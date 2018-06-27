function initNavbar() {
    $(".navbar .navbar-nav li").each(function () {
        var $this = $(this);
        if ($this.hasClass("dropdown")) {
            $this.on("mouseover", function () {
                $this.addClass("open").find("a:first-child").attr("aria-expanded", "true");
            }).on("mouseout", function () {
                $this.removeClass("open").find("a:first-child").attr("aria-expanded", "false");
            });
        }
        $this.find("a").each(function () {
            var $this = $(this);
            var $parent = $this.parent();
            $parent.removeClass("active");
            if ($this.attr("href") === $.tool.currentPath()) {
                $parent.toggleClass("active");
            }
        });
    });
}
var PaymentUtils = window.payment || {
    config: [{url: appConfig.staticPath + '/img/alipay_nb.jpg', desc: '支付宝转账'},{url: appConfig.staticPath + '/img/wechat_nb.jpg', desc: '微信转账'}],
    show : function () {
        $("#reward").modal('show');
        this.change(0);
        $("#reward input").on('ifChecked', function(event){
            var index = $(this).data("index");
            PaymentUtils.change(index);
        });
    },
    hide : function () {
        $("#reward").modal('hide');
    },
    change: function (index) {
        var config = this.config[index];
        $("#qrcode-container").empty();
        $('<img  src="' + config.url + '" style="width: 250px;height: 250px;" alt="'+config.desc+'">').appendTo($("#qrcode-container"));
    }

};
$(function () {

    $(document).ready(function () {
        NProgress.start();
    });
    $(window).load(function () {
        NProgress.done();
    });

    initNavbar();

    $('.to-top').toTop({
        autohide: true,//返回顶部按钮是否自动隐藏。可以设置true或false。默认为true
        offset: 100,//页面滚动到距离顶部多少距离时隐藏返回顶部按钮。默认值为420
        speed: 500,//滚动和渐隐的持续时间，默认值为500
        right: 25,//返回顶部按钮距离屏幕右边的距离，默认值为15
        bottom: 50//返回顶部按钮距离屏幕顶部的距离，默认值为30
    });

    $("[data-toggle='tooltip']").tooltip();
    $('[data-toggle="popover"]').popover();

    // 图片预览
    $(".showImage").fancybox();

    // # NProgress页面顶部进度条
    $(document).ajaxStart(function () {
        NProgress.start();
    }).ajaxStop(function () {
        NProgress.done();
    });
    // Loading弹窗
    // $(document).ajaxStart(function () {
    //     $("#loading").show();
    // }).ajaxStop(function () {
    //     $("#loading").hide();
    // });

    if ($("#scrolldiv")) {
        $("#scrolldiv").textSlider({line: 1, speed: 300, timer: 5000});
    }

    if ($.rating) {
        $.rating.init(5);
    }


    getCurrentDate();
    setInterval(function () {
        getCurrentDate();
    }, 1000);
    function getCurrentDate(){
        var now = new Date();
        var weekArr = new Array('星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六');
        $("#currentTime").html(now.format('yyyy年MM月dd日 hh时mm分ss秒') + " " + weekArr[now.getDay()]);
    }

    $.websocket.open({
        host: "ws://www.fxbworld.cn/websocket",
        reconnect: true,
        callback: function (json) {
            var onlineCount = json;
            $(".online").html(onlineCount);
        }
    });

    /**
     * 显示取链的表格
     */
    $(".showContent").click(function () {
        $(this).toggleClass('fa-plus-square fa-minus-square');
        // $(".disable-content").toggleClass('fade-in hide');
        $(".disable-content").slideToggle(400);
    });

    if(/iphone|ipod|ipad|ipad|mobile/i.test(navigator.userAgent.toLowerCase())){
        $('.share-sd').click(function() {
            $('#share').animate({
                        opacity: 'toggle',
                        top: '-80px'
                    },
                    500).animate({
                        top: '-60px'
                    },
                    'fast');
            return false;
        });
    } else {
        $(".share-sd").mouseover(function() {
            $(this).children("#share").show();
        });
        $(".share-sd").mouseout(function() {
            $(this).children("#share").hide();
        });
    }

    $("img.lazy-img").lazyload({
        placeholder : appConfig.staticPath + "/img/loading.gif",
        effect: "fadeIn",
        threshold: 100
    });
    $(window).bind("load", function() {
        var timeout = setTimeout(function() {
            $("img.lazy-img").trigger("sporty");
        }, 3000);
    });

    /* 热门搜索标签点击事件 */
    $(".search-hot li").click(function () {
        var $this = $(this);
        var text = $this.find("a span").text();
        $this.parents(".searchForm").find("input[name=keywords]").val(text);
        $this.parents(".searchForm").find(".nav-search-btn").click();
    });

    /* 分页按钮点击事件 */
    $(".page-btn li a").click(function () {
        var $this = $(this);
        var $parents = $this.parents(".page-btn");
        var search = $parents.data("search");
        var url = $parents.data("url");
        var pageNum = $this.data("page") || 1;
        if(!pageNum){
            return;
        }
        var action = url + "/" + pageNum;

        if(search){
            $("#searchForm").find("input[name=pageNumber]").val(pageNum);
            $(".nav-search-btn").click();
        } else {
            window.location.href = action;
        }
    });
});
