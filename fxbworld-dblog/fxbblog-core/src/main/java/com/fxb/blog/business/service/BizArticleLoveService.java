package com.fxb.blog.business.service;


import com.fxb.blog.business.entity.ArticleLove;
import com.fxb.blog.business.vo.ArticleLoveConditionVO;
import com.fxb.blog.framework.object.AbstractService;
import com.github.pagehelper.PageInfo;

/**
 * 文章点赞
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface BizArticleLoveService extends AbstractService<ArticleLove, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<ArticleLove> findPageBreakByCondition(ArticleLoveConditionVO vo);
}
