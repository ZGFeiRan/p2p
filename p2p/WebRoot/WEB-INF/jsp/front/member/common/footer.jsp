<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="clear"></div>
</div>
</div>
<!--网站底部-->
<div id="footer" class="ft">
	<div class="ft-inner clearfix">
		<div class="ft-helper clearfix">
			<dl>
				<dt>关于我们</dt>
				<dd>
					<a href="#">品牌优势</a><a href="#">管理团队</a><a href="#">官方公告</a><a
						href="#">联系我们</a>
				</dd>
			</dl>
			<dl>
				<dt>相关业务</dt>
				<dd>
					<a href="#">我要投资</a><a href="#">我要借款</a><a href="#">阳光宝盒</a><a
						href="#">我要加盟</a>
				</dd>
			</dl>
			<dl>
				<dt>帮助中心</dt>
				<dd>
					<a href="#">新手入门</a><a href="#">我的账户</a><a href="#">债权转让</a><a
						href="#">其它</a>
				</dd>
			</dl>
			<dl>
				<dt>帮助中心</dt>
				<dd>
					<a href="#">新手入门</a><a href="#">我的账户</a><a href="#">债权转让</a><a
						href="#">其它</a>
				</dd>
			</dl>
		</div>
		<div class="ft-service">
			<dl>
				<dd>
					<p>
						<strong>400-090-1268</strong><br> 工作日 9:00-22:00<br>
						官方交流群:<em>12345678</em><br> 工作日 9:00-22:00 / 周六 9:00-18:00<br>
					</p>
					<div class="ft-serv-handle clearfix">
						<a class="icon-hdSprite icon-ft-sina a-move a-moveHover"
							title="阳光易贷新浪微博" target="_blank" href="http://www.htmlsucai.com"></a><a
							class="icon-hdSprite icon-ft-qqweibo a-move a-moveHover"
							title="阳光易贷腾讯微博" target="_blank" href="http://www.htmlsucai.com"></a><a
							class="icon-ft-qun a-move a-moveHover" title="阳光易贷QQ群"
							target="_blank" href="http://www.htmlsucai.com"></a><a
							class="icon-hdSprite icon-ft-email a-move a-moveHover mrn"
							title="阳光易贷email" target="_blank" href="mailto:xz@ygydai.com"></a>
					</div>
				</dd>
			</dl>
		</div>
		<div class="ft-wap clearfix">
			<dl>
				<dt>官方二维码</dt>
				<dd>
					<span class="icon-ft-erweima"><img
						src="${pageContext.request.contextPath}/images/code.png"
						style="display: inline;"></span>
				</dd>
			</dl>
		</div>
	</div>
	<div class="ft-record">
		<div class="ft-approve clearfix">
			<a class="icon-approve approve-0 fadeIn-2s" target="_blank" href="#"></a><a
				class="icon-approve approve-1 fadeIn-2s" target="_blank" href="#"></a><a
				class="icon-approve approve-2 fadeIn-2s" target="_blank" href="#"></a><a
				class="icon-approve approve-3 fadeIn-2s" target="_blank" href="#"></a>
		</div>
		<div class="ft-identity">
			©2015 亿人宝 All rights reserved&nbsp;&nbsp;&nbsp;<span class="color-e6">|</span>&nbsp;&nbsp;&nbsp;安徽省亿人宝投资管理有限公司&nbsp;&nbsp;&nbsp;<span
				class="color-e6">|</span>&nbsp;&nbsp;&nbsp;<a target="_blank"
				href="http://www.htmlsucai.com">皖ICP备12345678号-1</a>
		</div>
	</div>
</div>
</body>
</html>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/fastclick.js"></script>
<script src="${pageContext.request.contextPath }/js/nprogress.js"></script>
<script src="${pageContext.request.contextPath }/js/custom.min.js"></script>
<script src="${pageContext.request.contextPath }/js/validator.js"></script>
<script src="${pageContext.request.contextPath }/js/dropzone.js"></script>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ablumn.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/detail.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/index.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.datetimepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.flexslider-min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/plugins.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/raphael-min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/user.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/datepicker.js"></script>
<script type="text/javascript">
	function repay(num) {
		if (num == 1) {
			window.location.href = "${pageContext.request.contextPath}/front/member/repayment_record?status=wh&payee_user_id="+${userSession.id};
		}
		if (num == 2) {
			window.location.href = "${pageContext.request.contextPath}/front/member/repayment_record?status=yh&payee_user_id="+${userSession.id};
		}
		if (num == 3) {
			window.location.href = "${pageContext.request.contextPath}/front/member/repayment_record?status=wh&payer_user_id="+${userSession.id};
		}
		if (num == 4) {
			window.location.href = "${pageContext.request.contextPath}/front/member/repayment_record?status=yh&payer_user_id="+${userSession.id};
		}
	}
</script>