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
		<title>添加学院管理员</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.gradeName.value == -1)
				{
					form.gradeName.focus();
					alert("学籍类型不能为空！");
					return false;
				}
				if (form.gradeNum.value == "")
				{
					form.gradeNum.focus();
					alert("年级不能为空！");
					return false;
				}
				
				var re2 = /^[0-9]*$/;
				var gradeNum = form.gradeNum.value;
				if (!re2.test(gradeNum)) {
					form.gradeNum.focus();
					alert("年级格式不正确，请输入数字！");
					return false;
				}
				form.button.disabled = true;
				return true;
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
	<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 年级管理 -&gt; 添加年级
				</td>
			</tr>
		</table>
		<s:form action="addGradeAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新年级信息
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							学籍类型：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select id="gradeName" name="grade.name" list="{'本科生','硕士','博士','其他'}" headerKey="-1" headerValue="请选择" />
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							年级：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="gradeNum" cssClass="INPUT" name="grade.grade" label="年级"></s:textfield>&nbsp;级
						&nbsp;*
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="20%">
						&nbsp;
					</td>
					<td width="80%">
						<s:submit id="button" cssClass="label" value="确定添加"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	</body>
</html>
