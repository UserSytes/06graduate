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
			function check(form)
			{
				if (form.title.value == "")
				{
					alert("学院名不能为空！");
					return false;
				}
				if (form.anthor.value == "")
				{
					alert("作者不能为空！");
					return false;
				}
				return true;
				
			}
</SCRIPT>
		<script type="text/javascript">
function cancelFile(){
document.forms["newsForm"].reset();
document.getElementById("attachmentDiv").style.display="block";
document.getElementById("conditionTable").style.display="none";
		 document.getElementById("continue").style.display="none";		
		 document.getElementById("cancel").style.display="none";
		 document.getElementById("replay").style.display="block";
var t=doucument.getElementById(conditionTable); 
  t.parent.remove(t); 
}
		var jj=0;
		<!--动态增加上传附件-->
		function readdFile1(){
		 document.getElementById("replay").style.display="none";
		 document.getElementById("attachmentDiv").style.display="none";
		 document.getElementById("conditionTable").style.display="block";
		 document.getElementById("continue").style.display="block";		
		 document.getElementById("cancel").style.display="block";		 
	 currRow=conditionTable.insertRow();
     cellc=currRow.insertCell();
     cellcContext= "<input type='File' NAME='myFile'>&nbsp;&nbsp;<button onclick='removeFile();'>删除</button><br>";
     cellc.innerHTML=cellcContext;
     
     //alert(cellcContext);
	    
	}
	function addFile11(){
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

		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>

	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 新闻政策管理 -&gt; 发布新闻政策
				</td>
			</tr>
		</table>
		<s:form id="newsForm" action="editNewsAction" method="post"
			onsubmit="return check(this);" enctype="multipart/form-data">
			<s:hidden name="news.id"></s:hidden>
			<s:hidden name="news.time"></s:hidden>
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
						<s:textfield cssClass="INPUT" id="title" name="news.title"
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
						<s:textfield cssClass="INPUT" id="author" name="news.author"
							label="作者"  size="30"></s:textfield>
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
							<s:property escape="false" value="news.content" />
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
						<div id=attachmentDiv>
							<s:iterator value="attachmentList" status="attachment">
								<img src="${ctx}/admin/Images/i_attach.gif" />
								<a
									href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="fileLink"/> 
                    			</s:param> 
								<s:param name="originalFileName"> 
                       			 	<s:property value="filename"/> 
                    			</s:param> 
                					</s:url>">
									<font color="blue"><s:property value="filename" /> </font> </a>
							</s:iterator>
						</div>
						<table id=conditionTable border=0>
						</table>
						<a href="javascript:readdFile1();" id="replay">重新上传</a>
						<a href="javascript:addFile11();" id="continue"
							style="display: none">继续上传</a>
						<a href="javascript:cancelFile();" id="cancel"
							style="display: none">
							取消上传</a>
					</td>
				</tr>
				<tr bgcolor="#ECF3FD">
					<td width="15%">
						&nbsp;
					</td>
					<td width="85%">
						<s:submit cssClass="label" value="确定修改"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
