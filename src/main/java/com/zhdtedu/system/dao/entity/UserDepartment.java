package com.zhdtedu.system.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Table(name = "sys_user_department")
public class UserDepartment {
    @ApiModelProperty(value = "部门用户，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private  int id;
    @ApiModelProperty(value = "用户id")
    @Column(name = "USER_ID_",type = MySqlTypeConstant.INT,length = 11)
    private  int userId;
    @ApiModelProperty(value = "部门id")
    @Column(name = "DEPT_ID_",type = MySqlTypeConstant.INT,length = 11)
    private  int deptId;

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

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
