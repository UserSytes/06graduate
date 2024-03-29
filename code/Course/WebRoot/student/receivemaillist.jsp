<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />
		<link type=text/css rel=stylesheet href="${ctx}/homepage/link.css">
		<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<LINK href="${ctx}/css/mail.css" type=text/css rel=stylesheet>

		<title>站内信-厦门大学课程中心</title>
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
			if(status == 1){
			var e = table1.rows[obj.parentNode.parentNode.rowIndex].cells[0].firstChild;
			e.src="${ctx}/teacher/images/pm_0.gif";
			}
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
						$(prepmdiv).style.display = 'none';	}
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
	<body topmargin="0" leftmargin="0" marginheight="0" marginwidth="0"
		background="${ctx}/homepage/image/back_img.gif"
		style="background-repeat: repeat-x">

		<s:include value="../homepage/include/header.jsp"></s:include>
		<!-- left -->
		<table border="0" cellpadding="0" cellspacing="0" width="950"
			align="center">
			<tr height="100%">
				<td width="200" align="center" valign="top">
					<s:include value="left.jsp"></s:include>
				</td>
				<td width="750" valign="top" align="right">
					<!-- main -->
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- main2 主题图 -->
							<td valign="top">
								<img src="${ctx}/homepage/image/main_img2.jpg" border="0">
							</td>
							<!--/main2 主题图 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr height="27">
							<!-- 主题 -->
							<td valign="top">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="11"></td>
										<td>
											<img style="float: left"
												src="${ctx}/homepage/image/title_myletter.gif" border="0"
												alt="">
										</td>
									</tr>
									<tr height="3">
										<td width="11"></td>
										<td bgcolor="#d7d7d7" width="738"></td>
									</tr>
								</table>
							</td>
							<!--/ 主题 -->
						</tr>
						<tr height="11">
							<td></td>
						</tr>
						<tr>
							<td valign="top" align="left">

								<div align="center" style="width: 100%">
									<s:form id="pmform" name="pmform" method="post"
										action="deleteMailsByStuAction">
										<table id="table" cellspacing="0" width="98%" cellpadding="0"
											class="pm_list" summary="收件箱">
											<div class="cm_header itemtitle s_clear">
												<ul>
													<a style="color: #09C; float: right; font-weight: 700;"
														href="goNewMailByStuAction.action" title="撰写短消息">+
														写新消息</a>
													<li class="current">
														<a href="getReceiveMailByStuAction.action"><span>收件箱</span>
														</a>
													</li>
													<li>
														<a href="getSendMailByStuAction.action"><span>发件箱</span>
														</a>
													</li>
													<li>
														<a href="getDraftByStuAction.action"><span>草稿箱</span>
														</a>
													</li>
												</ul>
											</div>
											<tbody id="tbody">
												<s:iterator value="mailList" status="mail">
													<tr class="listTr">
														<td class="msg_icon">

															<img id="msg_img" name="msg_img"
																src="${ctx}/teacher/images/pm_<s:property value="status"/>.gif" />

														</td>
														<td class="checkbox_toggle">
															<s:checkbox id="%{id}" name="pmitemid" fieldValue="%{id}" />
														</td>

														<td class="profile_pic">
															<a
																href="${ctx}/upload/<s:property value="sender.photo"/>"
																title="" class="thickbox"> <img width="48"
																	src="${ctx}/upload/<s:property value="sender.photo"/>" />
															</a>
														</td>
														<td class="name_and_date">
															<span class="name" style="float: left"><a
																href="###"> <s:property value="sender.name" /> </a> </span>
															<span class="date"><s:date name="time"
																	format="yyyy-MM-dd hh:mm:ss" /> </span>
														</td>

														</td>
														<td class="pmsubject">

															<div class="subject_wrap">

																<p>
																	<a
																		href="<s:url action="goReceiveMailDetailByStuAction"> 
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
																href="<s:url action="goReplyMailByStuAction"> 
                     			<s:param name="mailId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"
																style="background-image: url('${ctx}/teacher/images/reply.gif');"
																title="回复"> </a>
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
							</td>
						</tr>
					</table>

					<!-- /内容 -->
				</td>
			</tr>
		</table>


		<!-- 底部 -->
		<s:include value="../homepage/include/bottom.jsp"></s:include>

	</body>
</html>