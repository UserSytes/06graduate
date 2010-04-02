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
		<SCRIPT language=javascript>
		function showTopicsByTime(time) {
			window.location.href = "showTopicsByTeacherAction.action?time="+time;
		}
</SCRIPT>
	</head>
	<body>
		<div id="content">
			<div style="width: 100%">
				<div>
					<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
						align=center border=0>
						<tr class=position bgcolor="#ECF3FD">
							<td>
								当前位置: 课程管理 -&gt; 留言管理
							</td>
						</tr>
					</table>
					<table class=listTable align="center">
						<tr>
							<td>
								请选择查询时间：&nbsp;&nbsp;&nbsp;
								<s:select name="time"
									list="#{0:'全部',1:'最近一天',3:'最近三天',7:'最近七天',30:'最近一月'}"
									listKey="key" listValue="value"
									onchange="javascript:showTopicsByTime(this.value)" />

							</td>
						</tr>
					</table>
					<div align=center>

						<table class="listTable">
							<tr class="listHeaderTr"
								<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>

								<th width="4%">
									&nbsp;
								</th>								
								<th width="40%" align="left">
									标题
								</th>
								<th width="12%" align="center">
									所属课程
								</th>

								<th width="18%" align="center">
									作者
								</th>
								<th width="8%" align="center">
									回复/查看
								</th>
								<th width="18%" align="center">
									最后发表
								</th>
							</tr>
							<s:iterator value="topicList" status="topic">
								<tr class="listTr">
									<td align="center">
										<img src="${ctx}/coursepage/images/folder_new.gif" border="0"
											alt="新帖" />
									</td>
									
									<td align="left">
										<a
											href="<s:url action="showMessagesByTeaAction"> 
		<s:param name="topicId"> 
		<s:property value="id"/> 
		</s:param>
		</s:url>">
											<font color="green"> <s:property value="name" />
										</font> </a>

									</td>
									<td align="center">
										<s:property value="course.name" />
									</td>
									<td align="center">
										<s:property value="authorName" />
										<s:date name="time" format="yyyy-MM-dd" />
									</td>
									<td align="center">
										<s:property value="countReply" />
										/
										<s:property value="countPerson" />
									</td>
									<td align="center">
										<s:property value="lastAnswer" />
										<s:date name="lastUpdate" format="yyyy-MM-dd" />
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>

				</div>
			</div>
		</div>
	</body>
</html>