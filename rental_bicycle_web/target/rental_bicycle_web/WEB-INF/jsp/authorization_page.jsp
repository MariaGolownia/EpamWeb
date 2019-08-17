<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./img/favicon.ico">
    <title>Bicycle's rent</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="./css/signin.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="./js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./js/ie-emulation-modes-warning.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setLocale value="${empty cookie.lang.value ? 'en_US' : cookie.lang.value}"/>
    <fmt:setBundle basename="config.content" var="cnt"/>
    <!-- Подключение библиотеки с пользовательскими тегами-->
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

</head>

<body>
<!-- Пользовательский тэг для внедрения информационного нафигационного элемента-->
<t:nav/>

<div class="container">
    <!-- Обработка кнопки Submit, принадлежащей данной форме submit-form -->
    <form class="form-signin" name="submit-form" action="Controller?command=authorization_page_user_submit" method="post">
        <h2 class="form-signin-heading">
            <fmt:message key="authorization_page.signing" bundle="${cnt}"/>
        </h2>
        <label for="inputLogin" class="sr-only">
            <fmt:message key="authorization_page.label.login" bundle="${cnt}"/>
        </label>
        <!-- Вывод на форму переданного значения в loginUser в AuthorizationPageUserSubmitCommand -->
        <input type="login" id="inputLogin" name="userLogin" class="form-control" placeholder="Enter your login" value="${loginUser}" required autofocus>
        <label for="inputPassword" class="sr-only">
            <fmt:message key="authorization_page.label.password" bundle="${cnt}"/>
        </label>
        <input type="password" id="inputPassword" name="userPassword" class="form-control" placeholder="Enter your password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me">
                <fmt:message key="authorization_page.input.rebember_me" bundle="${cnt}"/>
            </label>
        </div>
        <!-- Выыод на форму переданного значения в loginErr в AuthorizationPageUserSubmitCommand -->
        <label style="color: red">${loginErr}</label>
        </br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >
            <fmt:message key="authorization_page.button.submit" bundle="${cnt}"/>
        </button>
    </form>
</div> <!-- /container -->


<script src="./js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
