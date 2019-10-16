package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.*;
import com.zhdtedu.util.RcsResult;

import java.util.List;

public interface RoleService {
    //获取角色数据列表
    List<Role> getRoleList();
    //获取总记录数
    int  getTotalCount();
    //根据id获取基础数据
    Role getRole(int id);
    //修改数据保存
    RcsResult updateRole(Role role);
    //根据id删除数据
    RcsResult   deleteRole(int id);
    //根据传入的记录保存
    RcsResult  saveRole(Role role);
    //获取动态树
    RcsResult  getNodeList();
    //添加角色权限
    RcsResult rolePrivilegeAdd(RolePrivilege rolePrivilege);
    //根据角色删除角色权限
    RcsResult rolePrivilegeDelete(int roleId);

}
