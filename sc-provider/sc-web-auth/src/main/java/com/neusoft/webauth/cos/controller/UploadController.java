package com.neusoft.webauth.cos.controller;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.neusoft.webauth.utils.AppResponse;
import com.neusoft.webauth.utils.StringUtil;
import com.neusoft.webauth.utils.TencentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UploadController {
    //    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    // 问题：在一个工具类中，通过@Value来映射配置文件的值，得到的总是null
    // 原因：不能用new工具类的方式，应该是用容器注册（@Autowried）的方式使用此工具类，就能得到配置文件里的值
    @Autowired
    private TencentUtil tencentUtil;//不能通过new来调用


    /**
     * markdown图片上传到腾讯云
     * @param file
     * @return
     */
    @PostMapping("/uploadImage")
    public AppResponse uploadImage(@RequestParam("file") MultipartFile file){
        System.out.println(file.getContentType().substring(6));// image/png
        if (file.isEmpty()) {
            return AppResponse.bizError("上传失败，请选择文件");
        }
        COSClient cosClient = tencentUtil.tencentStart();
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = tencentUtil.getBucketName();
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-beijing.myqcloud.com/mydemo.jpg` 中，对象键为 mydemo.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = tencentUtil.getQianzhui() + "/"+ tencentUtil.getQianzhui()+ "_" + StringUtil.getCommonCode(2) + "." + file.getContentType().substring(6);
        File localFile = null;
        try {
            //将 MultipartFile 类型 转为 File 类型
            localFile = File.createTempFile("temp",null);
            file.transferTo(localFile);
        }catch (IOException e){
            return AppResponse.bizError("上传失败，请选择文件");
        }
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        Map<String,String> map = new HashMap <>();
        map.put("url",tencentUtil.getPath()+key);
        return AppResponse.success("",tencentUtil.getPath()+"/"+key);
    }
}
