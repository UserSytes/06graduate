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
		background="${ctx}/homepage/images/back-body.jpg"
		style="overflow-x: hidden">
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
									<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
										codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0"
										width="765" height="102">
										<param name="movie"
											value="${ctx}/homepage/flash/delta46-2.swf">
										<param name="quality" value="high">
										<param name="menu" value="false">
										<embed src=${ctx}/homepage/flash/delta46-2.swf quality="high"
											pluginspage="http://www.macromedia.com/go/getflashplayer"
											type="application/x-shockwave-flash" width="765" height="102"></embed>
									</object>
								</td>
							</tr>
							<tr>
								<td width="210" height="10" valign="top">
									<table width="214" height="100%" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="60">
												<img src="${ctx}/homepage/images/up-1.jpg" width="214"
													height="60">
											</td>
										</tr>

										<tr bgcolor="#f1f1f1">
											<td height="38" bgcolor="#f1f1f1">
												<img src="${ctx}/homepage/images/but-2-1.jpg" width="214"
													height="38" style="">
											</td>
										</tr>
										<tr bgcolor="#f1f1f1">
											<td bgcolor="#f1f1f1" width="210" height="100%" valign="top"
												background="${ctx}/homepage/images/jiannan1.JPG"
												style="padding-left: 28px; padding-top: 4px; padding-bottom: 15px">
												<br>
												<div style="line-height: 15px; padding-bottom: 10px"></div>
												<a
													href="<s:url action="newsAction"> 
                					</s:url>"
													class="style3">新闻公告</a>
												<div style="line-height: 15px; padding-bottom: 10px">
												</div>

											</td>
										</tr>
									</table>
								</td>
								<td width="555" height="10" valign="top">
									<table width="555" height="100%" border="0" cellspacing="0"
										cellpadding="0"
										background="${ctx}/homepage/images/back-up-3.jpg">
										<tr>
											<td width="555" height="10"
												background="${ctx}/homepage/images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="555" height="534" border="0" cellspacing="0"
													cellpadding="0"
													background="${ctx}/homepage/images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: center bottom;">

													<tr>
														<br>
														<br>
														<br>
														<br>

													</tr>
													<tr>
														<td width="389" valign="top" style="padding-left: 5px">
															<div class="table">
																<img src="${ctx}/student/img/bg-th-left.gif" width="8"
																	height="7" alt="" class="left" />
																<img src="${ctx}/student/img/bg-th-right.gif" width="7"
																	height="7" alt="" class="right" />
																<s:form action="goChangeMyInfoAction" method="post">
																	<table class="listing form" cellpadding="0"
																		cellspacing="0">
																		<tr>
																			<th class="full" colspan="2">
																				新闻公告
																			</th>
																		</tr>
																		<s:iterator value="newsList" status="new">
																			<tr class="bg">
																				<td class="first">

																					<img src="${ctx}/homepage/images/but.jpg" width="4"
																						height="7">
																					&nbsp;
																					<a
																						href="<s:url action="enterNewsAction"> 
	                     											<s:param name="newsId"> 
	                       			 									<s:property value="id"/> 
	                    											</s:param> 
	                													</s:url>">
																						<s:property value="title" />&nbsp;&nbsp; <s:property
																							value="time" /> </a>
																					<br>

																				</td>
																			</tr>
																		</s:iterator>
																	</table>
																</s:form>
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