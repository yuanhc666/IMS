package com.zhdtedu.system.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.system.service.SysFileInfoService;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/{version}")
public class SysFileController  {

    @Resource
    private SysFileInfoService sysFileInfoService;

    @ApiVersion(1)
    @ApiOperation(value = "上传文件", notes = "上传单个或多个文件")
    @ApiImplicitParam(name = "tempId",value = "临时ID",dataType = "String",paramType = "path")
    @RequestMapping(value="/fileUpload",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public RcsResult uploadFile(HttpServletRequest request) {
        String tempId = request.getParameter("tempId");
        try {
            CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
            request.getSession().getServletContext());
            //检查form中是否有enctype="multipart/form-data"
            if(multipartResolver.isMultipart(request)) {
               //将request变成多部分request
                MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
                //获取multiRequest 中所有的文件名
                Iterator iter=multiRequest.getFileNames();
                while(iter.hasNext()) {
                    //一次遍历所有文件
                    MultipartFile mpf = multiRequest.getFile(iter.next().toString());
                    if(mpf!=null) {
                        String path = request.getSession().getServletContext().getRealPath("")+"fileupload/";
                        System.out.println("===========path========"+path+multiRequest.getParameter("keyID"));
                        System.out.println("===========type========"+mpf.getContentType());
                        System.out.println("==========name========="+mpf.getName());
                        System.out.println("==========getOriginalFilename========="+mpf.getOriginalFilename());
                        //上传
                        File mkdir = new File(path);
                        if(!mkdir.exists()){
                            mkdir.mkdir();
                        }
                        File file = new File(path+mpf.getOriginalFilename());
                        mpf.transferTo(file);
                        sysFileInfoService.uploadFile(file,request);
                    }
                }
            }
            return RcsResult.ok(this.sysFileInfoService.selectByFileCode(tempId));
        } catch (IOException e) {
            e.printStackTrace();
            return RcsResult.build(500,e.getMessage());
        }
    }

    @ApiVersion(1)
    @ApiOperation(value = "上传文件", notes = "删除文件")
    @ApiImplicitParam(name = "id",value = "文件ID",dataType = "String",paramType = "path")
    @DeleteMapping(value="/file/{id}",produces = "application/json;charset=utf-8")
    public RcsResult deleteFileById(@PathVariable("id") int id) {
        try {
            this.sysFileInfoService.deleteFileInfo(id);
            return RcsResult.ok();
        }catch (Exception e){
            return RcsResult.build(500,e.getMessage());
        }
    }

    @ApiVersion(1)
    @ApiOperation(value = "上传文件", notes = "下载文件")
    @ApiImplicitParam(name = "id",value = "文件ID",dataType = "String",paramType = "path")
    @GetMapping(value="/file/{id}",produces = "application/json;charset=utf-8")
    public void  downloadFile(@PathVariable("id") int id, HttpServletResponse response){
        this.sysFileInfoService.downloadFile(response,id);
    }


    @ApiVersion(1)
    @ApiOperation(value = "上传文件", notes = "获取文件列表")
    @ApiImplicitParam(name = "id",value = "tempId",dataType = "String",paramType = "path")
    @GetMapping(value="/files/{id}",produces = "application/json;charset=utf-8")
    public RcsResult  queryFile(@PathVariable("id")String tempId){
        try{
            return  RcsResult.ok(this.sysFileInfoService.selectByFileCode(tempId));
        }catch (Exception e){
            return RcsResult.build(500,e.getMessage());
        }
    }
}