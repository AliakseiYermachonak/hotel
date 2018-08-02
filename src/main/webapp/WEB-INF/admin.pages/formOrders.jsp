<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/mytaglib.tld" prefix="ct" %>

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
                            <fmt:message key="common.docType" />
                        </th>
                        <th>
                            <fmt:message key="common.price" />
                        </th>
                        <th>
                            <fmt:message key="admin.discount" />
                        </th>
                        <th>
                            <fmt:message key="common.idRoom" />
                        </th>
                        <th>
                            <fmt:message key="common.proceed" />
                        </th>
                    </tr>

                    </thead>
                    <c:forEach var="orders" items="${sessionScope.orders}">
                        <jsp:useBean id="orders" class="app.db.entity.Order"/>
                        <tr>
                            <form action="basic" method="POST" class="navbar-form navbar-right" onsubmit="{return main(this);}">
                                <td>
                                    <div class="form-group">
                                        <input type="text" name="idRequest" class="form-control"
                                               value="${orders.idRequest}" readonly/>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <select class="form-control" name="userInfo" id="userInfo">
                                            <option value="empty">
                                                <fmt:message key="admin.empty" />
                                            </option>
                                            <c:forEach var="uUserInfos" items="${sessionScope.uUserInfos}">
                                                <jsp:useBean id="uUserInfos" class="app.db.entity.united.UUserInfo" />
                                                <option value="${uUserInfos.idDocType} ${uUserInfos.docNumber}">
                                                    <c:out value="${uUserInfos.docType} ${uUserInfos.docNumber}"/>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <input type="text" name="price" class="form-control"
                                               value="${orders.price}" readonly/>
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <input type="text" name="discount" class="form-control" value="0"/>
                                        <h5>
                                            <small>
                                                <fmt:message key="admin.recDiscount" />
                                                <ct:srt totalOrders="${sessionScope.total}"/>
                                            </small>
                                        </h5>
                                   </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <select class="form-control" name="room" id="room">
                                            <c:forEach var="rooms" items="${sessionScope.rooms}">
                                                <jsp:useBean id="rooms" class="app.db.entity.Room"/>
                                                <option value="${rooms.idRoom}">
                                                    <c:out value="${rooms.idRoom}"/>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </td>
                                <input type=hidden name="idOrder" value="${orders.idOrder}"/>
                                <input type=hidden name="menu" value="formOrders"/>
                                <input type=hidden name="choice" value="continue"/>
                                <input type=hidden name="command" value="processRequests"/>
                                <td>
                                    <div class="form-group">
                                        <button class="btn btn-success" type="submit" name="sub" value="sub">
                                            <fmt:message key="admin.submit" />
                                        </button>
                                    </div>
                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    function main(form){
        if(testDate(form)){
            return true;
        }
        return false;
    }

    function testDate(form){
        var discount = form.discount.value;
        if(discount > 20 || discount <0){
            alert("Discount not valid");
            return false;
        }
        return true;
    }
</script>