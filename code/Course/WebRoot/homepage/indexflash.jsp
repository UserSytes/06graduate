<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站</title>
		<script type="text/javascript" src="/dwr/engine.js"></script>
		<script type="text/javascript" src="/dwr/util.js"></script>
		<script type="text/javascript" src="/dwr/interface/NewsService.js"></script>
		<SCRIPT language=javascript>

	function getNews() {
		newsList=newsService.findAllNews();
	}
	function callBack(data){
		if(data != null)
			DWRUtil.setValue('result',data.name);
		else
			DWRUtil.setValue('result',"该学生不存在");
	}
</SCRIPT>
	</head>
	<BODY  BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="${ctx}/homepage/images/back-body.jpg" style="overflow-x: hidden">
		<center>

			<table width="783" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%" background="${ctx}/homepage/images/back-left.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>


					<td width="765" height="100%" valign="top"
						background="${ctx}/homepage/images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=765 height="102">
									<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="765" height="102">
                  <param name="movie" value="flash/delta46test.swf">
                  <param name="quality" value="high"> <param name="menu" value="false">
                  <embed src="flash/delta46test.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="765" height="102"></embed>
			  </object>
								</td>
							</tr>
							<tr>
								<td width="210" height="10" valign="top">
									<table width="218" height="688" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="60">
												<img src="${ctx}/homepage/images/up-1.jpg" width="218" height="60">
											</td>
										</tr>

										<tr>
											<td height="42">
												<img src="${ctx}/homepage/images/but-1.jpg" width="218" height="42">
											</td>
										</tr>
										<tr>
											<td width="210" height="10" bgcolor="#64A5CF">
												<s:form action="loginFromHomePageAction" method="post"
													onsubmit="">
													<table width="100%" height="100%" border="0"
														cellspacing="0" cellpadding="0">
														<tr>
															<td width="70" height="30" align="left">
																&nbsp;账号：
															</td>
															<td>
																<s:textfield name="userName"></s:textfield>
															</td>
														</tr>
														<tr>
															<td height="30" width="70" align="left">
																&nbsp;密码：
															</td>
															<td>
																<s:password name="password"></s:password>
															</td>
														</tr>
														<tr>
															<td height="30">
																&nbsp;权限：
															</td>
															<td>
																<s:select name="flag" list="# {'0':'老師','1':'學生'}"
																	headerKey="-1" headerValue="请选择" />
															</td>
														</tr>
														<tr>
															<td colspan="2" align="center">
																<input type="submit" name="submit"
																	style="background: url(${ctx}/homepage/images/login_5.gif) no-repeat"
																	value=" 登  陆 ">
																<input type="reset" name="Submit"
																	style="background: url(${ctx}/homepage/images/login_5.gif) no-repeat"
																	value=" 取  消 ">
															</td>
														<tr>
													</table>
												</s:form>
											</td>
										</tr>
										<tr>
											<td height="38">
												<img src="${ctx}/homepage/images/but-2.jpg" width="218" height="38">
											</td>
										</tr>
										<tr>
											<td width="210" height="100%" valign="top"
												background="${ctx}/homepage/images/back-but-2.jpg"
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
										cellpadding="0" background="${ctx}/homepage/images/back-up-3.jpg">
										<tr>
											<td width="555" height="10" background="${ctx}/homepage/images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="100%" height="10" border="0" cellspacing="0"
													cellpadding="0" background="${ctx}/homepage/images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: bottom">
													<tr>
														<td colspan="5"
															style="padding-left: 110px; padding-bottom: 8px"
															valign="top">
															<img src="${ctx}/homepage/images/but-10.jpg" width="248" height="38">
														</td>
													</tr>
													<tr>
														<td width="166" height="100%" valign="top">
															<img src="${ctx}/homepage/images/pic-10.jpg" width="154" height="156"
																style="width: 154px; height: 156px;">
														</td>
														<td width="389" valign="top" style="padding-left: 5px">
															<img src="${ctx}/homepage/images/text-19.jpg" width="114" height="17"
																style="margin-bottom: 10px">
															<br>
															<font face="tahoma"
																style="font-size: 10px; color: #828688"><strong>

																	<s:iterator value="newsList" status="new">
																		<img src="${ctx}/homepage/images/but.jpg" width="4" height="7">&nbsp;
																		<a
																			href="<s:url action="enterNewsAction"> 
	                     											<s:param name="newsId"> 
	                       			 									<s:property value="id"/> 
	                    											</s:param> 
	                													</s:url>">
																			<s:property value="title" />&nbsp;&nbsp; ${new.title}<s:property
																				value="time" /> </a>
																		<br>
																	</s:iterator> </strong> </font>
														</td>

													</tr>
												</table>
											</td>
										</tr>
										<td width="555" height="33" align="left"
											background="${ctx}/homepage/images/back-tab.jpg">
											<table width="554" height="33" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="553" height="33"
														background="${ctx}/homepage/images/back-but-4.jpg">
														<img src="${ctx}/homepage/images/but-4.jpg" width="160" height="33">
														<img src="${ctx}/homepage/images/spacer.gif" width="108" height="1">
													</td>
												</tr>
											</table>
										</td>
										</tr>
										<tr>
											<td width="555" height="100%"
												background="${ctx}/homepage/images/back-tab.jpg">
												<table width="555" height="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="281" height="267" valign="top"
															style="padding-left: 9px; padding-bottom: 15px">

												
															<font face="tahoma" style="font-size: 13px"> <br>
																<img src="${ctx}/homepage/images/but.jpg" width="4" height="7"> <a
																href="<s:url action="courseDisplayAction"> 
                                                                    <s:param name="level"> 
                                                                   country
	                    											</s:param>
                                      <s:param name="time"> 
                                                                   2009
	                    											</s:param>
	                													</s:url>">09年国家级精品课程名单</a>
																<br> <font face="tahoma" style="font-size: 13px">
																	<br> <img src="${ctx}/homepage/images/but.jpg" width="4"
																		height="7"> <a href="<s:url action="courseDisplayAction"> 
                                                                    <s:param name="level"> 
                                                                   province
	                    											</s:param>
                                      <s:param name="time"> 
                                                                   2009
	                    											</s:param>
	                													</s:url>">09年福建省精品课程名单</a> <br>
																	<font face="tahoma" style="font-size: 13px"> <br>
																		<img src="${ctx}/homepage/images/but.jpg" width="4" height="7">
																		<a href="<s:url action="courseDisplayAction"> 
                                                                    <s:param name="level"> 
                                                                   school
	                    											</s:param>
                                      <s:param name="time"> 
                                                                   2009
	                    											</s:param>
	                													</s:url>">09年校级精品课程名单</a> <br> <font
																		face="tahoma" style="font-size: 13px"> <br>
																			<img src="${ctx}/homepage/images/but.jpg" width="4" height="7">
																			<a href="<s:url action="courseDisplayAction"> 
                                                                    <s:param name="level"> 
                                                                   country
	                    											</s:param>
                                      <s:param name="time"> 
                                                                   2008
	                    											</s:param>
	                													</s:url>">08年国家级精品课程名单</a> <br> <font
																			face="tahoma" style="font-size: 13px"> <br>
																				<img src="${ctx}/homepage/images/but.jpg" width="4" height="7">
																				<a href="<s:url action="courseDisplayAction"> 
                                                                    <s:param name="level"> 
                                                                   province
	                    											</s:param>
                                      <s:param name="time"> 
                                                                   2008
	                    											</s:param>
	                													</s:url>">08年福建省精品课程名单</a> <br> <font
																				face="tahoma" style="font-size: 13px"> <br>
																					<img src="${ctx}/homepage/images/but.jpg" width="4" height="7">
																					<a href="<s:url action="courseDisplayAction"> 
                                                                    <s:param name="level"> 
                                                                  school
	                    											</s:param>
                                      <s:param name="time"> 
                                                                   2008
	                    											</s:param>
	                													</s:url>">08校级精品课程名单</a> <br>
																					<div style="padding-top: 4px">
																						<br>
																						<a href="#"
																							style="color: #0CA4FF; text-decoration: none"><strong>learn
																								more</strong> </a>
																						<img src="${ctx}/homepage/images/but-blue.jpg" width="15"
																							height="7">
																					</div> </font>
														</td>
														<td width="2" height="167"
															background="${ctx}/homepage/images/back-line-up-1.jpg">
															<table width="2" height="100%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td>
																		<img src="${ctx}/homepage/images/line-up-1.jpg" width="2" height="50">
																	</td>
																</tr>
																<tr>
																	<td height="100%">
																		<img src="${ctx}/homepage/images/spacer.gif" width="2" height="1">
																	</td>
																</tr>
																<tr>
																	<td>
																		<img src="${ctx}/homepage/images/end-line-up-1.jpg" width="2"
																			height="47">
																	</td>
																</tr>
															</table>
														</td>
													</tr>

													<tr>
														<td colspan="3" bgcolor="#B2B2B2">
															<img src="${ctx}/homepage/images/spacer.gif" width="1" height="1">
														</td>
													</tr>

													<tr>
														<td width="553" height="33"
															background="${ctx}/homepage/images/back-but-4.jpg">
															<img src="${ctx}/homepage/images/but-5.jpg" width="139" height="33">
															<img src="${ctx}/homepage/images/spacer.gif" width="108" height="1">
														</td>
													</tr>
													<tr>

														<td width="281" height="100%" valign="top"
															style="padding-left: 9px; padding-bottom: 10px; padding-top: 10px">
															<br>
															<img src="${ctx}/homepage/images/pic-5.jpg" width="123" height="71"
																align="left" style="margin-right: 10px">
															<font face="tahoma"
																style="font-size: 13px; color: #828688; line-height: 11px">
																国家级：10门 </font>
															<br>
															<br>
															<font face="tahoma"
																style="font-size: 13px; color: #828688; line-height: 11px">
																省级：15门 </font>
															<br>
															<br>
															<font face="tahoma"
																style="font-size: 13px; color: #828688; line-height: 11px">
																校级：20门 </font>
														</td>

														<td width="2" height="100%"
															background="${ctx}/homepage/images/back-line-up-1.jpg">
															<table width="2" height="100%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td>
																		<img src="${ctx}/homepage/images/line-up-1.jpg" width="2" height="50">
																	</td>
																</tr>
																<tr>
																	<td height="100%">
																		<img src="${ctx}/homepage/images/spacer.gif" width="2" height="1">
																	</td>
																</tr>
																<tr>
																	<td>
																		<img src="${ctx}/homepage/images/end-line-up-1.jpg" width="2"
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
									<img src="${ctx}/homepage/images/spacer.gif" width="1" height="1">
								</td>
							</tr>
						</table>
					</td>



					<td width="9" height="100%" background="${ctx}/homepage/images/back-right.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
		</center>
	</BODY>
</html>