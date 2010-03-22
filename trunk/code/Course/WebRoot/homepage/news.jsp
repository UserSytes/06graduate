<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站——新闻公告</title>
	<link rel="stylesheet" href="${ctx}/homepage/link.css">
<body  topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" width="100%" height="100%" background="${ctx}/homepage/image/back_img.gif" style="background-repeat:repeat-x">

<s:include value="include/header.jsp"></s:include>
<!-- left -->
<table border="0" cellpadding="0" cellspacing="0" width="950"  align="center">
<tr height="100%">
	<td width="200" align="center" valign="top">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td valign="top">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><img src="${ctx}/homepage/image/left_menu_title.gif" border="0" ></td>
				</tr>		
				<tr>
					<td>
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="11" background=""></td>
							<td width="172" align="center"><a href="#"><img src="${ctx}/homepage/image/left_menu_01.gif" border="0"></a></td>
							<td width="11" background=""></td>
						</tr>
						<tr>
							<td width="11" background=""></td>
							<td width="172" align="center"><a href="#"><img src="${ctx}/homepage/image/left_menu_02.gif" border="0" ></a></td>
							<td width="11" background=""></td>
						</tr>
						<tr>
							<td width="11" background=""></td>
							<td width="172" align="center"><a href="#"><img src="${ctx}/homepage/image/left_menu_03.gif" border="0"></a></td>
							<td width="11" background=""></td>
						</tr>		
						</table>
					</td>
				</tr>
				<tr>
					<td><img src="${ctx}/homepage/image/jiannan.jpg" border="0" ></td>
				</tr>		
				</table>
				
			</td>
		</tr>
		</table>
	<!--/left -->
	</td>
	<td width="750" valign="top" align="right">
	<!-- main -->
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
		<!-- main2 主题图 -->
			<td valign="top"><img src="${ctx}/homepage/image/main_img2.jpg" border="0"></td>
		<!--/main2 主题图 -->
		</tr>
		<tr height="11"><td></td></tr>
		<tr height="27">
		<!-- 主题 -->
			<td valign="top">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="11"></td>
					<td><img src="${ctx}/homepage/image/title_new.gif" border="0" alt=""></td>
				</tr>
				<tr  height="3">
					<td width="11"></td>
					<td bgcolor="#d7d7d7" width="738"></td>
				</tr>
				</table>
			</td>
		<!--/ 主题 -->
		</tr>
		<tr height="11"><td></td></tr>
		<tr>
			<td valign="top" align="center">
			<!-- 内容 -->
				<table width="98%" border="0" cellpadding="0" cellspacing="0">				
						<s:iterator value="newsList" status="new">			
												<tr height="25">
													<td width="70%">&nbsp;&nbsp;<img src="${ctx}/homepage/image/but.jpg" border="0" alt="">&nbsp;&nbsp;
													<a href="<s:url action="enterNewsAction"> <s:param name="newsId"> 
	                       			 									<s:property value="id"/> </s:param> </s:url>">
																			<s:property value="title" /></a>
													&nbsp;&nbsp;</td>
													<td width="30%"><s:date name="time" format="yyyy-MM-dd hh:mm:ss" />&nbsp;&nbsp;[<s:property value="count" /> ]</td>
												</tr>
												<tr height="1">
													<td colspan="2" background="${ctx}/homepage/image/main_line.gif"></td>
												</tr>
												</s:iterator>
								</table>
							</td></tr>
						</table>				

			<!-- /内容 -->
			</td>
		</tr>
		</table>
	<!--/ 오른쪽부분 -->
	</td>
</tr>
</table>

<!-- 底部 -->
<s:include value="include/bottom.jsp"></s:include>
</body>
</html>