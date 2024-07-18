<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    Gson gson = new Gson();
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <style>
      .selected-option {
        background-color: lightgreen; /* 연초록색으로 선택된 옵션 표시 */
      }

      #food-type-select-message {
        margin-bottom: 5px;
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
    <link href="/assets/css/style-h.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- icon bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!--Select2 Css, JS -->
    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css"
          rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>


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
        <a href="${pageContext.request.contextPath}/main?seq=${userSeq}&pagecode=Requester"
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
                          class="d-none d-md-block">${brandInfo.nickname}<%--<%=brandInfo.getNickname()%>--%></span>
                </a><!-- End Profile Iamge Icon -->
            </li><!-- End Profile Nav -->
        </ul>
    </nav><!-- End Icons Navigation -->
</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item">
            <a class="nav-link" data-bs-target="#components-nav"
               href="#">
                <i class="bi bi-person-lines-fill"></i><span>브랜딩</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/my-activity">
                <i class="bi bi-layout-text-window-reverse"></i>
                <span>활동</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/my-notification">
                <i class="bi bi-envelope"></i>
                <span>알림</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/my-personal-info">
                <i class="ri-edit-box-line"></i>
                <span>개인정보수정</span>
            </a>
        </li>
    </ul>
</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>나의 브랜딩</h1>
    </div><!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="card">
                <!-- profile  -->
                <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                    <img src="/assets/img/basic/basic-profile-img.png" alt="Profile"
                         class="rounded-circle">
                    <h2 id="nickname-holder-section">${brandInfo.nickname}
                    </h2>
                    <div class="social-links mt-2 ri-heart-3-fill">
                        ${brandInfo.zzimCount}
                    </div>
                </div>

                <div class="card-body pt-3">
                    <!-- Bordered Tabs -->
                    <div class="tab-content pt-2">

                        <div class="tab-pane fade show active profile-overview"
                             id="profile-overview">

                            <!-- 소개 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">소개</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="introduce-input" type="text" name="to_nickname"
                                           value="${brandInfo.introduce}"
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

                            <!-- 닉네임 보여주기/등록하기 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">닉네임</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="nickname-input" type="text" name="to_nickname"
                                           value="${brandInfo.nickname}"
                                           class="form-control" readonly>
                                </div>
                                <div class="col-lg-1 col-md-2">
                                    <button type="button" class="btn btn-primary edit-btn"
                                            id="nickname-update-btn">수정
                                    </button>
                                    <button type="button" class="btn btn-success send-btn"
                                            style="display: none;" id="nickname-submit-btn">전송
                                    </button>
                                    <button type="button" class="btn btn-secondary cancel-btn"
                                            style="display: none;" id="nickname-cancel-btn">취소
                                    </button>
                                </div>
                            </div>

                            <script>
                              $(document).ready(function () {
                                function initializeIntroduceForm() {
                                  $('#introduce-input').val(${brandInfo.introduce}).prop('readonly',
                                      true);
                                  $('#introduce-update-btn').show();
                                  $('#introduce-submit-btn').hide();
                                  $('#introduce-cancel-btn').hide();
                                }

                                function initializeNicknameForm() {
                                  $('#nickname-input').val('${brandInfo.nickname}').prop(
                                      'readonly', true);
                                  $('#nickname-update-btn').show();
                                  $('#nickname-submit-btn').hide();
                                  $('#nickname-cancel-btn').hide();
                                }

                                $("#introduce-cancel-btn").click(function () {
                                  initializeIntroduceForm();
                                });

                                $("#introduce-update-btn").click(function () {
                                  $("#introduce-update-btn").hide();
                                  $("#introduce-cancel-btn").show();
                                  $("#introduce-submit-btn").show();
                                  $('#introduce-input').prop('readonly', false);
                                });

                                $("#introduce-submit-btn").click(function () {
                                  var newIntroduce = $('#introduce-input').val();
                                  $.ajax({
                                    url: '<%=request.getContextPath()%>/api/my-brand/introduce',
                                    method: 'POST',
                                    data: JSON.stringify({
                                      'user_seq': ${userSeq},
                                      'to_introduce': newIntroduce
                                    }),
                                    contentType: 'application/json',
                                    success: function (response) {
                                      $('#introduce-input').val(response.item).prop('readonly',
                                          true);
                                      $("#introduce-submit-btn").hide();
                                      $("#introduce-cancel-btn").hide();
                                      $("#introduce-update-btn").show();
                                      alert('소개글 변경에 성공했습니다.');
                                    },
                                    error: function (error) {
                                      console.log(error);
                                      alert('소개글 변경에 실패하였습니다.');
                                    }
                                  });
                                });

                                $("#nickname-cancel-btn").click(function () {
                                  initializeNicknameForm();
                                });

                                $("#nickname-update-btn").click(function () {
                                  $("#nickname-update-btn").hide();
                                  $("#nickname-cancel-btn").show();
                                  $("#nickname-submit-btn").show();
                                  $('#nickname-input').prop('readonly', false);
                                });

                                $("#nickname-submit-btn").click(function () {
                                  var newNickname = $('#nickname-input').val();
                                  $.ajax({
                                    url: '<%=request.getContextPath()%>/api/my-brand/nickname',
                                    method: 'POST',
                                    data: JSON.stringify({
                                      'userSeq': ${userSeq},
                                      'toNickname': newNickname
                                    }),
                                    contentType: 'application/json',
                                    success: function (response) {
                                      $('#nickname-input').val(response.item).prop('readonly',
                                          true);
                                      $("#nickname-holder-head").text(response.item);
                                      $("#nickname-holder-section").text(response.item);
                                      $("#nickname-submit-btn").hide();
                                      $("#nickname-cancel-btn").hide();
                                      $("#nickname-update-btn").show();
                                      alert('닉네임 변경에 성공하였습니다.');
                                    },
                                    error: function (error) {
                                      console.log(error);
                                      alert('닉네임 변경에 실패하였습니다.');
                                    }
                                  });
                                });
                              });
                            </script>

                            <!-- 연령대 보여주기/등록하기 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4">연령대</div>
                                <div class="col-lg-8 col-md-6">
                                    <select id="age-group-input"
                                            class="form-control form-control-readonly" disabled>
                                        <!-- col-lg-8 col-md-6 -->
                                    </select>
                                </div>

                                <script>
                                  $(document).ready(function () {
                                    var ageGroups = ["10대", "20대", "30대", "40대", "50대", "60대",
                                      "70대", "80대", "90대"];
                                    var selectedAgeGroup = '${brandInfo.ageGroup}'; // JSP 변수를 JavaScript로 가져오기

                                    $.each(ageGroups, function (index, ageGroup) {
                                      var option = $('<option>', {
                                        value: ageGroup,
                                        text: ageGroup
                                      });
                                      if (ageGroup === selectedAgeGroup) {
                                        option.prop('selected', true);
                                      }
                                      $('#age-group-input').append(option);
                                    });
                                  });
                                </script>

                                <script>
                                  $(document).ready(function () {
                                    $("#age-group-cancel-btn").click(function () {
                                      $("#age-group-cancel-btn").hide();
                                      $("#age-group-submit-btn").hide();
                                      $("#age-group-update-btn").show();
                                      $('#age-group-input').prop('disabled', true);
                                    });

                                    $("#age-group-update-btn").click(function () {
                                      $("#age-group-update-btn").hide();
                                      $("#age-group-cancel-btn").show();
                                      $("#age-group-submit-btn").show();
                                      $('#age-group-input').prop('disabled', false);
                                    });

                                    $("#age-group-submit-btn").click(function () {
                                      var newAgeGroup = $('#age-group-input').val();
                                      // Ajax 요청
                                      $.ajax({
                                        url: '<%=request.getContextPath()%>/api/customer/my-brand/age-group',
                                        method: 'POST',
                                        data: JSON.stringify({
                                          'usersSeq': ${userSeq},
                                          'toAgeGroup': newAgeGroup
                                        }),
                                        success: function (response) {
                                          // 성공적으로 응답을 받았을 때 처리
                                          $('#age-group-input').val(response.item).prop('disabled',
                                              true);
                                          $("#age-group-submit-btn").hide();
                                          $("#age-group-cancel-btn").hide();
                                          $("#age-group-update-btn").show();
                                          alert('연령대 변경 변경에 성공하였습니다.');
                                        },
                                        error: function (error) {
                                          // 실패 시 처리
                                          console.log(error);
                                          alert('연령대 변경에 실패하였습니다.');
                                        }
                                      });
                                    });
                                  });
                                </script>

                                <div class="col-lg-1 col-md-2">
                                    <button id="age-group-update-btn" type="button"
                                            class="btn btn-primary edit-btn">수정
                                    </button>
                                    <button id="age-group-submit-btn"
                                            type="button" class="btn btn-success send-btn"
                                            style="display: none;">전송
                                    </button>
                                    <button id="age-group-cancel-btn"
                                            type="button" class="btn btn-secondary cancel-btn"
                                            style="display: none;">취소
                                    </button>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">활동 분야</div>
                                <div class="col-lg-8 col-md-6">
                                    <select id="food-type-select" class="form-select" multiple
                                            size="5" disabled>
                                        <option value="국밥" data-custom-color="orange">국밥</option>
                                        <option value="돈까스" data-custom-color="orange">돈까스</option>
                                        <option value="족발" data-custom-color="orange">족발</option>
                                        <option value="막창" data-custom-color="orange">막창</option>
                                        <option value="피자" data-custom-color="mediumvioletred">피자
                                        </option>
                                        <option value="파스타" data-custom-color="mediumvioletred">
                                            파스타
                                        </option>
                                        <option value="햄버거" data-custom-color="mediumvioletred">
                                            햄버거
                                        </option>
                                        <option value="스테이크" data-custom-color="mediumvioletred">
                                            스테이크
                                        </option>
                                        <option value="마라탕" data-custom-color="saddlebrown">마라탕
                                        </option>
                                        <option value="짜장면" data-custom-color="saddlebrown">짜장면
                                        </option>
                                        <option value="짬뽕" data-custom-color="saddlebrown">짬뽕
                                        </option>
                                        <option value="탕수육" data-custom-color="saddlebrown">탕수육
                                        </option>
                                        <option value="텐동" data-custom-color="olivedrab">텐동</option>
                                        <option value="초밥" data-custom-color="olivedrab">초밥</option>
                                        <option value="규동" data-custom-color="olivedrab">규동</option>
                                        <option value="라멘" data-custom-color="olivedrab">라멘</option>
                                        <option value="빵" data-custom-color="sienna">빵</option>
                                        <option value="케이크" data-custom-color="sienna">케이크</option>
                                        <option value="쿠키" data-custom-color="sienna">쿠키</option>
                                        <option value="샌드위치" data-custom-color="sienna">샌드위치
                                        </option>
                                        <option value="커피" data-custom-color="sienna">커피</option>
                                        <option value="커리" data-custom-color="green">커리</option>
                                        <option value="쌀국수" data-custom-color="green">쌀국수</option>
                                        <option value="기타" data-custom-color="green">기타</option>
                                    </select>
                                    <p id="food-type-select-message" class="text-primary"
                                       style="font-size: 14px;"></p>
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
                              $(document).ready(function () {
                                $('#food-type-select').select2({
                                  width: '100%',
                                  templateSelection: function (option) {
                                    var color = $(option.element).data('custom-color');
                                    return $('<span style="color: ' + color + '">' + option.text
                                        + '</span>');
                                  }
                                });

                                var selectedFoodTypes = ${brandInfo.foodTypes};

                                function initializeFoodTypeSelect() {
                                  var foodTypeSelect = $('#food-type-select');
                                  foodTypeSelect.val(selectedFoodTypes).trigger('change');

                                  updateFoodTypeMessage();
                                }

                                function updateFoodTypeMessage() {
                                  var selectedOptions = $('#food-type-select').val();
                                  var messageElement = $('#food-type-select-message');

                                  if (selectedOptions === null || selectedOptions.length === 0) {
                                    messageElement.text('아직 선택한 활동 분야가 없어요.');
                                  } else {
                                    messageElement.text('');
                                  }
                                }

                                initializeFoodTypeSelect();

                                $('#food-type-select').on('select2:select', function (e) {
                                  var selectedOptions = $(this).val();
                                  if (selectedOptions.length > 5) {
                                    var $element = $(e.params.data.element);
                                    $element.prop('selected', false);
                                    $(this).trigger('change');
                                    alert('활동 분야는 최대 5개까지만 선택할 수 있습니다.');
                                  } else {
                                    updateFoodTypeMessage();
                                  }
                                });

                                $("#food-type-update-btn").click(function () {
                                  $("#food-type-update-btn").hide();
                                  $("#food-type-cancel-btn").show();
                                  $("#food-type-submit-btn").show();
                                  $('#food-type-select').prop('disabled', false);
                                });

                                $('#food-type-cancel-btn').click(function () {
                                  $('#food-type-cancel-btn').hide();
                                  $('#food-type-submit-btn').hide();
                                  $('#food-type-update-btn').show();
                                  $('#food-type-select').prop('disabled', true);
                                  initializeFoodTypeSelect();
                                });

                                $('#food-type-select').on('change', function () {
                                  $(this).find('option:selected').addClass('selected-option');
                                  $(this).find('option:not(:selected)').removeClass(
                                      'selected-option');
                                  updateFoodTypeMessage();
                                });

                                $("#food-type-submit-btn").click(function () {
                                  var selectedFoodTypes = $('#food-type-select').val();

                                  $.ajax({
                                    url: '<%=request.getContextPath()%>/api/my-brand/food-type',
                                    method: 'POST',
                                    contentType: 'application/json',
                                    data: JSON.stringify({
                                      'userSeq': ${userSeq},
                                      'toFoodTypes': selectedFoodTypes
                                    }),
                                    success: function (response) {
                                      alert('활동 분야 변경에 성공하였습니다.');
                                      $('#food-type-select').prop('disabled', true).select2({
                                        width: '100%',
                                        templateSelection: function (option) {
                                          var color = $(option.element).data('custom-color');
                                          return $(
                                              '<span style="color: ' + color + '">' + option.text
                                              + '</span>');
                                        }
                                      });
                                      $('#food-type-submit-btn, #food-type-cancel-btn').hide();
                                      $('#food-type-update-btn').show();
                                    },
                                    error: function (err) {
                                      alert('활동 분야 변경에 실패하였습니다.');
                                    }
                                  });
                                });
                              });
                            </script>

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">태그</div>
                                <div class="col-lg-8 col-md-6">
                                    <select id="tag-select" class="form-select" multiple size="2"
                                            disabled>
                                        <option value="초식" data-custom-color="green">초식</option>
                                        <option value="육식" data-custom-color="indianred">육식</option>
                                        <option value="맛집블로거" data-custom-color="blue">맛집블로거
                                        </option>
                                        <option value="정성리뷰어" data-custom-color="orange">정성리뷰어
                                        </option>
                                    </select>
                                    <p id="tag-select-message" class="text-primary"
                                       style="font-size: 14px;"></p>
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
                                $('#tag-select').select2({
                                  width: '100%',
                                  templateSelection: function (option) {
                                    var color = $(option.element).data('custom-color');
                                    return $('<span style="color: ' + color + '">' + option.text
                                        + '</span>');
                                  }
                                });

                                var selectedTags = ${brandInfo.tagInfos};

                                function initializeTagSelect() {
                                  var tagSelect = $('#tag-select');
                                  tagSelect.val(selectedTags).trigger('change');
                                  updateTagMessage();
                                }

                                function updateTagMessage() {
                                  var selectedOptions = $('#tag-select').val();
                                  var messageElement = $('#tag-select-message');

                                  if (selectedOptions === null || selectedOptions.length === 0) {
                                    messageElement.text('아직 선택한 태그가 없어요.');
                                  } else {
                                    messageElement.text('');
                                  }
                                }

                                initializeTagSelect();

                                $('#tag-select').on('select2:select',
                                    function (e) {
                                      var selectedOptions = $(this).val();
                                      if (selectedOptions.length > 2) {
                                        var $element = $(e.params.data.element);
                                        $element.prop("selected", false);
                                        $(this).trigger('change');
                                        alert('태그는 2개까지만 선택할 수 있습니다');
                                      } else {
                                        updateTagMessage();
                                      }
                                    });

                                $('#tag-select').on('change', function () {
                                  $(this).find('option:selected').addClass('selected-option');
                                  $(this).find('option:not(:selected)').removeClass(
                                      'selected-option');
                                  updateTagMessage();
                                });

                                $("#tag-update-btn").click(function () {
                                  $(this).hide();
                                  $("#tag-cancel-btn, #tag-submit-btn").show();
                                  $('#tag-select').prop('disabled', false).select2({
                                    width: '100%',
                                    templateSelection: function (option) {
                                      var color = $(option.element).data('custom-color');
                                      return $('<span style="color: ' + color + '">' + option.text
                                          + '</span>');
                                    }
                                  });
                                });

                                $('#tag-cancel-btn').click(function () {
                                  $(this).hide();
                                  $("#tag-submit-btn").hide();
                                  $("#tag-update-btn").show();
                                  $('#tag-select').prop('disabled', true).select2({
                                    width: '100%',
                                    templateSelection: function (option) {
                                      var color = $(option.element).data('custom-color');
                                      return $('<span style="color: ' + color + '">' + option.text
                                          + '</span>');
                                    }
                                  });
                                  initializeTagSelect();
                                });

                                $('#tag-submit-btn').click(function () {
                                  var selectedTags = $('#tag-select').val();

                                  $.ajax({
                                    url: '<%=request.getContextPath()%>/api/my-brand/tag',
                                    method: 'POST',
                                    contentType: 'application/json',
                                    data: JSON.stringify({
                                      'userSeq': ${userSeq},
                                      'toTags': selectedTags
                                    }),
                                    success: function (response) {
                                      alert('태그 변경에 성공하였습니다.');
                                      $('#tag-select').prop('disabled', true).select2({
                                        width: '100%',
                                        templateSelection: function (option) {
                                          var color = $(option.element).data('custom-color');
                                          return $(
                                              '<span style="color: ' + color + '">' + option.text
                                              + '</span>');
                                        }
                                      });
                                      $('#tag-submit-btn, #tag-cancel-btn').hide();
                                      $('#tag-update-btn').show();
                                      updateTagMessage();
                                    },
                                    error: function (err) {
                                      alert('태그 변경에 실패하였습니다.');
                                    }
                                  });
                                });

                                initializeTagSelect();
                              });
                            </script>
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>nugunaTeam</span></strong>. All Rights Reserved
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