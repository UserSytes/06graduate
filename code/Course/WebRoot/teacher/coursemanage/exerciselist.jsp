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
		<title>习题列表</title>
		<SCRIPT language=javascript>		
			function goToAddExercise(){
			 window.location.href="goAddExerciseAction.action";
			}

		</SCRIPT>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 我的课程 -&gt; 课件列表
				</td>
			</tr>
		</table>
		<div align="right">

			<input type="button" onclick="goToAddExercise()" value="添加习题" />
			&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div align="center">
			<table class="listTable">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						章节目录
					</th>
					<th>
						标题
					</th>
					<th>
						时间
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="exerciseList" status="exercise">
					<tr class="listTr">
						<td>
							<s:property value="chapter.number" />
							---
							<s:property value="chapter.name" />
						</td>
						<td>
							<s:property value="title" />
						</td>
						<td>
							<s:date format="yyyy-MM-dd" name="time" />
						</td>
						<td>
							<a
								href="<s:url action="goEditExerciseAction"> 
                     			<s:param name="exerciseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【编辑】</font> </a>
							<a
								href="<s:url action="deleteExerciseAction"> 
                     			<s:param name="exerciseId"> 
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