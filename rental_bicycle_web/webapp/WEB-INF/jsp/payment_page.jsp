<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./img/site_img/favicon.ico">

    <title>Payment page</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/owner.css" rel="stylesheet">
    <link href="./css/payment.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <fmt:setLocale value="${empty cookie.lang.value ? 'en_US' : cookie.lang.value}"/>
    <fmt:setBundle basename="config.content" var="cnt"/>
    <!-- Подключение библиотеки с пользовательскими тегами-->
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="./js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
</head>

<body>
<t:nav/>
<div class="flex-rent">
    <div class="item-rent">
        <h2 align="center">Payment</h2>
    </div>
    <div class="item-rent">
        <div class="item-rent">
            <label for="idPayment" class="sr-show">IdPayment</label>
            <input id="idPayment" class="form-control" placeholder="" value="${idPayment}" readonly autofocus>
            <label for="idPassportUser" class="sr-show">IdPassportUser</label>
            <input id="idPassportUser" class="form-control" placeholder="" value="${IdPassportUser}" readonly autofocus>
            <label for="userCards" class="sr-show">Card</label>
            <select id="userCards" class="form-control">
                <c:forEach items="${cards}" var="card">
                    <option value="${card.id}">Id:${card.id}, ${card.name}</option>
                </c:forEach>
            </select>
            <label for="cardBalance" class="sr-show">Balance</label>
            <input id="cardBalance" class="form-control" placeholder="" value="${cardBalance}" readonly autofocus>
            <label for="cardCurrency" class="sr-show">Currency</label>
            <input id="cardCurrency" class="form-control" placeholder="" value="${cardCurrency}" readonly autofocus>
            <label for="selectedBicycles" class="sr-show">Bicycles</label>
            <select id="selectedBicycles" class="form-control">
                <c:forEach items="${bicycles}" var="bicycle">
                    <option value="${bicycle.id}">Id:${bicycle.id}, ${bicycle.model}, year: ${bicycle.productionYear}, type: ${bicycle.bicycleType}</option>
                </c:forEach>
            </select>
            <label for="orderDuration" class="sr-show">Duration</label>
            <input id="orderDuration" class="form-control" placeholder="" value="${orderDuration}" readonly autofocus>
            <label for="orderAmount" class="sr-show">Amount</label>
            <input id="orderAmount" class="form-control" placeholder="" value="${orderAmount}" readonly autofocus>
            <label for="orderCurrency" class="sr-show">Currency</label>
            <input id="orderCurrency" class="form-control" placeholder="" value="${orderCurrency}" readonly autofocus>
            </br>
            <div class="flex-rent">
            <button class="btn btn-lg btn-primary btn-block" >Do Pay</button>
            </div>
            <label id="orderResult" class="sr-show"></label>
         </div>
    </div>
</div>

</body>
</html>