package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.MedicineUnitDao;
import tsxy.bsjz.platform.dao.mapper.MedicineUnitMapper;
import tsxy.bsjz.platform.model.MedicineUnit;
import tsxy.bsjz.platform.model.MedicineUnitExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--10:51
 */
@Repository
public class MedicineUnitDaoImpl implements MedicineUnitDao {
    @Autowired
    private MedicineUnitMapper medicineUnitMapper;
    @Override
    public void insertIntoUnit(MedicineUnit medicineUnit) throws Exception {
        medicineUnitMapper.insertSelective(medicineUnit);
    }

    @Override
    public void deleteUnitByIds(List<Integer> ids) throws Exception {
        MedicineUnitExample example = new MedicineUnitExample();
        MedicineUnitExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        medicineUnitMapper.deleteByExample(example);
    }

    @Override
    public void updateUnit(MedicineUnit medicineUnit) throws Exception {
        medicineUnitMapper.updateByPrimaryKeySelective(medicineUnit);
    }

    @Override
    public List<MedicineUnit> selectAllUnit() throws Exception {
        MedicineUnitExample example = new MedicineUnitExample();
        return medicineUnitMapper.selectByExample(example);
    }
}
