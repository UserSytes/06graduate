<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>厦门大学精品课程</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="${ctx}/coursepage/default.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="content">
			<div style="width: 770px">
<s:form action="loginFromMessageBoardAction" method="post"
													onsubmit="">
													<table width="100%" height="100%" border="0"
														cellspacing="0" cellpadding="0">
														<tr>
															<td width="70" height="30" align="left">
																&nbsp;账号：
															</td>
															<td>
																<s:textfield name="userName"></s:textfield>
															</td>
														</tr>
														<tr>
															<td height="30" width="70" align="left">
																&nbsp;密码：
															</td>
															<td>
																<s:password name="password"></s:password>
															</td>
														</tr>
														<tr>
															<td height="30">
																&nbsp;角色：
															</td>
															<td>
																<s:select name="flag" list="# {'0':'老師','1':'學生'}"
																	headerKey="-1" headerValue="请选择" />
															</td>
														</tr>
														<tr bgcolor="#64A5CF">
															<td colspan="2" align="center" bgcolor="#64A5CF">
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

		<jsp:include page="bottom.jsp"></jsp:include>
	</body>
</html>