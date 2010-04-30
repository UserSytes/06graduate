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
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>教师队伍列表</title>
		<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.pagination.js"></script>
		<script type="text/javascript">
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
		<SCRIPT language=javascript>
			function popwin(url)
			{
			window.open(url);
			}
			function goToAddteacherTeam(){
			 window.location.href="courseinfomanage/addteacherteam.jsp";
			}

		</SCRIPT>
	</head>
	<body>
		<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 我的课程 -&gt; 教师队伍列表
				</td>
				<td width="30">
					<div align="right">
						<input type="button" onclick="goToAddteacherTeam()" value="添加教师队伍" />
					</div>
				</td>
			</tr>
		</table>
		
			<table id="table" class="listTable" style="">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						名字
					</th>
					<th>
						职称
					</th>
					<th>
						研究领域
					</th>
					<th>
						链接
					</th>
					<th>
						备注
					</th>
					<th>
						操作
					</th>
				</tr>
				<tbody id="tbody" style="display: none;">
				<s:iterator value="teacherTeamList" status="teacherTeam">
					<tr class="listTr">
						<td>
							<s:property value="name" />
						</td>
						<td>
							<s:property value="position" />
						</td>
						<td>
							<s:property value="field" />
						</td>
						<td>
							<a href="javascript:popwin('${link}')"><s:property id="link"
									value="link" /> </a>
						</td>
						<td>
							<s:property value="remark" />
						</td>
						<td>
							<a
								href="<s:url action="goEidtTeacherTeamAction"> 
                     			<s:param name="teacherTeamId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【编辑】</font> </a>
							<a
								href="<s:url action="deleteTeacherTeamAction"> 
                     			<s:param name="teacherTeamId"> 
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
			<div id="Pagination" class="pagination"></div>
		</div>
	</body>
</html>