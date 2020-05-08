package com.xzsd.pc.good.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.good.dao.GoodDao;
import com.xzsd.pc.good.entity.GoodClassifyDataInfo;
import com.xzsd.pc.good.entity.GoodInfo;
import com.xzsd.pc.hotgood.dao.HotgoodDao;
import com.xzsd.pc.hotgood.entity.HotgoodInfo;
import com.xzsd.pc.slideshow.dao.SlideshowDao;
import com.xzsd.pc.slideshow.entity.SlideshowInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 商品实现类
 * wumaoxing
 * 2020-03-26 10:52
 */
@Service
public class GoodService {
    @Resource
    private GoodDao goodDao;
    @Resource
    private HotgoodDao hotgoodDao;
    @Resource
    private SlideshowDao slideshowDao;
//    @Autowired
//    private RedisOperator redisOperator;

    /**
     * 新增商品
     * wumaoxing
     * 2020-03-26 10:53
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGood(GoodInfo goodInfo) {
        //检验商品是否存在
        int countGoodAccount = goodDao.countGoodAccount(goodInfo);
        if (countGoodAccount != 0) {
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        goodInfo.setGoodsId(StringUtil.getCommonCode(2));
        //新增商品
        int count = goodDao.addGood(goodInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 商品详情
     * wumaoxing
     * 2020-04-21 13:51
     */
    public AppResponse findGoodsById(String goodsId) {
        return AppResponse.success("查询成功！", goodDao.findGoodsById(goodsId));
    }

    /**
     * 修改商品
     * wumaoxing
     * 2020-03-26 14:20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodById(GoodInfo goodInfo) {
        //检验商品是否存在
        int countGoodAccount = goodDao.countGoodAccount(goodInfo);
        if (countGoodAccount != 0) {
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        //修改商品
        int count = goodDao.updateGoodById(goodInfo);
        if (count == 0) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 删除商品
     * wumaoxing
     * 2020-03-28 10:24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGood(String goodsId, String updateUserId) {
        List<String> listDeleteGoodsId = Arrays.asList(goodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 检验商品是否在轮播图中或热门商品位中
        List<String> hotgoodList = hotgoodDao.queryHotgood(listDeleteGoodsId);
        List<String> slideshowList = slideshowDao.querySlideshow(listDeleteGoodsId);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < hotgoodList.size(); i++) {
            // 在轮播图中，map置为1
            map.put(hotgoodList.get(i), 1);
        }
        for (int i = 0; i < slideshowList.size(); i++) {
            // 在热门商品位中，map置为1
            map.put(slideshowList.get(i), 1);
        }
        List<String> newListDeleteGoodsId = new ArrayList<>();
        for (String deleteGoodsId : listDeleteGoodsId) {
            if (!map.containsKey(deleteGoodsId)) {
                newListDeleteGoodsId.add(deleteGoodsId);
            }
        }
        if (newListDeleteGoodsId.size() == 0) {
            return AppResponse.bizError("商品存在轮播图中或热门商品位中，不可删除，请重新输入！");
        }
        // 删除商品
        int count = goodDao.deleteGood(newListDeleteGoodsId, updateUserId);
        if (count == 0) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        } else if (listDeleteGoodsId.size() != count) {
            appResponse = AppResponse.success("部分商品删除成功，另一部分由于存在轮播图中或热门商品位中，不可删除");
        }
        return appResponse;
    }

    /**
     * 商品上下架
     * wumaoxing
     * 2020-03-28 10:41
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodState(String goodsId, String updateUserId, String goodsState) {
        List<String> listUpdateGoodsId = Arrays.asList(goodsId.split(","));
        if ("1".equals(goodsState)) {
            // 商品上架
            int count = goodDao.updateGoodState(listUpdateGoodsId, updateUserId, goodsState);
            if (count == 0) {
                return AppResponse.bizError("商品上架失败，请重试！");
            }
            return AppResponse.success("商品上架成功！");
        } else {
            // 检验商品是否在轮播图中或热门商品位中
            List<String> hotgoodList = hotgoodDao.queryHotgood(listUpdateGoodsId);
            List<String> slideshowList = slideshowDao.querySlideshow(listUpdateGoodsId);
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < hotgoodList.size(); i++) {
                // 在轮播图中，map置为1
                map.put(hotgoodList.get(i), 1);
            }
            for (int i = 0; i < slideshowList.size(); i++) {
                // 在热门商品位中，map置为1
                map.put(slideshowList.get(i), 1);
            }
            List<String> newListUpdateGoodsId = new ArrayList<>();
            for (String updateGoodsId : listUpdateGoodsId) {
                if (!map.containsKey(updateGoodsId)) {
                    newListUpdateGoodsId.add(updateGoodsId);
                }
            }
            if (newListUpdateGoodsId.size() == 0) {
                return AppResponse.bizError("商品存在轮播图中或热门商品位中，不可下架，请重新输入！");
            }
            // 商品下架
            int count = goodDao.updateGoodState(newListUpdateGoodsId, updateUserId, goodsState);
            if (count == 0) {
                return AppResponse.bizError("商品下架失败，请重试！");
            } else if (listUpdateGoodsId.size() != count) {
                return AppResponse.success("部分商品下架成功，另一部分由于存在轮播图中或热门商品位中，不可下架");
            }
            return AppResponse.success("商品下架成功！");
        }
    }

    /**
     * 查询商品分类
     * wumaoxing
     * 2020-03-28 11:09
     */
    public AppResponse queryGoodClassify(String lastClassifyId) {
        List<GoodClassifyDataInfo> tempDataInfos = goodDao.queryTempGoodClassify(lastClassifyId);
        return AppResponse.success("查询成功！", tempDataInfos);
    }

    /**
     * 商品分页列表
     * wumaoxing
     * 2020-03-28 11:29
     */
    public AppResponse listGoods(GoodInfo goodInfo) {
//        if( redisOperator.get(goodInfo.toString()) != null ){
//            System.out.println("从redis查数据");
//            PageInfo<GoodInfo> pageData = JsonUtils.fromJson(redisOperator.get(goodInfo.toString()),PageInfo.class);
//            return AppResponse.success("查询成功！",pageData);
//        }else{
        System.out.println("从mysql查数据");
        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<GoodInfo> goodInfoList = goodDao.listGoods(goodInfo);
        // 包装Page对象
        PageInfo<GoodInfo> pageData = new PageInfo<GoodInfo>(goodInfoList);
//            redisOperator.set(goodInfo.toString(), JsonUtils.toJson(pageData),300);
        return AppResponse.success("查询成功！", pageData);
//        }
    }
}
