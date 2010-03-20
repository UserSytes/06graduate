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
		<title>学生列表</title>
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
					当前位置: 课程管理 -&gt; 课程列表 -&gt;
					<s:text name="">${course.name}</s:text>
					-&gt; 学生列表
				</td>
			</tr>
		</table>

		<div align="center"  id="search1">
			<s:form action="findStudentByNoAction" method="post">
				<s:hidden name="course.id" />
				<table class="listTable">
					<tr class=editHeaderTr>
						<td class=editHeaderTd colSpan=7>查找学生 
						</td>
					</tr>
					<tr>
						<td bgcolor="#FFFDF0">
							<div align="center">
								请输入学生帐号：
							</div>
						</td>
						<td colspan="3" bgcolor="#FFFFFF">
							&nbsp;&nbsp;&nbsp;
							<s:textfield cssClass="INPUT" id="studentNo"
							name="studentNo" label="账号" ></s:textfield>
						</td>
					</tr>
					<tr bgcolor="#ECF3FD">
						<td width="20%">
							&nbsp;
						</td>
						<td width="80%">
							<s:submit cssClass="label" value="查找"></s:submit>
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
						序号
					</th>
					<th>
						姓名
					</th>
					<th>
						学号
					</th>
					<th>
						年级
					</th>
					<th>
						所属系
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="studentList" status="student">
					<tr class="listTr">
						<td width="5%">
							<s:property value="#student.count" />
						</td>
						<td width="15%">
							<s:property value="userInfo.name" />
						</td>
						<td width="20%">
							<s:property value="studentNo" />
						</td>
						<td width="20%">
							<s:property value="grade.name+grade.grade" />
						</td>
						<td width="20%">
							<s:property value="userInfo.department.name" />
						</td>
						<td width="20%">
							<a
								href="<s:url action="deleteStudentFromCourseAction"> 
                     			<s:param name="studentId"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
								<s:param name="courseId"> 
                       			 	${course.id}
                    			</s:param>  
                					</s:url>"
								onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
								<font color="red">【删除】</font> </a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</body>
</html>