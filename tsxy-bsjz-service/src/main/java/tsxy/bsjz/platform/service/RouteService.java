package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.RouteSearchDto;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Route;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/28--11:24
 */
public interface RouteService {
    //增
    void insertIntoRoute(Route route) throws BusinessException;

    //删（批量删除）
    void deleteRouteByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateRoute(Route route) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<Route> selectAllRoute(RouteSearchDto routeSearchDto) throws BusinessException;

    //查询---全部 无参数
    List<Route> selectAllRoute() throws BusinessException;

    //根据当前登录管理员获得页面上需要加载的路由信息
    List<Route> selectRouteByManager(Manager manager) throws BusinessException;
}
