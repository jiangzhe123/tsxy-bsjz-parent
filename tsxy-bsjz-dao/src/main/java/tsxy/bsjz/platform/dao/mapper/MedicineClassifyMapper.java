package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.MedicineClassify;
import tsxy.bsjz.platform.model.MedicineClassifyExample;

public interface MedicineClassifyMapper {
    long countByExample(MedicineClassifyExample example);

    int deleteByExample(MedicineClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineClassify record);

    int insertSelective(MedicineClassify record);

    List<MedicineClassify> selectByExample(MedicineClassifyExample example);

    MedicineClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MedicineClassify record, @Param("example") MedicineClassifyExample example);

    int updateByExample(@Param("record") MedicineClassify record, @Param("example") MedicineClassifyExample example);

    int updateByPrimaryKeySelective(MedicineClassify record);

    int updateByPrimaryKey(MedicineClassify record);
}