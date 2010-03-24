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
		<title>添加系</title>
		<script type="text/javascript" src="/dwr/engine.js"></script>
		<script type="text/javascript" src="/dwr/util.js"></script>
		<script type="text/javascript" src="/dwr/interface/DepartmentService.js"></script>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.name.value == "")
				{
					alert("系名不能为空！");
					return false;
				}else{
					return true;
				}
			}
			
	function checkDepartment(name) {
		if (name == "") {
			DWRUtil.setValue('result', "系名不能为空！");
			return false;
		}
		DepartmentService.getDepartmentByName(name, callBack);
	}
	function callBack(data) {
		if (data != null){
			DWRUtil.setValue('result', "该系名已经存在，请更换！");
			document.getElementById("button").disabled = true;
		}
		else{
			DWRUtil.setValue('result', "该系名可用！");
			document.getElementById("button").disabled = false;
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
					当前位置: 院系管理 -&gt;
					<s:text name="">${school.name}</s:text>
					-&gt; 添加系
				</td>
			</tr>
		</table>
		<s:form action="addDepartmentAction" method="post"
			onsubmit="return check(this);">
			<s:hidden name="schoolId" />
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新系信息
					</td>
				</tr>
				<tr>
					<td width="20%" bgcolor="#FFFDF0">
						<div align="center">
							系名称：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield cssClass="INPUT" id="name"  size="50"
							name="department.name" label="学院名称" onblur="checkDepartment(this.value)"></s:textfield>
						&nbsp;*<span style="color: green;" id="result"> </span>
					</td>
				</tr>	
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							所属学院：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:text name="">${school.name}</s:text>
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