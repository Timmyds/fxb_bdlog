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
public class SysConfig extends AbstractDO {
    private String homeDesc;
    private String homeKeywords;
    private String domain;
    private String siteUrl;
    private String siteName;
    private String siteDesc;
    private String siteFavicon;

    private String staticWebSite;
    private String authorName;
    private String authorEmail;

    private String wxCode;
    private String qq;
    private String weibo;
    private String github;
    private Boolean maintenance;
    private Date maintenanceData;
    private Boolean comment;
    private String qiuniuBasePath;
}
