package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.MedicineSearchDto;
import tsxy.bsjz.platform.model.Medicine;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/30--10:05
 */
public interface MedicineDao {
    //增
    void insertIntoMedicine(Medicine medicine) throws Exception;

    //批量增加  导入Excel数据库 到药品表
    void insertIntoMedicineList(List<Medicine> medicineList) throws Exception;

    //删（批量删除）
    void deleteMedicineByIds(List<Integer> ids) throws Exception;

    //修改
    void updateMedicine(Medicine medicine) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(MedicineSearchDto medicineSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Medicine> selectAllMedicine(MedicineSearchDto medicineSearchDto) throws Exception;

    //查询---全部 库存低于预警库存的 药品
    List<Medicine> selectAllLessMedicine(MedicineSearchDto medicineSearchDto) throws Exception;

    //查询满足条件的数量
    Integer countByInventory(MedicineSearchDto medicineSearchDto) throws Exception;

    //查询---全部药品 导出EXCEL
    List<Medicine> selectAllMedicineToExcel() throws Exception;

    //当药品分类被删除的时候  清空已经和这些药品分类建立关系的 药品中字段
    void updateMedicineClassifyNull(List<Integer> ids) throws Exception;

    //当药品单位被删除的时候  清空已经和这些药品单位建立关系的 药品中字段
    void updateMedicineUnitNull(List<Integer> ids) throws Exception;

    //当厂家名称被删除的时候  清空已经和这些厂家名称建立关系的 药品中字段
    void updateMedicineFactoryNull(List<Integer> ids) throws Exception;
}
