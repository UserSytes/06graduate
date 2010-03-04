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
	</head>
	<body>
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../top.jsp"></jsp:include>
		<div id="content">
			<div style="width: 770px">
				<div align="right">
					欢迎你，<s:property value="userInfo.name"/>&nbsp;&nbsp;&nbsp;<a href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">
												个人空间
											</a>&nbsp;&nbsp;&nbsp;<a href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
												退出
											</a>
				</div>
				<div>
					<p>
<div align="right">
						<img src="${ctx}/coursepage/images/newtopic.gif" alt="新帖"
							longdesc="http://baidu.com" />
						<img src="${ctx}/coursepage/images/reply.gif" alt="回复"
							longdesc="http://baidu.com" />
</div>	
					</p>
					<table bordercolor="#3399FF" border="1" width="100%">
						<tr>
							<td>
								<div style=" background-image:url(${ctx}/coursepage/images/header_bg2.gif); background-repeat:repeat-x; font-size:15px; font-weight:bold">	
标题：${topic.name}
</div>
<s:iterator value="MessageInfoList" status="messageInfo">
								<table frame="below" ellspacing="0" cellpadding="4" width="100%"
									align="center" style="border-bottom:thin solid #3399FF;">
									<tr style="height: 100%">
										<td width="24%" valign="top" style="border-right: thin dotted #60B7DE;" >
											<font style="font-weight:bold; font-size:14px"><s:property value="userName"/></font>
											<br />
											<div>
												个人信息：
												<br />
													ID：<s:property value="id"/>
												<br />
													系别：<s:property value="department"/>
												<br />
													学院：<s:property value="school"/>
												<br />
													性别：<s:property value="sex"/>
												<br />
													邮箱：<s:property value="email"/>
												<br />
													联系方式：<s:property value="mobile"/>
											</div>
										</td>
										<td width="76%" valign="top" style="padding: 0px"
											height="100%">
											<table border="0" cellspacing="0" cellpadding="4"
												height="100%" width="100%">
												<tr>
													<td>
														<div style="padding-top: 4px; border-bottom:thin inset #60B7DE;">
															第<s:property value="#messageInfo.count"/>楼&nbsp;&nbsp;&nbsp;发表于<s:date name="time" format="yyyy-MM-dd hh:mm:ss" />&nbsp;
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

		<jsp:include page="../bottom.jsp"></jsp:include>
	</body>
</html>