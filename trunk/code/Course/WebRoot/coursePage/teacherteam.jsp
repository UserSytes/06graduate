<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>厦门大学精品课程</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="../${ctx}/coursePage/default.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<div id="header">
			<h1>
				精品课程
				<br />
				<span class="text1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property
						value="applicationForm.name" />
				</span>
			</h1>
		</div>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="content">
			<div id="right">
				<h2 align="center">
					师资力量
				</h2>
				<hr id="border-top" />
				<table class=editTable cellSpacing=1 cellPadding=0 align=center
					border=1>
					<tr height="30">
						<th>
							<div align="center">
								教师姓名
							</div>
						</th>
						<th>
							<div align="center">
								职称
							</div>
						</th>
						<th>
							<div align="center">
								研究领域
							</div>
						</th>
<th>
							<div align="center">
								个人简历
							</div>
						</th>
					</tr>
					<s:iterator value="teacherTeamList" status="teacher">
			<tr bgcolor="#73C5E5" height="30" align="center" valign="middle"  <s:if test="#teacher.even">style="background-color:#FBFDFD"</s:if>> 
                <td width="50"><div align="center"><s:property value="name" /></div></td>
                <td width="60"><div align="center"><s:property value="position" /></div></td>
                <td width="290"><div align="center"><s:property value="field" /></div></td>
                <td width="50"><div align="center"><a href="<s:property value="link" />" target="_blank">点击浏览</a></div></td>
              </tr>
</s:iterator>
				</table>
			</div>

			<div id="left">
				<h2>
					Recent Updates
				</h2>
				<p>
					<strong>[06/09/2006]</strong> Etiam odio mi, suscipit et, rhoncus
					ac, lacinia, nisl. Aliquam gravida massa eu arcu.
					<a href="#">More&#8230;</a>
				</p>
				<p>
					<strong>[06/06/2006]</strong> Fusce mollis tristique sem. Sed eu
					eros imperdiet eros interdum blandit. Vivamus sagittis bibendum
					erat. Curabitur malesuada.
					<a href="#">More&#8230;</a>
				</p>
				<p>
					<strong>[06/03/2006]</strong> Nunc pellentesque. Sed vestibulum
					blandit nisl. Quisque elementum convallis purus. Suspendisse
					potenti. Donec nulla est, laoreet quis, pellentesque in.
					<a href="#">More&#8230;</a>
				</p>
				<h2>
					Ipsum Dolorem
				</h2>
				<ul>
					<li>
						<a href="#">Sagittis Bibendum Erat</a>
					</li>
					<li>
						<a href="#">Malesuada Turpis</a>
					</li>
					<li>
						<a href="#">Quis Gravida Massa</a>
					</li>
					<li>
						<a href="#">Inerat Viverra Ornare</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="footer">
			<p>
				Copyright &copy; 2006 Sitename.com. Designed by
				<a href="http://www.freecsstemplates.org" class="link1">Free CSS
					Templates</a>
			</p>
		</div>
	</body>
</html>
<span style="display: none;"><a href="http://www.mobanwang.com"
	title="ҳģ">ҳģ</a>
</span>
<span style="display: none;"><a href="http://www.mobanwang.com"
	title="ҳģ">ҳģ</a>
</span>