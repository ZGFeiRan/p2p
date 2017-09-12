<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/top.jsp"%>
<style>
.detailContext {
	line-height: 28px
}
</style>
<div class="main clearfix mrt30 wrap">
	<div class="x_panel">
		<div class="x_title">
			<h2 style="width: 200px">标的详情</h2>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<br>
			<form class="form-horizontal form-label-left">

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">借款标题</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmark.borrowtitle }</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">借款用途</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmark.lp_str }</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">借款金额</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmark.borrowmoney }元</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">借款说明</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmark.borrowexplain }</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">借款期限</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmark.borrowterm }个月</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">还款方式</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmark.rm_Str }</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">借款手续费</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmark.loanfees }%</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">年利率</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmark.annualrate }%</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">有效时间</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmark.activetime }天</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">借款申请时间</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">
							<fmt:formatDate value="${borrowmark.loanapplicationtime }"
								type="both" />
						</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">状态</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">
							<c:choose>
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
							</c:choose>
						</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">审核时间</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">
							<c:choose>
								<c:when test="${empty borrowmarkDetails.approve_date }">
								暂未审核
							</c:when>
								<c:otherwise>
									<fmt:formatDate value="${borrowmarkDetails.approve_date }"
										type="both" />
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">流标时间</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">
							<fmt:formatDate value="${borrowmarkDetails.liubiao_date }"
								type="both" />
						</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">放款时间</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">
							<c:choose>
								<c:when test="${empty borrowmarkDetails.lending_date }">
								暂未放款
							</c:when>
								<c:otherwise>
									<fmt:formatDate value="${borrowmarkDetails.lending_date }"
										type="both" />
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">结清时间</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">
							<c:choose>
								<c:when test="${empty borrowmarkDetails.clear_date }">
								暂未结清
							</c:when>
								<c:otherwise>
									<fmt:formatDate value="${borrowmarkDetails.clear_date }"
										type="both" />
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">结束日期</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">
							<c:choose>
								<c:when test="${empty borrowmarkDetails.finish_date }">
								暂未结束
							</c:when>
								<c:otherwise>
									<fmt:formatDate value="${borrowmarkDetails.finish_date }"
										type="both" />
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">剩余期数</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<p class="detailContext">${borrowmarkDetails.rest_period }</p>
					</div>
				</div>
			</form>
			<div class="ln_solid"></div>
		</div>
	</div>
</div>
<%@ include file="../common/foot.jsp"%>

