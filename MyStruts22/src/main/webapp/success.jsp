<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My  Examples</title>
</head>
<body>
Name:<s:property value="user.name"/>
Password:<s:property value="user.password"/>
<br>
<s:form action="GetObject">
<s:submit   label="JSON"></s:submit>
</s:form>
<s:form action="upload">
<s:submit   label="Upload File Example"></s:submit>
</s:form>
</body>
</html>