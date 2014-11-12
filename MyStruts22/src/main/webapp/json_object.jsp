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
    
    $('#mybutton1').click(function(){ 
     var value = null;
       $.ajax({
           async: false,
           url: "GetJsonData",
           dataType: 'json',
           success: function(data) {
               value = data;
              alert(value.name+'  '+value.city);
           }
       });
       
   });
    $('#mybutton2').click(function(){ 
        var value = '';
          $.ajax({
              async: false,
              url: "GetJsonArrayData",
              dataType: 'json',
              success: function(data) {
                   
                  for(var i=0;i<data.length;i++){
                	 value=value+data[i]+'  '; 
                  }
                 alert(value);
              }
          });
          
      });
    $('#mybutton3').click(function(){ 
        var value = '';
          $.ajax({
              async: false,
              url: "GetJsonMixData",
              dataType: 'json',
              success: function(data) {
                   arr=data.data;
                   value=data.msg+':';
                  for(var i=0;i<arr.length;i++){
                	 value=value+' '+arr[i].name+'  '+arr[i].age; 
                  }
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
<br>
<input type="button" id="mybutton1" value="Get JSON Object Data">
<br>
<input type="button" id="mybutton2" value="Get JSON Array Data">
<br>
<input type="button" id="mybutton3" value="Get JSON Mix Data">
</body>

</html>