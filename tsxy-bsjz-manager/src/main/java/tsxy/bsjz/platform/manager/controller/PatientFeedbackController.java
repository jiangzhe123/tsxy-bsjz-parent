package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.PatientFeedbackSearchDto;
import tsxy.bsjz.platform.model.PatientFeedback;
import tsxy.bsjz.platform.service.PatientFeedbackService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/29--13:52  PatientFeedback  patientFeedback  患者反馈
 */
@RestController
@RequestMapping("patientFeedback")
public class PatientFeedbackController {
    @Autowired
    private PatientFeedbackService patientFeedbackService;

    //批量删除患者反馈信息
    @RequestMapping("/deletePatientFeedbackByIds")
    public HashMap<String, Object> deletePatientFeedbackByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        patientFeedbackService.deletePatientFeedbackByIds(Arrays.asList(ids));
        return result;
    }

    //分页查询全部患者反馈信息
    @RequestMapping("/selectAllPatientFeedback")
    public HashMap<String, Object> selectAllPatientFeedback(PatientFeedbackSearchDto patientFeedbackSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<PatientFeedback> pageData =  patientFeedbackService.selectAllPatientFeedback(patientFeedbackSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<PatientFeedback> patientFeedbackList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("patientFeedbackList", patientFeedbackList);
        return result;
    }
}
