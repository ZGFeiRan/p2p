<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/top.jsp"%>
<!--注册-->
<div class="wrap">
	<div class="tdbModule register">
		<div class="registerTitle">注册账户</div>
		<div class="registerCont">
			<form action="${pageContext.request.contextPath}/doRegister"
				name="member">
				<ul>
					<li><span class="dis">用户名:</span> <input type="text"
						name="username" id="userName" class="input _userName"
						required="required" placeholder="请输入用户名"> <span
						id="userNameAlt"></span></li>
					<li><span class="dis">密码:</span> <input type="password"
						name="password" id="password" class="input _password"
						placeholder="请输入密码"></li>
					<li><span class="dis">确认密码:</span> <input type="password"
						required="required" name="repeatPassword" id="repeatPassword"
						placeholder="请再次输入密码" class="input _repeatPassword"></li>
					<li class="telNumber"><span class="dis">手机号码:</span> <input
						type="text" class="input _phoneNum" id="phone" name="phone"
						required="required" placeholder="请输入您的常用电话"></li>
					<li><span class="dis">邮箱:</span> <input type="email"
						name="email" class="input _userName" placeholder="请输入邮箱"
						required="required"></li>
					<li><span class="dis">验证码:</span> <input type="text"
						id="jpgVerify" class="input input1 _yanzhengma" name="yzm"
						maxlength="4" tabindex="1"> <img
						src="${pageContext.request.contextPath}/yzm" onclick="changge();"
						alt="验证码" style="cursor:pointer;" id="yanzheng" class="valign">
						<a class="look blue _changeCapcherButton" id="look"
						onclick="changge();">看不清？换一张</a> <span class="info"
						id="jpgVerifys"></span></li>
					<li class="agree"><input name="protocol" id="protocol"
						type="checkbox" value="" checked="checked"> 我同意《<a
						href="#" target="_black">注册协议</a>》 <span id="protocolAlt"
						data-info="请查看协议">请查看协议</span></li>
					<li class="btn"><input type="button" value="注册" id="sub">
						<input style="display: none;" type="submit" id="subm"
						value="submit" /></li>
				</ul>
			</form>
		</div>
	</div>
</div>
<%@ include file="common/foot.jsp"%>
<script type="text/javascript">
	$("#sub").on("click", function() {
		if ($("#password").val() == $("#repeatPassword").val()) {
			$("#subm").click();
		} else {
			alert("两次密码必须一样!!");
		}
	})
	$("#userName").on("blur", function() {
		$.ajax({
			url : "checkUser",
			type : "get",
			dataType : "json",
			data : {
				username : $("#userName").val()
			},
			success : function(data) {
				if (data == true) {
					alert("用户名已存在!!!");
					$("#userNameAlt").html("用户名已存在!!!");
				} else if (data == null) {
					$("#userNameAlt").html("用户名不能为空!!!");
				} else {
					$("#userNameAlt").html("用户名可以使用");
				}
			}
		})
	})
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