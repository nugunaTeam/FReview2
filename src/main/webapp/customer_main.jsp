<%--
  Created by IntelliJ IDEA.
  User: rlagk
  Date: 2024-07-23
  Time: 오전 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>체험단 메인페이지</title>
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script src="assets/js/jwt.js"></script>
</head>
<body>
     <c:if test="${not empty userVO}">
        <h2>User Information</h2>
        <p>Email: ${userVO.email}</p>
        <p>Name: ${userVO.seq}</p>
        <!-- userVO의 다른 필드들도 출력할 수 있습니다 -->
    </c:if>

    <c:if test="${empty userVO}">
        <p>User information is not available.</p>
    </c:if>
</body>
</html>
