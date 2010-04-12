<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>厦门大学精品课程</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="${ctx}/coursepage/default.css" rel="stylesheet"
			type="text/css" />
<SCRIPT language=javascript>
	function check(form) {
		if (form.userName.value == "") {
			alert("账号不能为空！");
			return false;
		}
		if (form.password.value == "") {
			alert("密码不能为空！");
			return false;
		}
		if (form.flag.value == -1) {
			alert("请选择权限！");
			return false;
		}
		return true;
	}
</SCRIPT>
	</head>
	<body>
		<!--<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="top.jsp"></jsp:include>
		--><div>
			<div>
<s:form action="loginFromEvaluationAction" method="post"
													onsubmit="">
													<table width="60%" height="100%" border="0"
														cellspacing="0" cellpadding="0" align="center" style="margin-top:100px;">
														<tr>
															<td colspan="2" align="center">
																<font style="font-size:18px;font-weight:bold;">用户登录</font>
															</td>
														</tr>
<tr>
															<td height="30" align="center">
																&nbsp;<font style="font-size:16px;font-weight:bold;">账号：</font>
															</td>
															<td>
																<s:textfield name="userName"></s:textfield>
															</td>
														</tr>
														<tr>
															<td height="30" align="center">
																&nbsp;<font style="font-size:16px;font-weight:bold;">密码：</font>
															</td>
															<td>
																<s:password name="password"></s:password>
															</td>
														</tr>
														<tr>
															<td height="30" align="center">
																&nbsp;<font style="font-size:16px;font-weight:bold;">角色：</font>
															</td>
															<td>
																<s:select name="flag" list="# {'0':'专家','1':'老師','2':'學生'}"
																	headerKey="-1" headerValue="请选择" />
															</td>
														</tr>
														<tr>
															<td colspan="2" align="center">
																<input type="submit" name="submit"
																	style="background: url(${ctx}/homepage/images/login_5.gif) no-repeat"
																	value=" 登  陆 ">
																<input type="reset" name="Submit"
																	style="background: url(${ctx}/homepage/images/login_5.gif) no-repeat"
																	value=" 取  消 ">
															</td>
														<tr>
													</table>
												</s:form>
			</div>
		</div>

		<!--<jsp:include page="bottom.jsp"></jsp:include>
	--></body>
</html>