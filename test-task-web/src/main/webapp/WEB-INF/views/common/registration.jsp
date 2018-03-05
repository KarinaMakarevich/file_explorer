<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="resources/css/common/index.css">
    <link rel="stylesheet" type="text/css" href="resources/css/common/responsive.css">

</head>
<body>

<header class="header">

</header>

<section class="content register-content">

    <form class="card register-card" onsubmit="return validateForm()"
          action="/signUp" method="post"
          id="register-form">
        <div class="field">
            <label class="required">Name</label>
            <input type="text" id="name" name="name" placeholder="${name}" value="${requestScope.get("name")}" required>
        </div>
        <div class="field">
            <label class="required">Surname</label>
            <input type="text" id="surname" name="surname" placeholder="${surname}"
                   value="${requestScope.get("surname")}"
                   required>
        </div>
        <div class="field">
            <label class="required">Email</label>
            <input type="text" id="mail" name="mail" placeholder="${mail}"
                   value="${requestScope.get("mail")}" required>
            <input type=hidden name="wrong_mail" placeholder="${wrEmail}">
        </div>
        <div class="field">
            <label class="required">Login</label>
            <input type="text" id="login" name="login" placeholder="${login}" value="${requestScope.get("login")}"
                   required>
        </div>
        <div class="field">
            <label class="required">Password</label>
            <input type="password" id="password" name="password" placeholder="${password}"
                   value="${requestScope.get("password")}" required>
        </div>
        <div class="field">
            <label class="required">Repeat password</label>
            <input type="password" id="repeat-password" name="repeat-password" placeholder="${repPassword}"
                   value="${requestScope.get("repeat-password")}" required>
        </div>
        <button class="button" type="submit">Register</button>
    </form>

</section>
<%@include file="../footer/footer.jsp" %>

</body>
</html>