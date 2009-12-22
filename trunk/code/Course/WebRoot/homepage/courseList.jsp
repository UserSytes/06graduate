<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="../Images/css1/admin.css" type=text/css rel=stylesheet>
		<title>精品课程搜索引擎->课程查询结果</title>
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
					当前位置: 首页 -&gt; 搜索结果
				</td>
			</tr>
		</table>
		<table align="center">
				<tr <s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						序号   
					</th>
					<th>
						课程名称   
					</th>
					<th>
						当前状态
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="courseList" status="course">
					<tr>
						<td>
							<s:property value="id" />
						</td>
						<td>
							<s:property value="name" />
						</td>
						<td>
							<s:property value="remark" />
						</td>
						<td>
							<a
								href="<s:url action="enterCourseAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看】</font></a>
						</td>
						<td>
							<a
								href="<s:url action="AddCollectionAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="red">【加入收藏】</font></a>
						</td>
					</tr>
				</s:iterator>
			</table>
			<s:url id="url_pre" value="courses.action">
				<s:param name="pageNow" value="pageNow-1"></s:param>
			</s:url>
			<s:url id="url_next" value="courses.action">
				<s:param name="pageNow" value="pageNow+1"></s:param>
			</s:url>
			<s:a href="%{url_pre}">上一页</s:a>

			<s:iterator value="courses" status="status">
				<s:url id="url" value="courses.action">
					<s:param name="pageNow" value="pageNow" />
				</s:url>
			</s:iterator>
			<s:a href="%{url_next}">下一页</s:a>

	</body>
</html>