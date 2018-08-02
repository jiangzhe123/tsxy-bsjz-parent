package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.DepartCountDto;
import tsxy.bsjz.platform.dao.vo.DepartmentSearchDto;
import tsxy.bsjz.platform.model.Department;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/26--19:39  科室管理
 */
public interface DepartmentDao {

    //增
    void insertIntoDepartment(Department department) throws Exception;

    //删（批量删除）
    void deleteDepartmentByIds(List<Integer> ids) throws Exception;

    //修改
    void updateDepartment(Department department) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(DepartmentSearchDto departmentSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Department> selectAllDepartment(DepartmentSearchDto departmentSearchDto) throws Exception;

    //查询---全部
    List<Department> selectAllDepartmentList() throws Exception;

    //视图之统计 柱状图
    List<DepartCountDto> selectAllDepartCountDto() throws Exception;
}
