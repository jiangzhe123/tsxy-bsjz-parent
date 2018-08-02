package tsxy.bsjz.platform.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsxy.bsjz.platform.dao.PowerDao;
import tsxy.bsjz.platform.dao.RoleDao;
import tsxy.bsjz.platform.dao.RouteDao;
import tsxy.bsjz.platform.dao.vo.RouteSearchDto;
import tsxy.bsjz.platform.model.*;
import tsxy.bsjz.platform.service.HandleRecordService;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.RouteService;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.HandleRecordConstants;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 姜哲 on 2018/2/28--11:26
 */
@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private HandleRecordService handleRecordService;

    @Override
    public void insertIntoRoute(Route route) throws BusinessException {
        try {
            if(route.getId() != null){
                routeDao.updateRoute(route);
            }else{
                routeDao.insertIntoRoute(route);
                //增加操作记录
                Manager currentManager = managerService.selectCurrentManager();
                HandleRecord handleRecord = new HandleRecord();
                handleRecord.setHandleName(currentManager.getRealName());
                handleRecord.setHandleRole(currentManager.getRole().getRoleName());
                handleRecord.setHandleContent(HandleRecordConstants.ROUTE_ADD+route.getName());
                handleRecord.setHandleDate(new Date());
                handleRecordService.insertIntoHandleRecord(handleRecord);
            }
        } catch (Exception e) {
            throw new BusinessException("增加更新路由信息失败",e.getMessage());
        }
    }

    @Override
    public void deleteRouteByIds(List<Integer> ids) throws BusinessException {
        try {
            List<Integer> judgeIds = routeDao.selectPowerIdWhenDelete(ids);
            //说明权限还有此路由所以不可以删除直接throw异常
            if(judgeIds.size() > 0){
                throw new BusinessException("权限还有此路由,删除路由失败");
            }
            routeDao.deleteRouteByIds(ids);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.ROUTE_DELETE);
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (BusinessException b){
            //捕获异常，通过AOP 传到前端
            throw new BusinessException(b.getErrorMessage());
        }catch (Exception e){
            throw new BusinessException("删除路由信息失败",e.getMessage());
        }
    }

    @Override
    public void updateRoute(Route route) throws BusinessException {
        try {
            routeDao.updateRoute(route);
            //增加操作记录
            Manager currentManager = managerService.selectCurrentManager();
            HandleRecord handleRecord = new HandleRecord();
            handleRecord.setHandleName(currentManager.getRealName());
            handleRecord.setHandleRole(currentManager.getRole().getRoleName());
            handleRecord.setHandleContent(HandleRecordConstants.ROUTE_UPDATE+route.getName());
            handleRecord.setHandleDate(new Date());
            handleRecordService.insertIntoHandleRecord(handleRecord);
        }catch (Exception e){
            throw new BusinessException("修改路由信息失败",e.getMessage());
        }
    }

    @Override
    public PageBean<Route> selectAllRoute(RouteSearchDto routeSearchDto) throws BusinessException {
        try {
            PageHelper.startPage(routeSearchDto.getPageNum(), routeSearchDto.getPageSize());
            List<Route> routeList = routeDao.selectAllRoute(routeSearchDto);//集合
            Integer countNums = routeDao.selectCountByExample(routeSearchDto);//总数
            PageBean<Route> pageData = new PageBean<>(routeSearchDto.getPageNum(), routeSearchDto.getPageSize(), countNums);
            pageData.setItems(routeList);
            return pageData;
        }catch (Exception e){
            throw new BusinessException("分页查询全部路由信息失败",e.getMessage());
        }
    }

    @Override
    public List<Route> selectAllRoute() throws BusinessException {
        try {
            return routeDao.selectAllRoute();
        }catch (Exception e){
            throw new BusinessException("查询全部路由信息失败",e.getMessage());
        }
    }

    @Override
    public List<Route> selectRouteByManager(Manager manager) throws BusinessException {
        Role role = manager.getRole();
        Integer roleNumber = null;
        //路由中有一个字段判断 比如---0那个都不能点（角色为 游客）+1那个都能点
        // （角色为 超级管理员）+2 除了权限管理的（角色为 高级管理员）
        // +3只能编辑能看见的页面（角色为 普通管理员）这个字段的值每次进行判断从新 赋予值
        if(role.getRoleCode().equals("cjgly")){
        //超级管理员
            roleNumber = 1;
        }else if(role.getRoleCode().equals("gjgly")){
        //高级管理员
            roleNumber = 2;
        }else if(role.getRoleCode().equals("ptgly")){
        //普通管理员
            roleNumber = 3;
        }else{
        //游客
            roleNumber = 0;
        }
        try {
            //从权限中取出路由的信息 实例化接口
            List<Power> powerList = role.getPowerList();
            List<Route> routeList = new ArrayList<Route>();;
            for(Power power:powerList){
                routeList.add(power.getRoute());
            }
            //给路由中那个字段赋值  判断增删改查按钮
            for(Route route:routeList){
                route.setRoleNumber(roleNumber);
            }
            return routeList;
        } catch (Exception e) {
            throw new BusinessException("查询此管理员下全部路由信息失败",e.getMessage());
        }
    }
}
