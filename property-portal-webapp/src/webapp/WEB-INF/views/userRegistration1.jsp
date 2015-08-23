<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post" commandName="moduleRequest" action="registerUser">
    <input id="id" name="propertyUser.id"   type="hidden" value="" maxlength="30">
    User Type  <input id="usertype1" name="propertyUser.userTypeId" style="border:none;" type="radio" value="1" checked="checked">
               <input id="usertype2" name="propertyUser.userTypeId" style="border:none;" type="radio" value="2">
               <input id="usertype3" name="propertyUser.userTypeId" style="border:none;" type="radio" value="3">
<br>
    First Name <input id="firstName" name="propertyUser.firstName" class="txt" type="text" value="" maxlength="30">
    <br>
    Email <input id="emailId" name="propertyUser.emailId" class="txt" type="text" value="" maxlength="30">
    <br>
    Password <input id="passwrd" name="propertyUser.passwrd" class="txt" type="text" value="" maxlength="30">
    <br>
    City
    <select  name="propertyUser.cityId" id="cityId">
        <option value="-1">--Select--</option>
        <c:forEach var="data" items="${response.module[0].moduleResponse.locality}">
            <option value="${data.id}">${data.name}</option>
        </c:forEach>
    </select>
    <br>
    Mobile <input id="mobile" name="propertyUser.mobileNo" class="txt" type="text" value="" maxlength="30">
    <br>
    Landline <input id="phone" name="propertyUser.phone" class="txt" type="text" value="" maxlength="30">
    <br>
    Spam Check <%--<input id="spamCheck" name="propertyUser" class="txt" type="text" value="" maxlength="30">--%>
    <input type="submit" value="Register">
</form>
</body>
</html>

