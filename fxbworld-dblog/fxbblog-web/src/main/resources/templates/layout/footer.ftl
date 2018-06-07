<#-- 搜索弹窗 -->
<div class="modal fade nav-search-box" tabindex="-1" role="dialog" aria-labelledby="navSearchModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header" style="padding: 5px 15px;">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="margin-top: 10px;"><span aria-hidden="true">&times;</span></button>
                <h4><i class="fa fa-search"></i> 搜索文章</h4>
            </div>
            <div class="modal-body">
                <form action="/" method="post" class="form-horizontal searchForm" id="searchForm">
                    <input type="hidden" name="pageNumber" value="1">
                    <div class="input-group bottom-line">
                        <input type="text" class="form-control br-none" name="keywords" value="${model.keywords}" required="required" placeholder="输入搜索内容">
                        <span class="input-group-btn">
                        <button class="btn btn-default br-none nav-search-btn pointer" type="submit"><i class="fa fa-search"></i> 搜索</button>
                    </span>
                    </div>
                    <div class="clear"></div>
                    <ul class="list-unstyled list-inline search-hot">
                        <li><strong style="position: relative;top: 2px;color: #999999;">热门搜索：</strong></li>
                        <li><a class="pointer" rel="external nofollow"><span class="label label-default">人像</span></a></li>
                        <li><a class="pointer" rel="external nofollow"><span class="label label-primary">后期</span></a></li>
                        <li><a class="pointer" rel="external nofollow"><span class="label label-success">风光</span></a></li>
                        <li><a class="pointer" rel="external nofollow"><span class="label label-info">ps</span></a></li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>
<!--评论弹框-->
<div class="modal fade bs-example-modal-sm" id="comment-detail-modal" tabindex="-1" role="dialog" aria-labelledby="comment-detail-modal-label">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="comment-detail-modal-label">评论信息框</h4>
                <small><i class="fa fa-lightbulb-o fa-fw"></i>可以通过QQ号实时获取昵称和头像</small>
            </div>
            <div class="modal-body">
                <form id="detail-form">
                    <input type="hidden" name="avatar">
                    <div class="form-group input-logo">
                        <input type="text" class="form-control" name="qq" placeholder="选填" value="">
                        <img class="pull-left hide" alt="">
                        <span class="fa fa-qq pull-left" aria-hidden="true">QQ</span>
                    </div>
                    <div class="form-group input-logo">
                        <input type="text" class="form-control" name="nickname" placeholder="必填" value="匿名">
                        <span class="fa fa-user pull-left" aria-hidden="true">昵称</span>
                    </div>
                    <div class="form-group input-logo">
                        <input type="text" class="form-control" name="email" placeholder="选填">
                        <span class="fa fa-envelope pull-left" aria-hidden="true">邮箱</span>
                    </div>
                    <div class="form-group input-logo">
                        <input type="text" class="form-control" name="url" placeholder="选填">
                        <span class="fa fa-globe pull-left" aria-hidden="true">网址</span>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-default btn-sm" id="detail-form-btn"><i class="fa fa-smile-o"></i>提交评论</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="reward" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <div class="rewardType" align="center">
                    <ul class="list-unstyle list-inline">
                        <li style="margin-right: 20px;">
                            <input type="radio" name="type" id="alipay" onclick="PaymentUtils.change(0)" data-index="0" checked="checked" ><span style="margin-left: 5px;">支付宝</span>
                        </li>
                        <li style="margin-right: 20px;">
                            <input type="radio" name="type" id="wechat" onclick="PaymentUtils.change(1)" data-index="1"><span style="margin-left: 5px;">微信</span>
                        </li>
                    </ul>
                </div>
                <div id="qrcode-container" align="center" style="margin-top: 10px;"></div>
                <div style="width: 100%;color: #a3a3a3;font-size: 16px;font-family: 'Microsoft YaHei';text-align: center;">
                    转账时请备注“<strong>博客赞助</strong>”
                </div>
            </div>
        </div>
        <small class="font-bold"></small>
    </div>
    <small class="font-bold"> </small>
</div>

<div id="loading">
    <div class="filter"></div>
    <div class="loader">
        <div class="loading-1"></div>
        <div class="loading-2">Loading...</div>
    </div>
</div>
<div class="clear blog-footer">
    <div class="container">
        <div class="col-xs-12 col-sm-4 col-md-4 text-left fade-in">
            <h4>其他链接</h4>
            <ul class="list-unstyled list-inline">
              	<li><a href="${config.siteUrl}/sitemap.html" target="_blank" title="网站地图" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-map-o fa-fw"></i>网站地图</a></li>
                <li><a href="${config.siteUrl}/recommended" title="文章推荐" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-thumbs-o-up fa-fw"></i>文章推荐</a></li>
                <li><a href="${config.siteUrl}/archives" title="归档目录" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-folder-o fa-fw"></i>归档目录</a></li>
                <li><a href="${config.siteUrl}/disclaimer" title="免责声明" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-file-o fa-fw"></i>免责声明</a></li>
            </ul>
        </div>
        <div class="col-xs-12 col-sm-4 col-md-4 text-left fade-in">
            <h4>关于本站</h4>
            <div style="padding: 4px;padding-left: 10px;">
                <p style="white-space: initial;">本站定位：个人分享</p>
                <p style="white-space: initial;">本站作用：摄影、旅游、户外等分享。</p>
            </div>
        </div>
    </div>
</div>
<footer class="footer">
    <div class="clear">
        <p>粤ICP备15112085号-1</p>
        <p>Copyright&copy;2016-${.now?string("yyyy")} ${config.siteName}</p>
    </div>
</footer>
<a class="to-top" title="点击返回顶部" data-toggle="tooltip" data-placement="bottom"></a>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery_lazyload/1.9.7/jquery.lazyload.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery-confirm/2.5.1/jquery-confirm.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/fancybox/2.1.5/jquery.fancybox.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery.bootstrapvalidator/0.5.1/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/js-xss/0.3.3/xss.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/nprogress/0.2.0/nprogress.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/mustache.js/2.3.0/mustache.min.js"></script>
<script type="text/javascript">
    var appConfig = {
        wwwPath: '${config.siteUrl}',
        staticPath: '${config.staticWebSite}'
    }
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "https://hm.baidu.com/hm.js?fd4c42a0eaacca4018beef9a247becf3";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })(); 
</script>
<script type="text/javascript" src="${config.staticWebSite}/js/wangEditor.min.js"></script>
<script type="text/javascript" src="${config.staticWebSite}/js/fxb.core.js"></script>
<script type="text/javascript" src="${config.staticWebSite}/js/fxb.js"></script>
<script type="text/javascript" src="${config.staticWebSite}/js/fxb.comment.js"></script>