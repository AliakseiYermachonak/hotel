<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${sessionScope.lang }" />
<fmt:setBundle basename="l7n.local"/>

<meta charset="UTF-8">

<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://localhost:8080/index.jsp">
                <fmt:message key="index.hotel" />
            </a>

        </div>
        <div class="navbar-collapse collapse">
            <div class="btn-group btn-group-sm pull-left">
                <form class="navbar-form pull-left" action="basic" method="POST">
                    <input type="hidden" name="command" value="lang">
                    <input type="hidden" name="who" value="guest">
                    <input type="hidden" name="lang" value="ru_RU">
                    <button class="btn btn-info" type="submit" name="RU">
                       RU
                    </button>
                </form>
                <form class="navbar-form pull-left" action="basic" method="POST">
                    <input type="hidden" name="command" value="lang">
                    <input type="hidden" name="who" value="guest">
                    <input type="hidden" name="lang" value="en_EN">
                    <button class="btn  btn-info" type="submit" name="EN">
                       EN
                    </button>
                </form>
            </div>
            <form action="basic" method="POST" class="navbar-form navbar-right">
                <div class="form-group">
                    <fmt:message key="index.loginHint" var="loginHint"/>
                    <input type="text" name="login" placeholder="${loginHint}" class="form-control"/><br>
                </div>
                <div class="form-group">
                    <fmt:message key="index.passwordHint" var="passwordHint"/>
                    <input type="password" name="password" placeholder="${passwordHint}" class="form-control"/><br>
                </div>
                <input type=hidden name="command" value="login" />
                <input type=hidden name="menu" value="requests" />
                <div class="form-group">
                    <button class="btn btn-success" type="submit" name="sub" value="sub">
                        <fmt:message key="index.enter" />
                    </button>
                </div>
            </form>

        </div>
    </div>
</div>