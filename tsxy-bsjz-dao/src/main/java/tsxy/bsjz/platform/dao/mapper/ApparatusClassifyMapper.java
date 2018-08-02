package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.ApparatusClassify;
import tsxy.bsjz.platform.model.ApparatusClassifyExample;

public interface ApparatusClassifyMapper {
    long countByExample(ApparatusClassifyExample example);

    int deleteByExample(ApparatusClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApparatusClassify record);

    int insertSelective(ApparatusClassify record);

    List<ApparatusClassify> selectByExample(ApparatusClassifyExample example);

    ApparatusClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApparatusClassify record, @Param("example") ApparatusClassifyExample example);

    int updateByExample(@Param("record") ApparatusClassify record, @Param("example") ApparatusClassifyExample example);

    int updateByPrimaryKeySelective(ApparatusClassify record);

    int updateByPrimaryKey(ApparatusClassify record);
}