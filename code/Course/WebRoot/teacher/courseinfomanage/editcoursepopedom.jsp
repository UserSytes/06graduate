<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>课程申报</title>
	</head>

	<body>		
<div align="center" width="98%">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程管理-&gt; 课程权限设置
				</td>
			</tr>
		</table>

		<s:form action="updateCoursePopedomAction" method="post"
			onsubmit="submit.disabled=1">
			<s:hidden name="popedom.id"></s:hidden>
			<s:hidden name="popedom.course.id"></s:hidden>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						课程内容公开访问对象：
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							教学大纲：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="popedom.outline"
							list="#{0:'所有用户',1:'学生、同行和专家',2:'同行和专家',3:'仅专家',4:'仅自己'}"
							listKey="key" listValue="value" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							课件教案：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="popedom.courseware"
							list="#{0:'所有用户',1:'学生、同行和专家',2:'同行和专家',3:'仅专家',4:'仅自己'}"
							listKey="key" listValue="value" />
					</td>
				</tr>				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							作业习题：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="popedom.exercise"
							list="#{0:'所有用户',1:'学生、同行和专家',2:'同行和专家',3:'仅专家',4:'仅自己'}"
							listKey="key" listValue="value" />
					</td>
				</tr>				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							实验指导：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="popedom.experiment"
							list="#{0:'所有用户',1:'学生、同行和专家',2:'同行和专家',3:'仅专家',4:'仅自己'}"
							listKey="key" listValue="value" />
					</td>
				</tr>				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							教学录像：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="popedom.movie"
							list="#{0:'所有用户',1:'学生、同行和专家',2:'同行和专家',3:'仅专家',4:'仅自己'}"
							listKey="key" listValue="value" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							课程试卷：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="popedom.examination"
							list="#{0:'所有用户',1:'学生、同行和专家',2:'同行和专家',3:'仅专家',4:'仅自己'}"
							listKey="key" listValue="value" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							教学资源：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select name="popedom.book"
							list="#{0:'所有用户',1:'学生、同行和专家',2:'同行和专家',3:'仅专家',4:'仅自己'}"
							listKey="key" listValue="value" />
					</td>
				</tr>
				<tr class=editHeaderTr>
					<td width="30%">
						&nbsp;
					</td>
					<td width="70%">
						<s:submit id="submit" cssClass="label" value="确认" />
						<s:reset cssClass="lable" value="取消"></s:reset>
					</td>
				</tr>
				</s:else>
			</table>
		</s:form>
<div align="left" style="border: 1px solid #ccc;padding: 10px; width: 98%">
				<img src="${ctx}/teacher/images/icon_1.png" width="16" height="16" />
				<strong><font color="red" size="3"> 提示</font> </strong>
				<div id="content_note">
					<ul>
						<li>
							请认真填写课程相关信息和选择课程所属学院。
						</li>
						<li>
							申请新的课程后需要等待所申请学院的教学秘书审核通过才能进行上传课件等操作。
						</li>						
						<li>
							如果您的课程长时间未审核通过，请向教学秘书反映相关情况。
						</li>						
					</ul>

				</div>
			</div>	
</div>
	</body>
</html>
