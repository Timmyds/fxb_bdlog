
package com.fxb.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxb.blog.business.entity.Comment;
import com.fxb.blog.business.entity.Config;
import com.fxb.blog.business.entity.User;
import com.fxb.blog.business.enums.CommentStatusEnum;
import com.fxb.blog.business.enums.ResponseStatus;
import com.fxb.blog.business.enums.TemplateKeyEnum;
import com.fxb.blog.business.service.BizCommentService;
import com.fxb.blog.business.service.MailService;
import com.fxb.blog.business.service.SysConfigService;
import com.fxb.blog.business.vo.CommentConditionVO;
import com.fxb.blog.framework.exception.CommentException;
import com.fxb.blog.framework.object.PageResult;
import com.fxb.blog.framework.object.ResponseVO;
import com.fxb.blog.util.ResultUtil;
import com.fxb.blog.util.SessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 评论管理
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@RestController
@RequestMapping("/comment")
public class RestCommentController {
    @Autowired
    private BizCommentService commentService;
    @Autowired
    private SysConfigService configService;
    @Autowired
    private MailService mailService;

    @PostMapping("/list")
    public PageResult list(CommentConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<Comment> pageInfo = commentService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    @PostMapping(value = "/reply")
    public ResponseVO reply(Comment comment) {
        try {
            Config config = configService.get();
            User user = SessionUtil.getUser();
            comment.setQq(user.getQq());
            comment.setEmail(user.getEmail());
            comment.setNickname(user.getNickname());
            comment.setAvatar(user.getAvatar());
            comment.setUrl(config.getSiteUrl());
            comment.setUserId(user.getId());
            comment.setStatus(CommentStatusEnum.APPROVED.toString());
            commentService.comment(comment);
        } catch (CommentException e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("成功");
    }

    @PostMapping(value = "/remove")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        for (Long id : ids) {
            commentService.removeByPrimaryKey(id);
        }
        return ResultUtil.success("成功删除 [" + ids.length + "] 条评论");
    }

    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.commentService.getByPrimaryKey(id));
    }

    @PostMapping("/edit")
    public ResponseVO edit(Comment comment) {
        try {
            commentService.updateSelective(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("评论修改失败！");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }

    /**
     * 审核
     *
     * @param comment
     * @return
     */
    @PostMapping("/audit")
    public ResponseVO audit(Comment comment, Boolean sendEmail) {
        try {
            commentService.updateSelective(comment);
            if (null != sendEmail && sendEmail) {
                Comment commentDB = commentService.getByPrimaryKey(comment.getId());
                mailService.send(commentDB, TemplateKeyEnum.TM_COMMENT_AUDIT, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("评论审核失败！");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }

    /**
     * 正在审核的
     *
     * @param comment
     * @return
     */
    @PostMapping("/listVerifying")
    public ResponseVO listVerifying(Comment comment) {
        return ResultUtil.success(null, commentService.listVerifying(10));
    }

}
