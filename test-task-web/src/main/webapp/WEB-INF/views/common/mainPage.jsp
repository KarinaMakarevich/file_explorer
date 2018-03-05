<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>MainPage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="../../../resources/css/common/index.css">
    <link rel="stylesheet" href="../../../resources/css/common/responsive.css">
    <link rel="stylesheet" href="../../../resources/css/items/items.css">

</head>
<body>

<%@include file="../header/header.jsp" %>

<section class="content">
    <aside>
        <div class="card collection">
            <div class="collection-item">
                <form class="card client-order" action="${pageContext.request.contextPath}/showAllFiles" method="get">
                    <button class="button common-button" type="submit">All files</button>
                </form>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <form class="card client-order" action="${pageContext.request.contextPath}/showAddUserForm" method="get">
                        <button class="button common-button" type="submit">Add user</button>
                    </form>
                </security:authorize>
            </div>
        </div>
        <button id="forajaxxx"></button>
    </aside>
    <%@include file="../admin/util/modalWindows.jsp" %>
    <main class="items">
        <c:forEach var="file" items="${allFiles}">
            <c:set var="key" value="${file.key}"/>
            <article class="item card" id="${file.key}">
                <form action="${pageContext.request.contextPath}/fileAction" method="get">
                    <main class="item-content">
                        <c:if test="${file.value eq 'file'}">
                            <button class="button form-button" type="submit" name="fileButton"
                                    value="${file.key}" disabled>${file.key}</button>
                            <img class="file-folder" src="../../../resources/images/file.jpg">
                        </c:if>
                        <c:if test="${file.value eq 'folder'}">
                            <button class="button form-button" type="submit" name="fileButton"
                                    value="${file.key}">${file.key}</button>
                            <img class="file-folder" src="../../../resources/images/folder.png">
                        </c:if>
                    </main>
                </form>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <footer class="item-footer">
                        <c:if test="${file.value eq 'folder'}">
                            <button class="button create-button" name="createButton" value="${file.key}"
                                    onclick="alert(this.value); openCreateModalWindow(this.value)">
                                Create file or folder in
                                this folder
                            </button>
                            <button class="button delete-button" name="deleteButton" value="${file.key}"
                                    onclick="openQuestionModalWindow(this.value)">Delete folder
                            </button>
                        </c:if>
                        <c:if test="${file.value eq 'file'}">
                            <button class="button delete-file-button" name="deleteButton"
                                    value="${file.key}"
                                    onclick="openQuestionModalWindow(this.value)">Delete file
                            </button>
                        </c:if>
                    </footer>
                </security:authorize>
            </article>
        </c:forEach>
        <div id="container"></div>
    </main>
</section>

<%@include file="../footer/footer.jsp" %>
<script type="text/javascript" src="../../../resources/js/file.js"></script>
<script type="text/javascript" src="../../../resources/js/util/jquery-3.2.1.js"></script>
</body>
</html>


