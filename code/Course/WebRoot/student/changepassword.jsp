<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<title>修改密码-厦门大学精品课程网站</title>
		<link type=text/css rel=stylesheet href="${ctx}/homepage/link.css">
	<SCRIPT language=javascript>
	function check(form) {
		if (form.oldPassword.value == "") {
			alert("原密码不能为空！");
			form.oldPassword.focus();
			return false;
		}
		if (form.newPassword.value == "") {
			alert("新密码不能为空！");
			form.newPassword.focus();
			return false;
		}
		if (form.newPasswordAgain.value == "") {
			alert("请再次输入新密码！");
			form.newPasswordAgain.focus();
			return false;
		}
		if (form.newPassword.value != form.newPasswordAgain.value) {
			alert("两次输入的新密码不一致，请重新输入！");
			form.newPassword.focus();
			return false;
		}
		form.button.disabled = true;
		return true;
	}
	</SCRIPT>
</head>
<body topmargin="0" leftmargin="0"
		marginheight="0" marginwidth="0"
		background="${ctx}/homepage/image/back_img.gif"
		style="background-repeat: repeat-x">

		<s:include value="../homepage/include/header.jsp"></s:include>
		<!-- left -->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr height="100%">
				<td width="200" align="center" valign="top">
					<s:include value="left.jsp"></s:include>
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
											<img src="${ctx}/homepage/image/title_changepwd.gif" border="0"
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
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="90%" align="left">
											<s:actionerror />
										</td>
									</tr>
								</table>
								<s:form action="changeStudentPwdAction" method="post" onsubmit="return check(this);">
									<table width="95%" border="0" cellpadding="0" cellspacing="0">
										<tr height="30">
											<td align="right" width="30%">
												<strong> 请输入原密码：</strong>
											</td>
											<td >
												&nbsp;&nbsp;<s:password cssClass="password" id="oldPassword" name="oldPassword"
																				 size="30" label="原密码"></s:password>
																			&nbsp;*
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 请输入新密码：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:password cssClass="password" id="newPassword" name="newPassword"
																				 size="30" label="新密码"></s:password>
																			&nbsp;*
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 请确认新密码：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:password cssClass="password" id="newPasswordAgain" name="newPasswordAgain"
																				 size="30" label="新密码2"></s:password>
																			&nbsp;*
											</td>
										</tr>	
										<tr height="10">
											<th colspan="2"></th>
									    </tr>
										<tr height="2">
											<th colspan="2" bgcolor="#d7d7d7"></th>
									    </tr>								
										<tr  height="30">
											<th colspan="2">
												<div align="right">
													<s:submit id="button" value="确定修改" />
												</div>
											</th>
										</tr>
									</table>
								</s:form>

							</td>
						</tr>
					</table>

					<!-- /内容 -->
				</td>
			</tr>
		</table>


		<!-- 底部 -->
		<s:include value="../homepage/include/bottom.jsp"></s:include>
	</body>
</html>