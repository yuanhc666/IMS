package com.zhdtedu.system.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.system.dao.entity.Department;
import com.zhdtedu.system.dao.entity.Privilege;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.system.service.DepartmentService;
import com.zhdtedu.system.service.PrivilegeService;
import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.PageModel;
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
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;
    int  currentPageNo=0;
    int  pageSize=10;
    int totalCount=0;
    /**
     * 获取角色权限列表
     *
     *
     *
     */
    //@ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取角色权限列表", notes = "根据角色roleId，索引页pageIndex获取数据列表")
    @GetMapping("/rolePrivilege")
    public RcsResult getPrivilegeByList(@ApiParam( name="roleId", value="角色id") @RequestParam(value="roleId",required = false) Integer roleId,
                                    @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=false,defaultValue="1") String pageIndex) {
        List<Privilege> privilegeList =null;
        System.out.println("pageIndex"+pageIndex);
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        totalCount= privilegeService.getTotalCountBy(roleId);
        if(totalCount>0){
            PageModel pageModel=  new PageModel(currentPageNo,totalCount,pageSize);
            try {
                privilegeList = privilegeService.getPrivilegeListBy(roleId,currentPageNo,pageSize);
            }catch (Exception e){
                e.printStackTrace();
                return  RcsResult.build(500, e.getMessage());
            }
            pageModel.setList(privilegeList);
            return  RcsResult.ok(pageModel);
        }else {
            return RcsResult.build(200, "没有这个名称，请重新输入！", null);
        }
    }
    /**
     * 获取权限列表
     *
     *params:名称PrivilegeName，职务role
     *
     *
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取权限列表", notes = "根据父级ID获取数据列表")
    @GetMapping("/privileges")
    public RcsResult getPrivilegeByList( @ApiParam( name="partId", value="索引页") @RequestParam(value="partId",required=false,defaultValue="1") Integer partId) {
        List<Privilege> privilegeList = privilegeService.getPrivilList(partId);
            return  RcsResult.ok(privilegeList);
    }
/**
     * 新增权限数据
     * params：获取选中的parentId
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "新增权限部门数据", notes = "新增权限部门数据")
    @ApiImplicitParam(name = "privilege", value = "Privilege", required = true, dataType = "Privilege")
    @PostMapping("/privileges")
    public RcsResult savePrivilege( @RequestBody Privilege privilege){
        RcsResult result=privilegeService.savePrivilege(privilege);
        return  RcsResult.ok(result);
    }


/**
     * 删除权限数据
     * params:id
     */
    //@ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "删除权限数据", notes = "删除权限数据")
    @DeleteMapping("/privileges/{id}")
    public RcsResult deletePrivilege(@ApiParam(required =true, name="id", value="节点id") @PathVariable("id") int id){
        RcsResult result=privilegeService.deletePrivilege(id);
        return  result;
    }
    /*
     * 修改权限保存的信息
     * 更新表单中的信息
     * @RequestBody将json数据转化为对应的实体
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "修改权限后保存", notes = "根据节点id更新数据")
    @PutMapping("/privileges")
    public  RcsResult   modifyPrivilege( @RequestBody Privilege  privilege){
        RcsResult result= privilegeService.updatePrivilege(privilege);
        return  result;
    }
    /**
     * 获取动态树节点
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取动态树", notes = "获取动态树")
    @GetMapping("/privileges/nodes")
    public RcsResult getNodeList( ){
        RcsResult result= privilegeService.getNodeList();
        return  result;
    }

    /**
     * 根据父级id获取去权限
     * @return
     */
    @ApiOperation(value = "根据父级id获取去权限", notes = "根据父级id获取去权限")
    @GetMapping("/privileges/id")
    public RcsResult getList( @ApiParam(required =true, name="partId", value="父级id") @PathVariable("partId") Integer partId){
        List<Privilege> result= privilegeService.getPrivilList(partId);
        return RcsResult.build(200, "没有这个名称，请重新输入！", null);
    }

}


