package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.ManagerDao;
import tsxy.bsjz.platform.dao.vo.ManagerLoginDto;
import tsxy.bsjz.platform.dao.vo.ManagerSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;
import tsxy.bsjz.platform.utils.StringUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--13:44
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private HandleRecordService handleRecordService;

    @Override
    public void insertIntoManager(Manager manager) throws BusinessException {
        try {
            if(manager.getId() != null){
                //说明用户已经存在了
                managerDao.updateManager(manager);
            }else{
                manager.setCreateDate(new Date());
                manager.setPassword(StringUtil.MD5(manager.getPassword()));
                managerDao.insertIntoManager(manager);
                //当增加管理员的时候，默认往管理员-角色表增加一条数据 分配新增加的管理员默认为游客角色
                managerDao.insertIntoManagerRole(manager.getId(),4);
                //增加操作记录
                Manager currentManager = this.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.MANAGER_ADD+manager.getRealName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加管理员失败",e.getMessage());
        }
    }

    @Override
    public void deleteManagerByIds(List<Integer> ids) throws BusinessException {
        try {
            managerDao.deleteManagerByIds(ids);
            //删除此管理员时候会把  此管理员建立过的角色 同时删除
            managerDao.deleteRoleIdByManagerIds(ids);
            //增加操作记录
            Manager currentManager = this.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.MANAGER_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("删除管理员失败",e.getMessage());
        }
    }

    @Override
    public void updateManager(Manager manager) throws BusinessException {
        try {
            manager.setPassword(StringUtil.MD5(manager.getPassword()));
            managerDao.updateManager(manager);

            //增加操作记录
            Manager currentManager = this.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.MANAGER_UPDATE+manager.getRealName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("更新管理员失败",e.getMessage());
        }
    }

    @Override
    public Manager selectManagerByUserName(String userName) throws BusinessException {
        try {
            return managerDao.selectManagerByUserName(userName);
        }catch (Exception e){
            throw new BusinessException("查询管理员通过用户名失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Manager> selectAllManager(ManagerSearchDto managerSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(managerSearchDto.getPageNum(), managerSearchDto.getPageSize());
            List<Manager> managerList = managerDao.selectAllManager(managerSearchDto);//科室集合
            Integer countNums = managerDao.selectCountByExample(managerSearchDto);//总数
            PageBean<Manager> pageData = new PageBean<>(managerSearchDto.getPageNum(), managerSearchDto.getPageSize(), countNums);
            pageData.setItems(managerList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部管理员失败",e.getMessage());
        }
    }

    @Override
    public void loginManager(ManagerLoginDto managerLoginDto) throws BusinessException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(managerLoginDto.getUserName(),StringUtil.MD5(managerLoginDto.getPassword()));
        try {
            subject.login(token);//这一步开始登陆,并跳转到ManagerRealm类doGetAuthenticationInfo方法中
            Manager currentManager = managerDao.selectManagerByUserName(managerLoginDto.getUserName());
            //修改管理员最后一次登录时间
            currentManager.setLastLoginDate(new Date());
            managerDao.updateManager(currentManager);
            Session shiroSession = subject.getSession();
            shiroSession.setAttribute("loginManager", currentManager);
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            throw new BusinessException("密码错误");
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            throw new BusinessException("帐号不存在");
        } catch(AuthenticationException ae){
            //账号或密码错误
            throw new BusinessException("账号或密码错误");
        } catch (Exception e) {
            throw new BusinessException("查询管理员失败");
        }
    }

    @Override
    public Manager selectCurrentManager() throws BusinessException {
        //通过SecurityUtils工具类得到shiro的subject
        Subject subject = SecurityUtils.getSubject();
        //通过subject得到shiro的session
        Session session = subject.getSession();
        Manager manager = (Manager) session.getAttribute("loginManager");
        return manager;
    }

    @Override
    public void loginOutManager() throws BusinessException {
        //通过SecurityUtils工具类得到shiro的subject
        Subject subject = SecurityUtils.getSubject();
        /**
         * session.invalidate();是把session内的所有属性 都清除，
         session.removeAttribute("loginManager")；是清除session中的 "loginManager" 属性，就是清除一个特定的属性
         **/
        subject.logout();
    }

    @Override
    public Integer selectRoleIdByManagerId(Integer managerId) throws BusinessException {
        try {
            return managerDao.selectRoleIdByManagerId(managerId);
        }catch (Exception e){
            throw new BusinessException("查询此管理员角色ID失败",e.getMessage());
        }
    }

    @Override
    public void updateManagerRoleByRoleId(Integer managerId, Integer roleId) throws BusinessException {
        try {
            managerDao.updateManagerRoleByRoleId(managerId,roleId);
            //增加操作记录
            Manager currentManager = this.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.MANAGER_ALLOT);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("更改此管理员的角色失败",e.getMessage());
        }
    }
}
