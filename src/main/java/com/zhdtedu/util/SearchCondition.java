package com.zhdtedu.util;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class SearchCondition {

    private int pageSize=10;//每页条数

    private int pageNo =1;//默认第一页

    private int pageTotal=0;//总条数

    private int startNo=0;//起始数


    /**
     * 用于记录request中参数名称及值
     */
    private Map<String, Object> values = new HashMap<String, Object>();

    /**
     * 用于记录自定义查询条件值
     */
    private List<Object> conditionvalue = new ArrayList<Object>();

   /* private EcOrgInfo orgInfo;

    private EcUser user;


    public EcOrgInfo getOrgInfo() {
        return orgInfo;
    }

    public void setOrgInfo(EcOrgInfo orgInfo) {
        this.orgInfo = orgInfo;
    }

    public EcUser getUser() {
        return user;
    }

    public void setUser(EcUser user) {
        this.user = user;
    }*/

    private String orderBy;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getStartNo() {
        System.out.println("=====this.getPageNo()======"+this.getPageNo());
        System.out.println("=====this.getPageSize()======"+this.getPageSize());
       return (this.getPageNo()-1)*this.getPageSize();
    }

    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public SearchCondition() {

    }
    /**
     * 根据页面传递参数生成MAP类型值
     *
     * @param request
     */
    public SearchCondition(HttpServletRequest request) {
        for (Iterator<?> i = request.getParameterMap().keySet().iterator(); i
                .hasNext();) {
            String key = (String) i.next();
            String val = request.getParameter(key);

            try {
                val = java.net.URLDecoder.decode(request.getParameter(key),
                        "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(key+"============"+val);
            values.put(key, val);
        }

    }

    /**
     * @param attributes
     * @param request
     */
    public SearchCondition(String attributes, HttpServletRequest request) {
        setExpAtt(attributes, request);
    }

    private void setExpAtt(String attributes, HttpServletRequest request) {
        List<String> attList = this.parseVertical(attributes);
        String attValue;
        for (String attName : attList) {
            attValue = attName;
            if (attName.indexOf(":") > 0) {
                attValue = attName.substring(attName.indexOf(":") + 1);
                attName = attName.substring(0, attName.indexOf(":"));
            }
            values.put(attName, request.getParameter(attValue));
        }
    }

    public Object[] getValues(String attributes) {
        List<String> attList = this.parseVertical(attributes);
        List<Object> objs = new ArrayList<Object>();
        for (String attName : attList) {
            if (attName.startsWith("%") && attName.endsWith("%")) {
                attName = attName.substring(1, attName.length() - 1);
                objs.add("%" + values.get(attName) + "%");
            } else if (attName.startsWith("%")) {
                attName = attName.substring(1);
                objs.add("%" + values.get(attName));
            } else if (attName.startsWith("%")) {
                attName = attName.substring(0, attName.length() - 1);
                objs.add("%" + values.get(attName));
            } else {
                objs.add(values.get(attName));
            }
        }
        return objs.toArray();
    }

    public Map<String, Object> getParameter() {
        return values;
    }

    /**
     * @desc
     * @date 2008-11-8
     * @author 袁航程
     * @parameter
     * @see com.gkhb.mis.core.web.ISearchCondition#addCustomCondition(java.lang.Object)
     */
    public void addCustomCondition(Object o) {
        this.conditionvalue.add(o);
    }

    public Object[] getCustomCondition() {
        return this.conditionvalue.toArray();
    }

    public void setValue(String key,String value) {
        values.put(key, value);
    }

    /**
     * @desc
     * @date 2008-11-8
     * @author 袁航程
     * @parameter
     * @see com.gkhb.mis.core.web.ISearchCondition#getValue(java.lang.String)
     */
    public String getValue(String key) {
        if (values.get(key) != null) {
            return (String) values.get(key);
        } else {
            return null;
        }
    }

    /**
     * @desc
     * @date 2008-11-9
     * @author 袁航程
     * @parameter
     * @see com.gkhb.mis.core.web.ISearchCondition#valueIsNull(java.lang.String)
     */
    public boolean valueIsNull(String key) {
        if (getValue(key) == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @desc
     * @date 2008-11-9
     * @parameter
     * @see com.gkhb.mis.core.web.ISearchCondition#valueIsNullOrNothing(java.lang.String)
     */
    public boolean valueIsNullOrNothing(String key) {
        String v = getValue(key);
        if (v == null) {
            return true;
        } else {
            v = v.trim();
            if (v.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static List<String> parseVertical(String string) {
        List<String> list = new ArrayList<String>();
        StringTokenizer objTokenizer = new StringTokenizer(string, "|");
        while (objTokenizer.hasMoreTokens()) {
            list.add(objTokenizer.nextToken().trim());
        }
        return list;
    }

}
