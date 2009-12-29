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
		<title>新闻政策列表</title>
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
					当前位置: 新闻政策管理 -&gt; 新闻政策列表 
				</td>
			</tr>
		</table>
		<div align="center">
			<table class="listTable">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						序号
					</th>
					<th>
						标题
					</th>
					<th>
						发布时间
					</th>
					<th>
						作者
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="newsList" status="news">
					<tr class="listTr">
						<td width="5%">
							<s:property value="#news.count" />
						</td>
						<td width="35%">
							<s:property value="title" />
						</td>
						<td width="25%">
							<s:property value="time" />
						</td>
						<td width="15%">
							<s:property value="author" />
						</td>
						<td width="20%">
							<a
								href="<s:url action="viewNewsAction"> 
                     			<s:param name="newsId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看】</font>
							</a>
							<a
								href="<s:url action="deleteNewsAction"> 
                     			<s:param name="newsId"> 
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