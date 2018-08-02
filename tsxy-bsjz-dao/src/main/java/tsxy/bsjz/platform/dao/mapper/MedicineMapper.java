package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.dao.vo.MedicineSearchDto;
import tsxy.bsjz.platform.model.Medicine;
import tsxy.bsjz.platform.model.MedicineExample;

public interface MedicineMapper {
    long countByExample(MedicineExample example);

    int deleteByExample(MedicineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    //批量增加  导入Excel数据库 到药品表
    void insertIntoMedicineList(@Param("medicineList") List<Medicine> medicineList);

    List<Medicine> selectByExample(MedicineExample example);

    Medicine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Medicine record, @Param("example") MedicineExample example);

    int updateByExample(@Param("record") Medicine record, @Param("example") MedicineExample example);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);

    //查询---全部 库存低于预警库存的 药品
    List<Medicine> selectAllLessMedicine(@Param("medicineSearchDto") MedicineSearchDto medicineSearchDto);

    //查询满足条件的数量
    Integer countByInventory(@Param("medicineSearchDto") MedicineSearchDto medicineSearchDto);

    //当药品分类被删除的时候  清空已经和这些药品分类建立关系的 药品中字段
    void updateMedicineClassifyNull(List<Integer> ids);

    //当药品单位被删除的时候  清空已经和这些药品单位建立关系的 药品中字段
    void updateMedicineUnitNull(List<Integer> ids);

    //当厂家名称被删除的时候  清空已经和这些厂家名称建立关系的 药品中字段
    void updateMedicineFactoryNull(List<Integer> ids);
}