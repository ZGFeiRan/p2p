<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<jsp:useBean id="time" class="java.util.Date" />
<!-- page content -->
<div class="right_col" role="main">
	<div>
		<div class="title_left">
			<h1>添加报销单</h1>
		</div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br>
						<form id="demo-form2" data-parsley-validate=""
							class="form-horizontal form-label-left" novalidate="">

							<input type="hidden" name="next" value="1" id="next">

							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">填报人 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="name" readonly="readonly"
										value="${userSession.name }"
										class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="createTime">填报时间 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="createTime" readonly="readonly"
										class="form-control col-md-7 col-xs-12"
										value="<fmt:formatDate value="${time}" type="both" />">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="totalAccount">总金额 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="number" required="required"
										class="form-control col-md-7 col-xs-12" name="totalAccount">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="status">状态 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="status" readonly="readonly"
										value="新创建" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="form-group" id="typep">
								<button type="button" class="btn btn-success btn-xs"
									style="margin-left: 350px" id="addType">添加</button>
								<div class="typeView" style="padding-left: 350px">
									项目类别:<input type="text" name="item">&nbsp;项目金额:<input
										type="number" name="account">&nbsp;费用说明:<input
										type="text" name="des">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="event">事由 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<textarea rows="7" cols="12"
										class="form-control col-md-7 col-xs-12" name="event"></textarea>
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
									<button class="btn btn-primary" id="donext">保存</button>
									<button type="submit" class="btn btn-success">提交</button>
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
<script type="text/javascript">
	$(function() {
		$("#addType").on("click", function() {
			$("#typep").append($("#typep :eq(1)").clone(true).insertAfter(this));
		})
		$("#donext").on("click", function() {
			$("#next").val(0);
			$("form :eq(0)").sumbit();
		})
	})
</script>
<%@ include file="../common/footer.jsp"%>
