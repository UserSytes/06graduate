<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>新闻政策</title>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>

	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 新闻政策管理 -&gt; 新闻政策浏览
				</td>
			</tr>
		</table>
		<s:form action="goEditNewsAction" method="post">
			<s:hidden name="news.id" />
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						<s:text name="">${news.title}</s:text>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							标题：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<s:property value="news.title"></s:property>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							作者：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<s:property value="news.author"></s:property>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							发布时间：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<s:property value="news.time"></s:property>
					</td>
				</tr>
 				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							最后修改时间：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<s:property value="news.lastEditTime"></s:property>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							内容：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<s:text name="">${news.content}</s:text>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							附件：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<s:iterator value="attachmentList" status="attachment">
							<img src="${ctx}/admin/Images/i_attach.gif" />
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
							
						</s:iterator>
						</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="15%">
						&nbsp;
					</td>
					<td width="85%">
						<s:submit cssClass="label" value="修改"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
