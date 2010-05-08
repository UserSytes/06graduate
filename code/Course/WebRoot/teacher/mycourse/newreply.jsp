<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>回复主题-<s:property value="topic.name" />-师生留言-厦门大学课程网络平台</title>
	<script type="text/javascript">
function check(form) {			
		var oEditor = FCKeditorAPI.GetInstance("message.content");
   		if(oEditor.GetXHTML(true) == "")
   		{
   			alert("内容不能为空！");
			return false;
   		}		
   		form.submit.disabled = true;	
		return true;
}
</script>
</head>
	<body style="width: 600">
		<div
			style="padding-left: 10px; padding-right: 10px; padding-top: 5px; padding-bottom:  5px; background-color: #F1F5FA">
			<!-- 左侧 -->
			<!-- 正文 -->
			<s:form action="addReplyByTeaAction" method="post" id="myform"
				onsubmit="return check(this);">
				<s:hidden name="topic.id"></s:hidden>
				<table cellpadding="0" cellspacing="0" width="600" align=center
					border=0 >
					<tr>
						<td>
							<font color="#0099CC" style="font-size: 15px; font-weight: bold">&nbsp;回复主题</font>
						</td>
					</tr>
					<tr
						style="border-color: #999999 #CCCCCC #CCCCCC #999999; border-style: solid; border-width: 1px;">
						
						<td>
							<FCK:editor instanceName="message.content" width="100%"
								height="405" toolbarSet="Default">
								<jsp:attribute name="value">
								<s:text name="">${replyString}</s:text>
                            </jsp:attribute>
							</FCK:editor>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit id="submit" cssClass="label" value="发表回复"></s:submit>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

	</body>
</html>
