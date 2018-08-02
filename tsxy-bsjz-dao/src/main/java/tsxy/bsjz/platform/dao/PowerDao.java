package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.PowerSearchDto;
import tsxy.bsjz.platform.model.Power;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--10:28
 */
public interface PowerDao {

    //增
    void insertIntoPower(Power power) throws Exception;

    //删（批量删除）
    void deletePowerByIds(List<Integer> ids) throws Exception;

    //修改
    void updatePower(Power power) throws Exception;

    //查询---通过主键 查询单个
    Power selectPowerById(Integer id) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(PowerSearchDto powerSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Power> selectAllPower(PowerSearchDto powerSearchDto) throws Exception;

    //查询---全部 无参数
    List<Power> selectAllPower() throws Exception;

    //增加权限的时候默认给此权限 增加一个路由信息  权限路由一对一 默认路由为全部页面
    void insertIntoPowerRoute(Integer powerId,Integer routeId) throws Exception;

    //修改此权限对应的路由 一对一
    void updatePowerAndRoute(Integer powerId,Integer routeId) throws Exception;

    //查询此权限下对应的那个路由ID主键
    Integer selectRouteIdByPowerId(Integer powerId) throws Exception;

    //当删除权限的时候，判断全部角色中 是否还有角色有这个权限
    List<Integer> selectRoleIdWhenDelete(List<Integer> ids) throws Exception;
}
