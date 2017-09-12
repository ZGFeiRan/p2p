<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../common/header.jsp"%>

<div class="right_col" role="main">
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>修改借款用途</h2>
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
						action="doLoanpAlter" name="_loanpurpose">
						<input type="hidden" name="id" value="${loanpurpose.id }">
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="loanpurpose">借款用途 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="loanpurpose" required="required"
									class="form-control col-md-7 col-xs-12" name="loanpurpose"
									value="${loanpurpose.loanpurpose }">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="notes">备注 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="notes" required="required"
									class="form-control col-md-7 col-xs-12" name="notes"
									value="${loanpurpose.notes }">
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

