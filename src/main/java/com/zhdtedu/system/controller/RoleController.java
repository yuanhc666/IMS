package com.zhdtedu.system.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.system.dao.entity.Privilege;
import com.zhdtedu.system.dao.entity.Role;
import com.zhdtedu.system.dao.entity.RolePrivilege;
import com.zhdtedu.system.dao.entity.UserDepartment;
import com.zhdtedu.system.service.PrivilegeService;
import com.zhdtedu.system.service.RoleService;
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
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PrivilegeService privilegeService;

    /**
     * 获取角色列表
     *
     *params:名称RoleName，职务role
     *
     *
     */
    //@ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取角色列表", notes = "获取数据列表")
    @GetMapping("/roles")
    public RcsResult getRoleByList() {
        List<Role> RoleList =null;
        int totalCount= roleService.getTotalCount();
        if(totalCount>0){
            try {
                RoleList = roleService.getRoleList();
            }catch (Exception e){
                e.printStackTrace();
                return  RcsResult.build(500, e.getMessage());
            }
            return  RcsResult.ok(RoleList);
        }else {
            return RcsResult.build(200, "没有角色，请重新输入！", null);
        }
    }
/**
     * 新增角色数据
     * params：获取选中的parentId
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "新增角色数据", notes = "新增角色数据")
    @ApiImplicitParam(name = "role", value = "Role", required = true, dataType = "Role")
    @PostMapping("/roles")
    public RcsResult saveRole( @RequestBody Role role,Integer []prigId){
        RcsResult result=roleService.saveRole(role);
        System.out.println(role.getRoleId());
        System.out.println(prigId.length);
        RolePrivilege rolePrivilege=new RolePrivilege();
        for (Integer rid : prigId) {
            rolePrivilege.setRoleId(role.getRoleId());
            rolePrivilege.setPrivilegeId(rid);
            privilegeService.rolePrivilegeAdd(rolePrivilege);
        }
        return  result;
    }
    /**
     * 赋值权限
     * params：获取选中的parentId
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "赋值权限", notes = "赋值权限")
    @PostMapping("/roleprigs")
    public RcsResult saveRolePrig(@RequestBody Role  role,int []prigId){
        /*Role role = roleService.getRole(role.getRoleId());*/
        RolePrivilege rolePrivilege=new RolePrivilege();
        for (Integer rid : prigId) {
            rolePrivilege.setRoleId(role.getRoleId());
            rolePrivilege.setPrivilegeId(rid);
            privilegeService.rolePrivilegeAdd(rolePrivilege);
        }
        return  RcsResult.ok(rolePrivilege);
    }


/**
     * 删除角色数据
     * params:id
     */
  //  @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "删除角色,角色权限数据", notes = "删除角色，角色权限数据")
    @DeleteMapping("/roles/{id}")
    public RcsResult deleteRole(@ApiParam(required =true, name="id", value="节点id") @PathVariable("id") int id){
        roleService.deleteRole(id);
        roleService.rolePrivilegeDelete(id);
        return RcsResult.build(200, "删除成功！", null);
    }
    /*
     * 修改角色保存的信息
     * 更新表单中的信息
     * @RequestBody将json数据转化为对应的实体
     */
  // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "修改角色后保存", notes = "根据节点id更新数据")
    @PutMapping("/roles")
    public  RcsResult   modifyRole( @RequestBody Role  role,Integer[] prigId){
        //删除角色
        RcsResult result= roleService.updateRole(role);
        //查询角色权限的中间表
       List<Privilege> prigByRid = privilegeService.findPrigByRid(role.getRoleId());
       //循环删除中间表
       for (int i = 0; i <=prigByRid.size(); i++) {
           roleService.rolePrivilegeDelete(role.getRoleId());
       }
       //添加中间表
       if(prigId.length>0) {
           RolePrivilege rolePrivilege = new RolePrivilege();
           for (Integer rid : prigId) {
               rolePrivilege.setRoleId(role.getRoleId());
               rolePrivilege.setPrivilegeId(rid);
               privilegeService.rolePrivilegeAdd(rolePrivilege);
           }
       }
        return  result;
    }
    /**
     * 获取动态树节点
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取动态树", notes = "获取动态树")
    @GetMapping("/roles/nodes")
    public RcsResult getNodeList( ){
        RcsResult result= roleService.getNodeList();
        return  result;
    }



}


