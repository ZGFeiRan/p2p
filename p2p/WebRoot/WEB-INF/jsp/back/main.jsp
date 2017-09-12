<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML >
<html>
<head>
<title>后台管理</title>
</head>

<body>
	<%@ include file="common/header.jsp"%>

	<!-- page content -->
	<div class="right_col" role="main">
		<div class="">
			<div class="page-title">
				<div class="title_left">
					<h3>欢迎管理员</h3>
					<h2>
						<a href="${pageContext.request.contextPath }/main">进入前台页面</a>
					</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- /page content -->


	<%@ include file="common/footer.jsp"%>
</body>
</html>
