package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.SysFileInfo;
import com.zhdtedu.util.FastDFSFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;


public interface SysFileInfoService {

    /**
     * 上传文件
     * @param file
     * @param request
     */
    public void uploadFile(File file, HttpServletRequest request);


    public void fastDfsUploadFile(FastDFSFile file, String tempId);

    /**
     * 保存文件
     * @param file
     */
    public void save(SysFileInfo file);

    /**
     * 根据id获取文件信息
     * @param id
     * @return
     */
    public SysFileInfo getFileInfo(Integer id);

    /**
     * 删除文件
     * @param id
     * @throws Exception
     */
    public void deleteFileInfo(Integer id) throws Exception;

    /**
     * 查询文件
     * @param code
     * @return
     */
    public List<SysFileInfo> selectByFileCode(String code);

    /**
     * 修改文件code
     * @param oldCode
     * @param nowCode
     */
    public void updateFileCode(String oldCode, String nowCode);

    /**
     * 下载文件
     * @param response
     * @param id
     */
    public void downloadFile(HttpServletResponse response, int id);
}
