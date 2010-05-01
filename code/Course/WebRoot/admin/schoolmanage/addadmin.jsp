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
		<script type="text/javascript" src="/course/dwr/engine.js"></script>
		<script type="text/javascript" src="/course/dwr/util.js"></script>
		<script type="text/javascript" src="/course/dwr/interface/AdminService.js"></script>
		<SCRIPT language=javascript>
	function check(form) {
		if (form.account.value == "") {
			alert("账号不能为空！");
			return false;
		}
		if (form.adminName.value == "") {
			alert("姓名不能为空！");
			return false;
		}
		if (form.adminSchoolId.value == -1) {
			alert("所属学院不能为空！");
			return false;
		}

		return true;
	}

	function checkAdmin(account) {
		if (account == "") {
			DWRUtil.setValue('result', "账号不能为空！");
			return false;
		}
		AdminService.getAdminByAccount(account, callBack);
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
							登陆账号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="account"  size="30"
							name="admin.account" label="登陆账号" onblur="checkAdmin(this.value)"></s:textfield>
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
						<s:textfield  size="30" cssClass="INPUT" id="adminName" name="admin.name"
							label="姓名"></s:textfield>
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
						<s:select name="adminSchoolId" list="allSchoolList" headerKey="-1"
							headerValue="请选择" listKey="id" listValue="name" />
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
