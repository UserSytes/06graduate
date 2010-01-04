<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
	<link href="../${ctx}/homepage/default.css" rel="stylesheet"
			type="text/css" />	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>精品课程搜索引擎</title>
	</head>
	<BODY onload="getSchool()" BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
		MARGINHEIGHT=0 rightmargin="0" bottommargin="0"
		background="${ctx}/homepage/images/back-body.jpg" style="overflow-x: hidden">
<script type="text/javascript" src="/dwr/engine.js"></script>
		<script type="text/javascript" src="/dwr/util.js"></script>
		<script type="text/javascript" src="/dwr/interface/DepartmentDAO.js"></script>
		<script type="text/javascript" src="/dwr/interface/SchoolDAO.js"></script>
		<script language="javascript">
		function callbackorgcus(data) {
		if (data) {
			DWRUtil.setValue("check", "该用户已存在");
		} else {
			DWRUtil.setValue("check", "可用用户名");
		}
	}
	//获得学校列表
	function getSchool() {

		SchoolDAO.findAll(callbackorg);

	}
	//显示学校级别
	function callbackorg(data) {
		DWRUtil.addOptions("School", data, "id", "name");

	}
	//显示院系级别
	function callbackorg2(data) {

		DWRUtil.removeAllOptions("Department");
		DWRUtil.addOptions("Department", data, "id", "name");
	}
	//获得院系列表
	function getDepartment(prvid) {

		if (prvid == -1) {
		} else {
			DepartmentDAO.findBySchool(prvid, callbackorg2);

		}
	}
	
		
</script>
		<center>

			<table width="74" height="780" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="9" height="100%" background="${ctx}/homepage/images/back-left.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>


					<td width="765" height="100%" valign="top"
						background="${ctx}/homepage/images/back-end.jpg">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td colspan="2" WIDTH=700 height="102">
									<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="765" height="102">
                  <param name="movie" value="${ctx}/homepage/flash/delta46-2.swf">
                  <param name="quality" value="high"> <param name="menu" value="false">
                  <embed src="${ctx}/homepage/flash/delta46-2.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="765" height="102"></embed>
			  </object>
								</td>
							</tr>
							<tr>
								<td width="210" height="10" valign="top">
									<table width="214" height="543" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="60">
												<img src="${ctx}/homepage/images/up-1.jpg" width="214" height="60">
											</td>
										</tr>

											<tr>
											<td height="38">
												<img src="${ctx}/homepage/images/but-2-3.jpg" width="214" height="38" style="">
											</td>
										</tr>
										<tr>
											<td width="210" height="100%" valign="top"
												background="${ctx}/homepage/images/back-but-2.jpg"
												style="padding-left: 28px; padding-top: 4px; padding-bottom: 15px">
												<br>
												<div style="line-height: 15px; padding-bottom: 10px"></div>
												<a href="searchbyschool.jsp">搜索课程</a>
												<div style="line-height: 15px; padding-bottom: 10px">
												</div>
											</td>
										</tr>
									</table>
								</td>
								<td width="555" height="10" valign="top">
									<table width="545" height="618" border="0" cellspacing="0"
										cellpadding="0" background="${ctx}/homepage/images/back-up-3.jpg" style="height: 618px;">
										<tr>
											<td width="555" height="10" background="${ctx}/homepage/images/up-3.jpg"
												style="background-repeat: no-repeat; background-position: top">
												<table width="555" height="534" border="0" cellspacing="0"
													cellpadding="0" background="${ctx}/homepage/images/end-3.jpg"
													style="background-repeat: no-repeat; background-position: center bottom;">
<tr><td>
											<table class=editTable cellSpacing=1 cellPadding=0 align=center
					border=1>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 首页 -&gt; 搜索课程
				</td>
			</tr>
		</table>

		<s:form action="findCourseByDepartmentAction" method="post"
			onsubmit="">&nbsp;&nbsp; 
			<table class=editTable cellSpacing=1 cellPadding=0 align=center
					border=1>
															<tr >
																<td  colSpan=7>
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
		<s:form action="findCourseByNameAction" method="post" onsubmit="">&nbsp;&nbsp;
	<table class=editTable cellSpacing=1 cellPadding=0 align=center
					border=1>
				<tr>
					<td colSpan=7>
						课程搜索
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
<s:form action="findCourseByTeacherAction" method="post" onsubmit="">&nbsp;&nbsp;
	<table class=editTable cellSpacing=1 cellPadding=0 align=center
					border=1>
				<tr >
					<td colSpan=7>
						教师搜索
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							教师名称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield name="teacherName" cssClass="input" />
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


</td></tr>

												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<s:include value="include/bottom.jsp"></s:include>
							<tr>
								<td colspan="2" height="100%">
									<img src="${ctx}/homepage/images/spacer.gif" width="1" height="1">
								</td>
							</tr>
						</table>
					</td>
					<td width="9" height="100%" background="${ctx}/homepage/images/back-right.jpg">
						<img src="${ctx}/homepage/images/spacer.gif" width="9" height="1">
					</td>
				</tr>
			</table>
		</center>
	</BODY>
</html>