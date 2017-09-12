<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jsp"%>
<div class="personal-money">
	<h3>
		<i>资金记录</i>
	</h3>
	<form id="form" name="form" method="post" action="">
		<div class="money-choose">
			<span class="money-date1">操作类型</span> <select class="form-control"
				name="financial_tran_type">
					<option selected="selected">全部</option>
					<option value="XSCZ">充值</option>
					<option value="TX">提现</option>
					<option value="TB">投标</option>
					<option value="SK">收款</option>
					<option value="FK">放款</option>
					<option value="HK">还款</option>
			</select>
			<button
				class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btn-sx">
				<span class="ui-button-text ui-c">筛选</span>
			</button>
			<button
				class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btn-dc">
				<span class="ui-button-text ui-c">导出</span>
			</button>
		</div>
		<div class="x_panel">
			<div class="x_title">
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">

				<table class="table">
					<thead>
						<tr>
							<th>交易类型</th>
							<th>收入</th>
							<th>支出</th>
							<th>余额</th>
							<th>备注</th>
							<th>时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cash_flows }" var="cash_flow">
							<tr>
								<td>${cash_flow.financial_tran_type }</td>
								<td>${cash_flow.income }</td>
								<td>${cash_flow.outlay }</td>
								<td>${cash_flow.user_fund_account_amount }</td>
								<td>${cash_flow.remarks }</td>
								<td><fmt:formatDate value="${cash_flow.createtime }"
										type="both" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 分页 -->

				<c:if test="${pageSupport.totalPageCount>1 }">
				当前页${pageSupport.currentPageNo}/总页数${pageSupport.totalPageCount}
					<button type="button" class="btn btn-info btn-sm"
						onclick="javascript:page(1)">首页</button>
					<c:if test="${pageSupport.currentPageNo>1 }">
						<button type="button" class="btn btn-info btn-sm"
							onclick="javascript:page(${pageSupport.currentPageNo-1})">上一页</button>
					</c:if>
					<c:if
						test="${pageSupport.currentPageNo< pageSupport.totalPageCount}">
						<button type="button" class="btn btn-info btn-sm"
							onclick="javascript:page(${pageSupport.currentPageNo+1})">下一页</button>
						<button type="button" class="btn btn-info btn-sm"
							onclick="javascript:page(${pageSupport.totalPageCount})">末页</button>
					</c:if>
				</c:if>
				<script type="text/javascript">
					//分页
					function page(num) {
						window.location.href = "cash_flowList?currentPageNo=" + num;
					}
				</script>
			</div>
		</div>

	</form>
</div>
</div>
<%@ include file="common/footer.jsp"%>