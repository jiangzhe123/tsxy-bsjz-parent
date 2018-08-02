package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.RoleSearchDto;
import tsxy.bsjz.platform.model.Power;
import tsxy.bsjz.platform.model.Role;
import tsxy.bsjz.platform.service.PowerService;
import tsxy.bsjz.platform.service.RoleService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/3/1--10:48
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PowerService powerService;

    //增加角色
    @RequestMapping("/insertIntoRole")
    public HashMap<String, Object> insertIntoRole(Role role){
        HashMap<String, Object> result = new HashMap<String, Object>();
        roleService.insertIntoRole(role);
        return result;
    }

    //批量删除角色
    @RequestMapping("/deleteRoleByIds")
    public HashMap<String, Object> deleteRoleByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        roleService.deleteRoleByIds(Arrays.asList(ids));
        return result;
    }

    //修改角色
    @RequestMapping("/updateRole")
    public HashMap<String, Object> updateRole(Role role){
        HashMap<String, Object> result = new HashMap<String, Object>();
        roleService.updateRole(role);
        return result;
    }

    //查询全部角色信息
    @RequestMapping("/selectAllRole")
    public HashMap<String, Object> selectAllRole(RoleSearchDto roleSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Role> roleList = roleService.selectAllRole(roleSearchDto);
        result.put("data",roleList);
        return result;
    }

    //分配权限给角色之查询权限 并且选中此角色已有权限们
    @RequestMapping("/selectPowerIdsByRoleId")
    public HashMap<String, Object> selectPowerIdsByRoleId(Integer roleId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<Integer> powerIds = roleService.selectPowerIdsByRoleId(roleId);
        List<Power> powerList = powerService.selectAllPower();
        result.put("powerIds",powerIds);
        result.put("powerList",powerList);
        return result;
    }

    //分配权限给角色之增加 ，提交权限 角色和权限一对多
    @RequestMapping("/insertIntoRoleAndPower")
    public HashMap<String, Object> insertIntoRoleAndPower(Integer roleId, Integer[] powerIds) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        if(powerIds.length>0){
            roleService.insertIntoRoleAndPower(roleId,Arrays.asList(powerIds));
        }
        return result;
    }

}
