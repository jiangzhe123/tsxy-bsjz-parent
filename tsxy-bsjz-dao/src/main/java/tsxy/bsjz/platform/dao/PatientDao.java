package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.PatientSearchDto;
import tsxy.bsjz.platform.model.Patient;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--10:49
 */
public interface PatientDao {

    //增
    void insertIntoPatient(Patient patient) throws Exception;

    //删（批量删除）
    void deletePatientByIds(List<Integer> ids) throws Exception;

    //修改
    void updatePatient(Patient patient) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(PatientSearchDto patientSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Patient> selectAllPatient(PatientSearchDto patientSearchDto) throws Exception;

    //根据科室ID 查询 全部患者
    List<Patient> selectAllPatientByDepartId(Integer departmentId) throws Exception;

    //根据科室ID 查询 全部患者(未安排病床的)
    List<Patient> selectNotSickbedPatient(Integer departmentId) throws Exception;

    //当家庭联系人类型被删除的时候  清空已经和这些患者建立关系的 家庭联系人类型中字段
    void updateFamilyContactNull(List<Integer> ids) throws Exception;

    //当科室被删除的时候  清空已经和这些患者建立关系的 科室中字段
    void updateDepartmentNull(List<Integer> ids) throws Exception;

    //当私人医生被删除的时候  清空已经和这些患者建立关系的 私人医生中字段
    void updateDoctorNull(List<Integer> ids) throws Exception;
}
