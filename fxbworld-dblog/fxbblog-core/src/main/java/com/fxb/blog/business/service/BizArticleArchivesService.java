package com.fxb.blog.business.service;

import java.util.List;
import java.util.Map;

/**
 * 归档目录
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface BizArticleArchivesService {

    /**
     * 获取归档目录列表
     *
     * @return
     */
    Map<String, List> listArchives();
}
