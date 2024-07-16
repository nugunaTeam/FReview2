<%@ page import="com.nuguna.freview.dto.cust.brand.CustMyBrandInfoDto" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    CustMyBrandInfoDto brandInfo = (CustMyBrandInfoDto) request.getAttribute("brandInfo");
    Gson gson = new Gson();
%>


<!DOCTYPE html>
<html lang="en">

<head>
    <style>
      .selected-option {
        background-color: lightgreen; /* 연초록색으로 선택된 옵션 표시 */
      }
    </style>

    <style>
      .form-control {
        width: 100%;
        height: 38px;
        padding: 6px 12px;
        font-size: 14px;
        line-height: 1.42857143;
        color: #555;
        background-color: #fff;
        background-image: none;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
      }

      .form-control-readonly {
        background-color: #e9ecef;
        opacity: 1;
      }
    </style>

    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Users / Profile - NiceAdmin Bootstrap Template</title>
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

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-h.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- icon bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
<header id="header" class="header fixed-top xd-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
            <img src="assets/img/logo/logo-vertical.png" alt="">
            <span class="d-none d-lg-block">FReview</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
            <li class="nav-item dropdown pe-3">
                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#">
                    <img src="assets/img/basic/basic-profile-img.png" alt="Profile"
                         class="rounded-circle">
                    <span id="nickname-holder-head"
                          class="d-none d-md-block">${fromMemberNickname}</span>
                </a><!-- End Profile Iamge Icon -->
            </li><!-- End Profile Nav -->
        </ul>
    </nav><!-- End Icons Navigation -->
</header><!-- End Header -->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Profile</h1>
    </div><!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="card">
                <!-- profile  -->
                <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                    <img src="assets/img/basic/basic-profile-img.png" alt="Profile"
                         class="rounded-circle">
                    <h2 id="nickname-holder-section">${brandInfo.nickname}</h2>
                    <div class="social-links mt-2 ri-heart-3-fill">
                        ${brandInfo.zzimCount}
                    </div>
                </div>

                <div class="card-body pt-3">
                    <!-- Bordered Tabs -->
                    <div class="tab-content pt-2">

                        <div class="tab-pane fade show active profile-overview"
                             id="profile-overview">

                            <h5 class="card-title">Profile Details</h5>

                            <!-- 소개 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">소개</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="introduce-input" type="text"
                                           value="<%= brandInfo.getIntroduce() %>"
                                           class="form-control" readonly>
                                </div>
                            </div>
                        </div>

                        <!-- 닉네임 보여주기/등록하기 -->
                        <div class="tab-pane fade show active profile-overview">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">닉네임</div>
                                <div class="col-lg-8 col-md-6">
                                    <input type="text"
                                           value="<%=brandInfo.getNickname()%>"
                                           class="form-control" readonly>
                                </div>
                            </div>
                        </div>

                        <!-- 연령대 보여주기/등록하기 -->
                        <div class="tab-pane fade show active profile-overview">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">연령대</div>
                                <div class="col-lg-8 col-md-6">
                                    <input type="text"
                                           value="<%=brandInfo.getAgeGroup()%>"
                                           class="form-control" readonly>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane fade show active profile-overview">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">활동 분야</div>
                                <div class="col-lg-8 col-md-6">
                                    <select id="food-type-select" class="form-select" multiple
                                            size="6" disabled>
                                        <option value="한식">한식</option>
                                        <option value="양식">양식</option>
                                        <option value="중식">중식</option>
                                        <option value="일식">일식</option>
                                        <option value="빵&베이커리">빵&베이커리</option>
                                        <option value="기타">기타</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <script>
                          // 서버에서 받아온 foodType 목록을 JSON 형태로 포함
                          var selectedFoodTypes = JSON.parse(
                              '<%= gson.toJson(brandInfo.getFoodTypes()) %>');

                          // foodType 목록을 미리 선택된 상태로 설정
                          document.addEventListener('DOMContentLoaded', function () {
                            var foodTypeSelect = document.getElementById('food-type-select');
                            for (var i = 0; i < foodTypeSelect.options.length; i++) {
                              if (selectedFoodTypes.includes(foodTypeSelect.options[i].value)) {
                                foodTypeSelect.options[i].selected = true;
                                foodTypeSelect.options[i].classList.add('selected-option');
                              }
                            }
                          });
                        </script>


                        <!-- 태그들 보여주기/등록하기 -->
                        <div class="tab-pane fade show active profile-overview">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">태그</div>
                                <div class="col-lg-8 col-md-6">
                                    <select id="tag-select" class="form-select" multiple size="3"
                                            disabled>
                                        <option value="초식">초식</option>
                                        <option value="육식">육식</option>
                                        <option value="빵빵이">빵빵이</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <script>
                          $(document).ready(function () {
                            var selectedTags = JSON.parse(
                                '<%=gson.toJson(brandInfo.getTagInfos())%>');

                            function initializeTagSelect() {
                              var tagSelect = $('#tag-select');
                              tagSelect.find('option').each(function () {
                                if (selectedTags.includes($(this).val())) {
                                  $(this).prop('selected', true);
                                  $(this).addClass('selected-option');
                                } else {
                                  $(this).prop('selected', false);
                                  $(this).removeClass('selected-option');
                                }
                              })
                              ;
                            }

                            initializeTagSelect();
                          });
                        </script>
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>nugunaTeam</span></strong>. All
        Rights Reserved
    </div>
    <div class="credits">
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
</footer><!-- End Footer -->

<a href="#"
   class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>
<!-- jquery  -->

<!-- icon bootstrap -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<!-- Vendor JS Files -->
<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/chart.js/chart.umd.js"></script>
<script src="assets/vendor/echarts/echarts.min.js"></script>
<script src="assets/vendor/quill/quill.js"></script>
<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="assets/vendor/tinymce/tinymce.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>


</body>

</html>