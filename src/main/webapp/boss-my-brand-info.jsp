<%@ page import="com.nuguna.freview.dto.cust.brand.CustMyBrandInfoDto" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.nuguna.freview.dto.boss.brand.BossMyBrandInfoDto" %>
<%@ page import="com.nuguna.freview.entity.member.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    BossMyBrandInfoDto brandInfo = (BossMyBrandInfoDto) request.getAttribute("brandInfo");
    Gson gson = new Gson();
    Member member = null;
    int memberSeq = 0;
    if (session.getAttribute("Member") != null) {
        member = (Member) session.getAttribute("Member");
        memberSeq = member.getMemberSeq();
    }
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
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="/main?seq=<%=memberSeq%>&pagecode=Requester"
           class="logo d-flex align-items-center">
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
                    <span id="store-name-holder-head"
                          class="d-none d-md-block">${brandInfo.storeName}</span>
                </a><!-- End Profile Iamge Icon -->
            </li><!-- End Profile Nav -->
        </ul>
    </nav><!-- End Icons Navigation -->
</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed" href="#">
                <i class="bi bi-grid"></i>
                <span>나의 브랜딩</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/boss-received-request.jsp">
                <i class="bi bi-bell"></i>
                <span>알림</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link " href="${pageContext.request.contextPath}/boss-my-request.jsp">
                <i class="bi bi-card-checklist"></i>
                <span>요청</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="#">
                <i class="bi bi-person"></i>
                <span>개인정보수정</span>
            </a>
        </li><!-- End Register Page Nav -->

    </ul>

