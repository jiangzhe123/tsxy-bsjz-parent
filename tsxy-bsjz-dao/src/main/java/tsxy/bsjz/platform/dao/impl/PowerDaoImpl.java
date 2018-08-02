package tsxy.bsjz.platform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tsxy.bsjz.platform.dao.PowerDao;
import tsxy.bsjz.platform.dao.mapper.PowerMapper;
import tsxy.bsjz.platform.dao.vo.PowerSearchDto;
import tsxy.bsjz.platform.model.Power;
import tsxy.bsjz.platform.model.PowerExample;

import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--11:32
 */
@Repository
public class PowerDaoImpl implements PowerDao {

    @Autowired
    private PowerMapper powerMapper;

    @Override
    public void insertIntoPower(Power power) throws Exception {
        powerMapper.insertSelective(power);
    }

    @Override
    public void deletePowerByIds(List<Integer> ids) throws Exception {
        PowerExample example = new PowerExample();
        PowerExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        powerMapper.deleteByExample(example);
    }

    @Override
    public void updatePower(Power power) throws Exception {
        powerMapper.updateByPrimaryKeySelective(power);
    }

    @Override
    public Power selectPowerById(Integer id) throws Exception {
        return powerMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer selectCountByExample(PowerSearchDto powerSearchDto) throws Exception {
        PowerExample example = new PowerExample();
        PowerExample.Criteria criteria = example.createCriteria();
        if(powerSearchDto.getPowerName() != null && !powerSearchDto.getPowerName().equals("")){
            criteria.andPowerNameLike("%"+powerSearchDto.getPowerName()+"%");
        }
        return (int)powerMapper.countByExample(example);
    }

    @Override
    public List<Power> selectAllPower(PowerSearchDto powerSearchDto) throws Exception {
        PowerExample example = new PowerExample();
        PowerExample.Criteria criteria = example.createCriteria();
        if(powerSearchDto.getPowerName() != null && !powerSearchDto.getPowerName().equals("")){
            criteria.andPowerNameLike("%"+powerSearchDto.getPowerName()+"%");
        }
        return powerMapper.selectByExample(example);
    }

    @Override
    public List<Power> selectAllPower() throws Exception {
        PowerExample example = new PowerExample();
        return powerMapper.selectByExample(example);
    }

    @Override
    public void insertIntoPowerRoute(Integer powerId, Integer routeId) throws Exception {
        powerMapper.insertIntoPowerRoute(powerId,routeId);
    }

    @Override
    public void updatePowerAndRoute(Integer powerId, Integer routeId) throws Exception {
        powerMapper.updatePowerAndRoute(powerId,routeId);
    }

    @Override
    public Integer selectRouteIdByPowerId(Integer powerId) throws Exception {
        return powerMapper.selectRouteIdByPowerId(powerId);
    }

    @Override
    public List<Integer> selectRoleIdWhenDelete(List<Integer> ids) throws Exception {
        return powerMapper.selectRoleIdWhenDelete(ids);
    }

}
