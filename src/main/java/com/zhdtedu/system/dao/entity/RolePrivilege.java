package com.zhdtedu.system.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
@Table(name = "sys_role_privilege")
public class RolePrivilege {
    @ApiModelProperty(value = "角色权限id，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private  int id;
    @ApiModelProperty(value = "权限id")
    @Column(name = "PRIVILEGE_ID_",type = MySqlTypeConstant.INT,length = 11)
    private  int privilegeId;
    @ApiModelProperty(value = "角色id")
    @Column(name = "ROLE_ID_",type = MySqlTypeConstant.INT,length = 11)
    private  int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(int privilegeId) {
        this.privilegeId = privilegeId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
