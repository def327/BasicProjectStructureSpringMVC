<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>Hello <b>${user.login}</b></h5>
<h5>Your password is <b>${user.password}</b></h5>
<h5>Keep user to be logged is <b>${user.keepLoggedIn}</b></h5>

<h1>To check the bean defenition</h1>

Name : ${complexUser2.login}<br>
Password : ${complexUser2.password}<br>
Be logged: ${complexUser2.keepLoggedIn}<br>

</body>
</html>
