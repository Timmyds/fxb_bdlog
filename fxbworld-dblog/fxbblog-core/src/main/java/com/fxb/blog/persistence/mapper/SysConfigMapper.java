package com.fxb.blog.persistence.mapper;

import com.fxb.blog.persistence.beans.SysConfig;
import com.fxb.blog.plugin.BaseMapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author  
 * @website  
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Repository
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    SysConfig get();

    Map<String, Object> getSiteInfo();
}
