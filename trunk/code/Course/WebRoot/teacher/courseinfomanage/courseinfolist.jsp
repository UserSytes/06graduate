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
		<title>课程信息列表</title>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 我的课程 -&gt; 课程信息列表
				</td>
			</tr>
		</table>

		<div align="center">
			<table class="listTable">
				<tr>
					<td>
						<a href="coursemanage/addcourseinfo.jsp">点击这里添加新的课程信息<a>

					</td>
				</tr>
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						标题
					</th>
					<th>
						目录
					</th>
					<th>
						时间
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="courseInfoList" status="courseInfo">
					<tr class="listTr">
						<td>
							<a
								href="<s:url action="deleteAdminAction"> 
                     			<s:param name="courseInfoId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<s:property value="title" /> </a>
						</td>
						<td>
							<s:set name="myflag" value="sort"/>
							<s:if test="#myflag==1">课程简介</s:if>
							<s:if test="#myflag==2">教学大纲</s:if>
						</td>



						<td>
							<s:date name="time" format="yyyy-MM-dd hh:mm" />
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