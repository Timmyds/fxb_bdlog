package com.fxb.blog.framework.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {

    public Boolean enableKaptcha;

    public boolean getEnableKaptcha() {
        return null == enableKaptcha ? false : enableKaptcha;
    }

    public Map<String, String> qiniu = new HashMap<>();

    public String getQiniuAccessKey() {
        return this.qiniu.get("accessKey");
    }

    public String getQiniuSecretKey() {
        return this.qiniu.get("secretKey");
    }

    public String getQiniuBucketName() {
        return this.qiniu.get("bucketName");
    }

}
