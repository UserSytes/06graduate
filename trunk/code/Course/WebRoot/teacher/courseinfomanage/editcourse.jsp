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

	<body onload="getSchool()">
		<script type="text/javascript" src="/dwr/engine.js"></script>
		<script type="text/javascript" src="/dwr/util.js"></script>
		<script type="text/javascript" src="/dwr/interface/DepartmentDAO.js"></script>
		<script type="text/javascript" src="/dwr/interface/SchoolDAO.js"></script>
		<script language="javascript">
</script>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程申报-&gt; 课程信息
				</td>
			</tr>
		</table>

		<s:form action="updateCourseAction" method="post"
			onsubmit="return check(this);">
			<s:hidden name="course.id"></s:hidden>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						课程信息：
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							院系：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="course.department.name" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							级别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="course.level" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							名称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="course.name" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							备注：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="course.remark" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							访问人数：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:property value="course.count" />
					</td>
				</tr>
				<s:if test="course.status==2">
					<tr>
						<td bgcolor="#FFFDF0">
							<div align="center">
								被拒原因:
							</div>
						</td>
						<td colspan="3" bgcolor="#FFFFFF">
							&nbsp;&nbsp;&nbsp;
							<s:property value="course.refuseReason" />
						</td>
					</tr>
				</s:if>
				<s:else>
					<tr>
						<td bgcolor="#FFFDF0">
							<div align="center">
								公开访问：
							</div>
						</td>
						<td colspan="3" bgcolor="#FFFFFF">
							&nbsp;&nbsp;&nbsp;
							<s:select name="course.visible" list="#{1:'是',0:'否'}" listKey="key"
								listValue="value" />
						</td>
					</tr>
					<tr class=editHeaderTr>
						<td width="30%">
							&nbsp;
						</td>
						<td width="70%">
							<s:submit loadingText="正在提交，请稍候……" cssClass="label" value="确认" />
							<s:reset cssClass="lable" value="取消"></s:reset>
						</td>
					</tr>
				</s:else>
			</table>
		</s:form>
	</body>
</html>
