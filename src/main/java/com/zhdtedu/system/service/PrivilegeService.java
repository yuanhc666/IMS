package com.zhdtedu.system.service;


import com.zhdtedu.system.dao.entity.Department;
import com.zhdtedu.system.dao.entity.Privilege;
import com.zhdtedu.system.dao.entity.RolePrivilege;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.util.RcsResult;

import java.util.List;

public interface PrivilegeService {
	//获取权限数据列表
	/*List<Privilege> getPrivilegeList(int pageNo, int pageSize);*/
	//获取总记录数
	int  getTotalCount();
	//根据id获取基础数据
	Privilege getPrivilege(int id);
	//修改数据保存
	RcsResult updatePrivilege(Privilege privilege);
	//根据id删除数据
	RcsResult   deletePrivilege(int id);
	//根据传入的记录保存
	RcsResult  savePrivilege(Privilege privilege);
	//获取动态树
	RcsResult  getNodeList();
	//添加角色权限
	RcsResult rolePrivilegeAdd(RolePrivilege rolePrivilege);
	//根据权限删除权限部门
	RcsResult rolePrivilegeDelete(int privilegeId);
	//	根据 角色id查询权限
	List<Privilege> findPrigByRid(Integer roleId);
	//获取角色权限数据列表
	List<Privilege> getPrivilegeListBy( Integer roleId, int pageNo, int pageSize);
	//获取总记录数
	int  getTotalCountBy(Integer roleId);
	//获取角色权限数据列表
	List<Privilege> getPrivilegeListBy( Integer roleId);
	//根据父级id查询
	public List<Privilege> getPrivilList(Integer partId);

}

