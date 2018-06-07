package com.fxb.blog.business.service;


import com.fxb.blog.business.entity.Article;
import com.fxb.blog.business.vo.ArticleConditionVO;
import com.fxb.blog.framework.object.AbstractService;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 文章列表
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface BizArticleService extends AbstractService<Article, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<Article> findPageBreakByCondition(ArticleConditionVO vo);

    /**
     * 站长推荐
     *
     * @param pageSize
     * @return
     */
    List<Article> listRecommended(int pageSize);

    /**
     * 近期文章
     *
     * @param pageSize
     * @return
     */
    List<Article> listRecent(int pageSize);

    /**
     * 随机文章
     *
     * @param pageSize
     * @return
     */
    List<Article> listRandom(int pageSize);

    /**
     * 获取热门文章
     *
     * @return
     */
    List<Article> listHotArticle(int pageSize);

    /**
     * 根据某篇文章获取与该文章相关的文章
     *
     * @return
     */
    List<Article> listRelatedArticle(int pageSize, Article article);

    /**
     * 获取上一篇和下一篇
     *
     * @param insertTime
     * @return
     */
    Map<String, Article> getPrevAndNextArticles(Date insertTime);

    /**
     * 文章点赞
     *
     * @param id
     */
    void doPraise(Long id);

    /**
     * 是否存在文章
     *
     * @param id
     * @return
     */
    boolean isExist(Long id);

    /**
     * 获取素材库
     *
     * @return
     */
    List<String> listMaterial();

}
