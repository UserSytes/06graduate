<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%><html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>留言板-厦门大学网络课程中心</title>
<link rel="stylesheet" href="${ctx}/coursepage/classical/link.css">
</head>
<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" background="${ctx}/coursepage/classical/image/back.gif" >

<!-- 导航 -->
<s:include value="../classical/header.jsp"></s:include>
<!-- /导航 -->

<!-- 正文-->
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center" >
<tr>
	<td width="175">
		<!--左边栏 -->
		<s:include value="../classical/left.jsp"></s:include>
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
						<td width="350"><font style="font-size:12px; color:#574434"><b>欢迎你，<s:property value="userInfo.name"/>&gt;<a href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">个人空间
											</a>&nbsp;<a href="${ctx}/coursepage/messagemanage/searchtopic.jsp">
												搜索
											</a>
											&nbsp;<a href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
												退出
											</a></b></font>
											</td>
							<td width="400" valign="top" align="right"><font style="font-size:12px; color:#574434">首页 &gt;<b>留言板&gt;浏览主题</font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold"></font></td>
								</tr>
								<tr>
									<td>
<a href="<s:url action="goNewTopicAction"></s:url>"><img src="${ctx}/coursepage/classical/image/newtopic.gif" alt="新帖" border="0"/></a>
<a href="<s:url action="goReplyAction">
                     			<s:param name="topicId"> 
                       			 	<s:property value="topic.id"/> 
                    			</s:param>
                					</s:url>">
												<img src="${ctx}/coursepage/classical/image/reply.gif" alt="回复" border="0"/>
											</a>
</td></tr>
								</table></td></tr>
						<tr height="1">
							<td width="750" bgcolor="#c4ae86" valign="top"></td></tr>
						</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
					<td width="750" align="center">
						<!--게시판 -->
<table border="0" cellpadding="0" cellspacing="0" width="760" height="31" background="${ctx}/coursepage/classical/image/pro_titlebg.gif" style="background-repeat:no-repeat">
								<tr><td>主题：[03-31]你们有谁买过螺旋藻~~都是用那个牌子的，价格如何</td></tr>
								</table>
<table frame="below" ellspacing="0" cellpadding="4" width="100%"
									align="center" style="border-bottom:thin solid #9db350;">

<s:iterator value="messageList" status="message">
<tr style="height: 100%">
										<td width="24%" valign="top" style="border-right: thin dotted #60B7DE;" >
											<font style="font-weight:bold; font-size:14px"><s:property value="userInfo.name"/></font>
										   <div>
												个人信息：
											  <br />
													<img src="${ctx}/coursepage/classical/image/icon_1.gif" width="13" height="13">ID：<font color="#ffc0dc"><s:property value="userInfo.id"/></font>
												<br />
													<img src="${ctx}/coursepage/classical/image/icon_10.gif" width="12" height="12">系别：<font color="#800080"><s:property value="userInfo.department.name"/></font>
												<br />
													<img src="${ctx}/coursepage/classical/image/icon_4.gif" width="13" height="13">学院：：<font color="#ff0000"><s:property value="userInfo.department.school.name"/></font>
												<br />
													<img src="${ctx}/coursepage/classical/image/icon_12.gif" width="12" height="12">性别：<font color="#48b00d"><s:property value="userInfo.sex"/></font>
												<br />
													<img src="${ctx}/coursepage/classical/image/icon_9.gif">邮箱：<a href="mailto:<s:property value="userInfo.email"/>?subject=[厦门大学课程网络平台]"><font color="#ffa500"><s:property value="userInfo.email"/></font></a>
											  <br />
													<img src="${ctx}/coursepage/classical/image/icon_6.gif" width="13" height="13">联系方式：<font color="#48e0d0"><s:property value="userInfo.mobile"/></font>
										</div>
									  </td>
										<td width="76%" valign="top" style="padding: 0px"
											height="100%">
											<table border="0" cellspacing="0" cellpadding="4"
												height="100%" width="100%">
												<tr>
													<td>
														<div style="padding-top: 4px; border-bottom:thin inset #9db350;">
															第<s:property value="grade"/>楼&nbsp;&nbsp;&nbsp;发表于<s:date name="time" format="yyyy-MM-dd hh:mm:ss" />&nbsp;
															<a href="" target="_blank">个人资料</a>&nbsp;
														</div>
													</td>
												</tr>
												<tr>
													<td valign="top" height="100%" style="padding-top: 10px;">
														<div>
													<s:text name="">${content}</s:text>		
												</div>
													</td>
												</tr>
												<tr height="20">
													<td align="right">
														&nbsp;
														<a href="">引用</a> &nbsp;
														<a href="###" onclick="">回复</a>
														<a href="###" onclick="scroll(0,0)"><img src="${ctx}/coursepage/classical/image/top.gif"
																border="0" alt="顶部" />
														</a>
													</td>
												</tr>
											</table>
										</td>
									</tr>
</s:iterator>
</table>
						<!--/게시판 -->
					</td></tr>
<tr>
					<td>
						<!-- 페지검색 -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="14"></td>
							<td><a href="#"><img src="${ctx}/coursepage/classical/image/icon3.gif" border="0"></a></td>
							<td width="4"></td>
							<td><s:url id="url_pre" value="showMessagesAction.action">
				<s:param name="pageNow" value="pageNow-1"></s:param>
			</s:url>
			<s:url id="url_next" value="showMessagesAction.action">
				<s:param name="pageNow" value="pageNow+1"></s:param>
			</s:url>
			<s:a href="%{url_pre}">上一页</s:a></td>
							<td><s:iterator value="messageInfoList" status="status">
				<s:url id="url" value="showMessagesAction.action">
					<s:param name="pageNow" value="pageNow" />
				</s:url>
			</s:iterator>
			<s:a href="%{url_next}">下一页</s:a></td>
			<td>&nbsp;当前页<s:property value="pageNow"/></td>
							<td width="4"></td>
							<td><a href="#"><img src="${ctx}/coursepage/classical/image/icon6.gif" border="0"></a></td>
							<td width="30"></td>
							<td><a href="#"><img src="${ctx}/coursepage/classical/image/button1.gif" border="0"></a></td></tr>
						</table>
						<!-- /페지검색 -->
					</td></tr>
<tr>
					<td width="658" align="center">
						<!--검색 -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="750">
								<tr height="40" bgcolor="#f1e1be">
									<td><img src="${ctx}/coursepage/classical/image/s_left.gif" border="0"></td>
									<td width="7"></td>
									<td><img src="${ctx}/coursepage/classical/image/search.gif" border="0"></td>
									<td width="8"></td>
									<td><select name="" style="width:73px;height:21px;background-color:#ffffff;color:#777777"><option>标题</option></select></td>
									<td width="3"></td>
									<td><input type="text" name="" style="width:197px;height:21px;border:solid 1px #c1a568;background-color:#ffffff"></td>
									<td width="5"></td>
									<td><a href="#"><img src="${ctx}/coursepage/classical/image/button3.gif" border="0"></a></td>
									<td width="143"></td>
									<td><a href="#"><img src="${ctx}/coursepage/classical/image/button2.gif" border="0"></a></td>
									<td width="6"></td>
									<td><img src="${ctx}/coursepage/classical/image/s_right.gif" border="0"></td></tr>
							</table>							</td></tr>
						</table>
					<!--/검색 -->					</td></tr>
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
<s:include value="../classical/bottom.jsp"></s:include>
<!--/底部 -->

</body>
</html>
