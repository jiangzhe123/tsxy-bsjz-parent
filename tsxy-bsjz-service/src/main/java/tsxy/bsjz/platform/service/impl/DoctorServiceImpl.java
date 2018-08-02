package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.DoctorDao;
import tsxy.bsjz.platform.dao.PatientDao;
import tsxy.bsjz.platform.dao.vo.DoctorCountDto;
import tsxy.bsjz.platform.dao.vo.DoctorSearchDto;
import tsxy.bsjz.platform.model.Doctor;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.service.DoctorService;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/27--9:08
 */
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private PatientDao patientDao;

    @Override
    public void insertIntoDoctor(Doctor doctor) throws BusinessException {
        try {
            if(doctor.getId() != null){
                doctorDao.updateDoctor(doctor);
            }else{
                doctor.setCreateDate(new Date());
                doctorDao.insertIntoDoctor(doctor);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.DOCTOR_ADD+doctor.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加医生失败",e.getMessage());
        }
    }

    @Override
    public void deleteDoctorByIds(List<Integer> ids) throws BusinessException {
        try {
            doctorDao.deleteDoctorByIds(ids);
            //当私人医生被删除的时候  清空已经和这些患者建立关系的 私人医生中字段
            patientDao.updateDoctorNull(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.DOCTOR_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除医生失败",e.getMessage());
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) throws BusinessException {
        try {
            doctorDao.updateDoctor(doctor);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.DOCTOR_UPDATE+doctor.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改医生失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Doctor> selectAllDoctor(DoctorSearchDto doctorSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(doctorSearchDto.getPageNum(), doctorSearchDto.getPageSize());
            List<Doctor> doctorList = doctorDao.selectAllDoctor(doctorSearchDto);//全部医生
            Integer countNums = doctorDao.selectCountByExample(doctorSearchDto);//总数
            PageBean<Doctor> pageData = new PageBean<>(doctorSearchDto.getPageNum(), doctorSearchDto.getPageSize(), countNums);
            pageData.setItems(doctorList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询医生失败",e.getMessage());
        }

    }

    @Override
    public List<Doctor> selectDoctorByDepartmentId(Integer departmentId) throws BusinessException {
        try {
            return doctorDao.selectDoctorByDepartmentId(departmentId);
        }catch (Exception e){
            throw new BusinessException("根据科室ID查询此科室下的全部医生失败",e.getMessage());
        }
    }

    @Override
    public List<DoctorCountDto> selectDoctorCountDto() throws BusinessException {
        try {
            return doctorDao.selectDoctorCountDto();
        }catch (Exception e){
            throw new BusinessException("查询视图医师职位下的医生的数量失败",e.getMessage());
        }
    }
}
