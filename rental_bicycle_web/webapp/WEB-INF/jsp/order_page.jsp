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
    <link rel="icon" href="./img/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/owner.css" rel="stylesheet">
    <link href="./css/selected_user.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="./js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
    <script>

        // -----------------------------------------------------------------------------------------------------
        // Выбор велосипеда в рамках локации
        // -----------------------------------------------------------------------------------------------------
        $(document).ready(function() {
// Работа с объектом по id = countryName
// Вызов апплета происходит по событию change
            $('#freeBicycles').on('change', function () {
                $.ajax({
                    url : 'GetBicycleImg?bicycleId='+$('#freeBicycles').val(),
                    // Структура данных, которую принимаем
                    success : function(imageString) {
                        var img = document.getElementById('pictBycicle');
                        img.src = "data:image/jpg;base64," + imageString;
                        document.getElementById('pictBycicle').style.visibility='visible';
                    }
                });
            });
        });
    </script>
    <script type="text/javascript">
        function getBicycle() {
            var freeBic=document.getElementById('freeBicycles');
            var selBic=document.getElementById('selectedBicycles');
            <!--Вставляем в конец -->
            selBic.options[selBic.options.length] = new Option(freeBic.options[freeBic.selectedIndex].text, freeBic.value);
            freeBic.options[freeBic.selectedIndex].remove();
            document.getElementById('pictBycicle').style.visibility='hidden';
        }
    </script>
    <script type="text/javascript">
        function removeBicycle() {
            var freeBic=document.getElementById('freeBicycles');
            var selBic=document.getElementById('selectedBicycles');
            freeBic.options[freeBic.options.length] = new Option(selBic.options[selBic.selectedIndex].text, selBic.value);
            selBic.options[selBic.selectedIndex].remove();
        }
    </script>
    <script>
        //-----------------------------------------------------------------------------------------------------
        // Пополнение баланса
        //-----------------------------------------------------------------------------------------------------
        $(document).ready(function() {
            $('#buttonOrder').on('click', function() {
                var idVal='';
                var idPassport= document.getElementById("choosedIDPassport");
                var selBic= document.getElementById("selectedBicycles");
                for (var i = 0; i < selBic.options.length; i++) {
                    idVal += selBic.options[i].value + ',';
                }
                $.ajax({
                    url: 'startOrder',
                    data:{
                        idOfPassport:idPassport.value,
                        idVal: idVal},
                    // Структура данных, которую принимаем
                    success : function(order) {
                        $('#orderID').attr('value', JSON.parse(order).id);
                        $('#startTime').attr('value', JSON.parse(order).startTimeStr);

                        var $select = $('#selectedBicycles');
                        $select.find('option').remove();
                    }
                });
            });
        });
    </script>
    <script>
        //-----------------------------------------------------------------------------------------------------
        //
        //-----------------------------------------------------------------------------------------------------
        $(document).ready(function() {
            $('#buttonFinish').on('click', function() {
                var idOrder= document.getElementById("orderID");
                $.ajax({
                    url: 'finishOrder',
                    data:{
                        idOrder:idOrder.value
                    },
                    // Структура данных, которую принимаем
                    success : function(order) {
                        $('#finishTime').attr('value', order);

                        var $select = $('#countryName');
                        $select.find('option').remove();
                        $select.append($('<option>').text("").attr('value', ""));
                        $select.append($('<option>').text("Belarus").attr('value', "Belarus"));
                        $select.append($('<option>').text("Poland").attr('value', "Poland"));
                        $select.append($('<option>').text("Lithuania").attr('value', "Lithuania"));
                    }
                });
            });
        });
    </script>

    <script>
        // -----------------------------------------------------------------------------------------------------
        // Выбор города в рамках страны
        // -----------------------------------------------------------------------------------------------------
        $(document).ready(function() {
// Работа с объектом по id = countryName
// Вызов апплета происходит по событию change
            $('#countryName').on('change', function() {
                $.ajax({
                    url : 'GetCity',
                    data : {
                        // Структура данных, которую передаем
                        countryName : $('#countryName').val()
                    },
                    // Структура данных, которую принимаем
                    success : function(responseJson) {
                        var $select = $('#cityName');
                        // Очищаем предыдущие значения в combobox
                        $select.find('option').remove();
                        // Добавляем пустую строчку
                        $select.append($('<option>').text("").attr('value', ""));
                        // Сооружаем конструкцию типа <option value="City">City
                        $.each(JSON.parse(responseJson), function(i, city) {
                            $select.append($('<option>').text(city).attr('value', city));
                        });
                    }
                });
            });
        });
    </script>

    <script>
        //-----------------------------------------------------------------------------------------------------
        //Выбор локации в рамках города
        //-----------------------------------------------------------------------------------------------------
        $(document).ready(function() {
// Работа с объектом по id = countryName
// Вызов апплета происходит по событию change
            $('#cityName').on('change', function() {
                $.ajax({
                    url : 'GetLocation',
                    data : {
                        // Структура данных, которую передаем
                        cityName : $('#cityName').val(),
                        countryName : $('#countryName').val()
                    },
                    // Структура данных, которую принимаем
                    success : function(responseJson) {
                        var $select = $('#locationName');
                        // Очищаем предыдущие значения в combobox
                        $select.find('option').remove();
                        // Добавляем пустую строчку
                        $select.append($('<option>').text("").attr('value', ""));
                        // Сооружаем конструкцию типа <option value="City">City
                        $.each(JSON.parse(responseJson), function(i, city) {
                            var valueForLocationStr = city.street + ", house: " + city.house + ", office: " + city.office;
                            $select.append($('<option>').text(valueForLocationStr).attr('value', city.id));
                        });
                    }
                });
            });
        });
    </script>
