package com.xzsd.app.goodClassify.service;

import com.xzsd.app.goodClassify.dao.GoodClassifyDao;
import com.xzsd.app.goodClassify.entity.GoodClassifyFirstInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

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

    /**
     * 查询商品一级分类
     * wumaoxing
     * 2020-03-27 10:32
     */
    public AppResponse queryGoodClassify() {
        List<GoodClassifyFirstInfo> tempDataInfos = goodClassifyDao.queryGoodClassify();
        return AppResponse.success("查询成功！", tempDataInfos);
    }
}
