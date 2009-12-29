<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻公告-><s:property value="news.title"/></title>
	</head>
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="homepage/images/back-body.jpg" style="overflow-x: hidden">
		<center>

			<table width="783" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%"
						background="homepage/images/back-left.jpg">
						<img src="homepage/images/spacer.gif" width="9" height="1">
					</td>


					<td width="765" height="100%" valign="top"
						background="homepage/images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=765 height="102">
									<s:include value="include/header3.jsp"></s:include>
								</td>
							</tr>
							<tr>
								<td width="210" height="10" valign="top">
									<table width="214" height="543" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="60">
												<img src="homepage/images/up-1.jpg" width="214" height="60">
											</td>
										</tr>

										<tr>
											<td height="38">
												<img src="${ctx}/homepage/images/but-2-1.jpg" width="214" height="38" style="">
											</td>
										</tr>
										<tr>
											<td width="210" height="100%" valign="top"
												background="${ctx}/homepage/images/back-but-2.jpg"
												style="padding-left: 28px; padding-top: 4px; padding-bottom: 15px">
												<br>
												<div style="line-height: 15px; padding-bottom: 10px"></div>
												<a href="<s:url action="newsAction"> 
                					</s:url>" class="style3">新闻公告</a>
												<div style="line-height: 15px; padding-bottom: 10px">
												</div>
												
											</td>
										</tr>
									</table>
								</td>
								<td width="555" height="10" valign="top">
									<table width="555" height="100%" border="0" cellspacing="0"
										cellpadding="0" background="homepage/images/back-up-3.jpg">
										<tr>
											<td width="555" height="10"
												background="homepage/images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="555" height="534" border="0" cellspacing="0"
													cellpadding="0" background="homepage/images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: center bottom;">
													<tr>
<br><br><br><br>
														<td width="389" height="18" valign="top" style="padding-left: 5px">
															<img src="homepage/images/text-19.jpg" width="114"
																height="17" style="margin-bottom: 10px">

														</td>
													</tr>
													<tr>
														<td colspan="3"
															style="padding-left: 0px; padding-bottom: 8px"
															valign="top">
															<br>
														<span style="font-size: 16px; font-weight: bold; text-align: center; width: 98%; margin-left: auto; margin-right: auto;">
<center>
														<s:property value="news.title" />
													</center>					
</span>
<br><br><span style="font-size: 12px; text-align: right; width: 98%; margin-left: auto; margin-right: auto;">新闻发布时间：<s:property value="news.time" />
</span>
	<P style="LINE-HEIGHT: 180%">
													<SPAN style="FONT-SIZE: 10.5pt; LINE-HEIGHT: 150%"><FONT
														face=宋体>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property
																value="news.content" />
													</FONT>
													</SPAN>
														</td>
													</tr>


												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<s:include value="homepage/include/bottom.jsp"></s:include>
							<tr>
								<td colspan="2" height="100%">
									<img src="homepage/images/spacer.gif" width="1" height="1">
								</td>
							</tr>
						</table>
					</td>
					<td width="9" height="100%"
						background="homepage/images/back-right.jpg">
						<img src="homepage/images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
		</center>
	</BODY>
</html>