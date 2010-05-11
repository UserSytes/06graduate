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
		<title>新闻政策列表</title>
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

table {
	font-family: "Verdana", "Arial", "Helvetica", "sans-serif";
}
</style>
		<script type="text/javascript">
$(document).ready(function(){
	oTable = $('#example').dataTable( {
			"bJQueryUI" :true,
			"sPaginationType" :"full_numbers"
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
				style="margin: 20px 0 20px 0; color: #000; BACKGROUND-COLOR: #B1CEEE; border: 1px solid #666;font-size: 12px;"
				align=center border=0>
				<tr bgcolor="#ECF3FD" height="25">
					<td>
						当前位置: 新闻政策管理 -&gt; 新闻政策列表
					</td>
				</tr>
			</table>
			<div class="demo_jui" style="margin-top: 10px;">				

				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					class="display" id="example">
					<thead>
					<tr>
					<th>
						序号
					</th>
					<th>
						标题
					</th>
					<th>
						发布时间
					</th>
					<th>
						作者
					</th>
					<th>
						操作
					</th>
				</tr>
				<tbody>
					<s:iterator value="newsList" status="news">
						<tr class="listTr">
							<td width="5%">
								<s:property value="#news.count" />
							</td>
							<td width="35%">
								<s:property value="title" />
							</td>
							<td width="25%">
								<s:date name="time" format="yyyy-MM-dd hh:mm:ss" />
							</td>
							<td width="15%">
								<s:property value="author" />
							</td>
							<td width="20%">
								<a
									href="<s:url action="viewNewsAction"> 
                     			<s:param name="newsId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
									<font color="green">【查看】</font> </a>
								<a
									href="<s:url action="deleteNewsAction"> 
                     			<s:param name="newsId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"
									onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
									<font color="red">【删除】</font> </a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tr class="listFooterTr">
				</tr>
			</table>

		</div>
	</body>
</html>