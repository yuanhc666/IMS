package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.*;
import com.zhdtedu.system.dao.mapper.RoleMapper;
import com.zhdtedu.system.dao.mapper.RolePrivilegeMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePrivilegeMapper rolePrivilegeMapper;


    @Override
    public List<Role> getRoleList() {
        List<Role> RoleList = roleMapper.selectByExample2();
        return RoleList;
    }

    @Override
    public int getTotalCount() {
        return roleMapper.getTotalCount();
    }

    @Override
    public Role getRole(int id) {
        return roleMapper.getRole(id);
    }

    @Override
    public RcsResult updateRole(Role role) {
        try {
            roleMapper.updateByPrimaryKey(role);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.ok();
    }

    @Override
    public RcsResult deleteRole(int id) {
        try {
            roleMapper.deleteByRole(id);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.build(200, "删除成功", null);
    }

    @Override
    public RcsResult saveRole(Role role) {
        try {
            roleMapper.insert(role);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
        }

        return RcsResult.build(201, "新增成功", null);

    }

    @Override
    public RcsResult getNodeList() {
        List<Role> RoleList = null;
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        try {
            RoleList = roleMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.ok(RoleList);
    }

    @Override
    public RcsResult rolePrivilegeAdd(RolePrivilege rolePrivilege) {
        try {
            rolePrivilegeMapper.insert(rolePrivilege);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
        }

        return RcsResult.build(201, "新增成功", null);

    }

    @Override
    public RcsResult rolePrivilegeDelete(int roleId) {
        try {
            rolePrivilegeMapper.deleteByRolePrivilege(roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.build(200, "删除成功", null);
    }







}
