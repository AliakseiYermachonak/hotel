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
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="/loginHeader.jsp" flush="true" />

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
                <table class="table table-bordered">

                    <thead>
                    <tr>
                        <th>
                            <fmt:message key="common.type" />
                        </th>
                        <th>
                            <fmt:message key="common.price" />
                        </th>
                        <th>
                            <fmt:message key="common.price" />
                        </th>

                    </tr>

                    </thead>


                    <c:forEach var="roomType" items="${roomType}">
                        <jsp:useBean id="roomType" class="app.db.entity.RoomType"/>
                        <tr>
                            <td><fmt:message key="${roomType.type}"/></td>
                            <td><c:out value="${roomType.price}"/></td>
                            <td>
                                <a href="http://localhost:8080/hotel/" class="btn btn-link" role="button">
                                    <fmt:message key="index.register" />
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
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
