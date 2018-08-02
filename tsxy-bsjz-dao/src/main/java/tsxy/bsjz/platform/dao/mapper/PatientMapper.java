package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.Patient;
import tsxy.bsjz.platform.model.PatientExample;

public interface PatientMapper {
    long countByExample(PatientExample example);

    int deleteByExample(PatientExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Patient record);

    int insertSelective(Patient record);

    List<Patient> selectByExample(PatientExample example);

    Patient selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);

    //根据科室ID 查询 全部患者(未安排病床的)
    List<Patient> selectNotSickbedPatient(Integer departmentId);

    //当家庭联系人类型被删除的时候  清空已经和这些患者建立关系的 家庭联系人类型中字段
    void updateFamilyContactNull(List<Integer> ids);

    //当科室被删除的时候  清空已经和这些患者建立关系的 科室中字段
    void updateDepartmentNull(List<Integer> ids);

    //当私人医生被删除的时候  清空已经和这些患者建立关系的 私人医生中字段
    void updateDoctorNull(List<Integer> ids);
}