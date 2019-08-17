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
</br>
Role: ${userR}
</br>

<div class="container">
        <form class="form-signin" action="Controller?command=location_page" method="post">
            <button class="btn btn-lg btn-primary btn-block" type="submit" >Choose location</button>
            <input type="status" id="selectedLocation" class="form-control" value="${locationName}" readonly autofocus>
        </form>
        </br>
        <form class="form-signin" action="Controller?command=user_page" method="post">
            <button class="btn btn-lg btn-primary btn-block" type="submit" >Choose user</button>
            <input type="status" id="selectedUser" class="form-control" value="${userName}" readonly autofocus>
        </form>
        </br>
        <form class="form-signin" action="Controller?command=order_page" method="post">
            <button class="btn btn-lg btn-primary btn-block" type="submit" >Order</button>
        </form>
</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>