package com.fxb.blog.persistence.mapper;

import org.springframework.stereotype.Repository;

import com.fxb.blog.persistence.beans.BizArticleArchives;

import java.util.List;

/**
 * @author  
 * @website  
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Repository
public interface BizArticleArchivesMapper {

    List<BizArticleArchives> listArchives();
}
