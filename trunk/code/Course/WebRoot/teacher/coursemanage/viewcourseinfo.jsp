<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>修改密码</title>
		<SCRIPT language=javascript>
	function sortChange(sort) {
		window.location.href = "findCurrentCourseInfoAction.action?sort="
				+ sort;

	}
	function deleteCourseInfo(){
	if(document.all.courseInfoId.value == ""){
	alert("该目录下暂无任何内容,无法删除");
	return false;}                 

		if(!confirm('确认删除？')) return false;
	}
</SCRIPT>
	</head>

	<body>
		<s:hidden id="courseInfoId" name="courseInfo.id"></s:hidden>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position>
				<td>
					当前位置: 我的课程 -&gt; 课程信息
				</td>
			</tr>
		</table>
		&nbsp;&nbsp;
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>
					查看课程信息：
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">
						目录：
					</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF">
					&nbsp;&nbsp;&nbsp;
					<s:select name="sort" list="#{2:'教学大纲',1:'课程简介'}" listKey="key"
						listValue="value" onchange="sortChange(this.value)" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">
						操作：
					</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF">
					&nbsp;&nbsp;&nbsp;

					<a
						href="<s:url action="updateCourseInfoAction"> 
                     			<s:param name="courseInfoId"> 
                       			 	<s:property value="courseInfo.id"/> 
                    			</s:param> 
                					</s:url>">
						<font color="green">【编辑】</font> </a>
					<a
						href="<s:url action="deleteCourseInfoAction"> 
                     			<s:param name="courseInfoId"> 
                       			 	<s:property   value="courseInfo.id"/> 
                    			</s:param> 
                					</s:url>"
						onclick="return deleteCourseInfo();"> <font color="red">【删除】</font>
					</a>
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">
						标题：
					</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF">
					&nbsp;&nbsp;&nbsp;
					<s:property value="courseInfo.title" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">
						内容：
					</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF">
					&nbsp;&nbsp;&nbsp;

				</td>
			</tr>
			<tr>
				<td colspan="7" bgcolor="#FFFFFF">
					<s:property escape="false" value="courseInfo.content" />
				</td>
			</tr>
		</table>

	</body>
</html>