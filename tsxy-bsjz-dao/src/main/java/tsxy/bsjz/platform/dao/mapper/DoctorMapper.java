package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.dao.vo.DoctorCountDto;
import tsxy.bsjz.platform.model.Doctor;
import tsxy.bsjz.platform.model.DoctorExample;

public interface DoctorMapper {
    long countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

    //根据科室ID查询  此科室下的全部医生的主键和名称
    List<Doctor> selectDoctorByDepartmentId(Integer departmentId);

    //查询视图医师职位下的医生的数量
    List<DoctorCountDto> selectDoctorCountDto();

    //当科室被删除的时候  清空已经和这些医师建立关系的 科室中字段
    void updateDepartmentNull(List<Integer> ids);

    //当医师资格被删除的时候  清空已经和这些医师建立关系的 医师资格中字段
    void updateQualificationNull(List<Integer> ids);

    //当医师专业被删除的时候  清空已经和这些分类建立关系的 医师专业中字段
    void updateMajorNull(List<Integer> ids);
}