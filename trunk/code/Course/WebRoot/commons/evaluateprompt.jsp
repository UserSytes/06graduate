<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>信息提示</title>

		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
<s:head/>
	</head>

	<body>

		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>
					信息提示
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF">
					<div align="left">
						<br>
<font size="3"><strong><s:fielderror />
						</strong>
						</font>
						<font size="3"><strong><s:actionmessage />
						</strong>
						</font>
						<font size="3"><strong><s:actionerror />
						</strong>
						</font>
					</div>
				</td>

			</tr>
<tr><td bgcolor="#FFFFFF" align="center"><font size="3"><strong><a href="${ctx}/coursepage/studentevaluate.jsp">返回</a></strong>
						</font></td></tr>
		</table>

	</body>
</html>
