<%@ page import="com.nuguna.freview.entity.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: rlagk
  Date: 2024-06-08
  Time: 오후 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Member user = (Member)session.getAttribute("Member");
    int seq = user.getMemberSeq();
%>
<html>
<head>
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script>
      $(function(){
        alert("로그인에 성공하였습니다. 사장님 회원 페이지로 이동합니다");
        location.href="/main?pagecode=Boss&&seq=<%=seq%>";
      })
    </script>
</head>
<body>
</body>
</html>
