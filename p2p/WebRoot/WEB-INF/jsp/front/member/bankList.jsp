<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="common/header.jsp"%>
<div class="x_panel">
	<div class="x_title">
		<h2 style="width: 200px">
			我的银行卡&nbsp;&nbsp;&nbsp; <a type="button"
				class="btn btn-round btn-info add"
				href="${pageContext.request.contextPath}/front/member/goBankAdd">添加</a>
		</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">

		<table class="table">
			<thead>
				<tr>
					<th>银行编号</th>
					<th>银行名称</th>
					<th>银行账户</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bankaccounts }" var="bankaccount">
					<tr>
						<td>${bankaccount.bankcode }</td>
						<td>${bankaccount.bankname }</td>
						<td>${bankaccount.bankaccount }</td>
						<td><button type="button"
								class="btn btn-round btn-danger delete"
								bankId="${bankaccount.id }">删除</button></td>
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
				window.location.href = "bankList?currentPageNo=" + num;
			}
		</script>

	</div>
</div>
<%@ include file="common/footer.jsp"%>
<script type="text/javascript">
	$(".delete").on("click", function() {
		var $obj = $(this).parent().parent();
		if (confirm("是否删除!!!")) {
			$.ajax({
				url : "bankDel",
				data : {
					id : $(this).attr("bankId")
				},
				dataTpye : "json",
				type : "get",
				success : function(data) {
					if (data == "true") {
						$obj.remove();
					}
					if (data == "false") {
						alert("删除失败!!请联系管理员");
					}
					if (data == "null") {
						alert("id为空!!请联系管理员");
					}
				},
				error : function() {
					alert("发生异常!!请联系管理员");
				}
			})
		}
	})
</script>