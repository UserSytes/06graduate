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
					当前位置: 课程管理 -&gt; 课程评价  -&gt;评价比对
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
						序号&nbsp; 
					</th>
					<th>
						课程
					</th>
					<th>
						学生评价
					</th>
					<th>
						专家评价
					</th>
					<th>
						同行评价
					</th>
				</tr>
				<s:iterator value="courseEvaluateList" status="ce">
					<tr class="listTr">
						<td width="5%">
							<s:property value="#ce.count" />
						</td>
						<td width="35%">
							<s:property value="courseName" />&nbsp; [<s:property value="teacherName" />]
						</td>
						<td width="20%">
							<s:property value="stuAvgScore" />分&nbsp; /共<s:property value="stuCount" />人
						</td>
						<td width="20%">
							<s:property value="expertAvgScore" />分&nbsp; /共<s:property value="expertCount" />人
						</td>
						<td width="20%">
							<s:property value="teacherAvgScore" />分&nbsp; /共<s:property value="teacherCount" />人
						</td>
					</tr>
				</s:iterator>
				<tr class="listFooterTr">
					<td colspan="5" align="right">
						<s:submit id="button" cssClass="label" value="图表显示"></s:submit>
					</td>
				</tr>
			</table>
			</s:form>
		</div>
	</body>
</html>