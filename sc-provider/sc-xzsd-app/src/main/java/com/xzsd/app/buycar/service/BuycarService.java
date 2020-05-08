package com.xzsd.app.buycar.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.buycar.dao.BuycarDao;
import com.xzsd.app.buycar.entity.BuycarInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class BuycarService {

    @Resource
    private BuycarDao buycarDao;

    /**
     * 新增购物车
     * wumaoxing
     * 2020-04-14 11:46
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addBuycar(BuycarInfo buycarInfo){
        //新增购物车
        buycarInfo.setBuycarId(StringUtil.getCommonCode(2));
        //检验商品是否已在购物车中
        int count = buycarDao.countBuycarGoods(buycarInfo);
        if (count != 0) {
            return AppResponse.bizError("商品已在购物车中，请重试！");
        }
        buycarInfo.setTotalMoney(Double.parseDouble(buycarInfo.getBuyNumber())*buycarInfo.getGoodsSaleMoney());
        count = buycarDao.addBuycar(buycarInfo);
        if (count == 0) {
            return AppResponse.bizError("新增购物车失败，请重试！");
        }
        return AppResponse.success("新增购物车成功！");
    }

    /**
     * 查询购物车分页列表
     * wumaoxing
     * 2020-04-14 14:16
     */
    public AppResponse listBuycars(BuycarInfo buycarInfo){
        PageHelper.startPage(buycarInfo.getPageNum(), buycarInfo.getPageSize());
        List<BuycarInfo> buycarInfoList = buycarDao.listBuycars(buycarInfo);
        // 包装Page对象
        PageInfo<BuycarInfo> pageData = new PageInfo<BuycarInfo>(buycarInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 修改购物车
     * wumaoxing
     * 2020-04-14 15:01
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateBuycarById(BuycarInfo buycarInfo){
        //修改购物车
        buycarInfo.setTotalMoney(Double.parseDouble(buycarInfo.getBuyNumber())*buycarInfo.getGoodsSaleMoney());
        int count = buycarDao.updateBuycarById(buycarInfo);
        if (count == 0) {
            return AppResponse.bizError("修改购物车失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 删除购物车
     * wumaoxing
     * 2020-04-14 15:05
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteBuycar(String buycarId, String updateUserId){
        List<String> listDeleteBuycarId = Arrays.asList(buycarId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除购物车
        int count = buycarDao.deleteBuycar(listDeleteBuycarId, updateUserId);
        if (count == 0) {
            appResponse = AppResponse.bizError("删除购物车失败，请重试！");
        }
        return appResponse;
    }
}
