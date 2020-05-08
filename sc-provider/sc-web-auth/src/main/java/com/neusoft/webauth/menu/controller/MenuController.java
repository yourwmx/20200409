package com.neusoft.webauth.menu.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.core.restful.AppResponseStatus;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.webauth.base.constant.GlobalConstant;
import com.neusoft.webauth.base.entity.Tree;
import com.neusoft.webauth.menu.entity.Menu;
import com.neusoft.webauth.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * @ClassName MenuService
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@RestController
@RequestMapping("/menu")
@Validated
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;

    /**
     * 部门：南京软件研发中心
     * 功能：获取菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    @RequestMapping(value = "listMenus")
    public AppResponse listMenus() {
        try {
            Map<String,Object> map = menuService.listMenus(GlobalConstant.MENU_ROOT);
            return AppResponse.success("查询成功", map);
        } catch (Exception e) {
            logger.error("菜单获取异常", e);
            throw new ScServerException("菜单获取失败，请重试");
        }
    }

    /**
     * 菜单详情
     * wumaoxing
     * 2020-04-10 10:57
     */
    @RequestMapping(value = "findMenuById")
    public AppResponse findMenuById(String menuId) {
        try {
            Menu menu= menuService.findMenuById(menuId);
            return AppResponse.success("查询成功", menu);
        } catch (Exception e) {
            logger.error("菜单获取异常", e);
            throw new ScServerException("菜单获取失败，请重试");
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：删除菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/8/30
     */
    @RequestMapping(value = "deleteMenu")
    public AppResponse deleteMenu(Menu menu) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menu.setLastModifiedBy(userId);
            menuService.deleteMenu(menu);
            return AppResponse.success("菜单删除成功");
        } catch (Exception e) {
            logger.error("菜单删除错误", e);
            return AppResponse.notFound("删除失败");
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：新增菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    @RequestMapping(value = "addMenu")
    public AppResponse addMenu(@Valid Menu menu) {
        try {
            String userId =  SecurityUtils.getCurrentUserId();
            menu.setCreateBy(userId);
            return menuService.addMenu(menu);
        } catch (Exception e) {
            logger.error("菜单新增异常", e);
            throw new ScServerException("菜单新增失败，请重试！");
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：修改菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    @RequestMapping(value = "updateMenuById")
    public AppResponse updateMenuById(@Valid Menu menu) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menu.setLastModifiedBy(userId);
            return menuService.updateMenuById(menu);
        } catch (Exception e) {
            logger.error("菜单修改异常", e);
            throw new ScServerException("菜单修改失败，请重试");
        }
    }

    /**
     * 根据角色代码获取菜单
     * @return
     */
    @RequestMapping(value = "listUserMenus")
    public AppResponse listUserMenus() {
        try {
            Tree treeMenus = menuService.listUserMenus();
            return AppResponse.success("查询成功", treeMenus.getChildren());
        } catch (Exception e) {
            logger.error("获取菜单失败", e);
            throw new ScServerException("获取菜单失败，请重试");
        }
    }
}
