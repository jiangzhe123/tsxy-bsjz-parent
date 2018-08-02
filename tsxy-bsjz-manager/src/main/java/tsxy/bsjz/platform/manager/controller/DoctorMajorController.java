package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.DoctorMajorSearchDto;
import tsxy.bsjz.platform.model.DoctorMajor;
import tsxy.bsjz.platform.service.DoctorMajorService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/28--9:34  doctorMajor   DoctorMajor  医师专业
 */
@RestController
@RequestMapping("doctorMajor")
public class DoctorMajorController {
    @Autowired
    private DoctorMajorService doctorMajorService;

    //增加医师专业信息
    @RequestMapping("/insertIntoDoctorMajor")
    public HashMap<String, Object> insertIntoDoctorMajor(DoctorMajor doctorMajor) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        doctorMajorService.insertIntoDoctorMajor(doctorMajor);
        return result;
    }

    //批量删除医师专业信息
    @RequestMapping("/deleteDoctorMajorByIds")
    public HashMap<String, Object> deleteDoctorMajorByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        doctorMajorService.deleteDoctorMajorByIds(Arrays.asList(ids));
        return result;
    }

    //修改医师专业信息
    @RequestMapping("/updateDoctorMajor")
    public HashMap<String, Object> updateDoctorMajor(DoctorMajor doctorMajor) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        doctorMajorService.updateDoctorMajor(doctorMajor);
        return result;
    }

    //分页查询全部医师专业信息
    @RequestMapping("/selectAllDoctorMajor")
    public HashMap<String, Object> selectAllDoctorMajor(DoctorMajorSearchDto doctorMajorSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<DoctorMajor> pageData =  doctorMajorService.selectAllDoctorMajor(doctorMajorSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<DoctorMajor> doctorMajorList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("doctorMajorList", doctorMajorList);
        return result;
    }
}
