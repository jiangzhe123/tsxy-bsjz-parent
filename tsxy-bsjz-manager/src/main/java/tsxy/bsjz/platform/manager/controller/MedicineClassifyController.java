package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.MedicinePublicDto;
import tsxy.bsjz.platform.model.MedicineClassify;
import tsxy.bsjz.platform.service.MedicineClassifyService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * Created by 姜哲 on 2018/3/30--11:43 medicineClassify  MedicineClassify  药品分类
 */
@RestController
@RequestMapping("medicineClassify")
public class MedicineClassifyController {
    @Autowired
    private MedicineClassifyService medicineClassifyService;

    //增加药品分类信息
    @RequestMapping("/insertIntoClassify")
    public HashMap<String, Object> insertIntoClassify(MedicineClassify medicineClassify) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineClassifyService.insertIntoClassify(medicineClassify);
        return result;
    }

    //批量删除药品分类信息
    @RequestMapping("/deleteClassifyByIds")
    public HashMap<String, Object> deleteClassifyByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineClassifyService.deleteClassifyByIds(Arrays.asList(ids));
        return result;
    }

    //修改药品分类信息
    @RequestMapping("/updateClassify")
    public HashMap<String, Object> updateClassify(MedicineClassify medicineClassify) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        medicineClassifyService.updateClassify(medicineClassify);
        return result;
    }

    //分页查询全部药品分类信息
    @RequestMapping("/selectAllClassify")
    public HashMap<String, Object> selectAllClassify(MedicinePublicDto medicinePublicDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<MedicineClassify> pageData =  medicineClassifyService.selectAllClassify(medicinePublicDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<MedicineClassify> classifyList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("classifyList", classifyList);
        return result;
    }
}
