package tsxy.bsjz.platform.manager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import tsxy.bsjz.platform.dao.vo.ManagerLoginDto;
import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.service.ManagerService;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by 姜哲 on 2018/2/8--14:47
 */
@RestController
@RequestMapping("loginAndRegist")
public class LoginController {

    @Autowired
    private ManagerService managerService;

    //登录管理员
    @RequestMapping("/loginManager")
    public HashMap<String, Object> loginManager(@ModelAttribute @Valid ManagerLoginDto managerLoginDto, BindingResult bindingResult) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.loginManager(managerLoginDto);
        Manager manager = managerService.selectCurrentManager();
        Manager manager2 = new Manager();
        manager2.setId(manager.getId());
        manager2.setRealName(manager.getRealName());
        manager2.setUserName(manager.getUserName());
        result.put("data",manager2);
        return result;
    }
    //获得当前登录的管理员
    @RequestMapping("/currentManager")
    public HashMap<String, Object> currentManager() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Manager currentManager = managerService.selectCurrentManager();
        result.put("data",currentManager);
        return result;
    }

    //注销退出登录   不想自己写方法的话 可以在 shiro配置中 加入这个路径  设置下就行  不用写
    //具体实现代码了就
    @RequestMapping("/loginOutManager")
    public HashMap<String, Object> loginOutManager() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        managerService.loginOutManager();
        return result;
    }
}
