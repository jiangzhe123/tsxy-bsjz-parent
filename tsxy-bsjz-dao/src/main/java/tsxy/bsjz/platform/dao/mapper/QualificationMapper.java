package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.Qualification;
import tsxy.bsjz.platform.model.QualificationExample;

public interface QualificationMapper {
    long countByExample(QualificationExample example);

    int deleteByExample(QualificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Qualification record);

    int insertSelective(Qualification record);

    List<Qualification> selectByExample(QualificationExample example);

    Qualification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Qualification record, @Param("example") QualificationExample example);

    int updateByExample(@Param("record") Qualification record, @Param("example") QualificationExample example);

    int updateByPrimaryKeySelective(Qualification record);

    int updateByPrimaryKey(Qualification record);
}