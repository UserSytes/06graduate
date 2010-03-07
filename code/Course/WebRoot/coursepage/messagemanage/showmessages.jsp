<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>厦门大学精品课程</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="${ctx}/coursepage/default.css" rel="stylesheet"
			type="text/css" />
<SCRIPT language=javascript>
	function check(form) {
		if (form.title.value == "") {
			alert("标题不能为空！");
			return false;
		}
		if (form.messagecontent.value == "") {
			alert("内容不能为空！");
			return false;
		}
		return true;

	}
</SCRIPT>
	</head>
	<body>
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../top.jsp"></jsp:include>
		<div id="content">
			<div style="width: 770px">
				<div>
<a href="${ctx}/coursepage/messagemanage/newmessage.jsp" align="left"><img src="${ctx}/coursepage/images/newtopic.gif" alt="新帖" border="0"/></a>
<a href="<s:url action="goReplyAction">
                     			<s:param name="topicId"> 
                       			 	<s:property value="topic.id"/> 
                    			</s:param>
                					</s:url>">
												<img src="${ctx}/coursepage/images/reply.gif" alt="回复" border="0"/>
											</a>
					欢迎你，<s:property value="userInfo.name"/>&nbsp;&nbsp;&nbsp;<a href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">
												个人空间
											</a>&nbsp;&nbsp;&nbsp;<a href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
												退出
											</a>
				
<div align="left">					
					<table bordercolor="#3399FF" border="1" width="100%">
						<tr>
							<td>
								<div align="left" style=" background-image:url(${ctx}/coursepage/images/header_bg2.gif); background-repeat:repeat-x; font-size:15px;font-weight:bold;">	
标题：${topic.name}
</div>
<s:iterator value="messageList" status="message">
								<table frame="below" ellspacing="0" cellpadding="4" width="100%"
									align="center" style="border-bottom:thin solid #3399FF;">
									<tr style="height: 100%">
										<td width="24%" valign="top" style="border-right: thin dotted #60B7DE;" >
											<font style="font-weight:bold; font-size:14px"><s:property value="userInfo.name"/></font>
											<br />
											<div>
												个人信息：
												<br />
													ID：<s:property value="userInfo.id"/>
												<br />
													系别：<s:property value="userInfo.department.name"/>
												<br />
													学院：<s:property value="userInfo.department.school.name"/>
												<br />
													性别：<s:property value="userInfo.sex"/>
												<br />
													邮箱：<s:property value="userInfo.email"/>
												<br />
													联系方式：<s:property value="userInfo.mobile"/>
											</div>
										</td>
										<td width="76%" valign="top" style="padding: 0px"
											height="100%">
											<table border="0" cellspacing="0" cellpadding="4"
												height="100%" width="100%">
												<tr>
													<td>
														<div style="padding-top: 4px; border-bottom:thin inset #60B7DE;">
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
												<tr>
													<td align="right">
														&nbsp;
														<a href="">引用</a> &nbsp;
														<a href="###" onclick="">回复</a>
														<a href="###" onclick="scroll(0,0)"><img src="${ctx}/coursepage/images/top.gif"
																border="0" alt="顶部" />
														</a>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
</s:iterator>
<s:url id="url_pre" value="showMessagesAction.action">
				<s:param name="pageNow" value="pageNow-1"></s:param>
			</s:url>
			<s:url id="url_next" value="showMessagesAction.action">
				<s:param name="pageNow" value="pageNow+1"></s:param>
			</s:url>
			<s:a href="%{url_pre}">上一页</s:a>

			<s:iterator value="messageInfoList" status="status">
				<s:url id="url" value="showMessagesAction.action">
					<s:param name="pageNow" value="pageNow" />
				</s:url>
			</s:iterator>
			<s:a href="%{url_next}">下一页</s:a>
&nbsp;当前页<s:property value="pageNow"/>
							</td>
						</tr>
					</table>

				</div>

			</div>
		</div>
<s:form action="addReplyAction" method="post"
			onsubmit="return check(this);">
<s:hidden name="topicId"></s:hidden>
<table cellspacing="0" cellpadding="4" width="100%" align="center">
<tr>
<td colspan="4" style="font-size:16px; font-weight:bold">快速回复主题</td>
</tr>
<tr>
<td width="24%" align="center" valign="top"><span class="bold" style="font-size:16px">内容</span></td>
<td width="76%" valign="top">
<div style="width: 97%" align="right">
<s:textarea rows="7" cols="20" id="messagecontent" name="message.content">&nbsp;*</s:textarea>
<br><br>
<div class="left">
<s:submit cssClass="label" value="发表回复"></s:submit>

</div>
</div>
</td>
</tr></table>
</s:form>
</div>
		<jsp:include page="../bottom.jsp"></jsp:include>
	</body>
</html>