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
		<LINK href="../Images/css1/admin.css" type=text/css rel=stylesheet>
		<title>添加学院</title>
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
					当前位置: 院系管理 -&gt; 添加学院
				</td>
			</tr>
		</table>
		<s:form action="addSchoolAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新学院信息
					</td>
				</tr>
		    <s:textfield cssClass="INPUT" name="schoolName" label="学院名称"></s:textfield>
			<s:submit cssClass="editRightTd" value="确定添加"></s:submit>
			</table>
		</s:form>
	</body>
</html>
