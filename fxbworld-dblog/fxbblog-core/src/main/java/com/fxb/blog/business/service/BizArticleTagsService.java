package com.fxb.blog.business.service;


import com.fxb.blog.business.entity.ArticleTags;
import com.fxb.blog.business.vo.ArticleTagsConditionVO;
import com.fxb.blog.framework.object.AbstractService;
import com.github.pagehelper.PageInfo;

/**
 * 文章标签
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface BizArticleTagsService extends AbstractService<ArticleTags, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ArticleTags> findPageBreakByCondition(ArticleTagsConditionVO vo);

    /**
     * 通过文章id删除文章-标签关联数据
     *
     * @param articleId
     * @return
     */
    int removeByArticleId(Long articleId);

    /**
     * 批量添加
     *
     * @param tagIds
     * @param articleId
     */
    void insertList(Long[] tagIds, Long articleId);
}
