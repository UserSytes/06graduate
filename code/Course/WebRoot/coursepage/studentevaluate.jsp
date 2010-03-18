
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="${ctx}/coursepage/default.css" rel="stylesheet" type="text/css" /></head>
		<title>厦门大学精品课程</title>
		
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
				<s:form action="studentEvaluateAction" method="post" onsubmit="return check(this);">
&nbsp;&nbsp; 
			<table class="listing form" cellpadding="0" cellspacing="0">
						<tr class="bg">
							<td class="first">
								请认真填写评价分数
							</td>
						</tr>
						<tr>
							<td class="first">
								&nbsp;&nbsp;&nbsp;
								<select id="School" name="score">
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

						<tr bgcolor="#ECF3FD">

							<td class="first">
								评价标准：
								<br>
								1分：上课不认真。
								<br>
								2分：课程内容准备不充分。
								<br>
								3分：上课认真。
								<br>
								4分：上课认真，课程内容准备充分。
								<br>
								5分：上课认真，关心同学。
							</td>
						</tr>
						<tr class="bg">
							<td bgcolor="#FFFDF0">
								<div align="center">
									对课程或老师更多的评价，请写在下面：
								</div>
							</td>
						</tr>
						<tr class="bg">
							<td colspan="4" bgcolor="#FFFFFF">
								<FCK:editor instanceName="content" width="100%"
									height="405" toolbarSet="Default" >
									<jsp:attribute name="value">
                            </jsp:attribute>
								</FCK:editor>
							</td>
						</tr>
						<tr class="bg">

							<td class="first">
								<s:submit cssClass="label" value="确认" />
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