<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%><html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="courseInfo.title"></s:property>-教学大纲-厦门大学网络课程中心</title>
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
								<table border="0" cellpadding="0" cellspacing="0" width="760" height="94" background="${ctx}/coursepage/classical/image/titlebg.gif" style="background-repeat:no-repeat">
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
							<td width="400" valign="top" align="right"><font style="font-size:12px; color:#574434">首页&gt;<b>留言板&gt;<b>发新主题</b></font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold">发布新主题</font></td>
								</tr>
								<tr>
									<td><font color="#92a35d"style="font-size:12px;"></font></td></tr>
								</table></td></tr>
						<tr height="1">
							<td width="750" bgcolor="#c4ae86" valign="top"></td></tr>
						</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td width="24"></td>
									<td><BR/>
<s:form action="addNewMessageAction" method="post" id="myform" name="myform"
			namespace="/upLoadFile" target="_self" enctype="multipart/form-data" onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=2>
						<font color="#966f48"style="font-size:14px; font-weight:bold">请编辑主题内容</font>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							<font color="#966f48"style="font-size:14px; font-weight:bold">标题：</font>
						</div>
					</td>
					<td>
						<s:textfield cssClass="LONGINPUT" id="title" name="topic.name"
							label="标题"></s:textfield>
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							<font color="#966f48"style="font-size:14px; font-weight:bold">内容：</font>
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<FCK:editor instanceName="message.content" width="100%" height="405"
							toolbarSet="Default">
							<jsp:attribute name="value">
                            </jsp:attribute>
						</FCK:editor>
					</td>
				</tr>
				<tr>
					<td width="15%">
						&nbsp;
					</td>
					<td width="85%">
						<s:submit cssClass="label" value="发新主题"></s:submit>
					</td>
				</tr>
			</table>
		</s:form></td>
										<td width="24"></td>
										</tr>
								</table>
							</td></tr>
						<tr height="35"><td></td></tr>	
						<tr height="45">
							<td width="753" align="right" valign="top"></td></tr>
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
