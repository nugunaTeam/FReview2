<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="loginUser" value="${loginUser}"/>
<c:set var="userSeq" value="${loginUser.seq}"/>
<c:set var="nickname" value="${loginUser.nickname}"/>
<c:set var="profileUrl" value="${loginUser.profilePhotoUrl}" />
<c:set var="code" value="${loginUser.code}"/>

<style>

  img{
    width: 200px;
    border-radius: 50px;
    margin-bottom: 20px;
  }
  .header{
    display: flex;
    justify-content: space-between;
  }
  .header-left,.header-right{
    display: flex;
  }
  .header-left{
    margin-left: 60px;
  }
  .header-right{
    margin-right: 60px;
  }
  .card-header{
    display: flex;
    justify-content: space-between;
  }

  .nav-menu {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-grow: 1;
  }

  .nav-menu ul {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .nav-menu ul li {
    padding: 0 15px;
  }

  .nav-menu ul li a {
    color: #000000;
    text-decoration: none;
    transition: color 0.3s ease;
  }

  .nav-menu ul li a:hover {
    color: #808080;
  }
</style>

<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="/main" class="logo d-flex align-items-center">
            <img src="/assets/img/logo/logo-vertical.png" alt="" style="width: 50px; margin-top: 20px;">
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

    <div class="header-right">
        <a href="/my" style="margin-right: 20px">
            ${nickname}
            <img src="${profileUrl}" alt=" " style="width: 30px; margin-top: 15px;">
        </a>
        <a href="/logout" style="margin-top: 17px;">로그아웃</a>
    </div>
</header>
