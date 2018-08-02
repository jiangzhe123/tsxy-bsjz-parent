package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.DoctorMajor;
import tsxy.bsjz.platform.model.DoctorMajorExample;

public interface DoctorMajorMapper {
    long countByExample(DoctorMajorExample example);

    int deleteByExample(DoctorMajorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DoctorMajor record);

    int insertSelective(DoctorMajor record);

    List<DoctorMajor> selectByExample(DoctorMajorExample example);

    DoctorMajor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DoctorMajor record, @Param("example") DoctorMajorExample example);

    int updateByExample(@Param("record") DoctorMajor record, @Param("example") DoctorMajorExample example);

    int updateByPrimaryKeySelective(DoctorMajor record);

    int updateByPrimaryKey(DoctorMajor record);
}