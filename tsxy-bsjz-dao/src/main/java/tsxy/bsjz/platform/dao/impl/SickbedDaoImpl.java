package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.SickbedDao;
import tsxy.bsjz.platform.dao.mapper.SickbedMapper;
import tsxy.bsjz.platform.dao.vo.SickbedCountDto;
import tsxy.bsjz.platform.dao.vo.SickbedSearchDto;
import tsxy.bsjz.platform.model.Sickbed;
import tsxy.bsjz.platform.model.SickbedExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/2--10:01
 */
@Repository
public class SickbedDaoImpl implements SickbedDao {
    @Autowired
    private SickbedMapper sickbedMapper;
    @Override
    public void insertIntoSickbed(Sickbed sickbed) throws Exception {
        sickbedMapper.insertSelective(sickbed);
    }

    @Override
    public void deleteSickbedByIds(List<Integer> ids) throws Exception {
        SickbedExample example = new SickbedExample();
        SickbedExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        sickbedMapper.deleteByExample(example);
    }

    @Override
    public void updateSickbed(Sickbed sickbed) throws Exception {
        sickbedMapper.updateByPrimaryKeySelective(sickbed);
    }

    @Override
    public void updatePatientNull(Integer id) throws Exception {
        sickbedMapper.updatePatientNull(id);
    }

    @Override
    public Integer selectCountByExample(SickbedSearchDto sickbedSearchDto) throws Exception {
        SickbedExample example = new SickbedExample();
        SickbedExample.Criteria criteria = example.createCriteria();
        if(sickbedSearchDto.getName() != null && !sickbedSearchDto.getName().equals("")){
            criteria.andNameLike("%"+sickbedSearchDto.getName()+"%");
        }
        criteria.andPatientIdIsNotNull();
        return (int)sickbedMapper.countByExample(example);
    }

    @Override
    public List<Sickbed> selectAllSickbed(SickbedSearchDto sickbedSearchDto) throws Exception {
        SickbedExample example = new SickbedExample();
        SickbedExample.Criteria criteria = example.createCriteria();
        if(sickbedSearchDto.getName() != null && !sickbedSearchDto.getName().equals("")){
            criteria.andNameLike("%"+sickbedSearchDto.getName()+"%");
        }
        criteria.andPatientIdIsNotNull();
        return sickbedMapper.selectByExample(example);
    }

    @Override
    public Integer selectCountNullByExample(SickbedSearchDto sickbedSearchDto) throws Exception {
        SickbedExample example = new SickbedExample();
        SickbedExample.Criteria criteria = example.createCriteria();
        if(sickbedSearchDto.getName() != null && !sickbedSearchDto.getName().equals("")){
            criteria.andNameLike("%"+sickbedSearchDto.getName()+"%");
        }
        criteria.andPatientIdIsNull();
        return (int)sickbedMapper.countByExample(example);
    }

    @Override
    public List<Sickbed> selectAllNullSickbed(SickbedSearchDto sickbedSearchDto) throws Exception {
        SickbedExample example = new SickbedExample();
        SickbedExample.Criteria criteria = example.createCriteria();
        if(sickbedSearchDto.getName() != null && !sickbedSearchDto.getName().equals("")){
            criteria.andNameLike("%"+sickbedSearchDto.getName()+"%");
        }
        criteria.andPatientIdIsNull();
        return sickbedMapper.selectByExample(example);
    }

    @Override
    public SickbedCountDto selectSickbedCountDto() throws Exception {
        return sickbedMapper.selectSickbedCountDto();
    }

    @Override
    public void updateDepartment2Null(List<Integer> ids) throws Exception {
        sickbedMapper.updateDepartment2Null(ids);
    }

    @Override
    public void updatePatient3Null(List<Integer> ids) throws Exception {
        sickbedMapper.updatePatient3Null(ids);
    }
}
