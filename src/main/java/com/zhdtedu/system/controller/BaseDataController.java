package com.zhdtedu.system.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.controller.BaseController;
import com.zhdtedu.system.dao.entity.BaseData;
import com.zhdtedu.system.service.BaseDataService;
import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.RcsResult;
import com.zhdtedu.util.SearchCondition;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据动态树增删改查等
 *
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
public class BaseDataController extends BaseController {
    @Autowired
    private BaseDataService baseDataService;


    /**
     * 获取基础数据列表
     *
     *params:parentId父节点的id
     *
     *
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取数据列表", notes = "根据父类parentId，索引页pageIndex获取数据列表",produces = "application/json;charset=utf-8")
    @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId",value = "父类id",paramType = "query",dataType = "Long"),
            @ApiImplicitParam(name = "pageNo",value = "索引页",paramType = "query",dataType = "Long"),
            @ApiImplicitParam(name = "sort",value = "排序字段",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "order",value = "排序类型（asc,desc）",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "search_condi",value = "查询条件",paramType = "query",dataType = "string")
    })
    @GetMapping("/basedatas")
    public RcsResult getBaseDataList( ) {
        SearchCondition sc = this.getSearchCondition();
        RcsResult result = baseDataService.getBaseDataList(sc);

        return  result;
    }


    /**通过id获取基础数据的信息
     *
     *
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "根据节点的id获取基础数据", notes = "根据节点的id获取基础数据")
    @GetMapping("/basedatas/{id}")
    public RcsResult  getBaseDatasById(@ApiParam(required =true, name="id", value="节点id") @PathVariable("id") Long id){
        return  baseDataService.getBaseData(id);
    }
    /**
     * 修改基础数据保存的信息
     * 更新表单中的信息
     * @RequestBody将json数据转化为对应的实体
     */
    @ApiOperation(value = "修改基础数据后保存", notes = "根据节点id更新数据")
    // @RequestMapping(value = "/baseData/modifySave", method = RequestMethod.POST)
    @PutMapping("/basedatas")
    public  RcsResult   modifyBaseData( @RequestBody BaseData baseData){
        RcsResult result= baseDataService.updateBaseData(baseData);
        return  result;

    }
    /**
     * 删除基础数据
     * params:id
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "删除基础数据", notes = "删除基础数据")
    @DeleteMapping("/basedatas/{id}")
    public RcsResult deleteBaseData(@ApiParam(required =true, name="id", value="节点id") @PathVariable("id") long id){
        RcsResult result= baseDataService.deleteBaseDataById(id);
        return  result;
    }

    /**
     * 新增基础数据
     * params：获取选中的parentId
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "新增基础数据", notes = "新增基础数据")
    @ApiImplicitParam(name = "baseData", value = "BaseData", required = true, dataType = "BaseData")
    //@RequestMapping(value = "/baseData/saveBaseData", method = RequestMethod.POST)
    @PostMapping("/basedatas")
    public RcsResult saveBaseData( @RequestBody BaseData baseData){
        RcsResult result= baseDataService.saveBaseData(baseData);
        return  result;


    }
    /**
     * 获取动态树节点
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取动态树", notes = "获取动态树")
    @GetMapping("/basedatas/nodes")
    public RcsResult getNodeList( ){
        RcsResult result= baseDataService.getNodeList();
        return  result;
    }




}
