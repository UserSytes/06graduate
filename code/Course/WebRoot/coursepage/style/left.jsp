<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<html>
	<head>
	</head>
	<body onload="getLeftNotice()">
		<script language="javascript">
	function getLeftNotice() {
		var url = "getLeftNoticeAction.action";
		$('#left-nav-bar').load(url);
	}
	var speed = 80
	var demo = document.getElementById("demo");
	var demo2 = document.getElementById("demo2");
	var demo1 = document.getElementById("demo1");
	demo2.innerHTML = demo1.innerHTML
	function Marquee() {
		if (demo2.offsetTop - demo.scrollTop <= 0)
			demo.scrollTop -= demo1.offsetHeight
		else {
			demo.scrollTop++
		}
	}
	var MyMar = setInterval(Marquee, speed)
	demo.onmouseover = function() {
		clearInterval(MyMar)
	}
	demo.onmouseout = function() {
		MyMar = setInterval(Marquee, speed)
	}
</script>
		<div id="left-nav-bar" class="bg_white">
			<s:include value="leftinfo.jsp"></s:include>
		</div>
	</body>
</html>
