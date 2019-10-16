package com.zhdtedu.system.service.impl;

import com.zhdtedu.system.dao.entity.SysFileInfo;
import com.zhdtedu.system.dao.mapper.SysFileInfoMapper;
import com.zhdtedu.system.service.SysFileInfoService;
import com.zhdtedu.util.FastDFSClient;
import com.zhdtedu.util.FastDFSFile;
import com.zhdtedu.util.FileUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysFileInfoService")
public class SysFileInfoServiceImpl implements SysFileInfoService {

    @Resource
    SysFileInfoMapper sysFileInfoMapper;

    @Override
    public void uploadFile(File file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("");
        String tempCode = request.getParameter("tempId");
        if(tempCode!=null && !tempCode.equals("")){
            SysFileInfo sfi = new SysFileInfo();
            sfi.setFileCode(tempCode);
            sfi.setTempCode(tempCode);
            System.out.println("===========file.getName()========"+file.getName());
            sfi.setFileName(file.getName());
            sfi.setFilePath(file.getPath());
            sfi.setFileSize(file.length());
            sfi.setUploadDate(new Date());
            sfi.setFileType(FileUtils.getFileType(file.getName()));
            sfi.setExt(FileUtils.getFileSize(file.length()));
            this.save(sfi);
        }
    }

    @Override
    public void fastDfsUploadFile(FastDFSFile file, String tempId){
        if(tempId!=null && !tempId.equals("")) {
            SysFileInfo sfi = new SysFileInfo();
            sfi.setFileCode(tempId);
            sfi.setTempCode(tempId);
            sfi.setFileName(file.getName());
            sfi.setFilePath("/" + file.getGroupName() + "/" + file.getRemoteFileName());
            sfi.setFileSize(file.getContent().length);
            sfi.setUploadDate(new Date());
            sfi.setFileType(FileUtils.getFileType(file.getName()));
            sfi.setExt(FileUtils.getFileSize(file.getContent().length));
            sfi.setGroupName(file.getGroupName());
            sfi.setRemoteFileName(file.getRemoteFileName());
            this.save(sfi);
        }
    }

    @Override
    public void save(SysFileInfo file) {
        sysFileInfoMapper.insertSelective(file);
    }

    @Override
    public SysFileInfo getFileInfo(Integer id) {
        return sysFileInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteFileInfo(Integer id) throws Exception {
        SysFileInfo file = this.getFileInfo(id);
        System.out.println("==========file========"+file);
        if(file.getGroupName()!=null&&file.getRemoteFileName()!=null){
            this.sysFileInfoMapper.deleteByPrimaryKey(file.getId());
            FastDFSClient.deleteFile(file.getGroupName(),file.getRemoteFileName());
        }else{
            File f = new File(file.getFilePath());
            f.getAbsolutePath();
            this.sysFileInfoMapper.deleteByPrimaryKey(file.getId());
            System.out.println("===delete file====="+f.getPath());
            if(f.exists()){
                System.out.println("===delete exists====="+f.getPath());
                f.delete();
            }
        }
    }

    @Override
    public List<SysFileInfo> selectByFileCode(String fileCode) {
        System.out.println("============code========="+fileCode);
        return this.sysFileInfoMapper.selectByFileCode(fileCode);
    }

    @Override
    public void updateFileCode(String oldCode,String nowCode) {
        Map<String, String> map = new HashMap<>();
        map.put("oldCode",oldCode);
        map.put("nowCode",nowCode);
        this.sysFileInfoMapper.updateFileCode(oldCode,nowCode);
    }

    @Override
    public void downloadFile(HttpServletResponse response, int id) {
        //1、根据id查询出文件信息
        SysFileInfo sfi = this.getFileInfo(id);
        System.out.println("========download======="+sfi);
        InputStream in;
        //2、判断文件是否存在
        if(sfi!=null){
            //3、实例化文件对象
            File file = new File(sfi.getFilePath());
            //4、设置response响应内容为二进制
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType(FileUtils.getMimeType(sfi.getFileType()));
                try {
                    //5、设置浏览器以附件的形式解处理响应
                    response.setHeader("Content-Disposition", "attachment;filename="+
                            new String(sfi.getFileName().getBytes("utf-8"),
                                    "ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //6、设置输入输出流
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    if(sfi.getGroupName()==null||sfi.getRemoteFileName()==null){
                        System.out.println("======local======");
                        if(file.exists()) {
                            fis = new FileInputStream(file);
                            bis = new BufferedInputStream(fis);
                        }
                    }else{
                        System.out.println("======fastdfs======");
                        bis = new BufferedInputStream(FastDFSClient.downFile(sfi.getGroupName(),sfi.getRemoteFileName()));
                    }
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    os.flush();
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
}
