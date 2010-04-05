<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%><html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>留言板-厦门大学网络课程中心</title>
<link rel="stylesheet" href="${ctx}/coursepage/classical/link.css">
</head>
<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0" background="${ctx}/coursepage/classical/image/back.gif" >

<!-- 导航 -->
<s:include value="../classical/header.jsp"></s:include>
<!-- /导航 -->

<!-- 正文-->
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center" >
<tr>
	<td width="175">
		<!--左边栏 -->
		<s:include value="../classical/left.jsp"></s:include>
		<!-- /左边栏 --></td>
	<td width="775"  valign="top" align="center">
		<table border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td>
				<!-- 中间主体内容 -->
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="3"><img width="775" src="${ctx}/coursepage/classical/image/topline2.gif" border="0"></td></tr>
				<tr>
					<td width="1" bgcolor="#b29f79"></td>
					<td bgcolor="#fdfbf3">
						<table border="0" cellpadding="0" cellspacing="0" width="773" >
						<tr>
							<td>
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="bottom">&nbsp;</td>
									<td>
										<table border="0" cellpadding="0" cellspacing="0">

										<tr>
											<td colspan="3">
												<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td>
														<!-- 课程内容 -->
														<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="773" align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="760" height="94" background="${ctx}/coursepage/classical/image/titlebg5.gif" style="background-repeat:no-repeat">
						<tr>
						<td width="350"><font style="font-size:12px; color:#574434"><b>欢迎你，<s:property value="userInfo.name"/>&gt;<a href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">个人空间
											</a>&nbsp;<a href="${ctx}/coursepage/messagemanage/searchtopic.jsp">
												搜索
											</a>
											&nbsp;<a href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
												退出
											</a></b></font>
											</td>
							<td width="400" valign="top" align="right"><font style="font-size:12px; color:#574434">首页 &gt;<b>课程教案列表</b></font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold"></font></td>
								</tr>
								<tr>
									<td>
<a href="<s:url action="goNewTopicAction"></s:url>"><img src="${ctx}/coursepage/classical/image/newtopic.gif" alt="新帖" border="0"/></a>
</td></tr>
								</table></td></tr>
						<tr height="1">
							<td width="750" bgcolor="#c4ae86" valign="top"></td></tr>
						</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
					<td width="750" align="center">
						<!--게시판 -->
						<table border="0" cellpadding="0" cellspacing="0" width="740">
						<tr height="3" bgcolor="#d3b981"><td colspan="14"></td></tr>
						<tr bgcolor="#f1e1be">
							<td width="50" height="40" align="center"><font style="font-size:14px;font-weight:bold;">序号</font></td>
							<td>&nbsp;</td>
							<td width="280" height="40" align="center"><font style="font-size:14px;font-weight:bold;">标题</font></td>
							<td>&nbsp;</td>
							<td width="160" height="40" align="center"><font style="font-size:14px;font-weight:bold;">作者</font></td>
							<td>&nbsp;</td>
							<td width="120" height="40" align="center"><font style="font-size:14px;font-weight:bold;">回复/查看</font></td>
							<td>&nbsp;</td>
							<td width="120" height="40" align="center"><font style="font-size:14px;font-weight:bold;">最后发表</font></td>
						</tr>
<s:iterator value="pageBean.list" status="topic">
						<tr height="33" bgcolor="#fdfbf3"  <s:if test="#topic.even">style="background-color:#faefda"</s:if>>
							<td width="50" align="center"><font color="#74582f"><s:property value="#topic.count" /></font></td>
							<td></td>	
							<td width="280" align="left"><font color="#74582f"><a href="<s:url action="showMessagesAction"> 
		<s:param name="topicId"> 
		<s:property value="id"/> 
		</s:param>
		</s:url>">
