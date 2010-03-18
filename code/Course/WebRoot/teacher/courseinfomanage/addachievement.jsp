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
					alert("成果标题不能为空！");
					return false;
				}
				var time= dojo.widget.byId("time");
				if (time.getValue() == "")
				{
					alert("时间不能为空！");
					return false;
				}
				  var oEditor = FCKeditorAPI.GetInstance("achievement.content");
   				if(oEditor.GetXHTML(true) == "")
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
					当前位置: 我的课程 -&gt; 添加教学成果
				</td>
			</tr>
		</table>
		<s:form action="addAchievementAction" method="post"
			onsubmit="return check(this);"  enctype="multipart/form-data">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						添加教学成果：
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
						<s:textfield id="title" name="achievement.title" cssClass="input"
							size="100" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:head />
						<s:datetimepicker id="time" displayFormat="yyyy-MM-dd"
							name="achievement.time" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							内容：
						</div>
					</td>

					<td colspan="3">
						<FCK:editor instanceName="achievement.content" width="100%"
							height="405" toolbarSet="Default">
							<jsp:attribute name="value">				
                </jsp:attribute>
						</FCK:editor>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							附件：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:file id="upload" name="upload"></s:file>
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