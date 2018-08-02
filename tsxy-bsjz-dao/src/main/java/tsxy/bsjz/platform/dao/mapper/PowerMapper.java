package tsxy.bsjz.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.Power;
import tsxy.bsjz.platform.model.PowerExample;
import tsxy.bsjz.platform.model.Route;

public interface PowerMapper {
    long countByExample(PowerExample example);

    int deleteByExample(PowerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Power record);

    int insertSelective(Power record);

    List<Power> selectByExample(PowerExample example);

    Power selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Power record, @Param("example") PowerExample example);

    int updateByExample(@Param("record") Power record, @Param("example") PowerExample example);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);

    //查询此角色下全部权限
    List<Power> selectPowerListByRoleId(Integer id);

    //增加权限的时候默认给此权限 增加一个路由信息  权限路由一对一 默认路由为全部页面
    void insertIntoPowerRoute(@Param("powerId") Integer powerId,@Param("routeId") Integer routeId);

    //修改此权限对应的路由 一对一
    void updatePowerAndRoute(@Param("powerId") Integer powerId,@Param("routeId") Integer routeId);

    //查询此权限下对应的那个路由ID主键 一对一
    Integer selectRouteIdByPowerId(Integer powerId);

    //当删除权限的时候，判断全部角色中 是否还有角色有这个权限
    List<Integer> selectRoleIdWhenDelete(List<Integer> ids);
}