<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>修改信息-厦门大学精品课程网站</title>
		<link type=text/css rel=stylesheet href="${ctx}/homepage/link.css">
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
											<img src="${ctx}/homepage/image/title_changinfo.gif" border="0">
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
								<s:form action="changeMyInfoAction" method="post"
																	onsubmit="return check(this);">
																	<s:hidden name="student.id" />
																	<s:hidden name="student.userInfo.id" />
																	<s:hidden name="userInfo.id" />
																	<s:hidden name="userInfo.name" />
																	<s:hidden name="userInfo.sex" />
																	<s:hidden name="userInfo.department.id" />
																	<s:hidden name="student.studentNo" />
																	<s:hidden name="student.password" />
																	<s:hidden name="student.grade.id" />
																	<s:hidden name="userInfo.photo"/>
									<table width="95%" border="3" cellpadding="0" cellspacing="0" bordercolor="#e7e7d7">
									
										<tr height="30">
											<td width="100" align="right"><strong> 
												姓名：</strong>
											</td>
											<td >
												&nbsp;&nbsp; <s:property value="student.userInfo.name" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 学号：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property value="student.studentNo" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 性别：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property value="student.userInfo.sex" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 院系：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property
													value="student.userInfo.department.school.name+student.userInfo.department.name" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 年级：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:property value="student.grade.name+student.grade.grade" />
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 电话：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:textfield cssClass="text" id="mobile" size="30"
																					name="userInfo.mobile" label="电话"></s:textfield>
																				&nbsp;*
											</td>
										</tr>
										<tr  height="30">
											<td align="right">
												<strong> 邮箱：</strong>
											</td>
											<td>
												&nbsp;&nbsp;<s:textfield cssClass="text" id="email"  size="30"
																					name="userInfo.email" label="邮箱"></s:textfield>
																				&nbsp;*
											</td>
										</tr>
										<tr  height="30">
											<th colspan="2">
												<div align="right">
													<s:submit value="修改信息" />
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