package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.DetailedMedicineDao;
import tsxy.bsjz.platform.dao.mapper.DetailedMedicineMapper;
import tsxy.bsjz.platform.model.DetailedMedicine;
import tsxy.bsjz.platform.model.DetailedMedicineExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/31--23:55
 */
@Repository
public class DetailedMedicineDaoImpl implements DetailedMedicineDao {
    @Autowired
    private DetailedMedicineMapper detailedMedicineMapper;
    @Override
    public void insertIntoDetailedMedicine(DetailedMedicine detailedMedicine) throws Exception {
        detailedMedicineMapper.insertSelective(detailedMedicine);
    }

    @Override
    public void deleteDetailedMedicineByIds(List<Integer> ids) throws Exception {
        DetailedMedicineExample example = new DetailedMedicineExample();
        DetailedMedicineExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        detailedMedicineMapper.deleteByExample(example);
    }

    @Override
    public void deleteMedicineByDetailedIds(List<Integer> detailedIds) throws Exception {
        DetailedMedicineExample example = new DetailedMedicineExample();
        DetailedMedicineExample.Criteria criteria = example.createCriteria();
        criteria.andDetailedIdIn(detailedIds);
        detailedMedicineMapper.deleteByExample(example);
    }

    @Override
    public void updateDetailedMedicine(DetailedMedicine detailedMedicine) throws Exception {
        detailedMedicineMapper.updateByPrimaryKeySelective(detailedMedicine);
    }

    @Override
    public List<DetailedMedicine> selectAllDetailedMedicine(Integer detailedId) throws Exception {
        DetailedMedicineExample example = new DetailedMedicineExample();
        DetailedMedicineExample.Criteria criteria = example.createCriteria();
        criteria.andDetailedIdEqualTo(detailedId);
        return detailedMedicineMapper.selectByExample(example);
    }

    @Override
    public void updateMedicineNull(List<Integer> ids) throws Exception {
        detailedMedicineMapper.updateMedicineNull(ids);
    }
}
