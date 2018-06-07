package com.fxb.blog.persistence.mapper;

import com.fxb.blog.business.vo.TypeConditionVO;
import com.fxb.blog.persistence.beans.BizType;
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
public interface BizTypeMapper extends BaseMapper<BizType>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizType> findPageBreakByCondition(TypeConditionVO vo);
}
