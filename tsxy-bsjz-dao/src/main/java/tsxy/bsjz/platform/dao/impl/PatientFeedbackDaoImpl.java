package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.PatientFeedbackDao;
import tsxy.bsjz.platform.dao.mapper.PatientFeedbackMapper;
import tsxy.bsjz.platform.dao.vo.PatientFeedbackSearchDto;
import tsxy.bsjz.platform.model.PatientFeedback;
import tsxy.bsjz.platform.model.PatientFeedbackExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--11:18
 */
@Repository
public class PatientFeedbackDaoImpl implements PatientFeedbackDao {
    @Autowired
    private PatientFeedbackMapper patientFeedbackMapper;
    @Override
    public void deletePatientFeedbackByIds(List<Integer> ids) throws Exception {
        PatientFeedbackExample example = new PatientFeedbackExample();
        PatientFeedbackExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        patientFeedbackMapper.deleteByExample(example);
    }

    @Override
    public Integer selectCountByExample(PatientFeedbackSearchDto patientFeedbackSearchDto) throws Exception {
        PatientFeedbackExample example = new PatientFeedbackExample();
        return (int)patientFeedbackMapper.countByExample(example);
    }

    @Override
    public List<PatientFeedback> selectAllPatientFeedback(PatientFeedbackSearchDto patientFeedbackSearchDto) throws Exception {
        PatientFeedbackExample example = new PatientFeedbackExample();
        example.setOrderByClause(patientFeedbackSearchDto.getOrderByClause());
        return patientFeedbackMapper.selectByExample(example);
    }

    @Override
    public void updatePatient2Null(List<Integer> ids) throws Exception {
        patientFeedbackMapper.updatePatient2Null(ids);
    }
}
