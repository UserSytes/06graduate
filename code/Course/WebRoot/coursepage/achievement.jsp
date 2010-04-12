<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>教学成果-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/green/color.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="style/header.jsp"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a href="<s:url action="findAchievementAction"> 
                					</s:url>">教学成果</a>&gt;详细浏览
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
								<table border="0" cellpadding="0" cellspacing="0" width="724" height="94" background="${ctx}/coursepage/classical/image/titlebg4.gif" style="background-repeat:no-repeat">
						<tr>
							<td width="724" valign="top" align="right"><font style="font-size:12px; color:#574434"></font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold"><s:property value="course.name" />课程成果展示</font></td>
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
							<s:iterator value="achievementList" status="achievement">
							<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="724" height="31" background="${ctx}/coursepage/classical/image/pro_titlebg.gif" style="background-repeat:no-repeat">
								<tr>
									<td width="10"></td>
									<td><img src="${ctx}/coursepage/classical/image/icon_img.gif" border="0"></td>
									<td align="left" width="100%"><s:property value="title" /></td>
									</tr>
								</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td width="24"></td>
									<td><font style="font-size:14px; color:#74582f"><s:text name="">${content}</s:text>
<br />
附件下载：<a href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="fileLink"/> 
                    			</s:param> 
                					</s:url>"
						onclick="JAVAscript:if(!confirm('确认下载附件？')) return false;return true;">
						<font color="red">点此下载</font> </a></font></td></tr>
								</table>
							</td></tr>								
</s:iterator>
								</table>
							</td></tr>
						</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="style/bottom.jsp"></s:include>
	</body>
</html>
