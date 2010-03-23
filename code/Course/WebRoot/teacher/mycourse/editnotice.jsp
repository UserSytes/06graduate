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
		<title>添加教学成果</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if(form.title.value == "")
				{
					alert("课程通知标题不能为空！");
					return false;
				}				
				if (form.courseId.value == -1)
				{
					alert("请先选择一门课程！");
					return false;
				}
				  var oEditor = FCKeditorAPI.GetInstance("achievement.content");
   				if(oEditor.(true) == "")
   				{
   					alert("内容不能为空！");
					return false;
   				}			
									
			}
		</SCRIPT>
	</head>

	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position>
				<td>
					当前位置: 课程通知 -&gt; 编辑课程通知
				</td>
			</tr>
		</table>
		<s:form action="updateNoticeAction" method="post"
			onsubmit="return check(this);">
			<s:hidden name="notice.id"></s:hidden>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						编辑课程通知：
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							课程：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select id="courseId" name="courseId" list="courseList"
							listKey="id" listValue="name"/>
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
						<s:textfield id="title" name="notice.title" cssClass="input"
							size="100" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							类别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="notice.sort" list="#{0:'课程通知',1:'课程公告'}"
						listKey="key" listValue="value"/>
					</td>
				</tr>				
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							内容：
						</div>
					</td>

					<td colspan="3">
						<FCK:editor instanceName="notice.content" width="100%"
							height="405" toolbarSet="Default">
						<jsp:attribute name="value">
								<s:property escape="false" value="notice.content" />
              				  </jsp:attribute>
						</FCK:editor>
					</td>
				</tr>				
				<tr class=editHeaderTr>
					<td width="10%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="90%">
						<s:submit cssClass="label" value="确认" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>