<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<title>我的课程</title>
	</head>

	<body>
		<script language="javascript">
	function check(form) {

	}
	function getCourseByState(){
	document.getElementById("form").submit();
		 
		
	}
	
</script>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程申报 -&gt; 课程申报
				</td>
			</tr>
		</table>

<s:form id="form" action="getMyCourseAction" method="post">
		<div align="center">
			<table class="listTable">
				<tr>
					<td>
						筛选：&nbsp;&nbsp;&nbsp;
						<s:select name="type" list="#{2:'全部',1:'己审核',0:'未审核'}" 
							listKey="key" listValue="value" onchange="getCourseByState()" />

					</td>
				</tr>
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						课程id
					</th>
					<th>
						课程名称
					</th>
					<th>
						级别
					</th>
					<th>
						学院
					</th>
					<th>
						系
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="myCoursesList" status="course">
					<tr class="listTr">
						<td>
							<s:property value="id" />
						</td>
						<td>
							<s:property value="name" />
						</td>
						<td>
							<s:property value="level" />
						</td>
						<td>
							<s:property value="department.school.name" />
						</td>
						<td>
							<s:property value="department.name" />
						</td>
						<td>
							<a
								href="<s:url action="findDepartmentAction"> 
                     			<s:param name="schoolId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看】</font> </a>
							<a
								href="<s:url action="deleteCourseAction" > 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="red">【删除】</font> </a>
						</td>
					</tr>
				</s:iterator>
				<tr class="listFooterTr">

				</tr>
			</table>
		</div>
</s:form>
	</body>
</html>
