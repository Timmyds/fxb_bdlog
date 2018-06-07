<#include "include/macros.ftl">
<@header title="留言板 | ${config.siteName}"
    keywords="${config.siteName},摄影,旅游,户外,游记博客"
    description="我的留言板,欢迎留言 - ${config.siteName}"
    canonical="/guestbook">
    <style>
        ul {
            list-style: none;
            margin-left: 0;
            padding-left: 0;
        }
    </style>
</@header>

<div class="container custome-container">
    <nav class="breadcrumb">
        <a class="crumbs" title="返回首页" href="${config.siteUrl}" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-home"></i>首页</a>
        <i class="fa fa-angle-right"></i>留言板
    </nav>
    <div class="row">
        <@blogHeader title="留言板"></@blogHeader>
        <div class="col-sm-12 blog-main">
            <div class="blog-body expansion">
                <div class="alert alert-default alert-dismissible" role="alert" style="padding: 0px;">
                    <ul>
                        <li><i class="fa fa-lightbulb-o fa-fw"></i> 随便留言，只要不是违反法律法规、反国家等危险言论。</li>
                        <li><i class="fa fa-heartbeat fa-fw"></i> 欢迎对本站的提出你的建议，吐槽！各种花式留言！</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-12 blog-main">
            <div class="blog-body expansion">
                <div id="comment-box" data-id="-1"></div>
            </div>
        </div>
    </div>
</div>

<@footer>
    <script src="https://v1.hitokoto.cn/?encode=js&c=d&select=%23hitokoto" defer></script>
</@footer>
