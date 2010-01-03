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
  <h1>精品课程<br />
	<span class="text1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="applicationForm.name"/></span></h1>
</div>
<jsp:include page="top.jsp"></jsp:include>
<div id="content">
  <div id="right">
		<h2 align="center">实验文档列表</h2>
		<hr id="border-top" />
<table class=editTable cellSpacing=1 cellPadding=0 align=center border=2>
															<tr bgcolor="#ECF3FD" height="30">
																<th>
																	实验文档名
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
															<s:iterator value="experimentList" status="experiment">
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
<div id="footer">
	<p>Copyright &copy; 2006 Sitename.com. Designed by <a href="http://www.freecsstemplates.org" class="link1">Free CSS Templates</a></p>
</div>
</body>
</html>
<span style="display:none;"><a href="http://www.mobanwang.com" title="ҳģ">ҳģ</a></span><span style="display:none;"><a href="http://www.mobanwang.com" title="ҳģ">ҳģ</a></span>