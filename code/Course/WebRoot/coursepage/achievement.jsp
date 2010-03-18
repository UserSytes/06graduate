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
  <div id="right">
<h2 align="center"><s:property value="course.name" />课程成果展示</h2>
<s:iterator value="achievementList" status="achievement">
<h3 align="center"><s:property value="title" /></h2>
		<hr id="border-top" />
<h5 align="right">发布日期：<s:date name="time" format="yyyy-MM-dd" /></h5>
<p style="line-height: 150%"/>
<s:text name="">${content}</s:text>
<br />
附件下载：<a href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="fileLink"/> 
                    			</s:param> 
                					</s:url>"
						onclick="JAVAscript:if(!confirm('确认下载附件？')) return false;return true;">
						<font color="red">点此下载</font> </a>
</s:iterator>
  </div>
		<jsp:include page="left.jsp"></jsp:include>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>