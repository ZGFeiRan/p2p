<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../common/top.jsp"%>
<div class="main clearfix mrt30 wrap">
	<div class="x_panel">
		<div class="x_title">
			<h2 style="width: 500px">
				发布标的<small>如果交易成功需要扣除手续费</small>
			</h2>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<br>
			<form class="form-horizontal form-label-left" action="doLoan"
				name="borrowmark">

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="borrowtitle">借款标题 <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="text" id="borrowtitle" required="required"
							placeholder="借款标题" name="borrowtitle"
							class="form-control col-md-7 col-xs-12">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="lp_id">借款用途 <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<select name="lp_id" id="lp_id"
							class="select2_single form-control">
							<c:forEach items="${loanpurposes }" var="loanpurpose">
								<option value="${loanpurpose.id }">${loanpurpose.loanpurpose }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="borrowmoney">借款金额 <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="number" id="borrowmoney" name="borrowmoney"
							placeholder="1000-100000(100的倍数)" required="required"
							max="100000" min="1000" class="form-control col-md-7 col-xs-12">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="borrowexplain">借款说明 <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="text" id="borrowexplain" name="borrowexplain"
							placeholder="借款说明 " required="required"
							class="form-control col-md-7 col-xs-12">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="borrowterm">借款期限 <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<select id="borrowterm" name="borrowterm"
							class="form-control col-md-7 col-xs-12">
							<option value="1">一个月</option>
							<option value="3">三个月</option>
							<option value="6">六个月</option>
							<option value="9">九个月</option>
							<option value="12">一年</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="loanfees">借款手续费(%) <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="text" id="loanfees" name="loanfees"
							class="form-control col-md-7 col-xs-12" readonly="readonly"
							value="1">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="rm_id">还款方式 <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<select name="rm_id" id="rm_id"
							class="select2_single form-control">
							<c:forEach items="${repayList }" var="repay">
								<option value="${repay.id }">${repay.repaymentmethods }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="annualrate">年利率<span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="number" id="annualrate" name="annualrate"
							placeholder="5%-20%" required="required"
							class="form-control col-md-7 col-xs-12">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12"
						for="activetime">有效时间(天) <span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="number" id="activetime" name="activetime"
							placeholder="1-30" required="required" max="30" min="1"
							class="form-control col-md-7 col-xs-12">
					</div>
				</div>
				<div class="ln_solid"></div>
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<button type="button" class="btn btn-success sub">提交</button>
					</div>
				</div>
				<div style="display: none;">
					<input type="submit" id="sub">
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="../common/foot.jsp"%>
<script type="text/javascript">
	$("#borrowterm").on("mouseout", function() {
		if ($(this).val() == 1) {
			$("#loanfees").val("1");
		}
		if ($(this).val() == 3) {
			$("#loanfees").val("2");
		}
		if ($(this).val() == 6) {
			$("#loanfees").val("3");
		}
		if ($(this).val() == 9) {
			$("#loanfees").val("4");
		}
		if ($(this).val() == 12) {
			$("#loanfees").val("5");
		}
	})
	$(".sub").on("click", function() {
		if ($("#borrowmoney").val() % 100 == 0) {
			$("#sub").click();
		} else {
			alert("借款金额必须是100的倍数");
		}
	})
</script>
