package com.neusoft.webauth.menu.dao;

import com.neusoft.webauth.menu.entity.Menu;

import java.util.List;

/**
 * @ClassName MenuDao
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
public interface MenuDao {
    /**
     * 查询全部菜单
     * @return 菜单集合
     */
    List<Menu> listMenus();
    /**
     * 菜单详情
     * wumaoxing
     * 2020-04-10 11:00
     */
    Menu findMenuById(String menuId);

    /**
     * 删除菜单
     * @param menu 菜单信息
     * @return
     */
    int deleteMenu(Menu menu);
    /**
     * 新增菜单
     * @param menu 菜单信息
     * @return
     */
    int addMenu(Menu menu);
    /**
     * 修改菜单
     * @param menu 菜单信息
     * @return
     */
    int updateMenuById(Menu menu);
    /**
     * 获取用户菜单信息
     * @return
     */
    List<Menu> listMenusByManager();
}
