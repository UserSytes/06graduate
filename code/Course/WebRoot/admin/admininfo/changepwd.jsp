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
		<title>校管理员信息</title>
		<SCRIPT language=javascript>
	function check(form) {
		if (form.oldPassword.value == "") {
			form.oldPassword.focus();
			alert("原密码不能为空！");
			return false;
		}
		if (form.newPassword.value == "") {
			form.newPassword.focus();
			alert("新密码不能为空！");
			return false;
		}
		if (form.newPasswordAgain.value == "") {
			form.newPasswordAgain.focus();
			alert("请再次输入新密码！");
			return false;
		}
		if (form.newPassword.value != form.newPasswordAgain.value) {
			form.newPassword.focus();
			alert("两次输入的新密码不一致，请重新输入！");
			return false;
		}
		form.button.disabled = true;
		return true;
	}
</SCRIPT>
	</head>

	<body>
	<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 个人信息管理 -&gt; 修改密码
				</td>
			</tr>
		</table>
		<s:form action="changeSuperAdminPwdAction" method="post" enctype="multipart/form-data" onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						修改密码：
					</td> 
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							请输入原密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:password cssClass="INPUT" name="oldPassword"
							label="原密码"  size="30"></s:password>
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							请输入新密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:password cssClass="INPUT" name="newPassword"
							label="新密码"  size="30"></s:password>
						&nbsp;*
					</td>
				</tr>
<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							请再次输入新密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:password cssClass="INPUT" name="newPasswordAgain"
							label="新密码2" size="30"></s:password>
						&nbsp;*
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="20%">
						&nbsp;
					</td>
					<td width="80%">
						<s:submit id="button" cssClass="label" value="确定修改"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	</body>
</html>
