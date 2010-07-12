<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>学生评价-课程评价-厦门大学课程网络平台</title>
		<link href="${ctx}/coursepage/style/common/common.css"
			rel="stylesheet" type="text/css" />
		<link href="${ctx}/coursepage/style/common/layout.css"
			rel="stylesheet" type="text/css" />
<SCRIPT language=javascript>
	function check(form) {
		if (form.score.value=="") {
			alert("评价分数不能为空！");
			form.score.focus();
			return false;
		}	
		var re = /^[0-9]*$/;
		if (!re.test(form.score.value)) {
			alert("评价分数的格式必须为整数！");
			form.score.focus();
			return false;
		}		
		if (form.score.value<0 ||form.score.value>100 ) {
			alert("请输入0~100的整数");
			form.score.focus();
			return false;
		}		
		form.submit.disabled = true;	
		return true;
	}
</SCRIPT>
	</head>
	<body>
		<!-- 头部 -->
		<s:include value="../style/%{#session.header}"></s:include>
		<div class="content">
			<!-- 左侧 -->
			<s:include value="../style/left.jsp"></s:include>
			<div id="right-cnt">			
				<!-- 正文部分 -->
				<div class="pages">
					<h2>
						<a href="goIndexQueryAction.action">首页</a>&gt;
						<a
							href="<s:url action="evaluateAction"> 
                					</s:url>">课程评价</a>&gt;学生评价
					</h2>					
				</div>
				<!-- 正文 -->
				<div>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table-info">
						<tr height="29">
							<td align="center">
								<font style="font-size: 16px; font-weight: bold">
									我对该课程的评价</font>
							</td>
						</tr>
						<tr height="19">
							<td>
								<font class="timefont">当前平均得分：<s:text
														name="global.format.score">
														<s:param value="stuAvgScore" />
													</s:text>分  | 评价人数: <s:property
										value="stuCount" />人
								</font>
							</td>
						</tr>
						<tr height="1" class="trborder">
							<td></td>
						</tr>
						<tr>
							<td>
								<s:form action="studentEvaluateAction" method="post" onsubmit="return check(this);">
&nbsp;&nbsp; 
			<table cellpadding="0" cellspacing="0" align="center">
										<tr>
											<td>
												<font style="font-size: 16px; font-weight: bold;">请认真填写评价分数（0到100分的整数）</font>
											</td>
											<td align="center">
												&nbsp;&nbsp;&nbsp;
												<s:textfield cssClass="INPUT" id="score" name="score"
													label="分数"></s:textfield>
											<td width="20"></td>
											</td>
											<td>
												<s:submit id="submit" cssClass="label" value="确认" />
												<s:reset cssClass="label" value="取消" />
											</td>
										</tr>
										<tr>


										</tr>
									</table>
								</s:form>
							</td>
						</tr>
<br />
						<tr>
							<td>
								<font color="#74582f" style="font-size: 16px"> 评价标准： <br />
									0-10分：上课不认真。 <br /> 10-20分：课程内容准备不充分。 <br /> 20-30分：上课认真。 <br />
									30-40分：上课认真，课程内容准备充分。 <br /> 40-50分：上课认真，关心同学。 <br />
									50-60分：上课不认真。 <br /> 60-70分：课程内容准备不充分。 <br /> 70-80分：上课认真。 <br />
									80-90分：上课认真，课程内容准备充分。 <br /> 90-100分：上课认真，关心同学。</font>
							</td>
						</tr>
					</table>
				</div>
				<br class="clear" />
			</div>

			<br class="clear" />
		</div>
		<s:include value="../style/bottom.jsp"></s:include>
	</body>
</html>
