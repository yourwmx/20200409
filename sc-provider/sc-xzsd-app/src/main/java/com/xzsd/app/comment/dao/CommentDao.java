package com.xzsd.app.comment.dao;

import com.xzsd.app.comment.entity.CommentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
    /**
     * 查询商品评价分页列表
     * wumaoxing
     * 2020-04-13 17:33
     */
    List<CommentInfo> listComments(CommentInfo commentInfo);
    /**
     * 对订单进行评价
     * wumaoxing
     * 2020-04-13 20:42
     */
    int actionOrderComment(@Param("commentInfoList") List<CommentInfo> commentInfoList);
}
