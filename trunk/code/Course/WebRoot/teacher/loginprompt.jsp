<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xml:lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>错误页面</title>
		<!-- Force MSIE without  javascript actived to take the default theme. not conforms to the standards but functional -->
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
					您还未登录或者长时间未进行任何操作！
					<br>
					<img src="${ctx}/error/ajax_indicator_01.gif" alt="&lt;br&gt;登录错误">
				</div>
				<div class="notreload">
					[请<a href="javascript:window.parent.location.href='homepageNewsAction.action'" target="_top"><strong><font color="#ffff00"> 点击此处 </font></strong></a>回到课程平台首页]
				</div>
			</div>
		</div>
	</body>
</html>
