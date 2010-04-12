<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>My JSP 'green.jsp' starting page</title>
	<link href="${ctx}/coursepage/style/common/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/coursepage/style/common/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/coursepage/style/green/color.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  <s:include value="style/header.jsp"></s:include>
<div class="content">
	 <s:include value="style/left.jsp"></s:include> 
  <div id="right-cnt">		 		  
		    <div class="pages"><h2>成果展示</h2><div id="more"><a href="#" class="cblue">MORE</a></div>
		    <br class="clear" /></div>
<div><font style="font-size: 12px; color: #74582f">自从1968年提出“软件工程”这一术语以来，研究软件工程的专家学者们陆续提出了100多条关于软件工程的准则或信条。美国著名的软件工程专家巴利·玻姆（Barry Boehm）综合这些专家的意见，并总结了美国天合公司（TRW）多年的开发软件的经验，于1983年提出了软件工程的七条基本原理。</font></div>
<br class="clear" />
  </div>
  
  <br class="clear" />
</div>
	<s:include value="style/bottom.jsp"></s:include>
  </body>
</html>
