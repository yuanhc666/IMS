package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.Department;
import com.zhdtedu.system.dao.entity.Privilege;
import com.zhdtedu.system.dao.entity.PrivilegeExample;
import com.zhdtedu.system.dao.entity.RolePrivilege;
import com.zhdtedu.system.dao.mapper.PrivilegeMapper;
import com.zhdtedu.system.dao.mapper.RolePrivilegeMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	@Autowired
	private PrivilegeMapper privilegeMapper;
	@Autowired
	private RolePrivilegeMapper rolePrivilegeMapper;

	/*@Override
	public List<Privilege> getPrivilegeList(Integer partId) {
		List<Privilege> PrivilegeList = privilegeMapper.selectByExample2(partId);
		return PrivilegeList;
	}*/

	@Override
	public int getTotalCount() {
		return privilegeMapper.getTotalCount();
	}

	@Override
	public Privilege getPrivilege(int id) {
		return null;
	}

	@Override
	public RcsResult updatePrivilege(Privilege Privilege) {
		try {
			privilegeMapper.updateByPrimaryKey(Privilege);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.ok();
	}

	@Override
	public RcsResult deletePrivilege(int id) {
		try {
			privilegeMapper.deleteByPrivilege(id);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.build(200, "删除成功", null);
	}

	@Override
	public RcsResult savePrivilege(Privilege Privilege) {
		try {
			privilegeMapper.insert(Privilege);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return RcsResult.build(201, "新增成功", null);

	}

	@Override
	public RcsResult getNodeList() {
		List<Privilege> privilegeList = null;
		PrivilegeExample example = new PrivilegeExample();
		PrivilegeExample.Criteria criteria = example.createCriteria();
		try {
			privilegeList = privilegeMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.ok(privilegeList);
	}

	@Override
	public RcsResult rolePrivilegeAdd(RolePrivilege rolePrivilege){
		try {
			rolePrivilegeMapper.insert(rolePrivilege);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return RcsResult.build(201, "新增成功", null);

	}

	@Override
	public RcsResult rolePrivilegeDelete(int privilegeId) {
		try {
			rolePrivilegeMapper.deleteByRolePrivilege(privilegeId);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.build(200, "删除成功", null);
	}

	@Override
	public List<Privilege> findPrigByRid(Integer roleId) {
		return privilegeMapper.findPrigByRid(roleId);
	}

	@Override
	public List<Privilege> getPrivilegeListBy(Integer roleId, int pageNo, int pageSize) {
		return privilegeMapper.selectByExample3(roleId,pageNo,pageSize);
	}

	@Override
	public int getTotalCountBy(Integer roleId) {
		return privilegeMapper.getTotalCountBy(roleId);
	}

	@Override
	public List<Privilege> getPrivilegeListBy(Integer roleId) {
		return privilegeMapper.selectByExample4(roleId);
	}
	@Override
	public List<Privilege> getPrivilList(Integer partId) {
		List<Privilege> privileges = privilegeMapper.selectByList(partId);
		return privileges;
	}


}

