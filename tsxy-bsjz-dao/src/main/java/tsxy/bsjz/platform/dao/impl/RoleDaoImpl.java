package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.RoleDao;
import tsxy.bsjz.platform.dao.mapper.RoleMapper;
import tsxy.bsjz.platform.dao.vo.RoleSearchDto;
import tsxy.bsjz.platform.model.Role;
import tsxy.bsjz.platform.model.RoleExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--11:19
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void insertIntoRole(Role role) throws Exception {
        roleMapper.insertSelective(role);
    }

    @Override
    public void deleteRoleByIds(List<Integer> ids) throws Exception {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        roleMapper.deleteByExample(example);
    }

    @Override
    public void updateRole(Role role) throws Exception {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public Role selectRoleById(Integer id) throws Exception {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> selectAllRole(RoleSearchDto roleSearchDto) throws Exception {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if(roleSearchDto.getRoleName() != null && !roleSearchDto.getRoleName().equals("")){
            criteria.andRoleNameLike("%"+roleSearchDto.getRoleName()+"%");
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<Role> selectAllRole() throws Exception {
        RoleExample example = new RoleExample();
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<Integer> selectPowerIdsByRoleId(Integer roleId) throws Exception {
        return roleMapper.selectPowerIdsByRoleId(roleId);
    }

    @Override
    public void deletePowerIdsByRoleId(Integer roleId) throws Exception {
        roleMapper.deletePowerIdsByRoleId(roleId);
    }

    @Override
    public void insertIntoRoleAndPower(Integer roleId, List<Integer> powerIds) throws Exception {
        roleMapper.insertIntoRoleAndPower(roleId,powerIds);
    }

    @Override
    public List<Integer> selectManagerIdWhenDelete(List<Integer> ids) throws Exception {
        return roleMapper.selectManagerIdWhenDelete(ids);
    }

}
