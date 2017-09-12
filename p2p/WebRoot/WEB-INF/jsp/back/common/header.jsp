<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!
DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>后台管理</title>
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
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="${pageContext.request.contextPath }/back/main"
							class="site_title"><i class="fa fa-cogs"></i> <span>后台管理</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="${pageContext.request.contextPath }/images/img.jpg"
								alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>欢迎</span>
							<h2>${userSession.username }</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>后台管理</h3>
							<ul class="nav side-menu">
								<li><a href="${pageContext.request.contextPath }/back/main"><i
										class="fa fa-home"></i> 首页 <span class="fa "></span></a>
								<li><a><i class="fa fa-cubes"></i> 借款标管理 <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="${pageContext.request.contextPath }/back/borrow/goBorrowList">借款列表</a></li>
										<li><a
											href="${pageContext.request.contextPath }/back/borrow/goBorrowCheck">标的审核</a></li>
										<li><a
											href="${pageContext.request.contextPath }/back/borrow/goMakeLoan">标的放款</a></li>
									</ul></li>
								<li><a><i class="fa fa-credit-card"></i>充值提现<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="${pageContext.request.contextPath }/back/Recharge">充值记录</a></li>
										<li><a
											href="${pageContext.request.contextPath }/back/goTixian">提现记录</a></li>
									</ul></li>
								<li><a><i class="fa fa-male"></i>会员管理<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="${pageContext.request.contextPath }/back/goMemberList">会员列表</a></li>

									</ul></li>
								<li><a><i class="fa fa-cog"></i>系统管理 <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="${pageContext.request.contextPath }/back/adminList">管理员信息</a></li>
										<li><a
											href="${pageContext.request.contextPath }/back/goRoleList">角色信息</a></li>
									</ul></li>
								<li><a><i class="fa fa-bars"></i>基础资料设置<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="${pageContext.request.contextPath }/back/goLoanpList">借款用途</a></li>
										<li><a
											href="${pageContext.request.contextPath }/back/goRepayMList">还款方式</a></li>
										<li><a
											href="${pageContext.request.contextPath }/back/goBankInfoList">银行信息</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
					<!-- /sidebar menu -->

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
									src="${pageContext.request.contextPath }/images/img.jpg" alt="">${userSession.username }<span
									class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="${pageContext.request.contextPath }/doLogout"><i
											class="fa fa-sign-out pull-right"></i> 退出</a></li>
								</ul></li>


						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->