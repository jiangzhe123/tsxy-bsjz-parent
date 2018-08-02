package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.ApparatusDao;
import tsxy.bsjz.platform.dao.mapper.ApparatusMapper;
import tsxy.bsjz.platform.dao.vo.ApparatusSearchDto;
import tsxy.bsjz.platform.model.Apparatus;
import tsxy.bsjz.platform.model.ApparatusExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--9:28
 */
@Repository
public class ApparatusDaoImpl implements ApparatusDao {
    @Autowired
    private ApparatusMapper apparatusMapper;
    @Override
    public void insertIntoApparatus(Apparatus apparatus) throws Exception {
        apparatusMapper.insertSelective(apparatus);
    }

    @Override
    public void deleteApparatusByIds(List<Integer> ids) throws Exception {
        ApparatusExample example = new ApparatusExample();
        ApparatusExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        apparatusMapper.deleteByExample(example);
    }

    @Override
    public void updateApparatus(Apparatus apparatus) throws Exception {
        apparatusMapper.updateByPrimaryKeySelective(apparatus);
    }

    @Override
    public Integer selectCountByExample(ApparatusSearchDto apparatusSearchDto) throws Exception {
        ApparatusExample example = new ApparatusExample();
        ApparatusExample.Criteria criteria = example.createCriteria();
        if(apparatusSearchDto.getName() != null && !apparatusSearchDto.getName().equals("")){
            criteria.andNameLike("%"+apparatusSearchDto.getName()+"%");
        }
        return (int)apparatusMapper.countByExample(example);
    }

    @Override
    public List<Apparatus> selectAllApparatus(ApparatusSearchDto apparatusSearchDto) throws Exception {
        ApparatusExample example = new ApparatusExample();
        ApparatusExample.Criteria criteria = example.createCriteria();
        if(apparatusSearchDto.getName() != null && !apparatusSearchDto.getName().equals("")){
            criteria.andNameLike("%"+apparatusSearchDto.getName()+"%");
        }
        example.setOrderByClause(apparatusSearchDto.getOrderByClause());
        return apparatusMapper.selectByExample(example);
    }

    @Override
    public void updateClassifyNull(List<Integer> ids) throws Exception {
        apparatusMapper.updateClassifyNull(ids);
    }
}
