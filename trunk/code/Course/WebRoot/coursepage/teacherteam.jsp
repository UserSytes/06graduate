<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>厦门大学精品课程</title>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="${ctx}/coursepage/default.css" rel="stylesheet" type="text/css" /></head>
<body>
<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="content">
			<div id="right">
				<h2 align="center">
					<strong>师资力量</strong>
				</h2>
				<hr id="border-top" />
				<table class="listTable">
					<tr class="listHeaderTr">
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
			<tr class="listTr" <s:if test="#teacher.even">style="background-color:#FBFDFD"</s:if>> 
                <td width="20%"><div align="center"><s:property value="name" /></div></td>
                <td width="25%"><div align="center"><s:property value="position" /></div></td>
                <td width="35%"><div align="center"><s:property value="field" /></div></td>
                <td width="20%"><div align="center"><a href="<s:property value="link" />" target="_blank">点击浏览</a></div></td>
              </tr>
</s:iterator>
				</table>
			</div>
	<jsp:include page="left.jsp"></jsp:include>
		</div>
		<jsp:include page="bottom.jsp"></jsp:include>
	</body>
</html>