</head>

<body>

<div class="flex2">
    <!--<h2 class="form-signin-heading">Select a user by key parameters: </h2>-->
    <label for="orderID" class="sr-show">ID of order</label>
    <input id="orderID" class="form-control" placeholder="" value="${numberOrder}" required autofocus>
    </br>
</div>

<div class="flex2">
    <div class="item2">
        <div class="item2">
            <h2 align="center">Choosed location</h2>
            <!--------------------------------PassportIdentificationNumber--------------------------------------------------------------->
            <label for="choosedCountry" class="sr-show">Country</label>
            <input id="choosedCountry" class="form-control" placeholder="" value="${selectCountry}" readonly autofocus>
            <!-----------------------------------------Surname--------------------------------------------------------------->
            <label for="choosedCity" class="sr-show">City</label>
            <input id="choosedCity" class="form-control" placeholder="" value="${selectCity}" readonly autofocus>
            <!-----------------------------------------Name--------------------------------------------------------------->
            <label for="choosedAddress" class="sr-show">Address</label>
            <input id="choosedAddress" class="form-control" placeholder="" value="${selectAddress}" readonly autofocus>
        </div>
    </div>

</br>

    <div class="item2">
        <div class="item2">
            <h2>Choosed user</h2>
            <!--------------------------------PassportIdentificationNumber--------------------------------------------------------------->
            <label for="choosedIDPassport" class="sr-show">ID passport</label>
            <input id="choosedIDPassport" class="form-control" placeholder="" value="${selectIdPassport}" readonly autofocus>
            <!-----------------------------------------Surname--------------------------------------------------------------->
            <label for="choosedSurname" class="sr-show">Surname</label>
            <input id="choosedSurname" class="form-control" placeholder="" value="${selectSurname}" readonly autofocus>
            <!-----------------------------------------Name--------------------------------------------------------------->
            <label for="choosedName" class="sr-show">Name</label>
            <input id="choosedName" class="form-control" placeholder="" value="${selectName}" readonly autofocus>
        </div>
    </div>
</div>

<h2 align="center">Bicycles</h2>
<div class="flex2">
    <div class="item2">
        <div class="item2">
            <label class="sr-show">Bicycles</label>

            <select name="bicycle" id="freeBicycles" class="form-control">
                <option value=""></option>
                <c:forEach items="${bicycles}" var="bicycle">
                    <option value="${bicycle.id}">Id:${bicycle.id}, ${bicycle.model}, year: ${bicycle.productionYear}, type: ${bicycle.bicycleType}</option>
                </c:forEach>
            </select>
        </div>

        <button class="btn btn-lg btn-primary btn-block" onclick="getBicycle()" >Add to order</button>
    </div>

    </br>

    <div class="item2">
        <div class="item2">
            <img id="pictBycicle" width="200px" height="133px">
        </div>
    </div>
</div>

<h2 align="center">Order</h2>
<div class="flex2">
    <div class="item2">
        <select id="selectedBicycles" class="form-control">
        </select>

        <button class="btn btn-lg btn-primary btn-block" onclick="removeBicycle()" >Delete from order</button>
    </div>
</div>

<div class="flex2">
    <div class="item2">
        <div class="item2">
            <h2 align="center">Order in the filling stage</h2>
            <!--------------------------------PassportIdentificationNumber--------------------------------------------------------------->
            <label for="startTime" class="sr-show">Start time</label>
            <input id="startTime" class="form-control" placeholder="" value="" readonly autofocus>
            <!-----------------------------------------Surname--------------------------------------------------------------->
            <label for="finishTime" class="sr-show">Finish time</label>
            <input id="finishTime" class="form-control" placeholder="" value="" readonly autofocus>
            <!-----------------------------------------Name--------------------------------------------------------------->
            <label class="sr-show">Country</label>
            <select id="countryName" class="form-control">
            </select>
            <!----------------------------------------Cities------------------------------------------------------------->
            <label class="sr-show">City</label>
            <select id="cityName" class="form-control">
            </select>
            <!----------------------------------------Location----------------------------------------------------------->
            <label class="sr-show">Location</label>
            <select id="locationName" class="form-control">
            </select>
        </div>
    </div>

    </br>

    <div class="item2">
        <button class="btn btn-lg btn-primary btn-block" id="buttonOrder" >Start</button>
        </br>
        </br>
        </br>
        <button class="btn btn-lg btn-primary btn-block" id="buttonFinish" >Finish</button>
        </br>
        </br>
        </br>
        <form class="form-signin" action="Controller?command=payment_page" method="post">
            <button class="btn btn-lg btn-primary btn-block" type="submit" >Pay</button>
        </form>
    </div>
</div>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>