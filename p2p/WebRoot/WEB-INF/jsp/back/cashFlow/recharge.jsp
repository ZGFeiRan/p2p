<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../common/header.jsp"%>

<!-- page content -->
<div class="right_col" role="main">
	<div class="row">
		<div class="x_panel">
			<div class="x_title">
				<h2 style="width: 200px">提现列表</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<table class="table">
					<thead>
						<tr>
							<th>会员ID</th>
							<th>收入</th>
							<th>支出</th>
							<th>当前资金</th>
							<th>备注</th>
							<th>时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cash_flows }" var="cash_flow">
							<tr>
								<td>${cash_flow.m_id }</td>
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
						window.location.href = "Recharge?currentPageNo=" + num;
					}
				</script>

			</div>
		</div>
	</div>
</div>
<!-- /page content -->
<%@ include file="../common/footer.jsp"%>

