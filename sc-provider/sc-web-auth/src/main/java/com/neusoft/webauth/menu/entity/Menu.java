package com.neusoft.webauth.menu.entity;

import java.util.Date;

/**
 * 部门：软件开发事业部
 * 描述：略
 * 作成者：印政权
 * 作成时间：2018/3/13
 */

public class Menu {

    /**
     * 菜单编号
     */
    private String menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 路径
     */
    private String menuRoute;
    /**
     * 上级菜单编号
     */
    private String lastLevelId;
    /**
     * 是否菜单
     */
    private String isMenu;
    /**
     * 备注
     */
    private String menuNote;
    /**
     * 删除标记 0未删 1删
     */
    private int isDeleted;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改人
     */
    private String lastModifiedBy;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 版本号
     */
    private String version;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuRoute() {
        return menuRoute;
    }

    public void setMenuRoute(String menuRoute) {
        this.menuRoute = menuRoute;
    }

    public String getLastLevelId() {
        return lastLevelId;
    }

    public void setLastLevelId(String lastLevelId) {
        this.lastLevelId = lastLevelId;
    }

    public String getMenuNote() {
        return menuNote;
    }

    public void setMenuNote(String menuNote) {
        this.menuNote = menuNote;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
