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
		<title>参考书籍列表</title>
		<SCRIPT language=javascript>		
			function goToAddBook(){
			 window.location.href="${ctx}/teacher/coursemanage/addbook.jsp";
			}
		</SCRIPT>
	</head>
	<body>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=position bgcolor="#ECF3FD">
				<td>
					当前位置: 我的课程 -&gt; 参考书籍列表
				</td>
			</tr>
		</table>
		<table class=listTable align="center">
			<tr>
				<td>
					<div align="right">
						<input type="button" onclick="goToAddBook()" value="添加参考书籍" />
					</div>
				</td>
			</tr>
		</table>
		<div align="center">
			<table class="listTable">
				<tr class="listHeaderTr"
					<s:if test="#st.odd">style="background-color:#bbbbbb"</s:if>>
					<th>
						书名
					</th>
					<th>
						作者
					</th>
<th>
						出版社
					</th>					
					<th>
						出版时间
					</th>
					<th>
						下载
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="bookList" status="book">
					<tr class="listTr">
						<td>
							<s:property value="name" />
						</td>
						<td>
							<s:property value="author" />
						</td>	
<td>
							<s:property value="publication" />
						</td>					
						<td>
							<s:date format="yyyy-MM-dd" name="time" />
						</td>
						<td>
							<a
								href="<s:url action="download"> 
                     			<s:param name="fileName"> 
                       			 	<s:property value="fileLink"/> 
                    			</s:param> 
								<s:param name="originalFileName"> 
                       			 	<s:property value="filename"/> 
                    			</s:param> 
                					</s:url>">
								<font color="blue"><s:property value="filename" /> </font> </a>
						</td>
						<td>
							<a
								href="<s:url action="goEditBookAction"> 
                     			<s:param name="bookId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>">
								<font color="green">【编辑】</font> </a>
							<a
								href="<s:url action="deleteBookAction"> 
                     			<s:param name="bookId"> 
                       			 	<s:property value="id"/> 
                    			</s:param> 
                					</s:url>"
								onclick="JAVAscript:if(!confirm('确认删除？')) return false;return true;">
								<font color="red">【删除】</font> </a>
						</td>
					</tr>
				</s:iterator>


			</table>
		</div>
	</body>
</html>