<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/base.jsp" %>
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="/common/guest_top.jsp" %>
	
	<div id="mainDiv" class="borderDiv">
		
		[新建包裹]
		<form action="bag/add" method="post">
			<input type="hidden" name="surveyId" value="${param.surveyId }">
			<table class="formTable">
				<tr>
					<td>包裹名称</td>
					<td>
						<input type="text" name="bagName">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="新建">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="/common/guest_bottom.jsp" %>
</body>
</html>