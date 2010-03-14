<html xmlns="http://www.w3.org/1999/xhtml">

	<%@ include file="../commons/taglibs.jsp"%>
	<head>
		<%@ page language="java" contentType="text/html; charset=UTF-8"
			pageEncoding="UTF-8"%>
		<title>无标题文档</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 12px;
}

.STYLE2 {
	font-size: 12px;
	color: #03515d;
}

a:link {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}

a:visited {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}
-->
</style>
	</head>
	<body onload="getCourse(3)">
		<script type="text/javascript" src="../js/prototype.js"></script>
		<script language=JavaScript>
	function showsubmenu(sid) {
		whichEl = eval("submenu" + sid);
		if (whichEl.style.display == "none") {
			eval("submenu" + sid + ".style.display=\"\";");
		} else {
			eval("submenu" + sid + ".style.display=\"none\";");
		}
	}
	function getCourse(type) {
		var url = "getMyCourseInLeft.action?type=" + type;
		new Ajax.Updater('courseMain', url, {
			onLoading : function() {
			},
			onSuccess : function(request) {
			},
			onFailure : function(request) {
				alert("服务器故障，请稍候重试");
			}
		});
	}
</script>
		<table width="156" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="top">
					<table width="100%" height="100%" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="33" background="images/main_21.gif">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td height="20" background="images/main_25.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="13%">
											&nbsp;
										</td>
										<td width="72%" height="20">
											<div align="center">
												<table width="78%" height="21" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td>
															<div align="center">
																<img src="images/top_8.gif" width="16" height="16">
															</div>
														</td>
														<td valign="middle" style="CURSOR: hand"
															onclick=showsubmenu(1);>
															<div align="center" class="STYLE1">
																教师信息
															</div>
														</td>
													</tr>
												</table>
											</div>
										</td>
										<td width="15%">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="center" valign="top">
								<table id=submenu1 width="145" border="0" align="center"
									cellpadding="0" cellspacing="0">

									<tr>
										<td>
											<table width="130" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="41" height="35">
														<div align="center">
															<img src="images/left_1.gif" width="31" height="31">
														</div>
													</td>
													<td width="89" height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;<A
																		href="getTeacherInfoAction.action" target=I2>个人信息</A>
																	</span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td width="41" height="35">
														<div align="center">
															<img src="images/left_2.gif" width="31" height="31">
														</div>
													</td>
													<td height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;<A
																		href="changepassword.jsp" target=I2>修改密码</A> </span>
																</td>
															</tr>
														</table>
													</td>
												</tr>

											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="22" background="images/main_36.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="13%">
											&nbsp;
										</td>
										<td width="72%" height="20">
											<div align="center">
												<table width="78%" height="21" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td>
															<div align="center">
																<img src="images/top_17.gif" width="16" height="16">
															</div>
														</td>
														<td valign="middle" style="CURSOR: hand"
															onClick="showsubmenu(2);">
															<div align="center">
																<span class="STYLE1">课程管理</span>
															</div>
														</td>
													</tr>
												</table>
											</div>
										</td>
										<td width="15%">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="center" valign="top">
								<table id=submenu2 width="145" border="0" align="center"
									cellpadding="0" cellspacing="0">

									<tr>
										<td>
											<table width="130" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="41" height="35">
														<div align="center">
															<img src="images/left_1.gif" width="31" height="31">
														</div>
													</td>
													<td width="89" height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;<a
																		href="courseinfomanage/addnewcourse.jsp" target=I2>课程申请</a>
																	</span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td width="41" height="35">
														<div align="center">
															<img src="images/left_2.gif" width="31" height="31">
														</div>
													</td>
													<td height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;<a
																		href="getMyCourseAction.action" target=I2>我的课程</a> </span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td width="41" height="35">
														<div align="center">
															<img src="images/left_1.gif" width="31" height="31">
														</div>
													</td>
													<td width="89" height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;<a
																		href="coursePassByTeaAction.action?type=1" target=I2>学生管理</a>
																	</span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td width="41" height="35">
														<div align="center">
															<img src="images/left_3.gif" width="31" height="31">
														</div>
													</td>
													<td height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;<a
																		href="addcourseinfo.jsp" target=I2>留言管理</a> </span>
																</td>
															</tr>
														</table>
													</td>
												</tr>

											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="22" background="images/main_36.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="13%">
											&nbsp;
										</td>
										<td width="72%" height="20">
											<div align="center">
												<table width="78%" height="21" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td>
															<div align="center">
																<img src="images/top_16.gif" width="16" height="16">
															</div>
														</td>
														<td valign="middle" style="CURSOR: hand"
															onclick="showsubmenu(3)">
															<div align="center">
																<span class="STYLE1">我的课程</span>
															</div>
														</td>
													</tr>
												</table>
											</div>
										</td>
										<td width="15%">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="center" valign="top">
								<div id="courseMain" align="center">
									<s:include value="left_course_children.jsp"></s:include>
								</div>
							</td>
						</tr>
						<tr>
							<td height="22" background="images/main_36.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="13%">
											&nbsp;
										</td>
										<td width="72%" height="20">
											<div align="center">
												<table width="78%" height="21" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td>
															<div align="center">
																<img src="images/top_18.gif" width="16" height="16">
															</div>
														</td>
														<td valign="middle">
															<div align="center" class="STYLE1">
																系统信息
															</div>
														</td>
													</tr>
												</table>
											</div>
										</td>
										<td width="15%">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="center" valign="top">
								<table id=submenu4 width="145" border="0" align="center"
									cellpadding="0" cellspacing="0">

									<tr>
										<td>
											<table width="130" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>													
													<td height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;设计制作：软件学院
																	</span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>													
													<td height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;技术支持：软件学院
																	</span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>													
													<td height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;帮助中心：软件学院
																	</span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>													
													<td height="35">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td height="23" style="cursor: hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">&nbsp;系统版本：1.0开发版
																	</span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="39" background="images/main_37.gif">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
