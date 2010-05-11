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
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>邀请同行</title>
		<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
		<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
		<script type="text/javascript"
			src="${ctx}/dwr/interface/EvaluateService.js"></script>
		<SCRIPT language=javascript>
	function check(form) {
		if (form.evaname.value == "") {
			alert("名字不能为空！");
			form.evaname.focus();
			return false;
		}
		if (form.evapassword.value == "") {
			alert("密码不能为空！");
			form.evapassword.focus();
			return false;
		}
		if (form.confirmPwd.value == "") {
			alert("确认密码不能为空！");
			form.confirmPwd.focus();
			return false;
		}
		if (form.evapassword.value != form.confirmPwd.value) {
			alert("两次输入的密码不一致，请重新输入！");
			return false;
		}
		form.submit.disabled = true;
	}
	function getEvaluationName(username) {
		if (username == "") {
			DWRUtil.setValue('result', "账号不能为空！");
			return false;
		}
		EvaluateService.getEvaluationByUsername(username, callBack);
	}
	function callBack(data) {
		if (data == null) {
			DWRUtil.setValue('result', "该帐号可用");
		} else {
			DWRUtil.setValue('result', "该帐户已经存在");
			document.getElementById("evaname").value = "";
		}
	}
</SCRIPT>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position>
				<td>
					当前位置: 我的课程 -&gt; 邀请同行评价
				</td>
			</tr>
		</table>
		<s:form action="addEvaTeacherAction" method="post"
			enctype="multipart/form-data" onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						邀请同行：
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							用户名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="evaname" name="evaluation.username"
							cssClass="input" onblur="getEvaluationName(this.value)" />
						<span id="result"> </span>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:password id="evapassword" name="evaluation.password"
							cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							确认密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:password id="confirmPwd" cssClass="input" />
					</td>
				</tr>
				<tr class=editHeaderTr>
					<td width="30%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="70%">
						<s:submit id="submit" cssClass="label" value="确认" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>