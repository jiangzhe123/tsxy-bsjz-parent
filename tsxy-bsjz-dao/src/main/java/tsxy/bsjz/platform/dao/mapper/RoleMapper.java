package tsxy.bsjz.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.Power;
import tsxy.bsjz.platform.model.Role;
import tsxy.bsjz.platform.model.RoleExample;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //根据managerId 查询role信息
    Role selectRoleByManagerId(Integer id);

    //查询此角色拥有的权限power们的IDs 根据角色ID
    List<Integer> selectPowerIdsByRoleId(Integer roleId);

    //根据角色ID 删除此角色拥有的权限们
    void deletePowerIdsByRoleId(Integer roleId);

    //建立增加 角色和权限关系 一对多
    void insertIntoRoleAndPower(@Param("roleId") Integer roleId,@Param("powerIds") List<Integer> powerIds);

    //当删除角色的时候，判断全部管理员中 是否还有管理员是这个角色
    List<Integer> selectManagerIdWhenDelete(List<Integer> ids);
}