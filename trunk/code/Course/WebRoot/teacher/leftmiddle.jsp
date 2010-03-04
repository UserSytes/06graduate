<html xmlns="http://www.w3.org/1999/xhtml">

	<%@ include file="../commons/taglibs.jsp"%>
	<head>
		<%@ page language="java" contentType="text/html; charset=UTF-8"
			pageEncoding="UTF-8"%>
		<title>无标题文档</title>

	</head>
<script language="javascript">
<!--
var displayBar=true;
function switchBar(obj){
	if (displayBar)
	{
		parent.frame.cols="0,6,*";
		displayBar=false;
		obj.title="打开左边管理菜单";
	}
	else{
		parent.frame.cols="156,6,*";
		displayBar=true;
		obj.title="关闭左边管理菜单";
	}
}
//-->
</script>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="6" valign="middle" background="images/main_27.gif"
					onclick=switchBar(this)>
					<SPAN class=navPoint id=switchPoint title=关闭/打开左栏><img
							src="images/main_30.gif" name="img1" width=6 height=70 id=img1>
					</SPAN>
				</td>
			</tr>
		</table>

	</body>
</html>
