<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>发布主题-师生留言-厦门大学课程网络平台</title>
<script type="text/javascript">
function check(form) {
		if (form.title.value == "") {
			alert("标题不能为空！");	
			form.title.focus();	
			return false;
		}	
		var oEditor = FCKeditorAPI.GetInstance("message.content");
   		if(oEditor.GetXHTML(true) == "")
   		{
   			alert("内容不能为空！");
			return false;
   		}		
		return true;
}
</script>
		<style type="text/css">
.txt,.txtarea {
	padding: 2px; *
	padding: 0 2px;
	height: 16px; *
	height: 20px;
	border: 1px solid;
	border-color: #999 #CCC #CCC #999;
	background: #FFF;
	width: 500px;
}
</style>
	</head>

	<body style="width: 600">
		<div
			style="padding-left: 10px; padding-right: 10px; padding-top:5px; background-color: #F1F5FA">
			<s:form action="addNewMessageByTeaAction" method="post" id="myform"				
				onsubmit="return check(this);">
				<table cellpadding="0" cellspacing="0" width="600" align=center>
					<tr>
						<td>
							<font color="#0099CC" style="font-size: 15px; font-weight: bold">&nbsp;发新主题</font>
						</td>
					</tr>
					<tr>
						<td style="padding: 5px 10px 5px 0;">
							&nbsp;&nbsp;标题：
							<s:textfield cssClass="txt" id="title" name="topic.name"></s:textfield>
						</td>
					</tr>
					<tr
						style="border-color: #999999 #CCCCCC #CCCCCC #999999; border-style: solid; border-width: 1px;">
						<td>
							<FCK:editor instanceName="message.content" width="100%"
								height="405" toolbarSet="Default">
								<jsp:attribute name="value">
                            </jsp:attribute>
							</FCK:editor>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="发新主题"></s:submit>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</body>
</html>
