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
                        <th>Document</th>
                        <th>Name</th>
                        <th>Contacts</th>
                        <th>Loyality</th>
                    </tr>

                    </thead>
                    <c:forEach var="users" items="${users}">
                        <jsp:useBean id="users" class="app.db.entity.User"/>
                        <tr>
                            <td><c:out value="${users.login}" /></td>

                            <td>
                                <c:forEach var="roles" items="${roles}">
                                    <jsp:useBean id="roles" class="app.db.entity.Role" />
                                    <c:if test="${users.idRole==roles.idRole }">
                                        <c:out value="${roles.role}" />
                                    </c:if>
                                </c:forEach>
                            </td>

                            <td>
                                <c:forEach var="delStatus" items="${delStatus}">
                                    <jsp:useBean id="delStatus" class="app.db.entity.DelStatus" />
                                    <c:if test="${users.idDelStatus==delStatus.idDelStatus}">
                                        <c:out value="${delStatus.status}" />
                                    </c:if>
                                </c:forEach>
                            </td>

                            <td>
                                ACTION
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>