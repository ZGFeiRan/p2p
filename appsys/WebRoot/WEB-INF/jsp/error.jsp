<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>错误页面</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath }/statics/css/nprogress.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath }/statics/css/custom.min.css"
	rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- page content -->
			<div class="col-md-12">
				<div class="col-middle">
					<div class="text-center">
						<h1>错误</h1>
						<h2>鬼才知道发生了什么</h2>
						<p>
							${exception.message } <a href="javascript:history.go(-1)">返回上个界面</a>
						</p>
						<div class="mid_center">
							<h3>Search</h3>
							<form>
								<div class="col-xs-12 form-group pull-right top_search">
									<div class="input-group">
										<input type="text" class="form-control"
											placeholder="Search for..."> <span
											class="input-group-btn">
											<button class="btn btn-default" type="button">Go!</button>
										</span>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath }/statics/js/fastclick.js"></script>
	<!-- NProgress -->
	<script
		src="${pageContext.request.contextPath }/statics/js/nprogress.js"></script>

	<!-- Custom Theme Scripts -->
	<script
		src="${pageContext.request.contextPath }/statics/js/custom.min.js"></script>
</body>
</html>