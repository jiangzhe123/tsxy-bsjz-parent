package tsxy.bsjz.platform.dao;

import tsxy.bsjz.platform.dao.vo.ManagerSearchDto;
import tsxy.bsjz.platform.model.Manager;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--10:27
 */
public interface ManagerDao {

    //增
    void insertIntoManager(Manager manager) throws Exception;

    //删（批量删除）
    void deleteManagerByIds(List<Integer> ids) throws Exception;

    //修改
    void updateManager(Manager manager) throws Exception;

    //查询---通过主键 查询单个
    Manager selectManagerById(Integer id) throws Exception;

    //查询---通过用户名 查询单个
    Manager selectManagerByUserName(String userName) throws Exception;

    //查询---通过手机号 查询单个
    Manager selectManagerByPhone(String phone) throws Exception;

    //查询 总共多少满足条件 的实体类个数
    Integer selectCountByExample(ManagerSearchDto managerSearchDto) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Manager> selectAllManager(ManagerSearchDto managerSearchDto) throws Exception;

    //查询---全部 无参数
    List<Manager> selectAllManager() throws Exception;

    //查询此管理员 对应 的角色ID  根据管理员ID
    Integer selectRoleIdByManagerId(Integer managerId) throws Exception;

    //当增加管理员的时候，默认往管理员-角色表增加一条数据 分配新增加的管理员默认为游客角色
    void insertIntoManagerRole(Integer managerId,Integer roleId) throws Exception;

    //更改此管理员的角色 根据管理员ID  一对一
    void updateManagerRoleByRoleId(Integer managerId,Integer roleId) throws Exception;

    //删除此管理员的时候，同时删除 管理员-角色表中 此管理员下的角色信息
    void deleteRoleIdByManagerIds(List<Integer> ids) throws Exception;
}
