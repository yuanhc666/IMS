package com.zhdtedu.riverchiefs.controller;


import com.github.pagehelper.PageInfo;
import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.service.RcsArchiveFlowVoService;
import com.zhdtedu.riverchiefs.service.RcsArchiveInfoService;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.util.*;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
//@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
//@RequestMapping(value="/v1",name="版本号，如：v1,v2,v3")
public class RcsArchiveFlowVoController extends BaseController{

    int  currentPageNo = 0;
    int  pageSize=5;

    RcsArchiveFlowVo rcsArchiveFlowVo;

    SearchCondition sc;

    PageInfo pageInfo;

    @Autowired
    private RcsArchiveFlowVoService rcsArchiveFlowVoService;

    @Autowired
    private RcsArchiveInfoService rcsArchiveInfoService;

    @Autowired
    private PageModel pageModel;



    @ApiOperation(value="查询案卷待办列表", notes="查询案卷待办列表")
    @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header"),
            @ApiImplicitParam(name = "X-Token",value = "用户token",paramType = "header",dataType = "String"),
            @ApiImplicitParam(name = "archNum",value = "案卷编号",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionFrom",value = "来源",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionType",value = "类型",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "suosLiuy",value = "河段",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "status",value = "状态",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "deptId",value = "处置部门",paramType = "query",dataType = "String")
    })
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @RequestMapping(value="/archive/flowVoList/{curPage}", method= RequestMethod.GET)
    public RcsResult getRcsArchiveFlowVoList(@PathVariable("curPage") String curPage) {
        //获取请求的数据
        sc = this.getSearchCondition();
        rcsArchiveFlowVo = getRcsArchiveFlowVoData(sc);
        User user = getUserInfo();
        System.out.println("=====user======"+user);
        rcsArchiveFlowVo.setOperator(String.valueOf(user.getUserId()));
        if (curPage != null) {
            try {
                currentPageNo = Integer.valueOf(curPage);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        try {
            List<RcsArchiveFlowVo> list = rcsArchiveFlowVoService.selectRcsArchiveFlowVoByCondition(currentPageNo, pageSize,rcsArchiveFlowVo);
            pageInfo = new PageInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        List<RcsArchiveFlowVo> rafList = pageInfo.getList();
        for ( RcsArchiveFlowVo rcsArchiveFlowVo:rafList) {
            rcsArchiveFlowVo.setStatus(EnumUtil.getEnumByCode(rcsArchiveFlowVo.getStatus(), RcsArchiveStatus.class).getMessage());
        }
        return RcsResult.ok(pageInfo);
    }

    @ApiOperation(value="查询已办案卷列表", notes="查询已办案卷列表")
    @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header"),
            @ApiImplicitParam(name = "archNum",value = "案卷编号",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionFrom",value = "来源",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionType",value = "类型",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "suosLiuy",value = "河段",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "status",value = "状态",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "deptId",value = "处理部门",paramType = "query",dataType = "String")
    })
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @RequestMapping(value="/archive/flowVoList/Handler/{curPage}", method= RequestMethod.GET)
    public RcsResult getRcsArchiveFlowVoHandledList(@PathVariable("curPage") String curPage) {
        System.out.println("===BX=curPage==="+curPage);
        //获取请求的数据
        sc = this.getSearchCondition();
        //将请求的数据封装成RcsArchiveFlowVo对象
        rcsArchiveFlowVo = getRcsArchiveFlowVoData(sc);



        if (curPage != null) {
            try {
                currentPageNo = Integer.valueOf(curPage);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        try {
            List<RcsArchiveFlowVo> list = rcsArchiveFlowVoService.selectRcsArchiveFlowVoHandledListByConditon(currentPageNo, pageSize,rcsArchiveFlowVo);
            pageInfo = new PageInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        List<RcsArchiveFlowVo> rafList = pageInfo.getList();
        for ( RcsArchiveFlowVo rcsArchiveFlowVo:rafList) {
            rcsArchiveFlowVo.setStatus(EnumUtil.getEnumByCode(rcsArchiveFlowVo.getStatus(), RcsArchiveStatus.class).getMessage());
        }
        return RcsResult.ok(pageInfo);
    }

    @ApiOperation(value="查询已派列表", notes="查询已派列表")
    @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header"),
            @ApiImplicitParam(name = "archNum",value = "案卷编号",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionFrom",value = "来源",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionType",value = "类型",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "suosLiuy",value = "河段",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "status",value = "状态",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "deptId",value = "处置部门",paramType = "query",dataType = "String")
    })
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @RequestMapping(value="/archive/flowVoList/dispatch/{curPage}", method= RequestMethod.GET)
    public RcsResult getRcsArchiveFlowVoDispatchedList(@PathVariable("curPage") String curPage) {
        //获取请求的数据
        sc = this.getSearchCondition();
        //将请求的数据封装成RcsArchiveFlowVo对象
        rcsArchiveFlowVo = getRcsArchiveFlowVoData(sc);

        if (curPage != null) {
            try {
                currentPageNo = Integer.valueOf(curPage);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        try {
            List<RcsArchiveFlowVo> list =  rcsArchiveFlowVoService.selectRcsArchiveFlowVoDispatchedListByConditon(currentPageNo, pageSize,rcsArchiveFlowVo);
            pageInfo = new PageInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        List<RcsArchiveFlowVo> rafList = pageInfo.getList();
        for ( RcsArchiveFlowVo rcsArchiveFlowVo:rafList) {
            rcsArchiveFlowVo.setStatus(EnumUtil.getEnumByCode(rcsArchiveFlowVo.getStatus(), RcsArchiveStatus.class).getMessage());
        }
        return RcsResult.ok(pageInfo);
    }

    @ApiOperation(value="查询所有案卷", notes="查询所有案卷")
    @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header"),
            @ApiImplicitParam(name = "archNum",value = "案卷编号",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionFrom",value = "来源",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionType",value = "类型",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "suosLiuy",value = "河段",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "status",value = "状态",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "deptId",value = "处置部门",paramType = "query",dataType = "String")
    })
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @RequestMapping(value="/archive/flowVoAllList/{curPage}", method= RequestMethod.GET)
    public RcsResult getRcsArchiveFlowVoAllList(@PathVariable("curPage") String curPage) {
        //获取请求的数据
        sc = this.getSearchCondition();
        //将请求的数据封装成RcsArchiveFlowVo对象
        rcsArchiveFlowVo = getRcsArchiveFlowVoData(sc);

        if (curPage != null) {
            try {
                currentPageNo = Integer.valueOf(curPage);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        try {
            List<RcsArchiveFlowVo> list =  rcsArchiveFlowVoService.selectRcsArchiveFlowVoAllListByConditon(currentPageNo, pageSize,rcsArchiveFlowVo);
            pageInfo = new PageInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        List<RcsArchiveFlowVo> rafList = pageInfo.getList();
        for ( RcsArchiveFlowVo rcsArchiveFlowVo:rafList) {
            rcsArchiveFlowVo.setStatus(EnumUtil.getEnumByCode(rcsArchiveFlowVo.getStatus(), RcsArchiveStatus.class).getMessage());
        }
        return RcsResult.ok(pageInfo);
    }

    public RcsArchiveFlowVo getRcsArchiveFlowVoData(SearchCondition sc){
        //将请求的数据封装成RcsArchiveFlowVo对象
        rcsArchiveFlowVo = new RcsArchiveFlowVo(sc.getValue("archNum"),
                sc.getValue("questionFrom"),
                sc.getValue("questionType"),
                sc.getValue("suosLiuy"),
                sc.getValue("status"),
                sc.getValue("deptId"));
        return rcsArchiveFlowVo;
    }
}
