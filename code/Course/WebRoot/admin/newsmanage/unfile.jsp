<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<script type="text/javascript">
	var jj=0;
	<!--动态增加上传附件-->
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

	</head>

	<body>
		<s:form id="myform" name="myform" namespace="/upLoadFile"
			action="upFile" method="post" target="_self"
			enctype="multipart/form-data">
			<table>
				<tr>
					ddddd
				</tr>
			</table>
			<div>
				<table id=conditionTable border=1>
				</table>
				<a href="javascript:addFile11();">添加附件</a>
			</div>
			<div align="left">
				<s:submit value="上传"></s:submit>
			</div>
		</s:form>
	</body>
</html>