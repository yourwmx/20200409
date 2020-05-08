package com.xzsd.app.hotgood.service;

import com.xzsd.app.dictionary.dao.DictionaryDao;
import com.xzsd.app.hotgood.dao.HotgoodDao;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HotgoodService {

    @Resource
    private HotgoodDao hotgoodDao;

    @Resource
    private DictionaryDao dictionaryDao;

    /**
     * 查询热门位商品
     * wumaoxing
     * 2020-04-13 14:46
     */
    public AppResponse listHotgoods(){
        //查询热门位商品展示数量
        String hotgoodShowNumber = dictionaryDao.queryVById("HotgoodShowNumber");
        return AppResponse.success("查询成功！",hotgoodDao.listHotgoods(Integer.parseInt(hotgoodShowNumber)));
    }
}
