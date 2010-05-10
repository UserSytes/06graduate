<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox.js"></script>
		<script>jQuery.noConflict();</script>
		<title>修改密码</title>
		<SCRIPT language=javascript>
	function check(form) {		
		if (form.name.value == "") {
			alert("名字不能为空！");
			form.name.focus();
			return false;
		}
		if (form.position.value == "") {
			alert("职称不能为空！");
			form.position.focus();
			return false;
		}	
		if (form.email.value == "") {
			alert("E-mail不能为空！");
			form.email.focus();
			return false;
		}	
		if (form.mobile.value == "") {
			alert("电话不能为空！");
			form.mobile.focus();
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
		form.submit.disabled = true;	
		return true;
	}
</SCRIPT>
		<style type="text/css">
form {
	margin: 0;
	color: #5E5E5D;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif", arial;
	FONT-SIZE: 9pt;;
	letter-spacing: -0.02em;
	text-decoration: none;
	line-height: 12pt;
}

BODY {
	COLOR: #000;
	BACKGROUND-COLOR: #fff
}

BODY {
	FONT-SIZE: 9px;
	LINE-HEIGHT: 150%;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"
}

label {
	FONT-SIZE: 18px;
	LINE-HEIGHT: 150%;
	BACKGROUND-COLOR: #FFFDF0;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"
}

INPUT {
	FONT-SIZE: 12px;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"
}

TABLE.editTable {
	FONT-SIZE: 12px;
	LINE-HEIGHT: 150%;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"; border :
	1px solid #666;
	WIDTH: 98%;
	BACKGROUND-COLOR: #87ceeb;
	border: 1px solid #666;
}

TR.editHeaderTr {
	HEIGHT: 25px;
	BACKGROUND-COLOR: #b0e0e6
}

TD.editHeaderTd {
	PADDING-LEFT: 50px;
	FONT-WEIGHT: bold
}

TR.editTr {
	HEIGHT: 30px
}

TD.editLeftTd {
	WIDTH: 150px;
	BACKGROUND-COLOR: #b0e0e6;
	TEXT-ALIGN: center
}

TD.editRightTd {
	PADDING-LEFT: 10px;
	BACKGROUND-COLOR: #fff
}

TR.editFooterTr {
	HEIGHT: 40px;
	BACKGROUND-COLOR: #b0e0e6
}

TD.editFooterTd {
	PADDING-LEFT: 150px
}

TR.position {
	HEIGHT: 25px;
	BACKGROUND-COLOR: #b0e0e6
}
</style>
	</head>

	<body>

		<table class=editTable style="margin: 20px 0 20px 0; color: #000"
			cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
			<tr class=position bgcolor="#22cc77">
				<td>
					当前位置: 个人资料 -&gt; 个人信息
				</td>
			</tr>
		</table>

		<table class=editTable
			style="margin: 20px 0 20px 0; background-color: #FFFFFF; border-width: 0"
			cellSpacing=1 cellPadding=0 width="98%" align=center border=0>
			<tr>
				<td width="200" align="center" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top">
								<!-- 로그인부분 -->
								<table border="0" cellpadding="0" cellspacing="0" align="center">
									<tr>
										<td>
											<img src="${ctx}/homepage/image/mycourse_title.gif"
												border="0" alt="">
										</td>
									</tr>
									<tr height="11">
										<td>
											<!-- 로그인 웃부분 여백 -->
											<table border="0" cellpadding="0" cellspacing="0"
												width="100%" height="100%">
												<tr>
													<td width="2" bgcolor="#e7e7e7"></td>
													<td width="190"></td>
													<td width="2" bgcolor="#e7e7e7"></td>
												</tr>
											</table>
											<!--/ 로그인 웃부분 여백 -->
										</td>
									</tr>
									<tr>
										<td width="194">
											<!-- 头像 -->
											<table border="0" cellpadding="0" cellspacing="0"
												width="100%">
												<tr height="29">
													<td width="2" bgcolor="#e7e7e7" valign="top"></td>
													<td width="10" valign="top"></td>
													<td valign="top" width="170">
														<a
															href="${ctx}/upload/<s:property value="userInfo.photo"/>"
															title="" class="thickbox"><img width="170" border="0"
																src="${ctx}/upload/<s:property value="userInfo.photo"/>" />
														</a>
													</td>
													<td width="10" valign="top"></td>
													<td width="2" bgcolor="#e7e7e7" valign="top"></td>
												</tr>
											</table>
											<!--/ 头像 -->
										</td>
									</tr>
									<tr height="16">
										<td>
											<table border="0" cellpadding="0" cellspacing="0"
												width="100%" height="100%">
												<tr>
													<td width="2" bgcolor="#e7e7e7"></td>
													<td width="190"></td>
													<td width="2" bgcolor="#e7e7e7"></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td width="2" bgcolor="#e7e7e7"></td>
													<td width="13"></td>

													<td width="2" bgcolor="#e7e7e7"></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td width="2" bgcolor="#e7e7e7"></td>
													<td width="53"></td>
													<td>
														<a href="<s:url action="goChangePhotoAction"></s:url>"><img
																src="${ctx}/homepage/image/change_head.gif" border="0"
																alt="修改头像"> </a>
													</td>
													<td width="6"></td>
													<td width="43">

													</td>
													<td width="11"></td>
													<td width="2" bgcolor="#e7e7e7"></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<img src="${ctx}/homepage/image/login_bottom.gif" border="0"
												alt="">
										</td>
									</tr>
								</table>


								<!-- 리스트 -->
							</td>
						</tr>
					</table>
				</td>
				<td valign="top">
					<s:form action="changeTeacherInfoAction" method="post"
						onsubmit="return check(this);">
						<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
							border=0>
							<s:hidden name="teacher.id" />
							<s:hidden name="teacher.password" />
							<s:hidden name="userInfo.id" />
							<s:hidden name="teacher.teacherNo" />
							<s:hidden name="teacher.userInfo.id" />
							<s:hidden name="userInfo.photo" />
							<s:hidden name="userInfo.department.id" />
							<tr class=editHeaderTr>
								<td class=editHeaderTd colSpan=7>
									修改个人信息：
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFDF0">
									<div align="center">
										名字：
									</div>
								</td>
								<td colspan="3" bgcolor="#FFFFFF">
									&nbsp;&nbsp;&nbsp;
									<s:textfield id="name"  size="40"  name="userInfo.name"
										cssClass="input" />
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFDF0">
									<div align="center">
										职称：
									</div>
								</td>
								<td colspan="3" bgcolor="#FFFFFF">
									&nbsp;&nbsp;&nbsp;
									<s:textfield id="position" size="40" name="teacher.position" cssClass="input" />
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFDF0">
									<div align="center">
										性别：
									</div>
								</td>
								<td colspan="3" bgcolor="#FFFFFF">
									&nbsp;&nbsp;&nbsp;
									<s:select name="userInfo.sex" list="{'男','女'}" />
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFDF0">
									<div align="center">
										电子邮箱：
									</div>
								</td>
								<td colspan="3" bgcolor="#FFFFFF">
									&nbsp;&nbsp;&nbsp;
									<s:textfield id="email" size="40" name="userInfo.email" cssClass="INPUT" />
								</td>
							</tr>
							<tr>
								<td bgcolor="#FFFDF0">
									<div align="center">
										手机：
									</div>
								</td>
								<td colspan="3" bgcolor="#FFFFFF">
									&nbsp;&nbsp;&nbsp;
									<s:textfield id="mobile" size="40" name="userInfo.mobile" cssClass="INPUT" />
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
				</td>
			</tr>
		</table>
	</body>
</html>
