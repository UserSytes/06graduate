<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:quote>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><s:property value="topic.name" />-师生留言-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<script type="text/javascript">
	function check(form) {
		if (form.messagecontent.value == "") {
			alert("内容不能为空！");
			return false;
		}
		return true;

	}
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

.repquote {
	background: url(${ctx}/coursepage/style/common/repquote.gif) no-repeat 0
		50%;
	padding: 5px 10px 5px 25px;
	color: #999;
}

.fastreply {
	background: url(${ctx}/coursepage/style/common/fastreply.gif) no-repeat
		0 50%;
	padding: 5px 10px 5px 25px;
	color: #999;
}
</style>
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="../style/%{#session.header}"></s:include>		
		<script type="text/javascript" src="${ctx}/js/jquery.pagination.js"></script>
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
});
</script>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="showTopicsAction"> 
                					</s:url>">师生留言</a>&gt;详细浏览
					</h2>
					<br class="clear" />
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0" >
						<tr>
							<td width="724" align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="724">
									<tr height="39">
										<td valign="bottom" align="left">
											&nbsp;&nbsp;
											<a href="<s:url action="goNewTopicAction"></s:url>"
												rel="facebox"><img
													src="${ctx}/coursepage/classical/image/newtopic.gif"
													alt="新帖" border="0" /> </a>
											<a
												href="<s:url action="goReplyAction">
															<s:param name="topicId"> 
															<s:property value="topic.id"/> 
                    										</s:param>
                											</s:url>"
												rel="facebox"> <img
													src="${ctx}/coursepage/classical/image/reply.gif" alt="回复"
													border="0" /> </a>
										</td>
										<td width="324" align="right" class="titlea"
											style="line-height: 25px; font-family: Verdana, Helvetica, Arial, sans-serif; font-size: 12px; margin-right: 20px;">
											&nbsp;&nbsp;&nbsp;欢迎你,
											<s:property value="userInfo.name" />
											&nbsp;
											<span style="color: #CBCBCB">|</span><a class="titlea"
												href="<s:url action="myPageAction"> 
                					</s:url>">&nbsp;个人空间&nbsp;
											</a><span style="color: #CBCBCB">|</span><a class="titlea"
												href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
												&nbsp;退出 </a>
										</td>
										<td width="20"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td width="724" align="center">
								<!--게시판 -->
								<table border="0" cellpadding="0" cellspacing="0" width="724"
									height="31"
									background="${ctx}/coursepage/classical/image/pro_titlebg.gif"
									style="background-repeat: no-repeat">
									<tr>
										<td align="left">
											<font style="font-size: 14px; font-weight: 700">
												&nbsp;&nbsp;&nbsp;主题： <s:property value="topic.name" /> </font>
										</td>
									</tr>
								</table>
								<table id="table" frame="below" ellspacing="0" cellpadding="4"
									width="100%" align="center"
									style="border-bottom: thin solid #9db350;">
									<tbody id="tbody" style="display: none;">
										<s:iterator value="messageList" status="message">
											<tr style="height: 100%">
												<td width="200" valign="top"
													style="border-right: thin dotted #60B7DE; border-bottom: 0px;">
													&nbsp;
													<img width="120"
														src="${ctx}/upload/<s:property value="userInfo.photo"/>" />
													<br>
													<font style="font-weight: bold; font-size: 14px;text-align: left;">&nbsp;<s:property
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
	<br /><img src="${ctx}/coursepage/classical/image/icon_9.gif">
														邮箱： 
													<a
														href="mailto:<s:property value="userInfo.email"/>?subject=[厦门大学课程网络平台]"><font
														color="#003366"><s:property value="userInfo.email" />
													</font> </a>
													<br />
													<img src="${ctx}/coursepage/classical/image/icon_6.gif"
														width="13" height="13">
														联系电话： 
													<font color="#003366"><s:property
															value="userInfo.mobile" /> </font>

													</div>
												</td>
												<td width="514" valign="top" height="100%">
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
												<td width="200" align="left"
													style="border-bottom: thin solid #9db350; border-right: thin dotted #60B7DE; border-top: 0px solid #E7EEF6;">
													</td>
												<td width="514" height="31" align="right"
													style="border-top: 1px solid #E7EEF6; border-bottom: thin solid #9db350; padding-top: 5px; float: right;">
													<a class="fastreply" rel="facebox"
														href="<s:url action="goReplyWithQuoteAction">
                     										<s:param name="topicId"> 
                       			 								<s:property value="topic.id"/> 
                    										</s:param>
															<s:param name="messageId" value="id"> 
                    										</s:param>															
                											</s:url>"><font
														color="#999">引用</font> </a>
													<a class="repquote" rel="facebox"
														href="<s:url action="goReplyToSomeoneAction">
                     										<s:param name="topicId"> 
                       			 								<s:property value="topic.id"/> 
                    										</s:param>
															<s:param name="messageId" value="id"> 
                    										</s:param>					
                											</s:url>"><font
														color="#999">回复</font> </a>
													<a href="###" onclick="scroll(0,0)"><img
															src="${ctx}/coursepage/classical/image/top.gif"
															border="0" alt="顶部" /> </a>&nbsp;
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
						<tr>
							<td>
								<!-- 페지검색 -->
								<table border="0" cellpadding="0" cellspacing="0">

								</table>
								<s:form action="addReplyAction" method="post"
									onsubmit="return check(this);">
									<s:hidden name="topic.id"></s:hidden>
									<table cellspacing="0" cellpadding="4" border="0" width="100%"
										align="center">
										<br>
										<tr>
											<td width="200" align="center" valign="top">
												<span class="bold"
													style="padding-left: 10px; font-size: 15px; font-weight: bold;">快速回复主题</span>
											</td>
											<td width="500" valign="top"
												style="padding-right: 20px; padding-left: 20px;">
												<div style="width: 500" align="left">
													<s:textarea rows="7" cols="60" id="messagecontent"
														name="message.content"></s:textarea>
													<div class="left">
														<s:submit cssClass="label" value="发表回复"></s:submit>
													</div>
												</div>
											</td>
										</tr>
									</table>
								</s:form>
								<!-- /페지검색 -->
							</td>
						</tr>

					</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="../style/bottom.jsp"></s:include>
	</body>
</html>
