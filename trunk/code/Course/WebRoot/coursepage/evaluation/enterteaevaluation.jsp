<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/student.css" type=text/css rel=stylesheet>
		<title>厦门大学精品课程</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="${ctx}/coursepage/default.css" rel="stylesheet"
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
		<jsp:include page="${ctx}/coursepage/top.jsp"></jsp:include>
		<div id="content">
			<div id="right">
				<h2 align="center">
					<strong>教师对课程《<s:text name="">${course.name}</s:text>》的评价</strong>
				</h2>
				<hr id="border-top" />

				<table class="listing form" cellpadding="0" cellspacing="0">

					<tr class="bg">
						<td class="first">

							教师	<s:property value="evaluation.name" />对该门课程的评价分数是：
<br>
							<s:text name="">${evaluation.score}</s:text>
<br><br>评价内容是：<br>
							<s:text name="">${evaluation.content}</s:text>
							
						</td>
					</tr>
					<tr class="bg">
						<td class="first" align="center">
							<br>
							<a
								href="<s:url action="tDetailEvaluateAction"> 
                     			<s:param name="course"> 
                       			 	<s:property value="id"/> 
                    			</s:param>
                					</s:url>">我要评价</a>

						</td>
					</tr>
				</table>
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
		<jsp:include page="${ctx}/coursepage/bottom.jsp"></jsp:include>
	</body>
</html>