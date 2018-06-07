package com.fxb.blog.persistence.mapper;

import com.fxb.blog.business.vo.NoticeConditionVO;
import com.fxb.blog.persistence.beans.SysNotice;
import com.fxb.blog.plugin.BaseMapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author  
 * @website  
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Repository
public interface SysNoticeMapper extends BaseMapper<SysNotice>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<SysNotice> findPageBreakByCondition(NoticeConditionVO vo);
}
