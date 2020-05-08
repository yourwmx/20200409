package com.xzsd.app.slideshow.service;

import com.xzsd.app.slideshow.dao.SlideshowDao;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SlideshowService {

    @Resource
    private SlideshowDao slideshowDao;

    /**
     * 查询轮播图
     * wumaoxing
     * 2020-04-13 11:02
     */
    public AppResponse listSlideshows(){
        return AppResponse.success("查询成功！",slideshowDao.listSlideshows());
    }

}
