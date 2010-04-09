<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程网站——搜索课程</title>
		<link rel="stylesheet" href="${ctx}/homepage/link.css">
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
</head>
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		background="${ctx}/homepage/image/back_img.gif"
		style="background-repeat: repeat-x">

		<s:include value="include/header.jsp"></s:include>
		<!-- left -->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr height="100%">
				<td width="200" align="center" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<img src="${ctx}/homepage/image/left_menu_title5.gif"
												border="0">
										</td>
									</tr>
									<tr>
										<td>
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td width="11" background=""></td>
													<td width="172" align="center">
														<a href="<s:url action="lastCourseAction"></s:url>">
															<img src="${ctx}/homepage/image/left_menu_06.gif" border="0">
														</a>
													</td>
													<td width="11" background=""></td>
												</tr>
												<tr>
													<td width="11" background=""></td>
													<td width="172" align="center">
														<a href="<s:url action="lastWeekCourseAction"></s:url>">
															<img src="${ctx}/homepage/image/left_menu_07.gif" border="0">
														</a>
													</td>
													<td width="11" background=""></td>
												</tr>
												<tr>
													<td width="11" background=""></td>
													<td width="172" align="center">
														<a href="<s:url action="lastMonthCourseAction"></s:url>">
															<img src="${ctx}/homepage/image/left_menu_08.gif" border="0">
														</a>
													</td>
													<td width="11" background=""></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<img src="${ctx}/homepage/image/jiannan.jpg" border="0">
										</td>
									</tr>
								</table>

							</td>
						</tr>
					</table>
					<!--/left -->
				</td>
				<td width="750" valign="top" align="right">
					<!-- main -->
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- main2 主题图 -->
							<td valign="top">
								<img src="${ctx}/homepage/image/main_img2.jpg" border="0">
							</td>
							<!--/main2 主题图 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr height="27">
							<!-- 主题 -->
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="11"></td>
										<td>
											<img src="${ctx}/homepage/image/title_last<s:property value="imageNum" />.gif" border="0"
												alt="">
										</td>
									</tr>
									<tr height="3">
										<td width="11"></td>
										<td bgcolor="#d7d7d7" width="738"></td>
									</tr>
								</table>
							</td>
							<!--/ 主题 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr>
							<td valign="top" align="center">
								<!-- 内容 -->
                             <table width="90%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td width="90%" align="left"><s:actionmessage /></td>
										</tr>
							</table>
							<table width="96%" id="table" style="">
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
													<td width="80" align="center">
														发布时间
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
													<s:property value="name" />
												</a>
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
											<td width="80" align="center">
												<s:date name="time" format="yyyy.MM.dd" />
											</td>
										</tr>
										<tr height="3">
											<td colspan="6"
												background="${ctx}/homepage/image/table_line.gif"></td>
										</tr>
									</s:iterator></tbody>
								</table>
								<div id="Pagination" class="pagination"></div>
							</td>
						</tr>
					</table>

					<!-- /内容 -->
				</td>
			</tr>
		</table>
	

		<!-- 底部 -->
		<s:include value="include/bottom.jsp"></s:include>
	</body>
</html>