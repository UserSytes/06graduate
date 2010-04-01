<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>

		<table border="0" cellpadding="0" cellspacing="0">
		
		<tr>
			<td><table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="3"><img src="${ctx}/coursepage/classical/image/qimg1.gif" border="0"></td></tr>
		<tr>
			<td width="5" bgcolor="#b59962"></td>
			<td width="82" align="center" valign="top" bgcolor="#ffffff">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><a href="${ctx}/homepage/index.jsp"><img src="${ctx}/coursepage/classical/image/q_menu1.gif" border="0"></a></td><tr>
				<tr>
					<td><a href="<s:url action="evaluateAction"></s:url>"><img src="${ctx}/coursepage/classical/image/q_menu2.gif" border="0"></a></td></tr>
				<tr>
					<td><a href="<s:url action="showTopicsAction"></s:url>"><img src="${ctx}/coursepage/classical/image/q_menu3.gif" border="0"></a></td></tr>
				<tr height="10"><td></td></tr>
				<tr height="40">
					<td background="${ctx}/coursepage/classical/image/q_menu4.gif" width="73" style="background-repeat:no-repeat">
					<table border="0" cellpadding="0" cellspacing="0" width="73"  height="40">
					<tr height="19"><td></td></tr>
					<tr  height="21"><td align="center"><s:property value="count"/></td></tr>
					</table>
					</td></tr>
				</table></td>
			<td width="5" bgcolor="#b59962"></td></tr>
		<tr>
			<td colspan="3"><img src="${ctx}/coursepage/classical/image/qimg2.gif" border="0"></td><tr>
		</table></td>
		</tr>
		<tr>
			<td><img width="175" src="${ctx}/coursepage/classical/image/mainimage.jpg" border="0"></td>
		</tr>
		</table>
	</body>
</html>