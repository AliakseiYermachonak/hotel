<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<fmt:setLocale value="${sessionScope.lang }" />
<fmt:setBundle basename="l7n.local"/>

<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://localhost:8080/hotel/">
                <fmt:message key="index.hotel" />
            </a>

        </div>
        <div class="navbar-collapse collapse">
            <div class="btn-group btn-group-sm pull-left">
                <form class="navbar-form pull-left" action="basic" method="POST">
                    <input type="hidden" name="command" value="adminRooms"/>
                    <input type=hidden name="menu" value="rooms"/>
                    <button class="btn btn-primary" type="submit" name="rooms">
                        <fmt:message key="common.room" />
                    </button>
                </form>
                <form class="navbar-form pull-left" action="basic" method="POST">
                    <input type="hidden" name="command" value="adminRequests"/>
                    <input type=hidden name="menu" value="requests"/>
                    <button class="btn btn-primary" type="submit" name="requests">
                        <fmt:message key="common.request" />
                    </button>
                </form>
                <form class="navbar-form pull-left" action="basic" method="POST">
                    <input type="hidden" name="command" value="adminOrders"/>
                    <input type=hidden name="menu" value="orders"/>
                    <button class="btn btn-primary" type="submit" name="orders">
                        <fmt:message key="admin.orders" />
                    </button>
                </form>
                <form class="navbar-form pull-left" action="basic" method="POST">
                    <input type="hidden" name="command" value="adminUsers"/>
                    <input type=hidden name="menu" value="users"/>
                    <button class="btn btn-primary" type="submit" name="user">
                        <fmt:message key="admin.users" />
                    </button>
                </form>
            </div>

            <form class="navbar-form navbar-right" action="basic" method="POST">
                <input type="hidden" name="command" value="lang"/>
                <input type="hidden" name="who" value="admin"/>
                <input type="hidden" name="lang" value="ru_RU"/>
                <input type=hidden name="menu" value="requests" />
                <button class="btn btn-info" type="submit" name="RU">
                    RU
                </button>
            </form>
            <form class="navbar-form navbar-right" action="basic" method="POST">
                <input type="hidden" name="command" value="lang"/>
                <input type="hidden" name="who" value="admin"/>
                <input type="hidden" name="lang" value="en_EN"/>
                <input type=hidden name="menu" value="requests" />
                <button class="btn  btn-info" type="submit" name="EN">
                    EN
                </button>
            </form>
            <form class="navbar-form navbar-right" action="basic" method="POST">
                <input type=hidden name="command" value="logout"/>
                <input type=hidden name="menu" value="requests"/>
                <div class="form-group">
                    <button class="btn btn-success" type="submit" name="sub" value="sub">Выйти</button>
                </div>
            </form>
        </div>
    </div>
</div>