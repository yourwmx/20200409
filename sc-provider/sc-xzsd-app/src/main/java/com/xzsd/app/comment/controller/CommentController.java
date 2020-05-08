package com.xzsd.app.comment.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.comment.entity.CommentDataInfo;
import com.xzsd.app.comment.entity.CommentInfo;
import com.xzsd.app.comment.service.CommentService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Resource
    private CommentService commentService;
    
    /**
     * 对订单进行评价
     * wumaoxing
     * 2020-04-13 20:15
     */
    @PostMapping(value = "actionOrderComment")
    public AppResponse actionOrderComment(@RequestBody CommentDataInfo commentDataInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            commentDataInfo.setCreateBy(userId);
            return commentService.actionOrderComment(commentDataInfo);
        } catch (Exception e) {
            logger.error("对商品进行评价异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品评价分页列表
     * wumaoxing
     * 2020-04-13 17:27
     */
    @RequestMapping(value = "findGoodCommentById")
    public AppResponse findGoodCommentById(CommentInfo commentInfo) {
        try {
            return commentService.findGoodCommentById(commentInfo);
        } catch (Exception e) {
            logger.error("查询商品评价分页异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
