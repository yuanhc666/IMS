package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.riverchiefs.service.RcsArchiveFlowService;
import com.zhdtedu.util.*;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
//@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
//@RequestMapping(value="/v1",name="版本号，如：v1,v2,v3")
public class RcsArchiveFlowController extends BaseController{

    String status = "";

    @Autowired
    private RcsArchiveFlowService  rcsArchiveFlowService;

    @ApiOperation(value="根据案卷编号获取历史处理记录", notes="根据案卷编号获取历史处理记录")
    @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header")
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @RequestMapping(value="/archive/flowList/{id}", method= RequestMethod.GET)
    public RcsResult getArchiveFlowList(@PathVariable String id){
        List<RcsArchiveFlow> rcsArchiveFlowList = rcsArchiveFlowService.getRcsArchiveFlowList(id);
        for (RcsArchiveFlow rcsArchiveFlow:rcsArchiveFlowList) {
            String user = rcsArchiveFlowService.getUserByOperator(rcsArchiveFlow);
            rcsArchiveFlow.setOperator(user);
            //通过枚举工具将状态转换为消息
            rcsArchiveFlow.setStatus(EnumUtil.getEnumByCode(rcsArchiveFlow.getStatus(), RcsArchiveStatus.class).getMessage());
        }
        return RcsResult.ok(rcsArchiveFlowList);
    }

    @ApiOperation(value="插入历史记录", notes="插入历史记录")
            @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
            @ApiImplicitParams({
                    @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header"),
                    @ApiImplicitParam(name = "id",value = "业务id",paramType = "form",dataType = "int"),
                    @ApiImplicitParam(name = "times",value = "时限",paramType = "form",dataType = "int"),
                    @ApiImplicitParam(name = "unit",value = "时限单位",paramType = "form",dataType = "String"),
                    @ApiImplicitParam(name = "operator",value = "处理人",paramType = "form",dataType = "String"),
                    @ApiImplicitParam(name = "operation",value = "操作",paramType = "form",dataType = "String"),
            @ApiImplicitParam(name = "opinion",value = "处理意见",paramType = "form",dataType = "String"),
            @ApiImplicitParam(name = "deptId",value = "处理部门",paramType = "form",dataType = "String")
    })
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @RequestMapping(value="/archive/flow", method= RequestMethod.POST)
    public void insertArchiveFlow(@RequestBody RcsArchiveFlow vo){

        vo.setOperTime(new Date());
        //根据id查询案卷登记信息
        RcsArchiveInfo rcsArchiveInfo = rcsArchiveFlowService
                .queryRcsArchiveInfoById(Integer.valueOf(vo.getId().toString()));

        /**
         * 修改案卷登记表中的状态信息
         * 所有操作：
         *      "申请核实":1,
         *      "上报":2,案卷登记默认这状态为"上报"
         *      "派遣"：3，
         *      "不立案"：4，
         *      "申请验收" ：5
         *      "结案"：6，
         *      "处理"：7，
         *      "已处理"：8
         *      "撤回"：9
         *      “不派遣”：10
         */
        //如果操作状态为"撤回" ，则状态修改为"上报"
        if(vo.getOperation().equals("撤回")){
            vo.setStatus("2");
        }
        //插入案卷编号
        vo.setOperNum(rcsArchiveInfo.getArchNum());
        //将对象插入到历史记录表中
        rcsArchiveFlowService.insertRcsArchiveFlow(vo);
        //改变案卷登记信息表中的状态信息
        rcsArchiveInfo.setStatus(vo.getStatus());
        rcsArchiveFlowService.modifyRcsArchiveInfo(rcsArchiveInfo);
    }
}
