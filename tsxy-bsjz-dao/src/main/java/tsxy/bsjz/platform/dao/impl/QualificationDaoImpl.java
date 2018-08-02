package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.QualificationDao;
import tsxy.bsjz.platform.dao.mapper.QualificationMapper;
import tsxy.bsjz.platform.dao.vo.QualificationSearchDto;
import tsxy.bsjz.platform.model.Qualification;
import tsxy.bsjz.platform.model.QualificationExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/26--20:19
 */
@Repository
public class QualificationDaoImpl implements QualificationDao {
    @Autowired
    private QualificationMapper qualificationMapper;
    @Override
    public void insertIntoQualification(Qualification qualification) throws Exception {
        qualificationMapper.insertSelective(qualification);
    }

    @Override
    public void deleteQualificationByIds(List<Integer> ids) throws Exception {
        QualificationExample example = new QualificationExample();
        QualificationExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        qualificationMapper.deleteByExample(example);
    }

    @Override
    public void updateQualification(Qualification qualification) throws Exception {
        qualificationMapper.updateByPrimaryKeySelective(qualification);
    }

    @Override
    public Integer selectCountByExample(QualificationSearchDto qualificationSearchDto) throws Exception {
        QualificationExample example = new QualificationExample();
        QualificationExample.Criteria criteria = example.createCriteria();
        if(qualificationSearchDto.getName() != null && !qualificationSearchDto.getName().equals("")){
            criteria.andNameLike("%"+qualificationSearchDto.getName()+"%");
        }
        return (int)qualificationMapper.countByExample(example);
    }

    @Override
    public List<Qualification> selectAllQualification(QualificationSearchDto qualificationSearchDto) throws Exception {
        QualificationExample example = new QualificationExample();
        QualificationExample.Criteria criteria = example.createCriteria();
        if(qualificationSearchDto.getName() != null && !qualificationSearchDto.getName().equals("")){
            criteria.andNameLike("%"+qualificationSearchDto.getName()+"%");
        }
        return qualificationMapper.selectByExample(example);
    }

    @Override
    public List<Qualification> selectAllQualificationList() throws Exception {
        QualificationExample example = new QualificationExample();
        return qualificationMapper.selectByExample(example);
    }
}
