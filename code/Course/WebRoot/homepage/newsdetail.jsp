<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站-新闻查看</title>
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
					<td><img src="${ctx}/homepage/image/left_menu_title6.gif" border="0" ></td>
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
					<td><img src="${ctx}/homepage/image/title_new.gif" border="0" ></td>
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
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
						<tr height="40"><td colspan="2" align="center"><FONT color="black" style="font-weight:bolder;size: 24pt"><s:property value="news.title" /></FONT>	</td></tr>			
						<tr height="1"><td bgcolor="#d7d7d7" colspan="2" width="650"></td></tr>
						<tr height="30"><td align="left">此信息发布于：<s:date name="news.time" format="yyyy-MM-dd hh:mm:ss" /></td>
							<td align="right">浏览次数：<s:property value="news.count" /></td></tr>	
						<tr height="1" ><td bgcolor="#d7d7d7" colspan="2" width="650"></td></tr>
						<tr><td colspan="2">
						<table width="95%" border="0" cellpadding="0" cellspacing="0">
						<TR><TD><strong><s:property value="ifAttachment"/></strong></TD></TR>
						<s:iterator value="attachmentList" status="attachment">		
							<TR><TD><img src="${ctx}/admin/Images/i_attach.gif" />
							<a
								href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="fileLink"/> 
                    			</s:param> 
								<s:param name="originalFileName"> 
                       			 	<s:property value="filename"/> 
                    			</s:param> 
                					</s:url>">
								<font color="blue"><s:property value="filename" /> </font> </a>
							</TD></TR>
						</s:iterator>
						<TR height="20"><TD></TD></TR>
						</table>
						</td></tr>
						<tr>
							<td colspan="2">
								<s:text name="">${news.content}</s:text>
							</td>
						</tr>
						<tr height="20"><td colspan="2"></td></tr>
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