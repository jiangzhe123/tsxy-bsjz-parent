package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.MedicineUnit;
import tsxy.bsjz.platform.model.MedicineUnitExample;

public interface MedicineUnitMapper {
    long countByExample(MedicineUnitExample example);

    int deleteByExample(MedicineUnitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineUnit record);

    int insertSelective(MedicineUnit record);

    List<MedicineUnit> selectByExample(MedicineUnitExample example);

    MedicineUnit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MedicineUnit record, @Param("example") MedicineUnitExample example);

    int updateByExample(@Param("record") MedicineUnit record, @Param("example") MedicineUnitExample example);

    int updateByPrimaryKeySelective(MedicineUnit record);

    int updateByPrimaryKey(MedicineUnit record);
}