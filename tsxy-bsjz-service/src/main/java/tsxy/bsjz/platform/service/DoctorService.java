package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.DoctorCountDto;
import tsxy.bsjz.platform.dao.vo.DoctorSearchDto;
import tsxy.bsjz.platform.model.Doctor;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/27--9:07
 */
public interface DoctorService {

    //增
    void insertIntoDoctor(Doctor doctor) throws BusinessException;

    //删（批量删除）
    void deleteDoctorByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateDoctor(Doctor doctor) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<Doctor> selectAllDoctor(DoctorSearchDto doctorSearchDto) throws BusinessException;

    //根据科室ID查询  此科室下的全部医生的主键和名称
    List<Doctor> selectDoctorByDepartmentId(Integer departmentId) throws BusinessException;

    //查询视图医师职位下的医生的数量
    List<DoctorCountDto> selectDoctorCountDto() throws BusinessException;
}
