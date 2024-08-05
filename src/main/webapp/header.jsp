<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="loginUser" value="${loginUser}"/>
<c:set var="userSeq" value="${loginUser.seq}"/>
<c:set var="nickname" value="${loginUser.nickname}"/>
<c:set var="profileUrl" value="${loginUser.profilePhotoUrl}" />
<c:set var="code" value="${loginUser.code}"/>

<header id="header" class="header fixed-top d-flex align-items-center header">
    <div class="d-flex align-items-center justify-content-between ">
        <a href="/main?seq=${userSeq}&pagecode=Requester"
           class="logo d-flex align-items-center">
            <img src="/assets/img/logo/logo-vertical.png" alt=""
                 style="width: 50px; margin-top: 20px;">
            <span class="d-none d-lg-block">FReview</span>
        </a>
    </div>

    <nav class="nav-menu d-none d-lg-block">
        <ul>
            <li><a href="/notice">공지게시판</a></li>
            <li><a href="/mojip">모집게시판</a></li>
            <li><a href="/recommendation/customer">체험단 추천</a></li>
            <li><a href="/recommendation/store">사장님 추천</a></li>
        </ul>
    </nav>

<%--    TODO: 마이페이지 이동하는 컨트롤러 체험단/사장님/관리자 통합 후 링크 수정 필요--%>
    <div class="header-right">
        <a href="/my-info?user_seq=${userSeq}" style="margin-right: 20px">
            ${nickname}
            <img src="${profileUrl}" alt=" " style="width: 30px; margin-top: 15px;">
        </a>
        <a href="/COMM_logout.jsp" style="margin-top: 17px;">로그아웃</a>
    </div>
</header>
