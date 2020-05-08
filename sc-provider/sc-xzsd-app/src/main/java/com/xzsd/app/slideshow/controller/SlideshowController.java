package com.xzsd.app.slideshow.controller;

import com.xzsd.app.slideshow.service.SlideshowService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/slideshow")
public class SlideshowController {
    private static final Logger logger = LoggerFactory.getLogger(SlideshowController.class);

    @Resource
    private SlideshowService slideshowService;

    /**
     * 查询轮播图
     * wumaoxing
     * 2020-04-13 10:57
     */
    @RequestMapping(value = "listSlideshows")
    public AppResponse listSlideshows() {
        try {
            return slideshowService.listSlideshows();
        } catch (Exception e) {
            logger.error("查询轮播图异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
