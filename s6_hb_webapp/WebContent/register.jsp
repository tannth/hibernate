<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.java.UserDAO"%>

<jsp:useBean id="obj" class="com.java.User" />

<jsp:setProperty property="*" name="obj" />

<%
	int i = UserDAO.register(obj);
	if (i > 0) {
		out.print("You are successfully registered");
	}
%>