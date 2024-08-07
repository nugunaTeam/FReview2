<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="nickname" value="${nickname}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" type="text/css" href="/assets/css/style-h.css"/>
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
    <style>

      .card-body {
        display: flex;
        flex-direction: column;
        padding: 15px;
      }

      .card-body p {
        margin: 5px 0;
      }

      .date-like-info {
        display: flex;
        flex-direction: row;
        margin-bottom: 10px;
      }

      .date-like-info p {
        margin: 0 5px;
      }

      .date-like-info i {
        margin-left: 5px;
      }

      .profile-container img {
        width: 100%;
        height: 100%;
        object-fit: cover; /* 이미지의 중앙을 맞추고, 자르기 */
        object-position: center; /* 중앙 위치 */
      }

      .card-title-y > p {
        cursor: pointer;
      }

      .pb-4 input[type="radio"] {
        margin: 0 5px 0 10px;
      }

      .card-title span {
        color: #899bbd;
        font-size: 14px;
        font-weight: 400;
      }

      .pagination-container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 20px;
      }

    </style>

    <!-- add css-->
    <link rel="stylesheet" href="/assets/css/style-h.css"/>

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

    <!-- Day.js -->
    <script src="https://cdn.jsdelivr.net/npm/dayjs@1.10.7/dayjs.min.js"></script>
</head>

<body>

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

                    <img src="/user/${userSeq}/profile"
                         alt="Profile"
                         class="rounded-circle profile-img"
                         style="margin-right: 5px;">
                    <span id="nickname-holder-head"
                          class="d-none d-md-block"
                          style="font-size : 18px;">${nickname}</span>
                </a>
            </li>
        </ul>
    </nav>
</header>


