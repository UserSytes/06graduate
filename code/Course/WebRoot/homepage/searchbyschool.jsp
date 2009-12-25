<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站</title>
	</head>
	<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="images/back-body.jpg" style="overflow-x: hidden">
		<center>

			<table width="783" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%" background="images/back-left.jpg">
						<img src="images/spacer.gif" width="9" height="1">
					</td>


					<td width="765" height="100%" valign="top"
						background="images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=765 height="102">
									<s:include value="include/header4.jsp"></s:include>
								</td>
							</tr>
							<tr>
								<td width="210" height="10" valign="top">
									<table width="214" height="543" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="60">
												<img src="images/up-1.jpg" width="214" height="60">
											</td>
										</tr>

										<tr>
											<td height="38">
												<img src="images/but-2.jpg" width="214" height="38">
											</td>
										</tr>
										<tr>
											<td width="210" height="100%" valign="top"
												background="images/back-but-2.jpg"
												style="padding-left: 28px; padding-top: 4px; padding-bottom: 15px">
												<img src="images/text-2.jpg" width="92" height="17">
												<br>
												<div style="line-height: 15px; padding-bottom: 10px">
													<font face="tahoma"
														style="font-size: 10px; color: #666666; line-height: 15px">11
														Some Street Second Floor<br>New York WA 02020<br>Tel./Fax
														1(800)111-1111</font>
												</div>
												<img src="images/text-2.jpg" width="92" height="17">
												<br>
												<div style="line-height: 14px">
													<font face="tahoma"
														style="font-size: 10px; color: #666666; line-height: 14px">3030
														Some street Suite 1500<br>Atlanta GA 30300<br>Tel./Fax
														1(800)111-1111</font>
												</div>
											</td>
										</tr>
									</table>
								</td>
								<td width="555" height="10" valign="top">
									<table width="555" height="100%" border="0" cellspacing="0"
										cellpadding="0" background="images/back-up-3.jpg">
										<tr>
											<td width="555" height="10" background="images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="555" height="534" border="0" cellspacing="0"
													cellpadding="0" background="images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: center bottom;">
													<table class=editTable cellSpacing=1 cellPadding=0
														width="553" align=center border=0 height="38"
														style="width: 553px;">

														<tr class=position bgcolor="#ECF3FD">
															<td>
																当前位置: 首页 -&gt; 搜索课程
															</td>
														</tr>
													</table>

													<s:form action="findCourseByDepartmentAction" method="post"
														onsubmit="">&nbsp;&nbsp; 
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
															align=center border=0>
															<tr class=editHeaderTr>
																<td class=editHeaderTd colSpan=7>
																	院系搜索
																</td>
															</tr>
															<tr>
																<td bgcolor="#FFFDF0">
																	<div align="center">
																		院系：
																	</div>
																</td>
																<td colspan="3" bgcolor="#FFFFFF">
																	&nbsp;&nbsp;&nbsp;
																	<select id="School" name="school"
																		onchange="getDepartment(this.value)">
																		<option value="-1">
																			--请选择院--
																		</option>
																	</select>
																	<select id="Department" name="departmentId">
																		<option value="-1">
																			--请选择系--
																		</option>
																	</select>
																</td>
															</tr>
															<tr bgcolor="#ECF3FD">
																<td width="30%">
																	&nbsp;
																</td>
																<td width="70%">
																	<s:submit cssClass="label" value="确认" />
																	<s:reset cssClass="label" value="取消" />
																</td>
															</tr>
														</table>
													</s:form>
													<s:form action="findCourseByNameAction" method="post"
														onsubmit="">&nbsp;&nbsp;
	<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
															align=center border=0>
															<tr class=editHeaderTr>
																<td class=editHeaderTd colSpan=7>
																	课程名称搜索
																</td>
															</tr>
															<tr>
																<td bgcolor="#FFFDF0">
																	<div align="center">
																		名称：
																	</div>
																</td>
																<td colspan="3" bgcolor="#FFFFFF">
																	&nbsp;&nbsp;&nbsp;
																	<s:textfield name="courseName" cssClass="input" />
																</td>
															</tr>
															<tr bgcolor="#ECF3FD">
																<td width="30%">
																	&nbsp;
																</td>
																<td width="70%">
																	<s:submit cssClass="label" value="确认" />
																	<s:reset cssClass="label" value="取消" />
																</td>
															</tr>
														</table>
													</s:form>
													<tr>
														<td colspan="3"
															style="padding-left: 110px; padding-bottom: 0px"
															valign="top"></td>
													</tr>


													<tr>
														<td width="389" valign="top" style="padding-left: 5px">
															<img src="images/text-19.jpg" width="114" height="17"
																style="margin-bottom: 10px">

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
									<img src="images/spacer.gif" width="1" height="1">
								</td>
							</tr>
						</table>
					</td>
					<td width="9" height="100%" background="images/back-right.jpg">
						<img src="images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
		</center>
	</BODY>
</html>