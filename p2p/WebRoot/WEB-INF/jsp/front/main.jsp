<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ include file="common/top.jsp"%>
<html>
<head>
<title>p2p网贷平台</title>
<style>
/*上下滚动*/
#scrollDiv {
	width: 400px;
	height: 30px;
	line-height: 30px;
	overflow: hidden;
}

#scrollDiv li {
	height: 30px;
	padding-left: 10px;
}
</style>

</head>
<body>
	<div class="flexslider">
		<ul class="slides">
			<li
				style="background-image: url(images/banner.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="#" target="_blank"></a></li>
			<li
				style="background-image: url(images/banner.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="#" target="_blank"></a></li>
			<li
				style="background-image: url(images/banner.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="#" target="_blank"></a></li>
			<li
				style="background-image: url(images/banner.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="# " target="_blank"></a></li>
			<li
				style="background-image: url(images/banner.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="#" target="_blank"></a></li>
		</ul>
	</div>



	<div class="ipubs">
		<span class="o1">累计投资金额:<strong>1,047,288,128.79</strong>元
		</span> <span class="o2">已还本息:<strong>400,507,750.81</strong>元
		</span><span class="o2">余额:<strong>677,679,983.07</strong>元
		</span><span class="o4">注册人数:<strong>20649</strong>人
		</span>
	</div>
	<div class="feature">
		<a class="fea1" href="#"> <i></i>
			<h3>高收益</h3> <span>年化收益率最高达“20%<br> 50元起投，助您轻松获收益
		</span>
		</a> <a class="fea2" href="#"> <i></i>
			<h3>安全理财</h3> <span>100%本息保障<br> 实物质押，多重风控审核
		</span>
		</a> <a class="fea3" href="#"> <i></i>
			<h3>随时赎回</h3> <span>两步赎回您的资金<br> 最快当日到账
		</span>
		</a> <a class="fea4" href="#"> <i></i>
			<h3>随时随地理财</h3> <span>下载手机客户端<br> 随时随地轻松理财
		</span>
		</a>
	</div>
	<!--中间内容-->
	<div class="main clearfix mrt30" data-target="sideMenu">
		<div class="wrap">
			<div class="page-left fn-left"></div>
			<div class="page-right fn-right" style="top: 0px;"></div>
		</div>
	</div>
	<div class="partners wrap clearfix mrb30">
		<div class="partners-inner ui-tab">
			<div class="hd">
				<div class="ui-tab-nav">
					<i class="icon icon-cur" style="left: 151px;"></i>
					<ul>
						<li class=""><a href="#">合作机构</a></li>
						<li class="active"><a href="#">友情链接</a></li>
					</ul>
				</div>
			</div>
			<div class="bd">
				<div class="ui-tab-cont">
					<div class="ui-tab-item active">
						<div class="img-scroll">
							<div class="container">
								<ul>
									<li><img src="images/logo_sbcvc.png" width="152"
										height="52" alt="软银"></li>
									<li><img src="images/logo_abc.png" width="152" height="52"
										alt="农业银行"></li>
									<li><img src="images/logo_wdzj.png" width="152"
										height="52" alt="网贷之家"></li>
									<li><img src="images/logo_baidu.png" width="152"
										height="52" alt="百度"></li>
									<li><img src="images/logo_aqb.png" width="152" height="52"
										alt="安全宝"></li>
									<li><img src="images/logo_gds.png" width="152" height="52"
										alt="万国数据"></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="ui-tab-item">
						<div class="links">
							<a target="_blank" href="http://www.htmlsucai.com">网贷互联</a> <a
								target="_blank" href="http://www.htmlsucai.com">北京证券网</a> <a
								target="_blank" href="http://www.htmlsucai.com">易贷微理财</a> <a
								target="_blank" href="http://www.htmlsucai.com">P2P</a> <a
								target="_blank" href="http://www.htmlsucai.com">网贷中国</a> <a
								target="_blank" href="http://www.htmlsucai.com">网贷帮手</a> <a
								target="_blank" href="https://www.okcoin.cn">比特币网</a> <a
								target="_blank" href="http://www.htmlsucai.com">网贷110</a> <a
								target="_blank" href="http://www.htmlsucai.com">招财猫理财</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="common/foot.jsp"%>
	<script type="text/javascript">
		// 上下滚动
		function AutoScroll(obj) {
			$(obj).find("ul:first").animate({
				marginTop : "-25px"
			},
				500,
				function() {
					$(this).css({
						marginTop : "0px"
					}).find("li:first").appendTo(this);
				});
		}
		$(document).ready(function() {
			var myar = setInterval('AutoScroll("#scrollDiv")', 3000);
			$("#scrollDiv").hover(function() {
				clearInterval(myar);
			},
				function() {
					myar = setInterval('AutoScroll("#scrollDiv")', 3000)
				}); //当鼠标放上去的时候，滚动停止，鼠标离开的时候滚动开始
		});
	</script>
	<script>
		$(function() {
			$('.flexslider').flexslider({
				directionNav : true,
				pauseOnAction : false
			});
			//产品列表滚动
			var pLength = $('.pListContentBox > li').length;
			var cishu = pLength - 4;
			var n = 0;
			$('.pListContentBox').css({
				'width' : pLength * 245 + 'px'
			});
			if (pLength > 4) {
				$('.pListRight').addClass('curr');
			}
			$('.pListRight').on('click', function() {
				if (cishu > 0) {
					//alert('1');
					n++;
					cishu--;
					$('.pListContentBox').animate({
						'left' : '-' + n * 244 + 'px'
					}, 500);
					if (cishu == 0) {
						$('.pListRight').removeClass('curr');
					}
					if (n > 0) {
						$('.pListLeft').addClass('curr');
					}
				}
			});
			$('.pListLeft').on('click', function() {
				if (n > 0) {
					n--;
					cishu++;
					$('.pListContentBox').animate({
						'left' : '-' + n * 244 + 'px'
					}, 500);
					if (n == 0) {
						$('.pListLeft').removeClass('curr');
					}
					if (cishu > 0) {
						$('.pListRight').addClass('curr');
					}
				}
			});
		//alert(pLength);
		});
	</script>
	<script type="text/javascript">
		var gaintop;
		$(function() {
			gaintop = $(".login_float").css("top");
			$(".login_float").css("top", -695);
			$(".login_float").show();
			$(".login_float").animate({
				top : gaintop,
				opacity : 1
			}, 800);
			$(".login_float").animate({
				top : '-=12px',
				opacity : 1
			}, 200);
			$(".login_float").animate({
				top : gaintop,
				opacity : 1
			}, 200);
			$(".login_float").animate({
				top : '-=6px',
				opacity : 1
			}, 200);
			$(".login_float").animate({
				top : gaintop,
				opacity : 1
			}, 200);
			$(".login_float").animate({
				top : '-=2px',
				opacity : 1
			}, 100);
			$(".login_float").animate({
				top : gaintop,
				opacity : 1
			}, 100);
		});
	</script>