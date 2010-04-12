<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>回复主题-<s:property value="topic.name" />-师生留言-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/green/color.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="../style/header.jsp"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a href="<s:url action="showTopicsAction"> 
                					</s:url>">师生留言</a>&gt;<a href="<s:url action="goReplyAction">
                     			<s:param name="topicId"> 
                       			 	<s:property value="topic.id"/> 
                    			</s:param>
                					</s:url>">
												发表回复
											</a>
					</h2>
					<br class="clear" />
				</div>

<ul id="products-list">
			</ul>
		<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="724" align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="724" height="94" background="${ctx}/coursepage/classical/image/titlebg.gif" style="background-repeat:no-repeat">
						<tr>
<td width="324"><font style="font-size:12px; color:#574434"><b>欢迎你，<s:property value="userInfo.name"/>&gt;<a href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">个人空间
											</a>&nbsp;<a href="${ctx}/coursepage/messagemanage/searchtopic.jsp">
												搜索
											</a>
											&nbsp;<a href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
												退出
											</a></b></font>
											</td>
							<td width="400" valign="top" align="right"><font style="font-size:12px; color:#574434"></font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold">发表回复</font></td>
								</tr>
								<tr>
									<td><font color="#92a35d"style="font-size:12px;"></font></td></tr>
								</table></td></tr>
						<tr height="1">
							<td width="724" bgcolor="#c4ae86" valign="top"></td></tr>
						</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td width="24"></td>
									<td><BR/>
<s:form action="addReplyAction" method="post" id="myform" name="myform"
			namespace="/upLoadFile" target="_self" enctype="multipart/form-data" onsubmit="return checkAll();">
			<s:hidden name="topic.id" ></s:hidden>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请编辑回复内容
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							内容：
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
				<tr bgcolor="#ECF3FD">
					<td width="15%">
						&nbsp;
					</td>
					<td width="85%">
						<s:submit cssClass="label" value="发表回复"></s:submit>
					</td>
				</tr>
			</table>
		</s:form></td>
										<td width="24"></td>
										</tr>
								</table>
							</td></tr>
						</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="../style/bottom.jsp"></s:include>
	</body>
</html>
