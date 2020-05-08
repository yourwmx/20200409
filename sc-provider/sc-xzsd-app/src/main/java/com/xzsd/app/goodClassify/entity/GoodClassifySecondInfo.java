package com.xzsd.app.goodClassify.entity;

import java.util.List;

public class GoodClassifySecondInfo {
    /**
     * 分类编号
     */
    private String classifyId;
    /**
     * 二级分类名称
     */
    private String classifyName;
    /**
     * 商品信息列表
     */
    private List<GoodClassifyInfo> list;

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public List<GoodClassifyInfo> getList() {
        return list;
    }

    public void setList(List<GoodClassifyInfo> list) {
        this.list = list;
    }
}
