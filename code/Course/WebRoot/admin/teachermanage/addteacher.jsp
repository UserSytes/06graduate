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
		<title>添加教师</title>
 		<script type="text/javascript" src="/course/dwr/engine.js"></script>
		<script type="text/javascript" src="/course/dwr/util.js"></script>
		<script type="text/javascript" src="/course/dwr/interface/TeacherInfoService.js"></script>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.teacherName.value == "")
				{
					form.teacherName.focus();
					alert("姓名不能为空！");
					return false;
				}
				if (form.sex.value == -1)
				{
					form.sex.focus();
					alert("性别不能为空！");
					return false;
				}
				if (form.departmentId.value == -1)
				{
					form.departmentId.focus();
					alert("所属系不能为空！");
					return false;
				}
				if (form.teacherNo.value == "")
				{
					form.teacherNo.focus();
					alert("账号不能为空！");
					return false;
				}
				form.button.disabled = true;
				return true;
			}
			
	function checkTeacher(teacherNo) {
		if (teacherNo == "")
				{
					DWRUtil.setValue('result1',"账号不能为空！");
					return false;
				}
		TeacherInfoService.findTeacherByTeacherNo(teacherNo,callBack);
	}
	function callBack(data){
		if(data != null){
			DWRUtil.setValue('result1',"该教师帐号已被注册，请另选帐号！");
			document.getElementById("button").disabled = true;
			}
		else{
			DWRUtil.setValue('result1',"");
			DWRUtil.setValue('result2',"该教师帐号可用！");
			document.getElementById("button").disabled = false;
			}
	}
		</SCRIPT>
	</head>

	<body>
	<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 教师管理 -&gt; 添加教师
				</td>
			</tr>
		</table>
		<s:form action="addTeacherAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新教师信息
					</td>
				</tr>
<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							账号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="teacherNo"  size="30"
							name="teacher.teacherNo" label="账号" onblur="checkTeacher(this.value)"></s:textfield>
						&nbsp;*<span id="result1" style="color: red;" ><span id="result2" style="color: green;" >
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
						<s:textfield cssClass="INPUT" id="teacherName"  size="30"
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
							职位：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="position"  size="30"
							name="teacher.position" label="职位"></s:textfield>

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
