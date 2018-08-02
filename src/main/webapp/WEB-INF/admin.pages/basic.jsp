<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/tld/mytaglib.tld" prefix="ct"%>

<fmt:setLocale value="${sessionScope.lang }" />
<fmt:setBundle basename="l7n.local"/>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Admin page</title>

    <link rel="stylesheet"
          href="css/bootstrap.css">

    <link rel="stylesheet"
          href="css/bootstrap-theme.css">

    <script src="js/jquery-3.2.1.slim.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/npm.js"></script>

</head>
<body>

<jsp:include page="/WEB-INF/admin.pages/header.jsp" flush="true" />

<nav class="navbar navbar-default">
    <div class="container-fluid text-center"
         style="padding-top: 10px; font-size: 30px;">
        <c:if test="${not empty requestScope.menu}">
            <fmt:message key="${requestScope.menu}" />
        </c:if>
        <c:if test="${not empty requestScope.info}">
            <fmt:message key="${requestScope.info}" />
        </c:if>
    </div>
</nav>

<c:if test="${param.menu=='requests' }">
    <jsp:include page="/WEB-INF/admin.pages/newRequests.jsp" flush="true" />
</c:if>
<c:if test="${param.menu=='rooms' }">
    <jsp:include page="/WEB-INF/admin.pages/rooms.jsp" flush="true" />
</c:if>
<c:if test="${param.menu=='orders' }">
    <jsp:include page="/WEB-INF/admin.pages/orders.jsp" flush="true" />
</c:if>
<c:if test="${param.menu=='users' }">
    <jsp:include page="/WEB-INF/admin.pages/users.jsp" flush="true" />
</c:if>
<c:if test="${param.menu=='formOrders' }">
    <jsp:include page="/WEB-INF/admin.pages/formOrders.jsp" flush="true" />
</c:if>
<c:if test="${param.menu=='userInfo' }">
    <jsp:include page="/WEB-INF/admin.pages/userInfo.jsp" flush="true" />
</c:if>

<footer>
    <nav class="navbar navbar-default">
        <div class="container-fluid text-center" style="padding-top: 15px;">
            &copy;2018
        </div>
    </nav>
</footer>
</body>
</html>
