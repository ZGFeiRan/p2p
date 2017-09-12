<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/top.jsp"%>
<!--注册-->
<div class="wrap">
	<form id="LonginForm"
		action="${pageContext.request.contextPath}/doLogin" method="post">
		<div class="tdbModule loginPage">
			<div class="registerTitle">用户登录</div>
			<div class="registerCont">
				<ul>
					</li>
					<li><span class="dis">用户名：</span><input class="input"
						type="text" name="username" id="userName" maxlength="24"
						required="required"> <a id="sssdfasdfas"
						href="${pageContext.request.contextPath}/goRegister" class="blue">注册用户</a></li>

					<li><span class="dis">密码：</span><input class="input"
						type="password" name="password" id="password" maxlength="24"
						required="required"> <a href="#" id="pawHide" class="blue">忘记密码</a></li>
					<li><span class="dis">验证码：</span><input type="text"
						onkeyup="verify(this)" id="jpgVerify" style="width:166px;"
						class="input" name="yzm" data-msg="验证码" maxlength="4" tabindex="1"
						autocomplete="off"> <img
						src="${pageContext.request.contextPath}/yzm" id="yanzheng"
						onclick="changge();" alt="点击更换验证码" title="点击更换验证码"
						style="cursor:pointer;" class="valign"> <a
						href="javascript:void(0);" onclick="changge();" class="blue">看不清？换一张</a></li>
					<li class="btn"><input type="button" id="sub" value="登录"></li>
				</ul>
			</div>
		</div>
		<div style="display: none;">
			<input type="submit" id="doSub">
		</div>
	</form>
</div>
<%@ include file="common/foot.jsp"%>
<script type="text/javascript">
	//验证码
	function changge() {
		$("#yanzheng").hide().attr("src", "${pageContext.request.contextPath}/yzm").fadeIn();
	}
	$("#sub").on("click", function() {
		var yzm = $("#jpgVerify").val();
		if (yzm == null) {
			alert("验证码不能为空!!!");
		} else {
			$.ajax({
				url : "checkYzm",
				data : {
					yzm : yzm
				},
				dataType : "html",
				type : "get",
				success : function(data) {
					if (data == "true") {
						$("#doSub").click();
					}
					if (data == "false") {
						alert("验证码错误!!!");
						changge()
					}
				}
			})
		}
	})
</script>