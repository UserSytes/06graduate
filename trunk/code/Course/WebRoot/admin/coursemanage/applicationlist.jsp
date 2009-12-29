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
		<title>申报课程列表</title>
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
					当前位置: 课程管理 -&gt; 申报课程列表 
				</td>
			</tr>
		</table>
		<div align="center">
			<table class="listTable">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						课程名
					</th>
					<th>
						教师
					</th>
					<th>
						简介
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="applicationCourseList" status="course">
					<tr class="listTr">
						<td width="20%">
							<s:property value="name" />
						</td>
						<td width="10%">
							<s:property value="teacher.userInfo.name" />
						</td>
						<td width="45%">
							<s:property value="remark" />
						</td>
						<td width="25%">
							<a
								href="<s:url action="coursePassAction">
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"  onclick="JAVAscript:if(!confirm('确认通过？')) return false;return true;">
								<font color="green">【通过】</font>
							</a>
							<a
								href="<s:url action="refuseReasonAction" >
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>" >
								<font color="red">【退回】</font>
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