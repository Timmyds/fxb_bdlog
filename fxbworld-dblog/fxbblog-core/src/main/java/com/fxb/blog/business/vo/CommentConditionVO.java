package com.fxb.blog.business.vo;

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
public class CommentConditionVO extends BaseConditionVO {
	private Long userId;
	private Long sid;
	private Long pid;
	private String qq;
	private String email;
	private String url;
	private String status;
}

