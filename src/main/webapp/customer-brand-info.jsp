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

    <title>브랜딩 페이지</title>
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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">

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
        <a href="${pageContext.request.contextPath}/main?seq=${userSeq}&pagecode=Requester"
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
                    <img src="/user/${fromUserSeq}/profile" alt="Profile"
                         class="rounded-circle">
                    <span id="nickname-holder-head"
                          class="d-none d-md-block">${userNickname}</span>
                </a>
            </li>
        </ul>
    </nav>
</header>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>${otherBrandInfo.nickname}님의 브랜딩 페이지</h1>
    </div><!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="card">
                <!-- profile  -->
                <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                    <img src="/user/${userSeq}/profile" alt="Profile"
                         class="rounded-circle">
                    <h2 id="nickname-holder-section">${otherBrandInfo.nickname}
                    </h2>
                    <div class="social-links mt-2 ri-heart-3-fill">
                        ${otherBrandInfo.zzimCount}
                    </div>
                </div>

                <div class="card-body pt-3">
                    <!-- Bordered Tabs -->
                    <div class="tab-content pt-2">

                        <div class="tab-pane fade show active profile-overview"
                             id="profile-overview">

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">소개</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="introduce-input" type="text" name="to_nickname"
                                           value="${otherBrandInfo.introduce}"
                                           class="form-control" readonly>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">닉네임</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="nickname-input" type="text" name="to_nickname"
                                           value="${otherBrandInfo.nickname}"
                                           class="form-control" readonly>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label">연령대</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="agegroup-input" type="text" name="to_nickname"
                                           value="${otherBrandInfo.ageGroup}"
                                           class="form-control" readonly>
                                </div>
                            </div>


                        </div>

                        <div class="row">
                            <div class="col-lg-3 col-md-4 label">활동 분야</div>
                            <div class="col-lg-8 col-md-6">
                                <div id="food-type-buttons">

                                </div>
                                <p id="food-type-buttons-message" class="text-primary"
                                   style="font-size: 14px;"></p>
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
                          });
                        </script>


                        <div class="row">
                            <div class="col-lg-3 col-md-4 label">태그</div>
                            <div class="col-lg-8 col-md-6">
                                <div id="tag-buttons"></div>
                                <p id="tag-select-message" class="text-primary"
                                   style="font-size: 14px;"></p>
                            </div>
                        </div>

                        <script>
                          $(document).ready(function () {
                            const tags = [
                              {value: "초식", color: "green"},
                              {value: "육식", color: "indianred"},
                              {value: "맛집블로거", color: "blue"},
                              {value: "정성리뷰어", color: "orange"}
                            ];

                            const selectedTags = [
                              <c:forEach var="tag" items="${otherBrandInfo.tagInfos}">
                              '${tag}'
                              <c:if test="${!tag.equals(otherBrandInfo.tagInfos[otherBrandInfo.tagInfos.size()-1])}">,
                              </c:if>
                              </c:forEach>
                            ];

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
                          });
                        </script>

                        <%--
                                                            <div class="row">
                                                                <div class="col-lg-3 col-md-4 label">리뷰 로그</div>
                                                                <div class="col-lg-8 col-md-6">
                                                                    <table class="table table-striped table-bordered text-center"
                                                                           id="review-log-table">
                                                                        <thead>
                                                                        <tr>
                                                                            <th>스토어명</th>
                                                                            <th>방문일자</th>
                                                                            <th>리뷰 작성여부</th>
                                                                        </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                        <tr>
                                                                            <th scope="row">1</th>
                                                                            <td>Brandon Jacob</td>
                                                                            <td>Designer</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">2</th>
                                                                            <td>Bridie Kessler</td>
                                                                            <td>Developer</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">3</th>
                                                                            <td>Ashleigh Langosh</td>
                                                                            <td>Finance</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">4</th>
                                                                            <td>Angus Grady</td>
                                                                            <td>HR</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">5</th>
                                                                            <td>Raheem Lehner</td>
                                                                            <td>Dynamic Division Officer</td>
                                                                        </tr>
                                                                        </tbody>
                                                                    </table>
                                                                    <div class="d-flex justify-content-between mt-3">
                                                                        <button id="prev-block-button"
                                                                                class="btn btn-primary edit-btn" disabled>&lt;
                                                                        </button>
                                                                        <div id="page-buttons"
                                                                             class="d-flex justify-content-center mx-2">
                                                                            <!-- 페이지 번호 버튼들이 여기에 추가됩니다 -->
                                                                        </div>
                                                                        <button id="next-block-button"
                                                                                class="btn btn-primary edit-btn" disabled>&gt;
                                                                        </button>
                                                                    </div>
                                                                </div>

                                                                <script>
                                                                  $(document).ready(function () {
                                                                    var currentPage = 1;
                                                                    var totalPages = 50; // 예시: 총 페이지 수는 50이라고 가정
                                                                    var pagesPerBlock = 5;

                                                                    function fetchReviewLogs(page) {
                                                                      $.ajax({
                                                                        url: '/api/review-logs',
                                                                        method: 'GET',
                                                                        data: {page: page},
                                                                        success: function (response) {
                                                                          var reviewLogs = response.logs;
                                                                          var hasPrevious = response.hasPrevious;
                                                                          var hasNext = response.hasNext;
                                                                          totalPages = response.totalPages;

                                                                          renderReviewLogs(reviewLogs);
                                                                          renderPageButtons();
                                                                          updatePaginationButtons(hasPrevious, hasNext);
                                                                        },
                                                                        error: function (err) {
                                                                          alert('리뷰 로그 데이터를 가져오는데 실패하였습니다.');
                                                                          renderPageButtons();
                                                                        }
                                                                      });
                                                                    }

                                                                    function renderReviewLogs(reviewLogs) {
                                                                      var tbody = $('#review-log-table tbody');
                                                                      tbody.empty(); // 기존 데이터를 제거합니다.

                                                                      reviewLogs.forEach(function (log) {
                                                                        var row = $('<tr>');
                                                                        row.append($('<td>').text(log.storeName));
                                                                        row.append($('<td>').text(log.visitDate));
                                                                        row.append($('<td>').text(log.reviewWritten));
                                                                        tbody.append(row);
                                                                      });
                                                                    }

                                                                    function renderPageButtons() {
                                                                      var pageButtonsDiv = $('#page-buttons');
                                                                      pageButtonsDiv.empty(); // 기존 페이지 버튼을 제거합니다.

                                                                      var currentBlock = Math.floor(
                                                                          (currentPage - 1) / pagesPerBlock);
                                                                      var startPage = currentBlock * pagesPerBlock + 1;
                                                                      var endPage = Math.min(startPage + pagesPerBlock - 1,
                                                                          totalPages);

                                                                      for (var i = startPage; i <= endPage; i++) {
                                                                        var pageButton = $('<button>')
                                                                        .text(i)
                                                                        .addClass(
                                                                            'btn btn-outline-primary mx-1 datatable-pagination-list-item-link')
                                                                        .attr('data-page', i)
                                                                        .attr('aria-label', 'Page ' + i);
                                                                        if (i === currentPage) {
                                                                          pageButton.addClass('active');
                                                                        }
                                                                        pageButton.on('click', function () {
                                                                          var page = parseInt($(this).attr('data-page'));
                                                                          currentPage = page;
                                                                          fetchReviewLogs(currentPage);
                                                                        });
                                                                        pageButtonsDiv.append(pageButton);
                                                                      }
                                                                    }

                                                                    function updatePaginationButtons(hasPrevious, hasNext) {
                                                                      var currentBlock = Math.floor(
                                                                          (currentPage - 1) / pagesPerBlock);
                                                                      var totalBlocks = Math.ceil(totalPages / pagesPerBlock);

                                                                      $('#prev-block-button').prop('disabled', currentBlock === 0);
                                                                      $('#next-block-button').prop('disabled',
                                                                          currentBlock >= totalBlocks - 1);
                                                                    }

                                                                    $('#prev-block-button').click(function () {
                                                                      var currentBlock = Math.floor(
                                                                          (currentPage - 1) / pagesPerBlock);
                                                                      if (currentBlock > 0) {
                                                                        currentPage = (currentBlock - 1) * pagesPerBlock + 1;
                                                                        fetchReviewLogs(currentPage);
                                                                      }
                                                                    });

                                                                    $('#next-block-button').click(function () {
                                                                      var currentBlock = Math.floor(
                                                                          (currentPage - 1) / pagesPerBlock);
                                                                      var totalBlocks = Math.ceil(totalPages / pagesPerBlock);
                                                                      if (currentBlock < totalBlocks - 1) {
                                                                        currentPage = (currentBlock + 1) * pagesPerBlock + 1;
                                                                        fetchReviewLogs(currentPage);
                                                                      }
                                                                    });

                                                                    // 초기 데이터 로드
                                                                    fetchReviewLogs(currentPage);
                                                                  });

                                                                </script>--%>


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