package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.*;
import com.zhdtedu.system.dao.mapper.UserDepartmentMapper;
import com.zhdtedu.system.dao.mapper.UserMapper;
import com.zhdtedu.system.dao.mapper.UserRoleMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserDepartmentMapper userDepartmentMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public List<User> getUserList(int departId, int pageNo, int pageSize) {
		List<User> userList = userMapper.selectByExample2(departId, pageNo, pageSize);
		return userList;
	}

	@Override
	public int getTotalCount(int id) {
		return userMapper.getTotalCount(id);
	}

	@Override
	public User getUser(int id) {
		return null;
	}

	@Override
	public RcsResult updateUser(User user) {
		try {
			userMapper.updateByPrimaryKey(user);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.ok();
	}

	@Override
	public RcsResult deleteUser(int id) {
		try {
			userMapper.deleteByUser(id);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.build(200, "删除成功", null);
	}
/*
*新增用户
 */
	@Override
	public RcsResult saveUser(User user) {
		try {
			userMapper.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return RcsResult.build(201, "新增成功", null);

	}

	@Override
	public RcsResult getNodeList() {
		List<User> userList = null;
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		try {
			userList = userMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.ok(userList);
	}

	/**
	 * 新增用户部门中间表
	 * @param userDepartment
	 * @return
	 */
	@Override
	public RcsResult userDepartmentAdd(UserDepartment userDepartment) {
		try {
			userDepartmentMapper.insert(userDepartment);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return RcsResult.build(201, "新增成功", null);

	}

	/**
	 * 删除用户部门中间表
	 * @param userId
	 * @return
	 */
	@Override
	public RcsResult userDepartmentDelete(int userId) {
		try {
			userDepartmentMapper.deleteByUserDepartment(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.build(200, "删除成功", null);
	}

	@Override
	public List<User> getUserListBy(String userName, String role,Integer departId, int pageNo, int pageSize) {
		List<User> userList = userMapper.selectByExample3(userName,role, departId,pageNo, pageSize);
		return userList;
	}

	@Override
	public int getTotalCountBy(String userName, String role,Integer departId) {
		return userMapper.getTotalCountBy(userName,role,departId);
	}

	@Override
	public User login(String account, String password) {
		return userMapper.login(account,password);
	}
	@Override
	public RcsResult userRoleAdd(UserRole userRole) {
		try {
			userRoleMapper.insert(userRole);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return RcsResult.build(201, "新增成功", null);

	}

	@Override
	public RcsResult userRoleDelete(int userId) {
		try {
			userRoleMapper.deleteByUserRole(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.build(200, "删除成功", null);
	}

	@Override
	public List<Role> findRoleByUid(Integer userId) {
		return userMapper.findRoleByUid(userId);
	}
	//账户是否存在
	@Override
	 public User getByAccount(String account){
		return userMapper.getByAccount(account);
	 }


}

