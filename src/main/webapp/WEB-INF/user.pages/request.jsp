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
                        <th>
                            <fmt:message key="common.proceed" />
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
                            <td>
                                <form c class="navbar-form pull-left" action="basic" method="POST">
                                    <input type="hidden" name="command" value="userProcessRequest"/>
                                    <input type="hidden" name="idRequest" value="${uRequests.idRequest}"/>
                                    <c:if test="${uRequests.idRequestStatus== 1 }">
                                        <button class="btn btn-warning" type="submit" name="not OK">
                                            <fmt:message key="common.delete" />
                                        </button>
                                    </c:if>
                                    <c:if test="${uRequests.idRequestStatus == 5 }">
                                        <button class="btn btn-warning" type="submit" name="not OK">
                                            <fmt:message key="common.delete" />
                                        </button>
                                    </c:if>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>