<div class="col-sm-3 blog-sidebar">
   <!-- <#if articleDetail?exists>
        <div class="sidebar-module">
            <h5 class="sidebar-title"><i class="fa fa-hand-peace-o icon"></i><strong>说给你听</strong></h5>
            <div class="div-quote">
                <i class="fa fa-quote-left fa-fw"></i><p id="hitokoto" style="margin-left: 15px;"></p>
            </div>
        </div>
    <#else>
        <div class="sidebar-module" style="position: relative;">
            <h5 class="sidebar-title"><i class="fa fa-home icon"></i><strong>关于我</strong></h5>
            <div class="widget">
                <div id="feed_widget">
                    <div class="feed-about">
                        <div class="about-main">
                            <div class="about-img"><a href="${config.staticWebSite}/img/wx_300px.png" class="showImage" title="微信公众号"><img src="${config.staticWebSite}/img/wx_300px.png" alt="微信公众号"></a></div>
                            <div class="about-name">${config.siteName}</div>
                            <div class="about-the">${config.siteDesc?if_exists}</div>
                        </div>
                        <div class="clear"></div>
                       
                    </div>
                </div>
            </div>
        </div> 
    </#if>-->
       <#-- 热门推荐 -->
            <div class="blog-body clear overflow-initial">
                <h4 class="bottom-line"><i class="fa fa-fire icon"></i><strong>热门推荐</strong></h4>
                <ul class="list-unstyled">
                    <@articleTag method="hotList" pageSize="10">
                        <#if hotList?exists && (hotList?size > 0)>
                            <#list hotList as item>
                            <li class="line-li">
                                <div class="line-container">
                                    <div class="line-left">
                                        <#if item.coverImage?exists>
                                            <img class="lazy-img" data-original="${config.qiuniuBasePath}${item.coverImage}" src="${config.qiuniuBasePath}${item.coverImage}" width="50" height="50" rel="external nofollow"/>
                                        <#else>
                                            <img class="lazy-img" data-original="${config.staticWebSite}/img/favicon.ico" width="60" height="60" rel="external nofollow"/>
                                        </#if>
                                    </div>
                                    <div class="line-right">
                                        <div class="text">
                                            <a href="${config.siteUrl}/article/${item.id?c}" data-original-title="${item.lookCount?c}人浏览了该文章" data-toggle="tooltip" data-placement="bottom">
                                                ${item.title}
                                            </a>
                                        </div>
                                        <div class="text">
                                            <#--<div style="display: inline-block">热门指数：</div>-->
                                            <#--<div class="rating ignore" data-star="5"></div>-->
                                            <span class="views" title="" data-toggle="tooltip" data-placement="bottom" data-original-title="文章阅读次数"><i class="fa fa-eye fa-fw"></i>浏览(${item.lookCount!(0)})</span>
                                            <span class="comment" title="" data-toggle="tooltip" data-placement="bottom" data-original-title="文章评论次数">
                                                <a href="${config.siteUrl}/article/${item.id?c}#comment-box" rel="external nofollow">
                                                    <i class="fa fa-comments-o fa-fw"></i>评论(${item.commentCount!(0)})
                                                </a>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            </#list>
                        </#if>
                    </@articleTag>
                </ul>
                <div class="clear"></div>
            </div>

    <div class="sidebar-module">
        <h5 class="sidebar-title"><i class="fa fa-tags icon"></i><strong>文章标签</strong></h5>
        <ul class="list-unstyled list-inline">
            <@fxbTag method="tagsList" pageSize="10">
                <#if tagsList?exists && (tagsList?size > 0)>
                    <#list tagsList as item>
                        <li class="tag-li">
                            <a class="btn btn-default btn-xs" href="${config.siteUrl}/tag/${item.id?c}" title="${item.name?if_exists}" data-toggle="tooltip" data-placement="bottom">
                                ${item.name?if_exists}
                            </a>
                        </li>
                    </#list>
                </#if>
            </@fxbTag>
        </ul>
    </div>
    <@fxbTag method="recentComments" pageSize="10">
        <#if recentComments?? && recentComments?size gt 0>
            <div class="sidebar-module">
                <h5 class="sidebar-title"><i class="fa fa-comments icon"></i><strong>近期评论</strong></h5>
                <ul class="list-unstyled list-inline comments">
                <#list recentComments as item>
                    <li>
                        <a href="${item.sourceUrl}#comment-${item.id?c}" title="${item.briefContent?if_exists}" rel="external nofollow" data-toggle="tooltip" data-placement="bottom">
                            <img alt="${item.nickname?if_exists}" src="${item.avatar?if_exists}" class="avatar auto-shake" height="64" width="64" onerror="this.src='${config.staticWebSite}/img/user.png'" />
                            <span class="comment-author">${item.nickname?if_exists}</span> ${item.briefContent?if_exists}
                        </a>
                    </li>
                </#list>
                </ul>
            </div>
        </#if>
    </@fxbTag>
    <div class="sidebar-module">
        <ul class="nav nav-tabs sidebar-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab"><i class="fa fa-list"></i>近期文章</a></li>
            <li role="presentation"><a href="#home" aria-controls="home" role="tab" data-toggle="tab"><i class="fa fa-thumbs-o-up"></i>文章推荐</a></li>
            <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab"><i class="fa fa-hand-peace-o"></i>随机文章</a></li>
        </ul>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="profile">
                <ol class="list-unstyled">
                    <@articleTag method="recentArticles" pageSize="10">
                        <#if recentArticles?exists && (recentArticles?size > 0)>
                            <#list recentArticles as item>
                                <li>
                                    <span class="li-icon li-icon-${item_index + 1}">${item_index + 1}</span>
                                    <a href="${config.siteUrl}/article/${item.id?c}" title="${item.title}" data-toggle="tooltip" data-placement="bottom">
                                        ${item.title}
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </@articleTag>
                </ol>
            </div>
            <div role="tabpanel" class="tab-pane" id="home">
                <ol class="list-unstyled">
                    <@articleTag method="recommendedList" pageSize="10">
                        <#if recommendedList?exists && (recommendedList?size > 0)>
                            <#list recommendedList as item>
                                <li>
                                    <span class="li-icon li-icon-${item_index + 1}">${item_index + 1}</span>
                                    <a href="${config.siteUrl}/article/${item.id?c}" title="${item.title}" data-toggle="tooltip" data-placement="bottom">
                                        ${item.title}
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </@articleTag>
                </ol>
            </div>
            <div role="tabpanel" class="tab-pane" id="messages">
                <ol class="list-unstyled">
                    <@articleTag method="randomList" pageSize="10">
                        <#if randomList?exists && (randomList?size > 0)>
                            <#list randomList as item>
                                <li>
                                    <span class="li-icon li-icon-${item_index + 1}">${item_index + 1}</span>
                                    <a href="${config.siteUrl}/article/${item.id?c}" title="${item.title}" data-toggle="tooltip" data-placement="bottom">
                                        ${item.title}
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </@articleTag>
                </ol>
            </div>
        </div>
    </div>
<!--   
  <div class="sidebar-module">
        <h5 class="sidebar-title"><i class="fa fa-info icon"></i><strong>网站信息</strong></h5>
        <ul class="ul-default">
            <@fxbTag method="siteInfo">
                <li> <i class="fa fa-file fa-fw"></i>  文章总数：${siteInfo.articleCount!(0)} 篇</li>
                <li> <i class="fa fa-tags fa-fw"></i> 标签总数：${siteInfo.tagCount!(0)} 个</li>
                <li> <i class="fa fa-folder-open fa-fw"></i> 分类总数：${siteInfo.typeCount!(0)} 个</li>
                <li> <i class="fa fa-comments fa-fw"></i> 留言数量：${siteInfo.commentCount!(0)} 条</li>
                <li> <i class="fa fa-users fa-fw"></i> 在线人数：<span class="online">11</span>人</li>
                <li> <i class="fa fa-calendar fa-fw"></i> 运行天数：${siteInfo.buildSiteDate!(0)}天</li>
                <li> <i class="fa fa-pencil-square fa-fw"></i> 最后更新：${siteInfo.recordeTime}</li>
            </@fxbTag>
        </ul>
    </div>
 -->
    
</div>