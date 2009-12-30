<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<table class="listTable">
	
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
					<font color="green">【管理】</font> </a>
				<s:a href="javascript:deleteCourse(%{id})" value="id">   
					<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                      <font color="red">【删除】</font> 
                </s:a>
			</td>
		</tr>
	</s:iterator>
	<tr class="listFooterTr">

	</tr>
</table>

