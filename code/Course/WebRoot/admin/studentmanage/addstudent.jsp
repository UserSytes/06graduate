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
        <script type="text/javascript" src="/course/dwr/engine.js"></script>
		<script type="text/javascript" src="/course/dwr/util.js"></script>
		<script type="text/javascript" src="/course/dwr/interface/StudentInfoService.js"></script>
		<SCRIPT language=javascript>
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
			DWRUtil.setValue('result',"该学生帐号已被注册，请另选帐号！");
			document.getElementById("button").disabled = true;
			}
		else{
			DWRUtil.setValue('result',"该学生帐号可用！");
			document.getElementById("button").disabled = false;
			}
	}
			function check(form)
			{
			if (form.studentNo.value == "")
				{
					alert("账号不能为空！");
					return false;
				}
				if (form.name.value == "")
				{
					alert("姓名不能为空！");
					return false;
				}
				if (form.sex.value == -1)
				{
					alert("性别不能为空！");
					return false;
				}
				if (form.departmentId.value == -1)
				{
					alert("所属系不能为空！");
					return false;
				}
				if (form.gradeId.value == -1)
				{
					alert("年级不能为空！");
					return false;
				}
				return true;
			}
		</SCRIPT>
	</head>

	<body>
	<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 学生管理 -&gt; 添加学生
				</td>
			</tr>
		</table>
		<s:form action="addStudentAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新学生账号信息
					</td>
				</tr>
<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							账号/学号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="studentNo"  size="30"
							name="student.studentNo" label="账号" onblur="getStudentName(this.value)"></s:textfield>
						&nbsp;*<span style="color: green;" id="result">
						</span>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							登陆密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<font color="#808080">初始密码为与账号相同 </font>&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="name"  size="30"
							name="userInfo.name" label="姓名"></s:textfield>
						&nbsp;*
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
						<s:select id="sex" name="userInfo.sex" list="{'男','女'}"
							headerKey="-1" headerValue="请选择"/>
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							所属系：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="departmentId"
							list="departmentList" headerKey="-1" headerValue="请选择"
							listKey="id" listValue="name" />
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							年级：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="gradeId"
							list="gradeList" headerKey="-1" headerValue="请选择"
							listKey="id" listValue="name+grade" />
						&nbsp;*
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
	</div>
	</body>
</html>
