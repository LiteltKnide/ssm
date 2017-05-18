<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/base.jsp"%>
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/common/guest_top.jsp"%>

	<div id="mainDiv" class="borderDiv">

		<c:if test="${empty page.result }">
			暂时没有调查
		</c:if>
		<c:if test="${!empty page.result}">
			<c:if test="${status == 0}">
			[我未完成的调查]
		</c:if>
			<c:if test="${status == 1 }">
			[我已完成的调查]
		</c:if>
			<table class="dataTable">
				<tr>
					<td>LOGO</td>
					<td>调查名称</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${page.result }" var="survey">
					<tr>
						<td><img alt="" src="${survey.logoPath }"></td>
						<td>${survey.surveyName }</td>
						<td>
							<c:if test="${status == 0}">
								<a href="survey/toEdit/${survey.id }">编辑</a>
								<a href="survey/toUpdateSurvey/${survey.id }">更新</a>&nbsp;&nbsp;
								<a href="survey/delete/${survey.id }">删除</a>&nbsp;&nbsp;
								<a href="#">完成</a>
							</c:if> 
							<c:if test="${status == 1 }">
								<a href="#">查看详情</a>
							</c:if></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3"><page:page page="${page }"></page:page></td>
				</tr>
			</table>
		</c:if>
	</div>

	<%@ include file="/common/guest_bottom.jsp"%>
</body>
</html>