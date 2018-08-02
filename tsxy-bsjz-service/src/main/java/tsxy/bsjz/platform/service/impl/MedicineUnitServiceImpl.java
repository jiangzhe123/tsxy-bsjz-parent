package tsxy.bsjz.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.MedicineDao;
import tsxy.bsjz.platform.dao.MedicineUnitDao;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.MedicineUnit;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.MedicineUnitService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--11:12
 */
@Service
@Transactional
public class MedicineUnitServiceImpl implements MedicineUnitService {
    @Autowired
    private MedicineUnitDao medicineUnitDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private MedicineDao medicineDao;
    @Override
    public void insertIntoUnit(MedicineUnit medicineUnit) throws BusinessException {
        try {
            if(medicineUnit.getId() != null){
                medicineUnitDao.updateUnit(medicineUnit);
            }else{
                medicineUnitDao.insertIntoUnit(medicineUnit);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.UNIT_ADD+medicineUnit.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加药品单位失败",e.getMessage());
        }
    }

    @Override
    public void deleteUnitByIds(List<Integer> ids) throws BusinessException {
        try {
            medicineUnitDao.deleteUnitByIds(ids);
            //当药品单位被删除的时候  清空已经和这些药品单位建立关系的 药品中字段
            medicineDao.updateMedicineUnitNull(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.UNIT_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除药品单位失败",e.getMessage());
        }
    }

    @Override
    public void updateUnit(MedicineUnit medicineUnit) throws BusinessException {
        try {
            medicineUnitDao.updateUnit(medicineUnit);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.UNIT_UPDATE+medicineUnit.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改药品单位失败",e.getMessage());
        }
    }

    @Override
    public List<MedicineUnit> selectAllUnit() throws BusinessException {
        try {
            return medicineUnitDao.selectAllUnit();
        }catch (Exception e){
            throw new BusinessException("查询全部药品单位失败",e.getMessage());
        }
    }
}
