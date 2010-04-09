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
		<title>申报课程列表</title>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
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
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程管理 -&gt; 申报课程列表
				</td>
			</tr>
		</table>
		<div align="center">
			<table id="table" class="listTable" style="">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						序号
					</th>
					<th>
						课程名
					</th>
					<th>
						教师
					</th>
					<th>
						简介
					</th>
					<th>
						操作
					</th>
				</tr>
				<tbody id="tbody" style="display: none;">
					<s:iterator value="applicationCourseList" status="course">
						<tr class="listTr">
							<td width="5%">
								<s:property value="#course.count" />
							</td>
							<td width="20%">
								<s:property value="name" />
							</td>
							<td width="10%">
								<s:property value="teacher.userInfo.name" />
							</td>
							<td width="45%">
								<s:property value="remark" />
							</td>
							<td width="20%">
								<a
									href="<s:url action="passInfoAction">
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
									<font color="green">【通过】</font> </a>
								<a
									href="<s:url action="refuseReasonAction" >
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
									<font color="red">【退回】</font> </a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tr class="listFooterTr">

				</tr>
			</table>
			<div id="Pagination" class="pagination"></div>

			<table bgcolor="white" class=editTable cellSpacing=1 cellPadding=0
				width="90%" align=center border=0>
				<TR>
					<td bgcolor="white">
						<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
						<strong><font color="red" size="3"> 提示</font> </strong>
						<div id="content_note">
							<ul>
								<li>
									本院所有教师申请新的课程需要等待您审核通过才能进行教学资料上传。
								</li>
								<li>
									若课程审核通过系统将提示教师可以正式开设该课程，并开始上传教学资料、课件等。
								</li>
								<li>
									若课程审核未通过，需要您填写理由，系统自动将退回理由传达给教师。
								</li>
							</ul>
						</div>
					</td>
				</TR>
			</table>
	</body>
</html>