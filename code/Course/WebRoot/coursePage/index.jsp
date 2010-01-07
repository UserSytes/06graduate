<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>厦门大学精品课程</title>
<meta http-equiv="Content-Style-Type" content="text/css">
<link href="${ctx}/coursePage/default.css" rel="stylesheet" type="text/css" /></head>
<body>
<div id="header">
  <h1><s:text name="">${course.name}</s:text>精品课程<br />
	<span class="text1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Xiamen University</span></h1>
</div>
<jsp:include page="top.jsp"></jsp:include>
<div id="content">
	<div id="right">
		<h2 ><strong>本站新闻</strong></h2>
		<p><img src="coursePage/images/img03.jpg" alt="" width="155" height="120" class="img1" /></p>
		<div>
          <ul>
         	<li><a href="#">课程安排（2009-2010学年第二学期）2010年01月5日</a></li>
            <li><a href="#">小组分数方案  2009年11月15日</a></li>
            <li><a href="#">如何学好软件工程  2009年10月6日</a></li>
            <li><a href="#">本周教学内容调整通知  2009年9月16日</a></li>
            <li><a href="#">作业小组安排以及选题  2009年8月26日</a></li>
          </ul>
          <p>&nbsp;</p>
	  </div>
		<p>&nbsp;</p>
		<hr id="border-top" />
		<div>
			<p><strong>课程简介</strong><br />
			作为国家示范性软件学院之一，厦门大学软件学院要面向IT企业、面向社会培养掌握现代软件技术的应用型、工程型软件开发与管理人才。因此，学院始终把《软件工程》这门课程列为软件工程专业的核心课程，每年开课一次，每学期选课人数约300人，重培养学生掌握软件工程理论与技术，按工程规范开发和生产软件。
本课程要能反映软件领域的基本原理、方法、工具、技术和管理。通过该课程的教学，使学生系统地掌握软件工程的基本概念、基本原理；系统地掌握软件的分析、设计、测试的方法和技术；掌握开发软件项目的工程化方法以及在软件开发过程中应遵循的流程、准则、标准和规范等。了解和掌握软件项目管理的基本原理、方法、标准和规范；提高人际交流能力和团队协作精神，使学生今后能按软件工程的理论、方法和技术从事软件项目开发和管理工作。

		</div>
  </div>
	<div id="left">
		<h2><strong>最新更新</strong></h2>
	  <p><strong>[06/09/2009]</strong>面向对象以及设计模式<a href="#"></a></p>
		<p><strong>[06/06/2009]</strong>Java 语言的基本语句、语法、应用程序开发技巧</p>
		<p><strong>[06/03/2009]</strong> 软件工程中的流程模型之瀑布模型</p>
		<p><strong>[06/06/2009]</strong>Java 语言的基本语句、语法、应用程序开发技巧</p>
		<p><strong>[06/03/2009]</strong> 软件工程中的流程模型之瀑布模型</p>
		<p>&nbsp;</p>
		<h2>在线学生</h2>
		<ul>
          <li>访客用户</li>
          <li>陈晓明</li>
          <li>刘晓庆</li>
          <li>潘粤明</li>
    </ul>
		<p>&nbsp;</p>
  </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>