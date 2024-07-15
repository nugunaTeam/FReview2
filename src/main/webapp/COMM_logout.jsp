<%--
  Created by IntelliJ IDEA.
  User: rlagk
  Date: 2024-06-10
  Time: 오전 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.removeAttribute("Member");
%>
<html>
<head>
    <title>Logout</title>
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script>
      $(function(){
        alert("계정에서 로그아웃하였습니다.");
        location.href="/main?pagecode=non_member";
      })
    </script>
</head>
<body>

</body>
</html>
