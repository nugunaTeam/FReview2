<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.google.gson.Gson" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
    String userSeq = request.getParameter("userSeq");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" type="text/css" href="/assets/css/style-h.css"/>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Users / Profile - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="/assets/img/favicon.png" rel="icon">
    <link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="/assets/css/style.css" rel="stylesheet">

    <!-- add css-->
    <link rel="stylesheet" href="/assets/css/style-h.css"/>
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="/main?seq=${userSeq}&pagecode=Boss"
           class="logo d-flex align-items-center">
            <img src="/assets/img/logo/logo-vertical.png" alt="">
            <span class="d-none d-lg-block">FReview</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
            <li class="nav-item dropdown pe-3">
                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#">
                    <img src="/assets/img/basic/basic-profile-img.png" alt="Profile"
                         class="rounded-circle">
                    <span id="nickname-holder-head"
                          class="d-none d-md-block">${user.nickname}</span>
                </a><!-- End Profile Iamge Icon -->
            </li><!-- End Profile Nav -->
        </ul>
    </nav><!-- End Icons Navigation -->
</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="/my-info?userSeq=${userSeq}">
                <i class="bi bi-award"></i>
                <span>브랜딩</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store-experience-page.jsp">
                <i class="bi bi-grid"></i>
                <span>체험</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store-activity-page.jsp">
                <i class="bi bi-card-checklist"></i>
                <span>활동</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link"
               href="${pageContext.request.contextPath}/store-notification-page.jsp">
                <i class="bi bi-bell"></i>
                <span>알림</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#">
                <i class="bi bi-person"></i>
                <span>개인정보수정</span>
            </a>
        </li>
    </ul>


</aside><!-- End Sidebar-->
<main id="main" class="main">

    <section class="section">
        <div class="row">
            <div class="col-lg-12">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Bordered Tabs</h5>

                        <!-- Bordered Tabs -->
                        <ul class="nav nav-tabs nav-tabs-bordered" id="borderedTab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active" id="like-tab" data-bs-toggle="tab" data-bs-target="#received-like" type="button" role="tab" aria-controls="home" aria-selected="true">좋아요</button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="zzim-tab" data-bs-toggle="tab" data-bs-target="#received-zzim" type="button" role="tab" aria-controls="profile" aria-selected="false">찜</button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="reply-tab" data-bs-toggle="tab" data-bs-target="#received-reply" type="button" role="tab" aria-controls="contact" aria-selected="false">댓글</button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="experience-tab" data-bs-toggle="tab" data-bs-target="#experience-list" type="button" role="tab" aria-controls="contact" aria-selected="false">체험</button>
                            </li>
                        </ul>
                        <div class="tab-content pt-4" id="borderedTabContent">
                            <div class="tab-pane fade show active" id="received-like" role="tabpanel" aria-labelledby="like-tab">
                                <div id="receivedLikeList">
                                    <c:forEach var="like" items="${receivedLike}">
                                        <div class='card'>
                                            <div class='card-body'>
                                                <h5 class='card-title'>
                                                    <a href='${pageContext.request.contextPath}/store/my/brand-info?userSeq=' + ${like.userSeq}>${like.title}</a>
                                                </h5>
                                                <p>${like.content}</p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="tab-pane fade" id="received-zzim" role="tabpanel" aria-labelledby="zzim-tab">
                                <div id="receivedZzimList">
                                    <c:forEach var="zzim" items="${receivedZzim}">
                                        <div class='card'>
                                            <div class='card-body'>
                                                <h5 class='card-title'>
                                                    <a href='${pageContext.request.contextPath}/store/my/brand-info?userSeq=' + ${zzim.userSeq}>${zzim.nickname}</a>
                                                </h5>
                                                <p>${dateFormat.format(new Date(zzim.createdAt.time))}</p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="received-reply" role="tabpanel" aria-labelledby="reply-tab">
                                <div id="receivedReplyList">
                                    <c:forEach var="reply" items="${receivedReply}">
                                        <div class='card'>
                                            <div class='card-body'>
                                                <h5 class='card-title'>
                                                    <a href='${pageContext.request.contextPath}/store/my/brand-info?userSeq=' + ${reply.userSeq}>${reply.title}</a>
                                                </h5>
                                                <p>${reply.content}</p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="experience-list" role="tabpanel" aria-labelledby="experience-tab">
                                <div id="experienceList">
                                    <c:forEach var="experience" items="${experience}">
                                        <div class='card'>
                                            <div class='card-body'>
                                                <h5 class='card-title'>
                                                    <a href='${pageContext.request.contextPath}/store/my/brand-info?userSeq=' + ${experience.userSeq}>${experience.title}</a>
                                                </h5>
                                                <p>${dateFormat.format(date(experience.createdAtat))}</p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div><!-- End Bordered Tabs -->

                    </div>
                </div>
            </div>
        </div>
    </section>

</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/assets/vendor/chart.js/chart.umd.js"></script>
<script src="/assets/vendor/echarts/echarts.min.js"></script>
<script src="/assets/vendor/quill/quill.js"></script>
<script src="/assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="/assets/js/main.js"></script>
<script>

</script>
</body>

</html>