package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.DepartCountDto;
import tsxy.bsjz.platform.dao.vo.DepartmentSearchDto;
import tsxy.bsjz.platform.model.Department;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/3/27--20:33
 */
public interface DepartmentService {
    //增
    void insertIntoDepartment(Department department) throws BusinessException;

    //删（批量删除）
    void deleteDepartmentByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateDepartment(Department department) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<Department> selectAllDepartment(DepartmentSearchDto departmentSearchDto) throws BusinessException;

    //查询---全部
    List<Department> selectAllDepartmentList() throws BusinessException;

    //视图之统计 柱状图
    List<DepartCountDto> selectAllDepartCountDto() throws BusinessException;
}
