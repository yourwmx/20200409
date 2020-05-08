package com.xzsd.app.slideshow.dao;

import com.xzsd.app.slideshow.entity.SlideshowInfo;

import java.util.List;

/**
 * SlideshowDao
 * wumaoxing
 * 2020-03-28 14:57
 */

public interface SlideshowDao {
    /**
     * 轮播图分页列表
     * wumaoxing
     * 2020-03-29 21:34
     */
    List<SlideshowInfo> listSlideshows();
}
