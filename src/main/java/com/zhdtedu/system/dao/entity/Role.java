package com.zhdtedu.system.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "sys_roles")
public class Role implements Serializable {
    @ApiModelProperty(value = "角色id，自动生成")
    @Column(name = "ROLE_ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int roleId;
    @ApiModelProperty(value = "名称")
    @Column(name = "ROLE_NAME_",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String roleName;
    //是否启用 1代表启用 0代表不启用
    @ApiModelProperty(value = "是否启用 1代表启用 0代表不启用")
    @Column(name = "STATUS_", type = MySqlTypeConstant.INT, length = 111)
    private Integer status;
    private List<Privilege>privileges=new ArrayList<>();
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
