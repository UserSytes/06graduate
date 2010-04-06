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
					当前位置: 课程管理 -&gt; 课程列表 
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
						课程名
					</th>
					<th>
						教师
					</th>
					<th>
						简介
					</th>
					<th>
						学生
					</th>
				</tr>
				<s:iterator value="applicationCourseList" status="course">
					<tr class="listTr">
						<td width="5%">
							<s:property value="#course.count" />
						</td>
						<td width="20%">
							<s:property value="name" />
						</td>
						<td width="10%">
							<s:property value="teacher.userInfo.name" />
						</td>
						<td width="35%">
							<s:property value="remark" />
						</td>
						<td width="30%">
							<a
								href="<s:url action="viewCourseStudentAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看】</font>
							</a>
							<a
								href="<s:url action="goAddCourseStudentAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="blue">【添加】</font>
							</a>
							<a
								href="<s:url action="goAddCourseStudentBatchAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="blue">【批量添加】</font>
							</a>
						</td>
					</tr>
				</s:iterator>
				<tr class="listFooterTr">

				</tr>
			</table>
		</div>

	  <table bgcolor="white" class=editTable cellSpacing=1 cellPadding=0
			width="90%" align=center border=0>
			<TR>
				<td bgcolor="white">
					<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
					<strong><font color="red" size="3"> 提示</font> </strong>
					<div id="content_note">
						<ul>
							<li>
								课程列表罗列本院所有审核通过的课程。
							</li>
							<li>
								您可以管理各门课程的学生，主要是为课程添加和删除学生。
							</li>
							<li>
								您可以点击对应课程学生列的“查看”链接去查看该课程的所有学生。
							</li>
							<li>
								您可以通过点击列表中对应课程的“添加”操作来添加学生到改课程中。
							</li>
							<li>
								您也可以点击“批量添加”，一次性添加大量学生到课程中。
							</li>
						</ul>
					</div>
				</td>
			</TR>
		</table>
	</body>
</html>