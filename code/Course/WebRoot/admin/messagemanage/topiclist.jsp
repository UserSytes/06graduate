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
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>留言列表</title>
		<style type="text/css">
<!--
.STYLE1 {
	color: #000000
}
-->
</style>
	</head>
	<body>
<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 留言管理 -&gt; 留言列表 
				</td>
			</tr>
		</table>

<div align="center">
			<s:form action="searchTopicByKeyAction" method="post">
				<table class="listTable">
					<tr>
						<td bgcolor="#FFFDF0">
							<div align="center">
								请输入主题关键字：
							</div>
						</td>
						<td colspan="3" bgcolor="#FFFFFF">
							&nbsp;&nbsp;&nbsp;
							<s:textfield cssClass="INPUT" id="topicKey"
							name="topicKey" label="关键字"></s:textfield>
						</td>
					</tr>
					<tr bgcolor="#ECF3FD">
						<td width="20%">
							&nbsp;
						</td>
						<td width="80%">
							<s:submit cssClass="label" value="关键字查找"></s:submit>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<div align="center">
			<table class="listTable">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						点击数
					</th>
					<th>
						回复
					</th>
					<th>
						课程
					</th>
					<th>
						标题
					</th>
					<th>
						作者
					</th>
					<th>
						最后回复
					</th>
                    <th>
						操作
					</th>
				</tr>
				<s:iterator value="topicList" status="topic">
					<tr class="listTr">
						<td width="8%">
							<s:property value="countPerson" />
						</td>
						<td width="5%">
							<s:property value="countReply" />
						</td>
						<td width="15%">
							<s:property value="course.name" />
						</td>
                        <td width="25%">
							<s:property value="name" />
						</td>
						<td width="12%">
							<s:property value="authorName" />
						</td>
						<td width="15%">
							<s:property value="lastUpdate+lastAnswer" />
						</td>
						<td width="20%">
							<a
								href="<s:url action="viewTopicAction"> 
                     			<s:param name="topicId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看】</font>
							</a>
							<a
								href="<s:url action="deleteTopicAction"> 
                     			<s:param name="topicId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"  onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
								<font color="red">【删除】</font>
							</a>
						</td>
					</tr>
				</s:iterator>
				<tr class="listFooterTr">
				</tr>
			</table>
		</div>
	</body>
</html>