package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.MedicineSearchDto;
import tsxy.bsjz.platform.model.Medicine;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--11:02
 */
public interface MedicineService {

    //增
    void insertIntoMedicine(Medicine medicine) throws BusinessException;

    //批量增加  导入Excel数据库 到药品表
    void insertIntoMedicineList(List<Medicine> medicineList) throws BusinessException;

    //删（批量删除）
    void deleteMedicineByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateMedicine(Medicine medicine) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<Medicine> selectAllMedicine(MedicineSearchDto medicineSearchDto) throws BusinessException;

    //查询---全部 库存低于预警库存的 药品
    PageBean<Medicine> selectAllLessMedicine(MedicineSearchDto medicineSearchDto) throws BusinessException;

    //查询---全部药品 导出EXCEL
    List<Medicine> selectAllMedicineToExcel() throws BusinessException;
}
