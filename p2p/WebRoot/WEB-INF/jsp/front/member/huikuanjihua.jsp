<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jsp"%>

<div class="x_panel">
	<div class="x_title">
		<h2 style="width: 250px">
			回款计划
			<c:if test="${!empty repayment_records }">
				<strong>预计回款:${sum }元</strong>
			</c:if>
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">

		<table class="table">
			<thead>
				<tr>
					<th>标的ID</th>
					<th>期号</th>
					<th>金额</th>
					<th>本金</th>
					<th>利息</th>
					<th>应还日期</th>
					<th>实际还款时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:if test="${!empty repayment_records }">
					<c:forEach items="${repayment_records }" var="repayment_record">
						<tr>
							<td>${repayment_record.borrow_id }</td>
							<td>${repayment_record.period_id }</td>
							<td>${repayment_record.amount }</td>
							<td>${repayment_record.bj }</td>
							<td>${repayment_record.lx }</td>
							<td><fmt:formatDate
									value="${repayment_record.should_return_date }" type="both" /></td>
							<td><fmt:formatDate
									value="${repayment_record.actual_return_date }" type="both" /></td>
							<td><button type="button"
									class="btn btn-round btn-success showBorrowmark"
									borrowId="${repayment_record.borrow_id }">查看标的详情</button></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<c:if test="${empty repayment_records }">
			<div
				style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
				<img src="${pageContext.request.contextPath}/images/nondata.png"
					width="60" height="60"><br> <br> 暂无回款计划
			</div>
		</c:if>
		
		<!-- 分页 -->

		<c:if test="${pageSupport.totalPageCount>1 }">
				当前页${pageSupport.currentPageNo}/总页数${pageSupport.totalPageCount}
					<button type="button" class="btn btn-info btn-sm"
				onclick="javascript:page(1)">首页</button>
			<c:if test="${pageSupport.currentPageNo>1 }">
				<button type="button" class="btn btn-info btn-sm"
					onclick="javascript:page(${pageSupport.currentPageNo-1})">上一页</button>
			</c:if>
			<c:if test="${pageSupport.currentPageNo< pageSupport.totalPageCount}">
				<button type="button" class="btn btn-info btn-sm"
					onclick="javascript:page(${pageSupport.currentPageNo+1})">下一页</button>
				<button type="button" class="btn btn-info btn-sm"
					onclick="javascript:page(${pageSupport.totalPageCount})">末页</button>
			</c:if>
		</c:if>
		<script type="text/javascript">
			//分页
			function page(num) {
				window.location.href = "repayment_record?currentPageNo=" + num+"&status=wh&payee_user_id="+${userSession.id};
			}
		</script>
		
	</div>
</div>
<%@ include file="common/footer.jsp"%>
<script type="text/javascript">
	$(".showBorrowmark").on("click", function() {
		window.location.href="${pageContext.request.contextPath }/front/invest/goBorrowDetail?b_id="+$(this).attr("borrowId");
	})
</script>