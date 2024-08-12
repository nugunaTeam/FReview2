<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Components / Accordion - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/hr.css" rel="stylesheet">
    <style>
      /* Custom CSS to make all table rows white */
      table tbody tr {
        background-color: white !important;
      }
    </style>
    <!-- =======================================================
    * Template Name: NiceAdmin
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Updated: Apr 20 2024 with Bootstrap v5.3.3
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<body>

<!-- ======= Header ======= -->
<jsp:include page="/header.jsp" />
<main id="main_wrap" class="main">
    <div id="main" style="margin:auto; margin-top:80px">
        <div class="pagetitle">
            <h1>메인페이지</h1>
        </div><!-- End Page Title -->
        <div class="card">
            <div class="card-header card-header-hr">
                <h5>HOT 모집글</h5>
                <a href="/mojip">모집글 게시판으로 가기</a>
            </div>
            <div class="card-body card-body-hr">
                <c:forEach var="dto" items="${mojips.hotMojipList}">
                    <div class="post-list">
                        <a href="/mojip/${dto.postSeq}" class="post-item">
                            <figure>
                                <c:choose>
                                    <c:when test="${dto.profilePhotoUrl == null}">
                                        <img src="https://play-lh.googleusercontent.com/38AGKCqmbjZ9OuWx4YjssAz3Y0DTWbiM5HB0ove1pNBq_o9mtWfGszjZNxZdwt_vgHo=w240-h480-rw"
                                             alt="Profile" class="profile-img">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${dto.profilePhotoUrl}" alt="Profile" class="profile-img">
                                    </c:otherwise>
                                </c:choose>
                            </figure>
                            <h5>${dto.title}</h5>
                            <p>${dto.storeName}</p>
                            <p>제목: ${dto.title}</p>
                            <p>모집 기간: ${dto.applyStartDate} ~ ${dto.applyEndDate}</p>
                            <p>방문 날짜: ${dto.experienceDate}</p>
                            <p>위치: ${dto.storeLocation}</p>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="card">
            <div class="card-header card-header-hr">
                <h5>최근 공지글</h5>
                <a href="/notice">공지글 게시판으로 가기</a>
            </div>
            <div class="card-body">
                <!-- Table with stripped rows -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성일자</th>
                        <th>수정일자</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" items="${gongjis.recentGongjiList}">
                        <tr>
                            <td>${dto.seq}</td>
                            <td><a href="/notice/${dto.seq}">${dto.title}</a></td>
                            <td>${dto.createdAt}</td>
                            <td>${dto.updatedAt}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!-- End Table with stripped rows -->
            </div>
        </div>
    </div>
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<jsp:include page="/footer.jsp" />