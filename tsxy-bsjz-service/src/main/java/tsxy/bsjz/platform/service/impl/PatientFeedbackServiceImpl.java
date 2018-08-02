package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.PatientFeedbackDao;
import tsxy.bsjz.platform.dao.vo.PatientFeedbackSearchDto;
import tsxy.bsjz.platform.model.HandleRecord;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Patient;
import tsxy.bsjz.platform.model.PatientFeedback;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.PatientFeedbackService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--13:43
 */
@Service
@Transactional
public class PatientFeedbackServiceImpl implements PatientFeedbackService {
    @Autowired
    private PatientFeedbackDao patientFeedbackDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;
    @Override
    public void deletePatientFeedbackByIds(List<Integer> ids) throws BusinessException {
        try {
            patientFeedbackDao.deletePatientFeedbackByIds(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.FEEDBACK_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("批量删除患者反馈失败",e.getMessage());
        }
    }

    @Override
    public PageBean<PatientFeedback> selectAllPatientFeedback(PatientFeedbackSearchDto patientFeedbackSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(patientFeedbackSearchDto.getPageNum(), patientFeedbackSearchDto.getPageSize());
            List<PatientFeedback> patientFeedbackList = patientFeedbackDao.selectAllPatientFeedback(patientFeedbackSearchDto);//全部
            Integer countNums = patientFeedbackDao.selectCountByExample(patientFeedbackSearchDto);//总数
            PageBean<PatientFeedback> pageData = new PageBean<>(patientFeedbackSearchDto.getPageNum(), patientFeedbackSearchDto.getPageSize(), countNums);
            pageData.setItems(patientFeedbackList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询患者失败",e.getMessage());
        }
    }
}
