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
		<title>课程列表</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	color: #FFFFFF;
}

-->
.cm_header {
	padding: 6px;
	border: solid #E6E7E1;
	border-width: 1px 0;
	background: #F5F5F5;
}

.itemtitle {
	clear: both;
	overflow: hidden;
	margin-bottom: 10px;
	line-height: 23px;
}

.itemtitle h1 {
	align: left;
	float: left;
	margin: 0 20px 0 0;
	float: left;
}

.postpm {
	color: #09C;
	float: right;
	font-weight: 700;
}

.itemtitle ul {
	float: left;
}

.itemtitle li {
	float: left;
	margin-right: 5px;
}

.itemtitle ul a {
	display: block;
	overflow: hidden;
	height: 23px;
	cursor: pointer;
}

* html .itemtitle ul a {
	float: left;
}

.itemtitle ul a span {
	display: block;
	padding: 0px 7px; *
	line-height: 22px;
	font-size: 14px;
}

.s_clear {
	zoom: 1;
}

a:link {
	font-size: 12px;
	text-decoration: none;
	color: #000000;
}

a:visited {
	font-size: 12px;
	text-decoration: none;
	color: #000000;
}

a:hover {
	font-size: 12px;
	text-decoration: none;
	color: #FF0000;
}

a.v1:link {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}

a.v1:visited {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}

.cpcontent {
	margin-left: 10px;
	width: auto;
	padding: 0px 15px;
}

.cpcontent h1,.main h1 {
	font-size: 16px;
	font-weight: 400;
	margin-bottom: 5px;
}

.cpcontent h1 {
	margin-bottom: 15px;
}

.pm_list {
	WIDTH: 95%;
}

.pm_list tr td {
	padding: 5px 0;
	border-bottom: 1px solid #E6E7E1;
}

.msg_icon {
	width: 35px;
	text-align: center;
}

.profile_pic {
	width: 60px;
	line-height: 1px;
}

.profile_pic a:hover {
	text-decoration: none;
}

.name_and_date .name {
	display: block;
	width: 150px;
	margin-right: 10px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.name_and_date .name a,.cpbox em {
	color: #09C;
}

.date {
	display: block;
	padding: 1px 0 0 0;
	font-size: 9px;
	color: #999;
}

.pmsubject {
	margin-right: 10px;
	line-height: 14px;
}

.pmsubject .subject_wrap {
	display: block;
	width: 410px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	line-height: 20px;
}

.subject_wrap p a {
	color: #09C;
}

.snippet_wrap a {
	color: #666;
}

.delete_msg {
	width: 24px;
}

.delete_msg a {
	display: block;
	margin-left: 4px;
	margin-top: 5px;
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
	function getMailDetail(mailId,obj) {
		MailService.getMailDetail(mailId, callBack);
	    table1 = document.getElementById("table");
		row1 = table1.insertRow(obj.parentNode.parentNode.parentNode.parentNode.rowIndex + 1);
		currpmdiv = obj.id + '_div'
		alert(obj.parentNode.parentNode.parentNode.parentNode.rowIndex);
	}
	function callBack(data){


		row1.id = currpmdiv;
		row1.className = 'row';
		var cell1 = row1.insertCell(0);
		cell1.innerHTML = '&nbsp;';
		cell1.className = 'altbg1';
		var cell2 = row1.insertCell(1);
		cell2.colSpan = '3';
		cell2.innerHTML=data;
		cell2.className = 'altbg1';
	}

	function showpm(e, obj) {
		var url = obj.href + '&inajax=yes';
		var currpmdiv = obj.id + '_div';
		if (!$(currpmdiv)) {
			var x = new Ajax();
			x.get(url, function(s) {
				var table1 = obj.parentNode.parentNode.parentNode.parentNode;
				var row1 = table1
						.insertRow(obj.parentNode.parentNode.rowIndex + 1);
				row1.id = currpmdiv;
				row1.className = 'row';
				var cell1 = row1.insertCell(0);
				cell1.innerHTML = '&nbsp;';
				cell1.className = 'altbg1';

				var cell2 = row1.insertCell(1);
				cell2.colSpan = '3';
				cell2.innerHTML = s;
				cell2.className = 'altbg1';

				if (prepmdiv) {
					$(prepmdiv).style.display = 'none';
				}
				changestatus(obj);
				prepmdiv = currpmdiv;
			})
		} else {
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
	function deletepm(obj) {
		var pmid = obj.id.substr(obj.id.lastIndexOf('_'));
		$('pm' + pmid).style.display = 'none';
		$('pm_view' + pmid + '_div').style.display = 'none';
		if (folder == 'inbox') {
			$('pm_inbox').innerHTML = parseInt($('pm_inbox').innerHTML) - 1;
			$('pm_total').innerHTML = parseInt($('pm_total').innerHTML) - 1;
		}
	}
	function markunread(obj) {
		var pmid = obj.id.substr(obj.id.lastIndexOf('_'));
		$('pm_view' + pmid).innerHTML = '<b>' + $('pm_view' + pmid).innerHTML + '</b>';
		$('pm_view' + pmid + '_div').style.display = 'none';
		prepmdiv = '';
		if (folder == 'inbox')
			$('pm_unread').innerHTML = parseInt($('pm_unread').innerHTML) + 1;
	}
	function changestatus(obj) {
		if (obj.innerHTML.substr(0, 3).toLowerCase() == '<b>') {
			obj.innerHTML = obj.innerHTML.substr(3, obj.innerHTML.length - 7);
			if (folder == 'inbox' && obj.href.indexOf('folder=announce') == -1)
				$('pm_unread').innerHTML = parseInt($('pm_unread').innerHTML) - 1;
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
			<table id="table" cellspacing="0" width="98%" cellpadding="0" class="pm_list"
				summary="收件箱">
				<div class="cm_header itemtitle s_clear">
					<ul>

						<a style="color: #09C; float: right; font-weight: 700"
							href="usercppostpm.aspx">+ 写新消息</a>
						<li>
							<a id="rBox" href="#" onclick="changeHead(1)"><span>收件箱</span>
							</a>
						</li>
						<li class="current">
							<a href="#" onclick="changeHead(2)"><span>发件箱</span> </a>
						</li>
						<li>
							<a href="#" onclick="changeHead(3)"><span>草稿箱</span> </a>
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
									<a href="###" onclick="getMailDetail(1,this)"><s:property value="title" /> </a>
								</p>
								<div class="snippet_wrap grayfont">
									<s:property value="content" />
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