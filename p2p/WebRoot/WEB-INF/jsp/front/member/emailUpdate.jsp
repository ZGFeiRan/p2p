<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="common/header.jsp"%>
<div class="x_panel">
	<div class="x_title">
		<h2 style="width: 200px">修改邮箱</h2>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<br>
		<form class="form-horizontal form-label-left"
			action="goPasswordUpdate">

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">邮箱
					<span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="email" id="email" required="required"
						placeholder="请输入密码" name="email"
						class="form-control col-md-7 col-xs-12">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12" for="yzm">验证码
					<span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" id="yzm" required="required" placeholder="请输入密码"
						name="yzm" class="form-control col-md-7 col-xs-12">
					<button type="button" id="yzemail" class="btn btn-info btn-xs">获取邮箱验证码</button>
				</div>
			</div>
			<div class="ln_solid"></div>
			<div class="form-group">
				<div style="display: none;">
					<input type="submit" id="sub">
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<button type="button" class="btn btn-success tijiao">提交</button>
				</div>
			</div>
			<input type="hidden" id="auth" value="">
		</form>
	</div>
</div>
<%@ include file="common/footer.jsp"%>
<script>
	$("#yzemail").on("click", function() {
		$.ajax({
			url : "sendEmail",
			data : null,
			dataType : "html",
			type : "get",
			success : function(data) {
				$("auth").val(data);
			}
		})
		buttonCountdown($(this), 1000 * 60 * 3, "ss");
	});
	function buttonCountdown($el, msNum, timeFormat) {
		var text = $el.data("text") || $el.text(),
			timer = 0;
		$el.prop("disabled", true).addClass("disabled")
			.on("bc.clear", function() {
				clearTime();
			});

		(function countdown() {
			var time = showTime(msNum)[timeFormat];
			$el.text(time + '后重试');
			if (msNum <= 0) {
				msNum = 0;
				clearTime();
			} else {
				msNum -= 1000;
				timer = setTimeout(arguments.callee, 1000);
			}
		})();

		function clearTime() {
			clearTimeout(timer);
			$el.prop("disabled", false).removeClass("disabled").text(text);
		}

		function showTime(ms) {
			var d = Math.floor(ms / 1000 / 60 / 60 / 24),
				h = Math.floor(ms / 1000 / 60 / 60 % 24),
				m = Math.floor(ms / 1000 / 60 % 60),
				s = Math.floor(ms / 1000 % 60),
				ss = Math.floor(ms / 1000);

			return {
				d : d + "天",
				h : h + "小时",
				m : m + "分",
				ss : ss + "秒",
				"d:h:m:s" : d + "天" + h + "小时" + m + "分" + s + "秒",
				"h:m:s" : h + "小时" + m + "分" + s + "秒",
				"m:s" : m + "分" + s + "秒"
			};
		}

		return this;
	}
</script>
