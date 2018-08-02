package tsxy.bsjz.platform.service;

import tsxy.bsjz.platform.dao.vo.RoleSearchDto;
import tsxy.bsjz.platform.model.Role;
import tsxy.bsjz.platform.utils.BusinessException;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--14:18
 */
public interface RoleService {

    //增
    void insertIntoRole(Role role) throws BusinessException;

    //删（批量删除）
    void deleteRoleByIds(List<Integer> ids) throws BusinessException;

    //修改
    void updateRole(Role role) throws BusinessException;

    //查询---全部+模糊查询+前端页面上分页+排序
    List<Role> selectAllRole(RoleSearchDto roleSearchDto) throws BusinessException;

    //查询---全部 无参数
    List<Role> selectAllRole() throws BusinessException;

    //查询此角色拥有的权限power们的IDs 根据角色ID
    List<Integer> selectPowerIdsByRoleId(Integer roleId) throws BusinessException;

    //建立增加 角色和权限关系 一对多
    void insertIntoRoleAndPower(Integer roleId,List<Integer> powerIds) throws BusinessException;
}
