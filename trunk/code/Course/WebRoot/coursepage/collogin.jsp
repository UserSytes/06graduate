<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	function check(form) {
		if (form.userName.value == "") {
			alert("账号不能为空！");
			return false;
		}
		if (form.password.value == "") {
			alert("密码不能为空！");
			return false;
		}		
		return true;
	}
</script>
		<style type="text/css">
.inputstyle {
	width: 120px;
}
</style>
	</head>
	<body>
		<div style="width: 420px; padding: 15px;" align="center">
			<div
				style="width: 400px; ">
				<table border="0" cellpadding="0" cellspacing="0" align="center"
					style="background-color: #fff;">
					<tr>
						<td>
							<table border="0" cellpadding="0" cellspacing="0" align="center"
								style="background-color: #fff;">
								<tr>
									<td>
										<img src="${ctx}/homepage/image/login_title.gif" border="0"
											alt="">
									</td>
								</tr>
								<tr height="11">
									<td>
										<!-- ??? ??? ?? -->
										<table border="0" cellpadding="0" cellspacing="0" width="100%"
											height="100%">
											<tr>
												<td width="2" bgcolor="#e7e7e7"></td>
												<td width="190"></td>
												<td width="2" bgcolor="#e7e7e7"></td>
											</tr>
										</table>
										<!--/ ??? ??? ?? -->
									</td>
								</tr>
								<tr>
									<td width="194">
										<!-- 登录 -->
										<s:form action="loginFromColAction" method="post"
											onsubmit="return check(this);">
											<table border="0" cellpadding="0" cellspacing="0" width="194">
												<tr height="29">
													<td width="2" bgcolor="#e7e7e7" valign="top"></td>
													<td width="16" valign="top"></td>
													<td valign="top" width="30">
														<img src="${ctx}/homepage/image/account.gif" border="0">
													</td>
													<td width="4" valign="top"></td>
													<td valign="top" width="120">
														<s:textfield name="userName" cssClass="inputstyle"></s:textfield>
													</td>
													<td width="7" valign="top"></td>
													<td width="9" valign="top"></td>
													<td width="2" bgcolor="#e7e7e7" valign="top"></td>
												</tr>
												<tr height="30">
													<td width="2" bgcolor="#e7e7e7"></td>
													<td width="16"></td>
													<td width="30">
														<img src="${ctx}/homepage/image/password.gif" border="0"
															alt="">
													</td>
													<td width="4"></td>
													<td width="120">
														<s:password name="password" cssClass="inputstyle"></s:password>
													</td>
													<td width="7"></td>
													<td width="9"></td>
													<td width="2" bgcolor="#e7e7e7"></td>
												</tr>
																								<tr height="10">
													<td width="2" bgcolor="#e7e7e7"></td>
													<td colspan="6" align="center">
													</td>
													<td width="2" bgcolor="#e7e7e7"></td>
												</tr>
												<tr>
													<td width="2" bgcolor="#e7e7e7"></td>
													<td colspan="6" align="center">
														<font color="red"><s:actionerror /> </font>
													</td>
													<td width="2" bgcolor="#e7e7e7"></td>
												</tr>
												<tr>
													<td width="2" bgcolor="#e7e7e7"></td>
													<td colspan="6" align="center">
														<input type="submit" name="submit" value=" 登  陆 ">
														<input type="reset" name="Submit" value=" 取  消 ">
													</td>
													<td width="2" bgcolor="#e7e7e7"></td>
												<tr>
											</table>
										</s:form>
										<!--/ 登录 -->
									</td>
								</tr>
								<tr height="16">
									<td>
										<!-- ??? ???? ?? -->
										<table border="0" cellpadding="0" cellspacing="0" width="100%"
											height="100%">
											<tr>
												<td width="2" bgcolor="#e7e7e7"></td>
												<td width="190"></td>
												<td width="2" bgcolor="#e7e7e7"></td>
											</tr>
										</table>
										<!--/ ??? ???? ?? -->
									</td>
								</tr>
								<tr>
									<td>
										<!-- ???? ? id/pw?? -->
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td width="2" bgcolor="#e7e7e7"></td>
												<td width="13"></td>

												<td width="2" bgcolor="#e7e7e7"></td>
											</tr>
										</table>
										<!--/ ???? ? id/pw?? -->
									</td>
								</tr>
								<tr>
									<td>
										<img src="${ctx}/homepage/image/login_bottom.gif" border="0"
											alt="">
									</td>
								</tr>
							</table>
						<td>
						<td style="padding-left: 20px;" >
							<div style="height:150px; border-left: 1px solid #DDDDDD;padding-left: 20px;padding-top: 50px;color: #444444;font-size: 14px;font-weight: 400;">
							课程收藏功能目前仅对学生开放，学生用户请直接登录</div>
						</td>
</tr></table>
			</div>
		</div>

	</body>
</html>
