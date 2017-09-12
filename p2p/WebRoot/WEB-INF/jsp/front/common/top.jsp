<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>p2p网贷平台</title>
<!-- bootstrap -->
<link href="${pageContext.request.contextPath }/css/dropzone.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/animate.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/nprogress.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/custom.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/about.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/detail.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/fileupload.less.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/help.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/register.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/user.css"
	rel="stylesheet" />


</head>
<body>
	<header>
		<div class="header-top min-width">
			<div class="container fn-clear">
				<strong class="fn-left">咨询热线：400-888-8888<span
					class="s-time">服务时间：9:00 - 18:00</span></strong>
				<ul class="header_contact">
					<li class="c_1"><a class="ico_head_weixin" id="wx"></a>
						<div class="ceng" id="weixin_xlgz" style="display: none;">
							<div class="cnr">
								<img src="images/code.png">
							</div>
							<b class="ar_up ar_top"></b> <b class="ar_up_in ar_top_in"></b>
						</div></li>
					<li class="c_2"><a href="#" target="_blank" title="官方QQ"
						alt="官方QQ"><b class="ico_head_QQ"></b></a></li>
					<li class="c_4"><a href="#" target="_blank" title="新浪微博"
						alt="新浪微博"><b class="ico_head_sina"></b></a></li>
				</ul>
				<ul class="fn-right header-top-ul">
					<c:if test="${!empty userSession}">
						<li>&nbsp;&nbsp;欢迎${userSession.username}&nbsp;&nbsp;</li>
						<li><a class="js-login" title="退出"
							href="${pageContext.request.contextPath}/doLogout">退出</a></li>
					</c:if>
					<li><a href="${pageContext.request.contextPath}/main"
						class="app">返回首页</a></li>
					<c:if test="${empty userSession }">
						<li>
							<div class="">
								<a href="${pageContext.request.contextPath}/goRegister"
									class="c-orange" title="免费注册">免费注册</a>
							</div>
						</li>
						<li>
							<div class="">
								<a href="${pageContext.request.contextPath}/goLogin"
									class="js-login" title="登录">登录</a>
							</div>
						</li>
					</c:if>

					<c:if test="${userSession.r_id>1 }">
						<li><a href="${pageContext.request.contextPath}/back/main"
							class="js-login" title="后台管理">后台管理</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="header min-width">
			<div class="container">
				<div class="fn-left logo">
					<a class="" href="${pageContext.request.contextPath}/main"> <img
						src="images/logo.png" title="">
					</a>
				</div>
				<ul class="top-nav fn-clear">
					<li class="on"><a
						href="${pageContext.request.contextPath}/main">首页</a></li>
					<li><a
						href="${pageContext.request.contextPath}/front/invest/main"
						class="">我要投资</a></li>
					<li><a
						href="${pageContext.request.contextPath}/front/loan/main">我要融资</a></li>
					<li class="top-nav-safe"><a
						href="${pageContext.request.contextPath}/front/member/main">我的账户</a></li>
					<li><a
						href="${pageContext.request.contextPath}//company/CompanyProfile">关于我们</a></li>
				</ul>
			</div>
		</div>
	</header>