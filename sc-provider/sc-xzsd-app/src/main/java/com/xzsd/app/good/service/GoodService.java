package com.xzsd.app.good.service;

import com.xzsd.app.good.dao.GoodDao;
import com.xzsd.app.good.entity.GoodInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodService {

    @Resource
    private GoodDao goodDao;

    /**
     * 商品二级分类及列表
     * wumaoxing
     * 2020-03-28 11:29
     */
    public AppResponse listGoods(GoodInfo goodInfo) {
        return AppResponse.success("查询成功！",goodDao.listGoods(goodInfo));
    }

    /**
     * 查询商品详细
     * wumaoxing
     * 2020-04-13 16:29
     */
    public AppResponse findGoodById(String goodsId, String storeId) {
        //修改商品浏览量
        goodDao.updateGoodsLookNumber(goodsId);
        //查询商品详细
        GoodInfo goodInfo = goodDao.findGoodById(goodsId);
        //判断是否有绑定门店
        if(storeId != null){
            String storeName = goodDao.findStoreById(storeId);
            goodInfo.setStoreName(storeName);
        }
        return AppResponse.success("查询成功！", goodInfo);
    }
}
