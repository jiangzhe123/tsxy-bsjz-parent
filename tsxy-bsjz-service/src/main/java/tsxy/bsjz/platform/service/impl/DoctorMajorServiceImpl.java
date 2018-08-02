package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.DoctorDao;
import tsxy.bsjz.platform.dao.DoctorMajorDao;
import tsxy.bsjz.platform.dao.vo.DoctorMajorSearchDto;
import tsxy.bsjz.platform.model.Department;
import tsxy.bsjz.platform.model.DoctorMajor;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.service.DoctorMajorService;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/27--20:41  医师专业
 */
@Service
@Transactional
public class DoctorMajorServiceImpl implements DoctorMajorService {

    @Autowired
    private DoctorMajorDao doctorMajorDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public void insertIntoDoctorMajor(DoctorMajor doctorMajor) throws BusinessException {
        try {
            if(doctorMajor.getId() != null){
                doctorMajorDao.updateDoctorMajor(doctorMajor);
            }else{
                doctorMajorDao.insertIntoDoctorMajor(doctorMajor);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.MAJOR_ADD+doctorMajor.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加医师专业失败",e.getMessage());
        }
    }

    @Override
    public void deleteDoctorMajorByIds(List<Integer> ids) throws BusinessException {
        try {
            doctorMajorDao.deleteDoctorMajorByIds(ids);
            //当医师专业被删除的时候  清空已经和这些分类建立关系的 医师专业中字段
            doctorDao.updateMajorNull(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.MAJOR_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除医师专业失败",e.getMessage());
        }
    }

    @Override
    public void updateDoctorMajor(DoctorMajor doctorMajor) throws BusinessException {
        try {
            doctorMajorDao.updateDoctorMajor(doctorMajor);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.MAJOR_UPDATE+doctorMajor.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改医师专业失败",e.getMessage());
        }
    }

    @Override
    public PageBean<DoctorMajor> selectAllDoctorMajor(DoctorMajorSearchDto doctorMajorSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(doctorMajorSearchDto.getPageNum(), doctorMajorSearchDto.getPageSize());
            List<DoctorMajor> doctorMajorList = doctorMajorDao.selectAllDoctorMajor(doctorMajorSearchDto);//集合
            Integer countNums = doctorMajorDao.selectCountByExample(doctorMajorSearchDto);//总数
            PageBean<DoctorMajor> pageData = new PageBean<>(doctorMajorSearchDto.getPageNum(), doctorMajorSearchDto.getPageSize(), countNums);
            pageData.setItems(doctorMajorList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部医师专业失败",e.getMessage());
        }
    }

    @Override
    public List<DoctorMajor> selectAllDoctorMajorList() throws BusinessException {
        try {
            return doctorMajorDao.selectAllDoctorMajorList();
        }catch (Exception e){
            throw new BusinessException("查询全部医师专业失败",e.getMessage());
        }
    }
}
