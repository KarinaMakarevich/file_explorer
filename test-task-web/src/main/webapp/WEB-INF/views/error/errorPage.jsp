<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Error </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="../../../resources/css/common/index.css">
    <link rel="stylesheet" href="../../../resources/css/common/responsive.css">
</head>
<body>
<header class="header">
</header>
<section class="content login-content">
    <div class="field">
        <form class="card register-card">
            <div class="field">
                <label>There was some mistake </label>
            </div>
            <div class="field">
                <label>Error </label>
                <span>${pageContext.exception}</span>
            </div>
            <div class="field">
                <label>Status code </label>
                <span>${pageContext.errorData.statusCode}</span>
            </div>
            <div class="field">
                <label>StackTrace </label>
                <div>${pageContext.exception.stackTrace}</div>
            </div>
        </form>
    </div>
</section>
<%@include file="../footer/footer.jsp" %>
</body>
</html>