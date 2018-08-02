package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.model.MedicineUnit;
import tsxy.bsjz.platform.utils.BusinessException;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--11:02
 */
public interface MedicineUnitService {
    //增
    void insertIntoUnit(MedicineUnit medicineUnit) throws BusinessException;

    //删（批量删除）
    void deleteUnitByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateUnit(MedicineUnit medicineUnit) throws BusinessException;

    //查询---全部
    List<MedicineUnit> selectAllUnit() throws BusinessException;
}
