package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.DoctorDao;
import tsxy.bsjz.platform.dao.QualificationDao;
import tsxy.bsjz.platform.dao.vo.QualificationSearchDto;
import tsxy.bsjz.platform.model.DoctorMajor;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Qualification;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.QualificationService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/27--20:47
 */
@Service
@Transactional
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationDao qualificationDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public void insertIntoQualification(Qualification qualification) throws BusinessException {
        try {
            if(qualification.getId() != null){
                qualificationDao.updateQualification(qualification);
            }else{
                qualificationDao.insertIntoQualification(qualification);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.QUALIFICATION_ADD+qualification.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        }catch (Exception e){
            throw new BusinessException("添加医师资格失败",e.getMessage());
        }
    }

    @Override
    public void deleteQualificationByIds(List<Integer> ids) throws BusinessException {
        try {
            qualificationDao.deleteQualificationByIds(ids);
            //当医师资格被删除的时候  清空已经和这些医师建立关系的 医师资格中字段
            doctorDao.updateQualificationNull(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.QUALIFICATION_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除医师资格失败",e.getMessage());
        }
    }

    @Override
    public void updateQualification(Qualification qualification) throws BusinessException {
        try {
            qualificationDao.updateQualification(qualification);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.QUALIFICATION_UPDATE+qualification.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改医师资格失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Qualification> selectAllQualification(QualificationSearchDto qualificationSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(qualificationSearchDto.getPageNum(), qualificationSearchDto.getPageSize());
            List<Qualification> qualificationList = qualificationDao.selectAllQualification(qualificationSearchDto);//集合
            Integer countNums = qualificationDao.selectCountByExample(qualificationSearchDto);//总数
            PageBean<Qualification> pageData = new PageBean<>(qualificationSearchDto.getPageNum(), qualificationSearchDto.getPageSize(), countNums);
            pageData.setItems(qualificationList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部医师资格失败",e.getMessage());
        }
    }

    @Override
    public List<Qualification> selectAllQualificationList() throws BusinessException {
        try {
            return qualificationDao.selectAllQualificationList();
        }catch (Exception e){
            throw new BusinessException("查询全部医师资格失败",e.getMessage());
        }
    }
}
