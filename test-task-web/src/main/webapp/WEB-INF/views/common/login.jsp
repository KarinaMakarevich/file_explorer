<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page session="true" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="resources/css/common/index.css">
    <link rel="stylesheet" href="resources/css/common/responsive.css">
</head>
<body>
<section class="content login-content">
    <div class="field">
        <form name="form" class="card login-card" method="post"
              action="j_spring_security_check">
            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                <div class="wrong-info">
                    <p>Invalid username or password.</p>
                </div>
            </c:if>
            <div class="field">
                <input name="j_username" type="text" placeholder="Username" required>
            </div>
            <div class="field">
                <input name="j_password" type="password" placeholder="Password" required>
            </div>
            <div class="field">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </div>
            <button class="button" type="submit">LogIn</button>
            <div class="field">
                <a href="<c:url value="/openRegistrationPage"/>">Registration</a>
            </div>
        </form>
    </div>
</section>
<%@include file="../footer/footer.jsp" %>
</body>
</html>