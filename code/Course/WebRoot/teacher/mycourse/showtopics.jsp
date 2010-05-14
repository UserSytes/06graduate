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
		<link href="${ctx}/facebox/facebox.css" media="screen"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" language="javascript"
			src="${ctx}/js/jquery.dataTables.js" charset="gb2312"></script>
		<script src="${ctx}/facebox/facebox.js" type="text/javascript"></script>

		<title>留言列表</title>

		<style type="text/css" title="currentStyle">
@import "${ctx}/css/demo_page.css";

@import "${ctx}/css/demo_table_jui.css";

@import "${ctx}/css/jquery-ui-1.7.2.custom.css";

div,span,p,ul,li {
	text-align: left;
}

a {
	text-decoration: none;
}

a,a:link,a:visited {
	color: #036;
}

a:hover {
	color: #0000cd;
}

.tr-content td {
	color: #036;
}
</style>
		<script type="text/javascript">
	$(document).ready( function() {
			oTable = $('#example').dataTable( {
			"bJQueryUI" :true,
			"sPaginationType" :"full_numbers",
			"aoColumns": [
			{ "sSortDataType": "dom-text", "sType": "numeric" },
			null,
			null,
			{ "sSortDataType": "dom-text", "sType": "numeric" },
			{ "sSortDataType": "dom-text", "sType": "numeric" },				
			null,
			null]	
		});
		$('a[rel*=facebox]').facebox( {
			loading_image :'${ctx}/facebox/loading.gif',
			close_image :'${ctx}/facebox/closelabel.gif'
		})

		});
</script>
	</head>
	<body id="dt_example">
		<div align="center"
			style="padding-left: 5px; padding-right: 5px; width: 98%">
			<table cellSpacing=1 cellPadding=0 width="100%"
				style="margin: 20px 0 20px 0; color: #000; BACKGROUND-COLOR: #87ceeb; border: 1px solid #666;"
				align=center border=0>
				<tr bgcolor="#B0E0E6" height="25">
					<td>
						当前位置: 课程管理 -&gt; 留言管理
					</td>
				</tr>
			</table>

			<div class="demo_jui" style="margin-top: 10px;">
				<a href="${ctx}/teacher/mycourse/newtopic.jsp" rel="facebox"><img
						src="${ctx}/coursepage/classical/image/newtopic.gif" alt="新帖"
						border="0" /> </a>

				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					class="display" id="example">
					<thead>
						<tr>
							<th>

							</th>
							<th width="480">
								标题
							</th>
							<th width="130">
								作者
							</th>
							<th width="60">
								回复
							</th>
							<th width="50">
								查看
							</th>
							<th width="130">
								最后发表
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="topicList" status="topic">
							<tr height="33" class="tr-content">
								<td width="30">
									<s:property value="#topic.count" />
									</div>
								</td>
								<td width="480" align="left" style="font-weight: bold">

									<a class="titlea"
										href="<s:url action="showMessagesByTeaAction">		
																<s:param name="topicId"> 
																	<s:property value="id"/> 
																	</s:param>
																</s:url>">
										<s:property value="name" /> </a>
								</td>
								<td width="130" align="center">
									<s:property value="authorName" />
									<br>
									<s:date name="time" format="yyyy-MM-dd hh:mm" />
								</td>
								<td width="60" align="center">
									<s:property value="countReply" />&nbsp;
								</td>
								<td width="50" align="center">									
								<s:property value="countPerson" />&nbsp;									
								</td>
								<td width="130" align="center">
									<s:property value="lastAnswer" />
									<br>
									<s:date name="lastUpdate" format="yyyy-MM-dd hh:mm" />
								</td>
								<td width="80" align="center">
									<a
										href="<s:url action="deleteTopicByTeaAction"> 
                     			<s:param name="topicId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"
										onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
										<font color="red">【删除】</font> </a>
								</td>
							</tr>
						</s:iterator>
					</tbody>

				</table>
				<!--/게시판 -->
			</div>
		</div>
		<br>
	</body>
</html>