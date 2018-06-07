package com.fxb.blog.business.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author  
 * @website  
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface RedisService {
    void set(String key, String value);

    void set(String key, String value, long expire, TimeUnit timeUnit);

    String get(String key);

    boolean expire(String key, long expire);

    void del(String key);

    <T> void setList(String key, List<T> list);

    <T> void setList(String key, List<T> list, long expire, TimeUnit timeUnit);

    <T> List<T> getList(String key, Class<T> clz);
}
