package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.ManagerLoginDto;
import tsxy.bsjz.platform.dao.vo.ManagerSearchDto;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.utils.BusinessException;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--13:42
 */
public interface ManagerService {

    //增
    void insertIntoManager(Manager manager) throws BusinessException;

    //删（批量删除）
    void deleteManagerByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateManager(Manager manager) throws BusinessException;

    //查询---通过用户名 查询单个
    Manager selectManagerByUserName(String userName) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    PageBean<Manager> selectAllManager(ManagerSearchDto managerSearchDto) throws BusinessException;

    //登录方法
    void loginManager(ManagerLoginDto managerLoginDto) throws BusinessException;

    //通过shiro获得当前登录用户
    Manager selectCurrentManager() throws BusinessException;

    //注销退出登录
    void loginOutManager() throws BusinessException;

    //查询此管理员 对应 的角色ID  根据管理员ID
    Integer selectRoleIdByManagerId(Integer managerId) throws BusinessException;

    //更改此管理员的角色 根据管理员ID  一对一
    void updateManagerRoleByRoleId(Integer managerId,Integer roleId) throws BusinessException;
}
