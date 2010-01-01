<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<td width="210" height="10" valign="top">
									<table width="214" height="543" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="60">
												<img src="${ctx}/homepage/images/up-1.jpg" width="214"
													height="60">
											</td>
										</tr>
										<tr>
											<td width="210" height="100%" valign="top"
												style="padding-left: 5px; padding-top: 4px; padding-bottom: 0px">
												<div id="left-column">
													<h3>
														我的课程
													</h3>
													<ul class="nav">
														<li>
															<font size="2" face="宋体"><a
																href="<s:url action="myCoursesAction"></s:url>">课程列表</a>
															</font>
														</li>
														<li class="last">
															<font size="2" face="宋体"><a href="<s:url action="myCollectionAction"></s:url>">收藏课程</a> </font>
														</li>
													</ul>
													<h3>
														我的帐号
													</h3>
													<ul class="nav">
														<li>
															<font size="2" face="宋体"><a href="<s:url action="myInfoAsStudentAction"></s:url>">个人信息</a> </font>
														</li>
														<li class="last">
															<font size="2" face="宋体"><a href="student/changepassword.jsp">修改密码</a> </font>
														</li>
													</ul>
													<h3>
														我的留言
													</h3>
													<ul class="nav">
														<li>
															<font size="2" face="宋体"><a href="#">最新留言</a> </font>
														</li>
														<li class="last">
															<font size="2" face="宋体"><a href="#">历史留言</a> </font>
														</li>
													</ul>
												</div>
											</td>
										</tr>
									</table>
								</td>
</body>
</html>