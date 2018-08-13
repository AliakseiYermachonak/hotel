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


                <form action="basic" method="post" class="form-horizontal" onsubmit="{return main(this);}">
                    <div class="row">
                        <div class="form-group">
                            <label class="col-sm-5 control-label">
                                <fmt:message key="common.chooseDate" />
                            </label>
                            <div class="col-sm-5">
                                <input type="date" class="form-control" name="date" id="date"/>
                            </div>
                            <div class="col-sm-5">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-5 control-label">
                                <fmt:message key="common.nDay" />
                            </label>
                            <div class="col-sm-5">
                                <div class="col-sm-5">

                                    <select class="form-control" name="nDays" id="nDays">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-5">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-5 control-label">
                                <fmt:message key="common.nRoom" />
                            </label>
                            <div class="col-sm-5">
                                <div class="col-sm-5">

                                    <select class="form-control" name="nRooms" id="nRooms">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-5">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-4 control-label">
                            </label>
                            <div class="col-sm-4 text-center">
                                <label class="radio-inline"><input type="radio" name="willing" value="toBook">
                                    <fmt:message key="common.toBook" />
                                </label>
                                <label class="radio-inline"><input type="radio" name="willing" value="toRent">
                                    <fmt:message key="common.toRent" />
                                </label>
                            </div>
                            <div class="col-sm-4">
                            </div>
                        </div>

                        <div>
                            <input type=hidden name="command" value="createNewRequest">
                            <input type=hidden name="menu" value="requests">
                            <input type=hidden name="idRoomType" value="requests">
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-5">
                                <button type="submit" class="btn btn-success">
                                    <fmt:message key="common.startReq" />
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
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
        var date = form.date.value;
        if(date == ""){
            alert("Missing date");
            return false;
        }
        date = new Date(date);
        var now = new Date();
        if(now>date){
            alert("Date from past");
            return false;
        }
        if(date.getFullYear() != now.getFullYear()){
            alert("Select this year");
            return false;
        }
        return true;
    }
</script>
