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
		
		[我所有已完成的调查]
		<table class="dataTable" >
<%-- 			<c:if test="${empty surveys }"> --%>
<!-- 				尚未创建调查 -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${!empty surveys}"> --%>
			
<%-- 			</c:if> --%>
			<tr>
				<th>LOGO</th>
				<th>调查名称</th>
				<th>操作</th>
			</tr>
			<tr>
				<td><img alt="" src="static/image/daoMain.png"></td>
				<td>爱好</td>
				<td>查看详情</td>
			</tr>
			
		</table>
		
	</div>
	
	<%@ include file="/common/guest_bottom.jsp" %>
</body>
</html>