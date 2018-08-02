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

    <title>Index page</title>

    <link rel="stylesheet"
          href="css/bootstrap.css">

    <link rel="stylesheet"
          href="css/bootstrap-theme.css">

    <script src="js/jquery-3.2.1.slim.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/npm.js"></script>
    <script src="js/index.js"></script>

</head>
<body>

<jsp:include page="/loginHeader.jsp" flush="true" />

<nav class="navbar navbar-default">
    <div class="container-fluid text-center"
         style="padding-top: 10px; font-size: 30px;">
        <fmt:message key="index.greeting" />
        <c:if test="${not empty requestScope.info}">
            <fmt:message key="${requestScope.info}" />
        </c:if>
    </div>
</nav>
<div class="container-fluid text-center">
    <div class="jumbotron" style="min-height: 650px;">
        <div id="main-div">
            <div class="container">
                <form action="basic" method="post"  class="form-horizontal" onsubmit="{return main(this);}">
                    <div class="row">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">
                                <fmt:message key="index.loginLabel" />
                            </label>
                            <div class="col-sm-4">
                                <fmt:message key="index.loginHint" var="loginHint"/>
                                <input type="text" class="form-control" name="login" id="login" placeholder="${loginHint}"/><br>
                            </div>
                            <div class="col-sm-4">

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label"><fmt:message key="index.passwordLabel" /></label>
                            <div class="col-sm-4">
                                <fmt:message key="index.passwordHint" var="passwordHint"/>
                                <input type="password" class="form-control" name="password" placeholder="${passwordHint}"/><br>
                            </div>
                            <div class="col-sm-4">

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">
                                <fmt:message key="index.rePasswordLabel" />
                            </label>
                            <div class="col-sm-4">
                                <input type="password" class="form-control" name="rePassword" placeholder="${passwordHint}"/><br>
                            </div>
                            <div class="col-sm-4">
                            </div>
                        </div>
                        <div>
                            <input type=hidden name="command" value="reg">
                            <input type=hidden name="menu" value="rooms">
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-5">
                                <button type="submit" class="btn btn-success">
                                    <fmt:message key="index.register" />
                                </button>
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
<footer>
    <nav class="navbar navbar-default">
        <div class="container-fluid text-center" style="padding-top: 15px;">
            &copy;2017 За копипаст сразу по щам!</div>
    </nav>
</footer>
</body>
</html>
