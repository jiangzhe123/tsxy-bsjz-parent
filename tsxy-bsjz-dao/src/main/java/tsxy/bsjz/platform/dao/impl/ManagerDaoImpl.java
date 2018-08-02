package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.ManagerDao;
import tsxy.bsjz.platform.dao.mapper.ManagerMapper;
import tsxy.bsjz.platform.dao.vo.ManagerSearchDto;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.ManagerExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--10:52
 */
@Repository
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public void insertIntoManager(Manager manager) throws Exception {
        managerMapper.insertSelective(manager);
    }

    @Override
    public void deleteManagerByIds(List<Integer> ids) throws Exception {
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        managerMapper.deleteByExample(example);
    }

    @Override
    public void updateManager(Manager manager) throws Exception {
        managerMapper.updateByPrimaryKeySelective(manager);
    }

    @Override
    public Manager selectManagerById(Integer id) throws Exception {
        return managerMapper.selectByPrimaryKey(id);
    }

    @Override
    public Manager selectManagerByUserName(String userName) throws Exception {
        return managerMapper.selectManagerByUserName(userName);
    }

    @Override
    public Manager selectManagerByPhone(String phone) throws Exception {
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<Manager> list = managerMapper.selectByExample(example);
        return list.get(0);
    }

    @Override
    public Integer selectCountByExample(ManagerSearchDto managerSearchDto) throws Exception {
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        //此处还可以加模糊查询的条件managerSearchDto.getUserName() != null ||
        if(managerSearchDto.getRealName() != null && !managerSearchDto.getRealName().equals("")){
            criteria.andRealNameLike("%"+managerSearchDto.getRealName()+"%");
        }
        return (int)managerMapper.countByExample(example);
    }

    @Override
    public List<Manager> selectAllManager(ManagerSearchDto managerSearchDto) throws Exception {
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        //此处还可以加模糊查询的条件managerSearchDto.getUserName() != null ||
        if(managerSearchDto.getRealName() != null && !managerSearchDto.getRealName().equals("")){
            criteria.andRealNameLike("%"+managerSearchDto.getRealName()+"%");
        }
        example.setOrderByClause(managerSearchDto.getOrderByClause());
        return managerMapper.selectByExample(example);
    }

    @Override
    public List<Manager> selectAllManager() throws Exception {
        ManagerExample example = new ManagerExample();
        return managerMapper.selectByExample(example);
    }

    @Override
    public Integer selectRoleIdByManagerId(Integer managerId) throws Exception {
        return managerMapper.selectRoleIdByManagerId(managerId);
    }

    @Override
    public void insertIntoManagerRole(Integer managerId, Integer roleId) throws Exception {
        managerMapper.insertIntoManagerRole(managerId,roleId);
    }

    @Override
    public void updateManagerRoleByRoleId(Integer managerId, Integer roleId) throws Exception {
        managerMapper.updateManagerRoleByRoleId(managerId,roleId);
    }

    @Override
    public void deleteRoleIdByManagerIds(List<Integer> ids) throws Exception {
        managerMapper.deleteRoleIdByManagerIds(ids);
    }
}
