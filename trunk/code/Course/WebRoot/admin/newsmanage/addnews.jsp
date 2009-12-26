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
		<title>发布新闻政策</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.schoolName.value == "")
				{
					alert("学院名不能为空！");
					return false;
				}else{
					return true;
				}
			}
		</SCRIPT>
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
					当前位置: 新闻政策管理 -&gt; 发布新闻政策
				</td>
			</tr>
		</table>
		<s:form action="addNewaAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新学院信息
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							标题：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<s:textfield cssClass="INPUT" id="title" name="news.title" label="标题"></s:textfield>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							发布时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<s:textfield cssClass="INPUT" id="time" name="news.time" label="时间"></s:textfield>
					</td>
				</tr>
				<tr>
					<td colspan="3" bgcolor="#FFFFFF">
						<s:textarea name="news.content" rows="10"></s:textarea>
					</td>
				</tr>
				<tr>
					<td colspan="3" bgcolor="#FFFFFF">
						<s:file></s:file>
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="30%">
						&nbsp;
					</td>
					<td width="70%">
						<s:submit cssClass="label" value="确定添加"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
