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
															当前位置: 我的留言 -&gt; 我的帖子
														</div>
													</tr>
													<tr>
														<td width="389" valign="top" style="padding-left: 5px">
															<div class="table">
																<img src="img/bg-th-left.gif" width="8" height="7"
																	alt="" class="left" />
																<img src="img/bg-th-right.gif" width="7" height="7"
																	alt="" class="right" />
																<table class="listing" cellpadding="0" cellspacing="0">
																	<tr <s:if test="#st.odd"></s:if>>
																		<th class="first">
																			课程
																		</th>
																		<th>
																			标题
																		</th>
																		<th>
																			回复
																		</th>
																		<th class="last">
																			最后回复
																		</th>
																	</tr>
																	<s:iterator value="messageList" status="message">
																		<tr>
																			<td width="30%">
																					<s:property value="topic.course.name" /> 																				
																			</td>
																			<td width="40%">
																			<a href="<s:url action="showMessagesAction"> 
																				<s:param name="topicId"> <s:property value="topic.id"/> </s:param> </s:url>">
																				<font color="purple"> <s:property value="topic.name" /></font></a>
																			</td>
																			<td width="10%">
																				<s:property value="topic.countPerson" />
																			</td>
																			<td width="20%">
																				<s:property value="topic.lastUpdate+topic.lastAnswer" />
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