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
				if (form.adminName.value == "")
				{
					alert("姓名不能为空！");
					return false;
				}
				if (form.adminSchoolId.value == -1)
				{
					alert("所属学院不能为空！");
					return false;
				}
				if (form.adminAccount.value == "")
				{
					alert("账号不能为空！");
					return false;
				}
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
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 院系管理 -&gt; 添加学院管理员
				</td>
			</tr>
		</table>
		<s:form action="addAdminAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新管理员信息
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" name="adminName" label="姓名"></s:textfield>
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							所管理学院：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="adminSchoolId" list="allSchoolList" headerKey="-1" headerValue="请选择" listKey="id" listValue="name"/> 
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							登陆账号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" name="adminAccount" label="登陆账号"></s:textfield>
						&nbsp;*
					</td>
				</tr>
<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							登陆密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<font color="#808080">初始密码为&quot;123456&quot;
						</font>&nbsp;
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
