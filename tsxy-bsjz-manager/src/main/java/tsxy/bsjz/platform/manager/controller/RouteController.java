package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.RouteSearchDto;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Route;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.RouteService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/1--11:10
 */
@RestController
@RequestMapping("route")
public class RouteController {

    @Autowired
    private RouteService routeService;
    @Autowired
    private ManagerService managerService;

    //增加路由信息
    @RequestMapping("/insertIntoRoute")
    public HashMap<String, Object> insertIntoRoute(Route route) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        routeService.insertIntoRoute(route);
        return result;
    }

    //批量删除路由信息
    @RequestMapping("/deleteRouteByIds")
    public HashMap<String, Object> deleteRouteByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        routeService.deleteRouteByIds(Arrays.asList(ids));
        return result;
    }

    //修改路由信息
    @RequestMapping("/updateRoute")
    public HashMap<String, Object> updateRoute(Route route) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        routeService.updateRoute(route);
        return result;
    }

    //查询全部路由信息
    @RequestMapping("/selectAllRoute")
    public HashMap<String, Object> selectAllRoute(RouteSearchDto routeSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Route> pageData =  routeService.selectAllRoute(routeSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Route> routeList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("routeList", routeList);
        return result;
    }

    //根据当前登录管理员获得页面上需要加载的路由信息
    @RequestMapping("/selectRouteByManager")
    public HashMap<String, Object> selectRouteByManager() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        //Manager manager = managerService.selectManagerByUserName(userName);
        Manager manager = managerService.selectCurrentManager();
        //从service层查询数据
        List<Route> routeList = routeService.selectRouteByManager(manager);
        //创建父类空集合
        List<Route> routeListParent = new ArrayList<Route>();
        //创建子类空集合
        List<Route> routeListChildren = new ArrayList<Route>();
        //创建最终返回到前台的集合
        List<Route> finalRouteList = new ArrayList<Route>();
        for (Route route:routeList){
            if(1 == route.getParentId()){
                routeListParent.add(route);
            }else{
                routeListChildren.add(route);
            }
        }
        for(Route routeParent:routeListParent){
            List<Route> routes = new ArrayList<Route>();
            for(Route routeChildren:routeListChildren){
                if(routeParent.getId() == routeChildren.getParentId()){
                    routes.add(routeChildren);
                }
            }
            routeParent.setChildRoutes(routes);
            finalRouteList.add(routeParent);
        }
        result.put("data", finalRouteList);
        return result;
    }
}


