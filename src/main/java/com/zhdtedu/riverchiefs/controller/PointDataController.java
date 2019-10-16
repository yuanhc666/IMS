package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.riverchiefs.service.PointDataService;
import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.PageModel;
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
public class PointDataController {
    /**
     * 获取检测点数据
     */
     @Autowired
    PointDataService pointDataService;


    /**
     * 新增监测点数据信息
     */

    @ApiOperation(value = "新增监测点数据信息", notes = "新增监测点数据信息")
    @ApiImplicitParam(name = "pointData", value = "pointData", required = true, dataType = "PointData")
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @PostMapping("/pointsData/insert")
    public RcsResult insertPointData(@RequestBody PointData pointData) {
        RcsResult result = pointDataService.insert(pointData);
        return result;
    }
    /**
     * 删除监测点数据信息
     */
    @ApiOperation(value = "删除监测点数据", notes = "根据监测点id删除数据")
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @DeleteMapping("/pointsData/delete/{id}")
    public  RcsResult deletePointData(@ApiParam(required =true, name="id", value="监测点id") @PathVariable("id") int id){
        RcsResult result= pointDataService.deleteById(id);
        return  result;
    }
    /**
     * 更新监测点数据信息
     *
     */
    @ApiOperation(value = "更新监测点数据信息", notes = "获取监测点数据记录并更新监测点数据信息")
    @ApiImplicitParam(name = "pointData", value = "pointData", required = true, dataType = "PointData")
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @PutMapping("/pointsData/update")
    public RcsResult updatePointData(@RequestBody PointData pointData){
        return      pointDataService.updatePointData(pointData);
    }

    /**
     * 获取监测点数据列表
     */
    int  currentPageNo=0;
    int  pageSize=5;
    int totalCount=0;
    @ApiOperation(value = "获取监测点数据列表", notes = "根据索引页pageIndex获取数据列表")
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @GetMapping("/pointDatas")
    public RcsResult getBasinList(
            @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=true,defaultValue="1") String pageIndex,
            @ApiParam( name="name", value="监测点名") @RequestParam(value="name",required=false) String name,
            @ApiParam( name="start_time", value="开始时间") @RequestParam(value="start_time",required=false) String start_time,
            @ApiParam( name="end_time", value="结束时间") @RequestParam(value="end_time",required=false) String end_time) {

           PageModel PageModel=pointDataService.getPointDataPages(name ,start_time,end_time,pageIndex,4);
           return  RcsResult.ok(PageModel);
    }

}
