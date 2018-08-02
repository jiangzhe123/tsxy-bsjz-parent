package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.model.DetailedMedicine;
import tsxy.bsjz.platform.utils.BusinessException;

import java.util.List;

/**
 * Created by 姜哲 on 2018/4/1--14:51
 */
public interface DetailedMedicineService {
    //增
    void insertIntoDetailedMedicine(DetailedMedicine detailedMedicine) throws BusinessException;

    //删（批量删除）
    void deleteDetailedMedicineByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateDetailedMedicine(DetailedMedicine detailedMedicine) throws BusinessException;
}
