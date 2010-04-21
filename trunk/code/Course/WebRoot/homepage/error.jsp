<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站——搜索课程</title>
		<link rel="stylesheet" href="${ctx}/homepage/link.css">
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
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		width="100%" height="100%"
		background="${ctx}/homepage/image/back_img.gif"
		style="background-repeat: repeat-x">

		<s:include value="include/header.jsp"></s:include>
		<!-- left -->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr height="100%">
				<td width="200" align="center" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr height=100>
							<td>
							</td>
						</tr>
						<tr>
							<td>
								<img src="${ctx}/homepage/image/jiannan.jpg" border="0">
							</td>
						</tr>
					</table>
					<!--/left -->
				</td>
				<td width="750" valign="top" align="right">
					<!-- main -->
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- main2 主题图 -->
							<td valign="top">
								<img src="${ctx}/homepage/image/main_img2.jpg" border="0">
							</td>
							<!--/main2 主题图 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr height="27">
							<!-- 主题 -->
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="11"></td>
										<td>
											<img src="${ctx}/homepage/image/title_prompt.gif" border="0"
												alt="">
										</td>
									</tr>
									<tr height="3">
										<td width="11"></td>
										<td bgcolor="#d7d7d7" width="738"></td>
									</tr>
								</table>
							</td>
							<!--/ 主题 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr>
							<td valign="top" align="center">
								<!-- 内容 -->
								<!-- 登录 -->
								<s:form action="loginFromHomePageAction" method="post"
									onsubmit="return check(this);">
									<table border="0" cellpadding="0" cellspacing="0" width="60%">
										<tr>
											<td colspan="2" align="left">
												<font color="black"><s:actionmessage /> </font>
											</td>
										</tr>
										<tr height="29">
											<td valign="top" width="40">
												<img src="${ctx}/homepage/image/account.gif" border="0"
													alt="">
											</td>
											<td valign="top">
												<s:textfield name="userName" size="20"></s:textfield>
											</td>
										</tr>
										<tr height="30">
											<td width="40">
												<img src="${ctx}/homepage/image/password.gif" border="0"
													alt="">
											</td>
											<td>
												<s:password name="password" size="20"></s:password>
											</td>
										</tr>
										<tr height="30">
											<td width="40">
												<img src="${ctx}/homepage/image/peopedom.gif" border="0"
													alt="">
											</td>
											<td>
												<s:select name="flag" list="# {'0':'老師','1':'學生'}"
													headerKey="-1" headerValue="请选择" />
											</td>
										</tr>
										<tr>
											<td colspan="2" align="left">
												<font color="red"><s:actionerror /> </font>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center">
												<input type="submit" name="submit" value=" 登  陆 ">
												<input type="reset" name="Submit" value=" 取  消 ">
											</td>
										<tr>
									</table>
								</s:form>
								<!--/ 登录 -->



								<!-- /内容 -->
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>


		<!-- 底部 -->
		<s:include value="include/bottom.jsp"></s:include>
	</body>
</html>