<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item">
            <a class="nav-link collapsed"
               href="/my/brand-info?userSeq=${userSeq}">
                <i class="bi bi-grid"></i>
                <span>브랜딩</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/my/experience?userSeq=${userSeq}">
                <i class="bi bi-card-checklist"></i>
                <span>체험</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link "
               href="${pageContext.request.contextPath}/my/activity?userSeq=${userSeq}">
                <i class="bi bi-bell"></i>
                <span>활동</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/my/notification?userSeq=${userSeq}">
                <i class="bi bi-card-checklist"></i>
                <span>알림</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/my/personal-info?userSeq=${userSeq}">
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
                                <button class="nav-link active" id="like-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#like" type="button" role="tab"
                                        aria-controls="like" aria-selected="true">좋아요
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="zzim-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#zzim" type="button"
                                        role="tab"
                                        aria-controls="zzim" aria-selected="false">찜
                                </button>
                            </li>
                        </ul>

                        <div class="tab-content pt-4" id="borderedTabContent">
                            <div class="tab-pane fade show active" id="like" role="tabpanel"
                                 aria-labelledby="like-tab">
                                <div id="likePostsList" class="row"></div>
                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container" id="like-posts-pagination"></div>
                            </div>


                            <!-- 내가 찜한 스토어 / 체험단-->
                            <div class="tab-pane fade" id="zzim" role="tabpanel"
                                 aria-labelledby="zzim-tab">
                                <div>
                                    <div class="pb-4">
                                        <input type="radio" id="zzimed-store-radio" name="zzimed"
                                               checked/> 스토어
                                        <input type="radio" id="zzimed-customer-radio"
                                               name="zzimed"/> 체험단
                                    </div>
                                </div>
                                <div id="zzimedUserList" class="row"></div>
                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container"
                                     id="zzimed-users-pagination"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>


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
  $(document).ready(function () {
    let userSeq = '${userSeq}'; // 사용자 시퀀스
    let currentPage = 1; // 현재 페이지 번호

    // 페이지 로드 시 좋아요 리스트를 가져옵니다.
    sendMyLikedPosts(1);

    // 좋아요한 글 리스트를 가져오는 함수
    function sendMyLikedPosts(page) {
      let sendData = {
        'userSeq': userSeq,
        'targetPage': page
      };

      $.ajax({
        type: "GET",
        url: "/api/customer/my/activity-info/my-liked-posts",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 좋아요한 글 리스트를 불러오는 데 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, myLikeInfos} = response;
          renderLikedPostsList(myLikeInfos);
          initializePagination(paginationInfo, 'like-posts');
        }
      });
    }

    function renderLikedPostsList(myLikeInfos) {
      let htmlStr = "";
      $.map(myLikeInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body mt-2'>";

        htmlStr += "<p><a href='/brand/" + item.authorSeq + "'>" + item.storeName + "</a> 님의 ";
        htmlStr += "<a href='/post/" + item.seq
            + "'>모집글</a>에 <span style='color : green'>좋아요</span> 했습니다.</p>";

        // 날짜와 좋아요 수를 상단에 표시
        htmlStr += "<div class='date-like-info'>";
        htmlStr += "<p>" + item.createdAt.year + "년 " + item.createdAt.monthValue + "월 "
            + item.createdAt.dayOfMonth + "일</p>";
        htmlStr += "<i>❤️</i>";
        htmlStr += "<p>" + item.likeCount + "</p>";
        htmlStr += "</div>";

        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#likePostsList").html(htmlStr);
    }

    // 찜한 스토어 리스트를 가져오는 함수
    function sendZzimStoreList(page) {
      let sendData = {
        'userSeq': userSeq,
        'targetPage': page
      };

      $.ajax({
        type: "GET",
        url: "/api/customer/my/activity-info/my-zzimed-stores",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 찜한 스토어 리스트를 불러오는 데 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, zzimedStoreInfos} = response;
          renderZzimStoreList(zzimedStoreInfos);
          initializePagination(paginationInfo, 'zzimed-users');
        }
      });
    }

    // 찜한 스토어 리스트를 렌더링하는 함수
    function renderZzimStoreList(zzimedStoreInfos) {
      let htmlStr = "";
      $.map(zzimedStoreInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body mt-2'>";

        htmlStr += "<p><a href='/brand/" + item.storeSeq + "'>" + item.storeName
            + "</a>님을 <span style='color : mediumvioletred'>찜</span>했습니다.</p>";
        htmlStr += "<p><span style='color: green;'>위치</span>: " + item.storeLocation + "</p>";
        htmlStr += "<p><span style='color: mediumvioletred;'>활동 분야</span>: " + item.foodTypes.join(
            ", ") + "</p>";
        htmlStr += "<p>" + item.createdAt.year + "년 " + item.createdAt.monthValue + "월 "
            + item.createdAt.dayOfMonth + "일</p>";

        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#zzimedUserList").html(htmlStr);
    }

    // 찜한 체험단 리스트를 가져오는 함수
    function sendZzimCustomerList(page) {
      let sendData = {
        'userSeq': userSeq,
        'targetPage': page
      };

      $.ajax({
        type: "GET",
        url: "/api/customer/my/activity-info/my-zzimed-customers",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 찜한 체험단 리스트를 불러오는 데 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, zzimedCustomerInfos} = response;
          renderZzimCustomerList(zzimedCustomerInfos);
          initializePagination(paginationInfo, 'zzimed-users');
        }
      });
    }

    // 찜한 체험단 리스트를 렌더링하는 함수
    function renderZzimCustomerList(zzimedCustomerInfos) {
      let htmlStr = "";
      $.map(zzimedCustomerInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body mt-2'>";

        htmlStr += "<p><a href='/brand/" + item.customerSeq + "'>" + item.nickname
            + "</a>님을 <span style='color : mediumvioletred'>찜</span>했습니다.</p>";
        htmlStr += "<p><span style='color: mediumvioletred;'>활동 분야</span>: " + item.foodTypes.join(
            ", ") + "</p>";
        htmlStr += "<p>" + item.createdAt.year + "년 " + item.createdAt.monthValue + "월 "
            + item.createdAt.dayOfMonth + "일</p>";

        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#zzimedUserList").html(htmlStr);
    }

    // 찜 탭 클릭 이벤트
    $("#zzim-tab").on("click", function () {
      sendZzimStoreList(1); // 처음 페이지를 로드
    });

    // 라디오 버튼 클릭 이벤트
    $("input[name='zzimed']").on("change", function () {
      if ($("#zzimed-store-radio").is(":checked")) {
        sendZzimStoreList(1);
      } else if ($("#zzimed-customer-radio").is(":checked")) {
        sendZzimCustomerList(1);
      }
    });

    function initializePagination(paginationInfo, page) {
      let currentPage = paginationInfo.currentPage;
      let startPage = paginationInfo.startPage;
      let endPage = paginationInfo.endPage;
      let hasNext = paginationInfo.hasNext;
      let hasPrevious = paginationInfo.hasPrevious;

      let paginationContainer = $("#" + page + "-pagination");

      let paginationHTML = '';

      // 이전 페이지 버튼
      if (hasPrevious) {
        paginationHTML += '<button id="prev-block-button" class="btn btn-primary edit-btn" data-page="'
            + (parseInt(currentPage) - 1) + '">&lt;</button>';
      }

      // 페이지 번호 버튼
      for (let i = startPage; i <= endPage; i++) {
        paginationHTML += '<button class="btn ' + (i === currentPage ? 'btn-secondary'
            : 'btn-primary') + ' edit-btn" data-page="' + i + '">' + i + '</button>';
      }

      // 다음 페이지 버튼
      if (hasNext) {
        paginationHTML += '<button id="next-block-button" class="btn btn-primary edit-btn" data-page="'
            + (parseInt(currentPage) + 1) + '">&gt;</button>';
      }

      paginationContainer.html(paginationHTML);

      // 페이지 버튼 클릭 이벤트 처리
      $(".edit-btn").on("click", function () {
        let pageNumber = parseInt($(this).data("page"));
        if (pageNumber > 0) {
          handlePageChange(
              $(this).closest(".pagination-container").attr("id").replace("-pagination", ""),
              pageNumber
          );
        }
      });
    }

    // 페이지 변경 핸들러
    function handlePageChange(tab, page) {
      // 현재 페이지를 전역 변수에 업데이트 (필요에 따라)
      currentPage = page;

      // 페이지에 따라 적절한 데이터를 로드
      if (tab === 'like-posts') {
        sendMyLikedPosts(page);
      } else if (tab === 'zzimed-users') {
        if ($("#zzimed-store-radio").is(":checked")) {
          sendZzimStoreList(page);
        } else if ($("#zzimed-customer-radio").is(":checked")) {
          sendZzimCustomerList(page);
        }
      }
    }
  });
</script>


</body>

</html>