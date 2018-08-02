package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.FamilycontactDao;
import tsxy.bsjz.platform.dao.mapper.FamilycontactMapper;
import tsxy.bsjz.platform.model.Familycontact;
import tsxy.bsjz.platform.model.FamilycontactExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--10:54
 */
@Repository
public class FamilycontactDaoImpl implements FamilycontactDao {

    @Autowired
    private FamilycontactMapper familycontactMapper;
    @Override
    public void insertIntoFamilycontact(Familycontact familycontact) throws Exception {
        familycontactMapper.insertSelective(familycontact);
    }

    @Override
    public void deleteFamilycontactByIds(List<Integer> ids) throws Exception {
        FamilycontactExample example = new FamilycontactExample();
        FamilycontactExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        familycontactMapper.deleteByExample(example);
    }

    @Override
    public void updateFamilycontact(Familycontact familycontact) throws Exception {
        familycontactMapper.updateByPrimaryKeySelective(familycontact);
    }

    @Override
    public List<Familycontact> selectAllFamilycontact() throws Exception {
        FamilycontactExample example = new FamilycontactExample();
        return familycontactMapper.selectByExample(example);
    }
}
