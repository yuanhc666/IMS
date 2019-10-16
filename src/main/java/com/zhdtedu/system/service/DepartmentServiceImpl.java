package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.Department;
import com.zhdtedu.system.dao.entity.DepartmentExample;
import com.zhdtedu.system.dao.entity.UserExample;
import com.zhdtedu.system.dao.mapper.DepartmentMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;


	@Override
	public List<Department> getDepartmentList(int partId) {
		List<Department> departments = departmentMapper.selectByList(partId);
		return departments;
	}

	@Override
	public int getTotalCount(int partId) {
		return departmentMapper.getTotalCount(partId);

	}

	@Override
	public Department getDepartment(int id) {
		return null;
	}

	@Override
	public RcsResult updateDepartment(Department department) {
		try {
			departmentMapper.updateByPrimaryKey(department);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.ok();
	}

	@Override
	public RcsResult deleteDepartment(int id) {
		try {
			departmentMapper.deleteByDepartment(id);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, e.getMessage());
		}
		return RcsResult.build(200, "删除成功", null);
	}

	@Override
	public RcsResult saveDepartment(Department department) {
		try {
			departmentMapper.insert(department);
		} catch (Exception e) {
			e.printStackTrace();
			return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return RcsResult.build(201, "新增成功", null);
	}

	@Override
	public RcsResult getNodeList() {
        List<Department> departmentList = null;
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        try {
            departmentList = departmentMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.ok(departmentList);
	}

    @Override
    public List<Department> findDeptByUid(Integer userId) {
        List<Department> departments = departmentMapper.findDeptByUid(userId);
        return departments;
    }
}

