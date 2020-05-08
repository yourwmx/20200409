package com.xzsd.app.comment.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.comment.dao.CommentDao;
import com.xzsd.app.comment.entity.CommentDataInfo;
import com.xzsd.app.comment.entity.CommentInfo;
import com.xzsd.app.good.dao.GoodDao;
import com.xzsd.app.good.entity.GoodInfo;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.photo.dao.PhotoDao;
import com.xzsd.app.photo.entity.PhotoInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Resource
    private CommentDao commentDao;

    @Resource
    private GoodDao goodDao;

    @Resource
    private PhotoDao photoDao;

    @Resource
    private OrderDao orderDao;

    /**
     * 对订单进行评价
     * wumaoxing
     * 2020-04-13 20:19
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse actionOrderComment(CommentDataInfo commentDataInfo){
        int count,flag = 0;
        List<PhotoInfo> photoInfoList = new ArrayList<>();
        List<CommentInfo> commentInfoList = new ArrayList<>();
        for(CommentInfo item: commentDataInfo.getList()) {
            //初始化
            item.setCreateBy(commentDataInfo.getCreateBy());
            item.setCustomerId(commentDataInfo.getCustomerId());
            item.setCommentId(StringUtil.getCommonCode(2));
            //判断是否有评价图片
            if (item.getList() != null) {
                flag = 1;
                for (PhotoInfo photo : item.getList()) {
                    photo.setPhotoId(StringUtil.getCommonCode(2));
                    photo.setCommentId(item.getCommentId());
                    photoInfoList.add(photo);
                }
            }
            commentInfoList.add(item);
        }
        //添加评论图片
        if(flag == 1) {
            count = photoDao.addPhoto(photoInfoList);
            if (count == 0) {
                return AppResponse.bizError("添加评论图片失败，请重试！");
            }
        }
        //加入评价列表
        count = commentDao.actionOrderComment(commentInfoList);
        if (count == 0) {
            return AppResponse.bizError("加入评价列表失败，请重试！");
        }
        //修改订单状态为已评价
        count = orderDao.updateOrderStateToFinishComment(commentDataInfo.getOrdersId(),"5");
        if (count == 0) {
            return AppResponse.bizError("修改订单状态失败，请重试！");
        }
        return AppResponse.success("评价成功！");
    }

    /**
     * 查询商品评价分页列表
     * wumaoxing
     * 2020-03-28 11:29
     */
    public AppResponse findGoodCommentById(CommentInfo commentInfo) {
        PageHelper.startPage(commentInfo.getPageNum(), commentInfo.getPageSize());
        List<CommentInfo> commentInfoList = commentDao.listComments(commentInfo);
        PageInfo<CommentInfo> pageData = new PageInfo<CommentInfo>(commentInfoList);
        return AppResponse.success("查询成功！",pageData);
    }
}
