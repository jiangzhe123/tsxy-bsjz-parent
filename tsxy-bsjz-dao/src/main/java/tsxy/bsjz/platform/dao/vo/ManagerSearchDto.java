package tsxy.bsjz.platform.dao.vo;

import java.io.Serializable;

/**
 * Created by 姜哲 on 2018/2/8--11:02
 */
public class ManagerSearchDto extends PageHelpDto implements Serializable{

    private String userName;

    private String realName;

    private String phone;

    private String orderByClause;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
}
