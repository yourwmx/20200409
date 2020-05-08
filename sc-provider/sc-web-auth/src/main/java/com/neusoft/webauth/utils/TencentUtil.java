package com.neusoft.webauth.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//省略 getter 和 setter 方法
@Component
@ConfigurationProperties(value = "spring.tengxun")
public class TencentUtil {
    @Value("${spring.tengxun.accessKey}")
    private String accessKey;
    @Value("${spring.tengxun.secretKey}")
    private String secretKey;
    @Value("${spring.tengxun.bucket}")
    private String bucket;
    @Value("${spring.tengxun.bucketName}")
    private String bucketName;
    @Value("${spring.tengxun.path}")
    private String path;
    @Value("${spring.tengxun.qianzhui}")
    private String qianzhui;
    @Value("${spring.tengxun.area}")
    private String area;

    public COSClient tencentStart(){
        System.out.println(accessKey);
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
        ClientConfig clientConfig = new ClientConfig(new Region(area));
        // 3 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getQianzhui() {
        return qianzhui;
    }

    public void setQianzhui(String qianzhui) {
        this.qianzhui = qianzhui;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
