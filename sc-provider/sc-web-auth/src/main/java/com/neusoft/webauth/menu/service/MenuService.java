package com.neusoft.webauth.menu.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.neusoft.util.UUIDUtils;
import com.neusoft.webauth.base.constant.GlobalConstant;
import com.neusoft.webauth.base.entity.Tree;
import com.neusoft.webauth.menu.dao.MenuDao;
import com.neusoft.webauth.menu.entity.Menu;
import com.neusoft.webauth.user.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName MenuService
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    @Resource
    private UserDao userDao;

    /**
     * 部门：南京软件研发中心
     * 功能：查询全部菜单
     * 描述：查询全部菜单，如果角色代码不为空，则查询角色已授权的菜单
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    public Map<String,Object> listMenus(String rootId) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 查询全部菜单
        List<Menu> allMenus = menuDao.listMenus();
        Tree rootTree = new Tree();
        // 格式化菜单成树结构
        initTree(rootTree, allMenus, rootId);
        map.put("rootTree",rootTree.getChildren());
        return map;
    }

    /**
     * 菜单详情
     * wumaoxing
     * 2020-04-10 10:58
     */
    public Menu findMenuById(String menuId) {
        return menuDao.findMenuById(menuId);
    }

    /**
     * 部门：南京软件研发中心
     * 功能：初始化菜单树
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    private void initTree(Tree rootTree, List<Menu> allMenus, String selfCode){
        Iterator<Menu> menuIterator = allMenus.iterator();
        while(menuIterator.hasNext()){
            Menu temp = menuIterator.next();
            //初始化自身节点
            if(temp.getMenuId().equals(selfCode)){
                menuToTree(temp,rootTree);
            }else if(temp.getLastLevelId().equals(selfCode)){
                //初始化子节点
                Tree children = new Tree();
                menuToTree(temp,children);
                rootTree.getChildren().add(children);
                //递归
                initTree(children,allMenus,temp.getMenuId());
            }
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：将菜单格式化成树
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    private void menuToTree(Menu menu, Tree tree){
        tree.setId(menu.getMenuId());
        tree.setIndex(menu.getMenuRoute());
        tree.setPid(menu.getLastLevelId());
        tree.setLabel(menu.getMenuName());
        tree.setAttributes(menu);
    }

    /**
     * 部门：南京软件研发中心
     * 功能：删除菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/8/30
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteMenu(Menu menu) {
        // 删除菜单
        menuDao.deleteMenu(menu);
    }

    /**
     * 部门：南京软件研发中心
     * 功能：新增菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    public AppResponse addMenu(Menu menu) {
        AppResponse appResponse = AppResponse.success("新增成功！");
        // 菜单代码
        String menuId = StringUtil.getCommonCode(2);
        menu.setMenuId(menuId);
        menu.setIsDeleted(0);
        // 新增菜单
        int count = menuDao.addMenu(menu);
        if(0 == count) {
            appResponse = AppResponse.bizError("新增失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 部门：南京软件研发中心
     * 功能：修改菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    public AppResponse updateMenuById(Menu menu) {
        AppResponse appResponse = AppResponse.success("修改成功！");
        int count = menuDao.updateMenuById(menu);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 部门：南京软件研发中心
     * 功能：查询用户菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/8/6
     */
    public Tree listUserMenus() {
        // 用户id
        String userId =  SecurityUtils.getCurrentUserId();
        // 用户角色
        String role = userDao.getCurrentRole(userId);
        Tree rootTree = new Tree();
        if("0".equals(role) == true){//管理员
            // 获取所有菜单
            List<Menu> allMenus = menuDao.listMenus();
            initUserMenuTree(rootTree, allMenus, GlobalConstant.MENU_ROOT);
            return rootTree;
        }else if("3".equals(role) == true){//店长
            // 获取客户、订单、门店、司机
            List<Menu> allMenus = menuDao.listMenusByManager();
            initUserMenuTree(rootTree, allMenus, GlobalConstant.MENU_ROOT);
        }
        return rootTree;
    }
    /**
     * 部门：南京软件研发中心
     * 功能：初始化用户菜单树
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    private void initUserMenuTree(Tree rootTree, List<Menu> allMenus, String selfCode) {
        Iterator<Menu> menuIterator = allMenus.iterator();
        while (menuIterator.hasNext()) {
            Menu tmp = menuIterator.next();
            // 初始化自身节点
            if (tmp.getMenuId().equals(selfCode)) {
                menuToTree(tmp, rootTree);
                // 如果是二级节点或者二级节点下的子节点，则追加到nodes
            }
            else if (null == selfCode || tmp.getLastLevelId().equals(selfCode)) {
                // 初始化子节点
                Tree children = new Tree();
                menuToTree(tmp, children);
                if (null != children.getId()) {
                    if (null == rootTree.getChildren()) {
                        rootTree.setChildren(new ArrayList<Tree>());
                    }
                    rootTree.getChildren().add(children);
                }
                // 递归
                initTree(children, allMenus, tmp.getMenuId());
            }
        }
    }
}
