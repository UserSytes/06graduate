<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站——搜索课程</title>
		<link rel="stylesheet" href="${ctx}/homepage/link.css">
		<script type="text/javascript" src="/dwr/engine.js"></script>
		<script type="text/javascript" src="/dwr/util.js"></script>
		<script type="text/javascript" src="/dwr/interface/DepartmentDAO.js"></script>
		<script type="text/javascript" src="/dwr/interface/SchoolDAO.js"></script>
		<script language="javascript">
	function check(form) {
		if (form.departmentId.value == -1 && form.courseName.value == "" && form.teacherName.value=="") {
			alert("搜索条件不能全为空，请重新搜索！");
			return false;
		}
		return true;
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
						<tr>
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<img src="${ctx}/homepage/image/left_menu_title3.gif"
												border="0">
										</td>
									</tr>
									<tr>
										<td>
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td width="11" background=""></td>
													<td width="172" align="center">
														<a href="<s:url action="forwardToSearchAction"></s:url>">
															<img src="${ctx}/homepage/image/left_menu_04.gif"
																border="0"> </a>
													</td>
													<td width="11" background=""></td>
												</tr>
												<tr>
													<td width="11" background=""></td>
													<td width="172" align="center">
														<a
															href="<s:url action="forwardToSuperSearchAction"></s:url>">
															<img src="${ctx}/homepage/image/left_menu_05.gif"
																border="0"> </a>
													</td>
													<td width="11" background=""></td>
												</tr>

											</table>
										</td>
									</tr>
									<tr>
										<td>
											<img src="${ctx}/homepage/image/jiannan2.jpg" border="0">
										</td>
									</tr>
								</table>

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
											<img src="${ctx}/homepage/image/title_search2.gif" border="0"
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
								<s:form action="superSearchCourseAction"
									onsubmit="return check(this);" method="post"
									enctype="multipart/form-data">
									<table width="90%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td width="20%" align="center">
												院系：
											</td>
											<td width="80%">
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
											</td>
										</tr>
										<tr>
											<td width="20%" align="center">
												课程：
											</td>
											<td width="80%">
												<s:textfield name="courseName" cssClass="text" />
											</td>
										</tr>
										<tr>
											<td width="20%" align="center">
												教师：
											</td>
											<td width="80%">
												<s:textfield name="teacherName" cssClass="text" />
											</td>
										</tr>
										<tr>
											<td></td>
											<td width="84">
												<input type="submit" name="submit"
													style="background: url(${ctx}/homepage/images/search_btn.gif) no-repeat"
													value="搜索 ">
											</td>
										</tr>
									</table>
								</s:form>

								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="90%" align="left">
											<s:actionmessage />
										</td>
									</tr>
								</table>
								<table width="95%" cellpadding="0" cellspacing="0">
									<tr height="40">
										<td colspan="5" background="${ctx}/homepage/image/bbs_bg.gif">
											<table border="0" cellpadding="0" cellspacing="0"
												style="height: 23px;" width="100%">
												<tr height="1">
													<td bgcolor="#d7d7d7" colspan="5" width="100%"></td>
												</tr>
												<tr>
													<td width="50" align="center">
														序号
													</td>
													<td width="355" align="center">
														课程名
													</td>
													<td width="64" align="center">
														教师
													</td>
													<td width="145" align="center">
														所属系
													</td>
													<td width="50" align="center">
														点击
													</td>
												</tr>
											</table>
										</td>
									</tr>

									<s:iterator value="courseList" status="course">
										<tr>
											<td width="50" align="center">
												<s:property value="#course.count" />
											</td>
											<td width="355" align="center">
												<a
													href="<s:url action="enterCourseAction"> 
																				<s:param name="courseId"> <s:property value="id"/> </s:param> </s:url>">
													<s:property value="name" />
												</a>
											</td>
											<td width="64" align="center">
												<s:property value="teacher.userInfo.name" />
											</td>
											<td width="145" align="center">
												<s:property value="department.name" />
											</td>
											<td width="50" align="center">
												<s:property value="count" />
											</td>
										</tr>
										<tr height="3">
											<td colspan="5"
												background="${ctx}/homepage/image/table_line.gif"></td>
										</tr>
									</s:iterator>
								</table>

							</td>
						</tr>
					</table>

					<!-- /内容 -->
				</td>
			</tr>
		</table>


		<!-- 底部 -->
		<s:include value="include/bottom.jsp"></s:include>
	</body>
</html>