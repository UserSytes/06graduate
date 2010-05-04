<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>厦门大学精品课程</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="${ctx}/css/teachermsg.css" rel="stylesheet"
			type="text/css" />
		<link href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<link href="${ctx}/facebox/facebox.css" media="screen"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.pagination.js"></script>
		<script src="${ctx}/facebox/facebox.js" type="text/javascript"></script>
		<script type="text/javascript">
	function check(form) {
		if (form.messagecontent.value == "") {
			alert("内容不能为空！");
			return false;
		}
		return true;

	}
</script>
		<script type="text/javascript">
$(document).ready(function(){
	//这是一个非常简单的demo实例，让列表元素分页显示
	//回调函数的作用是显示对应分页的列表项内容
	//回调函数在用户每次点击分页链接的时候执行
	//参数page_index{int整型}表示当前的索引页
	var $table = $('#table');
	$("#tbody tr:gt(" + 39+ ")").hide().end();
	$("#tbody").css("display","");  
		var num_entries = $("#tbody tr").length/4;
		// 创建分页
		$("#Pagination").pagination( {
				count:num_entries,
				pageCount:10,
				imagePath:"${ctx}/commons/images",
				callback:function(page_index){							
		 			$table.find("#tbody tr").show();               
          			$("#tbody tr:lt(" + (page_index-1) * 40 + ")").hide().end();                  
       				$("#tbody tr:gt(" + ((page_index) * 40 -1) + ")").hide().end();
			}
		});
		$('a[rel*=facebox]').facebox( {
			loading_image :'${ctx}/facebox/loading.gif',
			close_image :'${ctx}/facebox/closelabel.gif'
		})
});
</script>
		<style type="text/css">
quote\:msgheader {
	BORDER-BOTTOM: #e7e7e7 1px solid;
	BORDER-LEFT: #e7e7e7 1px solid;
	PADDING-BOTTOM: 5px;
	MARGIN: 0px 1em;
	PADDING-LEFT: 5px;
	PADDING-RIGHT: 5px;
	BACKGROUND: #f3f8d7;
	COLOR: #000000;
	BORDER-TOP: #e7e7e7 1px solid;
	FONT-WEIGHT: bold;
	BORDER-RIGHT: #e7e7e7 1px solid;
	PADDING-TOP: 5px
}

quote\:msgborder {
	BORDER-BOTTOM: #e7e7e7 1px solid;
	BORDER-LEFT: #e7e7e7 1px solid;
	PADDING-BOTTOM: 10px;
	MARGIN: 0px 1em;
	PADDING-LEFT: 10px;
	WIDTH: 100%;
	PADDING-RIGHT: 10px;
	WORD-WRAP: break-word;
	BACKGROUND: #fdfff2;
	OVERFLOW: hidden;
	BORDER-TOP: 0px;
	BORDER-RIGHT: #e7e7e7 1px solid;
	PADDING-TOP: 10px
}

.delete {
	background: url(${ctx}/teacher/img/del.png) no-repeat
		0 50%;
	padding: 5px 10px 5px 25px;
	color: #999;
}

div,span,p,ul,li {
	text-align: left;
}

