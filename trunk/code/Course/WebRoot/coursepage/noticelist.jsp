<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%><html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="notice.title"></s:property>-新闻公告-厦门大学网络课程中心</title>
<link rel="stylesheet" href="${ctx}/coursepage/classical/link.css">
</head>
<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" background="${ctx}/coursepage/classical/image/back.gif" >

<!-- 导航 -->
<s:include value="classical/header.jsp"></s:include>
<!-- /导航 -->

<!-- 正文-->
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center" >
<tr>
	<td width="175">
		<!--左边栏 -->
		<s:include value="classical/left.jsp"></s:include>
		<!-- /左边栏 --></td>
	<td width="775"  valign="top" align="center">
		<table border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td>
				<!-- 中间主体内容 -->
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="3"><img width="775" src="${ctx}/coursepage/classical/image/topline2.gif" border="0"></td></tr>
				<tr>
					<td width="1" bgcolor="#b29f79"></td>
					<td bgcolor="#fdfbf3">
						<table border="0" cellpadding="0" cellspacing="0" width="773" >
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="bottom">&nbsp;</td>
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
								<table border="0" cellpadding="0" cellspacing="0" width="760" height="94" background="${ctx}/coursepage/classical/image/titlebg2.gif" style="background-repeat:no-repeat">
						<tr>
							<td width="750" valign="top" align="right"><font style="font-size:12px; color:#574434">首页 ><b>新闻公告 ><b>详细浏览</b></font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold"><s:property value="notice.title"/></font></td>
								</tr>
								<tr>
									<td><font color="#92a35d"style="font-size:12px;">发布时间：<s:date name="notice.time" format="yyyy-MM-dd" /></font></td></tr>
								</table></td></tr>
						<tr height="1">
							<td width="750" bgcolor="#c4ae86" valign="top"></td></tr>
						</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
					<td width="750" align="center">
						<!--게시판 -->
						<table border="0" cellpadding="0" cellspacing="0" width="740">
						<tr height="3" bgcolor="#d3b981"><td colspan="14"></td></tr>
						<tr bgcolor="#f1e1be">
							<td width="48" height="40" align="center"><font style="font-size:14px;font-weight:bold;">序号</font></td>
							<td>&nbsp;</td>
							<td width="249" height="40" align="center" colspan="2"><font style="font-size:14px;font-weight:bold;">标题</font></td>
							<td>&nbsp;</td>
							<td width="70" height="40" align="center"><font style="font-size:14px;font-weight:bold;">作者</font></td>
							<td>&nbsp;</td>
							<td width="83" height="40" align="center"><font style="font-size:14px;font-weight:bold;">发布时间</font></td>
							<td>&nbsp;</td>
							<td width="48" height="40" align="center"><font style="font-size:14px;font-weight:bold;">点击量</font></td>
						</tr>
<s:iterator value="noticeList" status="notice">
						<tr height="33" bgcolor="#fdfbf3" <s:if test="#notice.even">style="background-color:#faefda"</s:if>>
							<td align="center"><font color="#74582f"><s:property value="#notice.count" /></font></td>
							<td></td>
							<td width="10"></td>
							<td width="239"><font color="#74582f"><a href="<s:url action="viewNoticeAction"> 
											                     			<s:param name="noticeId"> 
											                       			 	<s:property value="id"/> 
											                    			</s:param>
											                					</s:url>"><s:property value="title"/></a></font></td> 
							<td></td>
							<td width="70" align="center"><font color="#74582f"><s:property value="author"/> </font></td>
							<td></td>
							<td width="83" align="center"><font color="#74582f"><s:date name="time" format="yyyy-MM-dd hh:mm:ss" /></font></td>
							<td></td>
							<td width="48" align="center"><font color="#74582f">12</font></td></tr>
</s:iterator>					
						<tr height="4"><td></td></tr>
						<tr height="1" bgcolor="#d3b981"><td colspan="14"></td></tr>
						<tr height="3" bgcolor="#eedcb3"><td colspan="14" width="630"></td></tr>
						</table>
						<!--/게시판 -->
					</td></tr>
<tr>
					<td>
						<!-- 페지검색 -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="197"></td>
							<td><a href="#"><img src="${ctx}/coursepage/classical/image/icon3.gif" border="0"></a></td>
							<td width="4"></td>
							<td><a href="#"><img src="${ctx}/coursepage/classical/image/icon4.gif" border="0"></a></td>
							<td width="14"></td>
							<td><font color="#666666">1</font></td>
							<td width="12"></td>
							<td><font color="#666666">2</font></td>
							<td width="10"></td>
							<td><font color="#ff780b"><b>3</b></font></td>
							<td width="10"></td>
							<td><font color="#666666">4</font></td>
							<td width="10"></td>
							<td><font color="#666666">5</font></td>
							<td width="10"></td>
							<td><font color="#666666">6</font></td>
							<td width="10"></td>
							<td><font color="#666666">7</font></td>
							<td width="10"></td>
							<td><font color="#666666">8</font></td>
							<td width="10"></td>
							<td><font color="#666666">9</font></td>
							<td width="10"></td>
							<td><font color="#666666">10</font></td>
							<td width="14"></td>
							<td><a href="#"><img src="${ctx}/coursepage/classical/image/icon5.gif" border="0"></a></td>
							<td width="4"></td>
							<td><a href="#"><img src="${ctx}/coursepage/classical/image/icon6.gif" border="0"></a></td>
							<td width="101"></td>
							<td><a href="#"><img src="${ctx}/coursepage/classical/image/button1.gif" border="0"></a></td></tr>
						</table>
						<!-- /페지검색 -->
					</td></tr>
<tr>
					<td width="750" align="center">
						<!--검색 -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="740">
								<tr height="40" bgcolor="#f1e1be">
									<td><img src="${ctx}/coursepage/classical/image/s_left.gif" border="0"></td>
									<td width="7"></td>
									<td><img src="${ctx}/coursepage/classical/image/search.gif" border="0"></td>
									<td width="8"></td>
									<td><select name="select" style="width:73px;height:21px;background-color:#ffffff;color:#777777">
									  <option>标题</option>
									  <option>作者</option>
									  </select>									</td>
									<td width="3"></td>
									<td><input type="text" name="" style="width:197px;height:21px;border:solid 1px #c1a568;background-color:#ffffff"></td>
									<td width="5"></td>
									<td><a href="#"><img src="${ctx}/coursepage/classical/image/button3.gif" border="0"></a></td>
									<td width="143"></td>
									<td><a href="#"><img src="${ctx}/coursepage/classical/image/button2.gif" border="0"></a></td>
									<td width="6"></td>
									<td><img src="${ctx}/coursepage/classical/image/s_right.gif" border="0"></td></tr>
								</table>
							</td></tr>
						</table>
						<!--/검색 -->
					</td></tr>
						<tr height="35"><td></td></tr>	
						<tr height="45">
							<td width="753" align="right" valign="top"><a href="#"><img src="${ctx}/coursepage/classical/image/button.gif" border="0"></a></td></tr>
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
					<td colspan="3"><img width="775"  src="${ctx}/coursepage/classical/image/bottomline2.gif" border="0"></td></tr>
				<tr height="10">
					<td colspan="3"></td></tr>
				</table>
			</td></tr>
		</table></td>
	<td width="13"></td>
</tr>
</table>
<!-- /내용부분-->

<!--底部 -->
<s:include value="classical/bottom.jsp"></s:include>
<!--/底部 -->

</body>
</html>
