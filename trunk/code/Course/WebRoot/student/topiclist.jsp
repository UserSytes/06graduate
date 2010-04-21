<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>我的留言-厦门大学课程中心</title>
		<link type=text/css rel=stylesheet href="${ctx}/homepage/link.css">
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
	$("#tbody tr:gt(" + 19+ ")").hide().end();
	$("#tbody").css("display","");  
		var num_entries = $("#tbody tr").length/2;
		// 创建分页
		$("#Pagination").pagination( {
				count:num_entries,
				pageCount:10,
				imagePath:"${ctx}/commons/images",
				callback:function(page_index){							
		 			$table.find("#tbody tr").show();               
          			$("#tbody tr:lt(" + (page_index-1) * 20 + ")").hide().end();                  
       				$("#tbody tr:gt(" + ((page_index) * 20 -1) + ")").hide().end();
			}
		});

});
</script>
	</head>
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		background="${ctx}/homepage/image/back_img.gif"
		style="background-repeat: repeat-x">

		<s:include value="../homepage/include/header.jsp"></s:include>
		<!-- left -->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr height="100%">
				<td width="200" align="center" valign="top">
					<s:include value="left.jsp"></s:include>
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
											<img src="${ctx}/homepage/image/title_mytopic.gif" border="0"
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
								<table border="0" cellpadding="0" cellspacing="0" width="95%">
									<tr>
										<td width="90%" align="left">
											<s:actionerror />
										</td>
									</tr>
								</table>
								<table width="95%"  id="table"  style="">
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
													<td width="150" align="center">
														课程
													</td>
													<td width="350" align="center">
														标题
													</td>
													<td width="50" align="center">
														回复
													</td>
													<td width="100" align="center">
														最后回复
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tbody id="tbody" style="display: none;">
									<s:iterator value="messageList" status="message">
										<tr>
											<td width="40" align="center">
												<s:property value="#message.count" />
											</td>
											<td width="150" align="center">
												<s:property value="topic.course.name" />
											</td>
											<td width="350" align="center">
												<a
													href="<s:url action="showMessagesAction"> 
																				<s:param name="topicId"> <s:property value="topic.id"/> </s:param> </s:url>">
													<font color="purple"> <s:property value="topic.name" />
												</font>
												</a>
											</td>
											<td width="50" align="center">
												<s:property value="topic.countPerson" />
											</td>
											<td width="100" align="center">
												<s:property value="topic.lastUpdate+topic.lastAnswer" />
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
		<s:include value="../homepage/include/bottom.jsp"></s:include>
	</body>
</html>