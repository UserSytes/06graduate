<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>厦门大学精品课程</title>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="${ctx}/coursepage/default.css" rel="stylesheet" type="text/css" /></head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../top.jsp"></jsp:include>
<div id="content">
  <div style="width:770px">
<div align="right">
					欢迎你，<s:property value="userInfo.name"/>&nbsp;&nbsp;&nbsp;<a href="<s:url action="enterPersionalSpaceAction"> 
                					</s:url>">
												个人空间
											</a>&nbsp;&nbsp;&nbsp;<a href="<s:url action="logoutFromMessageBoardAction"> 
                					</s:url>">
												退出
											</a>
		<div>
		    <p><img src="${ctx}/coursepage/images/newtopic.gif" alt="新帖" longdesc="http://baidu.com"/>
<div align=right></p>

<table width="100%">
<tr style="background-repeat:repeat-x; background-image: url(${ctx}/coursepage/images/cbg.gif)" >
	<th width="4%">&nbsp;</th>
	<th width="25">&nbsp;</th>
	<th width="55%" align="left">标题
	</th>
	<th width="12%" align="center">作者
	</th>
	<th width="8%" align="center">回复/查看
	</th>
	<th width="17%" align="center">最后发表
	</th>
	</tr>
<s:iterator value="topicList" status="topic">
	<tr>
		<td align="center"><img src="${ctx}/coursepage/images/folder_new.gif" alt="新帖" /></td>
		<td></td>
		<td align="left">
<a href="<s:url action="showMessagesAction"> 
		<s:param name="topicId"> 
		<s:property value="id"/> 
		</s:param>
		</s:url>">
<font color="green"><s:property value="name" /></font></a>
		
</td>
		<td align="center"><s:property value="authorName"/><br><s:date name="time" format="yyyy-MM-dd" /></td>
		<td align="center">回/<s:property value="countPerson"/></td>
		<td align="center">时间<br>by <s:property value="lastAnswer"/></td>
	</tr>
</s:iterator>
</table>
    </div>
		
  </div>
</div>
</div>
<jsp:include page="../bottom.jsp"></jsp:include>
</body>
</html>