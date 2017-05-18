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
		
		$("#submit").click(function(){
			var username = $("#username").val();
			var password = $("#password").val();
			
			if (username == "" || password == "") {
				console.log("submit is null");
				$("#username").parents("tr").prev("tr").hide();
				$("#username").parents("tr").before("<tr><td colspan='2' style='color: red'>用户名或密码不能为空</td></tr>");
				return false;
			}
		});
		
	});
</script>
</head>
<body>
	
	<%@ include file="/common/guest_top.jsp" %>
	
	<div id="mainDiv" class="borderDiv">
		[用户登录]
		<form action="user/login" method="post">
			<table class="formTable">
				<c:if test="${!empty msg }">
					<tr>
						<td colspan="2" style="color: red">${msg }</td>
					</tr>
				</c:if>
				<tr>
					<td>用户名</td>
					<td>
						<input id="username" class="longInput" type="text" name="username" placeholder="请输入用户名">
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input id="password" class="longInput" type="password" name="password" placeholder="请输入密码">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input id="submit" type="submit" value="登录" >
					</td>
				</tr>
				
			</table>
		</form>
		
	</div>
	
	<%@ include file="/common/guest_bottom.jsp" %>
</body>
</html>