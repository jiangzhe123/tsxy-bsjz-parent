package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.MedicineFactoryDao;
import tsxy.bsjz.platform.dao.mapper.MedicineFactoryMapper;
import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.MedicineFactory;
import tsxy.bsjz.platform.model.MedicineFactoryExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--10:43
 */
@Repository
public class MedicineFactoryDaoImpl implements MedicineFactoryDao {
    @Autowired
    private MedicineFactoryMapper medicineFactoryMapper;
    @Override
    public void insertIntoFactory(MedicineFactory medicineFactory) throws Exception {
        medicineFactoryMapper.insertSelective(medicineFactory);
    }

    @Override
    public void deleteFactoryByIds(List<Integer> ids) throws Exception {
        MedicineFactoryExample example = new MedicineFactoryExample();
        MedicineFactoryExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        medicineFactoryMapper.deleteByExample(example);
    }

    @Override
    public void updateFactory(MedicineFactory medicineFactory) throws Exception {
        medicineFactoryMapper.updateByPrimaryKeySelective(medicineFactory);
    }

    @Override
    public Integer selectCountByExample(MedicinePublicDto medicinePublicDto) throws Exception {
        MedicineFactoryExample example = new MedicineFactoryExample();
        MedicineFactoryExample.Criteria criteria = example.createCriteria();
        if(medicinePublicDto.getName() != null && !medicinePublicDto.getName().equals("")){
            criteria.andNameLike("%"+medicinePublicDto.getName()+"%");
        }
        return (int)medicineFactoryMapper.countByExample(example);
    }

    @Override
    public List<MedicineFactory> selectAllFactory(MedicinePublicDto medicinePublicDto) throws Exception {
        MedicineFactoryExample example = new MedicineFactoryExample();
        MedicineFactoryExample.Criteria criteria = example.createCriteria();
        if(medicinePublicDto.getName() != null && !medicinePublicDto.getName().equals("")){
            criteria.andNameLike("%"+medicinePublicDto.getName()+"%");
        }
        return medicineFactoryMapper.selectByExample(example);
    }

    @Override
    public List<MedicineFactory> selectAllFactoryList() throws Exception {
        MedicineFactoryExample example = new MedicineFactoryExample();
        return medicineFactoryMapper.selectByExample(example);
    }
}
