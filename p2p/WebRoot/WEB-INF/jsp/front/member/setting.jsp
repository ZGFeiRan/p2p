<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="common/header.jsp"%>
<div class="x_panel">
	<div class="x_title">
		<h2>账户设置</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">

		<table class="table">
			<tbody>
				<tr>
					<td>手机号</td>
					<td>${userSession.phone }</td>
					<td><a
						href="${pageContext.request.contextPath}/front/member/goPhoneUpdate"
						class="btn btn-round btn-primary">修改</a></td>
				</tr>
				<tr>
					<td>电子邮箱</td>
					<td>${userSession.email }</td>
					<td><a href="${pageContext.request.contextPath}/front/member/goEmailUpdate"
						class="btn btn-round btn-primary">修改</a></td>
				</tr>
				<tr>
					<td>登录密码</td>
					<td></td>
					<td><a
						href="${pageContext.request.contextPath}/front/member/goPasswordUpdate"
						class="btn btn-round btn-primary">修改</a></td>
				</tr>
				<tr>
					<td>支付密码</td>
					<td></td>
					<td><c:if test="${empty userSession.paymentpassword }">
							<a
								href="${pageContext.request.contextPath}/front/member/goZFPassword"
								class="btn btn-round btn-primary">添加</a>
						</c:if> <c:if test="${!empty userSession.paymentpassword }">
							<a
								href="${pageContext.request.contextPath}/front/member/goZFPassword"
								class="btn btn-round btn-primary">修改</a>
						</c:if></td>
				</tr>
			</tbody>
		</table>

	</div>
</div>
<%@ include file="common/footer.jsp"%>
