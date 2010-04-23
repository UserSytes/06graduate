<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>师生留言-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />

	</head>
	<body>
		<!-- 头部 -->
		<s:include value="../style/%{#session.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="showTopicsAction"> 
                					</s:url>">师生留言</a>&gt;列表浏览
					</h2>
					<br class="clear" />
				</div>

				<ul id="products-list">
				</ul>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="724" align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="724"
									height="94"
									background="${ctx}/coursepage/classical/image/titlebg5.gif"
									style="background-repeat: no-repeat">
									<tr>
										<td width="324" align="left">
											<font style="font-size: 12px; color: #574434"><b>欢迎你，<s:property
														value="userInfo.name" />&gt;<a
													href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">个人空间
												</a>&nbsp;<a
													href="${ctx}/coursepage/messagemanage/searchtopic.jsp">
														搜索 </a> &nbsp;<a
													href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
														退出 </a> </b> </font>
										</td>
										<td width="400" valign="top" align="right">
										</td>
									</tr>
									<tr height="69">
										<td valign="bottom" align="left">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td>
													</td>
												</tr>
												<tr>
													<td>
														<a href="<s:url action="goNewTopicAction"></s:url>"><img
																src="${ctx}/coursepage/classical/image/newtopic.gif"
																alt="新帖" border="0" /> </a>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="1">
										<td width="724" class="td-foot" valign="top"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr height="20">
							<td></td>
						</tr>
						<tr>
							<td width="724" align="center">
								<!--게시판 -->
								<table border="0" cellpadding="0" cellspacing="0" width="724"
									class="display" id="example">								
									<tr class="tr-title">
										<td width="50" height="40" align="center">
											序号
										</td>
										<td width="280" height="40" align="center">
											标题
										</td>
										<td width="160" height="40" align="center">
											作者
										</td>
										<td width="120" height="40" align="center">
											回复/查看
										</td>
										<td width="120" height="40" align="center">
											最后发表
										</td>
									</tr>
									<s:iterator value="topicList" status="topic">
										<tr height="33" class="tr-content"
											<s:if test="#topic.odd">style="background-color:#fff"</s:if>>
											<td width="50" align="center">
												<s:property value="#topic.count" />
											</td>											
											<td width="280" align="left" style="font-weight: bold">
												<a
													href="<s:url action="showMessagesAction"> 
		<s:param name="topicId"> 
		<s:property value="id"/> 
		</s:param>
		</s:url>">
													<s:property value="name" /> </a>
											</td>
											<td width="160" align="center">
												<s:property value="authorName" />
												<br>
												<s:date name="time" format="yyyy-MM-dd" />
											</td>
											<td width="120" align="center">
												<s:property value="countReply" />
												/
												<s:property value="countPerson" />
											</td>
											<td width="120" align="center">
												<s:date name="lastUpdate" format="yyyy-MM-dd" />
												<br>
													by 
												<s:property value="lastAnswer" />
											</td>
										</tr>
									</s:iterator>
									<tr height="4">
										<td></td>
									</tr>

									<tr height="3" class="tr-foot">
										<td colspan="14" width="630"></td>
									</tr>
								</table>
								<!--/게시판 -->
							</td>
						</tr>
						<tr>
							<td>
								<br />
								<!-- 페지검색 -->
								<table border="0" cellpadding="0" cellspacing="0">
									
								</table>
								<!-- /페지검색 -->

							</td>
						</tr>
						<tr>
							<td width="724" align="center">
								<!--검색 -->
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<td>
											<s:form action="goQuickSearchTopicAction"
												onsubmit="return check(this);" method="post"
												enctype="multipart/form-data">
												<table border="0" cellpadding="0" cellspacing="0"
													width="724">
													<tr height="40" bgcolor="#f1e1be">
														<td width="7"></td>
														<td>
															<img src="${ctx}/coursepage/classical/image/search.gif"
																border="0">
														</td>
														<td width="8"></td>
														<td>
															<s:select name="searchFlag"
																cssStyle="width:73px;height:21px;background-color:#ffffff;color:#777777"
																list="# {'0':'标题','1':'作者'}" headerKey="-1"
																headerValue="请选择" />
														</td>
														<td width="3"></td>
														<td>
															<s:textfield name="keyword" cssClass="text" size="40" />
														</td>
														<td width="5"></td>
														<td>
															<input type="submit" name="submit" value=" 查 询 "
																style=" background-image:${ctx}/coursepage/classical/image/button3.gif">
														</td>
														<td width="200"></td>
														<td>
															<!--<a href="#"><img src="${ctx}/coursepage/classical/image/button2.gif" border="0"></a>-->
														</td>
														<td width="6"></td>
												</table>
											</s:form>
										</td>
									</tr>
								</table>
								<!--/검색 -->
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
