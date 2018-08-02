package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.DoctorDao;
import tsxy.bsjz.platform.dao.mapper.DoctorMapper;
import tsxy.bsjz.platform.dao.vo.DoctorCountDto;
import tsxy.bsjz.platform.dao.vo.DoctorSearchDto;
import tsxy.bsjz.platform.model.Doctor;
import tsxy.bsjz.platform.model.DoctorExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/26--20:02
 */
@Repository
public class DoctorDaoImpl implements DoctorDao{
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public void insertIntoDoctor(Doctor doctor) throws Exception {
        doctorMapper.insertSelective(doctor);
    }

    @Override
    public void deleteDoctorByIds(List<Integer> ids) throws Exception {
        DoctorExample example = new DoctorExample();
        DoctorExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        doctorMapper.deleteByExample(example);
    }

    @Override
    public void updateDoctor(Doctor doctor) throws Exception {
        doctorMapper.updateByPrimaryKeySelective(doctor);
    }

    @Override
    public Integer selectCountByExample(DoctorSearchDto doctorSearchDto) throws Exception {
        DoctorExample example = new DoctorExample();
        DoctorExample.Criteria criteria = example.createCriteria();
        if(doctorSearchDto.getName() != null && !doctorSearchDto.getName().equals("")){
            criteria.andNameLike("%"+doctorSearchDto.getName()+"%");
        }
        return (int)doctorMapper.countByExample(example);
    }

    @Override
    public List<Doctor> selectAllDoctor(DoctorSearchDto doctorSearchDto) throws Exception {
        DoctorExample example = new DoctorExample();
        DoctorExample.Criteria criteria = example.createCriteria();
        if(doctorSearchDto.getName() != null && !doctorSearchDto.getName().equals("")){
            criteria.andNameLike("%"+doctorSearchDto.getName()+"%");
        }
        example.setOrderByClause(doctorSearchDto.getOrderByClause());
        return doctorMapper.selectByExample(example);
    }

    @Override
    public List<Doctor> selectDoctorByDepartmentId(Integer departmentId) throws Exception {
        return doctorMapper.selectDoctorByDepartmentId(departmentId);
    }

    @Override
    public List<DoctorCountDto> selectDoctorCountDto() throws Exception {
        return doctorMapper.selectDoctorCountDto();
    }

    @Override
    public void updateDepartmentNull(List<Integer> ids) throws Exception {
        doctorMapper.updateDepartmentNull(ids);
    }

    @Override
    public void updateQualificationNull(List<Integer> ids) throws Exception {
        doctorMapper.updateQualificationNull(ids);
    }

    @Override
    public void updateMajorNull(List<Integer> ids) throws Exception {
        doctorMapper.updateMajorNull(ids);
    }
}
