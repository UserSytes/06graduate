<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title><s:if test="sort==0">
课程通知</s:if><s:else>课程公告</s:else>-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/green/color.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="style/header.jsp"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="style/left.jsp"></s:include>
			<div id="right-cnt">
				<br class="clear" />
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	<s:property value="sort" /> 
                    			</s:param>
                					</s:url>"><s:if test="sort==0">
课程通知</s:if><s:else>课程公告</s:else></a>&gt;列表浏览
					</h2>
					<br class="clear" />
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="724" align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="724" height="94" background="${ctx}/coursepage/classical/image/titlebg2.gif" style="background-repeat:no-repeat">
						<tr>
							<td width="724" valign="top" align="right"><font style="font-size:12px; color:#574434"></font></td></tr>
						<tr height="69">
							<td valign="bottom" align="left">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><font color="#966f48"style="font-size:16px; font-weight:bold">课程通知</font></td>
								</tr>
								<tr>
									<td><font color="#92a35d"style="font-size:12px;"></font></td></tr>
								</table></td></tr>
						<tr height="1">
							<td width="724" bgcolor="#c4ae86" valign="top"></td></tr>
						</table>
							</td></tr>
						<tr height="20"><td></td></tr>
						<tr>
					<td width="724" align="center">
						<!--게시판 -->
						<table border="0" cellpadding="0" cellspacing="0" width="724">
						<tr height="3" bgcolor="#d3b981"><td colspan="14"></td></tr>
						<tr bgcolor="#f1e1be">
							<td width="48" height="40" align="center"><font style="font-size:14px;font-weight:bold;">序号</font></td>
							<td>&nbsp;</td>
							<td width="319" height="40" align="center" colspan="2"><font style="font-size:14px;font-weight:bold;">标题</font></td>
							<td>&nbsp;</td>
							<td width="83" height="40" align="center"><font style="font-size:14px;font-weight:bold;">发布时间</font></td>
							<td>&nbsp;</td>
							<td width="48" height="40" align="center"><font style="font-size:14px;font-weight:bold;">点击量</font></td>
						</tr>
<s:iterator value="pageBean.list" status="notice">
						<tr height="33" bgcolor="#fdfbf3" <s:if test="#notice.even">style="background-color:#faefda"</s:if>>
							<td align="center"><font color="#74582f"><s:property value="#notice.count" /></font></td>
							<td></td>
							<td width="10"></td>
							<td width="239"><font color="#74582f"><a href="<s:url action="viewNoticeAction"> 
											                     			<s:param name="noticeId"> 
											                       			 	<s:property value="id"/> 
											                    			</s:param>
																			<s:param name="sort"> 
											                       			 	<s:property value="sort"/>
											                    			</s:param>
											                					</s:url>"><s:property value="title"/></a></font></td> 
							<td></td>
							<td width="83" align="center"><font color="#74582f"><s:date name="time" format="yyyy-MM-dd hh:mm:ss" /></font></td>
							<td></td>
							<td width="48" align="center"><font color="#74582f">12</font></td></tr>
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
						<!--<tr>
							<td>共<s:property value="pageBean.allRow"/> 条记录</td>
							<td>共<s:property value="pageBean.totalPage"/> 页</td>
							<td>当前第<s:property value="pageBean.currentPage"/>页</td>
							</tr>
--><tr>
							<td colspan="3"><s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
        <s:else>
            <a href="getNoticeBySortAction.action?page=1">第一页</a>
            <a href="getNoticeBySortAction.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
<s:bean name="org.apache.struts2.util.Counter" id="counter"> 
  <s:param name="first" value="1" /> 
  <s:param name="last" value="pageBean.totalPage" />
   <s:iterator status="current">
   <s:if test="pageBean.currentPage!=current-1">
    <a href="getNoticeBySortAction.action?page=<s:property value="%{current-1}"/>"> 
[<s:property/>]</a> 
    </s:if> 
    <s:else>
    <font color="red"><s:property/></font> 
    </s:else> 
   </s:iterator> 
</s:bean> 
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="getNoticeBySortAction.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="getNoticeBySortAction.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
&nbsp;共 <s:property value="pageBean.allRow"/> 条记录&nbsp;当前第 <s:property value="pageBean.currentPage"/> 页&nbsp;共 <s:property value="pageBean.totalPage"/> 页
</td>
							</tr>
						</table>
						<!-- /페지검색 -->
					</td></tr>
<tr>
					<td width="724" align="center">
						<!--검색 -->
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<td>
								<table border="0" cellpadding="0" cellspacing="0" width="724">
								<tr height="40" bgcolor="#f1e1be">
									<td><img src="${ctx}/coursepage/classical/image/s_left.gif" border="0"></td>
									<td width="7"></td>
									<td><img src="${ctx}/coursepage/classical/image/search.gif" border="0"></td>
									<td width="8"></td>
									<td><select name="select" style="width:73px;height:21px;background-color:#ffffff;color:#777777">
									  <option>标题</option>
									  <option>作者</option>
									  </select>									</td>
									<td width="3"></td>
									<td><input type="text" name="" style="width:197px;height:21px;border:solid 1px #c1a568;background-color:#ffffff"></td>
									<td width="5"></td>
									<td><a href="#"><img src="${ctx}/coursepage/classical/image/button3.gif" border="0"></a></td>
									<td width="143"></td>
									<td><a href="#"><img src="${ctx}/coursepage/classical/image/button2.gif" border="0"></a></td>
									<td width="6"></td>
									<td><img src="${ctx}/coursepage/classical/image/s_right.gif" border="0"></td></tr>
								</table>
							</td></tr>
						</table>
						<!--/검색 -->
					</td></tr>
						</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="style/bottom.jsp"></s:include>
	</body>
</html>
