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
		<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.pagination.js"></script>
		<title>留言列表</title>
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
		function showTopicsByTime(time) {
			window.location.href = "showTopicsByTeacherAction.action?time="+time;
		}
</SCRIPT>
	</head>
	<body>
		<div id="content">
			<div style="width: 100%">
				<div>
					<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
						align=center border=0>
						<tr class=position bgcolor="#ECF3FD">
							<td>
								当前位置: 课程管理 -&gt; 留言管理
							</td>
						</tr>
					</table>
					<table class=listTable align="center">
						<tr>
							<td>
								请选择查询时间：&nbsp;&nbsp;&nbsp;
								<s:select name="time"
									list="#{0:'全部',1:'最近一天',3:'最近三天',7:'最近七天',30:'最近一月'}"
									listKey="key" listValue="value"
									onchange="javascript:showTopicsByTime(this.value)" />

							</td>
						</tr>
					</table>
					<div align=center>

						<table id="table" class="listTable" style="">
							<tr class="listHeaderTr"
								<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>

								<th width="4%">
									&nbsp;
								</th>								
								<th width="40%" align="left">
									标题
								</th>
								<th width="12%" align="center">
									所属课程
								</th>

								<th width="18%" align="center">
									作者
								</th>
								<th width="8%" align="center">
									回复/查看
								</th>
								<th width="18%" align="center">
									最后发表
								</th>
							</tr>
				<tbody id="tbody" style="display: none;">
							<s:iterator value="topicList" status="topic">
								<tr class="listTr">
									<td align="center">
										<img src="${ctx}/coursepage/images/folder_new.gif" border="0"
											alt="新帖" />
									</td>
									
									<td align="left">
										<a
											href="<s:url action="showMessagesByTeaAction"> 
		<s:param name="topicId"> 
		<s:property value="id"/> 
		</s:param>
		</s:url>">
											<font color="green"> <s:property value="name" />
										</font> </a>

									</td>
									<td align="center">
										<s:property value="course.name" />
									</td>
									<td align="center">
										<s:property value="authorName" />
										<s:date name="time" format="yyyy-MM-dd" />
									</td>
									<td align="center">
										<s:property value="countReply" />
										/
										<s:property value="countPerson" />
									</td>
									<td align="center">
										<s:property value="lastAnswer" />
										<s:date name="lastUpdate" format="yyyy-MM-dd" />
									</td>
								</tr>
							</s:iterator></tbody>
						</table>
			<div id="Pagination" class="pagination"></div>
					</div>

				</div>
			</div>
		</div>
	</body>
</html>