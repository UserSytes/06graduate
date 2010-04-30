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
		<LINK href="${ctx}/css/admin.css" type=text/css rel=stylesheet>
		<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.pagination.js"></script>
		<title>校管理员列表</title>
<script type="text/javascript">
$(document).ready(function(){
	//这是一个非常简单的demo实例，让列表元素分页显示
	//回调函数的作用是显示对应分页的列表项内容
	//回调函数在用户每次点击分页链接的时候执行
	//参数page_index{int整型}表示当前的索引页
	var $table = $('#table');
	$("#tbody tr:gt(" + 9+ ")").hide().end();
	$("#tbody").css("display","");  
		var num_entries = $("#tbody tr").length;
		// 创建分页
		$("#Pagination").pagination( {
				count:num_entries,
				pageCount:10,
				imagePath:"${ctx}/commons/images",
				callback:function(page_index){							
		 			$table.find("#tbody tr").show();               
          			$("#tbody tr:lt(" + (page_index-1) * 10 + ")").hide().end();                  
       				$("#tbody tr:gt(" + ((page_index) * 10 -1) + ")").hide().end();
			}
		});

});
</script>
	</head>
	<body>
	<div align="center">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 管理员管理 -&gt; 校管理员列表
				</td>
			</tr>
		</table>
			<table id="table" class="listTable" style="">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						序号
					</th>
					<th>
						登陆账号
					</th>
					<th>
						姓名
					</th>
					<th>
						Email邮箱
					</th>
					<th>
						电话
					</th>
					<th>
						操作
					</th>
				</tr>
				<tbody id="tbody" style="display: none;">
				<s:iterator value="superAdminList" status="superAdmin">
					<tr class="listTr">
						<td width="5%">
							<s:property value="#superAdmin.count" />
						</td>
						<td width="15%">
							<s:property value="account" />
						</td>
						<td width="10%">
							<s:property value="name" />
						</td>
						<td width="20%">
							<s:property value="email" />
						</td>
						<td width="15%">
							<s:property value="mobile" />
						</td>
						<td width="20%">
							<a
								href="<s:url action="deleteSuperAdminAction"> 
                     			<s:param name="superAdminId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"  onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
								<font color="red">【删除】</font> </a>
							<a
								href="<s:url action="restoreSuperAdminPasswordAction"> 
                     			<s:param name="superAdminId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"  onclick="JAVAscript:if(!confirm('确认还原初始密码？')) return false;return true;">
								<font color="green">【还原初始密码】</font>
							</a>
						</td>
					</tr>
				</s:iterator>
				</tbody>
				<tr class="listFooterTr">

				</tr>
			</table>
<div id="Pagination" class="pagination"></div>
		</div>
	</body>
</html>