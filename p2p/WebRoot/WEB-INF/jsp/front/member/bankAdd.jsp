<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="common/header.jsp"%>
<div class="x_panel">
	<div class="x_title">
		<h2>添加银行卡</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br>
		<form action="doBankAdd" class="form-horizontal form-label-left"
			name="bankaccount">
			<input type="hidden" name="m_id" value="${userSession.id }">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="bankcode">银行列表 <span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<select class="form-control" name="bankcode" id="bankcode">
						<c:forEach items="${bankinformations }" var="bankinformation">
							<option value="${bankinformation.bankcode }">${bankinformation.bankname }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="bankaccount">银行账户 <span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" id="bankaccount" required="required"
						name="bankaccount" class="form-control ">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="accountholder">开户人 <span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" id="accountholder" name="accountholder"
						required="required" class="form-control ">
				</div>
			</div>

			<div class="ln_solid"></div>
			<div class="form-group">
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<button type="submit" class="btn btn-success">提交</button>
				</div>
			</div>

		</form>
	</div>
</div>
<%@ include file="common/footer.jsp"%>
