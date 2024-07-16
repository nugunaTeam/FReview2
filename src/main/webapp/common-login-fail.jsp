<%--
  Created by IntelliJ IDEA.
  User: rlagk
  Date: 2024-06-08
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Fail</title>
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script>
      $(function(){
        alert("로그인에 실패하였습니다. 다시 로그인을 시도해주세요.");
        history.back();
      })
    </script>
</head>
<body>

</body>
</html>
