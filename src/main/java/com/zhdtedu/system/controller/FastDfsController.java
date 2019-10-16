package com.zhdtedu.system.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.system.service.SysFileInfoService;
import com.zhdtedu.util.FastDFSClient;
import com.zhdtedu.util.FastDFSFile;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

@RestController
@RequestMapping("/{version}")
public class FastDfsController {

    @Resource
    private SysFileInfoService sysFileInfoService;

    @ApiVersion(2)
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
                        System.out.println("==========getOriginalFilename========="+mpf.getOriginalFilename());
                        FastDFSFile f = new FastDFSFile();
                        f.setName(mpf.getOriginalFilename());
                        f.setContent(mpf.getBytes());
                        String ext = mpf.getOriginalFilename().substring(
                                mpf.getOriginalFilename().lastIndexOf(".") + 1);
                        f.setExt(ext);
                        String remoteFileName[] = FastDFSClient.upload(f);
                        f.setGroupName(remoteFileName[0]);
                        f.setRemoteFileName(remoteFileName[1]);
                        sysFileInfoService.fastDfsUploadFile(f,tempId);
                    }
                }
            }
            return RcsResult.ok(this.sysFileInfoService.selectByFileCode(tempId));
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500,e.getMessage());
        }
    }
}
