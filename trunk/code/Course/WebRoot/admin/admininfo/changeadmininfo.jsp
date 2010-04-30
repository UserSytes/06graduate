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
		<title>学院管理员信息</title>
		<SCRIPT language=javascript>
	function check(form) {
		if (form.mobile.value == "") {
			alert("电话不能为空！");
			return false;
		}
		if (form.email.value == "") {
			alert("E-mail不能为空！");
			return false;
		}
		var re2 = /^[0-9]*$/;
		var re = /^([a-zA-Z0-9_-])+@+([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		var email = form.email.value;
		var phone = form.mobile.value;
		if (!re.test(email)) {
			alert("E_mail格式错误，请输入正确邮箱！");
			return false;
		}
		if (!re2.test(phone)) {
			alert("电话号码应全为数字，请输入正确电话号码");
			return false;
		}
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
					当前位置: 个人信息管理 -&gt; 我的信息 -&gt; 修改联系方式
				</td>
			</tr>
		</table>
		<s:form action="changeAdminInfoAction" method="post" onsubmit="return check(this);">
			<s:hidden name="admin.id" />
			<s:hidden name="admin.name" />
			<s:hidden name="admin.account" />
			<s:hidden name="admin.password" />
			<s:hidden name="admin.school.id" />
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						联系方式：
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							电话：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="mobile" name="admin.mobile"
							label="电话"  size="30"></s:textfield>
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							E-mail：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="email" name="admin.email"
							label="邮箱"  size="30"></s:textfield>
						&nbsp;*
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="20%">
						&nbsp;
					</td>
					<td width="80%">
						<s:submit cssClass="label" value="确定修改"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	</body>
</html>
