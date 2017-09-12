<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../common/header.jsp"%>

<!-- page content -->
<div class="right_col" role="main">
	<div class="row">
		<div class="x_panel">
			<div class="x_title">
				<h2>会员信息</h2>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="title_right">
					<div
						class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
						<div class="input-group">
							<input type="text" class="form-control" id="username"
								placeholder="用户名"> <span class="input-group-btn">
								<button class="btn btn-default usernameSou" type="button">搜索</button>
							</span>
						</div>
					</div>
				</div>
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
							<th>用户名</th>
							<th>手机号</th>
							<th>邮箱</th>
							<th>权限等级</th>
							<th>注册时间</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${members!=null }">
							<c:forEach items="${members }" var="merber">
								<tr>
									<td>${merber.id }</td>
									<td>${merber.username }</td>
									<td>${merber.phone }</td>
									<td>${merber.email }</td>
									<td>${merber.r_id }</td>
									<td><fmt:formatDate value="${merber.registrationtime }"
											type="both" /></td>
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
						window.location.href = "goMemberList?currentPageNo=" + num;
					}
				</script>

			</div>
		</div>
	</div>
</div>
<!-- /page content -->
<%@ include file="../common/footer.jsp"%>

<script type="text/javascript">
	$(".usernameSou").on("click", function() {
		window.location.href = "${pageContext.request.contextPath }/back/goMemberList?username=" + $("#username").val();
	})
</script>