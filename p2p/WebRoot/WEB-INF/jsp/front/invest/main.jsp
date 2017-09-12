<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/top.jsp"%>
<div class="main clearfix mrt30 wrap">
	<div class="x_panel">
		<div class="x_title">
			<h2 style="width: 200px">可投资列表</h2>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">

			<table class="table">
				<thead>
					<tr>
						<th>借款标题</th>
						<th>借款金额</th>
						<th>借款用途</th>
						<th>借款说明</th>
						<th>借款期限</th>
						<th>还款方式</th>
						<th>年利率</th>
						<th>借款时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${borrowmarks}" var="borrowmark">
						<tr>
							<td>${borrowmark.borrowtitle }</td>
							<td>${borrowmark.borrowmoney }</td>
							<td>${borrowmark.lp_str }</td>
							<td>${borrowmark.borrowexplain }</td>
							<td>${borrowmark.borrowterm }</td>
							<td>${borrowmark.rm_Str }</td>
							<td>${borrowmark.annualrate }</td>
							<td><fmt:formatDate
									value="${borrowmark.loanapplicationtime }" type="both" /></td>
							<td><button b_id="${borrowmark.id }" type="button"
									borrowmoney="${borrowmark.borrowmoney }"
									class="btn btn-round btn-success invest">投资</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="display: none;">
				<input type="hidden" id="moeny" value="${fund_account.amount }">
			</div>
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
					window.location.href = "main?currentPageNo=" + num;
				}
			</script>

		</div>
	</div>
</div>
<%@ include file="../common/foot.jsp"%>
<script type="text/javascript">
	$(".invest").on("click", function() {
		var $obj = $(this).parent().parent();
		if ($(this).attr("borrowmoney") > $("#moeny").val()) {
			alert("你的余额已不足,请充值!!!");
		} else {
			$.ajax({
				url : "doInvest",
				data : {
					b_id : $(this).attr("b_id")
				},
				dataType : "html",
				type : "get",
				success : function(data) {
					if (data == "true") {
						$obj.remove();
					}
					if (data == "false") {
						alert("投资失败!!!");
					}
				}
			})
		}
	})
</script>
