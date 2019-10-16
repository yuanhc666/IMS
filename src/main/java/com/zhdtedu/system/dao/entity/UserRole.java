package com.zhdtedu.system.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
@Table(name = "sys_user_role")
public class UserRole {
    @ApiModelProperty(value = "用户角色id，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private  int id;
    @ApiModelProperty(value = "用户id")
    @Column(name = "USER_ID_",type = MySqlTypeConstant.INT,length = 11)
    private  int userId;
    @ApiModelProperty(value = "角色id")
    @Column(name = "ROLE_ID_",type = MySqlTypeConstant.INT,length = 11)
    private  int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
