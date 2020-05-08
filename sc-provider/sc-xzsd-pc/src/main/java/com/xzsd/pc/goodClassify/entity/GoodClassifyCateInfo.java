package com.xzsd.pc.goodClassify.entity;

import java.util.List;

/**
 * 商品分类
 * wumaoxing
 * 2020-03-27 10:40
 */
public class GoodClassifyCateInfo {
    /**
     * 分类编号
     */
    private String classifyId;
    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 版本
     */
    private String version;
    /**
     * 下一级分类
     */
    private List<GoodClassifyCateInfo> nextInfos;

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

    public List<GoodClassifyCateInfo> getNextInfos() {
        return nextInfos;
    }

    public void setNextInfos(List<GoodClassifyCateInfo> nextInfos) {
        this.nextInfos = nextInfos;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
