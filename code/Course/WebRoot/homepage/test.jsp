<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>《<s:property value="applicationForm.name" />》申报表格</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<LINK HREF="style.css" TYPE="text/css" REL="stylesheet">
	</head>

	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					&nbsp;
				</td>
				<td width="711" align="left" valign="top">
					<table width="711" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="107" align="left" valign="top">
								<table width="100%" height="107" border="0" cellpadding="0"
									cellspacing="0">
									<tr align="left" valign="top">
										<td width="468">
											<div style="padding-left: 22px; padding-top: 43px">
												<a href="index.jsp"><img
														src="coursePage/images/logo.jpg" width="248" height="38"
														border="0"> </a>
											</div>
										</td>
										<td>
											<div style="padding-left: 0px; padding-top: 68px">
												<table width="225" border="0" cellspacing="0"
													cellpadding="0">
													<tr align="left" valign="middle">
														<td width="45">
															<a href="#" class="style1">Account</a>
														</td>
														<td width="2">
															<img src="coursePage/images/p_1.jpg" width="2" height="2">
														</td>
														<td width="58" align="center">
															<a href="#" class="style1">View cart</a>
														</td>
														<td width="2" align="center">
															<img src="coursePage/images/p_1.jpg" width="2" height="2">
														</td>
														<td width="52" align="center">
															<a href="#" class="style1">Wish list</a>
														</td>
														<td width="2">
															<img src="coursePage/images/p_1.jpg" width="2" height="2">
														</td>
														<td align="right">
															<a href="#" class="style1">返回精品课程主站</a>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td background="coursePage/images/computers.jpg" width="101"
											height="30" border="0" align="center">
											<a
												href="<s:url action="enterCourseAction"> 
                     			<s:param name="applicationForm.course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												<font color="green">首页</font> </a>
										</td>
										<td background="coursePage/images/com_1.jpg" width="101"
											height="30" border="0" align="center">
											<a
												href="<s:url action="findApplicationFormAction"> 
                     			<s:param name="application.course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">
												<font color="green">申报表格</font> </a>
										</td>
									
