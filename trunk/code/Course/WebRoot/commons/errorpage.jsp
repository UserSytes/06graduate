<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xml:lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<meta name="robots" content="">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta name="rating" content="">
		<meta name="author" content="">
		<meta name="copyright" content="">
		<meta name="generator" content="XOOPS">
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>错误页面</title>
		<script type="text/javascript">
	function redirect(URLStr) {
		location = URLStr;
	}
	var i = 10;
	function timer() {
		if (i > 1) {
			i = i - 1;
			document.getElementById("sec").innerHTML = i;
		} else {
			stop();
			redirect("javascript:history.back()");
		}
	}
	var tid = null;
	function start() {
		if (tid == null) {
			tid = setInterval("timer()", 500);
		}
	}
	function stop() {
		if (tid != null) {
			clearInterval(tid);
			tid = null;
		}
	}
</script>
		<!-- Force MSIE without  javascript actived to take the default theme. not conforms to the standards but functional -->

		<!-- path favicon -->
		<link rel="shortcut icon" type="image/ico"
			href="http://xoops.org.cn/icons/favicon.ico">
		<link rel="icon" type="image/png"
			href="http://xoops.org.cn/icons/favicon.png">

		<!-- include xoops.js and others via header.php -->


		<!-- Xoops style sheet -->
		<link rel="stylesheet" type="text/css" media="screen"
			href="${ctx}/error/xoops.css">

		<!-- Theme style sheets -->
		<link rel="stylesheet" type="text/css" media="screen" title="Color"
			href="${ctx}/error/style.css">

	</head>
	<body>
		<br>
		<br>
		<br>
		<div id="con-wrapper" class="con-center">
			<div id="ctr">
			</div>
			<div id="cbl">
				<img src="${ctx}/error/blue_bl.gif">
			</div>
			<div id="cbr">
				<img src="${ctx}/error/blue_br.gif">
			</div>
			<div id="xo-redirect">
				<div class="message">
					<br>
					系统正忙，操作超时！
					<br>
					<img src="${ctx}/error/ajax_indicator_01.gif" alt="&lt;br&gt;登录错误">
				</div>
				<div class="notreload">
					如果页面没有自动跳转回上一页，请
					<a href="javascript:history.back()">点击此处</a>继续
				</div>
			</div>
		</div>
	</body>
</html>
