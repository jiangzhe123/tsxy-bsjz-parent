package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.DoctorCountDto;
import tsxy.bsjz.platform.dao.vo.DoctorSearchDto;
import tsxy.bsjz.platform.model.Doctor;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/26--19:58
 */
public interface DoctorDao {
    //增
    void insertIntoDoctor(Doctor doctor) throws Exception;

    //删（批量删除）
    void deleteDoctorByIds(List<Integer> ids) throws Exception;

    //修改
    void updateDoctor(Doctor doctor) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(DoctorSearchDto doctorSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Doctor> selectAllDoctor(DoctorSearchDto doctorSearchDto) throws Exception;

    //根据科室ID查询  此科室下的全部医生的主键和名称
    List<Doctor> selectDoctorByDepartmentId(Integer departmentId) throws Exception;

    //查询视图医师职位下的医生的数量
    List<DoctorCountDto> selectDoctorCountDto() throws Exception;

    //当科室被删除的时候  清空已经和这些医师建立关系的 科室中字段
    void updateDepartmentNull(List<Integer> ids) throws Exception;

    //当医师资格被删除的时候  清空已经和这些医师建立关系的 医师资格中字段
    void updateQualificationNull(List<Integer> ids) throws Exception;

    //当医师专业被删除的时候  清空已经和这些分类建立关系的 医师专业中字段
    void updateMajorNull(List<Integer> ids) throws Exception;
}
