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
		<h2 align="center">通知公告</h2>
		<hr id="border-top" />
<table class=editTable cellSpacing=1 cellPadding=0 align=center border=1>
															<s:iterator value="noticeList" status="notice">
																<tr bgcolor="#FBFDFD" height="30" align="center" valign="middle">
																	<td width="80%">
																		<li>
							<a href="<s:url action="viewNoticeAction"> 
											                     			<s:param name="noticeId"> 
											                       			 	<s:property value="id"/> 
											                    			</s:param>
											                					</s:url>"><s:property value="title"/></a></li>
																	</td>
																	<td width="20%" align="center" valign="top">
																		<s:date name="time" format="yyyy-MM-dd hh:mm:ss" />
																	</td>
																</tr>
															</s:iterator>
														</table>
  </div>
	<jsp:include page="left.jsp"></jsp:include>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>