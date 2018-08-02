package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.DoctorSearchDto;
import tsxy.bsjz.platform.model.Department;
import tsxy.bsjz.platform.model.Doctor;
import tsxy.bsjz.platform.model.DoctorMajor;
import tsxy.bsjz.platform.model.Qualification;
import tsxy.bsjz.platform.service.DepartmentService;
import tsxy.bsjz.platform.service.DoctorMajorService;
import tsxy.bsjz.platform.service.DoctorService;
import tsxy.bsjz.platform.service.QualificationService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/27--9:24
 */
@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DoctorMajorService doctorMajorService;
    @Autowired
    private QualificationService qualificationService;

    //增加医生信息
    @RequestMapping("/insertIntoDoctor")
    public HashMap<String, Object> insertIntoDoctor(Doctor doctor) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        doctorService.insertIntoDoctor(doctor);
        return result;
    }

    //批量删除医生信息
    @RequestMapping("/deleteDoctorByIds")
    public HashMap<String, Object> deleteDoctorByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        doctorService.deleteDoctorByIds(Arrays.asList(ids));
        return result;
    }

    //修改医生信息
    @RequestMapping("/updateDoctor")
    public HashMap<String, Object> updateDoctor(Doctor doctor) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        doctorService.updateDoctor(doctor);
        return result;
    }

    //查询全部医生信息
    @RequestMapping("/selectAllDoctor")
    public HashMap<String, Object> selectAllDoctor(DoctorSearchDto doctorSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Doctor> pageData = doctorService.selectAllDoctor(doctorSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Doctor> doctorList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("doctorList", doctorList);
        return result;
    }

    //查询科室+专业+医师资格 下拉选框集合信息
    @RequestMapping("/selectDoctorOtherCon")
    public HashMap<String, Object> selectDoctorOtherCon() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        //科室
        List<Department> departmentList = departmentService.selectAllDepartmentList();
        //医师专业
        List<DoctorMajor> doctorMajorList = doctorMajorService.selectAllDoctorMajorList();
        //医师资格
        List<Qualification> qualificationList = qualificationService.selectAllQualificationList();
        result.put("departmentList",departmentList);
        result.put("doctorMajorList",doctorMajorList);
        result.put("qualificationList",qualificationList);
        return result;
    }

}
