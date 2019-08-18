<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Rental Bicycle app">
    <meta name="author" content="Maria Golownia">
    <link rel="icon" href="./img/bicycle.jpg">

    <title>Rental Bicycle</title>

    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./css/signin.css" rel="stylesheet">
    <!-- Just for debugging purposes. -->
    <!--[if lt IE 9]script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./js/ie-emulation-modes-warning.js"></script>

</head>

<body>

<div class="container">

    <form class="form-signin" action="Controller?command=authorization_page_user_submit" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <input type="login" id="inputLogin" name="userLogin" class="form-control" placeholder="Enter your login" value="${loginUser}" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="userPassword" class="form-control" placeholder="Enter your password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <label style="color: red">${loginErr}</label>
        </br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >Submit</button>
    </form>
</div>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>