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
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>课程申报</title>

	</head>

	<body onload="getSchool()">
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

	function getSchool() {

		SchoolDAO.findAll(callbackorg);

	}

	function callbackorg(data) {
		DWRUtil.addOptions("School", data, "id", "name");

	}
	function getDepartment(prvid) {

		if (prvid == -1) {
		} else {
			DepartmentDAO.findBySchool(prvid, callbackorg2);

		}
	}
	function callbackorg2(data) { //显示出二级类别

		DWRUtil.removeAllOptions("Department");
		DWRUtil.addOptions("Department", data, "id", "name");
	}
	function getCourse(deptid) {
		alert("1");
		if (deptid == -1) {
		} else {
			CourseDAO.findByDepartment(deptid, callbackorg3);
alert("3");
		}
	}
	function callbackorg3(data) { //显示出二级类别
alert("2");
		DWRUtil.removeAllOptions("Course");
		DWRUtil.addOptions("Course", data, "id", "name");
	}
</script>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 个人资料 -&gt; 个人信息
				</td>
			</tr>
		</table>

		<s:form action="applyCourseAction" method="post"
			onsubmit="return check(this);">&nbsp;&nbsp; 
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						修改个人信息：
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							课程：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<select id="School" name="School"
							onchange="getDepartment(this.value)">
							<option value="-1">
								--请选择院--
							</option>
						</select>
						<select id="Department" name="Department"
							onchange="getCourse(this.value)">
							<option value="-1">
								--请选择系--
							</option>
						</select>
						<select id="Course" name="courseId">
							<option value="-1">
								--请选择系--
							</option>
						</select>
					</td>
				</tr>
				<tr id="test">
					<td bgcolor="#FFFDF0">
						<div align="center">
							级别:
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="teacherCourse.level" list="{'国家级','省级','校级','其它'}" />
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
						<s:textfield name="teacherCourse.name" cssClass="INPUT" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							备注：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textarea name="teacherCourse.remark" cssClass="TEXTAREA" />
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
	</body>
</html>
