<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
<link href="../${ctx}/coursepage/default.css" rel="stylesheet" type="text/css" />
<title>信息提示</title>
</head>
<body>
<div id="header">
  <h1>精品课程<br /></h1>
</div>
<jsp:include page="../coursepage/top.jsp"></jsp:include>
<div id="content">
  <div id="right">
	<br>
	<font size="3"><strong><s:fielderror />
						</strong>
						</font>
						<font size="3"><strong><s:actionmessage />
						</strong>
						</font>
						<font size="3"><strong><s:actionerror />
						</strong>
						</font>
  </div>
	<div id="left">
		<h2>Recent Updates</h2>
		<p><strong>[06/09/2006]</strong> Etiam odio mi, suscipit et, rhoncus ac, lacinia, nisl. Aliquam gravida massa eu arcu. <a href="#">More&#8230;</a></p>
		<p><strong>[06/06/2006]</strong> Fusce mollis tristique sem. Sed eu eros imperdiet eros interdum blandit. Vivamus sagittis bibendum erat. Curabitur malesuada. <a href="#">More&#8230;</a></p>
		<p><strong>[06/03/2006]</strong> Nunc pellentesque. Sed vestibulum blandit nisl. Quisque elementum convallis purus. Suspendisse potenti. Donec nulla est, laoreet quis, pellentesque in. <a href="#">More&#8230;</a></p>
		<h2>Ipsum Dolorem</h2>
		<ul>
			<li><a href="#">Sagittis Bibendum Erat</a></li>
			<li><a href="#">Malesuada Turpis</a></li>
			<li><a href="#">Quis Gravida Massa</a></li>
			<li><a href="#">Inerat Viverra Ornare</a></li>
		</ul>
	</div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>