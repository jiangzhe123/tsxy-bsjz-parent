package tsxy.bsjz.platform.dao.vo;

import java.io.Serializable;

/**
 * Created by 姜哲 on 2018/2/8--11:17
 */
public class RoleSearchDto implements Serializable{

    private String roleName;

    private String roleCode;

    private String orderByClause;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
}
