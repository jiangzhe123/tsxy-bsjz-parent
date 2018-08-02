package tsxy.bsjz.platform.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.ManagerExample;

public interface ManagerMapper {
    long countByExample(ManagerExample example);

    int deleteByExample(ManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    List<Manager> selectByExample(ManagerExample example);

    Manager selectByPrimaryKey(Integer id);

    Manager selectManagerByUserName(String userName);

    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    //查询此管理员 对应 的角色ID  根据管理员ID
    Integer selectRoleIdByManagerId(Integer managerId);

    //更改此管理员的角色 根据管理员ID  一对一
    void updateManagerRoleByRoleId(@Param("managerId") Integer managerId, @Param("roleId") Integer roleId);

    //当增加管理员的时候，默认往管理员-角色表增加一条数据 分配新增加的管理员默认为游客角色
    void insertIntoManagerRole(@Param("managerId") Integer managerId, @Param("roleId") Integer roleId);

    //删除此管理员的时候，同时删除 管理员-角色表中 此管理员下的角色信息
    void deleteRoleIdByManagerIds(List<Integer> ids);
}