a {
	text-decoration: none;
}
</style>
	</head>
	<body>
		<div align="center"
			style="padding-left: 5px; padding-right: 5px; width: 98%">
			<table cellSpacing=1 cellPadding=0 width="100%"
				style="margin: 20px 0 20px 0; color: #000; BACKGROUND-COLOR: #B1CEEE; border: 1px solid #666;font-size: 12px;"
				align=center border=0>
				<tr bgcolor="#ECF3FD" height="25">
					<td>
						当前位置: 课程管理 -&gt; 浏览留言贴
					</td>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="100%"
				style="border: 1px solid #B6B683;">				
				<tr>
					<td align="left">
						<!--게시판 -->
						<table border="0" cellpadding="0" cellspacing="0" width="100%"
							height="31" background=""
							style="background:#FFF url(${ctx}/teacher/images/pro_titlebg.gif) no-repeat; ">
							<tr>
								<td align="left">
									<font style="font-size: 14px; font-weight: 700">
									&nbsp;&nbsp;&nbsp;主题：
									<s:property value="topic.name" /> </font>
										</td>
							</tr>
						</table>
						<table id="table" frame="below" ellspacing="0" cellpadding="4"
							width="100%" align="center"
							style="border-bottom: thin solid #9db350;">
							<tbody id="tbody" style="display: none;">
								<s:iterator value="messageList" status="message">
									<tr style="height: 100%">
										<td width="25%" valign="top"
											style="border-right: thin dotted #60B7DE; border-bottom: 0px;">
											&nbsp;
											<img width="120"
												src="${ctx}/upload/<s:property value="userInfo.photo"/>" />
											<br>
											<font
												style="font-weight: bold; font-size: 14px;text-align: left;">&nbsp;
											<s:property
															value="userInfo.name" /> </font>
													<div>

														<img src="${ctx}/coursepage/classical/image/icon_10.gif"
															width="12" height="12">
														系别：
														<font color="#003366"><s:property
																value="userInfo.department.name" /> </font>
														<br />
														<img src="${ctx}/coursepage/classical/image/icon_4.gif"
															width="13" height="13">
														学院：
														<font color="#003366"><s:property
																value="userInfo.department.school.name" /> </font>
														<br />
														<img src="${ctx}/coursepage/classical/image/icon_1.gif"
															width="12" height="12">
														性别：
														<font color="#003366"><s:property
																value="userInfo.sex" /> </font>


													</div>
												</td>
										<td width="75%" valign="top" height="100%">
											<table border="0" cellspacing="0" cellpadding="4"
												height="100%" width="100%">
												<tr>
													<td>
														<div
															style="padding-top: 4px; padding-left: 10px; border-bottom: 1px solid #9db350; color: #999999">
															第
															<s:property value="grade" />
															楼&nbsp;&nbsp;&nbsp;发表于
															<s:date name="time" format="yyyy-MM-dd hh:mm:ss" />
															&nbsp;
														</div>
													</td>
												</tr>
												<tr height="100%">
													<td valign="top" height="100%"
														style="padding: 10px 10px 10px 10px;">
														<div>
															<s:text name="">${content}</s:text>
														</div>
													</td>
												</tr>

											</table>
										</td>
									</tr>
									<tr height="31">
										<td width="25%" align="left"
											style="border-bottom: thin solid #9db350; border-right: thin dotted #60B7DE; border-top: 0px solid #E7EEF6;">
											<img src="${ctx}/coursepage/classical/image/icon_9.gif">
											邮箱：
											<a
												href="mailto:<s:property value="userInfo.email"/>?subject=[厦门大学课程网络平台]"><font
												color="#003366">
											<s:property value="userInfo.email" /> </font> </a>
											<br />
											<img src="${ctx}/coursepage/classical/image/icon_6.gif"
												width="13" height="13">
											联系电话：
											<font color="#003366">
											<s:property value="userInfo.mobile" />
											</font>
										</td>
										<td height="31" width="75%" align="right"
											style="border-top: 1px solid #E7EEF6; border-bottom: thin solid #9db350; padding-top: 5px; float: right;">
											<a class="delete"
												href="<s:url action="deleteMessageAction">
                     										<s:param name="messageId"> 
                       			 								<s:property value="id"/> 
                    										</s:param>
                											</s:url>" onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;"><font
												color="#999">删除</font> </a>
											<a href="###" onclick="scroll(0,0)"><img
													src="${ctx}/coursepage/classical/image/top.gif" border="0"
													alt="顶部" /> </a>&nbsp;
										</td>
									</tr>
								</s:iterator>
							</tbody>

						</table>
						<br>
						<div id="Pagination" class="pagination">
							<!-- 这里显示分页 -->
						</div>
						<!--/게시판 -->
					</td>
				</tr>			

			</table>
			<br>
		</div>
	</body>
</html>