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
		<title>课程列表</title>
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
					当前位置: 课程管理 -&gt; 课程评价
				</td>
			</tr>
		</table>
		<div align="center">
		<s:form action="showEvaluateCoursesAction" method="post"
			onsubmit="return check(this);">
			<table class="listTable">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						序号
					</th>
					<th>
						课程名
					</th>
					<th>
						序号
					</th>
					<th>
						课程名
					</th>
				</tr>
				<s:iterator value="courseList" status="course">
					<s:if test="#course.odd||#course.first">
						<tr class="listTr">
					</s:if>
					<td width="5%">
						<s:property value="#course.count" />
					</td>
					<td width="40%">
						<s:checkbox  theme="simple" name="courseIds" value="flase" fieldValue="%{id}"></s:checkbox>
						<s:property value="name" />&nbsp;[<s:property value="teacher.userInfo.name" />]
					</td>
					<s:if test="#course.even||#course.last">
						<tr>
					</s:if>
				</s:iterator>
                <tr class="listFooterTr">
					<td colspan="4">
						<s:submit id="button" cssClass="label" value="查看评价"></s:submit>
					</td>
				</tr>
			</table>
		</s:form>
		</div>
	</body>
</html>