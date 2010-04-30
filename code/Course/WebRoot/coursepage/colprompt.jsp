<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<style type="text/css">

.alert_info {
	padding: 6px 10px 6px 58px;
	line-height: 160%;
	background: url() no-repeat 8px 50%;
	font-size: 14px;
}
</style>
</head>
	<body>
		<!-- 头部 -->
		<div style="width: 400">
			<div style="padding: 15px;">
				<div class="alert_info"
					style="background-image: url(${ctx}/coursepage/style/common/error_big.gif)">
					<p>
						<font style="font-size: 16px;"><s:fielderror /> <s:actionmessage />
							<s:actionerror /></font>
					</p>					
				</div>
			</div>
		</div>
	</body>
</html>
