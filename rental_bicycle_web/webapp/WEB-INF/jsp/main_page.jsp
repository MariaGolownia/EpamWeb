<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./img/favicon.ico">
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="./css/signin.css" rel="stylesheet">
    <fmt:setLocale value="${empty cookie.lang.value ? 'en_US' : cookie.lang.value}"/>
    <fmt:setBundle basename="config.content" var="cnt"/>
    <!-- Подключение библиотеки с пользовательскими тегами-->
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
    <script src="./js/ie-emulation-modes-warning.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>

<body>
<t:nav/>
User: ${userL}
</br>
Role: ${userR}
</br>

<div class="container">
    <form class="form-signin" action="Controller?command=location_page" method="post">
        <button class="btn btn-lg btn-primary btn-block" type="submit" >
            <fmt:message key="main_page.choose_location" bundle="${cnt}"/>
        </button>
        <input type="status" id="selectedLocation" class="form-control" value="${locationName}" readonly autofocus>
    </form>
    </br>
    <form class="form-signin" action="Controller?command=user_page" method="post">
        <button class="btn btn-lg btn-primary btn-block" type="submit" >
            <fmt:message key="main_page.choose_user" bundle="${cnt}"/>
        </button>
        <input type="status" id="selectedUser" class="form-control" value="${userName}" readonly autofocus>
    </form>
    </br>
    <form class="form-signin" action="Controller?command=order_page" method="post">
        <button class="btn btn-lg btn-primary btn-block" type="submit" >
            <fmt:message key="main_page.choose_order" bundle="${cnt}"/>
        </button>
    </form>
</div> <!-- /container -->



<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>