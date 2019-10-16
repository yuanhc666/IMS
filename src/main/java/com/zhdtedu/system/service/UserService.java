package com.zhdtedu.system.service;


import com.zhdtedu.system.dao.entity.*;
import com.zhdtedu.util.RcsResult;

import java.util.List;

public interface UserService {
	//获取用户数据列表
	List<User> getUserList(int departId, int pageNo, int pageSize);
	//获取总记录数
	int  getTotalCount(int parentId);
	//根据id获取基础数据
	User getUser(int id);
	//修改数据保存
	RcsResult updateUser(User user);
	//根据id删除数据
	RcsResult   deleteUser(int id);
	//根据传入的记录保存
	RcsResult  saveUser(User user);
	//获取动态树
	RcsResult  getNodeList();
	//添加用户部门
	RcsResult userDepartmentAdd(UserDepartment userDepartment);
	//根据用户删除用户部门
	RcsResult userDepartmentDelete(int userId);
	//获取用户数据列表
	List<User> getUserListBy(String userName,String role,Integer departId, int pageNo, int pageSize);
	//获取总记录数
	int  getTotalCountBy(String userName,String role,Integer departId);
	//登录账户
	User login(String account,String password);
	//添加用户角色
	RcsResult userRoleAdd(UserRole userRole);
	//根据用户删除用户角色
	RcsResult userRoleDelete(int userId);
	//	根据 用户id查询角色
	List<Role> findRoleByUid(Integer userId);
	//账户是否存在
	User getByAccount(String account);
}

