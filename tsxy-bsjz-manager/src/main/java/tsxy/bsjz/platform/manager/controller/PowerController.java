package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.PowerSearchDto;
import tsxy.bsjz.platform.model.Power;
import tsxy.bsjz.platform.model.Route;
import tsxy.bsjz.platform.service.PowerService;
import tsxy.bsjz.platform.service.RouteService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/1--11:01
 */
@RestController
@RequestMapping("power")
public class PowerController {

    @Autowired
    private PowerService powerService;
    @Autowired
    private RouteService routeService;

    //增加权限
    @RequestMapping("/insertIntoPower")
    public HashMap<String, Object> insertIntoPower(Power power){
        HashMap<String, Object> result = new HashMap<String, Object>();
        powerService.insertIntoPower(power);
        return result;
    }

    //批量删除权限
    @RequestMapping("/deletePowerByIds")
    public HashMap<String, Object> deletePowerByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        powerService.deletePowerByIds(Arrays.asList(ids));
        return result;
    }

    //修改权限
    @RequestMapping("/updatePower")
    public HashMap<String, Object> updatePower(Power power){
        HashMap<String, Object> result = new HashMap<String, Object>();
        powerService.updatePower(power);
        return result;
    }

    //查询全部权限信息
    @RequestMapping("/selectAllPower")
    public HashMap<String, Object> selectAllPower(PowerSearchDto powerSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Power> pageData =  powerService.selectAllPower(powerSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Power> powerList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("powerList", powerList);
        return result;
    }

    //查询此权限下的路由信息和全部路由信息  选中默认的
    @RequestMapping("/selectRouteByPowerId")
    public HashMap<String, Object> selectRouteByPowerId(Integer powerId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Integer routeId = powerService.selectRouteIdByPowerId(powerId);
        List<Route> routeList = routeService.selectAllRoute();
        result.put("routeId",routeId);
        result.put("routeList",routeList);
        return result;
    }

    //修改此权限对应的路由
    @RequestMapping("/updatePowerAndRoute")
    public HashMap<String, Object> updatePowerAndRoute(Integer powerId, Integer routeId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        powerService.updatePowerAndRoute(powerId,routeId);
        return result;
    }
}
