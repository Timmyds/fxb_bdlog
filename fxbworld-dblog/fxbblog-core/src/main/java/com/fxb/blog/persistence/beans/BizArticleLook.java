package com.fxb.blog.persistence.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.fxb.blog.framework.object.AbstractDO;

/**
 * @author  
 * @website  
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizArticleLook extends AbstractDO {
    private Long articleId;
    private Long userId;
    private String userIp;
    private Date lookTime;
}
