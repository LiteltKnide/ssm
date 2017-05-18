<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; 
	System.out.println(basePath);
	pageContext.setAttribute("basePath", basePath);
%>
<%-- <%@taglib prefix="c" uri=""%> --%>
<script type="text/javascript" src="${basePath }static/js/jquery-1.7.2.min.js"></script>
<%-- <base href="<%=basePath%>"> --%>

