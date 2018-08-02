package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.RouteSearchDto;
import tsxy.bsjz.platform.model.Route;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/28--9:47
 */
public interface RouteDao {

    //增
    void insertIntoRoute(Route route) throws Exception;

    //删（批量删除）
    void deleteRouteByIds(List<Integer> ids) throws Exception;

    //修改
    void updateRoute(Route route) throws Exception;

    //查询---通过主键 查询单个
    Route selectRouteById(Integer id) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(RouteSearchDto routeSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Route> selectAllRoute(RouteSearchDto routeSearchDto) throws Exception;

    //查询---全部 无参数
    List<Route> selectAllRoute() throws Exception;

    //当删除路由的时候，判断全部权限中 是否还有权限有这个路由
    List<Integer> selectPowerIdWhenDelete(List<Integer> ids) throws Exception;
}
