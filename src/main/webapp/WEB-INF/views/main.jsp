<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Main page</title>
    <link href="<c:url value="/resources/reset.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/structure.css"/>" rel="stylesheet">
</head>
<body>

<form:form method="POST" modelAttribute="user" action="/check-user" class="box login">

    <fieldset class="boxBody">

        <form:label path="login">Username:</form:label>
        <form:input path="login" type="text" tabindex="1" required="required"/>
        <form:errors path="login" cssClass="errorClass"/>

        <form:label path="password">Password:</form:label>
        <form:password path="password" required="required"/>
        <form:errors path="password" cssClass="errorClass"/>
    </fieldset>
    <footer>

        <form:label path="keepLoggedIn">Keep me logged in</form:label>
        <form:checkbox path="keepLoggedIn" tabindex="3"/>

        <input type="submit" class="btnLogin" tabindex="4"/>

    </footer>

</form:form>
</body>
</html>


