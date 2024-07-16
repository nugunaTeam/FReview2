<%--
  Created by IntelliJ IDEA.
  User: rlagk
  Date: 2024-06-07
  Time: 오전 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Success</title>
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script>
        $(function(){
          alert("회원가입에 성공하였습니다. 로그인해주세요!");
          location.href="/auth?pagecode=login";
        })
    </script>
</head>
<body>

</body>
</html>
