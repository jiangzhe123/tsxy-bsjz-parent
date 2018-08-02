package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.PatientDao;
import tsxy.bsjz.platform.dao.mapper.PatientMapper;
import tsxy.bsjz.platform.dao.vo.PatientSearchDto;
import tsxy.bsjz.platform.model.Patient;
import tsxy.bsjz.platform.model.PatientExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--11:06
 */
@Repository
public class PatientDaoImpl implements PatientDao {
    @Autowired
    private PatientMapper patientMapper;
    @Override
    public void insertIntoPatient(Patient patient) throws Exception {
        patientMapper.insertSelective(patient);
    }

    @Override
    public void deletePatientByIds(List<Integer> ids) throws Exception {
        PatientExample example = new PatientExample();
        PatientExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        patientMapper.deleteByExample(example);
    }

    @Override
    public void updatePatient(Patient patient) throws Exception {
        patientMapper.updateByPrimaryKeySelective(patient);
    }

    @Override
    public Integer selectCountByExample(PatientSearchDto patientSearchDto) throws Exception {
        PatientExample example = new PatientExample();
        PatientExample.Criteria criteria = example.createCriteria();
        if(patientSearchDto.getName() != null && !patientSearchDto.getName().equals("")){
            criteria.andNameLike("%"+patientSearchDto.getName()+"%");
        }
        return (int)patientMapper.countByExample(example);
    }

    @Override
    public List<Patient> selectAllPatient(PatientSearchDto patientSearchDto) throws Exception {
        PatientExample example = new PatientExample();
        PatientExample.Criteria criteria = example.createCriteria();
        if(patientSearchDto.getName() != null && !patientSearchDto.getName().equals("")){
            criteria.andNameLike("%"+patientSearchDto.getName()+"%");
        }
        example.setOrderByClause(patientSearchDto.getOrderByClause());
        return patientMapper.selectByExample(example);
    }

    @Override
    public List<Patient> selectAllPatientByDepartId(Integer departmentId) throws Exception {
        PatientExample example = new PatientExample();
        PatientExample.Criteria criteria = example.createCriteria();
        criteria.andDepartmentIdEqualTo(departmentId);
        return patientMapper.selectByExample(example);
    }

    @Override
    public List<Patient> selectNotSickbedPatient(Integer departmentId) throws Exception {
        return patientMapper.selectNotSickbedPatient(departmentId);
    }

    @Override
    public void updateFamilyContactNull(List<Integer> ids) throws Exception {
        patientMapper.updateFamilyContactNull(ids);
    }

    @Override
    public void updateDepartmentNull(List<Integer> ids) throws Exception {
        patientMapper.updateDepartmentNull(ids);
    }

    @Override
    public void updateDoctorNull(List<Integer> ids) throws Exception {
        patientMapper.updateDoctorNull(ids);
    }
}
