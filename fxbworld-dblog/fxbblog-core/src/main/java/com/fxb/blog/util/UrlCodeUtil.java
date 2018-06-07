package com.fxb.blog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * UrlEncoder & UrlDecoder
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/18 11:48
 * @since 1.0
 */
public class UrlCodeUtil {

    private static final Logger LOG = LoggerFactory.getLogger(UrlCodeUtil.class);
    private static final String URL_ENCODE = "UTF-8";

    private UrlCodeUtil() {
    }

    public static String encode(String param) {
        return encode(param, URL_ENCODE);
    }

    public static String encode(String param, String encode) {
        String result = null;
        if (!StringUtils.isEmpty(param)) {
            try {
                result = URLEncoder.encode(param, encode);
            } catch (UnsupportedEncodingException e) {
                LOG.error("url编码发生异常", e);
            }
        }
        return result;
    }

    public static String decode(String param) {
        return decode(param, URL_ENCODE);
    }

    public static String decode(String param, String encode) {
        String result = null;
        if (!StringUtils.isEmpty(param)) {
            try {
                result = URLDecoder.decode(param, encode);
            } catch (UnsupportedEncodingException e) {
                LOG.error("url编码发生异常", e);
            }
        }
        return result;
    }
}
