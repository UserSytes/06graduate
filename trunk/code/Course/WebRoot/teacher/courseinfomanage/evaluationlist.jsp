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
		<title>参考书籍列表</title>
		<SCRIPT language=javascript>
	
</SCRIPT>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 我的课程 -&gt; 课程评价列表
				</td>
			</tr>
		</table>

		<div align="center">
			<table class="listTable">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						姓名
					</th>
					<th>
						职称
					</th>
					<th>
						单位
					</th>
					<th>
						评分
					</th>
<th>
状态
</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="evaluationList" status="evaluation">
					<tr class="listTr">
						<td>
							<s:property value="name" />
						</td>
						<td>
							<s:property value="position" />
						</td>
						<td>
							<s:property value="company" />
						</td>
						<td>
							<s:property value="score" />
						</td>
<td>
							<s:if test="status==1">己评</s:if>
						<s:if test="status==0">未评</s:if>
						<td>
							<a
								href="<s:url action="getEvaluationDetailAction"> 
                     			<s:param name="evaluationId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【查看详情】</font> </a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</body>
</html>