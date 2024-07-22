<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <style>
      .bi-heart-fill {
        color: red;
      }
      .card-body-y {
        padding: 10px 20px;
      }

      .card-title-y {
        padding: 10px 0px 5px 0;
        font-size: 16px;
        font-weight: 500;
        color: #012970;
        font-family: "Poppins", sans-serif;
      }

      .p-last {
        margin-top : 0;
        margin-bottom: 0.5rem;
        font-size: 12px;
        color : #696969;
      }

      .card-title span {
        color: #899bbd;
        font-size: 14px;
        font-weight: 400;
      }
    </style>

    <!-- add css-->
    <link rel="stylesheet" href="/assets/css/style-h.css"/>
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="/main?seq=${userSeq}&pagecode=Requester"
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
                          class="d-none d-md-block">${nickname}</span>
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
               href="/store/my/brand-info?userSeq=${userSeq}">
                <i class="bi bi-grid"></i>
                <span>브랜딩</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/experience?userSeq=${userSeq}">
                <i class="bi bi-card-checklist"></i>
                <span>체험</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link "
               href="${pageContext.request.contextPath}/store/activity?userSeq=${userSeq}">
                <i class="bi bi-bell"></i>
                <span>활동</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/notification?userSeq=${userSeq}">
                <i class="bi bi-card-checklist"></i>
                <span>알림</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/store/my-info?userSeq=${userSeq}">
                <i class="bi bi-person"></i>
                <span>개인정보수정</span>
            </a>
        </li><!-- End Register Page Nav -->

    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

    <section class="section profile">
        <div class="row">
            <div class="col-xl-12">

                <div class="card">
                    <div class="card-body">

                        <!-- Bordered Tabs -->
                        <ul class="nav nav-tabs nav-tabs-bordered pt-4" id="borderedTab"
                            role="tablist">
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active" id="like-tab" data-bs-toggle="tab"
                                        data-bs-target="#send-like" type="button" role="tab"
                                        aria-controls="like" aria-selected="true">좋아요
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="zzim-tab" data-bs-toggle="tab"
                                        data-bs-target="#send-zzim" type="button" role="tab"
                                        aria-controls="zzim" aria-selected="false">찜
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="post-tab" data-bs-toggle="tab"
                                        data-bs-target="#written-post" type="button" role="tab"
                                        aria-controls="post" aria-selected="false">작성한 글
                                </button>
                            </li>
                        </ul>
                        <div class="tab-content pt-4" id="borderedTabContent">
                            <!-- 내가 좋아요 한 글 -->
                            <div class="tab-pane fade show active" id="send-like" role="tabpanel"
                                 aria-labelledby="like-tab">
                                <form>
                                    <c:forEach var="like" items="${sendLike}">
                                    <div class="card" id="sendLikeList">
                                        <div class="card-body-y">
                                            <h6 class="card-title-y">
                                                <a href="${pageContext.request.contextPath}/mojip/${like.postSeq}">
                                                    ${fn:length(like.title) > 20 ? fn:substring(like.title, 0, 20) + '...' : like.title}
                                                </a>
                                            </h6>
                                            <p>${fn:length(like.content) > 30 ? fn:substring(like.content, 0, 30) + '...' : like.content}</p>
                                            <p class="p-last"><fmt:formatDate value="${like.createdAt}" pattern="yyyy년 MM월 dd일"/> &nbsp<i class="bi bi-heart-fill"></i> &nbsp${like.likeCount}</p>
                                        </div>
                                    </div>
                                    </c:forEach>
                                    <!-- End Default Card -->
                                </form>
                            </div>

                            <!-- 내가 찜한 유저 -->
                            <div class="tab-pane fade" id="send-zzim" role="tabpanel"
                                 aria-labelledby="zzim-tab">
                                <form>
                                    <div class="pb-4">
                                        <input type="radio" name="code" value="customer" checked> 체험단
                                        <input type="radio" name="code" value="store"> 스토어
                                    </div>
                                    <c:forEach var="zzim" items="${sendZzim}">
                                    <div class="card" id="sendZzimList">
                                        <div class="card-body">
                                            <a href="/my/brand-info?userSeq=${zzim.toUserSeq}">
                                                <h6 class="card-title">${zzim.nickname}</h6>
                                            </a>
                                            <c:choose>
                                                <c:when test="${zzim.code eq 'customer' and param.code eq 'customer'}">
                                                    <p>분야:
                                                        <c:choose>
                                                            <c:when test="${not empty zzim.foodTypeList}">
                                                                <c:forEach var="foodType" items="${zzim.foodTypeList}" varStatus="foodTypeStatus">
                                                                    <c:if test="${foodTypeStatus.index != 0}">, </c:if>
                                                                    <c:out value="${foodType.code}"/>
                                                                </c:forEach>
                                                            </c:when>
                                                            <c:otherwise>
                                                                미등록
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </p>
                                                </c:when>
                                                <c:otherwise>
                                                    <p>위치: ${zzim.storeLocation}</p>
                                                    <p>분야:
                                                        <c:choose>
                                                            <c:when test="${not empty zzim.foodTypeList}">
                                                                <c:forEach var="foodType" items="${zzim.foodTypeList}" varStatus="foodTypeStatus">
                                                                    <c:if test="${foodTypeStatus.index != 0}">, </c:if>
                                                                    <c:out value="${foodType.code}"/>
                                                                </c:forEach>
                                                            </c:when>
                                                            <c:otherwise>
                                                                미등록
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </p>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div><!-- End Default Card -->
                                    </c:forEach>
                                </form>
                            </div>

                            <!-- 내가 작성한 글 -->
                            <div class="tab-pane fade" id="written-post" role="tabpanel"
                                 aria-labelledby="post-tab">
                                <form>
                                    <c:forEach var="post" items="${writtenPost}">
                                    <div class="card" id="writtenPostList">
                                        <div class="card-body-y">
                                            <h6 class="card-title-y">
                                                ${post.title}
                                            </h6>
                                            <p>${post.content}</p>
                                            <p class="p-last"><fmt:formatDate value="${post.createdAt}" pattern="yyyy년 MM월 dd일"/> &nbsp<i class="bi bi-heart-fill"></i> &nbsp${post.likeCount}</p>
                                    </div>
                                    </c:forEach>
<%--                                    <c:forEach var="post" items="${writtenPost}">--%>
<%--                                    <div class="card" id="writtenPostList">--%>
<%--                                        <div class="card-body-y">--%>
<%--                                            <h6 class="card-title-y">--%>
<%--                                                <a href="${pageContext.request.contextPath}/mojip/${post.seq}">--%>
<%--                                                        ${fn:length(post.title) > 20 ? fn:substring(post.title, 0, 20) + '...' : post.title}--%>
<%--                                                </a>--%>
<%--                                            </h6>--%>
<%--                                            <p>${fn:length(post.content) > 30 ? fn:substring(post.content, 0, 30) + '...' : post.content}</p>--%>
<%--                                            <p class="p-last"><fmt:formatDate value="${post.createdAt}" pattern="yyyy년 MM월 dd일"/> &nbsp<i class="bi bi-heart-fill"></i> &nbsp${post.likeCount}</p>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    </c:forEach>--%>
<%--                                    <!-- End Default Card -->--%>
                                </form>
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

</body>

</html>