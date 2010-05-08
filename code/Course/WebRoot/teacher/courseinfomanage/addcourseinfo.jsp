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
			function check(form)
			{
				if(form.title.value == "")
				{
					alert("标题不能为空！");
					form.title.focus();
					return false;
				}				
				var oEditor = FCKeditorAPI.GetInstance("courseInfo.content");
   				if(oEditor.GetXHTML(true) == "")
   				{
   					alert("内容不能为空！");
					return false;
   				}
   				form.submit.disabled = true;
			}
		</SCRIPT>
	</head>

	<body>
<div align="center" width="98%">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position>
				<td>
					当前位置: 我的课程 -&gt; 课程简介
				</td>
			</tr>
		</table>
		<s:form action="addNewCourseInfoAction" method="post"
			onsubmit="return check(this);">
			<s:hidden name="courseInfo.id"></s:hidden>
			<s:hidden name="courseInfo.course.id"></s:hidden>
			<s:hidden name="sort"></s:hidden>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						添加课程简介：
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
						<s:textfield id="title" name="courseInfo.title" cssClass="input" size="100"/>
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
					<td colspan="10">
						<FCK:editor instanceName="courseInfo.content" width="100%"
							height="405" toolbarSet="Default">
							<jsp:attribute name="value">
<s:property escape="false" value="courseInfo.content" />
                </jsp:attribute>
						</FCK:editor>
					</td>
				</tr>
				<tr class=editHeaderTr>
					<td width="30%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="70%">
						<s:submit id="submit" cssClass="label" value="确认" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
</div>
	</body>
</html>