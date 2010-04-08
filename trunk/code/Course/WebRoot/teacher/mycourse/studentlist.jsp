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
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />		
	
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
	   <script type="text/javascript" src="${ctx}/js/thickbox2.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.pagination.js" charset="gbk"></script>
		<title>学生列表</title>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}

.profile_pic {
	width: 60px;
	line-height: 1px;
}

.profile_pic a:hover {
	text-decoration: none;
}
-->
</style>
		<script type="text/javascript">
$(function(){
	//这是一个非常简单的demo实例，让列表元素分页显示
	//回调函数的作用是显示对应分页的列表项内容
	//回调函数在用户每次点击分页链接的时候执行
	//参数page_index{int整型}表示当前的索引页
	var initPagination = function() {
	
	$("#tbody tr:gt(" + 3 + ")").hide().end();
	$("#tbody").css("display","");  
		var num_entries = $("#table tbody tr").length;

		// 创建分页
		$("#Pagination").pagination( {
				count:num_entries,
				pageCount:4,
				imagePath:"${ctx}/commons/images",
				callback: pageselectCallback,
		});
	 }();

	 
	function pageselectCallback(page_index, jq){
		 var $table = $('#table');		
		 $table.find("#tbody tr").show();               
         $("#tbody tr:lt(" + (page_index-1) * 4 + ")").hide().end();                  
         $("#tbody tr:gt(" + ((page_index) * 4 -1) + ")").hide().end();
	}
});
</script>
	</head>
	<body>
		

		</div>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程管理 -&gt; 课程列表 -&gt;
					<s:text name="">${course.name}</s:text>
					-&gt; 学生列表
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
						照片
					</th>
					<th>
						姓名 学号
					</th>
					<th>
						年级
					</th>
					<th>
						院系
					</th>
					<th>
						联系方式
					</th>
					<th>
						操作
					</th>
				</tr>
<tbody id="tbody" style="display:none;">
					<s:iterator value="studentList" status="student">
						<tr class="listTr">
							<td width="5%">
								<s:property value="#student.count" />
							</td>
							<td width="24">
								<a href="${ctx}/upload/<s:property value="userInfo.photo"/>"
									title="" class="thickbox"> <img width="48"
										src="${ctx}/upload/<s:property value="userInfo.photo"/>" /> </a>
							</td>
							<td width="20%">
								<s:property value="userInfo.name" />
								<br>
								<s:property value="studentNo" />
							</td>
							<td width="15%">
								<s:property value="grade.name" />
								<br>
								<s:property value="grade.grade" />
								级


							</td>
							<td width="15%">
								<s:property value="userInfo.department.school.name" />
								<br>
								<s:property value="userInfo.department.name" />
							</td>
							<td width="20%">
								Email:
								<s:property value="userInfo.mobile" />
								<br>
								电&nbsp;话:
								<s:property value="userInfo.email" />
							</td>
							<td width="20%">
								<a
									href="<s:url action="goSendNewMailAction"> 
                     			<s:param name="studentId"> 
                       			 	<s:property value="id"/> 
                    			</s:param>								
                					</s:url>">
									<font color="green">【发站内信】</font> </a>
								<br>
								<a
									href="<s:url action="deleteStudentFromCourseAction"> 
                     			<s:param name="studentId"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
								<s:param name="courseId"> 
                       			 	${course.id}
                    			</s:param>  
                					</s:url>"
									onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
									<font color="red">【从该课程删除】</font> </a>
							</td>
						</tr>
				</s:iterator>
</tbody>
				</div>
			</table>
<div id="Pagination" class="pagination">
			<!-- 这里显示分页 -->
		</div>
		</div>
	</body>
</html>