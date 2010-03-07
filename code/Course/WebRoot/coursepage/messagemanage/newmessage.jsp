<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>发布新帖&lt;--厦门大学精品课程</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="${ctx}/coursepage/default.css" rel="stylesheet"
			type="text/css" />
<SCRIPT language=javascript>
	function check(form) {
		if (form.title.value == "") {
			alert("标题不能为空！");
			return false;
		}
		if (form.messagecontent.value == "") {
			alert("内容不能为空！");
			return false;
		}
		return true;

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
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../top.jsp"></jsp:include>
		<div id="content">
			<div style="width: 770px">
<s:form action="addNewMessageAction" method="post" id="myform" name="myform"
			namespace="/upLoadFile" target="_self" enctype="multipart/form-data" onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="70%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请编辑帖子内容
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							标题：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<s:textfield cssClass="LONGINPUT" id="title" name="topic.name"
							label="标题"></s:textfield>
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							内容：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<FCK:editor instanceName="message.content" width="100%" height="405"
							toolbarSet="Default">
							<jsp:attribute name="value">
                            </jsp:attribute>
						</FCK:editor>
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="15%">
						&nbsp;
					</td>
					<td width="85%">
						<s:submit cssClass="label" value="确定添加"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
			</div>
		</div>

		<jsp:include page="../bottom.jsp"></jsp:include>
	</body>
</html>