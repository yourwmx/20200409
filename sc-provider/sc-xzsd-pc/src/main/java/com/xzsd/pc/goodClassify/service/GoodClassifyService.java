package com.xzsd.pc.goodClassify.service;

import com.xzsd.pc.good.dao.GoodDao;
import com.xzsd.pc.goodClassify.dao.GoodClassifyDao;
import com.xzsd.pc.goodClassify.entity.GoodClassifyCateInfo;
import com.xzsd.pc.goodClassify.entity.GoodClassifyInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类实现类
 * wumaoxing
 * 2020-03-26 15:00
 */
@Service
public class GoodClassifyService {

    @Resource
    private GoodClassifyDao goodClassifyDao;

    @Resource
    private GoodDao goodDao;

    /**
     * 新增商品分类
     * wumaoxing
     * 2020-03-26 15:00
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodClassify(GoodClassifyInfo goodClassifyInfo) {
        //检验商品分类是否存在
        int countGoodClassifyAccount = goodClassifyDao.countGoodClassifyAccount(goodClassifyInfo);
        if (countGoodClassifyAccount != 0) {
            return AppResponse.bizError("商品分类已存在，请重新输入！");
        }
        //检验商品分类是否为第三级分类
        if("0".equals(goodClassifyInfo.getLastClassifyId()) == false){
            //查询是否为一级分类
            String lastClassify = goodClassifyDao.queryLastClassifyById(goodClassifyInfo.getLastClassifyId());
            if("0".equals(lastClassify) == false){
                return AppResponse.bizError("不可添加第三级的商品分类，请重新输入！");
            }
        }
        goodClassifyInfo.setClassifyId(StringUtil.getCommonCode(2));
        //新增商品分类
        int count = goodClassifyDao.addGoodClassify(goodClassifyInfo);
        if (count == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 修改商品分类
     * wumaoxing
     * 2020-03-26 16:19
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodClassifyById(GoodClassifyInfo goodClassifyInfo) {
        //检验商品分类是否存在
        int countGoodClassifyAccount = goodClassifyDao.countGoodClassifyAccount(goodClassifyInfo);
        if (countGoodClassifyAccount != 0) {
            return AppResponse.bizError("商品分类已存在，请重新输入！");
        }
        //修改商品分类
        int count = goodClassifyDao.updateGoodClassifyById(goodClassifyInfo);
        if (count == 0) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 删除商品分类
     * wumaoxing
     * 2020-03-26 16:19
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodClassifyById(String classifyId, String updateUserId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 查询是否有二级分类
        int count = goodClassifyDao.queryHaveSecondGoodClassify(classifyId);
        if (count != 0) {
            return AppResponse.bizError("商品分类下有二级分类，请重试！");
        }
        // 查询商品分类下是否有商品
        count = goodDao.queryGoodByGoodClassify(classifyId);
        if (count != 0) {
            return AppResponse.bizError("商品分类下有商品，请重试！");
        }
        // 删除商品分类
        count = goodClassifyDao.deleteGoodClassifyById(classifyId, updateUserId);
        if (count == 0) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 查询商品分类
     * wumaoxing
     * 2020-03-27 10:32
     */
    public AppResponse queryGoodClassify() {
        List<GoodClassifyCateInfo> tempDataInfos = goodClassifyDao.queryGoodClassify();
        return AppResponse.success("查询成功！", tempDataInfos);
    }

    /**
     * 商品分类详情
     * wumaoxing
     * 2020-03-27 14:33
     */
    public AppResponse findGoodClassifyById(String classifyId) {
        GoodClassifyInfo goodClassifyInfo = goodClassifyDao.findGoodClassifyById(classifyId);
        return AppResponse.success("查询成功！", goodClassifyInfo);
    }
}
