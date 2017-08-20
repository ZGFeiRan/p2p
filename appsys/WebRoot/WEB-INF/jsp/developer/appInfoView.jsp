<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="x_content">

	<form class="form-horizontal form-label-left">

		<p>${devUserSession.devName}</p>
		<span class="section">查看APP信息</span>

		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="softwareName">软件名称 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="softwareName" class="form-control col-md-7 col-xs-12"
					data-validate-length-range="6" data-validate-words="2"
					name="softwareName" readonly="readonly" type="text"
					value="${appInfo.softwareName }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="APKName">APK名称 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="APKName" class="form-control col-md-7 col-xs-12"
					data-validate-length-range="6" data-validate-words="2"
					name="APKName" readonly="readonly" type="text"
					value="${appInfo.APKName }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="supportROM">支持ROM <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="supportROM" class="form-control col-md-7 col-xs-12"
					data-validate-length-range="6" data-validate-words="2"
					name="supportROM" readonly="readonly" type="text"
					value="${appInfo.supportROM }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="interfaceLanguage">界面语言 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="interfaceLanguage"
					class="form-control col-md-7 col-xs-12"
					data-validate-length-range="6" data-validate-words="2"
					name="interfaceLanguage" readonly="readonly" type="text"
					value="${appInfo.interfaceLanguage }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="softwareSize">软件大小 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="number" id="softwareSize" name="softwareSize"
					readonly="readonly" class="form-control col-md-7 col-xs-12"
					value="${appInfo.softwareSize }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="downloads">下载次数 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="number" id="downloads" name="downloads"
					readonly="readonly" class="form-control col-md-7 col-xs-12"
					value="${appInfo.downloads }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="flatformId">所属平台 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="softwareName" class="form-control col-md-7 col-xs-12"
					data-validate-length-range="6" data-validate-words="2"
					name="softwareName" readonly="readonly" type="text"
					value="${appInfo.flatformId }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="categoryLevel1">一级分类 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="softwareName" class="form-control col-md-7 col-xs-12"
					data-validate-length-range="6" data-validate-words="2"
					name="softwareName" readonly="readonly" type="text"
					value="${appInfo.categoryLevel1Name }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="categoryLevel2">二级分类 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="softwareName" class="form-control col-md-7 col-xs-12"
					data-validate-length-range="6" data-validate-words="2"
					name="softwareName" readonly="readonly" type="text"
					value="${appInfo.categoryLevel2Name }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="categoryLevel3">三级分类 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input id="softwareName" class="form-control col-md-7 col-xs-12"
					data-validate-length-range="6" data-validate-words="2"
					name="softwareName" readonly="readonly" type="text"
					value="${appInfo.categoryLevel3Name }">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12" for="status">APP状态
				<span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" class="form-control col-md-7 col-xs-12"
					value="${appInfo.statusName}" readonly="readonly">
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="appInfo">应用简介 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<textarea id="appInfo" name="appInfo"
					class="form-control col-md-7 col-xs-12" readonly="readonly">${appInfo.appInfo }</textarea>
			</div>
		</div>
		<div class="item form-group bad">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="_logoPicPath">LOGO图片 <span class="required">*</span>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<c:choose>
					<c:when
						test="${appInfo.logoPicPath == null || appInfo.logoPicPath == ''}">   
				    	暂无
				  </c:when>
					<c:otherwise>
						<img src="${appInfo.logoPicPath }?m=1" width="100px;" />
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div class="ln_solid"></div>
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
						<c:forEach items="${appVersions }" var="appVersion">
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
		<div class="form-group">
			<div class="col-md-6 col-md-offset-3">
				<a href="list" class="btn btn-primary">返回</a>
			</div>
		</div>
	</form>
</div>
<%@include file="common/footer.jsp"%>
