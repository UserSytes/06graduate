<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>搜索帖子&lt;--厦门大学精品课程</title>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="${ctx}/coursepage/default.css" rel="stylesheet"
			type="text/css" />
<SCRIPT language=javascript>
	function check(form) {
		if (form.keyword.value == "" && form.keyname.value==""&&form.keydate.value=null) {
			alert("搜索条件不能全为空，请重新搜索！");
			return false;
		}
		return true;
	}
</SCRIPT>

		<style type="text/css">

	</head>
	<body>
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../top.jsp"></jsp:include>
		<div id="content">
			<div style="width: 770px">
<div>主题高级搜索-></div>
	<s:form action="searchTopicByKeyAction" onsubmit="return check(this);" method="post" enctype="multipart/form-data">
									<table border="0" cellpadding="0" cellspacing="0" align="center" >
										<tr height="35">
											<td width="100" align="right">
												标题关键字
											</td>
											<td width="300" align="center">
												<s:textfield name="keyword" cssClass="text" size="40"/>
											</td>
										</tr>
<tr height="35">
											<td width="100" align="right">
												发帖人姓名
											</td>
											<td width="300" align="center">
												<s:textfield name="authorName" cssClass="text" size="40"/>
											</td>
										</tr>
<tr height="35">
											<td width="100" align="right">
												搜索时间
											</td>
											<td width="300" align="center">
											
												<s:head /> 
												<s:datetimepicker id="time" displayFormat="yyyy-MM-dd"
							name="keydate" />
											</td>
										</tr>
<tr><td width="80">
												<input type="submit" name="submit" value="提交 ">
											</td></tr>
									</table>
								</s:form>
			</div>
		</div>

		<jsp:include page="../bottom.jsp"></jsp:include>
	</body>
</html>