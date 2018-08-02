package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.Apparatus;
import tsxy.bsjz.platform.model.ApparatusExample;

public interface ApparatusMapper {
    long countByExample(ApparatusExample example);

    int deleteByExample(ApparatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Apparatus record);

    int insertSelective(Apparatus record);

    List<Apparatus> selectByExample(ApparatusExample example);

    Apparatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Apparatus record, @Param("example") ApparatusExample example);

    int updateByExample(@Param("record") Apparatus record, @Param("example") ApparatusExample example);

    int updateByPrimaryKeySelective(Apparatus record);

    int updateByPrimaryKey(Apparatus record);

    //当仪器分类被删除的时候  清空已经和这些分类建立关系的 仪器中字段
    void updateClassifyNull(List<Integer> ids);
}