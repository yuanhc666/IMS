package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.dao.entity.RcsCoordinateInfo;
import com.zhdtedu.riverchiefs.service.CoordinateInfoService;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


@RestController
@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
public class CoordinateInfoController extends  BaseController{

    @Resource
    private CoordinateInfoService coordinateInfoService;

    @ApiOperation(value="保存一条坐标信息", notes="保存一条坐标信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParam(name = "coordinateInfo",value = "",paramType = "form",dataType = "String")
    @ApiVersion(1)
    @PostMapping(value="/coordinate",produces = "application/json;charset=utf-8")
    public RcsResult addCoordinateInfo(@RequestBody RcsCoordinateInfo coordinateInfo){
        try{
            RcsCoordinateInfo rci = this.coordinateInfoService.add(coordinateInfo);
            return  RcsResult.ok(rci);
        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }
    }

    @ApiOperation(value="获取一条坐标信息", notes="获取一条坐标信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParam(name = "id",value = "坐标ID",dataType = "int",paramType = "path")
    @ApiVersion(1)
    @GetMapping(value="/coordinate/{id}",produces = "application/json;charset=utf-8")
    public RcsResult getCoordinateInfo(@PathVariable("id")Integer id){
        try {
            return  RcsResult.ok(this.coordinateInfoService.getRcsCoordinateInfo((id)));
        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }
    }


    @ApiOperation(value="删除一条坐标信息", notes="删除一条坐标信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParam(name = "id",value = "坐标ID",dataType = "int",paramType = "path")
    @ApiVersion(1)
    @DeleteMapping(value="/coordinate/{id}", produces = "application/json;charset=utf-8")
    public RcsResult delCoordinateInfo(@PathVariable("id")Integer id){
        try {
            this.coordinateInfoService.deleteRcsCoordinateInfo(id);
            return  RcsResult.ok();
        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }
    }
}
