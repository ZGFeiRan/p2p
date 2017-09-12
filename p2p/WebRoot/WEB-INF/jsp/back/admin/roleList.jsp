<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../common/header.jsp"%>

<!-- page content -->
<div class="right_col" role="main">
	<div class="row">
		<div class="x_panel">
			<div class="x_title">
				<h2>角色信息</h2>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-success"
					href="goRoleAdd">添加</a>
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
							<th>ID</th>
							<th>角色名称</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${roles!=null }">
							<c:forEach items="${roles }" var="role">
								<tr>
									<td>${role.id }</td>
									<td>${role.rolename }</td>
									<td>${role.notes }</td>
									<td>
										<button type="button" class="btn btn-round btn-success alter"
											roleId=${role.id }>修改</button> &nbsp;&nbsp;
										<button type="button" class="btn btn-round btn-danger delete"
											roleId=${role.id }>删除</button>
									</td>
								</tr>
							</c:forEach>
						</c:if>
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
						window.location.href = "goRoleList?currentPageNo=" + num;
					}
				</script>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
		//修改跳转
		$(".alter").on("click", function() {
			window.location.href = "goRoleAlter?id=" + $(this).attr("roleId");
		})
		//删除操作
		$(".delete").on("click", function() {
			var $obj = $(this).parent().parent();
			if (confirm("确定删除???")) {
				$.ajax({
					url : "doRoleDel",
					data : {
						id : $(this).attr("roleId")
					},
					type : "get",
					dataType : "json",
					success : function(data) {
						if (data == false) {
							alert("数据不存在!!!");
						}
						if (data == true) {
							$obj.remove();
						}
					}
				})
			}
		})
	})
</script>


