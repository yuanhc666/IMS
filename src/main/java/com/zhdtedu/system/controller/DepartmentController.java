package com.zhdtedu.system.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.system.dao.entity.Department;
import com.zhdtedu.system.service.DepartmentService;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
//@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    int  currentPageNo=0;
    int  pageSize=10;
    int totalCount=0;
    /*
     * 新增部门数据
     * params：获取选中的parentId
    */
    //@ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "新增部门数据", notes = "新增部门数据")
    @ApiImplicitParam(name = "department", value = "Department", required = true, dataType = "Department")
    @PostMapping("/departments")
    public RcsResult saveBaseData(@RequestBody Department department){
        RcsResult result= departmentService.saveDepartment(department);
        return  result;
    }

    /*
     * 删除用户数据
     * params:id
    */
    //@ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "删除部门数据", notes = "删除部门数据")
    @DeleteMapping("/departments/{id}")
    public RcsResult deleteDepartment(@ApiParam(required =true, name="id", value="节点id") @PathVariable("id") int id){
        RcsResult result= departmentService.deleteDepartment(id);
        return  result;
    }
    /*
     * 修改部门数据保存的信息
     * 更新表单中的信息
     * @RequestBody将json数据转化为对应的实体
    */
    //@ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "修改部门数据后保存", notes = "根据节点id更新数据")
    @PutMapping("/departments")
    public  RcsResult   modifyDepartment( @RequestBody Department  department){
        RcsResult result= departmentService.updateDepartment(department);
        return  result;
    }
    /*
     * 获取基础数据列表
     *
     *params:partId父节点的id
     *Department
     */
    //@ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取数据列表", notes = "根据父类partId，索引页pageIndex获取数据列表")
    @GetMapping("/departments")
    public RcsResult getDepartmentList( @ApiParam( name="partId", value="父类id") @RequestParam(value="partId",required = false) Integer partId) {
        List<Department> departmentList =null;
        System.out.println(partId);
        int id=departmentService.getTotalCount(partId);
        System.out.println("输出"+id);
        if(id>0){
            departmentList = departmentService.getDepartmentList(partId);
        }else {
            return RcsResult.build(200, "没有该部门，请重新输入！", null);
        }
        return  RcsResult.ok(departmentList);
    }

    /**
     * 获取动态树节点
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取动态树", notes = "获取动态树")
    @GetMapping("/departments/nodes")
    public RcsResult getNodeList( ){
        RcsResult result= departmentService.getNodeList();
        return  result;
    }
}
