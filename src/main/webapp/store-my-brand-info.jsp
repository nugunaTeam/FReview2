<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

      #review-log-table {
        border-collapse: collapse;
      }

      #review-log-table th,
      #review-log-table td {
        border: 2px solid #dee2e6; /* 선 두께를 2px로 설정 */
        text-align: center;
        vertical-align: middle;
      }

      #review-log-table th {
        font-weight: bold;
      }

      #page-buttons .btn {
        margin: 0 2px;
      }

      .d-flex.justify-content-center {
        gap: 0.5rem;
      }

      .clickable {
        cursor: pointer;
      }

    </style>

    <%-- <link rel="stylesheet"
           href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">--%>
    <style>
      .alert-custom {
        background-color: transparent;
        color: orange;
        border: none;
        text-align: right;
        font-size: 1rem;
      }

      .pagination-container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 20px;
      }

      .table-container {
        position: relative;
      }

      .alert-custom-bottom {
        position: absolute;
        bottom: -30px;
        right: 0;
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

      .profile-container {
        width: 150px; /* 원하는 고정 가로 길이 */
        height: 150px; /* 원하는 고정 세로 길이 */
        position: relative;
        overflow: hidden;
        border-radius: 50%; /* 원형으로 만들기 위한 설정 */
      }

      .profile-container img {
        width: 100%;
        height: 100%;
        object-fit: cover; /* 이미지의 중앙을 맞추고, 자르기 */
        object-position: center; /* 중앙 위치 */
      }

    </style>

    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>FReview</title>
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

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css"
          rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</head>

<body>

<!-- ======= Header ======= -->
<jsp:include page="/header.jsp" />

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item">
            <a class="nav-link "
               href="/store/brand-info?userSeq=${brandInfo.storeSeq}">
                <i class="bi bi-grid"></i>
                <span>브랜딩</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/experience?userSeq=${brandInfo.storeSeq}">
                <i class="bi bi-card-checklist"></i>
                <span>체험</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed "
               href="${pageContext.request.contextPath}/store/activity?userSeq=${brandInfo.storeSeq}">
                <i class="bi bi-bell"></i>
                <span>활동</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/notification?userSeq=${brandInfo.storeSeq}">
                <i class="bi bi-card-checklist"></i>
                <span>알림</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/personal-info?userSeq=${brandInfo.storeSeq}">
                <i class="bi bi-person"></i>
                <span>개인정보수정</span>
            </a>
        </li><!-- End Register Page Nav -->
    </ul>
</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>스토어 브랜딩</h1>
    </div><!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="card">
                <!-- profile  -->
                <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                    <img id="profile-img"
                         src="/user/${brandInfo.storeSeq}/profile"
                         alt="Profile"
                         class="rounded-circle clickable img-fluid profile-img"
                         style="position: relative;
                         overflow: hidden; border-radius: 50%;"
                         onerror="this.onerror=null;this.src='/assets/img/basic/store-basic-profile.png';">
                    <input type="file" id="profile-img-upload" style="display: none;">
                    <h2 id="nickname-holder-section">${brandInfo.storeName}
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
                                <div class="col-lg-3 col-md-4 label" style="color:blue">소개</div>
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

                            <!-- 스토어명 보여주기/등록하기 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color:blue">스토어명</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="nickname-input" type="text" name="to_nickname"
                                           value="${brandInfo.storeName}"
                                           class="form-control" readonly>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color:blue">위치</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="location-holder" type="text" name="location"
                                           value="${brandInfo.storeLocation}"
                                           class="form-control" readonly>
                                </div>
                            </div>
                <script>
                  $(document).ready(function () {
                    $('#profile-img').click(function () {
                      $('#profile-img-upload').click(); // 파일 선택 창 열기
                    });

                    $('#profile-img-upload').change(function () {
                      var formData = new FormData();
                      formData.append('userSeq', ${brandInfo.storeSeq});
                      formData.append('profileFile', this.files[0]);

                      $.ajax({
                        url: '${pageContext.request.contextPath}/api/store/my/brand-info/profile-photo-url',
                        method: 'POST',
                        data: formData,
                        contentType: false, // 필수
                        processData: false, // 필수
                        success: function (response) {
                          var newImageUrl = "/user/${brandInfo.storeSeq}/profile?" + new Date().getTime();
                          $('.profile-img').attr('src', newImageUrl);
                          alert('프로필 사진이 업데이트 되었습니다.');
                        },
                        error: function (error) {
                          console.log(error);
                          alert('프로필 사진 업데이트에 실패하였습니다.');
                        }
                      });
                    });
                  });
                </script>

                            <script>
                              $(document).ready(function () {
                                function initializeIntroduceForm() {
                                  $('#introduce-input').val('${brandInfo.introduce}').prop(
                                      'readonly',
                                      true);
                                  $('#introduce-update-btn').show();
                                  $('#introduce-submit-btn').hide();
                                  $('#introduce-cancel-btn').hide();
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
                                    url: '<%=request.getContextPath()%>/api/store/my/brand-info/introduce',
                                    method: 'PUT',
                                    data: JSON.stringify({
                                      'userSeq': ${brandInfo.storeSeq},
                                      'toIntroduce': newIntroduce
                                    }),
                                    contentType: 'application/json',
                                    success: function (response) {
                                      $('#introduce-input').val(response.introduce).prop('readonly',
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
                              });
                            </script>

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color:blue">활동 분야</div>
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
                                // Initialize the selectedFoodTypes array using EL
                                var selectedFoodTypes = [
                                  <c:forEach var="foodType" items="${brandInfo.foodTypes}">
                                  "${foodType}"
                                  <c:if test="${!foodType.equals(foodTypes[foodTypes.size() - 1])}">,
                                  </c:if>
                                  </c:forEach>
                                ];

                                // Store the initial selected food types
                                var initialSelectedFoodTypes = selectedFoodTypes.slice();

                                // Initialize select2 with custom colors
                                $('#food-type-select').select2({
                                  width: '100%',
                                  templateSelection: function (option) {
                                    var color = $(option.element).data('custom-color');
                                    return $('<span style="color: ' + color + '">' + option.text
                                        + '</span>');
                                  }
                                });

                                // Function to initialize the select2 with selected values
                                function initializeFoodTypeSelect() {
                                  var foodTypeSelect = $('#food-type-select');
                                  // Set the selected values
                                  foodTypeSelect.val(selectedFoodTypes).trigger('change');
                                  updateFoodTypeMessage();
                                }

                                // Function to update the message based on selected options
                                function updateFoodTypeMessage() {
                                  var selectedOptions = $('#food-type-select').val();
                                  var messageElement = $('#food-type-select-message');

                                  if (selectedOptions === null || selectedOptions.length === 0) {
                                    messageElement.text('아직 선택한 활동 분야가 없어요.');
                                  } else {
                                    messageElement.text('');
                                  }
                                }

                                // Initialize the select2 with selected values on page load
                                initializeFoodTypeSelect();

                                // Handle select2 option selection
                                $('#food-type-select').on('select2:select', function (e) {
                                  var selectedOptions = $(this).val();
                                  if (selectedOptions.length > 5) {
                                    var $element = $(e.params.data.element);
                                    $element.prop('selected', false);
                                    $(this).trigger('change');
                                    alert('활동 분야는 최대 5개까지만 선택할 수 있습니다.');
                                  } else {
                                    selectedFoodTypes = selectedOptions;
                                    updateFoodTypeMessage();
                                  }
                                });

                                // Handle the update button click
                                $("#food-type-update-btn").click(function () {
                                  $("#food-type-update-btn").hide();
                                  $("#food-type-cancel-btn").show();
                                  $("#food-type-submit-btn").show();
                                  $('#food-type-select').prop('disabled', false);
                                });

                                // Handle the cancel button click
                                $('#food-type-cancel-btn').click(function () {
                                  $('#food-type-cancel-btn').hide();
                                  $('#food-type-submit-btn').hide();
                                  $('#food-type-update-btn').show();
                                  $('#food-type-select').prop('disabled', true);
                                  // Restore initial selected values
                                  selectedFoodTypes = initialSelectedFoodTypes.slice();
                                  initializeFoodTypeSelect();
                                });

                                // Handle select2 option changes
                                $('#food-type-select').on('change', function () {
                                  $(this).find('option:selected').addClass('selected-option');
                                  $(this).find('option:not(:selected)').removeClass(
                                      'selected-option');
                                  updateFoodTypeMessage();
                                });

                                // Handle the submit button click
                                $("#food-type-submit-btn").click(function () {
                                  var selectedFoodTypes = $('#food-type-select').val();

                                  $.ajax({
                                    url: '${pageContext.request.contextPath}/api/store/my/brand-info/food-types',
                                    method: 'PUT',
                                    contentType: 'application/json',
                                    data: JSON.stringify({
                                      'userSeq': ${brandInfo.storeSeq},
                                      'toFoodTypes': selectedFoodTypes
                                    }),
                                    success: function (response) {
                                      alert('활동 분야 변경에 성공하였습니다.');
                                      initialSelectedFoodTypes = selectedFoodTypes.slice();
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
                                <div class="col-lg-3 col-md-4 label" style="color:blue">태그</div>
                                <div class="col-lg-8 col-md-6">
                                    <select id="tag-select" class="form-select" multiple size="2"
                                            disabled>
                                        <option value="뷰 맛집" data-custom-color="mediumvioletred'">뷰 맛집</option>
                                        <option value="오션뷰" data-custom-color="deepskyblue">오션뷰</option>
                                        <option value="반려동물 환영" data-custom-color="green">반려동물 환영</option>
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
                                // Initialize the selectedTags array using EL
                                var selectedTags = [
                                  <c:forEach var="tag" items="${brandInfo.tagInfos}">
                                  "${tag}"
                                  <c:if test="${!tag.equals(tagInfos[tagInfos.size() - 1])}">,
                                  </c:if>
                                  </c:forEach>
                                ];

                                // Store the initial selected tags
                                var initialSelectedTags = selectedTags.slice();

                                // Initialize select2 with custom colors for tags
                                $('#tag-select').select2({
                                  width: '100%',
                                  templateSelection: function (option) {
                                    var color = $(option.element).data('custom-color');
                                    return $('<span style="color: ' + color + '">' + option.text
                                        + '</span>');
                                  }
                                });

                                // Function to initialize the select2 with selected values
                                function initializeTagSelect() {
                                  var tagSelect = $('#tag-select');
                                  tagSelect.val(selectedTags).trigger('change');
                                  updateTagMessage();
                                }

                                // Function to update the message based on selected options
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

                                // Handle select2 option selection for tags
                                $('#tag-select').on('select2:select', function (e) {
                                  var selectedOptions = $(this).val();
                                  if (selectedOptions.length > 2) {
                                    var $element = $(e.params.data.element);
                                    $element.prop('selected', false);
                                    $(this).trigger('change');
                                    alert('태그는 2개까지만 선택할 수 있습니다.');
                                  } else {
                                    selectedTags = selectedOptions;
                                    updateTagMessage();
                                  }
                                });

                                // Handle the update button click for tags
                                $("#tag-update-btn").click(function () {
                                  $(this).hide();
                                  $("#tag-cancel-btn, #tag-submit-btn").show();
                                  $('#tag-select').prop('disabled', false);
                                });

                                // Handle the cancel button click for tags
                                $('#tag-cancel-btn').click(function () {
                                  $(this).hide();
                                  $("#tag-submit-btn").hide();
                                  $("#tag-update-btn").show();
                                  $('#tag-select').prop('disabled', true);
                                  selectedTags = initialSelectedTags.slice();
                                  initializeTagSelect();
                                });

                                // Handle select2 option changes for tags
                                $('#tag-select').on('change', function () {
                                  $(this).find('option:selected').addClass('selected-option');
                                  $(this).find('option:not(:selected)').removeClass(
                                      'selected-option');
                                  updateTagMessage();
                                });

                                // Handle the submit button click for tags
                                $('#tag-submit-btn').click(function () {
                                  var selectedTags = $('#tag-select').val();

                                  $.ajax({
                                    url: '${pageContext.request.contextPath}/api/store/my/brand-info/tags',
                                    method: 'PUT',
                                    contentType: 'application/json',
                                    data: JSON.stringify({
                                      'userSeq': ${brandInfo.storeSeq},
                                      'toTags': selectedTags
                                    }),
                                    success: function (response) {
                                      alert('태그 변경에 성공하였습니다.');
                                      initialSelectedTags = selectedTags.slice();
                                      $('#tag-select').prop('disabled', true);
                                      $('#tag-submit-btn, #tag-cancel-btn').hide();
                                      $('#tag-update-btn').show();
                                      updateTagMessage();
                                    },
                                    error: function (err) {
                                      alert('태그 변경에 실패하였습니다.');
                                    }
                                  });
                                });
                              });
                            </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>


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
<jsp:include page="/footer.jsp" />
</html>