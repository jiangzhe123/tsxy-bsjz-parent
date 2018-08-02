package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.DetailedListDao;
import tsxy.bsjz.platform.dao.PatientDao;
import tsxy.bsjz.platform.dao.PatientFeedbackDao;
import tsxy.bsjz.platform.dao.SickbedDao;
import tsxy.bsjz.platform.dao.vo.PatientSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Patient;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.PatientService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--11:45
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private PatientFeedbackDao patientFeedbackDao;
    @Autowired
    private SickbedDao sickbedDao;
    @Autowired
    private DetailedListDao detailedListDao;
    @Override
    public void insertIntoPatient(Patient patient) throws BusinessException {
        try {
            if(patient.getId() != null){
                patientDao.updatePatient(patient);
            }else{
                patient.setCreateDate(new Date());
                patientDao.insertIntoPatient(patient);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.PATIENT_ADD+patient.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加患者失败",e.getMessage());
        }
    }

    @Override
    public void deletePatientByIds(List<Integer> ids) throws BusinessException {
        try {
            patientDao.deletePatientByIds(ids);
            //当患者被删除的时候  清空已经和这些患者建立关系的 患者反馈中字段
            patientFeedbackDao.updatePatient2Null(ids);
            //当患者被删除的时候  清空已经和这些患者建立关系的 病床中字段
            sickbedDao.updatePatient3Null(ids);
            //当患者被删除的时候  清空已经和这些患者建立关系的 清单列表中字段
            detailedListDao.updatePatient4Null(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.PATIENT_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除患者失败",e.getMessage());
        }
    }

    @Override
    public void updatePatient(Patient patient) throws BusinessException {
        try {
            patientDao.updatePatient(patient);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.PATIENT_UPDATE+patient.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改患者失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Patient> selectAllPatient(PatientSearchDto patientSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(patientSearchDto.getPageNum(), patientSearchDto.getPageSize());
            List<Patient> patientList = patientDao.selectAllPatient(patientSearchDto);//全部医生
            Integer countNums = patientDao.selectCountByExample(patientSearchDto);//总数
            PageBean<Patient> pageData = new PageBean<>(patientSearchDto.getPageNum(), patientSearchDto.getPageSize(), countNums);
            pageData.setItems(patientList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询患者失败",e.getMessage());
        }
    }

    @Override
    public List<Patient> selectAllPatientByDepartId(Integer departmentId) throws BusinessException {
        try {
            return patientDao.selectAllPatientByDepartId(departmentId);
        }catch (Exception e){
            throw new BusinessException("根据科室ID查询全部患者失败",e.getMessage());
        }
    }

    @Override
    public List<Patient> selectNotSickbedPatient(Integer departmentId) throws BusinessException {
        try {
            return patientDao.selectNotSickbedPatient(departmentId);
        }catch (Exception e){
            throw new BusinessException("根据科室ID查询全部患者(未安排病床的)失败",e.getMessage());
        }
    }
}
