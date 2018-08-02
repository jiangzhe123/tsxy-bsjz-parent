package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.DepartCountDto;
import tsxy.bsjz.platform.dao.vo.DetailedCountDto;
import tsxy.bsjz.platform.dao.vo.DoctorCountDto;
import tsxy.bsjz.platform.dao.vo.SickbedCountDto;
import tsxy.bsjz.platform.service.DepartmentService;
import tsxy.bsjz.platform.service.DetailedListService;
import tsxy.bsjz.platform.service.DoctorService;
import tsxy.bsjz.platform.service.SickbedService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/11--11:15  所有视图统计controller
 */
@RestController
@RequestMapping("count")
public class CountController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DetailedListService detailedListService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SickbedService sickbedService;

    //查询视图科室之统计柱状图
    @RequestMapping("/selectDepartCountDto")
    public HashMap<String, Object> selectAllDepartCountDto() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<DepartCountDto> departCountDtoList = departmentService.selectAllDepartCountDto();
        result.put("departCountDtoList",departCountDtoList);
        return result;
    }

    //查询视图清单统计之昨日和今日总金额
    @RequestMapping("/selectDetailedCountDto")
    public HashMap<String, Object> selectDetailedCountDto() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        DetailedCountDto detailedCountDto = detailedListService.selectDetailedCountDto();
        result.put("detailedCountDto",detailedCountDto);
        return result;
    }

    //查询视图医师职位下的医生的数量
    @RequestMapping("/selectDoctorCountDto")
    public HashMap<String, Object> selectDoctorCountDto() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<DoctorCountDto> doctorCountDtoList = doctorService.selectDoctorCountDto();
        result.put("doctorCountDtoList",doctorCountDtoList);
        return result;
    }

    //查询视图 病床之空不空 统计
    @RequestMapping("/selectSickbedCountDto")
    public HashMap<String, Object> selectSickbedCountDto() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        SickbedCountDto sickbedCountDto = sickbedService.selectSickbedCountDto();
        result.put("sickbedCountDto",sickbedCountDto);
        return result;
    }

}
