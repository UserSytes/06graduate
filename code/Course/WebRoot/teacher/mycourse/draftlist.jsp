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
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<title></title>
		<style type="text/css">
.itemtitle ul a:hover span {
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
		<script type="text/javascript" src="${ctx}/js/mail.js"></script>
		<script type="text/javascript" src="${ctx}/js/prototype.js"></script>
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.pagination2.js"></script>
		<script type="text/javascript" src="${ctx}/js/thickbox.js"></script>
		<script>jQuery.noConflict();</script>
		<script type="text/javascript">
	var prepmdiv = '';
	var folder = 'inbox';
	var table1;
	var row1;
	var currpmdiv;
	function getMailDetail(mailId,e,obj,status) {
		currpmdiv = mailId+ '_div';	
		if (!$(currpmdiv)) {		
		table1 = document.getElementById("table");
		row1 = table1.insertRow(obj.parentNode.parentNode.rowIndex + 1);
		jQuery.post("getMailDetailJsonAction.action", { mailId:mailId},callBack, "json");  
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
	}		

</script>

		<script type="text/javascript">
jQuery(document).ready(function(){
	//这是一个非常简单的demo实例，让列表元素分页显示
	//回调函数的作用是显示对应分页的列表项内容
	//回调函数在用户每次点击分页链接的时候执行
	//参数page_index{int整型}表示当前的索引页
	
	jQuery("#tbody tr:gt(" + 9+ ")").hide().end();
	jQuery("#tbody").css("display","");  
		var num_entries =jQuery("#tbody tr").length;
		// 创建分页
		jQuery("#Pagination").pagination( {
				count:num_entries,
				pageCount:10,
				imagePath:"${ctx}/commons/images",
				callback:function(page_index){	
				jQuery("#table").find("#tbody tr").show();               
          		jQuery("#tbody tr:lt(" + (page_index-1) * 10 + ")").hide().end();                  
       			jQuery("#tbody tr:gt(" + ((page_index) * 10 -1) + ")").hide().end();
			}
		});

});
</script>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 教师信息 -&gt; 消息管理 -&gt; 草稿箱
				</td>
			</tr>
		</table>

		<div align="center" style="width: 98%">
			<s:form id="pmform" name="pmform" method="post"
				action="deleteMailsAction">
				<table id="table" cellspacing="0" width="100%" cellpadding="0"
					class="pm_list" summary="草稿箱">
					<div class="cm_header itemtitle s_clear">
						<ul>
							<a style="color: #09C; float: right; font-weight: 700;"
								href="${ctx}/teacher/mycourse/newmail.jsp" title="撰写短消息">+
								写新消息</a>
							<li>
								<a href="getReceiveMailByTeaAction.action"><span>收件箱</span>
								</a>
							</li>
							<li>
								<a href="getSendMailByTeaAction.action"><span>发件箱</span> </a>
							</li>
							<li class="current">
								<a href="getDraftByTeaAction.action"><span>草稿箱</span> </a>
							</li>
						</ul>
					</div>
					<tbody id="tbody">
						<s:iterator value="mailList" status="mail">
							<tr class="listTr">
								<td class="msg_icon">

									<img id="msg_img" name="msg_img"
										src="${ctx}/teacher/images/pm_0.gif" />

								</td>
								<td class="checkbox_toggle">
									<s:checkbox id="%{id}" name="pmitemid" fieldValue="%{id}" />
								</td>

								<td class="profile_pic">
									<a href="${ctx}/upload/<s:property value="receiver.photo"/>"
										title="" class="thickbox"> <img width="48"
											src="${ctx}/upload/<s:property value="receiver.photo"/>" />
									</a>
								</td>
								<td class="name_and_date">
									<span class="name"><a href="###"> <s:property
												value="receiver.name" /> </a> </span>
									<span class="date"><s:date name="time"
											format="yyyy-MM-dd hh:mm:ss" /> </span>
								</td>

								</td>
								<td class="pmsubject">

									<div class="subject_wrap">

										<p>
											<a
												href="<s:url action="goDraftDetailAction"> 
                     			<s:param name="mailId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"><s:property
													value="title" /> </a>
										</p>
										<div class="snippet_wrap grayfont">
											<s:property value="content" escape="false" />
										</div>
									</div>

								</td>
								<td class="delete_msg">
									<a href="#"
										onclick="getMailDetail(${id},event,this,${status});"
										style="background-image: url('${ctx}/teacher/images/down.gif');"
										title="预览"> </a>
								</td>
								<td class="delete_msg">
									<a
										style="background-image: url('${ctx}/teacher/images/del.gif');"
										href="###"
										onclick="if (confirm('您确定要删除吗?')){$('${id}').checked=true;$('pmform').submit();}"
										title="删除"> </a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:form>
			<div class="cpbox s_clear">
				<div class="pages_btns">
					<div id="Pagination" class="pagination"></div>
					<a href="###" onclick="checkCheckBox($('pmform'),this)">全选</a>
					<span>|</span>
					<a href="###"
						onclick="if (confirm('您确定要删除吗?'))$('pmform').submit();">删除</a>
				</div>
			</div>
		</div>


	</body>
</html>