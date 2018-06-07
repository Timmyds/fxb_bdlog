package com.fxb.blog.business.service;


import com.fxb.blog.business.dto.SysNoticeDTO;
import com.fxb.blog.business.entity.Notice;
import com.fxb.blog.business.vo.NoticeConditionVO;
import com.fxb.blog.framework.object.AbstractService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 系统通知
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface SysNoticeService extends AbstractService<Notice, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<Notice> findPageBreakByCondition(NoticeConditionVO vo);

    /**
     * 获取已发布的通知列表
     *
     * @return
     */
    List<SysNoticeDTO> listRelease();
}
