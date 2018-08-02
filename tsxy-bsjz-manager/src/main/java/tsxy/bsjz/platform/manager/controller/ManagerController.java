package tsxy.bsjz.platform.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tsxy.bsjz.platform.dao.vo.ManagerSearchDto;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Role;
import tsxy.bsjz.platform.service.ManagerService;
import tsxy.bsjz.platform.service.RoleService;
import tsxy.bsjz.platform.utils.PageBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 姜哲 on 2018/2/8--15:27
 */
@RestController
@RequestMapping("myManager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private RoleService roleService;

    //增加管理员
    @RequestMapping("/insertIntoManager")
    public HashMap<String, Object> insertIntoManager(Manager manager) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.insertIntoManager(manager);
        return result;
    }

    //批量删除管理员
    @RequestMapping("/deleteManagerByIds")
    public HashMap<String, Object> deleteManagerByIds(Integer[] ids) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.deleteManagerByIds(Arrays.asList(ids));
        return result;
    }

    //修改管理员信息
    @RequestMapping("/updateManager")
    public HashMap<String, Object> updateManager(Manager manager) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.updateManager(manager);
        return result;
    }


    //查询全部管理员信息
    @RequestMapping("/selectAllManager")
    public HashMap<String, Object> selectAllManager(ManagerSearchDto managerSearchDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        PageBean<Manager> pageData =  managerService.selectAllManager(managerSearchDto);
        //总条数
        Integer totalNum = pageData.getTotalNum();
        //总页数
        Integer totalPage = pageData.getTotalPage();
        //结果集
        List<Manager> managerList = pageData.getItems();
        result.put("totalNum", totalNum);
        result.put("totalPage", totalPage);
        result.put("managerList", managerList);
        return result;
    }

    //查询此管理员的分配角色信息
    @RequestMapping("/selectRoleByManagerId")
    public HashMap<String, Object> selectRoleByManagerId(Integer managerId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Integer roleId = managerService.selectRoleIdByManagerId(managerId);
        List<Role> roleList = roleService.selectAllRole();
        result.put("roleId",roleId);
        result.put("roleList",roleList);
        return result;
    }

    //更改此管理员的角色
    @RequestMapping("/updateManagerRoleByRoleId")
    public HashMap<String, Object> updateManagerRoleByRoleId(Integer managerId,Integer roleId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.updateManagerRoleByRoleId(managerId,roleId);
        return result;
    }
}
