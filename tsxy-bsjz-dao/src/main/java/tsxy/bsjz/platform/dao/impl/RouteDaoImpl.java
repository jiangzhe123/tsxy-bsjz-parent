package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.RouteDao;
import tsxy.bsjz.platform.dao.mapper.RouteMapper;
import tsxy.bsjz.platform.dao.vo.RouteSearchDto;
import tsxy.bsjz.platform.model.Route;
import tsxy.bsjz.platform.model.RouteExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/28--11:15
 */
@Repository
public class RouteDaoImpl implements RouteDao {

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public void insertIntoRoute(Route route) throws Exception {
        routeMapper.insertSelective(route);
    }

    @Override
    public void deleteRouteByIds(List<Integer> ids) throws Exception {
        RouteExample example = new RouteExample();
        RouteExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        routeMapper.deleteByExample(example);
    }

    @Override
    public void updateRoute(Route route) throws Exception {
        routeMapper.updateByPrimaryKeySelective(route);
    }

    @Override
    public Route selectRouteById(Integer id) throws Exception {
        return routeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer selectCountByExample(RouteSearchDto routeSearchDto) throws Exception {
        RouteExample example = new RouteExample();
        RouteExample.Criteria criteria = example.createCriteria();
        if(routeSearchDto.getName() != null && !routeSearchDto.getName().equals("")){
            criteria.andNameLike("%"+routeSearchDto.getName()+"%");
        }
        return (int)routeMapper.countByExample(example);
    }

    @Override
    public List<Route> selectAllRoute(RouteSearchDto routeSearchDto) throws Exception {
        RouteExample example = new RouteExample();
        RouteExample.Criteria criteria = example.createCriteria();
        if(routeSearchDto.getName() != null && !routeSearchDto.getName().equals("")){
            criteria.andNameLike("%"+routeSearchDto.getName()+"%");
        }
        return routeMapper.selectByExample(example);
    }

    @Override
    public List<Route> selectAllRoute() throws Exception {
        RouteExample example = new RouteExample();
        return routeMapper.selectByExample(example);
    }

    @Override
    public List<Integer> selectPowerIdWhenDelete(List<Integer> ids) throws Exception {
        return routeMapper.selectPowerIdWhenDelete(ids);
    }
}
