package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.MedicineDao;
import tsxy.bsjz.platform.dao.mapper.MedicineMapper;
import tsxy.bsjz.platform.dao.vo.MedicineSearchDto;
import tsxy.bsjz.platform.model.Medicine;
import tsxy.bsjz.platform.model.MedicineExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--10:19
 */
@Repository
public class MedicineDaoImpl implements MedicineDao {
    @Autowired
    private MedicineMapper medicineMapper;
    @Override
    public void insertIntoMedicine(Medicine medicine) throws Exception {
        medicineMapper.insertSelective(medicine);
    }

    @Override
    public void insertIntoMedicineList(List<Medicine> medicineList) throws Exception {
        medicineMapper.insertIntoMedicineList(medicineList);
    }

    @Override
    public void deleteMedicineByIds(List<Integer> ids) throws Exception {
        MedicineExample example = new MedicineExample();
        MedicineExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        medicineMapper.deleteByExample(example);
    }

    @Override
    public void updateMedicine(Medicine medicine) throws Exception {
        medicineMapper.updateByPrimaryKeySelective(medicine);
    }

    @Override
    public Integer selectCountByExample(MedicineSearchDto medicineSearchDto) throws Exception {
        MedicineExample example = new MedicineExample();
        MedicineExample.Criteria criteria = example.createCriteria();
        if(medicineSearchDto.getName() != null && !medicineSearchDto.getName().equals("")){
            criteria.andNameLike("%"+medicineSearchDto.getName()+"%");
        }
        return (int)medicineMapper.countByExample(example);
    }

    @Override
    public List<Medicine> selectAllMedicine(MedicineSearchDto medicineSearchDto) throws Exception {
        MedicineExample example = new MedicineExample();
        MedicineExample.Criteria criteria = example.createCriteria();
        if(medicineSearchDto.getName() != null && !medicineSearchDto.getName().equals("")){
            criteria.andNameLike("%"+medicineSearchDto.getName()+"%");
        }
        return medicineMapper.selectByExample(example);
    }

    @Override
    public List<Medicine> selectAllLessMedicine(MedicineSearchDto medicineSearchDto) throws Exception {
        return medicineMapper.selectAllLessMedicine(medicineSearchDto);
    }

    @Override
    public Integer countByInventory(MedicineSearchDto medicineSearchDto) throws Exception {
        return medicineMapper.countByInventory(medicineSearchDto);
    }

    @Override
    public List<Medicine> selectAllMedicineToExcel() throws Exception {
        MedicineExample example = new MedicineExample();
        return medicineMapper.selectByExample(example);
    }

    @Override
    public void updateMedicineClassifyNull(List<Integer> ids) throws Exception {
        medicineMapper.updateMedicineClassifyNull(ids);
    }

    @Override
    public void updateMedicineUnitNull(List<Integer> ids) throws Exception {
        medicineMapper.updateMedicineUnitNull(ids);
    }

    @Override
    public void updateMedicineFactoryNull(List<Integer> ids) throws Exception {
        medicineMapper.updateMedicineFactoryNull(ids);
    }
}
