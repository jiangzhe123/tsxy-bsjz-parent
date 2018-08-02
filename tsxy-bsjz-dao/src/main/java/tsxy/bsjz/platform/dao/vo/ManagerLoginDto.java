package tsxy.bsjz.platform.dao.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by 姜哲 on 2018/2/8--14:01
 */
public class ManagerLoginDto implements Serializable{

    @NotBlank(message="用户名不能为空")
    @Length(min=5,max=15,message="账号在5-15字符之间")
    private String userName;

    @NotBlank(message="密码不能为空")
    @Length(min=5,max=15,message="密码在5-15字符之间")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
