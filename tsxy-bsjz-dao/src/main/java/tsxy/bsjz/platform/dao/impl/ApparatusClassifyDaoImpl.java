package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.ApparatusClassifyDao;
import tsxy.bsjz.platform.dao.mapper.ApparatusClassifyMapper;
import tsxy.bsjz.platform.dao.vo.ApparatusClassifySearchDto;
import tsxy.bsjz.platform.model.ApparatusClassify;
import tsxy.bsjz.platform.model.ApparatusClassifyExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--9:49
 */
@Repository
public class ApparatusClassifyDaoImpl implements ApparatusClassifyDao {
    @Autowired
    private ApparatusClassifyMapper apparatusClassifyMapper;
    @Override
    public void insertIntoApparatusClassify(ApparatusClassify apparatusClassify) throws Exception {
        apparatusClassifyMapper.insertSelective(apparatusClassify);
    }

    @Override
    public void deleteApparatusClassifyByIds(List<Integer> ids) throws Exception {
        ApparatusClassifyExample example = new ApparatusClassifyExample();
        ApparatusClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        apparatusClassifyMapper.deleteByExample(example);
    }

    @Override
    public void updateApparatusClassify(ApparatusClassify apparatusClassify) throws Exception {
        apparatusClassifyMapper.updateByPrimaryKeySelective(apparatusClassify);
    }

    @Override
    public Integer selectCountByExample(ApparatusClassifySearchDto apparatusClassifySearchDto) throws Exception {
        ApparatusClassifyExample example = new ApparatusClassifyExample();
        ApparatusClassifyExample.Criteria criteria = example.createCriteria();
        if(apparatusClassifySearchDto.getName() != null && !apparatusClassifySearchDto.getName().equals("")){
            criteria.andNameLike("%"+apparatusClassifySearchDto.getName()+"%");
        }
        return (int)apparatusClassifyMapper.countByExample(example);
    }

    @Override
    public List<ApparatusClassify> selectAllApparatusClassify(ApparatusClassifySearchDto apparatusClassifySearchDto) throws Exception {
        ApparatusClassifyExample example = new ApparatusClassifyExample();
        ApparatusClassifyExample.Criteria criteria = example.createCriteria();
        if(apparatusClassifySearchDto.getName() != null && !apparatusClassifySearchDto.getName().equals("")){
            criteria.andNameLike("%"+apparatusClassifySearchDto.getName()+"%");
        }
        return apparatusClassifyMapper.selectByExample(example);
    }

    @Override
    public List<ApparatusClassify> selectAllApparatusClassifyList() throws Exception {
        ApparatusClassifyExample example = new ApparatusClassifyExample();
        return apparatusClassifyMapper.selectByExample(example);
    }
}
