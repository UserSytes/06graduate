<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="${ctx}/coursepage/default.css" rel="stylesheet" type="text/css" />
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
						<li>
							<a href="#">课程安排（2009-2010学年第二学期）2010年01月5日</a>
						</li>
						<li>
							<a href="#">小组分数方案 2009年11月15日</a>
						</li>
						<li>
							<a href="#">如何学好软件工程 2009年10月6日</a>
						</li>
						<li>
							<a href="#">本周教学内容调整通知 2009年9月16日</a>
						</li>
						<li>
							<a href="#">作业小组安排以及选题 2009年8月26日</a>
						</li>
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
						<strong><a href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>">课程简介</a></strong>
						<br />
						<s:text name="courseintrotext">${courseInfo.content}</s:text>
				</div>
			</div>
			<jsp:include page="left.jsp"></jsp:include>
		</div>
		<jsp:include page="bottom.jsp"></jsp:include>
	</body>
</html>