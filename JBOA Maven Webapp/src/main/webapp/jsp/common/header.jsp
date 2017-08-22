<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/nprogress.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/green.css"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/jqvmap.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/daterangepicker.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/custom.min.css"
	rel="stylesheet">
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span>办公自动化!</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="${pageContext.request.contextPath}/images/img.jpg"
								alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>欢迎!!!<s:property value="#session.userType.nameCn" /></span>
							<h2>${userSession.name }</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i>报销单管理 <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="#">查看报销单</a></li>
										<li><a
											href="${pageContext.request.contextPath}/jsp/claim/addVoucher.jsp">添加报销单</a></li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i> 请假管理 <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="#">查看请假</a></li>
										<li><a href="#">申请请假</a></li>
									</ul></li>
								<s:if test="#session.userType.id == 2">
									<li><a><i class="fa fa-desktop"></i> 统计报表 <span
											class="fa fa-chevron-down"></span></a>
										<ul class="nav child_menu">
											<li><a href="#">统计报表</a></li>
										</ul></li>
								</s:if>
								<li><a><i class="fa fa-desktop"></i> 信息中心 <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="#">个人信息</a></li>
									</ul></li>

							</ul>
						</div>


					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="设置"> <span
							class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="全屏"> <span
							class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="锁住"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="退出"
							href="${pageContext.request.contextPath}/logout.action"> <span
							class="glyphicon glyphicon-off" aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <img
									src="${pageContext.request.contextPath}/images/img.jpg" alt="">${userSession.name }
									<span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a
										href="${pageContext.request.contextPath}/logout.action"><i
											class="fa fa-sign-out pull-right"></i> 退出</a></li>
								</ul></li>

						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->