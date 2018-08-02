package tsxy.bsjz.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.FamilycontactDao;
import tsxy.bsjz.platform.dao.PatientDao;
import tsxy.bsjz.platform.model.Familycontact;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.service.FamilycontactService;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--11:38
 */
@Service
@Transactional
public class FamilycontactServiceImpl implements FamilycontactService {
    @Autowired
    private FamilycontactDao familycontactDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private PatientDao patientDao;
    @Override
    public void insertIntoFamilycontact(Familycontact familycontact) throws BusinessException {
        try {
            if(familycontact.getId() != null){
                familycontactDao.updateFamilycontact(familycontact);
            }else{
                familycontactDao.insertIntoFamilycontact(familycontact);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.FAMILY_ADD+familycontact.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加患者家庭联系人失败",e.getMessage());
        }
    }

    @Override
    public void deleteFamilycontactByIds(List<Integer> ids) throws BusinessException {
        try {
            familycontactDao.deleteFamilycontactByIds(ids);
            //当家庭联系人类型被删除的时候  清空已经和这些患者建立关系的 家庭联系人类型中字段
            patientDao.updateFamilyContactNull(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.FAMILY_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除患者家庭联系人失败",e.getMessage());
        }
    }

    @Override
    public void updateFamilycontact(Familycontact familycontact) throws BusinessException {
        try {
            familycontactDao.updateFamilycontact(familycontact);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.FAMILY_UPDATE+familycontact.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改患者家庭联系人失败",e.getMessage());
        }
    }

    @Override
    public List<Familycontact> selectAllFamilycontact() throws BusinessException {
        try {
            return familycontactDao.selectAllFamilycontact();
        }catch (Exception e){
            throw new BusinessException("查询全部患者家庭联系人失败",e.getMessage());
        }
    }
}
