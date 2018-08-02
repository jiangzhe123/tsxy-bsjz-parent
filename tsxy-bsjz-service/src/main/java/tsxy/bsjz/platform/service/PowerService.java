package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.PowerSearchDto;
import tsxy.bsjz.platform.model.Power;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--14:27
 */
public interface PowerService {

    //增
    void insertIntoPower(Power power) throws BusinessException;

    //删（批量删除）
    void deletePowerByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updatePower(Power power) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<Power> selectAllPower(PowerSearchDto powerSearchDto) throws BusinessException;

    //查询---全部 无参数
    List<Power> selectAllPower() throws BusinessException;

    //修改此权限对应的路由 一对一
    void updatePowerAndRoute(Integer powerId,Integer routeId) throws BusinessException;

    //查询此权限下对应的那个路由ID主键
    Integer selectRouteIdByPowerId(Integer powerId) throws BusinessException;
}