<s:property value="name" /></a></font></td>
							<td></td>
							<td width="160" align="center"><font color="#74582f"><s:property value="authorName"/><br><s:date name="time" format="yyyy-MM-dd" /></font></td>
							<td></td>
							<td width="120" align="center"><font color="#74582f"><s:property value="countReply"/>/<s:property value="countPerson"/></font></td>
							<td></td>
							<td width="120" align="center"><font color="#74582f"><s:date name="lastUpdate" format="yyyy-MM-dd" /><br>by <s:property value="lastAnswer"/></font></td>
							</tr>
</s:iterator>					
						<tr height="4"><td></td></tr>
						<tr height="1" bgcolor="#d3b981"><td colspan="14"></td></tr>
						<tr height="3" bgcolor="#eedcb3"><td colspan="14" width="630"></td></tr>
						</table>
						<!--/게시판 -->
					</td></tr>
<tr>
					<td>
						<!-- 페지검색 -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>共<s:property value="pageBean.allRow"/> 条记录</td>
							<td>共<s:property value="pageBean.totalPage"/> 页</td>
							<td>当前第<s:property value="pageBean.currentPage"/>页</td>
							</tr>
<tr>
							<td colspan="3"><s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
        <s:else>
            <a href="showTopicsAction.action?page=1">第一页</a>
            <a href="showTopicsAction.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
<s:bean name="org.apache.struts2.util.Counter" id="counter"> 
  <s:param name="first" value="1" /> 
  <s:param name="last" value="pageBean.totalPage" />
   <s:iterator status="current">
   <s:if test="pageBean.currentPage!=current-1">
    <a href="showTopicsAction.action?page=<s:property value="%{current-1}"/>"> 
[<s:property/>]</a> 
    </s:if> 
    <s:else>
    <font color="red"><s:property/></font> 
    </s:else> 
   </s:iterator> 
</s:bean> 
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="showTopicsAction.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="showTopicsAction.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else></td>
							</tr>
						</table>
						<!-- /페지검색 -->

					</td></tr>
<tr>
					<td width="658" align="center">
						<!--검색 -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="750">
								<tr height="40" bgcolor="#f1e1be">
									<td><img src="${ctx}/coursepage/classical/image/s_left.gif" border="0"></td>
									<td width="7"></td>
									<td><img src="${ctx}/coursepage/classical/image/search.gif" border="0"></td>
									<td width="8"></td>
									<td><select name="" style="width:73px;height:21px;background-color:#ffffff;color:#777777"><option>标题</option></select></td>
									<td width="3"></td>
									<td><input type="text" name="" style="width:197px;height:21px;border:solid 1px #c1a568;background-color:#ffffff"></td>
									<td width="5"></td>
									<td><a href="#"><img src="${ctx}/coursepage/classical/image/button3.gif" border="0"></a></td>
									<td width="143"></td>
									<td><a href="#"><img src="${ctx}/coursepage/classical/image/button2.gif" border="0"></a></td>
									<td width="6"></td>
									<td><img src="${ctx}/coursepage/classical/image/s_right.gif" border="0"></td></tr>
							</table>							</td></tr>
						</table>
					<!--/검색 -->					</td></tr>
						<tr height="35"><td></td></tr>	
						<tr height="45">
							<td width="753" align="right" valign="top"><a href="#"><img src="${ctx}/coursepage/classical/image/button.gif" border="0"></a></td></tr>
						</table>
														<!-- /주요클리닉 -->
													</td></tr>
												</table>
											</td></tr>
										<tr height="12"><td></td></tr>
										</table>
									</td></tr>
								</table>
							</td></tr>
						</table></td>
					<td width="1" bgcolor="#cec1a6"></td></tr>
				<tr>
					<td colspan="3"><img width="775"  src="${ctx}/coursepage/classical/image/bottomline2.gif" border="0"></td></tr>
				<tr height="10">
					<td colspan="3"></td></tr>
				</table>
			</td></tr>
		</table></td>
	<td width="13"></td>
</tr>
</table>
<!-- /내용부분-->

<!--底部 -->
<s:include value="../classical/bottom.jsp"></s:include>
<!--/底部 -->

</body>
</html>
