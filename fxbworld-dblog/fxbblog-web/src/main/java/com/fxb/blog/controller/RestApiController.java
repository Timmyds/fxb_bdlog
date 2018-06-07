package com.fxb.blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fxb.blog.business.entity.Comment;
import com.fxb.blog.business.entity.Link;
import com.fxb.blog.business.enums.CommentStatusEnum;
import com.fxb.blog.business.service.BizArticleService;
import com.fxb.blog.business.service.BizCommentService;
import com.fxb.blog.business.service.SysLinkService;
import com.fxb.blog.business.service.SysNoticeService;
import com.fxb.blog.business.vo.CommentConditionVO;
import com.fxb.blog.framework.exception.ArticleException;
import com.fxb.blog.framework.exception.CommentException;
import com.fxb.blog.framework.exception.LinkException;
import com.fxb.blog.framework.object.ResponseVO;
import com.fxb.blog.util.RestClientUtil;
import com.fxb.blog.util.ResultUtil;

/**
 * 网站接口类，申请友链、评论、点赞等
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/18 11:48
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private SysLinkService sysLinkService;
    @Autowired
    private BizCommentService commentService;
    @Autowired
    private BizArticleService articleService;
    @Autowired
    private SysNoticeService noticeService;

    @PostMapping("/autoLink")
    public ResponseVO autoLink(@Validated Link link, BindingResult bindingResult) {
        LOG.info("申请友情链接......");
        LOG.info(JSON.toJSONString(link));
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            sysLinkService.autoLink(link);
        } catch (LinkException e) {
            LOG.error("客户端自助申请友链发生异常", e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("已成功添加友链，祝您生活愉快！");
    }

    @PostMapping("/qq/{qq}")
    public ResponseVO qq(@PathVariable("qq") String qq) {
        if (StringUtils.isEmpty(qq)) {
            return ResultUtil.error("");
        }
        Map<String, String> resultMap = new HashMap<>(4);
        String nickname = "匿名";
        String json = RestClientUtil.get("http://users.qzone.qq.com/fcg-bin/cgi_get_portrait.fcg?uins=" + qq, "GBK");
        if (!StringUtils.isEmpty(json)) {
            try {
                json = json.replaceAll("portraitCallBack|\\\\s*|\\t|\\r|\\n", "");
                json = json.substring(1, json.length() - 1);
                LOG.info(json);
                JSONObject object = JSONObject.parseObject(json);
                JSONArray array = object.getJSONArray(qq);
                nickname = array.getString(6);
            } catch (Exception e) {
                LOG.error("通过QQ号获取用户昵称发生异常", e);
            }
        }
        resultMap.put("avatar", "https://q1.qlogo.cn/g?b=qq&nk=" + qq + "&s=40");
        resultMap.put("nickname", nickname);
        resultMap.put("email", qq + "@qq.com");
        resultMap.put("url", "https://user.qzone.qq.com/" + qq);
        return ResultUtil.success(null, resultMap);
    }

    @PostMapping("/comments")
    public ResponseVO comments(CommentConditionVO vo) {
        vo.setStatus(CommentStatusEnum.APPROVED.toString());
        return ResultUtil.success(null, commentService.list(vo));
    }

    @PostMapping("/comment")
    public ResponseVO comment(Comment comment) {
        try {
            commentService.comment(comment);
        } catch (CommentException e) {
            LOG.error("评论发生异常", e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("评论发表成功，系统正在审核，请稍后刷新页面查看！");
    }

    @PostMapping("/doSupport/{id}")
    public ResponseVO doSupport(@PathVariable("id") Long id) {
        try {
            commentService.doSupport(id);
        } catch (CommentException e) {
            LOG.error("评论点赞发生异常", e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("");
    }

    @PostMapping("/doOppose/{id}")
    public ResponseVO doOppose(@PathVariable("id") Long id) {
        try {
            commentService.doOppose(id);
        } catch (CommentException e) {
            LOG.error("评论点踩发生异常", e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("");
    }

    @PostMapping("/doPraise/{id}")
    public ResponseVO doPraise(@PathVariable("id") Long id) {
        try {
            articleService.doPraise(id);
        } catch (ArticleException e) {
            LOG.error("文章点赞发生异常", e);
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("");
    }

    @PostMapping("/listNotice")
    public ResponseVO listNotice() {
        return ResultUtil.success("", noticeService.listRelease());
    }

}
