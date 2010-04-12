<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><s:property value="course.name"/>-厦门大学课程网络平台</title>
	<link href="${ctx}/coursepage/style/common/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/coursepage/style/common/layout.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/coursepage/style/green/color.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
<!-- 头部 -->
  <s:include value="style/header.jsp"></s:include>
<div class="content">
<!-- 左侧 -->
	 <s:include value="style/left.jsp"></s:include>
  <div id="right-cnt">
	      <div class="col_center">
	        <div class="sub-title"><h2>课程通知</h2><span><a href="<s:url action="getNoticeBySortAction"> 
                     			<s:param name="sort"> 
                       			 	0 
                    			</s:param>
                					</s:url>" class="cblue">MORE</a></span><br class="clear" />
	        </div>
			<ul>
<s:iterator value="noticeList" status="notice">
			    <li><font style="font-size:14px; color:#5a5547"><a href="<s:url action="viewNoticeAction"> 
										<s:param name="noticeId"> 
								<s:property value="id"/> 
								</s:param>
					<s:param name="sort"> 
						<s:property value="0"/>
					</s:param>
								</s:url>"><s:if test="title.length()>20"> 
      										<s:property value="title.substring(0, 20)+'...'" />
													</s:if> <s:else>
												<s:property value="title" />
											</s:else>
								</a></font>
</li>
</s:iterator>
			</ul>
		  </div>
	      <div class="col_center right">
	        <div class="sub-title"><h2>成果展示</h2><span><a href="<s:url action="findAchievementAction"></s:url>" class="cblue">MORE</a></span><br class="clear" /></div>
			<div><s:text name="courseintrotext">${courseInfo.content}</s:text>[<a href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>" class="cgray">详细</a>]</div>

		  </div><br class="clear" />
	<!-- 正文部分 -->	 		  
		    <div class="pages"><h2>课程简介</h2><div id="more"><a href="<s:url action="findCourseInfoAction"> 
                     			<s:param name="sort"> 
                       			 	1 
                    			</s:param>
                					</s:url>" class="cblue">MORE</a></div>
		    <br class="clear" /></div>
<!-- 正文 --> 
<div style="height:350px; overflow:hidden;"><s:text name="courseintrotext">${courseInfo.content}</s:text></div>
<br class="clear" />
			</div>

			<br class="clear" />
		</div>
<br />
	<s:include value="style/bottom.jsp"></s:include>
  </body>
</html>
