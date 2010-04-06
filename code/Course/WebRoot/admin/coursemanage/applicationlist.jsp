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
						操作
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
						<td width="45%">
							<s:property value="remark" />
						</td>
						<td width="20%">
							<a
								href="<s:url action="passInfoAction">
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【通过】</font> </a>
							<a
								href="<s:url action="refuseReasonAction" >
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="red">【退回】</font> </a>
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
								本院所有教师申请新的课程需要等待您审核通过才能进行教学资料上传。
							</li>
							<li>
								若课程审核通过系统将提示教师可以正式开设该课程，并开始上传教学资料、课件等。
							</li>
							<li>
								若课程审核未通过，需要您填写理由，系统自动将退回理由传达给教师。
							</li>
						</ul>
					</div>
				</td>
			</TR>
		</table>
	</body>
</html>