<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%><html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><s:property value="notice.title"></s:property>-新闻公告-厦门大学网络课程中心</title>
		<link rel="stylesheet" href="${ctx}/coursepage/classical/link.css">
	</head>
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		background="${ctx}/coursepage/classical/image/back.gif">

		<!-- 导航 -->
		<s:include value="classical/header.jsp"></s:include>
		<!-- /导航 -->

		<!-- 正文-->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr>
				<td width="175">
					<!--左边栏 -->
					<s:include value="classical/left.jsp"></s:include>
					<!-- /左边栏 -->
				</td>
				<td width="775" valign="top" align="center">
					<table border="0" cellpadding="0" cellspacing="0" align="center">
						<tr>
							<td>
								<!-- 中间主体内容 -->
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td colspan="3">
											<img width="775"
												src="${ctx}/coursepage/classical/image/topline2.gif"
												border="0">
										</td>
									</tr>
									<tr>
										<td width="1" bgcolor="#b29f79"></td>
										<td bgcolor="#fdfbf3">
											<table border="0" cellpadding="0" cellspacing="0" width="773">
												<tr>
													<td>
														<table border="0" cellpadding="0" cellspacing="0">
															<tr>
																<td valign="bottom">
																	&nbsp;
																</td>
																<td>
																	<table border="0" cellpadding="0" cellspacing="0">

																		<tr>
																			<td colspan="3">
																				<table border="0" cellpadding="0" cellspacing="0">
																					<tr>
																						<td>
																							<!-- 课程内容 -->
																							<table border="0" cellpadding="0" cellspacing="0">
																								<tr>
																									<td width="773" align="center">
																										<table border="0" cellpadding="0"
																											cellspacing="0" width="760" height="94"
																											background="${ctx}/coursepage/classical/image/titlebg.gif"
																											style="background-repeat: no-repeat">
																											<tr>
																												<td width="750" valign="top" align="right">
																													<font
																														style="font-size: 12px; color: #574434">首页
																														><b>教学视频 ><b>在线观看</b>
																													</font>
																												</td>
																											</tr>
																											<tr height="69">
																												<td valign="bottom" align="left">
																													<table border="0" cellpadding="0"
																														cellspacing="0">
																														<tr>
																															<td>
																																<font color="#966f48"
																																	style="font-size: 16px; font-weight: bold"><s:property
																																		value="courseMovie.title" /> </font>
																															</td>
																														</tr>
																														<tr>
																															<td>
																																<font color="#92a35d"
																																	style="font-size: 12px;">发布时间：<s:date
																																		name="courseMovie.time"
																																		format="yyyy-MM-dd" /> </font>
																															</td>
																														</tr>
																													</table>
																												</td>
																											</tr>
																											<tr height="1">
																												<td width="750" bgcolor="#c4ae86"
																													valign="top"></td>
																											</tr>
																										</table>
																									</td>
																								</tr>
																								<tr height="20">
																									<td></td>
																								</tr>
																								<tr>
																									<td>
																										<table border="0" cellpadding="0"
																											cellspacing="0" width="100%">
																											<tr>
																												<td align="center">
																													<object
																														classid=clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA
																														height=480 id=RAOCX name=rmplay width=600>
																														<param name="SRC" value="01.rm">
																														<param name="CONSOLE" value="Clip1">
																														<param name="CONTROLS" value="imagewindow">
																														<param name="AUTOSTART" value="true">
																														<embed src="01.rm" autostart="true"
																															controls="ImageWindow" console="Clip1"
																															pluginspage="http://www.real.com"
																															/’ target="_blank">
																														http://www.real.com"; width="356"
																														height="285">
																														</embed>
																													</object>
																													<br />
																													<object
																														classid=clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA
																														height=27 id=video1 width=600>
																														<param name="_ExtentX" value="7276">
																														<param name="_ExtentY" value="1058">
																														<param name="AUTOSTART" value="0">
																														<param name="SHUFFLE" value="0">
																														<param name="PREFETCH" value="0">
																														<param name="NOLABELS" value="0">
																														<param name="CONTROLS"
																															value="ControlPanel">
																														<param name="CONSOLE" value="Clip1">
																														<param name="LOOP" value="0">
																														<param name="NUMLOOP" value="0">
																														<param name="CENTER" value="0">
																														<param name="MAINTAINASPECT" value="0">
																														<param name="BACKGROUNDCOLOR"
																															value="#ffffff">
																														<embed type="audio/x-pn-realaudio-plugin"
																															console="Clip1" controls="ControlPanel"
																															height="27" width="356" autostart="0"
																															_extentx="7276" _extenty="1058"
																															shuffle="0" prefetch="0" nolabels="0"
																															loop="0" numloop="0" center="0"
																															maintainaspect="0"
																															backgroundcolor="#ffffff">
																														</embed>
																													</object>
																												</td>
																											</tr>
																											<tr>
																												<td width="24"></td>
																											</tr>

																										</table>
																									</td>
																								</tr>
																						<tr>
																								<td align="center">
<table border="1" cellpadding="0" cellspacing="0" width="600">
<tr><td colspan="2">
<table border="1" cellpadding="0" cellspacing="0" align="center"><tr><td width="50" align="center"><font style="font-size:12px;font-weight:bold;">发布者：</font></td><td width="120" align="center"><font color="#74582f"><s:property value="courseMovie.author" /></font></td>
<td width="80" align="center"><font style="font-size:12px;font-weight:bold;">发布时间：</font></td><td width="150" align="center"><font color="#74582f"><s:date name="courseMovie.time" format="yyyy-MM-dd" /></font></td>
<td width="50" align="center"><font style="font-size:12px;font-weight:bold;">职称：</font></td><td width="150" align="center"><s:property value="courseMovie.position" /></td></tr></table></td>
</tr>
<tr><td width="120"><font style="font-size:14px;font-weight:bold;">视频简介：</font></td><td width="480"><font color="#74582f"><s:property value="courseMovie.content" /></font></td>
</tr>
<tr><td width="120"><font style="font-size:14px;font-weight:bold;">下载链接：</font></td><td width="480"><a
																														href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="courseMovie.fileLink"/> 
                    			</s:param> 
						<s:param name="originalFileName"> 
                       			 	<s:property value="courseMovie.filename"/> 
                    			</s:param> 
                					</s:url>"
																														onclick="JAVAscript:if(!confirm('确认下载影片？')) return false;return true;">
																														<font color="red">点此下载</font> </a></td>
</tr>
</table>																													
</td>
																										</tr>
																								<tr height="35">
																									<td></td>
																								</tr>
																								<tr height="45">
																									<td width="753" align="right" valign="top">
																										<a href="#"><img
																												src="${ctx}/coursepage/classical/image/button.gif"
																												border="0"> </a>
																									</td>
																								</tr>
																							</table>
																							<!-- /주요클리닉 -->
																						</td>
																					</tr>
																				</table>
																			</td>
																		</tr>
																		<tr height="12">
																			<td></td>
																		</tr>
																	</table>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
										<td width="1" bgcolor="#cec1a6"></td>
									</tr>
									<tr>
										<td colspan="3">
											<img width="775"
												src="${ctx}/coursepage/classical/image/bottomline2.gif"
												border="0">
										</td>
									</tr>
									<tr height="10">
										<td colspan="3"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
				<td width="13"></td>
			</tr>
		</table>
		<!-- /내용부분-->

		<!--底部 -->
		<s:include value="classical/bottom.jsp"></s:include>
		<!--/底部 -->

	</body>
</html>
