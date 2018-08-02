package tsxy.bsjz.platform.manager.common.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


import tsxy.bsjz.platform.model.Manager;
import tsxy.bsjz.platform.model.Power;
import tsxy.bsjz.platform.model.Role;
import tsxy.bsjz.platform.service.ManagerService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * @author 姜哲
 * @version  
 * 
 */
public class ManagerRealm extends AuthorizingRealm{
    
    @Autowired
    private ManagerService managerService;
    
    @Override
    // doGetAuthorizationInfo()方法可以理解为是权限验证，
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String currentLoginName = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Manager manager = managerService.selectManagerByUserName(currentLoginName);
        if (manager != null) {
            Role role = manager.getRole();
            Set<String> roleCode = new HashSet<String>();
            roleCode.add(role.getRoleCode());
            // 将角色标识提供给info
            authorizationInfo.setRoles(roleCode);

            List<Power> powerList = role.getPowerList();
            Set<String> powerCode = new HashSet<String>();
            for (Power power:powerList){
                powerCode.add(power.getPowerCode());
            }
            // 将权限标识提供给info
            authorizationInfo.setStringPermissions(powerCode);
        }else{
            throw new AuthorizationException();
        }
        return authorizationInfo;
    }

    @Override
    // doGetAuthenticationInfo(  AuthenticationToken token)  理解为登陆验证。
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        String userName = (String) authcToken.getPrincipal();
        Manager manager = managerService.selectManagerByUserName(userName);
        if (manager == null) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                manager.getUserName(), manager.getPassword(), getName());
        return authenticationInfo;
    }

}
