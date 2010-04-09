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
		<LINK href="${ctx}/css/message.css" type=text/css rel=stylesheet>
		<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.pagination.js"></script>
		<title><s:text name="">${topic.name}</s:text></title>
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
	<body><br>
		<table class=editTable  cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 留言管理 -&gt; 浏览留言贴
				</td>
			</tr>
		</table>
<br>
		<div align="left">
			<table bordercolor="#3399FF" border="1" width="98%"  id="table" style="">
				<tr>
					<td>
						<div align="left"
							style=" background-image:url(${ctx}/coursepage/images/header_bg2.gif); background-repeat:repeat-x; font-size:15px;font-weight:bold;">
							标题：${topic.name}
						</div>
				<tbody id="tbody" style="display: none;">
						<s:iterator value="messageList" status="message">
							<table frame="below" ellspacing="0" cellpadding="4" width="100%"
								align="center" style="border-bottom: thin solid #3399FF;">
								<tr style="height: 100%">
									<td width="24%" valign="top"
										style="border-right: thin dotted #60B7DE;">
										<font style="font-weight: bold; font-size: 14px"><s:property
												value="userInfo.name" />
										</font>
										<br />
										<div><strong>
											个人信息</strong>
											<br />
											ID：
											<s:property value="userInfo.id" />
											<br />
											系别：
											<s:property value="userInfo.department.name" />
											<br />
											学院：
											<s:property value="userInfo.department.school.name" />
											<br />
											性别：
											<s:property value="userInfo.sex" />
											<br />
											邮箱：
											<s:property value="userInfo.email" />
											<br />
											联系方式：
											<s:property value="userInfo.mobile" />
										</div>
									</td>
									<td width="76%" valign="top" style="padding: 0px" height="100%">
										<table border="0" cellspacing="0" cellpadding="4"
											height="100%" width="100%">
											<tr>
												<td>
													<div
														style="padding-top: 4px; border-bottom: thin inset #60B7DE;">
														第
														<s:property value="grade" />
														楼&nbsp;&nbsp;&nbsp;发表于
														<s:date name="time" format="yyyy-MM-dd hh:mm:ss" />
														&nbsp;
													</div>
												</td>
											</tr>
											<tr>
												<td valign="top" height="100%" style="padding-top: 10px;">
													<div>
														<s:text name="">${content}</s:text>
													</div>
												</td>
											</tr>
											<tr>
												<td align="right">
													&nbsp;
													<a
														href="<s:url action="deleteMessageAction"> 
                     			<s:param name="messageId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"
														onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
														<font color="red">【删除】</font> </a>
													<a href="###" onclick="scroll(0,0)"><img
															src="${ctx}/coursepage/images/top.gif" border="0"
															alt="顶部" /> </a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</s:iterator>
</tbody>
					</td>
				</tr>
			</table>
			<div id="Pagination" class="pagination"></div>
		</div>
	</body>
</html>