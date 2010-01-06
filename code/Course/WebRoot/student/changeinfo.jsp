<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<LINK href="${ctx}/css/student.css" type=text/css rel=stylesheet>
		<title>厦门大学精品课程网站</title>
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
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="${ctx}/homepage/images/back-body.jpg" style="overflow-x: hidden">
		<center>

			<table width="783" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%"
						background="${ctx}/homepage/images/back-left.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>


					<td width="765" height="100%" valign="top"
						background="${ctx}/homepage/images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=765 height="102">
									<s:include value="include/header.jsp"></s:include>
								</td>
							</tr>
							<tr>
								<s:include value="left.jsp"></s:include>

								<td width="555" height="10" valign="top">
									<table width="555" height="100%" border="0" cellspacing="0"
										cellpadding="0"
										background="${ctx}/homepage/images/back-up-3.jpg">
										<tr>
											<td width="555" height="10"
												background="${ctx}/homepage/images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="555" height="100%" border="0" cellspacing="0"
													cellpadding="0"
													background="${ctx}/homepage/images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: center bottom;">

													<tr>
														<br />
														<br />
														<br />
														<br />
														<div style="padding-left: 5px" class="content1-pagetitle">
															当前位置: 我的帐号 -&gt; 修改个人信息
														</div>
													</tr>
													<tr>
														<td width="389" valign="top" style="padding-left: 5px">
															<div class="table">
																<img src="${ctx}/student/img/bg-th-left.gif" width="8"
																	height="7" alt="" class="left" />
																<img src="${ctx}/student/img/bg-th-right.gif" width="7"
																	height="7" alt="" class="right" />
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
																	<table class="listing form" cellpadding="0"
																		cellspacing="0">
																		<tr>
																			<th class="full" colspan="2">
																				个人信息
																			</th>
																		</tr>
																		<tr>
																			<td class="first" width="100">
																				姓名
																			</td>
																			<td class="last">
																				<s:property value="userInfo.name" />
																			</td>
																		</tr>
																		<tr class="bg">
																			<td class="first">
																				学号
																			</td>
																			<td class="last">
																				<s:property value="student.studentNo" />
																			</td>
																		</tr>
																		<tr>
																			<td class="first"">
																				性别
																			</td>
																			<td class="last">
																				<s:property value="userInfo.sex" />
																			</td>
																		</tr>
																		<tr class="bg">
																			<td class="first">
																				院系
																			</td>
																			<td class="last">
																				<s:property
																					value="userInfo.department.school.name+userInfo.department.name" />
																			</td>
																		</tr>
																		<tr>
																			<td class="first"">
																				年级
																			</td>
																			<td class="last">
																				<s:property
																					value="student.grade.name+student.grade.grade" />
																			</td>
																		</tr>
																		<tr class="bg">
																			<td class="first">
																				电话
																			</td>
																			<td class="last">
																				<s:textfield cssClass="text" id="mobile"
																					name="userInfo.mobile" label="电话"></s:textfield>
																				&nbsp;*
																			</td>
																		</tr>
																		<tr>
																			<td class="first"">
																				邮箱
																			</td>
																			<td class="last">
																				<s:textfield cssClass="text" id="email"
																					name="userInfo.email" label="邮箱"></s:textfield>
																				&nbsp;*
																			</td>
																		</tr>
																		<tr>
																			<th class="full" colspan="2">
																				<div align="right">
																					<s:submit value="修改信息" />
																				</div>
																			</th>
																		</tr>
																	</table>
																</s:form>
															</div>
														</td>
													</tr>

												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<s:include value="include/bottom.jsp"></s:include>
							<tr>
								<td colspan="2" height="100%">
									<img src="${ctx}/homepage/images/spacer.gif" width="1"
										height="1">
								</td>
							</tr>
						</table>
					</td>
					<td width="9" height="100%"
						background="${ctx}/homepage/images/back-right.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
	</BODY>
</html>