<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jsp"%>

<div class="x_panel">
	<div class="x_title">
		<h2 style="width: 250px">
			投资记录 <strong>累计投资:${sum }</strong>
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">

		<table class="table">
			<thead>
				<tr>
					<th>投标金额</th>
					<th>投标时间</th>
					<th>是否放款</th>
					<th>标的编号</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tender_records }" var="tender_record">
					<tr>
						<td>${tender_record.tender_amount }</td>
						<td><fmt:formatDate value="${tender_record.tender_date }"
								type="both" /></td>
						<td>${tender_record.is_fangkuan }</td>
						<td>${tender_record.borrow_id }</td>
						<td><button type="button"
								class="btn btn-round btn-success showBorrowmark"
								borrowId="${tender_record.borrow_id }">查看标的详情</button></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
</div>
<%@ include file="common/footer.jsp"%>
<script type="text/javascript">
	$(".showBorrowmark").on("click", function() {
		window.location.href = "${pageContext.request.contextPath }/front/invest/goBorrowDetail?b_id=" + $(this).attr("borrowId");
	})
</script>