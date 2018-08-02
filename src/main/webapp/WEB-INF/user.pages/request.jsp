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
                            <fmt:message key="common.date" />
                        </th>
                        <th>
                            <fmt:message key="common.nDay" />
                        </th>
                        <th>
                            <fmt:message key="common.type" />
                        </th>
                        <th>
                            <fmt:message key="common.nRoom" />
                        </th>
                        <th>
                            <fmt:message key="common.reqStat" />
                        </th>
                    </tr>

                    </thead>
                    <c:forEach var="uRequests" items="${uRequests}">
                        <jsp:useBean id="uRequests" class="app.db.entity.united.URequest" />
                        <tr>
                            <td><c:out value="${uRequests.date}" /></td>
                            <td><c:out value="${uRequests.days }" /></td>
                            <td>
                                <fmt:message key="${uRequests.roomType}" />
                            </td>
                            <td><c:out value="${uRequests.rooms}" /></td>
                            <td>
                                <fmt:message key="${uRequests.requestStatus}" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>