<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户登录-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/<s:property value="course.style"/>/color.css" rel="stylesheet"
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
		<!-- 头部 -->
		<s:include value="../style/%{course.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						用户登录
					</h2>
					<br class="clear" />
				</div>

<ul id="products-list">
			</ul>
		<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="724" align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="724" height="94" background="${ctx}/coursepage/classical/image/titlebg.gif" style="background-repeat:no-repeat">
						<tr>
							<td width="724" valign="top" align="right"><font style="font-size:12px; color:#574434"></font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold">用户登录</font></td>
								</tr>
								<tr>
									<td><font color="#92a35d"style="font-size:12px;"</font></td></tr>
								</table></td></tr>
						<tr height="1">
							<td width="724" bgcolor="#c4ae86" valign="top"></td></tr>
						</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr align="center">
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td width="24"></td>
									<td><font style="font-size:12px; color:#74582f"><BR/>
<s:form action="loginFromEvaluationAction" method="post"
													onsubmit="return check(this);">
													<table width="60%" height="100%" border="0"
														cellspacing="0" cellpadding="0" align="center">
														<tr>
															<td height="30" align="center">
																&nbsp;账号：
															</td>
															<td>
																<s:textfield name="userName"></s:textfield>
															</td>
														</tr>
														<tr>
															<td height="30" align="center">
																&nbsp;密码：
															</td>
															<td>
																<s:password name="password"></s:password>
															</td>
														</tr>
														<tr>
															<td height="30" align="center">
																&nbsp;角色：
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
</font></td>
										<td width="24"></td>
										</tr>
								</table>
							</td></tr>
						</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="../style/bottom.jsp"></s:include>
	</body>
</html>