</aside><!-- End Sidebar-->

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
                    <h2 id="store-name-holder-section">${brandInfo.storeName}</h2>
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

                            <!-- 스토어명 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">스토어명</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="store-name-input" type="text"
                                           value="<%= brandInfo.getStoreName() %>"
                                           class="form-control" readonly>
                                </div>
                            </div>

                            <!-- 소개 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">소개</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="introduce-input" type="text"
                                           value="<%= brandInfo.getIntroduce() %>"
                                           class="form-control" readonly>
                                </div>
                                <div class="col-lg-1 col-md-2">
                                    <button id="introduce-update-btn" type="button"
                                            class="btn btn-primary edit-btn">수정
                                    </button>
                                    <button id="introduce-submit-btn" type="button"
                                            class="btn btn-success send-btn"
                                            style="display: none;">전송
                                    </button>
                                    <button id="introduce-cancel-btn" type="button"
                                            class="btn btn-secondary cancel-btn"
                                            style="display: none;">취소
                                    </button>
                                </div>
                            </div>

                            <script>
                              $(document).ready(function () {
                                $("#introduce-cancel-btn").click(function () {
                                  $("#introduce-cancel-btn").hide();
                                  $("#introduce-submit-btn").hide();
                                  $("#introduce-update-btn").show();
                                  $('#introduce-input').prop('readonly', false);
                                });

                                $("#introduce-update-btn").click(function () {
                                  $("#introduce-update-btn").hide();
                                  $("#introduce-cancel-btn").show();
                                  $("#introduce-submit-btn").show();
                                  $('#introduce-input').prop('readonly', false);
                                });

                                $("#introduce-submit-btn").click(function () {
                                  var newIntroduce = $('#introduce-input').val();
                                  // Ajax 요청
                                  $.ajax({
                                    url: '<%=request.getContextPath()%>/api/my-brand/introduce',
                                    method: 'POST',
                                    data: JSON.stringify({
                                      'member_seq': <%=memberSeq%>,
                                      'to_introduce': newIntroduce
                                    }),
                                    success: function (response) {
                                      // 성공적으로 응답을 받았을 때 처리
                                      $('#introduce-input').val(response.item).prop('readonly',
                                          true);
                                      $("#introduce-submit-btn").hide();
                                      $("#introduce-cancel-btn").hide();
                                      $("#introduce-update-btn").show();
                                      alert('소개 변경에 성공하였습니다.');
                                    },
                                    error: function (error) {
                                      // 실패 시 처리
                                      console.log(error);
                                      alert('닉네임 변경에 실패하였습니다.');
                                    }
                                  });
                                });
                              });
                            </script>

                            <!-- 활동분야 보여주기/등록하기 -->
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
                                <div class="col-lg-1 col-md-2">
                                    <button id="food-type-update-btn" type="button"
                                            class="btn btn-primary edit-btn">수정
                                    </button>
                                    <button id="food-type-submit-btn" type="button"
                                            class="btn btn-success send-btn" style="display: none;">
                                        전송
                                    </button>
                                    <button id="food-type-cancel-btn" type="button"
                                            class="btn btn-secondary cancel-btn"
                                            style="display: none;">취소
                                    </button>
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

                              document.getElementById('food-type-update-btn').addEventListener(
                                  'click', function () {
                                    document.getElementById(
                                        'food-type-submit-btn').style.display = 'inline-block';
                                    document.getElementById(
                                        'food-type-cancel-btn').style.display = 'inline-block';
                                    document.getElementById(
                                        'food-type-update-btn').style.display = 'none';

                                    $('#food-type-select').prop('disabled', false);

                                    var foodTypeSelect = document.getElementById(
                                        'food-type-select');
                                    for (var i = 0; i < foodTypeSelect.options.length; i++) {
                                      if (foodTypeSelect.options[i].selected) {
                                        foodTypeSelect.options[i].classList.add('selected-option');
                                      } else {
                                        foodTypeSelect.options[i].classList.remove(
                                            'selected-option');
                                      }
                                    }
                                  });

                              document.getElementById('food-type-select').addEventListener('change',
                                  function () {
                                    var foodTypeSelect = document.getElementById(
                                        'food-type-select');
                                    for (var i = 0; i < foodTypeSelect.options.length; i++) {
                                      if (foodTypeSelect.options[i].selected) {
                                        foodTypeSelect.options[i].classList.add('selected-option');
                                      } else {
                                        foodTypeSelect.options[i].classList.remove(
                                            'selected-option');
                                      }
                                    }
                                  });

                              document.getElementById('food-type-cancel-btn').addEventListener(
                                  'click', function () {
                                    document.getElementById(
                                        'food-type-submit-btn').style.display = 'none';
                                    document.getElementById(
                                        'food-type-cancel-btn').style.display = 'none';
                                    document.getElementById(
                                        'food-type-update-btn').style.display = 'inline-block';

                                    var foodTypeSelect = document.getElementById(
                                        'food-type-select');
                                    for (var i = 0; i < foodTypeSelect.options.length; i++) {
                                      if (selectedFoodTypes.includes(
                                          foodTypeSelect.options[i].value)) {
                                        foodTypeSelect.options[i].selected = true;
                                        foodTypeSelect.options[i].classList.add('selected-option');
                                      } else {
                                        foodTypeSelect.options[i].selected = false;
                                        foodTypeSelect.options[i].classList.remove(
                                            'selected-option');
                                      }
                                    }
                                  });

                              $("#food-type-submit-btn").click(function () {
                                var selectedFoodTypes = Array.from(
                                    $("#food-type-select option:selected")).map(
                                    option => option.value);

                                // Ajax 요청
                                $.ajax({
                                  url: '<%=request.getContextPath()%>/api/my-brand/food-type',
                                  method: 'POST',
                                  contentType: 'application/json',
                                  data: JSON.stringify({
                                    'member_seq': <%=memberSeq%>,
                                    'to_food_types': selectedFoodTypes
                                  }),
                                  success: function (response) {
                                    // 서버로부터 받은 음식 유형 목록
                                    var foodTypesFromServer = response.item;

                                    $("#food-type-submit-btn").hide();
                                    $("#food-type-cancel-btn").hide();
                                    $("#food-type-update-btn").show();
                                    $('#food-type-select').prop('disabled', true);

                                    var foodTypeSelect = document.getElementById(
                                        'food-type-select');

                                    // 현재 select 요소에 있는 옵션들 저장
                                    var currentOptions = Array.from(foodTypeSelect.options).map(
                                        option => option.value);

                                    // 새로운 옵션 목록
                                    var newOptions = new Set(
                                        [...currentOptions, ...foodTypesFromServer]);

                                    // select 요소 초기화
                                    foodTypeSelect.innerHTML = '';

                                    // 모든 옵션을 select 요소에 추가
                                    newOptions.forEach(function (foodType) {
                                      var option = document.createElement('option');
                                      option.value = foodType;
                                      option.text = foodType;
                                      if (foodTypesFromServer.includes(foodType)) {
                                        option.selected = true;
                                        option.classList.add('selected-option');
                                      }
                                      foodTypeSelect.appendChild(option);
                                    });
                                    alert('활동 분야 변경에 성공하였습니다.');
                                  },
                                  error: function (error) {
                                    // 실패 시 처리
                                    console.log(error);
                                    alert('활동 분야 변경에 실패하였습니다.');
                                  }
                                });
                              });
                            </script>


                            <!-- 태그들 보여주기/등록하기 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">태그</div>
                                <div class="col-lg-8 col-md-6">
                                    <select id="tag-select" class="form-select" multiple size="4"
                                            disabled>
                                        <option value="단체석">단체석</option>
                                        <option value="뷰 맛집">뷰 맛집</option>
                                        <option value="오션뷰">오션뷰</option>
                                        <option value="반려동물 환영">반려동물 환영</option>
                                    </select>
                                </div>
                                <div class="col-lg-1 col-md-2">
                                    <button id="tag-update-btn" type="button"
                                            class="btn btn-primary edit-btn">수정
                                    </button>
                                    <button id="tag-submit-btn" type="button"
                                            class="btn btn-success send-btn" style="display: none;">
                                        전송
                                    </button>
                                    <button id="tag-cancel-btn" type="button"
                                            class="btn btn-secondary cancel-btn"
                                            style="display: none;">취소
                                    </button>
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
                                  });
                                }

                                initializeTagSelect();

                                $("#tag-update-btn").click(function () {
                                  $("#tag-update-btn").hide();
                                  $("#tag-cancel-btn").show();
                                  $("#tag-submit-btn").show();
                                  $('#tag-select').prop('disabled', false);
                                });

                                $('#tag-cancel-btn').click(function () {
                                  $('#tag-cancel-btn').hide();
                                  $('#tag-submit-btn').hide();
                                  $('#tag-update-btn').show();
                                  $('#tag-select').prop('disabled', true);
                                  initializeTagSelect();
                                });

                                $('#tag-submit-btn').click(function () {
                                  var selectedTags = [];
                                  $('#tag-select option:selected').each(function () {
                                    selectedTags.push($(this).val());
                                  });

                                  $.ajax({

                                    url: '<%=request.getContextPath()%>/api/my-brand/tag',
                                    method: 'POST',
                                    data: JSON.stringify({
                                      'member_seq': <%=memberSeq%>,
                                      'to_tags': selectedTags
                                    }),
                                    success: function (response) {
                                      console.log(response.item);
                                      alert('성공적으로 수정되었습니다.');
                                      $('#tag-select').prop('disabled', true);
                                      $('#tag-submit-btn').hide();
                                      $('#tag-cancel-btn').hide();
                                      $('#tag-update-btn').show();
                                    },
                                    error: function (error) {
                                      alert('태그 변경에 실패하였습니다.');
                                    }
                                  });
                                });

                                $('#tag-select').on('change', function () {
                                  $('#tag-select option').each(function () {
                                    if ($(this).is(':selected')) {
                                      $(this).addClass('selected-option');
                                    } else {
                                      $(this).removeClass('selected-option');
                                    }
                                  });
                                });
                              });
                            </script>

                            <%--<!-- 리뷰로그들 보여주기/ URL 등록하기 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">리뷰 로그</div>
                                <div class="col-lg-8 col-md-6">
                                    <input type="text" name="to_review_url"
                                           value="${brandInfo.reviewInfos}"
                                           class="form-control" readonly>
                                </div>
                                <div class="col-lg-1 col-md-2">
                                    <button type="button" class="btn btn-primary edit-btn">수정
                                    </button>
                                    <button type="button" class="btn btn-success send-btn"
                                            style="display: none;">전송
                                    </button>
                                    <button type="button" class="btn btn-secondary cancel-btn"
                                            style="display: none;">취소
                                    </button>
                                </div>
                            </div>
                            <div class="tab-pane fade profile-edit pt-3" id="profile-edit">
                            </div>
                        </div>
                    </div>--%>
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>JjangMutjinTeam</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>
<!-- jquery  -->

<!-- icon bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
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