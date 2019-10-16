package com.zhdtedu.riverchiefs.controller;


import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.riverchiefs.service.BasinInfoService;
import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
public class BasinInfoController  {

    @Autowired
    private BasinInfoService basinInfoService;
    /**
     * 获取流域列表
     */

    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取数据列表", notes = "根据父类parentId，索引页pageIndex获取数据列表")
    @GetMapping("/basins")
    public RcsResult getBasinList(@ApiParam( name="parentId", value="上级流域id") @RequestParam(value="parentId",required = false) Long parentId,
                                  @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=false,defaultValue="1") Long pageIndex) {
        return basinInfoService.getBasinList(parentId,pageIndex.intValue());
    }


    /**
     * 新增流域信息
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "新增流域信息", notes = "新增流域信息")
    /*@ApiImplicitParam(name = "tbBasin", value = "BasinInfo", required = true, dataType = "BasinInfo")*/
    @PostMapping(value="/basins",produces = "application/json;charset=utf-8")
    public RcsResult saveBasin( @RequestBody BasinInfo tbBasin) {
        System.out.println("tbBasin"+tbBasin.getType());
        RcsResult result = basinInfoService.saveBasin(tbBasin);
        return result;
    }

    /**
     * 通过id获取流域信息
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "通过id获取流域信息", notes = "通过流域编码id获取流域信息")
    @GetMapping(value="/basins/{id}",produces = "application/json;charset=utf-8")
    public RcsResult getBasinById(@ApiParam(required =true, name="id", value="流域信息id") @PathVariable("id") Long id){
        return      basinInfoService.getBasinById(id);
    }


    /**
     * 获取前端表单的数据后台更新
     * @return
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "更新流域信息", notes = "获取修改信息对象更新")
    @ApiImplicitParam(name = "tbBasin", value = "BasinInfo", required = true, dataType = "BasinInfo")
    @PutMapping("/basins")
    public RcsResult updateBasin(@RequestBody BasinInfo tbBasin){
        return      basinInfoService.updateBasin(tbBasin);
    }


    /**
     * 根据流域编码删除数据
     */

    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "删除流域数据", notes = "根据流域id删除数据")
    @DeleteMapping("/basins/{id}")
    public RcsResult deleteContent(@ApiParam(required =true, name="id", value="流域节点id") @PathVariable("id") long id){
        RcsResult result= basinInfoService.deleteBasinById(id);
        return  result;
    }

    /**
     * 获取动态树节点
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取动态树", notes = "获取动态树")
    @GetMapping("/basins/nodes")
    public RcsResult getBasinNodeList(@ApiParam( name="parentId", value="流域父节点id")
                                      @RequestParam(value="parentId",required = false,defaultValue = "0") Long parentId ){
        List nodeList=new ArrayList();
        try {
             nodeList = basinInfoService.getBasinNodeList(parentId);

        }catch (Exception e){
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());

        }
        return RcsResult.ok(nodeList);
    }






}


