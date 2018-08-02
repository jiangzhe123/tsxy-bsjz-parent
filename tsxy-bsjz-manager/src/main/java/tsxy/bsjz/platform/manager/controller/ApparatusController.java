package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.ApparatusSearchDto;
import tsxy.bsjz.platform.model.Apparatus;
import tsxy.bsjz.platform.model.ApparatusClassify;
import tsxy.bsjz.platform.service.ApparatusClassifyService;
import tsxy.bsjz.platform.service.ApparatusService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/4/3--10:19 Apparatus apparatus 仪器
 */
@RestController
@RequestMapping("apparatus")
public class ApparatusController {
    @Autowired
    private ApparatusService apparatusService;
    @Autowired
    private ApparatusClassifyService appClassifyService;

    //增加仪器信息
    @RequestMapping("/insertIntoApparatus")
    public HashMap<String, Object> insertIntoApparatus(Apparatus apparatus) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        apparatusService.insertIntoApparatus(apparatus);
        return result;
    }

    //批量删除仪器信息
    @RequestMapping("/deleteApparatusByIds")
    public HashMap<String, Object> deleteApparatusByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        apparatusService.deleteApparatusByIds(Arrays.asList(ids));
        return result;
    }

    //修改仪器信息
    @RequestMapping("/updateApparatus")
    public HashMap<String, Object> updateApparatus(Apparatus apparatus) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        apparatusService.updateApparatus(apparatus);
        return result;
    }

    //查询全部仪器分类信息
    @RequestMapping("/selectAllAppClassifyList")
    public HashMap<String, Object> selectAllAppClassifyList() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<ApparatusClassify> appClassifyList = appClassifyService.selectAllApparatusClassifyList();
        result.put("appClassifyList",appClassifyList);
        return result;
    }

    //分页查询全部仪器信息
    @RequestMapping("/selectAllApparatus")
    public HashMap<String, Object> selectAllApparatus(ApparatusSearchDto apparatusSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Apparatus> pageData =  apparatusService.selectAllApparatus(apparatusSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Apparatus> apparatusList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("apparatusList", apparatusList);
        return result;
    }
}
