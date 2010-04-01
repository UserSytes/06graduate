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
								<table border="0" cellpadding="0" cellspacing="0" width="760" height="94" background="${ctx}/coursepage/classical/image/titlebg4.gif" style="background-repeat:no-repeat">
						<tr>
							<td width="750" valign="top" align="right"><font style="font-size:12px; color:#574434">首页 ><b>课程教案列表</font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold"></font></td>
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
					<td width="750" align="center">
						<!--게시판 -->
						<table border="0" cellpadding="0" cellspacing="0" width="740">
						<tr height="3" bgcolor="#d3b981"><td colspan="14"></td></tr>
						<tr bgcolor="#f1e1be">
							<td width="48" height="40" align="center"><font style="font-size:14px;font-weight:bold;">序号</font></td>
							<td>&nbsp;</td>
							<td width="150" height="40" align="center"><font style="font-size:14px;font-weight:bold;">书名</font></td>
							<td>&nbsp;</td>
							<td width="70" height="40" align="center"><font style="font-size:14px;font-weight:bold;">作者</font></td>
							<td>&nbsp;</td>
							<td width="100" height="40" align="center"><font style="font-size:14px;font-weight:bold;">出版社</font></td>
							<td>&nbsp;</td>
							<td width="62" height="40" align="center"><font style="font-size:14px;font-weight:bold;">出版时间</font></td>
							<td>&nbsp;</td>
							<td width="68" height="40" align="center"><font style="font-size:14px;font-weight:bold;">链接</font></td>
						</tr>
<s:iterator value="bookList" status="book">
						<tr height="33" bgcolor="#fdfbf3"  <s:if test="#book.even">style="background-color:#faefda"</s:if>>
							<td align="center"><font color="#74582f"><s:property value="#book.count" /></font></td>
							<td></td>
							
							<td width="150" align="center"><font color="#74582f"><s:property value="name" /></font></td> 
							<td></td>
							<td width="70" align="center"><DIV align="center"><s:property value="author" /></DIV></td>
							<td></td>
							<td width="100" align="center"><font color="#74582f"><s:property value="publication" /></font></td>
							<td></td>
							<td width="62" align="center"><font color="#74582f"><s:date name="time" format="yyyy-MM-dd" /></font></td>
							<td></td>
							<td width="68" align="center"><font color="#74582f"><a
																			href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="fileLink"/> 
                    			</s:param>  
<s:param name="originalFileName"> 
                       			 	<s:property value="filename"/> 
                    			</s:param> 
                					</s:url>"
																			onclick="JAVAscript:if(!confirm('确认下载附件？')) return false;return true;">
																			<font color="red">点此下载</font> </a></font></td></tr>
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
						
						<!-- /페지검색 -->
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
