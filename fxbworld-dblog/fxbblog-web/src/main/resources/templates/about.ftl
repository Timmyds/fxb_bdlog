<#include "include/macros.ftl">
<@header title="关于 | ${config.siteName}"
    keywords="${config.siteName},关于博客"
    description="一个程序员的个人博客,关于我的个人原创博客 1111111111- ${config.siteName}"
    canonical="/about">
</@header>

<div class="container custome-container">
    <nav class="breadcrumb">
        <a class="crumbs" title="返回首页" href="${config.siteUrl}" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-home"></i>首页</a>
        <i class="fa fa-angle-right"></i>关于
    </nav>
    <div class="row">
        <@blogHeader title="关于本站"></@blogHeader>
        <div class="col-sm-12 blog-main">
        
                <h5 class="legend-title">关于我们</h5>
                <div class="info">
                   本站为非商业化站点，无盈利性质，主要是分享摄影、旅游、户外等分享。
                   因能力有限，可能部分内容并不能引起各位共鸣，若各位有那么一丝丝的空闲时间，劳烦各位能将我文章或者网站不足的地方提出来，欢迎留言给出你宝贵建议。
                </div>
                <h5 class="legend-title">关于版权</h5>
                <div class="info">
                    本站可能会有部分文章系从互联网上转载过来的。转载文章都会在文章中注明。但若因此造成侵权行为，烦请原作者<a target="_blank" href="fxbworld@163.com" title="点击给我发邮件" data-toggle="tooltip" data-placement="bottom" rel="external nofollow"><strong>告知</strong></a>，我会立刻删除相关内容。
                </div>
                <div class="alert alert-warning alert-dismissible simple-alert fade-in" role="alert">
                    <strong>注!</strong> 如果您觉得我的网站能够帮助到您，请您多多留言。！
                </div>
            </div>
        </div>
        <#--<div class="col-sm-12 blog-main">
            <div class="blog-body expansion">
                <div id="comment-box" data-id="-3"></div>
            </div>
        </div>-->
    </div>
</div>

<@footer>
    <script src="https://v1.hitokoto.cn/?encode=js&c=d&select=%23hitokoto" defer></script>
</@footer>
