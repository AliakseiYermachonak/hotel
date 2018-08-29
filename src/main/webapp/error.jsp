<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${sessionScope.lang }" />
<fmt:setBundle basename="l7n.local"/>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Room page</title>

    <link rel="stylesheet"
    href="css/bootstrap.css">

    <link rel="stylesheet"
          href="css/bootstrap-theme.css">

    <script src="js/jquery-3.2.1.slim.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/npm.js"></script>

</head>
<body>

<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand" href="http://localhost:8080/index.jsp">
                <fmt:message key="index.hotel" />
            </a>

        </div>
        <div class="navbar-collapse collapse">
            <div class="btn-group btn-group-sm pull-left">
                <form class="navbar-form pull-left" action="basic" method="POST">
                    <input type="hidden" name="command" value="lang">
                    <input type="hidden" name="who" value="guest">
                    <input type="hidden" name="lang" value="ru_RU">
                    <button class="btn btn-info" type="submit" name="RU">
                        RU
                    </button>
                </form>
                <form class="navbar-form pull-left" action="basic" method="POST">
                    <input type="hidden" name="command" value="lang">
                    <input type="hidden" name="who" value="guest">
                    <input type="hidden" name="lang" value="en_EN">
                    <button class="btn  btn-info" type="submit" name="EN">
                        EN
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container-fluid text-center"
         style="padding-top: 10px; font-size: 30px;">
        <c:if test="${not empty requestScope.info}">
            <fmt:message key="${requestScope.info}" />
        </c:if>
    </div>
</nav>

<fmt:setBundle basename="l7n.local"/>
<fmt:setLocale value="${sessionScope.lang }"/>
<div class="container-fluid text-center">
    <div class="jumbotron" style="min-height: 650px;">
        <div id="main-div">
            <div class="container">
                <h1>
                    <fmt:message key="error" />
                </h1>
            </div>
        </div>
    </div>
</div>


<footer>
    <nav class="navbar navbar-default">
        <div class="container-fluid text-center" style="padding-top: 15px;">
            &copy;2018</div>
    </nav>
</footer>
</body>
</html>
