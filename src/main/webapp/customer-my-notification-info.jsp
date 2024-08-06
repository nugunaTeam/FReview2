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

      .pagination-container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 20px;
      }

      .table-container {
        position: relative;
      }

      .profile-container img {
        width: 100%;
        height: 100%;
        object-fit: cover; /* 이미지의 중앙을 맞추고, 자르기 */
        object-position: center; /* 중앙 위치 */
      }

      .bi-heart-fill {
        color: red;
      }

      .card-body-y {
        padding: 20px 20px;
      }

      .card-title-y > p {
        cursor: pointer;
      }

      .pb-4 input[type="radio"] {
        margin: 0 5px 0 10px;
      }

      .card-title-y {
        padding: 10px 0px 5px 0;
        font-size: 16px;
        font-weight: 500;
        color: #012970;
        font-family: "Poppins", sans-serif;
      }

      .p-last {
        margin-top: 0;
        margin-bottom: 0.5rem;
        font-size: 12px;
        color: #696969;
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
            <a class="nav-link collapsed "
               href="${pageContext.request.contextPath}/my/activity?userSeq=${userSeq}">
                <i class="bi bi-bell"></i>
                <span>활동</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link "
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
                                <button class="nav-link active" id="zzimed-me-stores-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#zzimed-me-stores" type="button" role="tab"
                                        aria-controls="like" aria-selected="true">나를 찜한 스토어
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="zzimed-me-customers-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#zzimed-me-customers" type="button"
                                        role="tab"
                                        aria-controls="zzim" aria-selected="false">나를 찜한 체험단
                                </button>
                            </li>
                        </ul>

                        <div class="tab-content pt-4" id="borderedTabContent">
                            <!-- 나를 찜한 스토어 -->
                            <div class="tab-pane fade show active" id="zzimed-me-stores"
                                 role="tabpanel"
                                 aria-labelledby="zzim-me-stores-tab">
                                <div>
                                    <div class="pb-4">
                                        <input type="radio" id="zzimed-me-stores-noti-read"
                                               name="isReadStores"
                                               value="true" checked/> 읽음
                                        <input type="radio" id="zzimed-me-stores-noti-not-read"
                                               name="isReadStores"
                                               value="false"/> 안읽음
                                    </div>
                                </div>
                                <div id="zzimedMeStoresList" class="row">
                                    <!-- 나를 찜한 스토어 리스트가 렌더링 -->
                                </div>
                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container"
                                     id="zzimed-me-stores-pagination"></div>
                            </div>

                            <!-- 나를 찜한 체험단 -->
                            <div class="tab-pane fade" id="zzimed-me-customers" role="tabpanel"
                                 aria-labelledby="zzim-me-customers-tab">
                                <div>
                                    <div class="pb-4">
                                        <input type="radio" id="zzimed-me-customers-noti-read"
                                               name="isReadCustomers"
                                               value="true" checked/> 읽음
                                        <input type="radio" id="zzimed-me-customers-noti-not-read"
                                               name="isReadCustomers"
                                               value="false"/> 안읽음
                                    </div>
                                </div>
                                <div id="zzimedMeCustomersList" class="row"></div>
                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container"
                                     id="zzimed-me-customers-pagination"></div>
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
    let userSeq = '${userSeq}';
    let currentPage = 1;

    // 페이지 최초 로드 시 나를 찜한 스토어 리스트 전송
    sendZZimedMeStoreList(1);

    // 나를 찜한 스토어 리스트 전송 함수
    function sendZZimedMeStoreList(page) {
      let isRead = $("input[name='isReadStores']:checked").val() === 'true';
      let sendData = {
        'userSeq': userSeq,
        'isRead': isRead,
        'targetPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/customer/my/notification/zzimed-me-stores",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 나를 찜한 스토어 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, zzimedMeStoreInfos} = response;
          renderZzimStoreList(zzimedMeStoreInfos);
          initializePagination(paginationInfo, 'zzimed-me-stores');
        }
      });
    }

    // 나를 찜한 체험단 리스트 전송 함수
    function sendZzimCustomerList(page) {
      let isRead = $("input[name='isReadCustomers']:checked").val() === 'true';
      let sendData = {
        'userSeq': userSeq,
        'isRead': isRead,
        'targetPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/customer/my/notification/zzimed-me-customers",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 나를 찜한 체험단 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, zzimedMeCustomerInfos} = response;
          renderZzimCustomerList(zzimedMeCustomerInfos);
          initializePagination(paginationInfo, 'zzimed-me-customers');
        }
      });
    }

    // 나를 찜한 스토어 리스트 렌더링 함수
    function renderZzimStoreList(zzimedMeStoreInfos) {
      let htmlStr = "";
      $.map(zzimedMeStoreInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y mt-2'>";
        htmlStr += "<p><a href='/brand/" + item.storeSeq + "?fromUserSeq=${userSeq}" + "'>"
            + item.storeName + "</a>님이 나를 찜하였습니다.</p>";
        htmlStr += "<p class='p-last'>" + item.createdAt.year + "년 " + item.createdAt.monthValue
            + "월 " + item.createdAt.dayOfMonth + "일</p>";
        if (!($("input[name='isReadStores']:checked").val() === 'true')) {
          htmlStr += "<button class='btn btn-primary mark-as-read' data-notification-seq='"
              + item.notificationSeq + "'>읽음확인</button>";
        }
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#zzimedMeStoresList").html(htmlStr);
    }

    // 나를 찜한 체험단 리스트 렌더링 함수
    function renderZzimCustomerList(zzimedMeCustomerInfos) {
      let htmlStr = "";
      $.map(zzimedMeCustomerInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y mt-2'>";
        htmlStr += "<p><a href='/brand/" + item.customerSeq + "?fromUserSeq=${userSeq}" + "'>"
            + item.nickname + "</a>님이 나를 찜하였습니다.</p>";
        htmlStr += "<p class='p-last'>" + item.createdAt.year + "년 " + item.createdAt.monthValue
            + "월 " + item.createdAt.dayOfMonth + "일</p>";
        if (!($("input[name='isReadCustomers']:checked").val() === 'true')) {
          htmlStr += "<button class='btn btn-primary mark-as-read' data-notification-seq='"
              + item.notificationSeq + "'>읽음확인</button>";
        }
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#zzimedMeCustomersList").html(htmlStr);
    }

    // 페이지 네이션 처리
    function initializePagination(paginationInfo, page) {
      let currentPage = paginationInfo.currentPage;
      let startPage = paginationInfo.startPage;
      let endPage = paginationInfo.endPage;
      let hasNext = paginationInfo.hasNext;
      let hasPrevious = paginationInfo.hasPrevious;

      let paginationContainer = $("#" + page + "-pagination");

      let paginationHTML = '';
      if (hasPrevious) {
        paginationHTML += '<button id="prev-block-button" class="btn btn-primary edit-btn" data-page="'
            + (parseInt(currentPage) - 1) + '">&lt;</button>';
      }

      for (let i = startPage; i <= endPage; i++) {
        paginationHTML += '<button class="btn ' + (i === currentPage ? 'btn-secondary'
            : 'btn-primary') + ' edit-btn" data-page="' + i + '">' + i + '</button>';
      }

      if (hasNext) {
        paginationHTML += '<button id="next-block-button" class="btn btn-primary edit-btn" data-page="'
            + (parseInt(currentPage) + 1) + '">&gt;</button>';
      }

      paginationContainer.html(paginationHTML);
    }

    // 탭 클릭 시 해당 리스트 전송
    $("#zzimed-me-stores-tab").on('click', function () {
      $("#zzimed-me-stores-noti-read").prop("checked", true);
      sendZZimedMeStoreList(1);
    });

    $("#zzimed-me-customers-tab").on('click', function () {
      $("#zzimed-me-customers-noti-read").prop("checked", true);
      sendZzimCustomerList(1);
    });

    // 읽음/안읽음 필터 변경 시 리스트 전송
    $("input[name='isReadStores']").on('change', function () {
      sendZZimedMeStoreList(1);
    });

    $("input[name='isReadCustomers']").on('change', function () {
      sendZzimCustomerList(1);
    });

    // 페이지 버튼 클릭 이벤트
    $(document).on("click", ".btn.edit-btn", function (e) {
      let pageNumber = parseInt($(this).data("page"));
      if (pageNumber > 0) {
        handlePageChange(
            $(this).closest(".pagination-container").attr("id").replace("-pagination", ""),
            pageNumber);
      }
    });

    // 읽음확인 버튼 클릭 이벤트
    $(document).on("click", ".mark-as-read", function () {
      let notificationSeq = $(this).data("notification-seq");
      markNotificationAsRead(userSeq, notificationSeq);
    });

    // 알림 읽음 처리 함수
    function markNotificationAsRead(userSeq, notificationSeq) {
      $.ajax({
        type: "POST",
        url: "/api/customer/my/notification/" + notificationSeq,
        data: $.param({userSeq: userSeq}),
        contentType: "application/x-www-form-urlencoded",
        dataType: "text",
        success: function (response) {
          alert("해당 알림을 읽음처리 했습니다.");
          // 현재 활성 탭에 따라 페이지 새로고침
          if ($("#zzimed-me-stores-tab").hasClass("active")) {
            sendZZimedMeStoreList(currentPage);
          } else if ($("#zzimed-me-customers-tab").hasClass("active")) {
            sendZzimCustomerList(currentPage);
          }
        },
        error: function (response) {
          console.error("[ERROR] 알림을 읽음으로 표시하는 데 실패했습니다. 다시 시도해주세요.");
        }
      });
    }

    // 페이지 변경 핸들러
    function handlePageChange(tab, page) {
      currentPage = page;
      if (tab === 'zzimed-me-stores') {
        sendZZimedMeStoreList(page);
      } else if (tab === 'zzimed-me-customers') {
        sendZzimCustomerList(page);
      }
    }
  });
</script>


</body>

</html>