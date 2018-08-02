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
                            <fmt:message key="common.docNumber" />
                        </th>
                        <th>
                            <fmt:message key="common.docType" />
                        </th>
                        <th>
                            <fmt:message key="common.name" />
                        </th>
                        <th>
                            <fmt:message key="common.surname" />
                        </th>
                        <th>
                            <fmt:message key="common.phoneNumber" />
                        </th>
                        <th>
                            <fmt:message key="common.email" />
                        </th>
                        <th>
                            <fmt:message key="common.proceed" />
                        </th>
                    </tr>

                    </thead>
                    <c:forEach var="uUserInfos" items="${uUserInfos}">
                        <jsp:useBean id="uUserInfos" class="app.db.entity.united.UUserInfo" />
                        <tr>

                            <td><c:out value="${uUserInfos.docNumber}" /></td>
                            <td>
                                <fmt:message key="${uUserInfos.docType}" />
                            </td>
                            <td>
                                <c:out value="${uUserInfos.name}" />
                            </td>
                            <td>
                                <c:out value="${uUserInfos.surname}" />
                            </td>
                            <td>
                                <c:out value="${uUserInfos.phoneNumber}" />
                            </td>
                            <td>
                                <c:out value="${uUserInfos.email}" />
                            </td>
                            <td>

                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <form action="basic" method="POST">
                        <td>
                            <input type="docNumber" name="docNumber" class="form-control"/>
                        </td>
                        <td>
                            <select class="form-control" name="docType" id="docType">
                                <option value="1">
                                    <fmt:message key="Passport" />
                                </option>
                                <option value="2">
                                    <fmt:message key="DriverLicense" />
                                </option>
                                <option value="3">
                                    <fmt:message key="IDcard" />
                                </option>
                                <option value="4">
                                    <fmt:message key="ISIC" />
                                </option>
                                <option value="5">
                                    <fmt:message key="Other" />
                                </option>
                            </select>
                        </td>
                        <td>
                            <input type="name" name="name" class="form-control"/>
                        </td>
                        <td>
                            <input type="surname" name="surname" class="form-control"/>
                        </td>
                        <td>
                            <input type="phoneNumber" name="phoneNumber" class="form-control"/>
                        </td>
                        <td>
                            <input type="email" name="email" class="form-control"/>
                        </td>
                            <td>
                                <div class="form-group">
                                    <input type="hidden" name="command" value="processUser">
                                    <input type="hidden" name="choice" value="addInfo">
                                    <input type="hidden" name="menu" value="users">
                                    <c:forEach var="uUserInfos" items="${uUserInfos}" begin="0" end="1">
                                        <input type="hidden" name="idUser" value="${uUserInfos.idUser}">
                                    </c:forEach>
                                    <button class="btn btn-info" type="submit" name="Request">
                                        <fmt:message key="common.addInfo" />
                                    </button>
                                </div>
                            </td>
                        </form>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>