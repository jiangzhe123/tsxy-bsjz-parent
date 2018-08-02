package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.DetailedListDao;
import tsxy.bsjz.platform.dao.mapper.DetailedListMapper;
import tsxy.bsjz.platform.dao.vo.DetailedCountDto;
import tsxy.bsjz.platform.dao.vo.DetailedListSearchDto;
import tsxy.bsjz.platform.model.DetailedList;
import tsxy.bsjz.platform.model.DetailedListExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/31--23:25
 */
@Repository
public class DetailedListDaoImpl implements DetailedListDao {
    @Autowired
    private DetailedListMapper detailedListMapper;
    @Override
    public void insertIntoDetailedList(DetailedList detailedList) throws Exception {
        detailedListMapper.insertSelective(detailedList);
    }

    @Override
    public void deleteDetailedListByIds(List<Integer> ids) throws Exception {
        DetailedListExample example = new DetailedListExample();
        DetailedListExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        detailedListMapper.deleteByExample(example);
    }

    @Override
    public void updateDetailedList(DetailedList detailedList) throws Exception {
        detailedListMapper.updateByPrimaryKeySelective(detailedList);
    }

    @Override
    public Integer selectCountByExample(DetailedListSearchDto detailedListSearchDto) throws Exception {
        return detailedListMapper.selectCountByExample(detailedListSearchDto);
    }

    @Override
    public List<DetailedList> selectAllDetailedList(DetailedListSearchDto detailedListSearchDto) throws Exception {
        return detailedListMapper.selectAllDetailedList(detailedListSearchDto);
    }

    @Override
    public DetailedCountDto selectDetailedCountDto() throws Exception {
        return detailedListMapper.selectDetailedCountDto();
    }

    @Override
    public void updatePatient4Null(List<Integer> ids) throws Exception {
        detailedListMapper.updatePatient4Null(ids);
    }
}
