<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<title>厦门大学精品课程</title>
		<link href="${ctx}/coursePage/default.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<div id="header">
			<h1>
				<s:text name="">${course.name}</s:text>
				精品课程
				<br />
				<span class="text1"><s:property value="applicationForm.name" />
				</span>
			</h1>
		</div>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="content">
			<div id="right">
				<h2 align="center">
					<strong>课程评价</strong>
				</h2>
				<hr id="border-top" />
				<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
					align=center border=0>
					<tr class=position bgcolor="#ECF3FD">
						<td>
							当前位置: 课程评价
						</td>
					</tr>
				</table>
				<s:form action="expertEvaluateAction" method="post"
					onsubmit="return check(this);">
<s:hidden name="evaluation.id"></s:hidden>
<s:hidden name="evaluation.course.id"></s:hidden>
					<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
						align=center border=0>
						<tr class=editHeaderTr>
							<td class=editHeaderTd colSpan=7>
								请输入个人信息及对该课程的评价
							</td>
						</tr>
						<tr>
							<td bgcolor="#FFFDF0">
								<div align="center">
									姓名：
								</div>
							</td>
							<td colspan="3" bgcolor="#FFFFFF">
								&nbsp;&nbsp;&nbsp;
								<s:textfield cssClass="INPUT" id="expertName"
									name="evaluation.name" label="姓名"></s:textfield>
								&nbsp;*
							</td>
						</tr>
						<tr>
							<td bgcolor="#FFFDF0">
								<div align="center">
									单位：
								</div>
							</td>
							<td colspan="3" bgcolor="#FFFFFF">
								&nbsp;&nbsp;&nbsp;
								<s:textfield cssClass="INPUT" id="expertCompany"
									name="evaluation.company" label="单位"></s:textfield>
								&nbsp;*
							</td>
						</tr>
						<tr>
							<td bgcolor="#FFFDF0">
								<div align="center">
									职位：
								</div>
							</td>
							<td colspan="3" bgcolor="#FFFFFF">
								&nbsp;&nbsp;&nbsp;
								<s:textfield cssClass="INPUT" id="expertPosition"
									name="evaluation.position" label="职位"></s:textfield>
								&nbsp;*
							</td>
						</tr>
						<tr>
							<td bgcolor="#FFFDF0">
								<div align="center">
									电话：
								</div>
							</td>
							<td colspan="3" bgcolor="#FFFFFF">
								&nbsp;&nbsp;&nbsp;
								<s:textfield cssClass="INPUT" id="expertPhone"
									name="evaluation.phone" label="电话"></s:textfield>

							</td>
						</tr>
						<tr>
							<td bgcolor="#FFFDF0">
								<div align="center">
									邮箱：
								</div>
							</td>
							<td colspan="3" bgcolor="#FFFFFF">
								&nbsp;&nbsp;&nbsp;
								<s:textfield cssClass="INPUT" id="expertEmail"
									name="evaluation.email" label="邮箱"></s:textfield>

							</td>

						</tr>
<tr class="bg">
							<td class="first">
								请填写评价分数
							</td>
						</tr>
						<tr>
							<td class="first">
								&nbsp;&nbsp;&nbsp;
								<select id="School" name="evaluatation.score">
									<option value="1">
										&nbsp;1&nbsp;
									</option>
									<option value="2">
										&nbsp;2&nbsp;
									</option>
									<option value="3">
										&nbsp;3&nbsp;
									</option>
									<option value="4">
										&nbsp;4&nbsp;
									</option>
									<option value="5">
									&nbsp;	5&nbsp;
									</option>
								</select>

							</td>
						</tr>
						<tr class="bg">
							<td colspan="4" bgcolor="#FFFFFF">
								<FCK:editor instanceName="evaluation.content" width="100%"
									height="405" toolbarSet="Default">
									<jsp:attribute name="value">
<s:property value="evaluation.content" escape="false"/>
                            </jsp:attribute>
								</FCK:editor>
							</td>
						</tr>
						<tr bgcolor="#ECF3FD">
							<td width="20%">
								&nbsp;
							</td>
							<td width="80%">
								<s:submit cssClass="label" value="确定添加"></s:submit>
								<s:reset cssClass="label" value="取消" />
							</td>
						</tr>
					</table>
				</s:form>



			</div>

			<div id="left">
				<h2>
					<strong>最新更新</strong>
				</h2>
				<p>
					<strong>[06/09/2009]</strong>面向对象以及设计模式
					<a href="#"></a>
				</p>
				<p>
					<strong>[06/06/2009]</strong>Java 语言的基本语句、语法、应用程序开发技巧
				</p>
				<p>
					<strong>[06/03/2009]</strong> 软件工程中的流程模型之瀑布模型
				</p>
				<p>
					<strong>[06/06/2009]</strong>Java 语言的基本语句、语法、应用程序开发技巧
				</p>
				<p>
					<strong>[06/03/2009]</strong> 软件工程中的流程模型之瀑布模型
				</p>
				<p>
					&nbsp;
				</p>
				<h2>
					在线学生
				</h2>
				<ul>
					<li>
						访客用户
					</li>
					<li>
						陈晓明
					</li>
					<li>
						刘晓庆
					</li>
					<li>
						潘粤明
					</li>
				</ul>
				<p>
					&nbsp;
				</p>
			</div>
		</div>
		<jsp:include page="bottom.jsp"></jsp:include>
	</body>
</html>