package com.zhdtedu.system.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "sys_privilege")
public class Privilege implements Serializable {
    @ApiModelProperty(value = "权限id，自动生成")
    @Column(name = "PRIVILEGE_ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int privilegeId;
    @ApiModelProperty(value = "名称")
    @Column(name = "PRIVILEGE_NAME_",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String privilegeName;
    @ApiModelProperty(value = "地址")
    @Column(name = "URL_",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String url;
    @ApiModelProperty(value = "父级ID")
    @Column(name = "PART_ID_",type = MySqlTypeConstant.INT,length = 11)
    private int partId;
    private List<Role>roles=new ArrayList<>();
    public int getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(int privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilegeId=" + privilegeId +
                ", privilegeName='" + privilegeName + '\'' +
                ", url='" + url + '\'' +
                ", partId=" + partId +
                ", roles=" + roles +
                '}';
    }
}
