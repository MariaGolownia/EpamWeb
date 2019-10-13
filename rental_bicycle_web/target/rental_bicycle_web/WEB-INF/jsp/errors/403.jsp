<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<fmt:setLocale value="${empty cookie.lang.value ? 'en_US' : cookie.lang.value}"/>
<fmt:setBundle basename="config.content" var="cnt"/>

<html>
<head>
    <title><fmt:message key="page.error.title.403" bundle="${cnt}"/></title>
    <my:css/>
</head>
<body>
<my:nav/>
<div class="container min-vh-75">
    <div class="row h-75 justify-content-center align-items-center">
        <div>
            <div class="row justify-content-center py-0">
                <div class="container h-50 w-50">
                    <img src="<c:url value = "/errors_img/err_403.jpg"/>" class="img-fluid img-thumbnail border-dark" alt="">
                </div>
            </div>
            <div class="row justify-content-center pt-2">
                <div class="container h-100 w-100">
                    <h1 class="text-center"><fmt:message key="page.error.title.403" bundle="${cnt}"/></h1>
                </div>
            </div>
            <div class="row justify-content-center py-0">
                <a class="h6 font-weight-lighter" href="<c:url value = "/home.html"/>">
                    <fmt:message key="page.error.action.go_home" bundle="${cnt}"/>
                </a>
            </div>
        </div>
    </div>
</div>
<my:footer/>
<my:scripts/>
</body>
</html>
