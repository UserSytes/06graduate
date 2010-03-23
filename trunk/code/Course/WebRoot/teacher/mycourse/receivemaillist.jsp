<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<LINK href="${ctx}/css/mail.css" type=text/css rel=stylesheet>

		<title>课程列表</title>
		<style type="text/css">
.delete_msg {
	width: 200px;
}

.delete_msg a {
	display: block;
	margin-right: 10px;
	margin-left: 150px;
	margin-top: 10px;
	width: 18px;
	height: 19px;
	background: url(${ctx}/teacher/images/del.gif) no-repeat;
}

.delete_msg a:hover {
	background: #3B5998 url(${ctx}/teacher/images/del.gif) no-repeat;
}

itemtitle ul a:hover span {
	background: url(${ctx}/teacher/images/btn_block.gif) no-repeat 100%
		-69px;
}

.itemtitle ul .current a,.itemtitle ul .current a:hover {
	background: url(${ctx}/teacher/images/btn_block.gif) no-repeat 0 0;
}

.itemtitle ul .current a span,.itemtitle ul .current a:hover span {
	background: url(${ctx}/teacher/images/btn_block.gif) no-repeat 100%
		-23px;
	color: #FFF;
}

</style>
		<script type="text/javascript" src="/dwr/engine.js"></script>
		<script type="text/javascript" src="/dwr/util.js"></script>
		<script type="text/javascript" src="/dwr/interface/MailService.js"></script>
		<script type="text/javascript">
			var prepmdiv = '';
	var folder = 'inbox';
	var table1;
	var row1;
	var currpmdiv;
	function getMailDetail(mailId,e,obj) {
	
		currpmdiv = mailId+ '_div';	
		if (!$(currpmdiv)) {
		table1 = document.getElementById("table");
		row1 = table1.insertRow(obj.parentNode.parentNode.parentNode.parentNode.rowIndex + 1);
		MailService.getMailDetail(mailId, callBack);	   
					$(prepmdiv).style.display = 'none';
				changestatus(obj);
				prepmdiv = currpmdiv;
			}
		else {
			if ($(currpmdiv).style.display == 'none') {
					$(currpmdiv).style.display = '';
				changestatus(obj);
				if (prepmdiv) {
					$(prepmdiv).style.display = 'none';
				}
				prepmdiv = currpmdiv;
			} else {
				$(currpmdiv).style.display = 'none';
				prepmdiv = '';
			}
		}
				doane(e);
	}
	function callBack(data){


		row1.id = currpmdiv;
		row1.className = 'row';
		var cell1 = row1.insertCell(0);
		cell1.innerHTML = '&nbsp;';
		cell1.className = 'altbg1';
		cell1.colSpan = '2';
		var cell2 = row1.insertCell(1);
		cell2.colSpan = '3';
		cell2.innerHTML=data;
		cell2.className = 'altbg1';
		
	}

	
	function changestatus(obj) {
		if (obj.innerHTML.substr(0, 3).toLowerCase() == '<b>') {
			obj.innerHTML = obj.innerHTML.substr(3, obj.innerHTML.length - 7);
			if (folder == 'inbox' && obj.href.indexOf('folder=announce') == -1)
				$('pm_unread').innerHTML = parseInt($('pm_unread').innerHTML) - 1;
		}
	}
	function doane(event) {
	e = event ? event : window.event ;
	if(is_ie) {
		e.returnValue = false;
		e.cancelBubble = true;
	} else {
		e.stopPropagation();
		e.preventDefault();
	}
}
	
</script>

	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 课程管理 -&gt; 课程列表
				</td>
			</tr>
		</table>
		<div align="center" style="width: 100%">
			<table id="table" cellspacing="0" width="98%" cellpadding="0"
				class="pm_list" summary="收件箱">
				<div class="cm_header itemtitle s_clear">
					<ul>

						<a style="color: #09C; float: right; font-weight: 700"
							href="usercppostpm.aspx">+ 写新消息</a>
						<li>
							<a href="#" ><span>收件箱</span>
							</a>
						</li>
						<li class="current">
							<a href="#" ><span>发件箱</span> </a>
						</li>
						<li>
							<a href="#"><span>草稿箱</span> </a>
						</li>
					</ul>
				</div>
				<s:iterator value="mailList" status="mail">
					<tr class="listTr">
						<td class="msg_icon">
							<img src="${ctx}/teacher/images/pm_0.gif" title="已读" />
						</td>

						<td class="profile_pic">

							<img width="48"
								onerror="this.onerror=null;this.src='${ctx}/teacher/images/noavatar_small.gif'"
								src="${ctx}/teacher/images/noavatar_small.gif" />

						</td>
						<td class="name_and_date">
							<span class="name"><a href="###"> <s:property
										value="sender.name" /> </a> </span>
							<span class="date">今天 10:23</span>
						</td>

						</td>
						<td class="pmsubject">

							<div class="subject_wrap">

								<p>
									<a href="###" onclick="getMailDetail(${id},event,this)"><s:property
											value="title" /> </a>
								</p>
								<div class="snippet_wrap grayfont">
									<s:property value="content" escape="false"/>
								</div>
							</div>

						</td>
						<td class="delete_msg">
							<a
								href="<s:url action="goAddCourseStudentBatchByTeaAction"> 
                     			<s:param name="courseId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</body>
</html>