<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>发布新帖&lt;--厦门大学精品课程</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="${ctx}/css/teachermsg.css" rel="stylesheet"
			type="text/css" />
<SCRIPT language=javascript>
	function checkAll()   
   {   
        var oEditor = FCKeditorAPI.GetInstance('content');   
        var checkContent = oEditor.GetXHTML();   
       if(checkContent == "")   
       {   
           	alert("回复内容不能为空！");   
			oEditor.SetHTML("");
           	oEditor.Focus();   
            return false;   
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
<table style="FONT-SIZE: 15px;" class=editTable cellSpacing=1
			cellPadding=0 width="100%" align=center border=1>
			<tr style="HEIGHT: 25px; BACKGROUND-COLOR: #b0e0e6">
				<td>
					当前位置: 课程管理 -&gt; 留言管理 -&gt; 回复留言
				</td>
			</tr>
		</table>
		<div id="content"  style="width: 100%">
			<div>
<s:form action="addReplyByTeacherAction" method="post" id="myform" name="myform"
			target="_self" enctype="multipart/form-data" onsubmit="return checkAll();">
			<s:hidden name="topic.id" ></s:hidden>
			<table class=editTable cellSpacing=1 cellPadding=0 width="80%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请编辑回复内容
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
	</body>
</html>