<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function() {
    
    $('#mybutton').click(function(){ 
     var value = null;
       $.ajax({
           async: false,
           url: "GetJsonArrayData",
           dataType: 'json',
           success: function(data) {
               value = data;
              alert(value);
           }
       });
       
   });
});

</script>
<title>Insert title here</title>
</head>
<body>
in json page
<input type="button" id="mybutton" value="click heare!">

</body>

</html>