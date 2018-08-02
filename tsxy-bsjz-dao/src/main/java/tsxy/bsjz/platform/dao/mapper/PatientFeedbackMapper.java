package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.PatientFeedback;
import tsxy.bsjz.platform.model.PatientFeedbackExample;

public interface PatientFeedbackMapper {
    long countByExample(PatientFeedbackExample example);

    int deleteByExample(PatientFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PatientFeedback record);

    int insertSelective(PatientFeedback record);

    List<PatientFeedback> selectByExample(PatientFeedbackExample example);

    PatientFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PatientFeedback record, @Param("example") PatientFeedbackExample example);

    int updateByExample(@Param("record") PatientFeedback record, @Param("example") PatientFeedbackExample example);

    int updateByPrimaryKeySelective(PatientFeedback record);

    int updateByPrimaryKey(PatientFeedback record);

    //当患者被删除的时候  清空已经和这些患者建立关系的 患者反馈中字段
    void updatePatient2Null(List<Integer> ids);
}