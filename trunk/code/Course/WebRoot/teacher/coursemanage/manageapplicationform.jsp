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
		<title>修改密码</title>
		<SCRIPT language=javascript>
			function check(form)
			{
				if (form.userName.value == "")
				{
					alert("名字不能为空！");
					return false;
				}
			}
		</SCRIPT>
	</head>

	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position>
				<td>
					当前位置: 我的课程 -&gt; 课程简介
				</td>
			</tr>
		</table>

		<s:form action="addApplicationFormAction" method="post"  enctype="multipart/form-data"  
			onsubmit="return check(this);">&nbsp;&nbsp; 
			<s:hidden name="applicationForm.id"></s:hidden>
<s:hidden name="applicationForm.filename"></s:hidden>
<s:hidden name="applicationForm.fileLink"></s:hidden>
			<s:hidden name="applicationForm.course.id"></s:hidden>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						添加课程申报表格：
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							推荐省市：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield name="applicationForm.province"  cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							所属学校：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield name="applicationForm.school" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							推荐单位：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield name="applicationForm.recommender" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							课程名称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield name="applicationForm.name" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							课程层次(本/专)：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select id="level" list="{'本科','专科'}"
							name="applicationForm.level"></s:select>

					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							课程类型：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:select id="level" list="{'理论课(不含实践)','理论课(含实践)','实践课'}"
							name="applicationForm.sort"></s:select>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							所属一级学科名称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield name="applicationForm.firstSubject" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							所属二级学科名称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield name="applicationForm.secondSubject" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							课程负责人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:textfield name="applicationForm.responser" cssClass="input" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							申报时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:head />
						<s:datetimepicker displayFormat="yyyy-MM-dd" name="applicationForm.time" />
					</td>
				</tr>
<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							上传文件：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<s:file name="upload"></s:file>
					</td>
				</tr>
				
				<tr class=editHeaderTr>
					<td width="30%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="70%">
						<s:submit cssClass="label" value="确认" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>