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
  <div id="right" style="width:700px">
		<h2 align="center"><strong><s:property value="courseMovie.title" /></strong></h2>
		<hr id="border-top" />
<h5 align="right">作者：<s:property value="courseMovie.author" />&nbsp;发布日期：<s:date name="courseMovie.time" format="yyyy-MM-dd" /></h5>
<p style="line-height: 150%"/>
<div align="center">
<object classid=clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA height=480 id=RAOCX name=rmplay width=600>    
<param name="SRC" value="01.rm">    
<param name="CONSOLE" value="Clip1">    
<param name="CONTROLS" value="imagewindow">    
<param name="AUTOSTART" value="true">    
<embed src="01.rm" autostart="true" controls="ImageWindow" console="Clip1" pluginspage="http://www.real.com"/’ target="_blank" >http://www.real.com"; width="356" height="285">    
</embed>    
</object>
<br />
<object classid=clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA height=27 id=video1 width=600> 
<param name="_ExtentX" value="7276"> 
<param name="_ExtentY" value="1058"> 
<param name="AUTOSTART" value="0"> 
<param name="SHUFFLE" value="0"> 
<param name="PREFETCH" value="0"> 
<param name="NOLABELS" value="0"> 
<param name="CONTROLS" value="ControlPanel"> 
<param name="CONSOLE" value="Clip1"> 
<param name="LOOP" value="0"> 
<param name="NUMLOOP" value="0"> 
<param name="CENTER" value="0"> 
<param name="MAINTAINASPECT" value="0"> 
<param name="BACKGROUNDCOLOR" value="#ffffff"> 
<embed type="audio/x-pn-realaudio-plugin" console="Clip1" controls="ControlPanel" height="27" width="356" autostart="0" _extentx="7276" _extenty="1058" shuffle="0" prefetch="0" nolabels="0" loop="0" numloop="0" center="0" maintainaspect="0" backgroundcolor="#ffffff"> 
</embed> 
</object> 
<br />
视频简介：<s:text name="">${courseMovie.content}</s:text>
<br />
视频下载：<a href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="courseMovie.fileLink"/> 
                    			</s:param> 
						<s:param name="originalFileName"> 
                       			 	<s:property value="courseMovie.filename"/> 
                    			</s:param> 
                					</s:url>"
						onclick="JAVAscript:if(!confirm('确认下载附件？')) return false;return true;">
						<font color="red">点此下载</font> </a>
</div>
  </div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>