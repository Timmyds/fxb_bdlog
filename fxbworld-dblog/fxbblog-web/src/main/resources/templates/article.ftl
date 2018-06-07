<#include "include/macros.ftl">
<@header title="${article.title} | ${config.siteName}"
    keywords="${article.keywords?if_exists},${config.siteName}"
    description="${article.description?if_exists}"
    canonical="/article/${article.id}">
</@header>

<#if article.coverImage?exists>
    <img src="${config.qiuniuBasePath}${article.coverImage?if_exists}" onerror="this.src='${config.staticWebSite}/img/default_article_cover.jpg'" style="display: none;" id="cover-img">
</#if>
<div class="container custome-container">
    <nav class="breadcrumb">
        <a class="crumbs" title="返回首页" href="${config.siteUrl}" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-home"></i>首页</a>
        <i class="fa fa-angle-right"></i>
        <a href="${config.siteUrl}/type/${article.typeId}" title="点击查看该分类文章" data-toggle="tooltip" data-placement="bottom">${article.type.name}</a>
        <i class="fa fa-angle-right"></i>正文
    </nav>
    <div class="row">
        <div class="col-sm-8 blog-main">
            <div class="blog-body overflow-initial fade-in">
                <div class="article-flag">
                    <#if article.original?string('true','false') == 'true'>
                        <span class="article-blockquote article-blockquote-green"></span>
                        <span class="article-original article-original-green">
                            <a href="${config.siteUrl}/article/${article.id}">原创</a>
                        </span>
                    <#else>
                        <span class="article-blockquote article-blockquote-red"></span>
                        <span class="article-original article-original-red">
                            <a href="${config.siteUrl}/article/${article.id}">转载</a>
                        </span>
                    </#if>
                    <div class="blog-info-meta pull-right">
                        <ul class="list-unstyled list-inline">
                            <li><i class="fa fa-clock-o fa-fw"></i>发表于 ${article.createTime?string('yyyy年MM月dd日')}</li>
                            <li><i class="fa fa-eye fa-fw"></i><a class="pointer" data-original-title="${article.lookCount!(0)}人浏览了该文章" data-toggle="tooltip" data-placement="bottom">浏览 (<num>${article.lookCount!(0)}</num>)</a></li>
                            <li><a href="#comment-box" data-original-title="${article.commentCount!(0)}人评论了该文章" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-comments-o fa-fw"></i>评论 (${article.commentCount!(0)})</a></li>
                        </ul>
                    </div>
                </div>
                <div class="blog-info overflow-initial">
                    <div class="bottom-line">
                        <h1 class="blog-info-title">
                            <strong>${article.title}</strong>
                        </h1>
                    </div>
                    <div class="blog-info-body">
                        ${article.content}
                    </div>
                    <div class="separateline"><span>正文到此结束</span></div>
                    <div id="social" style="margin-bottom: 45px;">
                    <!--     <div class="social-main">
                            <span class="like">
                                <a href="javascript:;" data-id="${article.id?c}" title="点赞" ><i class="fa fa-thumbs-up"></i>赞 <i class="count"> ${article.loveCount!(0)}</i> </a>
                            </span>
                            <div class="shang-p">
                                <div class="shang-empty"><span></span></div>
                                <span class="shang-s"><a onclick="PaymentUtils.show();" style="cursor:pointer">赏</a> </span>
                            </div>
                            <div class="share-sd">
                                <span class="share-s"><a href="javascript:void(0)" id="share-s" title="分享"><i class="fa fa-share-alt"></i>分享</a></span>
                                <div id="share" style="display: none">
                                    <ul class="bdsharebuttonbox bdshare-button-style1-16" data-bd-bind=1234651>
                                        <li><a title="分享到人人网" class="fa fa-renren" data-cmd="renren" onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到腾讯微博" class="fa fa-pinterest-square" data-cmd="tqq" onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到QQ空间" class="fa fa-qq" data-cmd="qzone" onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到新浪微博" class="fa fa-weibo" data-cmd="tsina" onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到微信" class="fa fa-weixin" data-cmd="weixin" onclick="return false;" href="#"></a></li>
                                        <li><a title="更多" class="bds_more fa fa-plus-square" data-cmd="more" onclick="return false;" href="#"></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div> -->
                    </div>
                    <div class="article-footer overflow-initial">所属分类：<a href="${config.siteUrl}/type/${article.typeId}" data-original-title="点击查看${article.type.name}分类的文章" data-toggle="tooltip" data-placement="bottom">${article.type.name}</a></div>
                </div>
            </div>
            <div class="blog-body article-tag">
                <div class="cat">
                    <ul class="list-unstyled">
                        <li>
                            <strong>本文标签：</strong>
                                <#list article.tags as item>
                                    <a href="${config.siteUrl}/tag/${item.id?c}" class="c-label" data-original-title="${item.name}" data-toggle="tooltip" data-placement="bottom" target="_blank">${item.name}</a>
                                </#list>
                        </li>
                        <li>
                            <strong>版权声明：</strong>
                            <#if article.original?string('true','false') == 'true'>
                            本站原创文章，于${article.createTime?string('yyyy年MM月dd日')}由<a href="${config.siteUrl}" target="_blank" data-original-title="${config.siteName}" data-toggle="tooltip" data-placement="bottom"><strong>${config.authorName}</strong></a>发布，转载请注明出处
                            <#else>
                            本文为互联网转载文章，出处已在文章中说明(部分除外)。如果侵权，请<a target="_blank" href="mailto:fxbworld@163.com" title="点击给我发邮件" data-toggle="tooltip" data-placement="bottom"><strong>联系本站长</strong></a>删除，谢谢。
                            </#if>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- 广告
            <div class="blog-body">
                <a href="" target="_blank" rel="external nofollow">
                    <img src="${config.staticWebSite}/img/ad/aliyun_sale1000-60.png" alt="阿里云首购8折" class="img-responsive">
                </a>
            </div> -->
            <div class="blog-body prev-next">
                <nav class="nav-single wow" data-wow-delay="0.3s">
                    <#if other.prev>
                        <a href="${config.siteUrl}/article/${other.prev.id}" rel="prev">
                            <span class="meta-nav" data-original-title="${other.prev.title}" data-toggle="tooltip" data-placement="bottom"><span class="post-nav"><i class="fa fa-angle-left"></i> 上一篇</span>
                                <br>${other.prev.title}
                            </span>
                        </a>
                    <#else >
                        <a href="javascript:void(0)" rel="nofollow prev">
                            <span class="meta-nav" data-original-title="已经到第一篇了" data-toggle="tooltip" data-placement="bottom"><span class="post-nav"><i class="fa fa-angle-left"></i> 上一篇</span>
                                <br>已经到第一篇了
                            </span>
                        </a>
                    </#if>
                    <#if other.next>
                        <a href="${config.siteUrl}/article/${other.next.id}" rel="next">
                            <span class="meta-nav" data-original-title="${other.next.title}" data-toggle="tooltip" data-placement="bottom"><span class="post-nav">下一篇 <i class="fa fa-angle-right"></i></span>
                                <br>${other.next.title}
                            </span>
                        </a>
                    <#else >
                        <a href="${config.siteUrl}/article/1" rel="nofollow next">
                            <span class="meta-nav" data-original-title="已经到最后一篇了" data-toggle="tooltip" data-placement="bottom"><span class="post-nav">下一篇 <i class="fa fa-angle-right"></i></span>
                                <br>已经到最后一篇了
                            </span>
                        </a>
                    </#if>
                    <div class="clear"></div>
                </nav>
            </div>
             <#--评论-->
            <div class="blog-body clear overflow-initial expansion">
                <div id="comment-box" data-id="${article.id?c}"></div>
            </div>
            
            <#-- 相关文章 -->
            <div class="blog-body clear overflow-initial">
                <h4 class="bottom-line"><i class="fa fa-google-wallet icon"></i><strong>相关文章</strong></h4>
                <ul class="list-unstyled">
                    <#list relatedList as item>
                        <li class="line-li">
                            <div class="line-container">
                                <div class="line-right">
                                    <div class="text">
                                        <a href="${config.siteUrl}/article/${item.id?c}" data-original-title="${item.lookCount?c}人浏览了该文章" data-toggle="tooltip" data-placement="bottom">
                                            ${item.title}
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </#list>
                </ul>
                <div class="clear"></div>
            </div>
        </div>
        <#include "layout/sidebar.ftl"/>
    </div>
</div>
<@footer>
    <script src="https://v1.hitokoto.cn/?encode=js&c=d&select=%23hitokoto" defer></script>
</@footer>