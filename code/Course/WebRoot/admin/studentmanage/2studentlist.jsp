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
		<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.pagination.js"></script>
		<title>学生列表</title>
		<script language="javascript">
	function getStudent(type) {
	    if(type == 1){
			document.getElementById("search1").style.display="block";
			document.getElementById("search2").style.display="none";	
		}else{
			document.getElementById("search1").style.display="none";
			document.getElementById("search2").style.display="block";	
		}	
	}
	
	$(document).ready(function(){
	//这是一个非常简单的demo实例，让列表元素分页显示
	//回调函数的作用是显示对应分页的列表项内容
	//回调函数在用户每次点击分页链接的时候执行
	//参数page_index{int整型}表示当前的索引页
	var $table = $('#table');
	$("#tbody tr:gt(" + 9+ ")").hide().end();
	$("#tbody").css("display","");  
		var num_entries = $("#tbody tr").length;
		// 创建分页
		$("#Pagination").pagination( {
				count:num_entries,
				pageCount:10,
				imagePath:"${ctx}/commons/images",
				callback:function(page_index){							
		 			$table.find("#tbody tr").show();               
          			$("#tbody tr:lt(" + (page_index-1) * 10 + ")").hide().end();                  
       				$("#tbody tr:gt(" + ((page_index) * 10 -1) + ")").hide().end();
			}
		});

});
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
					当前位置: 学生管理 -&gt; 学生列表
				</td>
			</tr>
		</table>

		<table class=listTable align="center">
			<tr>
				<td>
					请选择查询条件：&nbsp;&nbsp;&nbsp;
					<s:select name="type" list="#{1:'帐号',0:'年级专业'}" listKey="key"
						listValue="value" onchange="javascript:getStudent(this.value)" />

				</td>
			</tr>
		</table>

		<div align="center" id="search1">
			<s:form action="findStudentByNoAction" method="post">
				<table class="listTable">
					<tr class=editHeaderTr>
						<td class=editHeaderTd colSpan=7>
							查找学生
						</td>
					</tr>
					<tr>
						<td bgcolor="#FFFDF0">
							<div align="center">
								请输入学生帐号：
							</div>
						</td>
						<td colspan="3" bgcolor="#FFFFFF">
							&nbsp;&nbsp;&nbsp;
							<s:textfield cssClass="INPUT" id="studentNo" size="30"
								name="studentNo" label="账号"></s:textfield>
						</td>
					</tr>
					<tr bgcolor="#ECF3FD">
						<td width="20%">
							&nbsp;
						</td>
						<td width="80%">
							<s:submit cssClass="label" value="查找"></s:submit>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
		<div align="center" id="search2" style="display: none;">
			<s:form action="findStudentByGradeAction" method="post">
				<table class="listTable">
					<tr class=editHeaderTr>
						<td class=editHeaderTd colSpan=7>
							查找学生
						</td>
					</tr>
					<tr>
						<td bgcolor="#FFFDF0">
							<div align="center">
								请选择筛选年级：
							</div>
						</td>
						<td colspan="3" bgcolor="#FFFFFF">
							&nbsp;&nbsp;&nbsp;
							<s:select name="gradeId" list="gradeList" headerKey="-1"
								headerValue="所有" listKey="id" listValue="name+grade" />
						</td>
					</tr>
					<tr>
						<td bgcolor="#FFFDF0">
							<div align="center">
								请选择筛选系：
							</div>
						</td>
						<td colspan="3" bgcolor="#FFFFFF">
							&nbsp;&nbsp;&nbsp;
							<s:select name="departmentId" list="departmentList"
								headerKey="-1" headerValue="所有" listKey="id" listValue="name" />
						</td>
					</tr>
					<tr bgcolor="#ECF3FD">
						<td width="20%">
							&nbsp;
						</td>
						<td width="80%">
							<s:submit cssClass="label" value="查找"></s:submit>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
		<div align="center">
			<s:hidden name="studentList" />
			<table id="table" class="listTable" style="">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						序号
					</th>
					<th>
						姓名
					</th>
					<th>
						性别
					</th>
					<th>
						账号
					</th>
					<th>
						年级
					</th>
					<th>
						所属系
					</th>
					<th>
						操作
					</th>
				</tr>
				<tbody id="tbody" style="display: none;">
					<s:iterator value="studentList" status="student">
						<tr class="listTr">
							<td width="5%">
								<s:property value="#student.count" />
							</td>
							<td width="15%">
								<s:property value="userInfo.name" />
							</td>
							<td width="5%">
								<s:property value="userInfo.sex" />
							</td>
							<td width="20%">
								<s:property value="studentNo" />
							</td>
							<td width="15%">
								<s:property value="grade.name+grade.grade" />
							</td>
							<td width="20%">
								<s:property value="userInfo.department.name" />
							</td>
							<td width="20%">
								<a
									href="<s:url action="goEditStudentAction"> 
                     			<s:param name="studentId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
									<font color="green">【修改】</font> </a>
								<a
									href="<s:url action="deleteStudentAction"> 
                     			<s:param name="studentId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"
									onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
									<font color="red">【删除】</font> </a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div id="Pagination" class="pagination">
			</div>
		</div>
	</body>
</html>