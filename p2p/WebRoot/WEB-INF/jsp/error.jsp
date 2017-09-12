<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>发送错误</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath }/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="${pageContext.request.contextPath }/css/nprogress.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath }/css/custom.min.css"
	rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- page content -->
			<div class="col-md-12">
				<div class="col-middle">
					<div class="text-center text-center">
						<h2>${exception.message }</h2>
						<p>
							${exception } <br> 你可以前往 <a
								href="${pageContext.request.contextPath }">首页</a>或者返回
							<button class="btn btn-round btn-primary syy">上一页</button>
						</p>

					</div>
				</div>
			</div>
			<!-- /page content -->
		</div>
	</div>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="${pageContext.request.contextPath }/js/fastclick.js"></script>
	<!-- NProgress -->
	<script src="${pageContext.request.contextPath }/js/nprogress.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="${pageContext.request.contextPath }/js/custom.min.js"></script>
	<script type="text/javascript">
		$(".syy").on("click", function() {
			window.history.go(-1);
		})
	</script>
</body>
</html>
