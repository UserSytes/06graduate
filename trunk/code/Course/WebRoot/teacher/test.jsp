<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<title>我的课程</title>
	</head>

	<body>
		<script type="text/javascript" src="../js/prototype.js"></script>
		<script language="javascript">
	function getCourseByState() {
		document.getElementById("form").submit();
	}
	function getCourseByType(type) {
        var url = "getMyCourseInLeft.action?type="+type;
   		new Ajax.Updater (   
        	'courseListMain',   
        	url,    
       		 {   
         	   onLoading:function (){   
         	   },   
         	   onSuccess:function (request) {   
       		   },    
       		   onFailure:function (request) {   
                 alert("服务器故障，请稍候重试");  
         	  }   
      	  }   
   	 	);   
	}  
		function deleteCourse(courseId) {
        var url = "deleteCourseAction.action?courseId="+courseId;   
   		new Ajax.Updater (   
        	'courseListMain',   
        	url,    
       		 {   
         	   onLoading:function (){   
         	   },   
         	   onSuccess:function (request) {   
       		   },    
       		   onFailure:function (request) {   
                 alert("服务器故障，请稍候重试");  
         	  }   
      	  }   
   	 	);   
	}  
	
</script>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程申报 -&gt; 课程申报
				</td>
			</tr>
		</table>

		<div id="courseListMain" align="center">
			<s:property escape="false" value="test"></s:property>


		</div>
	</body>
</html>
