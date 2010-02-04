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
<jsp:include page="../coursepage/header.jsp"></jsp:include>
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
<a href="javascript:history.back(-1)">返回上一页</a>
  </div>
	<jsp:include page="../coursepage/left.jsp"></jsp:include>
</div>
<jsp:include page="../coursepage/bottom.jsp"></jsp:include>
</body>
</html>