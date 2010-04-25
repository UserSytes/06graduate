<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>发布主题-师生留言-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<style type="text/css">
.txt,.txtarea {
	padding: 2px; *
	padding: 0 2px;
	height: 16px; *
	height: 20px;
	border: 1px solid;
	border-color: #999 #CCC #CCC #999;
	background: #FFF;
	width: 500px;
}
</style>
	</head>

	<body>
		<!-- 头部 -->
		<s:include value="../style/%{#session.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="showTopicsAction"> 
                					</s:url>">师生留言</a>&gt;
						<a href="<s:url action="goNewTopicAction"></s:url>">发布主题</a>
					</h2>
				</div>


				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table-info">
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="704">
									<tr>
										<td class="table-title">
											<font style="font-size: 14px; font-weight: bold">&nbsp;发布新主题</font>
										</td>
										<td width="324" align="right" class="titlea"
											style="line-height: 25px; font-family: Verdana, Helvetica, Arial, sans-serif; font-size: 12px; margin-right: 20px;">
											&nbsp;&nbsp;&nbsp;欢迎你,
											<s:property value="userInfo.name" />
											&nbsp;
											<span style="color: #CBCBCB">|</span><a class="titlea"
												href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">&nbsp;个人空间&nbsp;
											</a><span style="color: #CBCBCB">|</span><a class="titlea"
												href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
												&nbsp;退出 </a>
										</td>
										<td width="20"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr height="1" class="tr-title">
							<td></td>
						</tr>
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
										<td>
											<s:form action="addNewMessageAction" method="post"
												id="myform" name="myform" namespace="/upLoadFile"
												target="_self" enctype="multipart/form-data"
												onsubmit="return check(this);">
												<table cellpadding="0" cellspacing="0" width="100%"
													align=center>
													<tr class="tr-content">
														<td style="padding: 5px 10px 5px 0;">
															&nbsp;&nbsp;标题：<s:textfield cssClass="txt" id="title"
																name="topic.name"></s:textfield>															
														</td>
													</tr>
													<tr class="tr-content">
														<td>
															<FCK:editor instanceName="message.content" width="100%"
																height="405" toolbarSet="Default">
																<jsp:attribute name="value">
                            </jsp:attribute>
															</FCK:editor>
														</td>
													</tr>
													<tr class="tr-content">
														<td>
															<s:submit cssClass="label" value="发新主题"></s:submit>
														</td>
													</tr>
												</table>
											</s:form>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="../style/bottom.jsp"></s:include>
	</body>
</html>
