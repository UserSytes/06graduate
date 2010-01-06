<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<LINK href="${ctx}/css/student.css" type=text/css rel=stylesheet>
		<title>厦门大学精品课程网站</title>
	</head>
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="${ctx}/homepage/images/back-body.jpg" style="overflow-x: hidden">
		<center>

			<table width="783" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%"
						background="${ctx}/homepage/images/back-left.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>
					<td width="765" height="100%" valign="top"
						background="${ctx}/homepage/images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=765 height="102">
									<s:include value="include/header.jsp"></s:include>
								</td>
							</tr>
							<tr>
								<s:include value="left.jsp"></s:include>

								<td width="555" height="10" valign="top">
									<table width="555" height="100%" border="0" cellspacing="0"
										cellpadding="0"
										background="${ctx}/homepage/images/back-up-3.jpg">
										<tr>
											<td width="555" height="10"
												background="${ctx}/homepage/images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="555" height="100%" border="0" cellspacing="0"
													cellpadding="0"
													background="${ctx}/homepage/images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: center bottom;">

													<tr>
														<br>
														<br>
														<br>
														<br>
														<div style="padding-left: 5px" class="content1-pagetitle">
															当前位置: 我的课程 -&gt; 收藏课程
														</div>
													</tr>
													<tr>
														<td width="389" valign="top" style="padding-left: 5px">
															<div class="table">
																<img src="${ctx}/student/img/bg-th-left.gif" width="8" height="7"
																	alt="" class="left" />
																<img src="${ctx}/student/img/bg-th-right.gif" width="7" height="7"
																	alt="" class="right" />
																<table class="listing" cellpadding="0" cellspacing="0">
																	<tr <s:if test="#st.odd"></s:if>>
																		<th class="first">
																			序号
																		</th>
																		<th>
																			课程名
																		</th>
																		<th>
																			教师
																		</th>
																		<th>
																			院系
																		</th>
																		<th class="last">
																			操作
																		</th>
																	</tr>
																	<s:iterator value="courseList" status="course">
																		<tr>
																			<td width="10%">
																				<s:property value="#course.count" />
																			</td>
																			<td width="35%">
																				<a
																					href="<s:url action="enterCourseAction"> 
																				<s:param name="courseId"> <s:property value="id"/> </s:param> </s:url>">
																					<s:property value="name" /> </a>
																			</td>
																			<td width="15%">
																				<s:property value="teacher.userInfo.name" />
																			</td>
																			<td width="25%" class="last">
																				<s:property
																					value="department.school.name+department.name" />
																			</td>
																			<td width="15%">
																				<a
																					href="<s:url action="deleteCollectionAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"
																					onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
																					<font color="red">【删除】</font> </a>
																			</td>
																		</tr>
																	</s:iterator>
																	<tr class="listFooterTr">

																	</tr>
																</table>
															</div>
														</td>

													</tr>

												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<s:include value="include/bottom.jsp"></s:include>
							<tr>
								<td colspan="2" height="100%">
									<img src="${ctx}/homepage/images/spacer.gif" width="1"
										height="1">
								</td>
							</tr>
						</table>
					</td>
					<td width="9" height="100%"
						background="${ctx}/homepage/images/back-right.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
	</BODY>
</html>