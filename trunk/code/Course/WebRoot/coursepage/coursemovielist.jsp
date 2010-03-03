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
		<h2 align="center">教学视频列表</h2>
		<hr id="border-top" />
<table class=editTable cellSpacing=1 cellPadding=0 align=center border=1>
															<tr height="30">
																<th width="20%">
																	<div align="center">
																		视频名称
																	</div>
																</th>
																<th width="60%">
																	<div align="center">
																		简介
																	</div>
																</th>
																<th width="10%">
																	<div align="center">
																		发布时间
																	</div>
																</th>
																<th width="10%">
																	<div align="center">
																		观看
																	</div>
																</th>
															</tr>
															<s:iterator value="courseMovieList" status="courseMovie">
																<tr bgcolor="#73C5E5" height="30" align="center" valign="middle"  <s:if test="#chapter.even">style="background-color:#FBFDFD"</s:if>>
																	<td width="20%">
																		<s:property value="title" />
																	</td>
																	<td width="60%">
																		<s:property value="content" />
																	</td>
																	<td width="10%">
																		<s:date name="time" format="yyyy-MM-dd" />
																	</td>
																	<td width="10%" align="center" valign="top">
																		<a href="<s:url action="watchMovieAction"> 
											                     			<s:param name="courseMovieId"> 
											                       			 	<s:property value="id"/> 
											                    			</s:param>
											                					</s:url>">
																			<font color="green">【进入】</font></a>
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