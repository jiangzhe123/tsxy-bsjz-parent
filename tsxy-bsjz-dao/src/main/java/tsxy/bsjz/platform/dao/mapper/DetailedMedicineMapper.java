package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.DetailedMedicine;
import tsxy.bsjz.platform.model.DetailedMedicineExample;

public interface DetailedMedicineMapper {
    long countByExample(DetailedMedicineExample example);

    int deleteByExample(DetailedMedicineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DetailedMedicine record);

    int insertSelective(DetailedMedicine record);

    List<DetailedMedicine> selectByExample(DetailedMedicineExample example);

    DetailedMedicine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DetailedMedicine record, @Param("example") DetailedMedicineExample example);

    int updateByExample(@Param("record") DetailedMedicine record, @Param("example") DetailedMedicineExample example);

    int updateByPrimaryKeySelective(DetailedMedicine record);

    int updateByPrimaryKey(DetailedMedicine record);

    List<DetailedMedicine> selectMedicineByDetailedId(Integer detailedId);

    //当药品被删除的时候  清空已经和这些药品建立关系的 清单列表--药品中字段
    void updateMedicineNull(List<Integer> ids);
}