<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>左侧菜单栏</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<link href="${pageContext.request.contextPath}/css/about.css"
	rel="stylesheet" type="text/css">
<body>
	<div class="text-nav">
		<ul class="clearfix">
			<li><a class="text-link"
				href="${pageContext.request.contextPath}/company/companyProfile">公司简介</a>
			</li>
			<li><a class="text-link"
				href="${pageContext.request.contextPath}/company/TeamManagement">管理团队</a>
			</li>
			<li><a class="text-link"
				href="${pageContext.request.contextPath}/company/CooperativePartner">合作伙伴</a>
			</li>
			<li><a class="text-link"
				href="${pageContext.request.contextPath}/company/TeamPresence">团队风采</a>
			</li>
			<li><a class="text-link"
				href="${pageContext.request.contextPath}/company/LegalPolicy">法律政策</a>
			</li>
			<li><a class="text-link"
				href="${pageContext.request.contextPath}/company/LegalStatement">法律声明</a>
			</li>
			<li><a class="text-link"
				href="${pageContext.request.contextPath}/company/TariffDescription">资费说明</a>
			</li>
			<li><a class="text-link"
				href="${pageContext.request.contextPath}/company/ConnectionOut">联系我们</a>
			</li>
		</ul>
	</div>
</body>
</html>
