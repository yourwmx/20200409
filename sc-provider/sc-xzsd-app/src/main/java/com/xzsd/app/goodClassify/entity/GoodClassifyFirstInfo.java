package com.xzsd.app.goodClassify.entity;

import java.util.List;

/**
 * 商品分类
 * wumaoxing
 * 2020-03-27 10:40
 */
public class GoodClassifyFirstInfo {
    /**
     * 一级分类id
     */
    private String firstClassifyId;
    /**
     * 一级分类名称
     */
    private String firstClassifyName;
    /**
     * 版本
     */
    private String version;
    /**
     * 下一级分类
     */
    private List<GoodClassifySecondInfo> secondInfos;

    public String getFirstClassifyId() {
        return firstClassifyId;
    }

    public void setFirstClassifyId(String firstClassifyId) {
        this.firstClassifyId = firstClassifyId;
    }

    public String getFirstClassifyName() {
        return firstClassifyName;
    }

    public void setFirstClassifyName(String firstClassifyName) {
        this.firstClassifyName = firstClassifyName;
    }

    public List<GoodClassifySecondInfo> getSecondInfos() {
        return secondInfos;
    }

    public void setSecondInfos(List<GoodClassifySecondInfo> secondInfos) {
        this.secondInfos = secondInfos;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
