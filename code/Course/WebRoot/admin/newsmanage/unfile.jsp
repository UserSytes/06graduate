<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<script type="text/javascript">
	var jj=0;
	<!--��̬�����ϴ�����-->
	function addFile11(){
	 currRow=conditionTable.insertRow();
     cellc=currRow.insertCell();
     cellcContext= "<input type='File' NAME='myFile'>&nbsp;&nbsp;<button onclick='removeFile();'>ɾ��</button><br>";
     cellc.innerHTML=cellcContext;
     
     //alert(cellcContext);
	    
	}
	<!--�ڱ��td������-->
	function findTD(o){
if (o.nodeName=="TR"||o.nodeName=="TABLE") return;
if(o.nodeName=="TD")
return (o);
else
return (o.parentElement);
}

<!--ɾ��һ������-->
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
				<a href="javascript:addFile11();">��Ӹ���</a>
			</div>
			<div align="left">
				<s:submit value="�ϴ�"></s:submit>
			</div>
		</s:form>
	</body>
</html>