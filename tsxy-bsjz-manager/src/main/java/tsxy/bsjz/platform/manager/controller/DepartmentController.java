package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.DepartmentSearchDto;
import tsxy.bsjz.platform.model.Department;
import tsxy.bsjz.platform.service.DepartmentService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/28--9:23  Department   科室
 */
@RestController
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //增加科室信息
    @RequestMapping("/insertIntoDepartment")
    public HashMap<String, Object> insertIntoDepartment(Department department) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        departmentService.insertIntoDepartment(department);
        return result;
    }

    //批量删除科室信息
    @RequestMapping("/deleteDepartmentByIds")
    public HashMap<String, Object> deleteDepartmentByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        departmentService.deleteDepartmentByIds(Arrays.asList(ids));
        return result;
    }

    //修改科室信息
    @RequestMapping("/updateDepartment")
    public HashMap<String, Object> updateDepartment(Department department) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        departmentService.updateDepartment(department);
        return result;
    }

    //分页查询全部科室信息
    @RequestMapping("/selectAllDepartment")
    public HashMap<String, Object> selectAllDepartment(DepartmentSearchDto departmentSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Department> pageData =  departmentService.selectAllDepartment(departmentSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Department> departmentList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("departmentList", departmentList);
        return result;
    }

}
