<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>

<title>办公管理系统首页</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="${pageContext.request.contextPath}/css/nprogress.css"
	rel="stylesheet">
<!-- Animate.css -->
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/css/custom.min.css"
	rel="stylesheet">
</head>
<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
			id="signin"></a>

		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					<form action="login.action">
						<h1>登录</h1>
						<div>
							<input type="text" class="form-control" placeholder="帐号"
								required="" name="sn" />
						</div>
						<div>
							<input type="password" class="form-control" placeholder="密码"
								required="" name="password" />
						</div>
						<div>
							<input type="submit" class="btn btn-default submit" value="登录">
							</div>

							<div class="clearfix"></div>

						<div class="separator">

							<div>
								<h1>
									<i class="fa fa-paw"></i> 办公管理系统
								</h1>
								<p>©2017</p>
							</div>
						</div>
					</form>
				</section>
			</div>

		</div>
	</div>
</body>
</html>
