package tsxy.bsjz.platform.dao;


import tsxy.bsjz.platform.dao.vo.RoleSearchDto;
import tsxy.bsjz.platform.model.Power;
import tsxy.bsjz.platform.model.Role;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--10:28
 */
public interface RoleDao {

    //增
    void insertIntoRole(Role role) throws Exception;

    //删（批量删除）
    void deleteRoleByIds(List<Integer> ids) throws Exception;

    //修改
    void updateRole(Role role) throws Exception;

    //查询---通过主键 查询单个
    Role selectRoleById(Integer id) throws Exception;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Role> selectAllRole(RoleSearchDto roleSearchDto) throws Exception;

    //查询---全部 无参数
    List<Role> selectAllRole() throws Exception;

    //查询此角色拥有的权限power们的IDs 根据角色ID
    List<Integer> selectPowerIdsByRoleId(Integer roleId) throws Exception;

    //根据角色ID 删除此角色拥有的权限们
    void deletePowerIdsByRoleId(Integer roleId) throws Exception;

    //建立增加 角色和权限关系 一对多
    void insertIntoRoleAndPower(Integer roleId,List<Integer> powerIds) throws Exception;

    //当删除角色的时候，判断全部管理员中 是否还有管理员是这个角色
    List<Integer> selectManagerIdWhenDelete(List<Integer> ids) throws Exception;

}
