<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="common/header.jsp"%>
<div class="x_panel">
	<div class="x_title">
		<h2>在线充值</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br>
		<form action="doRecharge" class="form-horizontal form-label-left">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12" for="money">充值金额
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
					<c:if test="${!empty bankaccounts }">
						<select class="form-control">
							<c:forEach items="${bankaccounts }" var="bankaccount">
								<option>${bankaccount.bankname }--${bankaccount.bankaccount }</option>
							</c:forEach>
						</select>
					</c:if>
					<c:if test="${empty bankaccounts }">
						<input type="hidden" id="noBank" value="no">
						<a class="btn btn-success"
							href="${pageContext.request.contextPath }/front/member/goBankAdd">添加银行卡</a>
					</c:if>
				</div>
			</div>
			<div class="ln_solid"></div>
			<div class="form-group">
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<button type="button" class="btn btn-success recharge">充值</button>
				</div>
			</div>
			<div style="display: none;">
				<input type="submit" id="sub">
			</div>
		</form>
	</div>
</div>
<%@ include file="common/footer.jsp"%>
<script type="text/javascript">
	$(".recharge").on("click", function() {
		if ($("#noBank").val() == "no") {
			alert("请先添加银行卡");
		} else {
			$("#sub").click();
		}
	})
</script>