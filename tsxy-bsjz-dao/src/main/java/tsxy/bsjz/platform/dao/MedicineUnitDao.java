package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.model.MedicineUnit;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--10:06 MedicineUnit medicineUnit
 */
public interface MedicineUnitDao {

    //增
    void insertIntoUnit(MedicineUnit medicineUnit) throws Exception;

    //删（批量删除）
    void deleteUnitByIds(List<Integer> ids) throws Exception;

    //修改
    void updateUnit(MedicineUnit medicineUnit) throws Exception;

    //查询---全部
    List<MedicineUnit> selectAllUnit() throws Exception;
}
