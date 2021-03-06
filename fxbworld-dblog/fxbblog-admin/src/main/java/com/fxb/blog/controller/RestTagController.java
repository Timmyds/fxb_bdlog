
package com.fxb.blog.controller;

import com.fxb.blog.business.entity.Tags;
import com.fxb.blog.business.enums.ResponseStatus;
import com.fxb.blog.business.service.BizTagsService;
import com.fxb.blog.business.vo.TagsConditionVO;
import com.fxb.blog.framework.object.PageResult;
import com.fxb.blog.framework.object.ResponseVO;
import com.fxb.blog.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章标签管理
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@RestController
@RequestMapping("/tag")
public class RestTagController {
    @Autowired
    private BizTagsService tagsService;

    @PostMapping("/list")
    public PageResult list(TagsConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber() - 1, vo.getPageSize());
        PageInfo<Tags> pageInfo = tagsService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    @PostMapping(value = "/add")
    public ResponseVO add(Tags tags) {
        tagsService.insert(tags);
        return ResultUtil.success("标签添加成功！新标签 - " + tags.getName());
    }

    @PostMapping(value = "/remove")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        for (Long id : ids) {
            tagsService.removeByPrimaryKey(id);
        }
        return ResultUtil.success("成功删除 [" + ids.length + "] 个标签");
    }

    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.tagsService.getByPrimaryKey(id));
    }

    @PostMapping("/edit")
    public ResponseVO edit(Tags tags) {
        try {
            tagsService.updateSelective(tags);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("标签修改失败！");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }

    @PostMapping("/listAll")
    public ResponseVO listType() {
        return ResultUtil.success(null, tagsService.listAll());
    }

}
