package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.MedicineFactory;
import tsxy.bsjz.platform.model.MedicineFactoryExample;

public interface MedicineFactoryMapper {
    long countByExample(MedicineFactoryExample example);

    int deleteByExample(MedicineFactoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineFactory record);

    int insertSelective(MedicineFactory record);

    List<MedicineFactory> selectByExample(MedicineFactoryExample example);

    MedicineFactory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MedicineFactory record, @Param("example") MedicineFactoryExample example);

    int updateByExample(@Param("record") MedicineFactory record, @Param("example") MedicineFactoryExample example);

    int updateByPrimaryKeySelective(MedicineFactory record);

    int updateByPrimaryKey(MedicineFactory record);
}