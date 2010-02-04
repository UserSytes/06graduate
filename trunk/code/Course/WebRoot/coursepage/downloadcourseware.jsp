<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>厦门大学精品课程</title>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="../${ctx}/coursepage/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="top.jsp"></jsp:include>
<div id="content">
  <div id="right">
		<h2 align="center">课程教案列表</h2>
		<hr id="border-top" />
<table class=editTable cellSpacing=1 cellPadding=0 align=center border=2>
															<tr bgcolor="#ECF3FD" height="30">
																<th>
																	课件名
																</th>
																<th>
																	作者
																</th>
																<th>
																	时间
																</th>
																<th>
																	链接
																</th>
															</tr>
															<s:iterator value="coursewareList" status="courseware">
																<tr bgcolor="#73C5E5" height="30" align="center" valign="middle"  <s:if test="#courseware.even">style="background-color:#FBFDFD"</s:if>>
																	<td>
																		<s:property value="title" />
																	</td>
																	<td>
																		<s:property value="author" />
																	</td>
																	<td>
																		<s:date name="time" format="yyyy-MM-dd" />
																	</td>
																	<td align="center" valign="top">
																		<a
																			href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="fileLink"/> 
                    			</s:param>  
<s:param name="originalFileName"> 
                       			 	<s:property value="filename"/> 
                    			</s:param> 
                					</s:url>"
																			onclick="JAVAscript:if(!confirm('确认下载附件？')) return false;return true;">
																			<font color="red">点此下载</font> </a>
																	</td>
																</tr>
															</s:iterator>
														</table>
													</td>
												</tr>
											</table>
<a href="javascript:history.back(-1)">返回上一页</a>
  </div>
	<jsp:include page="left.jsp"></jsp:include>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>