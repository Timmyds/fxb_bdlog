
package com.fxb.blog.business.consts;

/**
 * 程序中公用的常量类
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public class CommonConst {
    /**
     * 安全密码(UUID生成)，作为盐值用于用户密码的加密
     */
    public static final String FXB_SECURITY_KEY = "929123f8f17944e8b0a531045453e1f1";

    /**
     * 百度api授权AK
     * 获取地址：http://lbsyun.baidu.com/apiconsole/key
     */
    public static final String DEFAULT_BAIDU_AK = "niQOw5lqctDZTyGTDb5KILudZCCArn82";

    /**
     * 程序默认的错误状态码
     */
    public static final int DEFAULT_ERROR_CODE = 500;

    /**
     * 程序默认的成功状态码
     */
    public static final int DEFAULT_SUCCESS_CODE = 200;

}
