package com.xzsd.app.photo.dao;

import com.xzsd.app.photo.entity.PhotoInfo;

import java.util.List;

public interface PhotoDao {
    /**
     * 添加评论图片
     * wumaoxing
     * 2020-04-15 14:18
     */
    int addPhoto(List<PhotoInfo> photoInfoList);
}
