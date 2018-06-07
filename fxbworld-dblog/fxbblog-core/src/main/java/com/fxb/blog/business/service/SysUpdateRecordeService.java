package com.fxb.blog.business.service;


import com.fxb.blog.business.entity.UpdateRecorde;
import com.fxb.blog.business.vo.UpdateRecordeConditionVO;
import com.fxb.blog.framework.object.AbstractService;
import com.github.pagehelper.PageInfo;

/**
 * 更新记录
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface SysUpdateRecordeService extends AbstractService<UpdateRecorde, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<UpdateRecorde> findPageBreakByCondition(UpdateRecordeConditionVO vo);
}
