<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
.ui-fileupload-choose {
	background: none;
	width: 90px;
	height: 90px;
	border: 0px none;
}

.ui-fileupload-choose input {
	width: 100%;
	height: 100%;
}

.ui-icon {
	background: none;
	width: 0px;
	height: 0px;
}
</style>
<%@ include file="common/header.jsp"%>

<!-- 内容   开始 -->
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
<div class="pmain-profile">
	<div class="pmain-welcome">
		<c:if test="${now.hours<12 }">
			<span class="fl"><span id="outLogin">早上好，</span>${userSession.username}
				喝一杯奶茶茶，让心情放松一下~</span>
		</c:if>
		<c:if test="${now.hours>12 and now.hours<20}">
			<span class="fl"><span id="outLogin">下午好，</span>${userSession.username}
				喝一杯下午茶，让心情放松一下~</span>
		</c:if>
		<c:if test="${now.hours>20}">
			<span class="fl"><span id="outLogin">晚上好，</span>${userSession.username}
				喝一杯咖啡茶，精神一下~</span>
		</c:if>
		<span class="fr">注册时间： <fmt:formatDate
				value="${member.registrationtime}" type="both" />
		</span>
	</div>
	<div class="pmain-user">
		<div class="user-info user-info1">
			<ul>
				<li>用户名<span>${member.username}</span></li>
				<c:if test="${empty member.paymentpassword}">
					<li>您还未设置支付密码，请 <a class="pmain-log"
						href="${pageContext.request.contextPath}/front/member/goZFPassword">立即设置</a>以确保您的正常使用和资金安全。
					</li>
				</c:if>
				<li>当前资金<span>${fund_account.amount}</span></li>
				<li>最后发生变化时间<span><fmt:formatDate
							value="${fund_account.update_date}" type="both" /></span></li>

			</ul>
		</div>
	</div>

</div>

</div>

<!-- 内容   结束 -->

<%@ include file="common/footer.jsp"%>
