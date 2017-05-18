<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="logoDiv" class="borderDiv">小刀论坛-在线调查系统</div>
	
	<div id="topDiv" class="borderDiv">
		
		<!-- 检查用户是否登录 -->
		<!-- 如果用户没有登录 -->
		<c:if test="${sessionScope.loginUser==null }">
			[<a href="user/toLogin">登录</a>]
			[<a href="user/toRegister">注册</a>]
		</c:if>
		
		<!-- 如果用户已经登录 -->
		<c:if test="${sessionScope.loginUser!=null }">
			[欢迎您：${sessionScope.loginUser.username }]
			[<a href="user/logout">退出登录</a>]
			
			<!-- 判断是否是企业用户 -->
			<c:if test="${sessionScope.loginUser.role==1 }">
				[<a href="survey/new">创建调查</a>]
				[<a href="survey/list/0">未完成的调查</a>]
				[<a href="survey/list/1">已完成的调查</a>]
			</c:if>
			
			[<a href="#">参与调查</a>]
			
		</c:if>
		
		[<a href="index.jsp">首页</a>]
		
	</div>