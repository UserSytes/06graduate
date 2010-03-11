<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>添加学生</title>
		<script type="text/javascript" src="/dwr/engine.js"></script>
		<script type="text/javascript" src="/dwr/util.js"></script>
		<script type="text/javascript" src="/dwr/interface/StudentInfoService.js"></script>
		<SCRIPT language=javascript>
	function check(form) {
		if (form.studentNo.value == "") {
			alert("学号不能为空！");
			return false;
		}
		return true;
	}
	function getStudentName(stuNo) {
		if (stuNo == "")
				{
					DWRUtil.setValue('result',"账号不能为空！");
					return false;
				}
		StudentInfoService.findUserInfoByStudentNo(stuNo,callBack);
	}
	function callBack(data){
		if(data != null){
			DWRUtil.setValue('result',data.name);
			document.getElementById("button").disabled = false;
			}
		else{
			DWRUtil.setValue('result',"该学生不存在");
			document.getElementById("button").disabled = true;
			}
	}
</SCRIPT>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>

	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程管理 -&gt;
					<s:text name="">${course.name}</s:text>
					-&gt; 添加学生
				</td>
			</tr>
		</table>
		<s:form action="addCourseStudentAction" method="post"
			onsubmit="return check(this);">
			<s:hidden name="course.id" />
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						<s:text name="">${course.name}</s:text>
						课程添加学生
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							请输入学号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="studentNo"
							name="studentNo" label="学号"
							onblur="getStudentName(this.value)"></s:textfield>

						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">					
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="result">
						</span>
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="20%">
						&nbsp;
					</td>
					<td width="80%">
						<s:submit id="button" cssClass="label" value="确定添加"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
