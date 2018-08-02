package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.PatientFeedbackSearchDto;
import tsxy.bsjz.platform.model.PatientFeedback;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--10:49
 */
public interface PatientFeedbackDao {

    //删（批量删除）
    void deletePatientFeedbackByIds(List<Integer> ids) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(PatientFeedbackSearchDto patientFeedbackSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<PatientFeedback> selectAllPatientFeedback(PatientFeedbackSearchDto patientFeedbackSearchDto) throws Exception;

    //当患者被删除的时候  清空已经和这些患者建立关系的 患者反馈中字段
    void updatePatient2Null(List<Integer> ids) throws Exception;
}
