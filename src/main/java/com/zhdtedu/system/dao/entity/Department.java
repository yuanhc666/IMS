package com.zhdtedu.system.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Table(name = "sys_department")
public class Department implements Serializable {
    @ApiModelProperty(value = "部门id，自动生成")
    @Column(name = "DEPT_ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer	deptId;
    //名称
    @ApiModelProperty(value = "部门名称")
    @Column(name = "DEPT_NAME_",type = MySqlTypeConstant.VARCHAR)
    private String	deptName;
    //上级部门
    @ApiModelProperty(value = "上级部门")
    @Column(name = "PART_ID_",type = MySqlTypeConstant.INT)
    private int	partId;
    //是否启用 1代表启用 0代表不启用
    @ApiModelProperty(value = "否启用 1代表启用 0代表不启用")
    @Column(name = "STATUS_",type = MySqlTypeConstant.INT)
    private Integer	status;


    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", partId=" + partId +
                ", status=" + status +
                '}';
    }
}
