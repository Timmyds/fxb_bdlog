
package com.fxb.blog.core.aspects;

import com.fxb.blog.business.entity.ArticleLook;
import com.fxb.blog.business.service.BizArticleLookService;
import com.fxb.blog.business.service.BizArticleService;
import com.fxb.blog.framework.holder.RequestHolder;
import com.fxb.blog.util.IpUtil;
import com.fxb.blog.util.SessionUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 文章浏览记录aop操作
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/18 11:48
 * @since 1.0
 */
@Component
@Aspect
@Order(1)
public class ArticleLookAspects {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleLookAspects.class);

    @Autowired
    private BizArticleService bizArticleService;
    @Autowired
    private BizArticleLookService articleLookService;

    @Pointcut("execution(* com.fxb.blog.controller.RenderController.article(..))")
    public void pointcut() {
        // 切面切入点
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            String userIp = IpUtil.getRealIp(RequestHolder.getRequest());
            Long articleId = (Long) args[1];
            if (!bizArticleService.isExist(articleId)) {
                LOGGER.warn("{}-该文章不存在！", articleId);
                return;
            }
            ArticleLook articleLook = new ArticleLook();
            articleLook.setArticleId(articleId);
            articleLook.setUserIp(userIp);
            articleLook.setLookTime(new Date());
            if (SessionUtil.getUser() != null) {
                articleLook.setUserId(SessionUtil.getUser().getId());
            }
            articleLookService.insert(articleLook);
        }
    }
}
