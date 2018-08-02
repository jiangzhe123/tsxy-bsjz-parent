package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.ApparatusClassifySearchDto;
import tsxy.bsjz.platform.model.ApparatusClassify;
import tsxy.bsjz.platform.service.ApparatusClassifyService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--10:19  ApparatusClassify  appClassify 仪器分类
 */
@RestController
@RequestMapping("appClassify")
public class ApparatusClassifyController {
    @Autowired
    private ApparatusClassifyService appClassifyService;

    //增加仪器分类信息
    @RequestMapping("/insertIntoAppClassify")
    public HashMap<String, Object> insertIntoAppClassify(ApparatusClassify appClassify) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        appClassifyService.insertIntoApparatusClassify(appClassify);
        return result;
    }

    //批量删除仪器分类信息
    @RequestMapping("/deleteAppClassifyByIds")
    public HashMap<String, Object> deleteAppClassifyByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        appClassifyService.deleteApparatusClassifyByIds(Arrays.asList(ids));
        return result;
    }

    //修改仪器分类信息
    @RequestMapping("/updateAppClassify")
    public HashMap<String, Object> updateAppClassify(ApparatusClassify appClassify) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        appClassifyService.updateApparatusClassify(appClassify);
        return result;
    }

    //分页查询全部仪器分类信息
    @RequestMapping("/selectAllAppClassify")
    public HashMap<String, Object> selectAllAppClassify(ApparatusClassifySearchDto appClassifySearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<ApparatusClassify> pageData =  appClassifyService.selectAllApparatusClassify(appClassifySearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<ApparatusClassify> appClassifyList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("appClassifyList", appClassifyList);
        return result;
    }


}
