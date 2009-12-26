<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>发布新闻政策</title>
<script language="Javascript" src="../../htmlbox/jquery-1.3.2.min.js" type="text/javascript"></script>
	<script language="Javascript" src="../../htmlbox/htmlbox.colors.js" type="text/javascript"></script>
	<script language="Javascript" src="../../htmlbox/htmlbox.styles.js" type="text/javascript"></script>
	<script language="Javascript" src="../../htmlbox/htmlbox.syntax.js" type="text/javascript"></script>
	<script language="Javascript" src="../../htmlbox/xhtml.js" type="text/javascript"></script>
	<script language="Javascript" src="../../htmlbox/htmlbox.min.js" type="text/javascript"></script>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>

	<body>
		<textarea id='ha'></textarea>
<script language="Javascript" type="text/javascript">
$("#ha").css("height","100%").css("width","100%").htmlbox({
    toolbars:[
	    [
		// Cut, Copy, Paste
		"separator","cut","copy","paste",
		// Undo, Redo
		"separator","undo","redo",
		// Bold, Italic, Underline, Strikethrough, Sup, Sub
		"separator","bold","italic","underline","strike","sup","sub",
		// Left, Right, Center, Justify
		"separator","justify","left","center","right",
		// Ordered List, Unordered List, Indent, Outdent
		"separator","ol","ul","indent","outdent",
		// Hyperlink, Remove Hyperlink, Image
		"separator","link","unlink","image"
		
		],
		[// Show code
		"separator","code",
        // Formats, Font size, Font family, Font color, Font, Background
        "separator","formats","fontsize","fontfamily",
		"separator","fontcolor","highlight",
		],
		[
		//Strip tags
		"separator","removeformat","striptags","hr","paragraph",
		// Styles, Source code syntax buttons
		"separator","quote","styles","syntax"
		]
	],
	skin:"blue"
});
</script>
	</body>
</html>
