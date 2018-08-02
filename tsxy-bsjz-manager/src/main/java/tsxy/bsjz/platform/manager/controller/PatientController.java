package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.PatientSearchDto;
import tsxy.bsjz.platform.model.Department;
import tsxy.bsjz.platform.model.Doctor;
import tsxy.bsjz.platform.model.Familycontact;
import tsxy.bsjz.platform.model.Patient;
import tsxy.bsjz.platform.service.DepartmentService;
import tsxy.bsjz.platform.service.DoctorService;
import tsxy.bsjz.platform.service.FamilycontactService;
import tsxy.bsjz.platform.service.PatientService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--13:53     patient  Patient  患者
 */
@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private FamilycontactService familycontactService;

    //增加患者信息
    @RequestMapping("/insertIntoPatient")
    public HashMap<String, Object> insertIntoPatient(Patient patient) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        patientService.insertIntoPatient(patient);
        return result;
    }

    //批量删除患者信息
    @RequestMapping("/deletePatientByIds")
    public HashMap<String, Object> deletePatientByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        patientService.deletePatientByIds(Arrays.asList(ids));
        return result;
    }

    //修改患者信息
    @RequestMapping("/updatePatient")
    public HashMap<String, Object> updatePatient(Patient patient) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        patientService.updatePatient(patient);
        return result;
    }

    //分页查询全部患者信息
    @RequestMapping("/selectAllPatient")
    public HashMap<String, Object> selectAllPatient(PatientSearchDto patientSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Patient> pageData =  patientService.selectAllPatient(patientSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Patient> patientList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("patientList", patientList);
        return result;
    }

    //根据科室ID查询  此科室下的全部医生的主键和名称
    @RequestMapping("/selectDoctorByDepartmentId")
    public HashMap<String, Object> selectDoctorByDepartmentId(Integer departmentId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Doctor> doctorList = doctorService.selectDoctorByDepartmentId(departmentId);
        result.put("doctorList",doctorList);
        return result;
    }

    //查询全部家庭联系人和科室  拼成下拉选框
    @RequestMapping("/selectFamilyAndDepartment")
    public HashMap<String, Object> selectFamilyAndDepartment() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Familycontact> familycontactList = familycontactService.selectAllFamilycontact();
        List<Department> departmentList = departmentService.selectAllDepartmentList();
        result.put("familycontactList",familycontactList);
        result.put("departmentList",departmentList);
        return result;
    }
}
