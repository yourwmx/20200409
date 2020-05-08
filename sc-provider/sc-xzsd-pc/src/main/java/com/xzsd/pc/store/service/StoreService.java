package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.RandomUtil;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Store实现类
 * wumaoxing
 * 2020-04-04 21:36
 */
@Service
public class StoreService {

    @Resource
    private StoreDao storeDao;

    @Resource
    private UserDao userDao;

    /**
     * 新增门店
     * wumaoxing
     * 2020-04-04 21:37
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo) {
        //检验门店是否存在或店长是否已绑定门店
        int countStore = storeDao.countStoreAccountOrManager(storeInfo);
        if (countStore != 0) {
            return AppResponse.bizError("门店已存在或店长已绑定门店，请重新输入！");
        }
        //检验门店邀请码是否重复
        String inviteCode;
        do{
            inviteCode = RandomUtil.radmonkey(6);
        }while(storeDao.queryInviteCode(inviteCode) != 0);
        storeInfo.setInviteCode(inviteCode);
        storeInfo.setStoreId(StringUtil.getCommonCode(2));
        //新增门店
        int count = storeDao.addStore(storeInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 修改门店
     * wumaoxing
     * 2020-04-04 21:54
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStoreById(StoreInfo storeInfo) {
        //检验门店是否存在或店长是否已绑定门店
        int countStore = storeDao.countStoreAccountOrManager(storeInfo);
        if (countStore != 0) {
            return AppResponse.bizError("门店已存在或店长已绑定门店，请重新输入！");
        }
        //修改门店
        int count = storeDao.updateStoreById(storeInfo);
        if (count == 0) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 删除门店
     * wumaoxing
     * 2020-04-04 22:04
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeId, String updateUserId) {
        List<String> listDeleteStoreId = Arrays.asList(storeId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除门店
        int count = storeDao.deleteStore(listDeleteStoreId, updateUserId);
        if (count == 0) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 门店分页列表
     * wumaoxing
     * 2020-03-28 11:29
     */
    public AppResponse listStores(StoreInfo storeInfo) {
        //当前角色为管理员（0）还是店长（3）需判断
        String userId = SecurityUtils.getCurrentUserId();
        storeInfo.setUserId(userId);
        String role = userDao.getCurrentRole(userId);
        storeInfo.setRole(role);
        PageHelper.startPage(storeInfo.getPageNum(), storeInfo.getPageSize());
        List<StoreInfo> storeInfoList = storeDao.listStores(storeInfo);
        // 包装Page对象
        PageInfo<StoreInfo> pageData = new PageInfo<StoreInfo>(storeInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 门店详情
     * wumaoxing
     * 2020-04-03 21:12
     */
    public AppResponse findStoreById(String storeId){
        return AppResponse.success("查询成功！",storeDao.findStoreById(storeId));
    }

    /**
     * 门店所在位置分类
     * wumaoxing
     * 2020-04-05 13:42
     */
    public AppResponse queryStoreLocalClassify(String lastClassifyId){
        // 查询门店所在位置分类
        return AppResponse.success("查询成功！",storeDao.queryStoreLocalClassify(lastClassifyId));
    }
}
