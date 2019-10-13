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

    <title>Bicycle's rent</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/owner.css" rel="stylesheet">
    <link href="./css/selected_user.css" rel="stylesheet">
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="./css/signin.css" rel="stylesheet">
    <link href="./css/order_page1.css" rel="stylesheet">
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

    <script>
        //-----------------------------------------------------------------------------------------------------
        //Выбор локации в рамках города
        //-----------------------------------------------------------------------------------------------------
        $(document).ready(function() {
// Работа с объектом по id = countryName
// Вызов апплета происходит по событию change
            $('#findUser').on('click', function() {
                $.ajax({
                    url : 'GetUser',
                    data : {
                        // Структура данных, которую передаем
                        userDocId: $('#inputPassportIdentificationNumber').val()
                    },
                    // Структура данных, которую принимаем
                    success : function(responseJson) {
                        // Сооружаем конструкцию типа <option value="City">City
                        var curUser=JSON.parse(responseJson);
                        $('#userName').attr('value', curUser.name);
                        $('#userSurname').attr('value', curUser.surname);
                        $('#userCountry').attr('value', curUser.country);
                    }
                });

                $.ajax({
                    url : 'GetUserCards',
                    data : {
                        // Структура данных, которую передаем
                        userDocId: $('#inputPassportIdentificationNumber').val()
                    },
                    // Структура данных, которую принимаем
                    success : function(responseJson) {
                        var $select = $('#cardName');
                        // Очищаем предыдущие значения в combobox
                        $select.find('option').remove();
                        // Добавляем пустую строчку
                        $select.append($('<option>').text("").attr('value', ""));
                        $.each(JSON.parse(responseJson), function(i, cards) {
                            $select.append($('<option>').text(cards.name).attr('value', cards.id));
                        });
                    }
                });
            });
        });
    </script>
    <script>
        //-----------------------------------------------------------------------------------------------------
        //Получение баланса и валюты выбранной карточки
        //-----------------------------------------------------------------------------------------------------
        $(document).ready(function() {
// Работа с объектом по id = countryName
// Вызов апплета происходит по событию change
            $('#cardName').on('change', function() {
                $.ajax({
                    url : 'GetUserCardBalance',
                    data : {
                        // Структура данных, которую передаем
                        userCardId: $('#cardName').val()
                    },
                    // Структура данных, которую принимаем
                    success : function(responseJson) {
                        // Сооружаем конструкцию типа <option value="City">City
                        var curCard=JSON.parse(responseJson);
                        $('#currencyCard').attr('value', curCard.currency);
                        $('#balanceCard').attr('value', curCard.balance);
                    }
                });
            });
        });
    </script>
    <script>
        //-----------------------------------------------------------------------------------------------------
        // Пополнение баланса
        //-----------------------------------------------------------------------------------------------------
        $(document).ready(function() {
            $('#buttonTopUpBalance').on('click', function() {
                $.ajax({
                    url : 'GetTopUpBalance',
                    data : {
                        // Структура данных, которую передаем
                        userCardId: $('#cardName').val(),
                        userCardAmmount: $('#rechargeableBalanceCard').val()
                    },
                    // Структура данных, которую принимаем
                    success : function(balanceCard) {
                        // Сооружаем конструкцию типа <option value="City">City

                        $('#balanceCard').attr('value', balanceCard);
                    }
                });
            });
        });
    </script>
</head>

<body>
<t:nav/>

    <!--<h2 class="form-signin-heading">Select a user by key parameters: </h2>-->

<div class="flex2">
    <div class="item2">
        <div class="item2">
            <!--------------------------------PassportIdentificationNumber--------------------------------------------------------------->
            <label for="inputPassportIdentificationNumber" class="sr-show">Passport identification number</label>
            <input type="passportIdentificationNumber" id="inputPassportIdentificationNumber" name="userPassportIdentificationNumber" class="form-control" placeholder="" autofocus>
            <button class="btn btn-lg btn-primary btn-block" type="topUp" id="findUser" > Select this user </button>
            </br>
            </br>
            </br>
            <!-----------------------------------------Surname--------------------------------------------------------------->
            <label for="userSurname" class="sr-show">Surname</label>
            <input type="surname" id="userSurname" name="userSurname" class="form-control" placeholder="" required autofocus>
            <!-----------------------------------------Name--------------------------------------------------------------->
            <label for="userName" class="sr-show">Name</label>
            <input type="name" id="userName" name="userName" class="form-control" placeholder="" required autofocus>
            <!-----------------------------------------country--------------------------------------------------------------->
            <label for="userCountry" class="sr-show">Country</label>
            <input type="country" id="userCountry" name="userCountry" class="form-control" placeholder=""  autofocus>
            <!--------------------------------Virtual card--------------------------------------------------------------->
            <label class="sr-show">Virtual card</label>
            <select id="cardName" class="form-control">
            </select>
            </br>
            </br>
            </br>
            <!--------------------------------Balance--------------------------------------------------------------->
            <label for="balanceCard" class="sr-show">Virtual card's balance</label>
            <input type="balance" id="balanceCard" name="userBalanceCard" class="form-control" placeholder="" autofocus>
            <!--------------------------------Currency--------------------------------------------------------------->
            <label for="currencyCard" class="sr-show">Currency</label>
            <input type="currency" id="currencyCard" name="userCurrencyCard" class="form-control" placeholder="" autofocus>
        </div>

        </br>
        </br>
        </br>

        <div class="item2">
            <!--------------------------------Top up--------------------------------------------------------------->
            <label for="rechargeableBalanceCard" class="sr-show">Rechargeable balance</label>
            <input type="rechargeableBalance" id="rechargeableBalanceCard" name="userRechargeableBalanceCard" class="form-control" placeholder="" autofocus>

            <button class="btn btn-lg btn-primary btn-block" type="topUp" id="buttonTopUpBalance">Top up balance</button>
        </div>
    </div>

</br>

    <div class="item2">
        <form action="Controller?command=main_page" method="post">
        <div class="item2">
            <button class="btn btn-lg btn-primary btn-block" type="topUp" id="selectUser"> Select this user </button>
        </div>
        </form>
        </br>
        <div class="item2">
            <button class="btn btn-lg btn-primary btn-block" type="topUp" onclick="history.back()"> Back </button>
        </div>
    </div>
</div>



<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>