<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
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
		<SCRIPT language=javascript>
	function check(form) {
		if (form.title.value == "") {
			alert("新闻标题不能为空！");
			return false;
		}
		if (form.anthor.value == "") {
			alert("作者不能为空！");
			return false;
		}
		return true;

	}
</SCRIPT>
		<script type="text/javascript">
		var jj=0;
		<!--动态增加上传附件-->
		function addFile11(){
		document.getElementById("conditionTable").style.display="block";
	 currRow=conditionTable.insertRow();
     cellc=currRow.insertCell();
     cellcContext= "<input type='File' NAME='myFile'>&nbsp;&nbsp;<button onclick='removeFile();'>删除</button><br>";
     cellc.innerHTML=cellcContext;
     
     //alert(cellcContext);
	    
	}
	<!--在表的td中增加-->
	function findTD(o){
if (o.nodeName=="TR"||o.nodeName=="TABLE") return;
if(o.nodeName=="TD")
return (o);
else
return (o.parentElement);
}

<!--删除一个附件-->
function removeFile(){
  o = findTD(event.srcElement);
  //alert(o.parentElement.rowIndex*1);
conditionTable.deleteRow(o.parentElement.rowIndex*1);


}
</script>
	</head>
	<body>
		<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 新闻政策管理 -&gt; 发布新闻政策
				</td>
			</tr>
		</table>
		<s:form action="addNewsAction" method="post" id="myform" name="myform"
			namespace="/upLoadFile" target="_self" enctype="multipart/form-data" onsubmit="return check(this);">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新闻信息
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							标题：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<s:textfield cssClass="LONGINPUT" id="title" name="news.title"
							label="标题"  size="80"></s:textfield>
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							作者：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<s:textfield cssClass="LONGINPUT" id="author" name="news.author"
							label="作者"  size="30" value="厦门大学"></s:textfield>
						&nbsp;*
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							内容：
						</div>
					</td>
					<td colspan="4" bgcolor="#FFFFFF">
						<FCK:editor instanceName="news.content" width="100%" height="405"
							toolbarSet="Default">
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
					<td bgcolor="#FFFFFF">
						<table id=conditionTable border=0  style="display: none">
						</table>
						<a href="javascript:addFile11();">添加附件</a>
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
	</body>
</html>
