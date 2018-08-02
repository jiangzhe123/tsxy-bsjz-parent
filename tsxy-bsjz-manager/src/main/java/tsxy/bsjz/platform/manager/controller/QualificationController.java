package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.QualificationSearchDto;
import tsxy.bsjz.platform.model.Qualification;
import tsxy.bsjz.platform.service.QualificationService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/28--9:42 Qualification  qualification  医师资格
 */
@RestController
@RequestMapping("qualification")
public class QualificationController {
    @Autowired
    private QualificationService qualificationService;

    //增加医师资格信息
    @RequestMapping("/insertIntoQualification")
    public HashMap<String, Object> insertIntoQualification(Qualification qualification) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        qualificationService.insertIntoQualification(qualification);
        return result;
    }

    //批量删除医师资格信息
    @RequestMapping("/deleteQualificationByIds")
    public HashMap<String, Object> deleteQualificationByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        qualificationService.deleteQualificationByIds(Arrays.asList(ids));
        return result;
    }

    //修改医师资格信息
    @RequestMapping("/updateQualification")
    public HashMap<String, Object> updateQualification(Qualification qualification) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        qualificationService.updateQualification(qualification);
        return result;
    }

    //分页查询全部医师资格信息
    @RequestMapping("/selectAllQualification")
    public HashMap<String, Object> selectAllQualification(QualificationSearchDto qualificationSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Qualification> pageData =  qualificationService.selectAllQualification(qualificationSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Qualification> qualificationList= pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("qualificationList", qualificationList);
        return result;
    }
}
