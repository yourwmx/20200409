package com.xzsd.pc.store.entity;

/**
 * 门店位置分类查询类
 * wumaoxing
 * 2020-04-05 13:37
 */
public class StoreDataInfo {

    /**
     * 上级分类编号
     */
    private String lastClassifyId;
    /**
     * 分类编号
     */
    private String classifyId;
    /**
     * 分类名称
     */
    private String classifyName;

    public String getLastClassifyId() {
        return lastClassifyId;
    }

    public void setLastClassifyId(String lastClassifyId) {
        this.lastClassifyId = lastClassifyId;
    }

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
}
