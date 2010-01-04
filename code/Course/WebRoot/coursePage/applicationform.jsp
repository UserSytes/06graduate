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
		<h2 align="center"><s:property value="applicationForm.name"/>申报表格</h2>
		<hr id="border-top" />

<table class=editTable cellSpacing=1 cellPadding=0 align=center border=0>
<tr bgcolor="#73C5E5" height="30">
														<td width="30%">
															<div align="center">
																推荐省份
															</div>
														</td>
														<td  width="70%">
															&nbsp;&nbsp;
															<s:property value="applicationForm.province" />
														</td>
													</tr>
													<tr bgcolor="#FBFDFD" height="30">
														<td>
															<div align="center">
																推荐单位
															</div>
														</td>
														<td>
															&nbsp;&nbsp;
															<s:property value="applicationForm.recommender" />
														</td>
													</tr>
													<tr bgcolor="#73C5E5" height="30">
														<td >
															<div align="center">
																所属院校
															</div>
														</td>
														<td>
															&nbsp;&nbsp;
															<s:property value="applicationForm.school" />
														</td>
													</tr>
													<tr bgcolor="#FBFDFD" height="30">
														<td>
															<div align="center">
																课程名称
															</div>
														</td>
														<td>
															&nbsp;&nbsp;
															<s:property value="applicationForm.name" />
														</td>
													</tr>
<tr bgcolor="#73C5E5" height="30">
														<td>
															<div align="center">
																课程级别
															</div>
														</td>
														<td>
															&nbsp;&nbsp;
															<s:property value="applicationForm.level" />
														</td>
													</tr>
													<tr bgcolor="#FBFDFD" height="30">
														<td>
															<div align="center">
																课程类型
															</div>
														</td>
														<td>
															&nbsp;&nbsp;
															<s:property value="applicationForm.sort" />
														</td>
													</tr>
													<tr bgcolor="#73C5E5" height="30">
														<td>
															<div align="center">
																所属一级学科名称
															</div>
														</td>
														<td>
															&nbsp;&nbsp;
															<s:property value="applicationForm.firstSubject" />
														</td>
													</tr>
													<tr bgcolor="#FBFDFD" height="30">
														<td>
															<div align="center">
																所属二级学科名称
															</div>
														</td>
														<td>
															&nbsp;&nbsp;
															<s:property value="applicationForm.secondSubject" />
														</td>
													</tr>
													<tr bgcolor="#73C5E5" height="30">
														<td>
															<div align="center">
																课程负责人
															</div>
														</td>
														<td>
															&nbsp;&nbsp;
															<s:property value="applicationForm.responser" />
														</td>
													</tr>
													<tr bgcolor="#FBFDFD" height="30">
														<td>
															<div align="center">
																申报日期
															</div>
														</td>
														<td>
															&nbsp;&nbsp;
															<s:date name="applicationForm.time" format="yyyy-MM-dd" />
														</td>
													</tr>
													<tr bgcolor="#73C5E5" height="30">
														<td>
															<div align="center">
																申报表格下载
															</div>
														</td>
														<td>
															<a
						href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="applicationForm.fileLink"/> 
                    			</s:param> 
						<s:param name="originalFileName"> 
                       			 	<s:property value="applicationForm.filename"/> 
                    			</s:param> 
                					</s:url>"
						onclick="JAVAscript:if(!confirm('确认下载附件？')) return false;return true;">
						<font color="red">点此下载</font> </a>
														</td>
													</tr>

<tr>
										<td height="5" align="left" valign="top" colspan="2">
											<img src="coursePage/images/bot_4.jpg" width="100%" height="5">
											<br>
											<div align="center">
												中华人民共和国教育部制
											</div>
											<br>
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
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>