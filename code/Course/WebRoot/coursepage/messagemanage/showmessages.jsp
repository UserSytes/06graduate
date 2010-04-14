<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><s:property value="topic.name" />-师生留言-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/green/color.css" rel="stylesheet"
			type="text/css" />
<SCRIPT language=javascript>
	function check(form) {
		if (form.messagecontent.value == "") {
			alert("内容不能为空！");
			return false;
		}
		return true;

	}
</SCRIPT>
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="../style/header.jsp"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a href="<s:url action="showTopicsAction"> 
                					</s:url>">师生留言</a>&gt;详细浏览
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
								<table border="0" cellpadding="0" cellspacing="0" width="724" height="94" background="${ctx}/coursepage/classical/image/titlebg2.gif" style="background-repeat:no-repeat">
						<tr>
						<td width="324" align="left"><font style="font-size:12px; color:#574434"><b>欢迎你，<s:property value="userInfo.name"/>&gt;<a href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">个人空间
											</a>&nbsp;<a href="${ctx}/coursepage/messagemanage/searchtopic.jsp">
												搜索
											</a>
											&nbsp;<a href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
												退出
											</a></b></font>
											</td>
							<td width="400" valign="top" align="right"><font style="font-size:12px; color:#574434"></font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold"></font></td>
								</tr>
								<tr>
									<td>
<a href="<s:url action="goNewTopicAction"></s:url>"><img src="${ctx}/coursepage/classical/image/newtopic.gif" alt="新帖" border="0"/></a>
<a href="<s:url action="goReplyAction">
                     			<s:param name="topicId"> 
                       			 	<s:property value="topic.id"/> 
                    			</s:param>
                					</s:url>">
												<img src="${ctx}/coursepage/classical/image/reply.gif" alt="回复" border="0"/>
											</a>
</td></tr>
								</table></td></tr>
						<tr height="1">
							<td width="724" bgcolor="#c4ae86" valign="top"></td></tr>
						</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
					<td width="724" align="center">
						<!--게시판 -->
<table border="0" cellpadding="0" cellspacing="0" width="724" height="31" background="${ctx}/coursepage/classical/image/pro_titlebg.gif" style="background-repeat:no-repeat">
								<tr><td>主题：[<s:date name="topic.time" format="MM-dd" />]<s:property value="topic.name" /></td></tr>
								</table>
<table frame="below" ellspacing="0" cellpadding="4" width="100%"
									align="center" style="border-bottom:thin solid #9db350;">

<s:iterator value="pageBean.list" status="message">
<tr style="height: 100%">
										<td width="24%" valign="top" style="border-bottom:thin solid #9db350;border-right: thin dotted #60B7DE;" >
											<font style="font-weight:bold; font-size:14px"><s:property value="userInfo.name"/></font>
										   <div>
												个人信息：
											  <br />
													<img src="${ctx}/coursepage/classical/image/icon_1.gif" width="13" height="13">ID：<font color="#ffc0dc"><s:property value="userInfo.id"/></font>
												<br />
													<img src="${ctx}/coursepage/classical/image/icon_10.gif" width="12" height="12">系别：<font color="#800080"><s:property value="userInfo.department.name"/></font>
												<br />
													<img src="${ctx}/coursepage/classical/image/icon_4.gif" width="13" height="13">学院：：<font color="#ff0000"><s:property value="userInfo.department.school.name"/></font>
												<br />
													<img src="${ctx}/coursepage/classical/image/icon_12.gif" width="12" height="12">性别：<font color="#48b00d"><s:property value="userInfo.sex"/></font>
												<br />
													<img src="${ctx}/coursepage/classical/image/icon_9.gif">邮箱：<a href="mailto:<s:property value="userInfo.email"/>?subject=[厦门大学课程网络平台]"><font color="#ffa500"><s:property value="userInfo.email"/></font></a>
											  <br />
													<img src="${ctx}/coursepage/classical/image/icon_6.gif" width="13" height="13">联系方式：<font color="#48e0d0"><s:property value="userInfo.mobile"/></font>
										</div>
									  </td>
										<td width="76%" valign="top" style="border-bottom:thin solid #9db350;padding: 0px"
											height="100%">
											<table border="0" cellspacing="0" cellpadding="4"
												height="100%" width="100%">
												<tr>
													<td>
														<div style="padding-top: 4px; border-bottom:thin inset #9db350;">
															第<s:property value="grade"/>楼&nbsp;&nbsp;&nbsp;发表于<s:date name="time" format="yyyy-MM-dd hh:mm:ss" />&nbsp;
															<a href="" target="_blank">个人资料</a>&nbsp;
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
												<tr height="20">
													<td align="right">
														&nbsp;
														<a href="">引用</a> &nbsp;
														<a href="###" onclick="">回复</a>
														<a href="###" onclick="scroll(0,0)"><img src="${ctx}/coursepage/classical/image/top.gif"
																border="0" alt="顶部" />
														</a>
													</td>
												</tr>
											</table>
										</td>
									</tr>
</s:iterator>
</table>
						<!--/게시판 -->
					</td></tr>
<tr>
					<td>
						<!-- 페지검색 -->
						<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td colspan="3">
											<s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
											<s:else>
												<a href="showMessagesAction.action?page=1">第一页</a>
												<a
													href="showMessagesAction.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
											</s:else>
											<s:bean name="org.apache.struts2.util.Counter" id="counter">
												<s:param name="first" value="1" />
												<s:param name="last" value="pageBean.totalPage" />
												<s:iterator status="current">
													<s:if test="pageBean.currentPage!=current-1">
														<a
															href="showMessagesAction.action?page=<s:property value="%{current-1}"/>">
															[<s:property />]</a>
													</s:if>
													<s:else>
														<font color="red"><s:property />
														</font>
													</s:else>
												</s:iterator>
											</s:bean>
											<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
												<a
													href="showMessagesAction.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
												<a
													href="showMessagesAction.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
											</s:if>
											<s:else>
            下一页 最后一页
        </s:else>
											&nbsp;共
											<s:property value="pageBean.allRow" />
											条记录&nbsp;当前第
											<s:property value="pageBean.currentPage" />
											页&nbsp;共
											<s:property value="pageBean.totalPage" />
											页
										</td>
									</tr>
								</table>
<s:form action="addReplyAction" method="post"
				onsubmit="return check(this);">
				<s:hidden name="topic.id"></s:hidden>
				<table cellspacing="0" cellpadding="4" border="0"
					width="100%" align="center">
					<tr style="HEIGHT: 30px; padding-left: 10px;font-size:15px;font-weight:bold;">
						<td colspan="4">
							快速回复主题
						</td>
					</tr>
					<tr>
						<td width="24%" align="center" valign="top">
							<span class="bold" style="font-size: 16px">内容</span>
						</td>
						<td width="76%" valign="top">
							<div style="width: 97%" align="left">
								<s:textarea rows="7" cols="70 " id="messagecontent"
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
					</td></tr><tr height="35"><td></td></tr>	
						<tr height="45">
							<td width="753" align="right" valign="top"><a href="<s:url action="showTopicsAction"> 
                					</s:url>"><img src="${ctx}/coursepage/classical/image/button.gif" border="0"></a></td></tr>
						</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="../style/bottom.jsp"></s:include>
	</body>
</html>
