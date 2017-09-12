<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../common/header.jsp"%>

<div class="right_col" role="main">
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>添加管理员</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<br>
					<form id="demo-form2" class="form-horizontal form-label-left"
						action="doAddAdmin" name="member">

						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="username">用户名 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="username" required="required"
									class="form-control col-md-7 col-xs-12" name="username">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="password">密码 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="password" id="password" required="required"
									class="form-control col-md-7 col-xs-12" name="password">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="paymentpassword">支付密码 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="password" id="paymentpassword" required="required"
									class="form-control col-md-7 col-xs-12" name="paymentpassword">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="phone">手机号 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="phone" required="required"
									class="form-control col-md-7 col-xs-12" name="phone">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="email">邮箱 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="email" required="required"
									class="form-control col-md-7 col-xs-12" name="email">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="r_id">所属角色 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select class="form-control col-md-7 col-xs-12" name="r_id"
									id="r_id">
									<c:forEach items="${roles }" var="role">
										<option value="${role.id }">${role.rolename }</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="ln_solid"></div>
						<div class="form-group">
							<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
								<button type="button" class="btn btn-success" id="retreat">后退</button>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="提交"
									class="btn btn-success">
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#retreat").on("click", function() {
			window.history.go(-1);
		})
	})
</script>

