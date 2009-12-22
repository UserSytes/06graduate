<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="../css1/css1.css" type=text/css rel=stylesheet>
		<title>查看精品课程申请表</title>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
  </head>
  <body>
    <table width="100%" height="100%" border="2" cellpadding="0"
			cellspacing="2" id="mblock1">
		<tr>
			<th>所属学校</th>
			<td><s:property value="applicationForm.school" /></td>
		</tr>
		<tr>
			<th>所属院系</th>
			<td><s:property value="applicationForm.school" /></td>
		</tr>
		<tr>
			<th>课程名称</th>
			<td><s:property value="applicationForm.name" /></td>
		</tr>
		<tr>
			<th>课程层次（本/专）</th>
			<td><s:property value="applicationForm.level" /></td>
		</tr>
		<tr>
			<th>课程类型</th>
			<td><s:property value="applicationForm.sort" /></td>
		</tr>
		<tr>
			<th>所属一级学科名称</th>
			<td><s:property value="applicationForm.firstSubject" /></td>
		</tr>
		<tr>
			<th>所属二级学科名称</th>
			<td><s:property value="applicationForm.secondSubjet" /></td>
		</tr>
		<tr>
			<th>课程负责人</th>
			<td><s:property value="applicationForm.responser" /></td>
		</tr>
	</table>
  </body>
</html>
