<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="common/header.jsp"%>
<div class="x_panel">
	<div class="x_title">
		<h2>提现</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br>
		<form action="doTixian" class="form-horizontal form-label-left">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="amount">当前余额 <span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" id="amount" name="amount" readonly="readonly"
						value="${fund_account.amount }"
						class="form-control col-md-7 col-xs-12">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12" for="money">提现金额
					<span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="number" id="money" required="required" name="money"
						class="form-control col-md-7 col-xs-12">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="last-name">选择账户<span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<select class="form-control">
						<c:forEach items="${bankaccounts }" var="bankaccount">
							<option>${bankaccount.bankname }--${bankaccount.bankaccount }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="ln_solid"></div>
			<div class="form-group">
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<button type="button" class="btn btn-success tixian">提现</button>
				</div>
			</div>
			<div style="display: none;">
				<input type="submit" id="tijiao">
			</div>
		</form>
	</div>
</div>
<%@ include file="common/footer.jsp"%>
<script type="text/javascript">
	$(".tixian").on("click", function() {
		if ($("#amount").val() < $("#money").val()) {
			alert("你没有那么多钱!!!!");
		} else {
			$("#tijiao").click();
		}
	})
</script>