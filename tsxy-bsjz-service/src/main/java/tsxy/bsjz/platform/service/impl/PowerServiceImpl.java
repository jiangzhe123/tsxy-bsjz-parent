package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.PowerDao;
import tsxy.bsjz.platform.dao.vo.PowerSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Power;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.PowerService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--14:27
 */
@Service
@Transactional
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerDao powerDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;

    @Override
    public void insertIntoPower(Power power) throws BusinessException {
        try {
            if(power.getId() != null){
                powerDao.updatePower(power);
            }else{
                powerDao.insertIntoPower(power);
                powerDao.insertIntoPowerRoute(power.getId(),1);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.POWER_ADD+power.getPowerName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("增加更新权限失败",e.getMessage());
        }
    }

    @Override
    public void deletePowerByIds(List<Integer> ids) throws BusinessException {
        try {
            List<Integer> judgeIds = powerDao.selectRoleIdWhenDelete(ids);
            //说明角色还有此权限所以不可以删除直接throw异常
            if(judgeIds.size() > 0){
                throw new BusinessException("角色还有此权限,删除权限失败");
            }
            powerDao.deletePowerByIds(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.POWER_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (BusinessException b){
            //捕获异常，通过AOP 传到前端
            throw new BusinessException(b.getErrorMessage());
        }catch (Exception e){
            throw new BusinessException("删除权限失败",e.getMessage());
        }
    }

    @Override
    public void updatePower(Power power) throws BusinessException {
        try {
            powerDao.updatePower(power);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.POWER_UPDATE+power.getPowerName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("更新权限失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Power> selectAllPower(PowerSearchDto powerSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(powerSearchDto.getPageNum(), powerSearchDto.getPageSize());
            List<Power> powerList = powerDao.selectAllPower(powerSearchDto);//集合
            Integer countNums = powerDao.selectCountByExample(powerSearchDto);//总数
            PageBean<Power> pageData = new PageBean<>(powerSearchDto.getPageNum(), powerSearchDto.getPageSize(), countNums);
            pageData.setItems(powerList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部权限失败",e.getMessage());
        }
    }

    @Override
    public List<Power> selectAllPower() throws BusinessException {
        try {
            return powerDao.selectAllPower();
        }catch (Exception e){
            throw new BusinessException("查询全部权限失败",e.getMessage());
        }
    }

    @Override
    public void updatePowerAndRoute(Integer powerId, Integer routeId) throws BusinessException {
        try {
            powerDao.updatePowerAndRoute(powerId,routeId);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.POWER_ALLOT);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改此权限对应的路由失败",e.getMessage());
        }
    }

    @Override
    public Integer selectRouteIdByPowerId(Integer powerId) throws BusinessException {
        try {
            return powerDao.selectRouteIdByPowerId(powerId);
        }catch (Exception e){
            throw new BusinessException("查询此权限下对应的那个路由ID主键失败",e.getMessage());
        }
    }
}
