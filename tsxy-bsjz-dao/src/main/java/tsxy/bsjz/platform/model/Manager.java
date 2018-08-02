package tsxy.bsjz.platform.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import tsxy.bsjz.platform.utils.StringUtil;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class Manager {

    private Integer id;

    @NotBlank(message="用户名不能为空")
    @Length(max=20,min=5,message="用户名长度在5-20之间")
    private String userName;

    @NotBlank(message="密码不能为空")
    @Length(max=20,min=5,message="密码长度在5-40之间")
    private String password;

    private String realName;
    @NotBlank(message="电话号码不能为空")
    @Pattern(regexp="^1[3|4|5|7|8][0-9]\\d{8}$",message="请输入正确的手机号")
    private String phone;

    private Date createDate;

    private Date lastLoginDate;

    //管理员和角色 一对一
    private Role role;

    //转化时间前台显示
    private String createDateStr;

    private String lastLoginDateStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateDateStr() {
        if(null != createDate){
            return StringUtil.dateToString(createDate);
        }
        return "";
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginDateStr() {
        if(null != lastLoginDate){
            return StringUtil.dateToString(lastLoginDate);
        }
        return "";
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}