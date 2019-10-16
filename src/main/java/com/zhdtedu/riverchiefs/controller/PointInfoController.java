package com.zhdtedu.riverchiefs.controller;


import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.dao.entity.PointInfo;
import com.zhdtedu.riverchiefs.service.PointInfoService;
import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
public class PointInfoController {

    @Autowired
    private PointInfoService pointInfoService;
    /**
     * 获取监测点列表
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取监测点数据列表", notes = "根据编码和名称，索引页pageIndex获取数据列表")
    @GetMapping("/points")
    public RcsResult getPointInfoList(@ApiParam( name="code", value="编码") @RequestParam(value="code",required = false) String code,
                                      @ApiParam( name="name", value="名称") @RequestParam(value="name",required = false) String name,
                                      @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=false,defaultValue="1") Long pageIndex) {
        return   pointInfoService.getPointInfoList(code,name,pageIndex.intValue());
    }


    /**
     * 新增监测点信息
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "新增监测点信息", notes = "新增监测点信息")
    @PostMapping(value="/points",produces = "application/json;charset=utf-8")
    public RcsResult savePoint( @RequestBody PointInfo pointInfo) {
        RcsResult result = pointInfoService.savePointInfo(pointInfo);
        return result;
    }

    /**
     * 通过id获取监测点信息
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "通过id获取监测点信息", notes = "通过id获取监测点信息")
    @GetMapping("/points/{id}")
    public RcsResult getPointInfoById(@ApiParam(required =true, name="id", value="监测点id") @PathVariable("id") Long id){
        return      pointInfoService.getPointInfoById(id);
    }


    /**
     * 获取前端表单的数据后台更新
     * @return
     */
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "更新监测点信息", notes = "获取监测点记录并更新监测点信息")
    @ApiImplicitParam(name = "pointInfo", value = "pointInfo", required = true, dataType = "PointInfo")
    @PutMapping("/points")
    public RcsResult updateBasin(@RequestBody PointInfo pointInfo){
        return      pointInfoService.updatePointInfo(pointInfo);
    }


    /**
     * 根据流域编码删除数据
     */

    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "删除流域数据", notes = "根据流域id删除数据")
    @DeleteMapping("/points/{id}")
    public RcsResult deleteContent(@ApiParam(required =true, name="id", value="流域节点id") @PathVariable("id") long id){
        RcsResult result= pointInfoService.deletePointInfoById(id);
        return  result;
    }



    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取所有的监测点", notes = "根获取所有的监测点数据列表")
    @GetMapping("/points/datas")
    public RcsResult getAllList() {
        return   pointInfoService.getAllList();

    }











}


