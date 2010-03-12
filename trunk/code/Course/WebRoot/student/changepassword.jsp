<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/student.css" type=text/css rel=stylesheet>
	<title>厦门大学精品课程网站</title>
	<SCRIPT language=javascript>
	function check(form) {
		if (form.oldPassword.value == "") {
			alert("原密码不能为空！");
			return false;
		}
		if (form.newPassword.value == "") {
			alert("新密码不能为空！");
			return false;
		}
		if (form.newPasswordAgain.value == "") {
			alert("请再次输入新密码！");
			return false;
		}
		if (form.newPassword.value != form.newPasswordAgain.value) {
			alert("两次输入的新密码不一致，请重新输入！");
			return false;
		}
		return true;
	</SCRIPT>
<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
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
													<br>
													<br>
													<br>
													<br>
													<div style="padding-left: 5px" class="content1-pagetitle">
														当前位置: 我的帐号 -&gt; 修改密码
													</div>
												</tr>
												<tr>
													<td width="389" valign="top" style="padding-left: 5px">
														<div class="table">
															<img src="${ctx}/student/img/bg-th-left.gif" width="8" height="7" alt=""
																class="left" />
															<img src="${ctx}/student/img/bg-th-right.gif" width="7" height="7"
																alt="" class="right" />
															<s:form action="changeStudentPwdAction" method="post"
																onsubmit="return check(this);">
																<table class="listing form" cellpadding="0"
																	cellspacing="0">
																	<tr>
																		<th class="full" colspan="2">
																			修改密码
																		</th>
																	</tr>
																	<tr>
																		<td class="first" width="100">
																			请输入原密码：
																		</td>
																		<td class="last">
																			<s:password cssClass="password" id="oldPassword" name="oldPassword"
																				label="原密码"></s:password>
																			&nbsp;*
																		</td>
																	</tr>
																	<tr class="bg">
																		<td class="first">
																			请输入新密码：
																		</td>
																		<td class="last">
																			<s:password cssClass="password" id="newPassword" name="newPassword"
																				label="新密码"></s:password>
																			&nbsp;*
																		</td>
																	</tr>
																	<tr>
																		<td class="first"">
																			请再次输入新密码：
																		</td>
																		<td class="last">
																			<s:password cssClass="password" id="newPasswordAgain" name="newPasswordAgain"
																				label="新密码2"></s:password>
																			&nbsp;*
																		</td>
																	</tr>
																	<tr>
																		<th class="full" colspan="2">
																			<div align="right">
																				<s:submit  value="确定修改" />
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