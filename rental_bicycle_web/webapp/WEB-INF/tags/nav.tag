<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="./js/jquery.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min.js" type="text/javascript"></script>

<link href="./css/navbar-static-top.css" rel="stylesheet">
<link href="./css/bootstrap.min.css" rel="stylesheet">


<!-- Static navbar -->

<nav class="navbar navbar-default navbar-static-top"  >
    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand" href="#"> BICYCLE RENTAL </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <!------------------------------------------------------------------------------------------------>
            <ul class="nav navbar-nav">
                <li><a href="/web/html/about.html">About us</a></li>
                <li><a href="#contact">Our phone numbers: 8 029 777 77 77, 8 029 888 88 88</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Language
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">English</a></li>
                        <li><a href="#">Russian</a></li>
                    </ul>
                </li>
                <li><a href="../navbar-fixed-top/">Exit</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>

</nav>