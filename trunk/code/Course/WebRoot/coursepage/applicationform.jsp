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
											<img src="coursepage/images/bot_4.jpg" width="100%" height="5">
											<br>
											<div align="center">
												中华人民共和国教育部制
											</div>
											<br>
										</td>
									</tr>
												</table>
  </div>
	<jsp:include page="left.jsp"></jsp:include>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>