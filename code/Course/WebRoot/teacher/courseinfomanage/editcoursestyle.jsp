<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<script type="text/javascript" src="${ctx}/js/jquery.tools.min.js"></script>
		<title>课程风格</title>
	</head>

	<body>
		<script>
	$( function() {
		var style='bluet';
		$("div.scrollable").scrollable();
		$(".items img").click( function() {
			
			// calclulate large image's URL based on the thumbnail URL (flickr specific)
				var url = $(this).attr("src").replace("_t", "");
				style =  $(this).attr("id");				
				// get handle to element that wraps the image and make it semitransparent
				var wrap = $("#image_wrap").fadeTo("medium", 0.5);

				// the large image from flickr
				var img = new Image();

				// call this function after it's loaded
				img.onload = function() {

					// make wrapper fully visible
					wrap.fadeTo("fast", 1);

					// change the image
					wrap.find("img").attr("src", url);

				};

				// begin loading the image from flickr
				img.src = url;

				// when page loads simulate a "click" on the first image
			}).filter(":first").click();
			$("#setstyle").click( function() {
			var courseId = $("#courseId").val();
				window.location.href="setCourseStyleAction.action?courseId="+courseId+"&style="+style;
			});
			
	});
</script>
		<style type="text/css">
BODY {
	FONT-SIZE: 12px; LINE-HEIGHT: 150%; FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"
}
#image_wrap { /* dimensions */
	width: 800px;
	margin: 15px 0 15px 40px;
	padding: 15px 0;
	/* centered */
	text-align: center;
	/* some "skinning" */
	background-color: #efefef;
	border: 2px solid #fff;
	outline: 1px solid #ddd;
	-moz-ouline-radius: 4px;
}

.scrollable { /* required settings */
	position: relative;
	overflow: hidden;
	width: 800px;
	height: 120px;
	/* custom decorations */
	border: 1px solid #ccc;
	background: url(${ctx}/teacher/img/h300.png) repeat-x;
}

.scrollable .items { /* this cannot be too large */
	width: 20000em;
	position: absolute;
	clear: both;
}

/* single scrollable item */
.scrollable img {
	float: left;
	margin: 20px 5px 20px 21px;
	background-color: #fff;
	padding: 2px;
	border: 1px solid #ccc;
	cursor: pointer;
	width: 100px;
	height: 70px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
}

/* active item */
.scrollable .active {
	border: 2px solid #000;
	z-index: 9999;
	position: relative;
}

.scrollable {
	float: left;
}

/* prev, next, prevPage and nextPage buttons */
a.browse {
	background: url(${ctx}/teacher/img/hori_large.png) no-repeat;
	display: block;
	width: 30px;
	height: 30px;
	float: left;
	margin: 40px 10px;
	cursor: pointer;
	font-size: 1px;
}

/* right */
a.right {
	background-position: 0 -30px;
	clear: right;
	margin-right: 0px;
}

a.right:hover {
	background-position: -30px -30px;
}

a.right:active {
	background-position: -60px -30px;
}

/* left */
a.left {
	margin-left: 0px;
}

a.left:hover {
	background-position: -30px 0;
}

a.left:active {
	background-position: -60px 0;
}

/* disabled navigational button */
a.disabled {
	visibility: hidden !important;
}

div,span,p,ul,li {
	text-align: left;
}

div.box{
	outline:1px solid #999;
	border:2px solid #fff;
	margin: 160px 0 15px 40px;
	padding:10px;
	width:780px;
	background-color:#F0F1F2;
	/* outline radius */
	outline-radius:4px;
	-moz-outline-radius:4px;
	-webkit-outline-radius:4px;	
}

</style>
		<div align="center"
			style="padding-left: 5px; padding-right: 5px; width: 98%">
			<table cellSpacing=1 cellPadding=0 width="100%"
				style="margin: 20px 0 20px 0; color: #000; BACKGROUND-COLOR: #87ceeb; border: 1px solid #666;"
				align=center border=0>
				<tr bgcolor="#B0E0E6" height="25">
					<td>
						当前位置: 课程管理 -&gt; 风格设置
					</td>
				</tr>
			</table>

<div>
<s:hidden id="courseId" name="courseId"></s:hidden>
			<div id="image_wrap">

				<!-- Initially the image is a simple 1x1 pixel transparent GIF -->
				<img src="${ctx}/teacher/img/bluet.jpg" width="750" height="519" />

			</div>

			<!-- "previous page" action -->
			<a class="prevPage browse left"></a>
			<!-- root element for scrollable -->
			<div class="scrollable">

				<!-- root element for the items -->

				<div class="items">

					<!-- 1-8 -->
					<img id="bluet" src="${ctx}/teacher/img/bluet_t.jpg" />
					<img id="greent" src="${ctx}/teacher/img/greent_t.jpg" />
					<img id="whitet" src="${ctx}/teacher/img/whitet_t.jpg" />
					<img id="grayt" src="${ctx}/teacher/img/grayt_t.jpg" />
					<img id="oranget" src="${ctx}/teacher/img/oranget_t.jpg" />
					<img id="pinkt" src="${ctx}/teacher/img/pinkt_t.jpg" />
					<img id="purplet" src="${ctx}/teacher/img/purplet_t.jpg" />
					<img id="redt" src="${ctx}/teacher/img/redt_t.jpg" />

					<!-- 9-16 -->
					<img id="blued" src="${ctx}/teacher/img/blued_t.jpg" />
					<img id="greend" src="${ctx}/teacher/img/greend_t.jpg" />
					<img id="whited" src="${ctx}/teacher/img/whited_t.jpg" />
					<img id="grayd" src="${ctx}/teacher/img/grayd_t.jpg" />
					<img id="oranged" src="${ctx}/teacher/img/oranged_t.jpg" />
					<img id="pinkd" src="${ctx}/teacher/img/pinkd_t.jpg" />
					<img id="purpled" src="${ctx}/teacher/img/purpled_t.jpg" />
					<img id="redd" src="${ctx}/teacher/img/redd_t.jpg" />

					<!-- 17-24 -->
					<img id="blues" src="${ctx}/teacher/img/blues_t.jpg" />
					<img id="greens" src="${ctx}/teacher/img/greens_t.jpg" />
					<img id="whites" src="${ctx}/teacher/img/whites_t.jpg" />
					<img id="grays" src="${ctx}/teacher/img/grays_t.jpg" />
					<img id="oranges" src="${ctx}/teacher/img/oranges_t.jpg" />
					<img id="pinks" src="${ctx}/teacher/img/pinks_t.jpg" />
					<img id="purples" src="${ctx}/teacher/img/purples_t.jpg" />
					<img id="reds" src="${ctx}/teacher/img/reds_t.jpg" />
				</div>

			</div>

			<!-- "next page" action -->
			<a class="nextPage browse right"></a>
</div>
<div class="box">
	<s:submit id="setstyle" value="提交"></s:submit><s:reset value="取消"></s:reset>
</div>

		</div>

	</body>
</html>
