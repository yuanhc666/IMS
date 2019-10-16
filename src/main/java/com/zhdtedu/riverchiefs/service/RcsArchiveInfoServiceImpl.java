package com.zhdtedu.riverchiefs.service;


import com.zhdtedu.riverchiefs.bean.RcsArchiveInfoVo;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;

import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveInfoMapper;
import com.zhdtedu.system.dao.entity.BaseData;
import com.zhdtedu.system.service.SysFileInfoService;
import com.zhdtedu.util.BeanUtil;
import com.zhdtedu.util.SearchCondition;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class RcsArchiveInfoServiceImpl implements  RcsArchiveInfoService{

    @Resource
    private RcsArchiveInfoMapper rcsArchiveInfoMapper;

    @Resource
    private SysFileInfoService sysFileInfoService;

    @Override
    public List<RcsArchiveInfo> pageQuery(SearchCondition sc){
        Map<String,Object> param = sc.getParameter();
        param.put("startNo",sc.getStartNo());
        param.put("pageSize",sc.getPageSize());
        if(sc.getValue("sort")!=null && sc.getValue("order")!=null){
            param.put("sort",sc.getValue("sort"));
            param.put("order",sc.getValue("order"));
        }
        if(sc.getValue("archNum")!=null&&!sc.getValue("archNum").equals("")){
            param.put("archNum",sc.getValue("archNum"));
        }
        if(sc.getValue("questionFrom")!=null&&!sc.getValue("questionFrom").equals("")){
            param.put("questionFrom",sc.getValue("questionFrom"));
        }
        if(sc.getValue("questionType")!=null&&!sc.getValue("questionType").equals("")){
            param.put("questionType",sc.getValue("questionType"));
        }
        if(sc.getValue("suosLiuy")!=null&&!sc.getValue("suosLiuy").equals("")){
            param.put("suosLiuy",sc.getValue("suosLiuy"));
        }
        sc.setPageTotal(this.rcsArchiveInfoMapper.count(param));
        List<RcsArchiveInfo> list  = this.rcsArchiveInfoMapper.pageQuery(param);
        return list;
    }

    @Override
    public RcsArchiveInfo getRcsArchiveInfo(Integer id) {
        return rcsArchiveInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addRcsArchiveInfo(RcsArchiveInfoVo rcsArchiveInfo) {
        if(rcsArchiveInfo!=null && (rcsArchiveInfo.getId()==null || rcsArchiveInfo.getId()==0)) {
            rcsArchiveInfo.setReportDate(new Date());
            rcsArchiveInfo.setArchNum(getArchNumCode());
        }
        rcsArchiveInfoMapper.insert(rcsArchiveInfo);
        if(rcsArchiveInfo.getTempID()!=null && !rcsArchiveInfo.getTempID().equals("")){
            sysFileInfoService.updateFileCode(rcsArchiveInfo.getTempID(),"rcsArchiveInfo-"+rcsArchiveInfo.getId());
        }
    }


    @Override
    public void modifyRcsArchiveInfo(RcsArchiveInfoVo rcsArchiveInfo) {
        RcsArchiveInfo info  = this.getRcsArchiveInfo(rcsArchiveInfo.getId());
        try {
            ConvertUtils.register(new DateConverter(rcsArchiveInfo.getReportDate()),Date.class);
            BeanUtil.copyIsNotNullProperties(rcsArchiveInfo,info);
            this.rcsArchiveInfoMapper.updateByPrimaryKey(info);
//            if(rcsArchiveInfo.getTempID()!=null && !rcsArchiveInfo.getTempID().equals("")){
//                sysFileInfoService.updateFileCode(rcsArchiveInfo.getTempID(),"rcsArchiveInfo-"+info.getId());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteRcsArchiveInfo(Integer id){
        this.rcsArchiveInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取问题类型列表
     * @return
     */
    public  List<BaseData> findQuestionType(){
        return this.rcsArchiveInfoMapper.findQuestionType();
    }

    /**
     * 获取问题来源列表
     * @return
     */
    @Override
    public List<BaseData> findQuestionFrom() {
        return this.rcsArchiveInfoMapper.findQuestionFrom();
    }


    /**
     * 获取问题来源列表
     * @return
     */
    @Override
    public List<BasinInfo> findSuosLiuy() {
        return this.rcsArchiveInfoMapper.findSuosLiuy();
    }


    /**
     * 从数据库获取当天的最大编号
     * @return
     */

    private String getArchNumCode(){
        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");
        String code = sfm.format(new Date()).replace("-","");
        Long nowCode = this.rcsArchiveInfoMapper.selectArchNumMaxCode(code);
        System.out.println(nowCode);
        if(nowCode==null||nowCode.equals("")){
            return  code+"0001";
        }
        return nowCode.toString();
    }

    public static void main(String[] args) {
        //RcsArchiveInfoServiceImpl a = new RcsArchiveInfoServiceImpl();
        //System.out.println(a.getArchNumCode());
        RcsArchiveInfo nrs = new RcsArchiveInfo();
        nrs.setArchNum("123456789");
        RcsArchiveInfoVo rs = new RcsArchiveInfoVo();
        rs.setId(0);
        rs.setStatus("s");
        //rs.setReportDate(new Date());
        BeanUtil.copyIsNotNullProperties(rs,nrs);
        System.out.println(nrs);
    }
}

