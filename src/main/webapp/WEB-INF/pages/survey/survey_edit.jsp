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
		
		<table class="dataTable">
			<tr>
				<td>LOGO</td>
				<td>调查名称</td>
				<td>操作</td>
			</tr>
			<tr>
				<td>
					<img alt="" src="${survey.logoPath }">
				</td>
				<td>${survey.surveyName }</td>
				<td>
					<a href="#">删除</a>
					<a href="#">完成</a>
				</td>
			</tr>
		</table>
		<br><br><br><br>
		<table class="dataTable">
			<c:if test="${empty survey.bags }">
				<tr>
					<td>
						<br>
						[还没有创建包裹<span><a href="bag/toAdd?surveyId=${survey.id }" style="text-decoration-line:underline">创建包裹</a></span>]
						<br>
						<br>
					</td>
				</tr>
			</c:if>
			<c:if test="${!empty survey.bags }">
				<c:forEach items="${survey.bags}" var="bag">
					<tr>
						<td>包裹名称</td>
						<td>${bag.bagName }</td>
					</tr>
					<tr>
						<td>预览</td>
						<td>
							<c:if test="${empty bag.questions }">
								[暂时还没有创建问题]
							</c:if>
							<c:if test="${!empty bag.questions }">
								<table class="dataTable">
									<c:forEach items="${bag.questions }" var="question">
										<tr>
											<td>
												
											</td>
										</tr>
									</c:forEach>
								</table>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				
			</c:if>
		</table>
		
	</div>
	
	<%@ include file="/common/guest_bottom.jsp" %>
</body>
</html>