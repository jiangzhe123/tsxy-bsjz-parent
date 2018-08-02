package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.MedicineClassifyDao;
import tsxy.bsjz.platform.dao.mapper.MedicineClassifyMapper;
import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.MedicineClassify;
import tsxy.bsjz.platform.model.MedicineClassifyExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--10:35
 */
@Repository
public class MedicineClassifyDaoImpl implements MedicineClassifyDao {
    @Autowired
    private MedicineClassifyMapper medicineClassifyMapper;
    @Override
    public void insertIntoClassify(MedicineClassify medicineClassify) throws Exception {
        medicineClassifyMapper.insertSelective(medicineClassify);
    }

    @Override
    public void deleteClassifyByIds(List<Integer> ids) throws Exception {
        MedicineClassifyExample example = new MedicineClassifyExample();
        MedicineClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        medicineClassifyMapper.deleteByExample(example);
    }

    @Override
    public void updateClassify(MedicineClassify medicineClassify) throws Exception {
        medicineClassifyMapper.updateByPrimaryKeySelective(medicineClassify);
    }

    @Override
    public Integer selectCountByExample(MedicinePublicDto medicinePublicDto) throws Exception {
        MedicineClassifyExample example = new MedicineClassifyExample();
        MedicineClassifyExample.Criteria criteria = example.createCriteria();
        if(medicinePublicDto.getName() != null && !medicinePublicDto.getName().equals("")){
            criteria.andNameLike("%"+medicinePublicDto.getName()+"%");
        }
        return (int)medicineClassifyMapper.countByExample(example);
    }

    @Override
    public List<MedicineClassify> selectAllClassify(MedicinePublicDto medicinePublicDto) throws Exception {
        MedicineClassifyExample example = new MedicineClassifyExample();
        MedicineClassifyExample.Criteria criteria = example.createCriteria();
        if(medicinePublicDto.getName() != null && !medicinePublicDto.getName().equals("")){
            criteria.andNameLike("%"+medicinePublicDto.getName()+"%");
        }
        return medicineClassifyMapper.selectByExample(example);
    }

    @Override
    public List<MedicineClassify> selectAllClassifyList() throws Exception {
        MedicineClassifyExample example = new MedicineClassifyExample();
        return medicineClassifyMapper.selectByExample(example);
    }
}