<td>
							<a href="<s:url action="newsAction"> 
                					</s:url>">
								<font color="green">【查看新闻】</font></a>

						</td>
										<td background="coursePage/images/com_3.jpg" width="101"
											height="30" border="0" align="center">
										<a href="<s:url action="courseDisplayAction"> 
                					</s:url>">
								<font color="green">【查看精品课程】</font></a>
										</td>
										<td background="coursePage/images/com_4.jpg" width="101"
											height="30" border="0" align="center">
											<a href="#">成果展示</a>
										</td>
										<td background="coursePage/images/com_5.jpg" width="101"
											height="30" border="0" align="center">
											<a href="#">课程教案</a>
										</td>
										<td background="coursePage/images/com_6.jpg" width="101"
											height="30" border="0" align="center">
											<a href="#">实验习题</a>
										</td>
										<td background="coursePage/images/com_6.jpg" width="101"
											height="30" border="0" align="center">
											<a href="#">教学录像</a>
										</td>
										<td background="coursePage/images/com_6.jpg" width="101"
											height="30" border="0" align="center">
											<a href="#">课程评价</a>
										</td>
										<td background="coursePage/images/com_6.jpg" width="101"
											height="30" border="0" align="center">
											<a href="#">留言板</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="10" align="left" valign="top"
								background="coursePage/images/rep_1.jpg"
								style="background-repeat: repeat-x; background-position: top">
								<img src="coursePage/images/spacer.gif" width="1" height="10">
							</td>
						</tr>
						<tr>
							<td align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr align="left" valign="top">
										<td width="185" height="100%">
											<table width="180" height="100%" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td align="left" valign="top">
														<table width="180" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="24" align="left" valign="top"
																	background="coursePage/images/ket_1.jpg">
																	<div style="padding-left: 18px; padding-top: 5px">
																		<span class="style2">系统登陆</span>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="81" align="left" valign="top"
																	style="border-right: 1px solid #CBCBCB; border-left: 1px solid #CBCBCB">
																	<div style="padding-left: 15px; padding-top: 18px">
																		<table width="142" height="42" border="0"
																			cellpadding="0" cellspacing="0">
																			<form>
																			<tr>
																				<td align="left" valign="top">
																					<input type="text" name="textfield"
																						style="width: 142px; height: 18px; font-family: tahoma; font-size: 10px; background-color: #FFFFFF; color: #A6A6A6">
																				</td>
																			</tr>
																			<tr>
																				<td align="left" valign="bottom">
																					<table width="100%" border="0" cellspacing="0"
																						cellpadding="0">
																						<tr align="left" valign="middle">
																							<td>
																								<select name="select"
																									style="width: 114px; height: 18px; font-family: tahoma; font-size: 10px; background-color: #FFFFFF; color: #A6A6A6">
																									<option>
																										All products
																									</option>
																								</select>
																							</td>
																							<td align="right">
																								<input name="image" type="image"
																									src="coursePage/images/button_1.jpg" width="25"
																									height="19">
																							</td>
																						</tr>
																					</table>
																				</td>
																			</tr>
																			</form>
																		</table>
																	</div>
																	<div style="padding-left: 15px; padding-top: 2px">
																		<a href="#" class="style3">管理员登陆</a>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="5" align="left" valign="top">
																	<img src="coursePage/images/bot_1.jpg" width="180"
																		height="5">
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td height="7" align="left" valign="top">
														<img src="coursePage/images/spacer.gif" width="1"
															height="7">
													</td>
												</tr>
												<tr>
													<td height="100%" align="left" valign="top">
														<table width="180" height="100%" border="0"
															cellpadding="0" cellspacing="0">
															<tr>
																<td height="24" align="left" valign="top"
																	background="coursePage/images/ket_1.jpg">
																	<div style="padding-left: 18px; padding-top: 5px">
																		<span class="style2">教学资源</span>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="100%" align="left" valign="top"
																	style="border-right: 1px solid #CBCBCB; border-left: 1px solid #CBCBCB">
																	<div
																		style="padding-left: 17px; padding-top: 5px; padding-bottom: 3px">
																		<table width="140" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr align="left" valign="middle">
																				<td width="9" height="21">
																					<img src="coursePage/images/point_1.jpg" width="3"
																						height="3">
																				</td>
																				<td height="21">
																					<a href="#" class="style3">教学课件</a>
																				</td>
																			</tr>
																			<tr align="left" valign="middle">
																				<td height="21">
																					<img src="coursePage/images/point_1.jpg" width="3"
																						height="3">
																				</td>
																				<td height="21">
																					<a href="#" class="style3">教学视频</a>
																				</td>
																			</tr>
																			<tr align="left" valign="middle">
																				<td height="21">
																					<img src="coursePage/images/point_1.jpg" width="3"
																						height="3">
																				</td>
																				<td height="21">
																					<a href="#" class="style3">作业习题</a>
																				</td>
																			</tr>
																			<tr align="left" valign="middle">
																				<td height="21">
																					<img src="coursePage/images/point_1.jpg" width="3"
																						height="3">
																				</td>
																				<td height="21">
																					<a href="#" class="style3">课程进度</a>
																				</td>
																			</tr>
																			<tr align="left" valign="middle">
																				<td height="21">
																					<img src="coursePage/images/point_1.jpg" width="3"
																						height="3">
																				</td>
																				<td height="21">
																					<a href="#" class="style3">实验指导</a>
																				</td>
																			</tr>
																		</table>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="5" align="left" valign="top">
																	<img src="coursePage/images/bot_1.jpg" width="180"
																		height="5">
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
										<td width="450" height="100%">
											<table width="450" height="100%" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="100%" align="center" valign="top">
						<table class=editTable cellSpacing=1 cellPadding=0
													width="100%" align=center border=0>
													<tr class=position bgcolor="#ECF3FD">
														<td>
															当前位置: 首页 -&gt; 申报表格
														</td>
													</tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
												</table>
														<table class=editTable cellSpacing=1 cellPadding=0
															width="450" align=center border=0>
															<tr bgcolor="#FFFDF0" height="30">
																<td>
																	<div align="center">
																		推荐单位
																	</div>
																</td>
																<td>
																	&nbsp;&nbsp;
																	<s:property value="applicationForm.unit" />
																</td>
															</tr>
															<tr bgcolor="#ECF3FD" height="30">
																<td width="30%">
																	<div align="center">
																		所属院校
																	</div>
																</td>
																<td width="70%">
																	&nbsp;&nbsp;
																	<s:property value="applicationForm.school" />
																</td>
															</tr>
															<tr bgcolor="#FFFDF0" height="30">
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
															<tr bgcolor="#ECF3FD" height="30">
																<td width="30%">
																	<div align="center">
																		课程类型
																	</div>
																</td>
																<td width="70%">
																	&nbsp;&nbsp;
																	<s:property value="applicationForm.sort" />
																</td>
															</tr>
															<tr bgcolor="#FFFDF0" height="30">
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
															<tr bgcolor="#ECF3FD" height="30">
																<td width="30%">
																	<div align="center">
																		所属二级学科名称
																	</div>
																</td>
																<td width="70%">
																	&nbsp;&nbsp;
																	<s:property value="applicationForm.secondSubjet" />
																</td>
															</tr>
															<tr bgcolor="#FFFDF0" height="30">
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
															<tr bgcolor="#ECF3FD" height="30">
																<td width="30%">
																	<div align="center">
																		申报日期
																	</div>
																</td>
																<td width="70%">
																	&nbsp;&nbsp;
																	<s:property value="applicationForm.time" />
																</td>
															</tr>
															<tr>
																<td height="5" align="left" valign="top" colspan="2">
																	<img src="coursePage/images/bot_4.jpg" width="100%"
																		height="5">
																	<br>
																	<div align="center">
																		中华人民共和国教育部制
																	</div>
																	<br>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
										<td height="100%">
											<table width="180" height="100%" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td height="100%" align="left" valign="top">
														<table width="180" height="100%" border="0"
															cellpadding="0" cellspacing="0">
															<tr>
																<td height="24" align="left" valign="top"
																	background="coursePage/images/ket_1.jpg">
																	<div style="padding-left: 18px; padding-top: 5px">
																		<span class="style2">课程简介</span>
																	</div>
																</td>
															</tr>
															<tr>
																<td align="left" valign="top"
																	background="coursePage/images/back_1.jpg"
																	style="border-right: 1px solid #CBCBCB; border-left: 1px solid #CBCBCB; background-position: top right; background-repeat: no-repeat">
																	<div style="padding-left: 16px; padding-top: 14px">
																		<img src="coursePage/images/vesti.jpg" width="73"
																			height="25">
																	</div>
																	<div class="style5"
																		style="padding-left: 17px; padding-top: 11px; padding-right: 89px">
																		课程简介
																	</div>
																	<div
																		style="padding-left: 15px; padding-top: 5px; line-height: 10px; padding-bottom: 10px; font-size: 10px">
																		<img src="coursePage/images/point_1.jpg" width="3"
																			height="3" vspace="2">
																		<a href="#" class="style3">Learn more</a>
																	</div>
																</td>
															</tr>
															<tr>
																<td align="left" valign="top"
																	background="coursePage/images/line_1.jpg"
																	style="border-right: 1px solid #CBCBCB; border-left: 1px solid #CBCBCB; background-position: top left; background-repeat: no-repeat">
																	<div style="padding-left: 15px; padding-top: 15px">
																		<img src="coursePage/images/tellus.jpg" width="140"
																			height="12">
																	</div>
																	<div class="style5"
																		style="padding-left: 17px; padding-top: 11px; padding-right: 12px">
																		Aliquam dapibus tincidunt metus praesent justo dolor,
																		lobortis quis, lobortis dignissim.
																	</div>
																	<div
																		style="padding-left: 15px; padding-top: 5px; line-height: 10px; padding-bottom: 10px; font-size: 10px">
																		<img src="coursePage/images/point_1.jpg" width="3"
																			height="3" vspace="2">
																		<a href="#" class="style3">Learn more</a>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="100%" align="left" valign="top"
																	background="coursePage/images/line_1.jpg"
																	style="border-right: 1px solid #CBCBCB; border-left: 1px solid #CBCBCB; background-position: top left; background-repeat: no-repeat">
																	<div
																		style="padding-left: 15px; padding-top: 12px; padding-right: 11px">
																		<img src="coursePage/images/back_2.jpg" width="60"
																			height="78" align="right">
																		<div style="padding-left: 0px; padding-top: 1px">
																			<img src="coursePage/images/diam.jpg">
																		</div>
																		<div class="style5"
																			style="padding-left: 2px; padding-top: 11px; padding-right: 0px">
																			课程进度
																		</div>
																		<div
																			style="padding-left: 0px; padding-top: 5px; line-height: 10px; padding-bottom: 10px; font-size: 10px">
																			<img src="coursePage/images/point_1.jpg" width="3"
																				height="3" vspace="2">
																			<a href="#" class="style3">Learn more</a>
																		</div>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="5" align="left" valign="top">
																	<img src="coursePage/images/bot_1.jpg" width="180"
																		height="5">
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td height="7" align="left" valign="top">
														<img src="coursePage/images/spacer.gif" width="1"
															height="7">
													</td>
												</tr>
												<tr>
													<td align="left" valign="top">
														<table width="180" height="100%" border="0"
															cellpadding="0" cellspacing="0">
															<tr>
																<td height="24" align="left" valign="top"
																	background="coursePage/images/ket_1.jpg">
																	<div style="padding-left: 18px; padding-top: 5px">
																		<span class="style2">给我留言</span>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="100" align="left" valign="top"
																	style="border-right: 1px solid #CBCBCB; border-left: 1px solid #CBCBCB">
																	<div class="style5"
																		style="padding-left: 17px; padding-top: 11px; padding-right: 12px">
																		同老师在线讨论课程，共同分享学习乐趣！
																	</div>
																	<div
																		style="padding-left: 15px; padding-top: 7px; padding-bottom: 7px">
																		<table width="142" height="44" border="0"
																			cellpadding="0" cellspacing="0">
																			<form>
																			<tr>
																				<td align="left" valign="top">
																					<input name="textfield" type="text"
																						style="width: 142px; height: 18px; font-family: tahoma; font-size: 10px; background-color: #FFFFFF; color: #A6A6A6"
																						value="Enter your e-mail here">
																				</td>
																			</tr>
																			<tr>
																				<td align="left" valign="bottom">
																					<input type="image"
																						src="coursePage/images/subs.jpg" width="67"
																						height="20">
																				</td>
																			</tr>
																			</form>
																		</table>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="5" align="left" valign="top">
																	<img src="coursePage/images/bot_1.jpg" width="180"
																		height="5">
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
						<tr>
							<td height="10" align="left" valign="top">
								<img src="coursePage/images/spacer.gif" width="1" height="10">
							</td>
						</tr>
						<tr>
							<td align="left" valign="top"
								style="border-top: 2px solid #BFBFBF">
								<table width="650" border="0" cellspacing="0" cellpadding="0">
									<tr align="left" valign="top">
										<td width="188">
											<div style="padding-left: 10px; padding-top: 16px">
												<table width="162" border="0" cellspacing="0"
													cellpadding="0">
													<tr align="left" valign="middle">
														<td width="82">
															<a href="#"><img src="coursePage/images/pay_1.jpg"
																	width="80" height="26" border="0"> </a>
														</td>
														<td width="41">
															<a href="#"><img src="coursePage/images/pay_2.jpg"
																	width="39" height="26" border="0"> </a>
														</td>
														<td>
															<a href="#"><img src="coursePage/images/pay_3.jpg"
																	width="39" height="26" border="0"> </a>
														</td>
													</tr>
												</table>
											</div>
										</td>
										<td>
											<div style="padding-left: 0px; padding-top: 15px">
												<span class="style6"><a href="#" class="style6">Computers</a>
													<img src="coursePage/images/point_2.jpg" hspace="11"
														vspace="2"><a href="#" class="style6">Peripherals</a>
													<img src="coursePage/images/point_2.jpg" hspace="11"
														vspace="2"><a href="#" class="style6">Networking</a>
													<img src="coursePage/images/point_2.jpg" hspace="11"
														vspace="2"><a href="#" class="style6">Software</a> <img
														src="coursePage/images/point_2.jpg" hspace="11" vspace="2"><a
													href="#" class="style6">Supplies</a> <img
														src="coursePage/images/point_2.jpg" hspace="11" vspace="2"><a
													href="#" class="style6">Services</a> <img
														src="coursePage/images/point_2.jpg" hspace="11" vspace="2"><a
													href="#" class="style6">Promotion</a> </span>
											</div>
											<div style="padding-left: 0px; padding-top: 3px">
												<span class="style8">Copyright ?2005 Company name,
													Inc. All Rights Reserved. <a href="index-2.html"
													class="style8" style="text-decoration: none">Privacy
														Policy</a> </span>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
				<td width="711" align="left" valign="top">
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
	</body>
</html>
