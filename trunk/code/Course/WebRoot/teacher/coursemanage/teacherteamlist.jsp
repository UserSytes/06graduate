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
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>教师队伍列表</title>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 我的课程 -&gt; 教师队伍列表
				</td>
			</tr>
		</table>

		<div align="center">
			<table class="listTable">
				<tr>
					<td>
						<a href="coursemanage/addteacherteam.jsp">点击这里添加新的教师<a>
					</td>
				</tr>
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						名字
					</th>
					<th>
						职称
					</th>
					<th>
						研究领域
					</th>
					<th>
						链接
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="teacherTeamList" status="teacherTeam">
					<tr class="listTr">
						<td>
							<s:property value="name" />
						</td>
						<td>
							<s:property value="position" />
						</td>
						<td>
							<s:property value="field" />
						</td>
						<td>
							<a href="javascript:openLink();"><s:property value="link"/></a>							
						</td>
						<td>
							<a
								href="<s:url action="deleteCourseInfoAction"> 
                     			<s:param name="courseInfoId"> 
                       			 	<s:property value="id"/> 
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