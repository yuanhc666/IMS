package com.zhdtedu.riverchiefs.controller;


import com.zhdtedu.riverchiefs.bean.RcsArchiveInfoResultVo;
import com.zhdtedu.riverchiefs.bean.RcsArchiveInfoVo;
import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.riverchiefs.service.RcsArchiveInfoService;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.system.service.SysFileInfoService;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.*;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class RcsArchiveInfoController extends BaseController {

        @Resource
        RcsArchiveInfoService rcsArchiveInfoService;

        @Resource
        private UserService userService;

        @Resource
        SysFileInfoService sysFileInfoService;

    @ApiOperation(value="案卷登记", notes="根据分页及其它条件获取用户详细信息",produces = "application/json;charset=utf-8")
    @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header"),
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "每页数量",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "sort",value = "排序字段",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "order",value = "排序类型（asc,desc）",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "archNum",value = "查询条件1(案卷编号)",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "questionFrom",value = "查询条件2（问题来源）",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "questionType",value = "查询条件3（问题类型）",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "suosLiuy",value = "查询条件4（所属流域）",paramType = "query",dataType = "string")
    })
    @ApiVersion(1)
    @GetMapping(value = "/archive",produces = "application/json;charset=utf-8")
    public RcsResult pageQuery(){
        try {
            SearchCondition sc = this.getSearchCondition();
            List<RcsArchiveInfo> list = this.rcsArchiveInfoService.pageQuery(sc);
            PageModel page = new PageModel();
            page.setList(list);
            page.setTotalRecords(sc.getPageTotal());
            page.setPageSize(sc.getPageSize());
            page.setCurrentPageNum(sc.getPageNo());
            return RcsResult.ok(page);
        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }
    }


    @ApiOperation(value="案卷登记", notes="新增或者修改案卷信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header")
    @ApiVersion(1)
    @PostMapping(value="/archive",produces = "application/json;charset=utf-8")
    public RcsResult addRcsArchiveInfo(@RequestBody RcsArchiveInfoVo archive ){
        try {
            if(archive.getId()==null || archive.getId().equals("")){
                 User u = getUserInfo();
                archive.setReportId(u.getUserId());
                archive.setReportRealname(u.getUserName());
                this.rcsArchiveInfoService.addRcsArchiveInfo(archive);
            }else{
                this.rcsArchiveInfoService.modifyRcsArchiveInfo(archive);
            }
            return RcsResult.ok();
        }catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
    }

    @ApiOperation(value="案卷登记", notes="获取一条案卷信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "id",value = "案卷ID",dataType = "int",paramType = "path"),
    @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header")
    })
    @ApiVersion(1)
    @RequestMapping(value="/archive/{id}", method= RequestMethod.GET,produces = "application/json;charset=utf-8")
    public RcsResult getRcsArchiveInfo(@PathVariable Integer id){
        try {
            if(id==null || id==0){
                throw new BusinessRuntimeException("无效的ID");
            }
            RcsArchiveInfoResultVo vo = new RcsArchiveInfoResultVo();
            RcsArchiveInfo rahi = this.rcsArchiveInfoService.getRcsArchiveInfo(id);
            vo.setInfo(rahi);
            vo.setFlist(sysFileInfoService.selectByFileCode("rcsArchiveInfo-"+rahi.getId())==null?null:
                    sysFileInfoService.selectByFileCode("rcsArchiveInfo-"+rahi.getId()));
            return  RcsResult.ok(vo);
        }catch (Exception e){
            return RcsResult.build(500,e.getMessage());
        }
    }


    @ApiOperation(value="案卷登记", notes="删除一条案卷信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "案卷ID", dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "version", value = "版本号", dataType = "int", paramType = "header")
    })
    @RequestMapping(value="/archive/{id}", method= RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public RcsResult delRcsArchiveInfo(@PathVariable Integer id){
        try {
            if(id==null || id==0){
                new BusinessRuntimeException("无效的ID");
            }
            this.rcsArchiveInfoService.deleteRcsArchiveInfo(id);
            return RcsResult.ok();
        }catch (Exception e){
            return RcsResult.build(500,e.getMessage());
        }
    }

    @ApiImplicitParam(name = "version",value = "版本号",dataType = "int",paramType = "header")
    @ApiOperation(value="案卷登记", notes="获取问题类型、所属流域、问题来源选择列表数据",produces = "application/json;charset=utf-8")
    @ApiVersion(1)
    @RequestMapping(value="/archive/select", method= RequestMethod.GET,produces = "application/json;charset=utf-8")
    public RcsResult getQuestionType(){
        try {
            Map<String,Object> selectList = new HashMap<String,Object>();
            selectList.put("questionType",this.rcsArchiveInfoService.findQuestionType());
            selectList.put("questionFrom",this.rcsArchiveInfoService.findQuestionFrom());
            selectList.put("suosly",this.rcsArchiveInfoService.findSuosLiuy());
            return  RcsResult.ok(selectList);
        }catch (Exception e){
            return RcsResult.build(500,e.getMessage());
        }
    }


}

