package com.zhdtedu.system.dao.entity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Table(name = "sys_users")
public class User implements Serializable {
    @ApiModelProperty(value = "用户id，自动生成")
    @Column(name = "USER_ID_", type = MySqlTypeConstant.INT, length = 11, isKey = true, isAutoIncrement = true)
    private Integer userId;
    //名称
    @ApiModelProperty(value = "名称")
    @Column(name = "USER_NAME_", type = MySqlTypeConstant.VARCHAR, length = 111)
private String userName;
//电话号码
@ApiModelProperty(value = "电话号码")
@Column(name = "TELEPHONE_", type = MySqlTypeConstant.VARCHAR, length = 111)
private String telephone;
//邮箱
@ApiModelProperty(value = "邮箱")
@Column(name = "MAILBOX_", type = MySqlTypeConstant.VARCHAR, length = 111)
private String mailbox;
//职务
/*@ApiModelProperty(value = "职务")
@Column(name = "ROLE_", type = MySqlTypeConstant.VARCHAR, length = 111)
private String role;*/
//邮箱
@ApiModelProperty(value = "账号")
@Column(name = "ACCOUNT_", type = MySqlTypeConstant.VARCHAR, length = 111)
private String account;
//职务
@ApiModelProperty(value = "密码")
@Column(name = "PASSWORD_", type = MySqlTypeConstant.VARCHAR, length = 111)
private String password;
//是否启用 1代表启用 0代表不启用
@ApiModelProperty(value = "是否启用 1代表启用 0代表不启用")
@Column(name = "USER_STATUS_", type = MySqlTypeConstant.INT, length = 111)
private Integer userStatus;
    /*@ApiModelProperty(value = "验证令牌")
    @Column(name = "AVAILABLE_", type = MySqlTypeConstant.VARCHAR)
    private Boolean available;*/
//记住角色
private List<Role> roles = new ArrayList<>();
private List<Department> departments = new ArrayList<>();


    /*public User(String account, String password, Boolean available) {
        this.account = account;
        this.password = password;
        this.available = available;
    }*/

public Integer getUserId() {
        return userId;
        }

public void setUserId(Integer userId) {
        this.userId = userId;
        }

public String getUserName() {
        return userName;
        }

public void setUserName(String userName) {
        this.userName = userName;
        }

public String getTelephone() {
        return telephone;
        }

public void setTelephone(String telephone) {
        this.telephone = telephone;
        }

public String getMailbox() {
        return mailbox;
        }

public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
        }

/*public String getRole() {
        return role;
        }

public void setRole(String role) {
        this.role = role;
        }*/

public String getAccount() {
        return account;
        }

public void setAccount(String account) {
        this.account = account;
        }

public String getPassword() {
        return password;
        }

public void setPassword(String password) {
        this.password = password;
        }

public Integer getUserStatus() {
        return userStatus;
        }

public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
        }

public List<Role> getRoles() {
        return roles;
        }

public void setRoles(List<Role> roles) {
        this.roles = roles;
        }

public List<Department> getDepartments() {
        return departments;
        }

public void setDepartments(List<Department> departments) {
        this.departments = departments;
        }

        @Override
        public String toString() {
                return "User{" +
                        "userId=" + userId +
                        ", userName='" + userName + '\'' +
                        ", telephone='" + telephone + '\'' +
                        ", mailbox='" + mailbox + '\'' +
                        ", account='" + account + '\'' +
                        ", password='" + password + '\'' +
                        ", userStatus=" + userStatus +
                        ", roles=" + roles +
                        ", departments=" + departments +
                        '}';
        }
}
