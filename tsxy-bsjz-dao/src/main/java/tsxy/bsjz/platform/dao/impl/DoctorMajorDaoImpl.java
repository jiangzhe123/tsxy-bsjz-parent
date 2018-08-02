package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.DoctorMajorDao;
import tsxy.bsjz.platform.dao.mapper.DoctorMajorMapper;
import tsxy.bsjz.platform.dao.vo.DoctorMajorSearchDto;
import tsxy.bsjz.platform.model.DoctorMajor;
import tsxy.bsjz.platform.model.DoctorMajorExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/26--20:12
 */
@Repository
public class DoctorMajorDaoImpl implements DoctorMajorDao {

    @Autowired
    private DoctorMajorMapper doctorMajorMapper;
    @Override
    public void insertIntoDoctorMajor(DoctorMajor doctorMajor) throws Exception {
        doctorMajorMapper.insertSelective(doctorMajor);
    }

    @Override
    public void deleteDoctorMajorByIds(List<Integer> ids) throws Exception {
        DoctorMajorExample example = new DoctorMajorExample();
        DoctorMajorExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        doctorMajorMapper.deleteByExample(example);
    }

    @Override
    public void updateDoctorMajor(DoctorMajor doctorMajor) throws Exception {
        doctorMajorMapper.updateByPrimaryKeySelective(doctorMajor);
    }

    @Override
    public Integer selectCountByExample(DoctorMajorSearchDto doctorMajorSearchDto) throws Exception {
        DoctorMajorExample example = new DoctorMajorExample();
        DoctorMajorExample.Criteria criteria = example.createCriteria();
        if(doctorMajorSearchDto.getName() != null && !doctorMajorSearchDto.getName().equals("")){
            criteria.andNameLike("%"+doctorMajorSearchDto.getName()+"%");
        }
        return (int)doctorMajorMapper.countByExample(example);
    }

    @Override
    public List<DoctorMajor> selectAllDoctorMajor(DoctorMajorSearchDto doctorMajorSearchDto) throws Exception {
        DoctorMajorExample example = new DoctorMajorExample();
        DoctorMajorExample.Criteria criteria = example.createCriteria();
        if(doctorMajorSearchDto.getName() != null && !doctorMajorSearchDto.getName().equals("")){
            criteria.andNameLike("%"+doctorMajorSearchDto.getName()+"%");
        }
        return doctorMajorMapper.selectByExample(example);
    }

    @Override
    public List<DoctorMajor> selectAllDoctorMajorList() throws Exception {
        DoctorMajorExample example = new DoctorMajorExample();
        return doctorMajorMapper.selectByExample(example);
    }
}
