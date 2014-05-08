<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index1</title>
</head>
<body>
	<s:form action="login" method="post">
		<s:textfield name="id" key="label.UserName" />
		<s:password name="password" key="label.Passowrd" />
		<s:submit value="submit" />
	</s:form>
</body>
</html>