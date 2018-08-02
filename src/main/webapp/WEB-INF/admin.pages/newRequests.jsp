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
                            <fmt:message key="admin.nReq" />
                        </th>
                        <th>
                            <fmt:message key="admin.users" />
                        </th>
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
                            <fmt:message key="admin.suggest" />
                        </th>
                        <th>
                            <fmt:message key="common.reqStat" />
                        </th>
                        <th>
                            <fmt:message key="common.proceed" />
                        </th>
                    </tr>

                    </thead>
                    <c:forEach var="uRequestNew" items="${uRequestNew}">
                        <jsp:useBean id="uRequestNew" class="app.db.entity.united.URequestNew" />
                        <tr>
                            <td><c:out value="${uRequestNew.idRequest}" /></td>
                            <td><c:out value="${uRequestNew.login}" /></td>
                            <td><c:out value="${uRequestNew.date}" /></td>
                            <td><c:out value="${uRequestNew.days }" /></td>
                            <td><fmt:message key="${uRequestNew.roomType}" /></td>
                            <td><c:out value="${uRequestNew.rooms}" /></td>
                            <td><c:out value="${uRequestNew.availRooms}" /></td>
                            <td><fmt:message key="${uRequestNew.requestStatus}" /></td>

                            <td>
                                <form  class="navbar-form pull-left" action="basic" method="POST">
                                    <input type="hidden" name="command" value="processRequests"/>
                                    <input type="hidden" name="choice" value="true"/>
                                    <input type="hidden" name="idRequest" value="${uRequestNew.idRequest}"/>
                                    <input type="hidden" name="menu" value="formOrders"/>
                                    <button class="btn btn-success" type="submit" name="OK">
                                        <fmt:message key="admin.accept" />
                                    </button>
                                </form>
                                <form c class="navbar-form pull-left" action="basic" method="POST">
                                    <input type="hidden" name="command" value="processRequests"/>
                                    <input type="hidden" name="choice" value="false"/>
                                    <input type="hidden" name="idRequest" value="${uRequestNew.idRequest}"/>
                                    <input type="hidden" name="menu" value="requests"/>
                                    <button class="btn btn-danger" type="submit" name="not OK">
                                        <fmt:message key="admin.deny" />
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