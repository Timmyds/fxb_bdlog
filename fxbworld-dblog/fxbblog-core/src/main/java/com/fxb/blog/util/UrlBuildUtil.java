package com.fxb.blog.util;

import java.text.MessageFormat;

import com.fxb.blog.business.consts.ApiUrlConst;
import com.fxb.blog.business.consts.CommonConst;

/**
 * Url构建工具类
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/18 11:48
 * @since 1.0
 */
public class UrlBuildUtil {

    private static final String GET_LOCATION_BY_IP = "{0}?ak={1}&coor=gcj02&ip={2}";
    private static final String BAIDU_PUSH_URL_PATTERN = "{0}{1}?site={2}&token=d9qF4YmQKUzoTrD3";

    /**
     * 根据ip获取定位信息的接口地址
     *
     * @param ip
     *         用户IP
     * @return
     */
    public static String getLocationByIp(String ip) {
        return MessageFormat.format(GET_LOCATION_BY_IP, ApiUrlConst.BAIDU_API_GET_LOCATION_BY_IP, CommonConst.DEFAULT_BAIDU_AK, ip);
    }

    /**
     * 提交链接到百度的接口地址
     *
     * @param site
     *         待提交的站点
     * @return
     */
    public static String getBaiduPushUrl(String pushType, String site) {
        return MessageFormat.format(BAIDU_PUSH_URL_PATTERN, ApiUrlConst.BAIDU_PUSH_URL, pushType, site);
    }
}
