package com.zhdtedu.riverchiefs.dao.entity;

import lombok.Data;

import java.util.List;
@Data
public class TreeNode {
//定义前端数据
    private Long id;
    private  String label;
    private Long  parentId;
    private List<?> children;
}
