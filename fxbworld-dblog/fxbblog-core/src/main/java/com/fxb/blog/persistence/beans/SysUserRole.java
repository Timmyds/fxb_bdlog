package com.fxb.blog.persistence.beans;

import com.fxb.blog.framework.object.AbstractDO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author  
 * @website  
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRole extends AbstractDO {
    private Long userId;
    private Long roleId;
}