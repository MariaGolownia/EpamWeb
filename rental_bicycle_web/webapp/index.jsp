<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Вход</title>
</head>

<body>
<%
    response.sendRedirect("Controller?command=authorization_page");
%>
</body>
</html>

<!-- %@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
c:redirect url = "/Controller?command=authorization_page"/> -->
