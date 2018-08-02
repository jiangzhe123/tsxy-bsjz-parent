package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.PatientFeedbackSearchDto;
import tsxy.bsjz.platform.model.PatientFeedback;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--13:42
 */
public interface PatientFeedbackService {

    //删（批量删除）
    void deletePatientFeedbackByIds(List<Integer> ids) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<PatientFeedback> selectAllPatientFeedback(PatientFeedbackSearchDto patientFeedbackSearchDto) throws BusinessException;
}
