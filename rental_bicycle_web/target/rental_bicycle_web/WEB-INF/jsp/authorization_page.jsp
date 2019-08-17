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
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
</head>

<body>
<!-- Пользовательский тэг для внедрения информационного нафигационного элемента-->
<t:nav/>

<div class="container">
    <!-- Обработка кнопки Submit, принадлежащей данной форме submit-form -->
    <form class="form-signin" name="submit-form" action="Controller?command=authorization_page_user_submit" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <!-- Вывод на форму переданного значения в loginUser в AuthorizationPageUserSubmitCommand -->
        <input type="login" id="inputLogin" name="userLogin" class="form-control" placeholder="Enter your login" value="${loginUser}" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="userPassword" class="form-control" placeholder="Enter your password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <!-- Выыод на форму переданного значения в loginErr в AuthorizationPageUserSubmitCommand -->
        <label style="color: red">${loginErr}</label>
        </br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >Submit</button>
    </form>
</div> <!-- /container -->


<script src="./js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
