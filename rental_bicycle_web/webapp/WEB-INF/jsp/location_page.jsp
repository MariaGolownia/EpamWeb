<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="by.javatr.entity.en_um.City" %>
<%@ page import="by.javatr.entity.en_um.Country" %>
<!DOCTYPE html>
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
    <script src="./js/ie-emulation-modes-warning.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>

<body>
User: ${userL}
Role: ${userR}
</br>
Info: ${userT}

<div class="container">

    <form class="form-signin" action="Controller?command=authorization_page_user_submit" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputLogin" class="sr-only">Data</label>
        <!---------------------------------------Login----------------------------------------------------------------->
        <label for="inputLogin" class="sr-only">Work with user with login:</label>
        <input type="login" id="inputLogin" name="userLogin" class="form-control" placeholder=${userL} required autofocus>
        <!---------------------------------------Country----------------------------------------------------------------->
        <label for="inputLogin" class="sr-only">Country</label>
        <select class="form-control" name = "country">
            <option>Belarus</option>
            <option>Poland</option>
            <option>Lithuania</option>
        </select>
        <!---------------------------------------Cities??????????????????????????----------------------------------------------------------------->
        <label for="inputLogin" class="sr-only">Country</label>
        <%
            List<City> list = new ArrayList<>();

            list = City.getByCountry(Country.valueOf(request.getParameter("country")));
            request.setAttribute("listCity", list);
        %>
        <select class="form-control">
            <c:forEach items="${listCity}" var="city">
                <option> ${city} </option>
            </c:forEach>
        </select>
        <!----------------------------------------Location-------------------------------------------------------------------->

        <button class="btn btn-lg btn-primary btn-block" type="submit" >Submit</button>
    </form>
</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>