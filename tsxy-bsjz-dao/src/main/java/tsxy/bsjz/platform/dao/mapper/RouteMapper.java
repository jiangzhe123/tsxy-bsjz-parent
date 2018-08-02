package tsxy.bsjz.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.Route;
import tsxy.bsjz.platform.model.RouteExample;

public interface RouteMapper {
    long countByExample(RouteExample example);

    int deleteByExample(RouteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Route record);

    int insertSelective(Route record);

    List<Route> selectByExample(RouteExample example);

    Route selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Route record, @Param("example") RouteExample example);

    int updateByExample(@Param("record") Route record, @Param("example") RouteExample example);

    int updateByPrimaryKeySelective(Route record);

    int updateByPrimaryKey(Route record);

    Route selectRouteByPowerId(Integer id);

    //当删除路由的时候，判断全部权限中 是否还有权限有这个路由
    List<Integer> selectPowerIdWhenDelete(List<Integer> ids);
}