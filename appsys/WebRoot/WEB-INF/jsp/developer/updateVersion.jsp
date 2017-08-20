<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="x_content">
	<!-- 版本信息 -->
	<div class="x_panel">
		<div class="x_title">
			<h2>历史版本列表</h2>
			<ul class="nav navbar-right panel_toolbox">
				<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"><i
						class="fa fa-wrench"></i></a></li>
				<li><a class="close-link"><i class="fa fa-close"></i></a></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">

			<table class="table">
				<thead>
					<tr>
						<th>软件名称</th>
						<th>版本号</th>
						<th>版本大小(单位:M)</th>
						<th>发布状态</th>
						<th>APK文件下载</th>
						<th>最新更新时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${appVersions}" var="appVersion">
						<tr>
							<th>${appInfo.softwareName }</th>
							<td>${appVersion.versionNo }</td>
							<td>${appVersion.versionSize }</td>
							<c:choose>
								<c:when test="${appVersion.publishStatus==1 }">
									<td>不发布</td>
								</c:when>
								<c:when test="${appVersion.publishStatus==2 }">
									<td>已发布</td>
								</c:when>
								<c:otherwise>
									<td>预发布</td>
								</c:otherwise>
							</c:choose>
							<td><a
								href="down?apkLocPath='${appVersion.apkLocPath }'&apkFileName='${appVersion.apkFileName }'">${appVersion.apkFileName }</a></td>
							<td><fmt:formatDate value="${appVersion.modifyDate }"
									type="both" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	<form class="form-horizontal form-label-left" action="doUpdateVersion"
		enctype="multipart/form-data" method="post" name="appVersion">
		<input type="hidden" name="id" value="${newAppVersion.id }">
		<p>${devUserSession.devName}</p>
		<span class="section">修改APP版本信息</span> <input type="hidden"
			name="appId" value="${appInfo.id }"> <input type="hidden"
			name="createdBy" value="${devUserSession.id }"> <input
			type="hidden" name="APKName" value="${appInfo.APKName }">
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="versionNo">版本号<span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="versionNo" class="form-control col-md-7 col-xs-12"
					data-validate-length-range="6" data-validate-words="2"
					name="versionNo" required="required"
					value="${newAppVersion.versionNo }" type="text">
			</div>
		</div>

		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="versionSize">版本大小 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="number" id="versionSize" name="versionSize"
					required="required" data-validate-minmax="10,100"
					value="${newAppVersion.versionSize }"
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>

		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="publishStatus">发布状态 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="hidden" id="publishStatus" name="publishStatus"
					value="3">预发布
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="versionInfo">版本简介 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<textarea id="versionInfo" required="required" name="versionInfo"
					class="form-control col-md-7 col-xs-12">${newAppVersion.versionInfo }</textarea>
			</div>
		</div>

		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="apkFile">apk文件 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="file" id="apkFile" name="apkFile">
			</div>
			<div class="alert">${fileUploadError }</div>
		</div>
		<div class="ln_solid"></div>
		<div class="form-group">
			<div class="col-md-6 col-md-offset-3">
				<a href="list" class="btn btn-primary">返回</a>
				<button id="send" type="submit" class="btn btn-success">保存</button>
			</div>
		</div>
	</form>
</div>
<div class="clearfix"></div>
<%@include file="common/footer.jsp"%>
