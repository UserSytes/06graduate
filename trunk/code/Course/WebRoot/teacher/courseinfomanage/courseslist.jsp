<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<table class="listTable">

	<tr class="listHeaderTr"
		<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
		<th>
			序号
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
			状态
		</th>
		<th>
			操作
		</th>
	</tr>
	<s:iterator value="myCoursesList" status="course">
		<tr class="listTr">
			<td>
				<s:property value="#course.count" />
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
				<s:if test="status==1">已审核</s:if>
				<s:if test="status==0">未审核</s:if>
				<s:if test="status==2">未通过</s:if>
			</td>
			<td>
				<a
					href="<s:url action="goEidtCourseAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
					<font color="green">【详情】</font> </a>
				<s:a
					onclick="JAVAscript:if(!confirm('如果删除该课程，将会删除该课程下的所有内容，请谨慎操作？')) return false;"
					href="javascript:deleteCourse(%{id})" value="id">
					<s:param name="courseId">
						<s:property value="id" />
					</s:param>
					<font color="red">【删除】</font>
				</s:a>
			</td>
		</tr>
	</s:iterator>
	<tr class="listFooterTr">

	</tr>
</table>

