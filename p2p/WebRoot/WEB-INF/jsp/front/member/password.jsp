<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="common/header.jsp"%>
<div class="x_panel">
	<div class="x_title">
		<h2 style="width: 200px">修改密码</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br>
		<form class="form-horizontal form-label-left"
			action="doPasswordUpdate">

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="password">密码 <span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="password" id="password" required="required"
						placeholder="请输入密码" name="password"
						class="form-control col-md-7 col-xs-12">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="repassword">确认密码 <span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="password" id="repassword" required="rerequired"
						placeholder="请确认密码" name="password"
						class="form-control col-md-7 col-xs-12">
				</div>
			</div>
			<div class="ln_solid"></div>
			<div class="form-group">
				<div style="display: none;">
					<input type="submit" id="sub">
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<button type="button" class="btn btn-success tijiao">提交</button>
				</div>
			</div>

		</form>
	</div>
</div>
<%@ include file="common/footer.jsp"%>
<script type="text/javascript">
	$(".tijiao").on("click", function() {
		if ($("#password").val() == $("#repassword").val()) {
			$("#sub").click();
		} else {
			alert("两次密码不一样!!!");
		}
	})
</script>
