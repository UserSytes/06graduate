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
		<title>添加学院</title>
		<script type="text/javascript" src="/course/dwr/engine.js"></script>
		<script type="text/javascript" src="/course/dwr/util.js"></script>
		<script type="text/javascript" src="/course/dwr/interface/SuperAdminService.js"></script>
		<SCRIPT language=javascript>
		function checkSchool(name) {
			if (name == "") {
				DWRUtil.setValue('result', "学院名称不能为空！");
				return false;
			}
			SuperAdminService.checkSchool(name, callBack);
		}
		function callBack(data) {
			if (data != null){
				DWRUtil.setValue('result', "该学院已经存在，请更换帐号！");
				document.getElementById("button").disabled = true;
			}
			else{
				DWRUtil.setValue('result', "该学院名称可用！");
				document.getElementById("button").disabled = false;
				}
		}
			function check(form)
			{
				if (form.schoolName.value == "")
				{
					form.schoolName.focus();
					alert("学院名不能为空！");
					return false;
				}else{
					form.button.disabled = true;
					return true;
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
					当前位置: 院系管理 -&gt; 添加学院
				</td>
			</tr>
		</table>
		<s:form action="addSchoolAction" method="post"
			onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新学院信息
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							学院名称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield  size="50" cssClass="INPUT" id="schoolName" name="school.Name" label="学院名称" onblur="checkSchool(this.value)"></s:textfield>
						&nbsp;*<span style="color: green;" id="result">点击验证 </span>
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
