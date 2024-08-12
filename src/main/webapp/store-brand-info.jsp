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
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="/main"
           class="logo d-flex align-items-center">
            <img src="/assets/img/logo/logo-vertical.png" alt="">
            <span class="d-none d-lg-block">FReview</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div>

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
            <li class="nav-item dropdown pe-3">
                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#">
                    <img src="/user/${fromUserSeq}/profile"
                         alt="Profile"
                         class="rounded-circle profile-img"
                         style="margin-right: 5px;"
                         onerror="
                                 this.onerror = null;
                                 this.src = ${isFromUserStore}
                                 ? '/assets/img/basic/store-basic-profile.png'
                                 : '/assets/img/basic/customer-basic-profile.png';"
                    >
                    <span id="nickname-holder-head"
                          class="d-none d-md-block"
                          style="font-size : 18px;">${userNickname}</span>
                </a>
            </li>
        </ul>
    </nav>
</header>

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
                         src="/user/${otherBrandInfo.storeSeq}/profile"
                         alt="Profile"
                         class="rounded-circle clickable img-fluid profile-img"
                         style="position: relative;
                         overflow: hidden; border-radius: 50%;"
                         onerror="
                                 this.onerror = null;
                                 this.src = ${isFromUserStore}
                                 ? '/assets/img/basic/store-basic-profile.png'
                                 : '/assets/img/basic/customer-basic-profile.png';">
                    <input type="file" id="profile-img-upload" style="display: none;">
                    <h2 id="nickname-holder-section">${otherBrandInfo.storeName}
                    </h2>
                    <div class="social-links mt-2"
                         style="display: flex; align-items: center; justify-content: center;">
                        <!-- 찜 버튼 -->
                        <button id="zzimButton"
                                style="background-color: #ffe6e6; border: none; font-size: 1.5rem; cursor: pointer; padding: 0.5rem 1rem; border-radius: 5px; display: flex; align-items: center; outline: none; height: 40px;">
                            <i id="heartIcon" class="ri-heart-3-fill"
                               style="margin-right: 0.7rem; color: pink;"></i>
                            <span id="zzimCount" style="font-size: 1rem; color: #333;">
                                ${otherBrandInfo.zzimCount}
                            </span>
                        </button>
                    </div>
                </div>

                <script>
                  $(document).ready(function () {
                    var zzimed = ${zzimed};
                    if (zzimed) {
                      $('#heartIcon').css('color', 'red');
                    } else {
                      $('#heartIcon').css('color', 'white');
                    }

                    $('#zzimButton').on('click', function () {
                      const userSeq = ${userSeq};

                      const data = {
                        toUserSeq: userSeq
                      };

                      $.ajax({
                        url: '/api/other/zzim',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: function (response) {
                          if (response.zzimed) {
                            alert("해당 스토어를 찜했습니다.");
                            $('#heartIcon').css('color', 'red'); // 찜 활성화
                          } else {
                            alert("해당 스토어를 찜 취소했습니다.");
                            $('#heartIcon').css('color', 'white'); // 찜 비활성화
                          }
                          $('#zzimCount').text(response.zzimCount);
                        },
                        error: function (error) {
                          console.error('Error:', error);
                        }
                      });
                    });
                  });
                </script>

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
                                           value="${otherBrandInfo.introduce}"
                                           class="form-control" readonly>
                                </div>
                            </div>

                            <!-- 스토어명 보여주기/등록하기 -->
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color:blue">스토어명</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="nickname-input" type="text" name="to_nickname"
                                           value="${otherBrandInfo.storeName}"
                                           class="form-control" readonly>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color:blue">위치</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="location-holder" type="text" name="location"
                                           value="${otherBrandInfo.storeLocation}"
                                           class="form-control" readonly>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color : blue">활동 분야</div>
                                <div class="col-lg-8 col-md-6">
                                    <div id="food-type-buttons">
                                    </div>
                                    <p id="food-type-buttons-message" class="text-primary"
                                       style="font-size: 18px;"></p>
                                </div>
                            </div>

                            <script>
                              $(document).ready(function () {
                                const foodTypes = [
                                  {value: "국밥", color: "orange"},
                                  {value: "돈까스", color: "orange"},
                                  {value: "족발", color: "orange"},
                                  {value: "막창", color: "orange"},
                                  {value: "피자", color: "mediumvioletred"},
                                  {value: "파스타", color: "mediumvioletred"},
                                  {value: "햄버거", color: "mediumvioletred"},
                                  {value: "스테이크", color: "mediumvioletred"},
                                  {value: "마라탕", color: "saddlebrown"},
                                  {value: "짜장면", color: "saddlebrown"},
                                  {value: "짬뽕", color: "saddlebrown"},
                                  {value: "탕수육", color: "saddlebrown"},
                                  {value: "텐동", color: "olivedrab"},
                                  {value: "초밥", color: "olivedrab"},
                                  {value: "규동", color: "olivedrab"},
                                  {value: "라멘", color: "olivedrab"},
                                  {value: "빵", color: "sienna"},
                                  {value: "케이크", color: "sienna"},
                                  {value: "쿠키", color: "sienna"},
                                  {value: "샌드위치", color: "sienna"},
                                  {value: "커피", color: "sienna"},
                                  {value: "커리", color: "green"},
                                  {value: "쌀국수", color: "green"},
                                  {value: "기타", color: "green"}
                                ];

                                const foodTypeButtons = $("#food-type-buttons");

                                const selectedFoodTypes = [
                                  <c:forEach var="foodType" items="${otherBrandInfo.foodTypes}">
                                  '${foodType}'
                                  <c:if test="${!foodType.equals(otherBrandInfo.foodTypes[otherBrandInfo.foodTypes.size()-1])}">,
                                  </c:if>
                                  </c:forEach>
                                ];

                                if (selectedFoodTypes.length === 0) {
                                  $("#food-type-buttons-message").text("아직 선택한 활동 분야가 없어요.");
                                } else {
                                  foodTypes.forEach(function (foodType) {
                                    if (selectedFoodTypes.includes(foodType.value)) {
                                      const button = $("<button></button>")
                                      .text(foodType.value)
                                      .css({
                                        backgroundColor: foodType.color,
                                        border: 'none',
                                        color: 'white',
                                        padding: '10px',
                                        margin: '5px',
                                        borderRadius: '5px'
                                      })
                                      .prop('disabled', true);

                                      $("#food-type-buttons").append(button);
                                    }
                                  });
                                }
                              });
                            </script>


                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color : blue">태그</div>
                                <div class="col-lg-8 col-md-6">
                                    <div id="tag-buttons"></div>
                                    <p id="tag-select-message" class="text-primary"
                                       style="font-size: 18px;"></p>
                                </div>
                            </div>

                            <script>
                              $(document).ready(function () {
                                const tags = [
                                  {value: "뷰 맛집", color: "mediumvioletred"},
                                  {value: "오션뷰", color: "deepskyblue"},
                                  {value: "반려동물 환영", color: "green"},
                                ];

                                const selectedTags = [
                                  <c:forEach var="tag" items="${otherBrandInfo.tagInfos}">
                                  '${tag}'
                                  <c:if test="${!tag.equals(otherBrandInfo.tagInfos[otherBrandInfo.tagInfos.size()-1])}">,
                                  </c:if>
                                  </c:forEach>
                                ];

                                if (selectedTags.length === 0) {
                                  $("#tag-select-message").text("아직 선택한 태그가 없어요.");
                                } else {
                                  tags.forEach(function (tag) {
                                    if (selectedTags.includes(tag.value)) {
                                      const button = $("<button></button>")
                                      .text(tag.value)
                                      .css({
                                        backgroundColor: tag.color,
                                        border: 'none',
                                        color: 'white',
                                        padding: '10px',
                                        margin: '5px',
                                        borderRadius: '5px'
                                      })
                                      .prop('disabled', true);
                                      $("#tag-buttons").append(button);
                                    }
                                  });
                                }
                              });
                            </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span><a
            href="https://github.com/nugunaTeam/FReview2"> nugunaTeam </a></span></strong>.
        All
        Rights
        Reserved
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