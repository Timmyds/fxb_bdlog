package com.fxb.blog.business.vo;

import com.fxb.blog.business.entity.User;
import com.fxb.blog.framework.object.BaseConditionVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserConditionVO extends BaseConditionVO {
    private User user;
}
