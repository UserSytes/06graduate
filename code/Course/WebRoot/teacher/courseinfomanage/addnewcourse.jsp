<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>课程申报</title>
	</head>

	<body onload="getSchool()">
		<script type="text/javascript" src="/course/dwr/engine.js"></script>
		<script type="text/javascript" src="/course/dwr/util.js"></script>
		<script type="text/javascript"
			src="/course/dwr/interface/DepartmentDAO.js"></script>
		<script type="text/javascript"
			src="/course/dwr/interface/SchoolDAO.js"></script>
		<script language="javascript">
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
	function check(form) {
		if (form.Department.value == -1) {
			alert("请先选择申报的院系！");
			return false;
		}
		if (form.name.value == "") {
			alert("名字不能为空！");
			form.name.focus();
			return false;
		}
		if (form.name.value.length >= 50) {
			alert("名字长度不能超过50！");
			form.name.focus();
			return false;
		}
		form.submit.disabled = true;

	}
</script>
<div align="center" width="98%">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程管理-&gt; 课程申报
				</td>
			</tr>
		</table>

		<s:form action="addNewCourseAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						添加课程：
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
						<select id="School" name="School"
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
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							级别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select id="level" list="{'国家级','省级','市级','校级','其它'}"
							name="course.level"></s:select>
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
						<s:textfield id="name" size="50" name="course.name" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							编号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield id="name" size="50" name="course.number" cssClass="input" />
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
						<s:textarea name="course.remark" cssClass="TEXTAREA"></s:textarea>
					</td>
				</tr>
				<tr class=editHeaderTr>
					<td width="30%">
						&nbsp;
					</td>
					<td width="70%">
						<s:submit id="submit" cssClass="label" value="确认" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
<div align="left" style="border: 1px solid #ccc;padding: 10px; width: 98%">
				<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
				<strong><font color="red" size="3"> 提示</font> </strong>
				<div id="content_note">
					<ul>
						<li>
							请认真填写课程相关信息和选择课程所属学院。
						</li>
						<li>
							申请新的课程后需要等待所申请学院的教学秘书审核通过才能进行上传课件等操作。
						</li>						
						<li>
							如果您的课程长时间未审核通过，请向教学秘书反映相关情况。
						</li>						
					</ul>

				</div>
			</div>	
</div>
	</body>
</html>
