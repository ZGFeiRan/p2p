<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../common/header.jsp"%>

<!-- page content -->
<div class="right_col" role="main">
	<div class="row">
		<div class="x_panel">
			<div class="x_title">
				<h2 style="width: 200px">标的审核</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<table class="table">
					<thead>
						<tr>
							<th>借款人</th>
							<th>借款标题</th>
							<th>借款用途</th>
							<th>借款金额</th>
							<th>借款说明</th>
							<th>借款期限</th>
							<th>还款方式</th>
							<th>借款手续费(%)</th>
							<th>年利率(%)</th>
							<th>有效时间(天)</th>
							<th>申请时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${borrowmarks }" var="borrowmark">
							<tr>
								<td>${borrowmark.m_id }</td>
								<td>${borrowmark.borrowtitle }</td>
								<td>${borrowmark.lp_str }</td>
								<td>${borrowmark.borrowmoney }</td>
								<td>${borrowmark.borrowexplain }</td>
								<td>${borrowmark.borrowterm }</td>
								<td>${borrowmark.rm_Str }</td>
								<td>${borrowmark.loanfees }</td>
								<td>${borrowmark.annualrate }</td>
								<td>${borrowmark.activetime }</td>
								<td><fmt:formatDate
										value="${borrowmark.loanapplicationtime }" type="both" /></td>
								<td><c:choose>
										<c:when test="${borrowmark.status ==1}">
								已提交申请
							</c:when>
										<c:when test="${borrowmark.status ==2}">
								审批通过
							</c:when>
										<c:when test="${borrowmark.status ==3}">
								审批未通过
							</c:when>
										<c:when test="${borrowmark.status ==4}">
								已有投资
							</c:when>
										<c:when test="${borrowmark.status ==5}">
								已放款
							</c:when>
										<c:when test="${borrowmark.status ==6}">
								已结束
							</c:when>
									</c:choose></td>
								<td>
									<button type="button" class="btn btn-round btn-danger check"
										onclick="javascript:check(${borrowmark.id },2)">审核通过</button>
									<button type="button" class="btn btn-round btn-danger check"
										onclick="javascript:check(${borrowmark.id },3)">审核不通过</button>
								</td>
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
						window.location.href = "goBorrowCheck?currentPageNo=" + num;
					}
				</script>

			</div>
		</div>
	</div>
</div>
<!-- /page content -->
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	function check(id, status) {
		window.location.href = "doBorrowCheck?id=" + id + "&status=" + status;
	}
</script>