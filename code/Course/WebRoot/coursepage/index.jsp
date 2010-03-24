<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Style-Type" content="text/css">
		<link href="${ctx}/coursepage/default.css" rel="stylesheet"
			type="text/css" />
		<title>厦门大学精品课程</title>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="content">
			<div id="right">
				<h2>
					<strong>本站新闻</strong>
				</h2>
				<p>
					<img src="coursepage/images/img03.jpg" alt="" width="155"
						height="120" class="img1" />
				</p>
				<div>
					<ul>
						<s:iterator value="noticeList" status="notice">
							<li>
								<a
									href="<s:url action="viewNoticeAction"> 
										<s:param name="noticeId"> 
								<s:property value="id"/> 
								</s:param>
								</s:url>"><s:property
										value="title" />
								</a><s:date name="time" format="yyyy-MM-dd hh:mm:ss" />
							</li>
							
						</s:iterator>
					</ul>
					<p>
						&nbsp;
					</p>
				</div>
				<p>
					&nbsp;
				</p>
				<hr id="border-top" />
				<div>
					<p>
						<strong><a
							href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>">课程简介</a>
						</strong>
						<br />
<div style="width:500px; height:400px;overflow:hidden;">
			<!--<s:textarea rows="25" cols="60" name="courseInfo.content" readonly="true" cssStyle="overflow:auto; background-attachment:fixed; background-repeat:no-repeat; border-style:solid; border-color:#FFFFFF"></s:textarea>-->
						<s:text name="courseintrotext">${courseInfo.content}</s:text>...
						<div align="right"><a href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>">查看详细介绍</a></div>
</div>
</div>
			</div>
			<jsp:include page="left.jsp"></jsp:include>
		</div>
		<jsp:include page="bottom.jsp"></jsp:include>
	</body>
</html>