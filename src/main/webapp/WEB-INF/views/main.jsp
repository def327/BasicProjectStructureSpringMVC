<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <link href="<c:url value="/resources/reset.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/structure.css"/>" rel="stylesheet">

</head>
<body>

<form class="box login">
    <fieldset class="boxBody">
        <label>Username</label>
        <input type="text" tabindex="1" placeholder="Enter Username" required>
        <label><a href="/password/restore" class="rLink" tabindex="5">Forget your password?</a>Password</label>
        <input type="password" tabindex="2" placeholder="Enter Password" required>
    </fieldset>
    <footer>
        <label><input type="checkbox" tabindex="3">Keep me logged in</label>
        <input type="submit" class="btnLogin" value="Login" tabindex="4">
    </footer>
</form>


</body>
</html>
