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
.delete_msg a {
	display: block;
	margin-right: 10px;
	margin-left: 150px;
	margin-top: 10px;
	width: 18px;
	height: 19px;
	background: url(${ctx}/teacher/images/del.gif) no-repeat;
}

.yulan_msg a {
	display: block;
	margin-right: 10px;
	margin-left: 10px;
	margin-top: 10px;
	width: 18px;
	height: 19px;
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

.checkbox_toggle {
	width: 35px;
	text-align: center;
}
</style>
		<script type="text/javascript" src="${ctx}/js/mail.js"></script>
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
	function checkCheckBox(form,objtag)
	{
		if (typeof(objtag.checked) == "undefined")
		{
			objtag.checked = true;
		}
		for(var i = 0; i < form.elements.length; i++) 
		{
			var e = form.elements[i];
			if(e.name == "pmitemid") 
			{
				e.checked = objtag.checked;
			}
		}
		objtag.checked = !objtag.checked;
	}
	    function selectAll() {  
        var arryObj = document.getElementsByName("pmform")  
   for ( var i = 0; i < arryObj.length; i++) {  
   
            if (typeof arryObj[i].type != "undefined"  
   && arryObj[i].type == 'checkbox')  
                arryObj[i].checked = true;  
        }  
    }  
     
   function unSelectAll() {  
       var arryObj = document.getElementsByName("pmform");  
       for ( var i = 0; i < arryObj.length; i++) {  
           if (typeof arryObj[i].type != "undefined"  
                   && arryObj[i].type == 'checkbox')  
              ;  
          arryObj[i].checked = false;  
      }  
   }  
	
	
</script>

	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 教师信息 -&gt; 消息管理
				</td>
			</tr>
		</table>
		<div align="center" style="width: 100%">
			<form id="pmform" name="pmform" method="post" action="">
				<table id="table" cellspacing="0" width="98%" cellpadding="0"
					class="pm_list" summary="收件箱">
					<div class="cm_header itemtitle s_clear">
						<ul>

							<a style="color: #09C; float: right; font-weight: 700" href="##">+
								写新消息</a>
							<li class="current">
								<a href="#"><span>收件箱</span> </a>
							</li>
							<li>
								<a href="#"><span>发件箱</span> </a>
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
							<td class="checkbox_toggle">
								<s:checkbox id="pmitemid" theme="simple" name="pmitemid"
									value="id" />
							</td>

							<td class="profile_pic">

								<img width="48" src="<s:property value="sender.photo"/>" />
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
										<s:property value="content" escape="false" />
									</div>
								</div>

							</td>
							<td class="yulan_msg">
								<a href="#"
									style="background-image: url('${ctx}/teacher/images/del.gif')">
								</a>
							</td>
							<td class="delete_msg">
								<a
									style="background-image: url('${ctx}/teacher/images/del.gif')"
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
			</form>
			<div class="cpbox s_clear">
				<div class="pages_btns">
					<div class="pages">
						<em>共有短消息:1条</em>
					</div>
					<a href="###" onclick="checkCheckBox($('pmform'),this)">全选</a>
					<span class="pipe">|</span>
					<a href="###"
						onclick="if (confirm('您确定要删除吗?'))$('pmform').submit();">删除</a>
				</div>
			</div>

		</div>
	</body>
</html>