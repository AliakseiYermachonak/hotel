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
                            <fmt:message key="admin.nOrder" />
                        </th>
                        <th>
                            <fmt:message key="admin.nReq" />
                        </th>
                        <th>
                            <fmt:message key="admin.users"/>
                        </th>
                        <th>
                            <fmt:message key="common.date"/>
                        </th>
                        <th>
                            <fmt:message key="common.nDay"/>
                        </th>
                        <th>
                            <fmt:message key="common.type"/>
                        </th>
                        <th>
                            <fmt:message key="common.nRoom"/>
                        </th>
                        <th>
                            <fmt:message key="admin.discount"/>
                        </th>
                        <th>
                            <fmt:message key="common.price"/>
                        </th>
                        <th>
                            <fmt:message key="common.idRoom"/>
                        </th>
                        <%-- <th><fmt:message key="common.proceed"/></th> --%>
                    </tr>

                    </thead>
                    <c:forEach var="uOrders" items="${uOrders}">
                        <jsp:useBean id="uOrders" class="app.db.entity.united.UOrder"/>
                        <tr>
                            <td><c:out value="${uOrders.idOrder}" /></td>
                            <td><c:out value="${uOrders.idRequest}" /></td>
                            <td><c:out value="${uOrders.login}" /> </td>
                            <td><c:out value="${uOrders.date}" /></td>
                            <td><c:out value="${uOrders.days }" /></td>
                            <td><fmt:message key="${uOrders.roomType}" /></td>
                            <td><c:out value="${uOrders.rooms}" /></td>
                            <td><c:out value="${uOrders.disount}" /></td>
                            <td><c:out value="${uOrders.price}" /></td>
                            <td><c:out value="${uOrders.idRoom}" /></td>
                            <%--<td><fmt:message key="admin.accept"/></td>--%>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>