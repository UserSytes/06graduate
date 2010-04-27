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
		<link href="${ctx}/facebox/facebox.css" media="screen"
			rel="stylesheet" type="text/css" />

		<style type="text/css" title="currentStyle">
@import "${ctx}/css/demo_page.css";

@import "${ctx}/css/demo_table_jui.css";

@import "${ctx}/css/jquery-ui-1.7.2.custom.css";
</style>
		<style type="text/css">
.ui-widget-header {
	border: 1px solid #aaaaaa;
	background: #b1ceee;
	color: #222222;
	font-weight: bold;
}
</style>
	</head>
	<body id="dt_example">
		<!-- 头部 -->
		<s:include value="../style/%{#session.header}"></s:include>
		<script type="text/javascript" language="javascript"
			src="${ctx}/js/jquery.dataTables.js" charset="gb2312"></script>
		<script src="${ctx}/facebox/facebox.js" type="text/javascript"></script>

		<script type="text/javascript" charset="utf-8">
	$(document).ready( function() {
		oTable = $('#example').dataTable( {
			"bJQueryUI" :true,
			"sPaginationType" :"full_numbers"
		});
		$('a[rel*=facebox]').facebox( {
			loading_image :'${ctx}/css/images/loading.gif',
			close_image :'${ctx}/css/images/closelabel.gif'
		})

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
                					</s:url>">师生留言</a>&gt;列表浏览
					</h2>
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">
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
										</td>
										<td width="324" align="right" class="titlea"
											style="line-height: 25px; font-family: Verdana, Helvetica, Arial, sans-serif; font-size: 12px; margin-right: 20px;">
											&nbsp;&nbsp;&nbsp;欢迎你,
											<s:property value="userInfo.name" />
											&nbsp;
											<span style="color: #CBCBCB">|</span><a class="titlea"
												href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">&nbsp;个人空间&nbsp;
											</a><span style="color: #CBCBCB">|</span><a class="titlea"
												href="<s:url action="logoutAction"> 
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
								<div class="demo_jui"
									style="margin: 10px auto 0; padding-left: 10px; padding-right: 10px;">
									<table border="0" cellpadding="0" cellspacing="0" width="704"
										class="display" id="example">
										<thead>
											<tr>
												<th>
													
												</th>
												<th width="280">
													标题
												</th>
												<th width="130">
													作者
												</th>
												<th width="100">
													回复/查看
												</th>
												<th width="130">
													最后发表
												</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="topicList" status="topic">
												<tr height="33" class="tr-content">
													<td width="30">
														<s:property value="#topic.count" /></div>
													</td>
													<td width="280" align="left" style="font-weight: bold">

														<a class="titlea"
															href="<s:url action="showMessagesAction"> 
		<s:param name="topicId"> 
		<s:property value="id"/> 
		</s:param>
		</s:url>">
															<s:property value="name" /> </a>
													</td>
													<td width="130" align="center">
														<s:property value="authorName" />
														<br>
														<s:date name="time" format="yyyy-MM-dd hh:mm" />
													</td>
													<td width="100" align="center">
														<s:property value="countReply" />
														/
														<font color="#444444"><s:property
																value="countPerson" /> </font>&nbsp;&nbsp;&nbsp;
													</td>
													<td width="130" align="center">
														<s:property value="lastAnswer" />
														<br>
														<s:date name="lastUpdate" format="yyyy-MM-dd hh:mm" />
													</td>
												</tr>
											</s:iterator>
										</tbody>

									</table>
									<!--/게시판 -->
								</div>
							</td>
						</tr>
					</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<div id="info" style="display: none;">
			<p>
				Hey, I'm the 'info' div!
			</p>
			<p>
				I look like this:
			</p>

			<code>
				&lt;div id="info" style="display:none;"&gt;
				<br />
				&nbsp;&nbsp;text
				<br />
				&lt;/div&gt;
			</code>
		</div>

		<s:include value="../style/bottom.jsp"></s:include>
	</body>
</html>
