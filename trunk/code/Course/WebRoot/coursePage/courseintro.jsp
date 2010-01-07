<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>厦门大学精品课程</title>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="../${ctx}/coursePage/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <h1><s:text name="">${course.name}</s:text>精品课程<br />
	<span class="text1"><s:property value="applicationForm.name"/></span></h1>
</div>
<jsp:include page="top.jsp"></jsp:include>
<div id="content">
  <div id="right">
		<h2 align="center"><strong><s:property value="courseInfo.title" /></strong></h2>
		<hr id="border-top" />
<h5 align="right">发布日期：<s:date name="courseInfo.time" format="yyyy-MM-dd" /></h5>
<p style="line-height: 150%"/>
<s:text name="">${courseInfo.content}</s:text>
  </div>
	<div id="left">
		<h2><strong>最新更新</strong></h2>
	  <p><strong>[06/09/2009]</strong>面向对象以及设计模式<a href="#"></a></p>
		<p><strong>[06/06/2009]</strong>Java 语言的基本语句、语法、应用程序开发技巧</p>
		<p><strong>[06/03/2009]</strong> 软件工程中的流程模型之瀑布模型</p>
		<p><strong>[06/06/2009]</strong>Java 语言的基本语句、语法、应用程序开发技巧</p>
		<p><strong>[06/03/2009]</strong> 软件工程中的流程模型之瀑布模型</p>
		<p>&nbsp;</p>
		<h2>在线学生</h2>
		<ul>
          <li>访客用户</li>
          <li>陈晓明</li>
          <li>刘晓庆</li>
          <li>潘粤明</li>
    	</ul>
		<p>&nbsp;</p>
  </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>