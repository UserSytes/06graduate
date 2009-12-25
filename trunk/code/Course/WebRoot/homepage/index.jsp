<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站</title>
	</head>
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="images/back-body.jpg" style="overflow-x: hidden">
		<center>

			<table width="783" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%" background="images/back-left.jpg">
						<img src="images/spacer.gif" width="9" height="1">
					</td>


					<td width="765" height="100%" valign="top"
						background="images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=765 height="102">
									<s:include value="include/header.jsp"></s:include>
								</td>
							</tr>
							<tr>
								<td width="210" height="10" valign="top">
									<table width="218" height="688" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="60">
												<img src="images/up-1.jpg" width="218" height="60">
											</td>
										</tr>

										<tr>
											<td height="42">
												<img src="images/but-1.jpg" width="218" height="42">
											</td>
										</tr>
										<tr>
											<td width="210" height="10" bgcolor="#64A5CF">
												<table width="100%" height="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="29%" height="95" align="right" valign="top"
															style="padding-left: 10px; padding-right: 8px; padding-top: 13px">
															<font face="tahoma"
																style="font-size: 11px; color: #FFFFFF"><strong>用户名:
																	<div style="padding-top: 14px">
																		密码:
																	</div> </strong> </font>
														</td>
														<td width="55%" valign="top"
															style="padding-top: 10px; padding-bottom: 11px">
															<input type="txt"
																style="width: 93px; height: 17px; font-size: 11px; margin-bottom: 8px">
															<br>
															<input name="" type="password"
																style="width: 93px; height: 17px; font-size: 11px">
															<br>
															<br>
															<select name="select"
																style="width: 93px; height: 17px; font-size: 11px">
																<option>
																	管理员
																</option>
																<option>
																	老师
																</option>
																<option>
																	学生
																</option>
															</select>
														</td>
														<td width="16%" valign="top"
															style="padding-right: 5px; padding-top: 38px">

															<a href="#"><img src="images/ok.jpg" width="25"
																	height="17" border="0"> </a>
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td height="38">
												<img src="images/but-2.jpg" width="218" height="38">
											</td>
										</tr>
										<tr>
											<td width="210" height="100%" valign="top"
												background="images/back-but-2.jpg"
												style="padding-left: 28px; padding-top: 4px; padding-bottom: 15px">
												<br>
												<div style="line-height: 15px; padding-bottom: 10px"></div>
												<a href="http://www.moe.edu.cn/" class="style3">中华人民共和国教育部</a>
												<div style="line-height: 15px; padding-bottom: 10px">
												</div>
												<a href="http://www.jpk.pku.edu.cn/pkujpk/" class="style3">北京大学精品课程</a>
												<div style="line-height: 15px; padding-bottom: 10px">
												</div>
												<a href="http://jpkc.fudan.edu.cn/" class="style3">复旦大学精品课程</a>
											</td>
										</tr>
									</table>
								</td>



								<td width="555" height="10" valign="top">
									<table width="555" height="100%" border="0" cellspacing="0"
										cellpadding="0" background="images/back-up-3.jpg">
										<tr>
											<td width="555" height="10" background="images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="100%" height="10" border="0" cellspacing="0"
													cellpadding="0" background="images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: bottom">
													<tr>
														<td colspan="5"
															style="padding-left: 110px; padding-bottom: 8px"
															valign="top">
															<img src="images/but-10.jpg" width="248" height="38">
														</td>
													</tr>
													<tr>
														<td width="166" height="100%" valign="top">
															<img src="images/pic-10.jpg" width="154" height="156"
																style="width: 154px; height: 156px;">
														</td>
														<td width="389" valign="top" style="padding-left: 5px">
															<img src="images/text-19.jpg" width="114" height="17"
																style="margin-bottom: 10px">
															<br>
															<font face="tahoma"
																style="font-size: 10px; color: #828688"><strong>

																	<s:iterator value="newsList" status="new">
																		<img src="images/but.jpg" width="4" height="7">&nbsp;
																		<a
																			href="<s:url action="enterNewsAction"> 
	                     											<s:param name="newsId"> 
	                       			 									<s:property value="id"/> 
	                    											</s:param> 
	                													</s:url>">
																			<s:property value="title" />&nbsp;&nbsp;
																		<s:property value="time" /></a>
																		
																		<br>
																	</s:iterator> <br> <img src="images/but.jpg" width="4"
																		height="7"> <a href="#"
																	style="color: #828688; text-decoration: none">Cardiology</a>
																	<br> <img src="images/but.jpg" width="4"
																		height="7">&nbsp; <a href="#"
																	style="color: #828688; text-decoration: none">Chronic
																		Disease</a> <br> <img src="images/but.jpg" width="4"
																		height="7">&nbsp; <a href="#"
																	style="color: #828688; text-decoration: none">Dentistry</a>
																	<br> </strong> </font>
														</td>

													</tr>
												</table>
											</td>
										</tr>
										<td width="555" height="33" align="left"
											background="images/back-tab.jpg">
											<table width="554" height="33" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="553" height="33"
														background="images/back-but-4.jpg">
														<img src="images/but-4.jpg" width="160" height="33">
														<img src="images/spacer.gif" width="108" height="1">
													</td>
												</tr>
											</table>
										</td>
										</tr>
										<tr>
											<td width="555" height="100%"
												background="images/back-tab.jpg">
												<table width="555" height="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="281" height="267" valign="top"
															style="padding-left: 9px; padding-bottom: 15px">


															<font face="tahoma" style="font-size: 13px"> <br>
																<img src="images/but.jpg" width="4" height="7"> <a
																href="#">09年</a> <br> <br> <br> <br>
																<div style="padding-top: 4px">
																	<a href="#"
																		style="color: #0CA4FF; text-decoration: none"><strong>learn
																			more</strong> </a>
																	<img src="images/but-blue.jpg" width="15" height="7">
																</div> </font>
														</td>
														<td width="2" height="167"
															background="images/back-line-up-1.jpg">
															<table width="2" height="100%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td>
																		<img src="images/line-up-1.jpg" width="2" height="50">
																	</td>
																</tr>
																<tr>
																	<td height="100%">
																		<img src="images/spacer.gif" width="2" height="1">
																	</td>
																</tr>
																<tr>
																	<td>
																		<img src="images/end-line-up-1.jpg" width="2"
																			height="47">
																	</td>
																</tr>
															</table>
														</td>
													</tr>

													<tr>
														<td colspan="3" bgcolor="#B2B2B2">
															<img src="images/spacer.gif" width="1" height="1">
														</td>
													</tr>

													<tr>
														<td width="553" height="33"
															background="images/back-but-4.jpg">
															<img src="images/but-5.jpg" width="139" height="33">
															<img src="images/spacer.gif" width="108" height="1">
														</td>
													</tr>
													<tr>

														<td width="281" height="100%" valign="top"
															style="padding-left: 9px; padding-bottom: 10px; padding-top: 10px">
															<br>
															<img src="images/pic-5.jpg" width="123" height="71"
																align="left" style="margin-right: 10px">
															<font face="tahoma"
																style="font-size: 13px; color: #828688; line-height: 11px">
																国家级：10门 </font>
															<br>
															<br>
															<font face="tahoma"
																style="font-size: 13px; color: #828688; line-height: 11px">
																省级：10门 </font>
															<br>
															<br>
															<font face="tahoma"
																style="font-size: 13px; color: #828688; line-height: 11px">
																校级：10门 </font>
														</td>

														<td width="2" height="100%"
															background="images/back-line-up-1.jpg">
															<table width="2" height="100%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td>
																		<img src="images/line-up-1.jpg" width="2" height="50">
																	</td>
																</tr>
																<tr>
																	<td height="100%">
																		<img src="images/spacer.gif" width="2" height="1">
																	</td>
																</tr>
																<tr>
																	<td>
																		<img src="images/end-line-up-1.jpg" width="2"
																			height="47">
																	</td>
																</tr>
															</table>
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
									<img src="images/spacer.gif" width="1" height="1">
								</td>
							</tr>
						</table>
					</td>



					<td width="9" height="100%" background="images/back-right.jpg">
						<img src="images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
		</center>
	</BODY>
</html>