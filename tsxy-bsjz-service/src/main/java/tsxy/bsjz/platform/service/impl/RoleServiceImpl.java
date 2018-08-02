package tsxy.bsjz.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.RoleDao;
import tsxy.bsjz.platform.dao.vo.RoleSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Role;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.RoleService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--14:18
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;

    @Override
    public void insertIntoRole(Role role) throws BusinessException {
        try {
            if(role.getId() != null){
                roleDao.updateRole(role);
            }else{
                roleDao.insertIntoRole(role);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.ROLE_ADD+role.getRoleName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("增加更新角色失败",e.getMessage());
        }
    }

    @Override
    public void deleteRoleByIds(List<Integer> ids) throws BusinessException {
        try {
            //删除的时候，判断下 是否还有管理员是此角色 待加 dao层已经写好
            List<Integer> judgeIds = roleDao.selectManagerIdWhenDelete(ids);
            //说明有管理员还有此角色所以不可以删除直接throw异常
            if(judgeIds.size() > 0){
                throw new BusinessException("管理员还有此角色,删除角色失败");
            }
            roleDao.deleteRoleByIds(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.ROLE_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (BusinessException b){
            //捕获异常，通过AOP 传到前端
            throw new BusinessException(b.getErrorMessage());
        }catch (Exception e){
            throw new BusinessException("删除角色失败",e.getMessage());
        }
    }

    @Override
    public void updateRole(Role role) throws BusinessException {
        try {
            roleDao.updateRole(role);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.ROLE_UPDATE+role.getRoleName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("更新角色失败",e.getMessage());
        }
    }

    @Override
    public List<Role> selectAllRole(RoleSearchDto roleSearchDto) throws BusinessException {
        try {
            return roleDao.selectAllRole(roleSearchDto);
        }catch (Exception e){
            throw new BusinessException("查询全部角色失败",e.getMessage());
        }
    }

    @Override
    public List<Role> selectAllRole() throws BusinessException {
        try {
            return roleDao.selectAllRole();
        }catch (Exception e){
            throw new BusinessException("查询全部角色失败",e.getMessage());
        }
    }

    @Override
    public List<Integer> selectPowerIdsByRoleId(Integer roleId) throws BusinessException {
        try {
            return roleDao.selectPowerIdsByRoleId(roleId);
        }catch (Exception e){
            throw new BusinessException("查询此角色拥有的权限power们的Ids失败",e.getMessage());
        }
    }

    @Override
    public void insertIntoRoleAndPower(Integer roleId, List<Integer> powerIds) throws BusinessException {
        try {
            roleDao.deletePowerIdsByRoleId(roleId);
            roleDao.insertIntoRoleAndPower(roleId,powerIds);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.ROLE_ALLOT);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("根据角色ID 删除此角色拥有的权限们失败 + 建立增加 角色和权限关系 一对多失败",e.getMessage());
        }
    }
}
