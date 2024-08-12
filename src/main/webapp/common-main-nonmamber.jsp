<%@ page import="com.nuguna.freview.dto.MainpageMojipDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nuguna.freview.dto.MainpageRequesterDTO" %>
<%@ page import="com.nuguna.freview.dto.MainpageGongjiDTO" %><%--
  Created by IntelliJ IDEA.
  User: rlagk
  Date: 2024-06-09
  Time: 오후 3:12
  To change this template use File | Settings | File Templates.
--%>
// common-notice-board-y.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    ArrayList<MainpageMojipDTO> mojips = (ArrayList<MainpageMojipDTO>)request.getAttribute("mojips");
    ArrayList<MainpageRequesterDTO> requesters = (ArrayList<MainpageRequesterDTO>)request.getAttribute("requesters");
    ArrayList<MainpageGongjiDTO> gongjis = (ArrayList<MainpageGongjiDTO>)request.getAttribute("gongji");
%>

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
<header id="header" class="header fixed-top d-flex align-items-center header-hr">

    <div class="d-flex align-items-center justify-content-between header-hr-left">
        <a href="#" class="logo d-flex align-items-center">
            <img src="assets/img/logo/logo-vertical.png" alt="" style="  width: 50px;
    margin-top: 20px;">
            <span class="d-none d-lg-block">Freview</span>
        </a>
    </div><!-- End Logo -->
    <div class="header-hr-right">
        <a href="/auth?pagecode=login" style="margin-right: 20px">로그인</a>
        <a href="/auth?pagecode=register">회원가입</a>
    </div>
</header><!-- End Header -->

<main id="main_wrap" class="main">
    <div id ="main" style="margin:auto; margin-top:80px">
    <div class="pagetitle">
        <h1>메인페이지</h1>
    </div><!-- End Page Title -->
        <div class = "card">
            <div class="card-header card-header-hr">
                <h5>모집글</h5>
                <a href="/auth?pagecode=login">모집글 게시판으로 가기</a>
            </div>
            <div class="card-body card-body-hr">
                    <%for(MainpageMojipDTO dto : mojips){ %>
                    <div class="post-list">
                        <a href="#" class="post-item">
                            <figure>
                                <%if(dto.getThumbnailPhotoUrl()==null){%>
                                <img src="https://play-lh.googleusercontent.com/38AGKCqmbjZ9OuWx4YjssAz3Y0DTWbiM5HB0ove1pNBq_o9mtWfGszjZNxZdwt_vgHo=w240-h480-rw" alt="Profile" class="profile-img">
                                <%} else{%>
                                <img src="<%=dto.getThumbnailPhotoUrl()%>" alt="Profile" class="profile-img">
                                <%}%>
                            </figure>
                            <h5><%=dto.getTitle()%></h5>
                            <p>작성자: <%=dto.getMemberSeq()%></p>
                            <p>모집 기간: <%=dto.getApplyStartDate()%> ~ <%=dto.getApplyEndDate()%> </p>
                            <p>방문 날짜: <%=dto.getExperienceDate()%></p>
                            <p>좋아요 수: <%=dto.getViewCount()%></p>
                        </a>
                    </div>
                    <%}%>
            </div>
        </div>
    <div class = "card">
        <div class="card-header">
            <h5>최근 활동한 체험단</h5>
        </div>
        <div class="card-body card-body-hr">
            <%for(MainpageRequesterDTO dto : requesters){%>
            <div class="post-list">
                <a href="#" class="post-item">
                    <figure>
                    <%if(dto.getProfilePhotoUrl()==null){%>
                        <img src="https://play-lh.googleusercontent.com/38AGKCqmbjZ9OuWx4YjssAz3Y0DTWbiM5HB0ove1pNBq_o9mtWfGszjZNxZdwt_vgHo=w240-h480-rw" alt="Profile" class="profile-img">
                        <%} else{%>
                    <img src="<%=dto.getProfilePhotoUrl()%>" alt="Profile" class="profile-img">
                        <%}%>
                    </figure>
                    <h5><%=dto.getNickname()%></h5>
                </a>
            </div>
            <%}%>
        </div>
    </div>
    <div class="card">
        <div class="card-header card-header-hr">
            <h5>공지글</h5>
            <a href="/auth?pagecode=login">공지글 게시판으로 가기</a>
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
                <%for(MainpageGongjiDTO dto : gongjis){%>
                <tr>
                    <td><%=dto.getPostSeq()%></td>
                    <td><a href="#"><%=dto.getTitle()%></a></td>
                    <td><%=dto.getCreatedAt()%></td>
                    <td><%=dto.getUpdatedAt()%></td>
                </tr>
                <%}%>
                </tbody>
            </table>
            <!-- End Table with stripped rows -->

        </div>
        </div>
    </div>
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer" style="margin-left: 0">
    <div class="copyright">
        &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!— You can delete the links only if you purchased the pro version. —>
        <!— Licensing information: https://bootstrapmade.com/license/ —>
        <!— Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ —>
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
</footer><!— End Footer —>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!— Vendor JS Files —>
<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/chart.js/chart.umd.js"></script>
<script src="assets/vendor/echarts/echarts.min.js"></script>
<script src="assets/vendor/quill/quill.js"></script>
<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="assets/vendor/tinymce/tinymce.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>

<!— Template Main JS File —>
<script src="assets/js/main.js"></script>
<script src="assets/js/hr.js"></script>
</body>

</html>
