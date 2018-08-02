package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.PatientSearchDto;
import tsxy.bsjz.platform.model.Patient;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--11:44
 */
public interface PatientService {

    //增
    void insertIntoPatient(Patient patient) throws BusinessException;

    //删（批量删除）
    void deletePatientByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updatePatient(Patient patient) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<Patient> selectAllPatient(PatientSearchDto patientSearchDto) throws BusinessException;

    //根据科室ID 查询 全部患者
    List<Patient> selectAllPatientByDepartId(Integer departmentId) throws BusinessException;

    //根据科室ID 查询 全部患者(未安排病床的)
    List<Patient> selectNotSickbedPatient(Integer departmentId) throws BusinessException;
}
