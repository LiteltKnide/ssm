<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/base.jsp" %>
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("input[name='surveyName']").blur(function(){
			var name = $(this).val();
			if(name == ""){
				alert("请填写调查的名称!")
				$(this).focus();
			}
		});
		
		$("input[type='submit']").click(function(){
			var name = $("input[name='surveyName']").val();
			if(name==""){
				alert("请填写调查的名称!");
				return false;
			}
			
		});
	});
</script>
</head>
<body>
	
	<%@ include file="/common/guest_top.jsp" %>
	
	<div id="mainDiv" class="borderDiv">
		
		[更新调查]
		<form action="survey/update/${survey.id }" method="POST" enctype="multipart/form-data">
<!-- 			<input type="hidden" name="_method" value="PUT"> -->
			<input type="hidden" name="id" value="${survey.id}">
			<table class="formTable">
				<c:if test="${!empty exception.message }">
					<tr>
						<td colspan="2" style="color:red"> ${exception.message }</td>
					</tr>
				</c:if>
				<tr>
					<td>调查名称</td>
					<td>
						<input type="text" name="surveyName" value="${survey.surveyName }">
					</td>
				</tr>
				<tr>
					<td>调查Logo</td>
					<td>
						<input type="file" name="file">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="update">
					</td>
				</tr>
			</table>
		</form>
		
	</div>
	
	<%@ include file="/common/guest_bottom.jsp" %>
</body>
</html>