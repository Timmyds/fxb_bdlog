package com.fxb.blog.persistence.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

import com.fxb.blog.framework.object.AbstractDO;

import java.util.List;

/**
 * @author  
 * @website  
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizArticle extends AbstractDO {
    @Transient
    List<BizTags> tags;
    @Transient
    BizType bizType;
    private String title;
    private Long userId;
    private String coverImage;
    private String qrcodePath;
    private String content;
    private Boolean top;
    private Long typeId;
    private Integer status;
    private Boolean recommended;
    private Boolean original;
    private String description;
    private String keywords;
    @Transient
    private Integer lookCount;
    @Transient
    private Integer commentCount;
    @Transient
    private Integer loveCount;
}
