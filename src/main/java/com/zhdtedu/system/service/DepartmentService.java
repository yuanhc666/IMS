package com.zhdtedu.system.service;


import com.zhdtedu.system.dao.entity.Department;
import com.zhdtedu.util.RcsResult;

import java.util.List;

public interface DepartmentService {
	//获取部门数据列表
	List<Department> getDepartmentList(int partId);
	//获取总记录数
	int  getTotalCount(int partId);
	//根据id获取基础数据
	Department getDepartment(int id);
	//修改数据保存
	RcsResult updateDepartment(Department department);
	//根据id删除数据
	RcsResult   deleteDepartment(int id);
	//根据传入的记录保存
	RcsResult  saveDepartment(Department department);
	//获取动态树
	RcsResult  getNodeList();
	//	根据 用户id查询部门
    List<Department> findDeptByUid(Integer userId);
}

