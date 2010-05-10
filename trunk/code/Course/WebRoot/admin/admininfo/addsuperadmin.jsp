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
		<title>添加校管理员</title>
		<script type="text/javascript" src="/course/dwr/engine.js"></script>
		<script type="text/javascript" src="/course/dwr/util.js"></script>
		<script type="text/javascript" src="/course/dwr/interface/SuperAdminDAO.js"></script>
		<SCRIPT language=javascript>
	function check(form) {
		if (form.account.value == "") {
			form.account.focus();
			alert("账号不能为空！");
			return false;
		}
		if (form.name.value == "") {
			form.name.focus();
			alert("姓名不能为空！");
			return false;
		}
		if (form.mobile.value == "") {
			form.mobile.focus();
			alert("电话不能为空！");
			return false;
		}
		if (form.email.value == "") {
			form.email.focus();
			alert("E-mail不能为空！");
			return false;
		}
		var re2 = /^[0-9]*$/;
		var re = /^([a-zA-Z0-9_-])+@+([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		var email = form.email.value;
		var phone = form.mobile.value;
		if (!re2.test(phone)) {
			form.phone.focus();
			alert("电话号码应全为数字，请输入正确电话号码");
			return false;
		}
		
		if (!re.test(email)) {
			form.email.focus();
			alert("E_mail格式错误，请输入正确邮箱！");
			return false;
		}
		form.button.disabled = true;
		return true;
	}

	function checkAdmin(account) {
		if (account == "") {
			DWRUtil.setValue('result', "账号不能为空！");
			return false;
		}
		SuperAdminDAO.findByAccount(account, callBack);
	}
	function callBack(data) {
		if (data != null){
			DWRUtil.setValue('result', "该管理员帐号已经存在，请更换帐号！");
			document.getElementById("button").disabled = true;
		}
		else{
			DWRUtil.setValue('result', "该管理员帐号可用！");
			document.getElementById("button").disabled = false;
			}
	}
</SCRIPT>
	</head>
	<body>
	<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 管理员管理 -&gt; 添加校管理员
				</td>
			</tr>
		</table>
		<s:form action="addSuperAdminAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新校管理员信息
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
						<s:textfield cssClass="INPUT" id="account"  size="30" name="superAdmin.account" label="登陆账号" onblur="checkAdmin(this.value)"></s:textfield>
						&nbsp;*
						<span style="color: green;" id="result"> </span>
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
						<font color="#808080">初始密码与帐号相同 </font>&nbsp;
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
						<s:textfield  size="30" cssClass="INPUT" id="name" name="superAdmin.name"
							label="姓名"></s:textfield>
						&nbsp;*
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
						<s:textfield  size="30" cssClass="INPUT" id="mobile" name="superAdmin.mobile"
							label="电话"></s:textfield>
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
						<s:textfield  size="30" cssClass="INPUT" id="email" name="superAdmin.email"
							label="email"></s:textfield>
						&nbsp;*
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="30%">
						&nbsp;
					</td>
					<td width="70%">
						<s:submit id="button" cssClass="label" value="确定添加"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
</div>
	</body>
</html>
