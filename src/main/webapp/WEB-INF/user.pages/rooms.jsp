<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                            <fmt:message key="common.type"/>
                        </th>
                        <th>
                            <fmt:message key="common.price"/>
                        </th>
                        <th>
                            <fmt:message key="common.proceed"/>
                        </th>
                    </tr>
                    </thead>

                    <c:forEach var="roomType" items="${roomType}">
                        <jsp:useBean id="roomType" class="app.db.entity.RoomType"/>
                        <tr>

                            <td><fmt:message key="${roomType.type}"/></td>
                            <td><c:out value="${roomType.price}"/></td>

                            <td>
                                <form action="basic" method="POST">
                                    <input type="hidden" name="command" value="newRequest">
                                    <input type="hidden" name="menu" value="newRequest">
                                    <input type="hidden" name="idRoomType" value="${roomType.idRoomType}">
                                    <button class="btn btn-warning" type="submit" name="Request">
                                        <fmt:message key="common.startReq" />
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>


                </table>
            </div>
        </div>
    </div>
</div>