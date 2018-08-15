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
                            <fmt:message key="admin.login" />
                        </th>
                        <th>
                            <fmt:message key="admin.role" />
                        </th>
                        <th>
                            <fmt:message key="admin.status" />
                        </th>
                        <th>
                            <fmt:message key="common.proceed" />
                        </th>
                    </tr>

                    </thead>
                    <c:forEach var="uUsers" items="${uUsers}">
                        <jsp:useBean id="uUsers" class="app.db.entity.united.UUser"/>
                        <tr>
                            <td><c:out value="${uUsers.login}" /></td>
                            <td><fmt:message key="${uUsers.role}" /></td>
                            <td><fmt:message key="${uUsers.delStatus}" /></td>

                            <td>
                                <form  class="navbar-form pull-left" action="basic" method="POST">
                                    <input type="hidden" name="command" value="processUser"/>
                                    <input type="hidden" name="choice" value="sAdmin"/>
                                    <input type="hidden" name="idUser" value="${uUsers.idUser}"/>
                                    <button class="btn btn-success" type="submit" name="OK">
                                        <fmt:message key="admin.sAdmin" />
                                    </button>
                                </form>
                                <form c class="navbar-form pull-left" action="basic" method="POST">
                                    <input type="hidden" name="command" value="processUser"/>
                                    <input type="hidden" name="choice" value="sUser"/>
                                    <input type="hidden" name="idUser" value="${uUsers.idUser}"/>
                                    <button class="btn btn-warning" type="submit" name="not OK">
                                        <fmt:message key="admin.sUser" />
                                    </button>
                                </form>
                                <form c class="navbar-form pull-left" action="basic" method="POST">
                                    <input type="hidden" name="command" value="processUser"/>
                                    <input type="hidden" name="choice" value="ban"/>
                                    <input type="hidden" name="idUser" value="${uUsers.idUser}"/>
                                    <button class="btn btn-danger" type="submit" name="not OK">
                                        <fmt:message key="admin.ban" />
                                    </button>
                                </form>
                                <form c class="navbar-form pull-left" action="basic" method="POST">
                                    <input type="hidden" name="command" value="processUser"/>
                                    <input type="hidden" name="choice" value="userInfo"/>
                                    <input type="hidden" name="idUser" value="${uUsers.idUser}"/>
                                    <button class="btn btn-info" type="submit" name="not OK">
                                        <fmt:message key="admin.info" />
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