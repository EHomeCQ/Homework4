
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>登录</title>
</head>
<body>

<table>
  <tr>
    <p> <font color="#0000FF">输入用户名称：</font></p>
  </tr>
  
  <tr>
    <%
    if (request.getParameter("username") == null) {%>
    <td>
        <p> <b>User_name: </b></p>
    </td>
    <td>
        <form action='?' method='get'><input type='text' name='username'></form>
   
    <%}else {%>
        <p>Hello,  <%=request.getParameter("username")%> !</p>
    <%}%>
     </td>
  </tr>
</table>
</body>
</html>

