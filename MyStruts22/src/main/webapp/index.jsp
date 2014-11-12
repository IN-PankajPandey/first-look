<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head></head>
<body>
<s:form action="Login">
<s:textfield key="user.name"/>
<s:password key="user.password"/>
<s:submit key="submit"></s:submit>
</s:form>
</body>
</html>