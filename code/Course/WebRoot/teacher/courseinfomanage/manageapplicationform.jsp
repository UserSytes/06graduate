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
		<script type="text/javascript">		
		function check(form)
		{
		if (form.province.value == "")
		{
			alert("推荐省市不能为空！");
			form.province.focus();
			return false;
		}
		if (form.school.value == "") {
			alert("推荐学校不能为空！");
			form.school.focus();
			return false;
		}		
		if (form.recommender.value == "") {
			alert("推荐单位不能为空！");
			form.recommender.focus();
			return false;
		}
		
		if (form.name.value == "") {
			alert("课程名称不能为空！");
			form.name.focus();
			return false;
		}
		if (form.firstSub.value == "") {
			alert("所属一级学科名称不能为空！");
			form.firstSub.focus();
			return false;
		}
		if (form.secondSub.value == "") {
			alert("所属二级学科名称不能为空！");
			form.secondSub.focus();
			return false;
		}
		if (form.responser.value == "") {
			alert("课程负责人不能为空！");
			form.responser.focus();
			return false;
		}
		var time= dojo.widget.byId("time");
		if (time.getValue() == "")
		{
			alert("申报时间不能为空！");			
			return false;
		}		
		form.submit.disabled = true;
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
		<s:form action="addApplicationFormAction" method="post"
			enctype="multipart/form-data" onsubmit="return check(this);">
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
						<s:textfield id="province" name="applicationForm.province" cssClass="input" />
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
						<s:textfield id="school" name="applicationForm.school" cssClass="input" />
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
						<s:textfield id="recommender" name="applicationForm.recommender" cssClass="input" />
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
						<s:textfield id="name" name="applicationForm.name" cssClass="input" />
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
						<s:textfield id="firstSub" name="applicationForm.firstSubject" cssClass="input" />
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
						<s:textfield id="secondSub" name="applicationForm.secondSubject" cssClass="input" />
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
						<s:textfield id="responser" name="applicationForm.responser" cssClass="input" />
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
						<s:datetimepicker id="time" displayFormat="yyyy-MM-dd"
							name="applicationForm.time" />
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
						<s:file id="upload" name="upload"></s:file>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							查看原来附件：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						&nbsp;&nbsp;&nbsp;
						<a
							href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="applicationForm.fileLink"/> 
                    			</s:param> 
								<s:param name="originalFileName"> 
                       			 	<s:property value="applicationForm.filename"/> 
                    			</s:param> 
                					</s:url>">
							<font color="red"><s:property
									value="applicationForm.filename" /> </font> </a>
					</td>
				</tr>
				<tr class=editHeaderTr>
					<td width="30%" class=editFooterTd>
						&nbsp;
					</td>
					<td width="70%">
						<s:submit id="submit" cssClass="label" value="确认" />
						<s:reset cssClass="label" value="取消" />
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>