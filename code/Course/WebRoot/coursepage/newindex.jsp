<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程首页</title>
<link rel="stylesheet" href="${ctx}/coursepage/classical/link.css">
</head>
<style type="text/css">
<!--
.STYLE1 {color: #9E834A}
.STYLE2 {color: #7B6435}
-->
</style>
<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" background="${ctx}/coursepage/classical/image/back.gif" width="100%">

<!-- 导航 -->
<s:include value="classical/header.jsp"></s:include>
<!-- /导航 -->

<!-- 正文-->
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center" >
<tr>
	<td width="175">
		<!--左边栏 -->
		<s:include value="classical/left.jsp"></s:include>
		<!-- /左边栏 -->
		</td>
		
	<td width="775"  valign="top" align="center">
		<table border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td>
				<!-- 中间主体内容 -->
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="3"><img width="775" src="${ctx}/coursepage/classical/image/topline.gif" border="0"></td></tr>
				<tr>
					<td width="1" bgcolor="#cec1a6"></td>
					<td >
						<table border="0" cellpadding="0" cellspacing="0" width="773" background="${ctx}/coursepage/classical/image/contentsbg.gif" style="background-repeat:repeat-y">
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="bottom">&nbsp;</td>
									<td>
										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<!-- 公告 -->
												<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td><img src="${ctx}/coursepage/classical/image/notice.gif" border="0"></td>
													<td>
														<table border="0" cellpadding="0" cellspacing="0">
														<tr height="20">
															<td width="7"></td>
															<td><img src="${ctx}/coursepage/classical/image/left_bg1.gif" border="0"></td>
															<td width="9"></td>
															<td width="200"><font style="font-size:12px; color:#5a5547">公告...</font></td>
															<td width="7"></td>
															<td width="5"></td></tr>
														<tr>
															<td colspan="6">
																<table border="0" cellpadding="0" cellspacing="0">
																<tr>
																	<td width="7"></td>
																	<td><img src="${ctx}/coursepage/classical/image/main_line.gif" border="0"></td></tr>
																</table></td></tr>
														<tr height="20">
															<td width="7"></td>
															<td><img src="${ctx}/coursepage/classical/image/left_bg1.gif" border="0"></td>
															<td width="9"></td>
															<td width="200"><font style="font-size:12px; color:#5a5547">公告...</font></td>
															<td width="7"></td>
															<td width="5"></td></tr>
														<tr>
															<td colspan="6">
																<table border="0" cellpadding="0" cellspacing="0">
																<tr>
																	<td width="7"></td>
																	<td><img src="${ctx}/coursepage/classical/image/main_line.gif" border="0"></td></tr>
																</table></td></tr>
														
													</table>													</td></tr>
												</table></td>
												<!--/ 공지사항 -->
											<td width="20"></td>
											<td>
												<!-- 新闻 -->
												<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													
													<td><img src="${ctx}/coursepage/classical/image/news.gif" border="0"></td>
													<td>
														<table border="0" cellpadding="0" cellspacing="0">
														<s:iterator value="noticeList" status="notice">
														<tr height="20">
															<td width="7"></td>
															<td><img src="${ctx}/coursepage/classical/image/left_bg1.gif" border="0"></td>
															<td width="9"></td>
															<td width="200"><font style="font-size:12px; color:#5a5547"><a href="<s:url action="viewNoticeAction"> 
										<s:param name="noticeId"> 
								<s:property value="id"/> 
								</s:param>
								</s:url>"><s:property
										value="title" />
								</a><s:date name="time" format="yyyy-MM-dd hh:mm:ss" /></font></td>
															<td width="7"></td>
															<td width="5"></td></tr>
														<tr>
															<td colspan="6">
																<table border="0" cellpadding="0" cellspacing="0">
																<tr>
																	<td width="7"></td>
																	<td><img src="${ctx}/coursepage/classical/image/main_line.gif" border="0"></td></tr>
																</table></td></tr>
														</s:iterator>
														</table></td>
													<td width="2"></td></tr>
												</table>
												<!--/  상담실  -->
											</td></tr>
										<tr height="20"><td></td></tr>
										<tr>
											<td colspan="3">
												<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td>
														<!-- 课程简介 -->
														<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="773" align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="760" height="31" background="${ctx}/coursepage/classical/image/pro_titlebg.gif" style="background-repeat:no-repeat">
								<tr>
									<td width="10"></td>
									<td><img src="${ctx}/coursepage/classical/image/icon_img.gif" border="0"></td>
									<td><img src="${ctx}/coursepage/classical/image/cmenu01.gif" border="0"></td>
									<td width="100%"></td></tr>
								</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td width="24"></td>
									<td><div style="height:300px;overflow:hidden;">
<font style="font-size:12px; color:#74582f"><s:text name="courseintrotext">${courseInfo.content}</s:text>
</font></div></td>
										<td width="24"></td>
										</tr>
								</table>
							</td></tr>
						<tr height="35"><td></td></tr>	
						<tr height="45">
							<td width="753" align="right" valign="top"><a href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>"><img src="${ctx}/coursepage/classical/image/button.gif" border="0"></a></td></tr>
						</table>
														<!-- /주요클리닉 -->
													</td></tr>
												</table>
											</td></tr>
										<tr height="12"><td></td></tr>
										</table>
									</td></tr>
								</table>
							</td></tr>
						</table></td>
					<td width="1" bgcolor="#cec1a6"></td></tr>
				<tr>
					<td colspan="3"><img width="775"  src="${ctx}/coursepage/classical/image/bottomline.gif" border="0"></td></tr>
				<tr height="10">
					<td colspan="3"></td></tr>
				</table>
			</td></tr>
		</table></td>
	<td width="13"></td>
</tr>
</table>
<!-- /zhengwen-->

<!--底部 -->
<s:include value="classical/bottom.jsp"></s:include>
<!--/底部 -->
</body>
</html>
