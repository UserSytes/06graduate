<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${ctx}/js/jquery.pagination.js"></script>
<script type="text/javascript">
	$(document).ready( function() {
		//这是一个非常简单的demo实例，让列表元素分页显示
			//回调函数的作用是显示对应分页的列表项内容
			//回调函数在用户每次点击分页链接的时候执行
			//参数page_index{int整型}表示当前的索引页
			var $table = $('#table');
			$("#tbody tr:gt(" + 19 + ")").hide().end();
			$("#tbody").css("display", "");
			var num_entries = $("#tbody tr").length / 2;
			// 创建分页
			$("#Pagination").pagination(
					{
						count :num_entries,
						pageCount :10,
						imagePath :"${ctx}/commons/images",
						callback : function(page_index) {
							$table.find("#tbody tr").show();
							$("#tbody tr:lt(" + (page_index - 1) * 20 + ")")
									.hide().end();
							$("#tbody tr:gt(" + ((page_index) * 20 - 1) + ")")
									.hide().end();
						}
					});

		});
</script>
<table width="90%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="90%" align="left">
			<s:actionmessage />
		</td>
	</tr>
</table>
<table id="table" width="96%" cellpadding="0" cellspacing="0">
	<tr height="40">
		<td colspan="6" background="${ctx}/homepage/image/bbs_bg.gif">
			<table border="0" cellpadding="0" cellspacing="0"
				style="height: 23px;" width="100%">
				<tr height="1">
					<td bgcolor="#d7d7d7" colspan="6" width="100%"></td>
				</tr>
				<tr>
					<td width="40" align="center">
						序号
					</td>
					<td width="350" align="center">
						课程名
					</td>
					<td width="60" align="center">
						教师
					</td>
					<td width="120" align="center">
						所属系
					</td>
					<td width="80" align="center">
						级别
					</td>
					<td width="40" align="center">
						点击
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tbody id="tbody" style="display: none;">
		<s:iterator value="courseList" status="course">
			<tr>
				<td width="40" align="center">
					<s:property value="#course.count" />
				</td>
				<td width="350" align="center">
					<a
						href="<s:url action="enterCourseAction"> 
																				<s:param name="courseId"> <s:property value="id"/> </s:param> </s:url>">
						<s:property value="name" /> </a>
				</td>
				<td width="60" align="center">
					<s:property value="teacher.userInfo.name" />
				</td>
				<td width="120" align="center">
					<s:property value="department.name" />
				</td>
				<td width="80" align="center">
					<s:property value="level" />
				</td>
				<td width="40" align="center">
					<s:property value="count" />
				</td>
			</tr>
			<tr height="3">
				<td colspan="6" background="${ctx}/homepage/image/table_line.gif"></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
<div id="Pagination" class="pagination" style="float: right"></div>
