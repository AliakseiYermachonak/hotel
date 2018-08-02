
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${sessionScope.lang }" />
<fmt:setBundle basename="l7n.local"/>

<div class="container-fluid text-center">
    <div class="jumbotron" style="min-height: 650px;">
        <div id="main-div">
            <div class="container">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>
                            <fmt:message key="common.idRoom" />
                        </th>
                        <th>
                            <fmt:message key="common.type" />
                        </th>
                        <th>
                            <fmt:message key="common.price" />
                        </th>
                    </tr>
                    </thead>
                    <c:forEach var="uRooms" items="${uRooms}">
                        <jsp:useBean id="uRooms" class="app.db.entity.united.URoom" />
                        <tr>
                            <td><c:out value="${uRooms.idRoom}" /></td>
                            <td><fmt:message key="${uRooms.type}" /></td>
                            <td><c:out value="${uRooms.price}" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>