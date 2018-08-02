package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.SickbedSearchDto;
import tsxy.bsjz.platform.model.Department;
import tsxy.bsjz.platform.model.Patient;
import tsxy.bsjz.platform.model.Sickbed;
import tsxy.bsjz.platform.service.DepartmentService;
import tsxy.bsjz.platform.service.PatientService;
import tsxy.bsjz.platform.service.SickbedService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/2--19:46  Sickbed  sickbed  病床
 */
@RestController
@RequestMapping("sickbed")
public class SickbedController {
    @Autowired
    private SickbedService sickbedService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DepartmentService departmentService;

    //增加病床信息
    @RequestMapping("/insertIntoSickbed")
    public HashMap<String, Object> insertIntoSickbed(Sickbed sickbed) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        sickbedService.insertIntoSickbed(sickbed);
        return result;
    }

    //批量删除病床信息
    @RequestMapping("/deleteSickbedByIds")
    public HashMap<String, Object> deleteSickbedByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        sickbedService.deleteSickbedByIds(Arrays.asList(ids));
        return result;
    }

    //修改病床信息
    @RequestMapping("/updateSickbed")
    public HashMap<String, Object> updateSickbed(Sickbed sickbed) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        sickbedService.updateSickbed(sickbed);
        return result;
    }

    //修改病床信息
    @RequestMapping("/updatePatientNull")
    public HashMap<String, Object> updatePatientNull(Integer id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        sickbedService.updatePatientNull(id);
        return result;
    }

    //查询全部科室
    @RequestMapping("/selectAllDepartmentList")
    public HashMap<String, Object> selectAllDepartmentList() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Department> departmentList = departmentService.selectAllDepartmentList();
        result.put("departmentList", departmentList);
        return result;
    }

    //根据科室ID 查询 全部患者(未安排病床的)
    @RequestMapping("/selectNotSickbedPatient")
    public HashMap<String, Object> selectNotSickbedPatient(Integer departmentId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Patient> patientList = patientService.selectNotSickbedPatient(departmentId);
        result.put("patientList", patientList);
        return result;
    }

    //根据科室ID 查询 全部患者
    @RequestMapping("/selectAllPatientByDepartId")
    public HashMap<String, Object> selectAllPatientByDepartId(Integer departmentId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Patient> patientList = patientService.selectAllPatientByDepartId(departmentId);
        result.put("patientList", patientList);
        return result;
    }

    //查询全部非空病床信息
    @RequestMapping("/selectAllSickbed")
    public HashMap<String, Object> selectAllSickbed(SickbedSearchDto sickbedSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Sickbed> pageData =  sickbedService.selectAllSickbed(sickbedSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Sickbed> sickbedList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("sickbedList", sickbedList);
        return result;
    }

    //查询全部空病床信息
    @RequestMapping("/selectAllNullSickbed")
    public HashMap<String, Object> selectAllNullSickbed(SickbedSearchDto sickbedSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Sickbed> pageData =  sickbedService.selectAllNullSickbed(sickbedSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Sickbed> sickbedList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("sickbedList", sickbedList);
        return result;
    }


}
