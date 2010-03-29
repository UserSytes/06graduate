<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>厦门大学精品课程</title>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="${ctx}/coursepage/default.css" rel="stylesheet" type="text/css" /></head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="top.jsp"></jsp:include>
<div id="content">
  <div id="right" style="width:700px">
		<h2 align="center"><strong><s:property value="notice.title" /></strong></h2>
		<hr id="border-top" />
<h5 align="right">发布日期：<s:date name="notice.time" format="yyyy-MM-dd" /></h5>
<p style="line-height: 150%"/>
<s:text name="">${notice.content}</s:text>
  </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>