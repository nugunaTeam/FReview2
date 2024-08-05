<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="loginUser" value="${loginUser}"/>
<c:set var="userSeq" value="${loginUser.seq}"/>
<c:set var="nickname" value="${loginUser.nickname}"/>
<c:set var="profileUrl" value="${loginUser.profilePhotoUrl}"/>
<c:set var="code" value="${loginUser.code}"/>
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
    <div class="header-hr-right ms-auto">
        <div class="d-flex align-items-center">
            <div class="pe-3">
                <a href="/my/brand-info?userSeq=${userSeq}" style="margin-right: 20px">
                    ${nickname}
                    <img class="rounded-circle" src="${profileUrl}" alt=" "
                         style="width: 30px; margin-top: 15px; ">
                </a>
                <a href="/COMM_logout.jsp" style="margin-top: 17px;">로그아웃</a>
            </div>
        </div>
    </div>
</header><!-- End Header -->

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
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/my-info?userSeq=${userSeq}">
                <i class="bi bi-person"></i>
                <span>개인정보수정</span>
            </a>
        </li><!-- End Register Page Nav -->

    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">
    <%--    <div id="userSeqData" data-user-seq="${userSeq}" hidden="hidden"></div>--%>
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
                                <div id="sendLikeList" class="row">
                                    <!-- 좋아요 리스트가 여기에 렌더링됩니다. -->
                                </div>

                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container" id="like-pagination"></div>
                            </div>

                            <!-- 내가 찜한 유저 -->
                            <div class="tab-pane fade" id="send-zzim" role="tabpanel"
                                 aria-labelledby="zzim-tab">
                                <div>
                                    <div class="pb-4">
                                        <input type="radio" id="customerZzim" name="code" value="CUSTOMER" checked /> 체험단
                                        <input type="radio" id="storeZzim" name="code" value="STORE" /> 스토어
                                    </div>
<%--                                    <div class="pb-4">--%>
<%--                                        <input type="radio" id="customerZzim" name="code"--%>
<%--                                               value="CUSTOMER"--%>
<%--                                               onchange="handleZzimPageChange('CUSTOMER')" checked/>--%>
<%--                                        체험단--%>
<%--                                        <input type="radio" id="storeZzim" name="code" value="STORE"--%>
<%--                                               onchange="handleZzimPageChange('STORE')"/> 스토어--%>
<%--                                    </div>--%>
                                </div>
                                <div id="sendZzimListHtml" class="row"></div>
                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container" id="zzim-pagination"></div>
                            </div>

                            <!-- 내가 작성한 글 -->
                            <div class="tab-pane fade" id="written-post" role="tabpanel"
                                 aria-labelledby="post-tab">
                                <div>
                                    <div id="writtenPostList" class="row"></div>
                                    <!-- 페이지네이션 버튼 -->
                                    <div class="pagination-container" id="post-pagination"></div>
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
  $(document).ready(function () {

    let userSeq = '${userSeq}';
    let selectedValue = $("input[name='code']:checked").val() || 'CUSTOMER'; // 기본값 설정
    // let selectedValue = $("input[name='code']:checked").val();

    // 초기 활동 페이지 로드 시 좋아요 리스트 우선.
    sendLikeList(1);

    // 좋아요 리스트 전송 함수
    function sendLikeList(page) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/store/activity/send-like",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 좋아요 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, sendLikeInfos} = response;
          renderLikeList(sendLikeInfos);
          initializePagination(paginationInfo, 'like');
        }
      });
    }
    // 좋아요 - 리스트
    function renderLikeList(sendLikeInfos) {
      let htmlStr = "";
      $.map(sendLikeInfos, function (item) {
        let formattedDate = dayjs(item.createdAt).format('YYYY년 MM월 DD일');
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y'>";
        htmlStr += "<h6 class='card-title-y'>";
        htmlStr += "<a href='/mojip/" + item.postSeq + "'>";
        htmlStr += (item.title.length > 20 ? item.title.substring(0, 20) + '...' : item.title);
        htmlStr += "</a>";
        htmlStr += "</h6>";
        htmlStr += "<p>" + (item.content.length > 30 ? item.content.substring(0, 30) + '...'
            : item.content) + "</p>";
        htmlStr += "<p class='p-last'>" + formattedDate
            + " &nbsp<i class='bi bi-heart-fill'></i> &nbsp" + item.likeCount + "</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#sendLikeList").html(htmlStr);
    }


    // 페이지 변경 핸들러
    function handlePageChange(location, page) {
      if (location === 'post') {        // 작성한 글
        writtenPostList(page);
      } else if (location === 'like') { // 좋아요
        sendLikeList(page);
      } else if (location === 'zzim') { // 찜
        sendZzimList(page, selectedValue)
        .then(response => {
          if (selectedValue === 'CUSTOMER') {
            renderZzimCustomerList(response.sendZzimCustomerInfos);
          } else if (selectedValue === 'STORE') {
            renderZzimStoreList(response.sendZzimStoreInfos);
          } else {
            console.error("[Not Found!] 데이터를 찾을 수 없습니다. 다시 시도해주세요.");
          }
          initializePagination(response.paginationInfo, 'zzim');
        })
        .catch(error => {
          console.error("[ERROR] 데이터가 정상적이지 않습니다. 다시 시도해주세요.");
        });

      }
    }

    // // selectedValue 값에 따른 input value 선택.
    // function handleZzimPageChange(value) {
    //   selectedValue = value;
    //   sendZzimPageList(selectedValue);
    // }

    // 페이지에 따라 찜 리스트를 로드하는 함수
    // function sendZzimPageList(page) {
    //   sendZzimList(1, page);
    // }

    // 찜(체험단/스토어) 리스트 전송 함수
    function sendZzimList(page, selectedValue) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };

      let apiUrl = selectedValue === 'CUSTOMER'
          ? "/api/store/activity/send-zzim-to-customer"
          : "/api/store/activity/send-zzim-to-store";

      return new Promise((resolve, reject) => {
        $.ajax({
          type: "GET",
          url: apiUrl,
          data: $.param(sendData),
          contentType: "application/x-www-form-urlencoded",
          dataType: "json",
          success: function (response) {
            let paginationInfo = response.paginationInfo;
            if (selectedValue === 'CUSTOMER') {
              renderZzimCustomerList(response.sendZzimCustomerInfos);
            } else if (selectedValue === 'STORE') {
              renderZzimStoreList(response.sendZzimStoreInfos);
            }
            initializePagination(paginationInfo, 'zzim');
            resolve(response);
          },
          error: function (response) {
            reject(response);
            console.error("[ERROR] 찜 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
          }
        });
      });
    }
    // 찜 - 체험단 리스트 렌더링 함수
    function renderZzimCustomerList(sendZzimCustomerInfos) {
      let htmlStr = "";
      $.map(sendZzimCustomerInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y mt-2'>";
        htmlStr += "<p><a href='/brand/" + item.zzimUserSeq + "'>" + item.nickname
            + "</a>님을 찜 하였습니다.</p>";
        htmlStr += "<p class='p-last'>분야 : " + item.foodTypes + "</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#sendZzimListHtml").html(htmlStr);
    }
    // 찜 - 스토어 리스트 렌더링 함수
    function renderZzimStoreList(sendZzimStoreInfos) {
      let htmlStr = "";
      $.map(sendZzimStoreInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y mt-2'>";
        htmlStr += "<p><a href='/brand/" + item.zzimUserSeq + "'>" + item.nickname
            + "</a>님을 찜 하였습니다.</p>";
        htmlStr += "<p class='text-body-y'>스토어 위치 : " + item.storeLocation + "</p>";
        htmlStr += "<p class='p-last'>분야 : " + item.foodTypes + "</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#sendZzimListHtml").html(htmlStr);
    }

    // 작성한 글 리스트 전송 함수
    function writtenPostList(page) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/store/activity/written-post",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 작성한 글 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {writtenPostInfos, paginationInfo} = response;
          renderWrittenPostList(writtenPostInfos);
          initializePagination(paginationInfo, 'post');
        }
      });
    }
    // 작성한 글 리스트 랜더링 함수
    function renderWrittenPostList(writtenPostInfos) {
      let htmlStr = "";
      $.map(writtenPostInfos, function (item) {
        let formattedDate = dayjs(item.createdAt).format('YYYY년 MM월 DD일');
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y'>";
        htmlStr += "<h6 class='card-title-y'>";
        htmlStr += "<a href='/mojip/" + item.postSeq + "'>";
        htmlStr += (item.title.length > 20 ? item.title.substring(0, 20) + '...' : item.title);
        htmlStr += "</a>";
        htmlStr += "</h6>";
        htmlStr += "<p>" + (item.content.length > 30 ? item.content.substring(0, 30) + '...'
            : item.content) + "</p>";
        htmlStr += "<p class='p-last'>" + formattedDate
            + " &nbsp<i class='bi bi-heart-fill'></i> &nbsp" + item.likeCount + "</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#writtenPostList").html(htmlStr);
    }

    // 페이지 네이션 처리.
    function initializePagination(paginationInfo, page) {
      let currentPage = paginationInfo.currentPage;
      let startPage = paginationInfo.startPage;
      let endPage = paginationInfo.endPage;
      let hasNext = paginationInfo.hasNext;
      let hasPrevious = paginationInfo.hasPrevious;

      // 각 id에 맞는 위치에 데이터 뿌릴 변수명 = paginationContainer
      let paginationContainer = $("#" + page + "-pagination");

      let paginationHTML = '';
      // 이전 버튼
      if (hasPrevious) {
        paginationHTML += '<button id="prev-block-button" class="btn btn-primary edit-btn" data-page="'
            + (parseInt(currentPage) - 1) + '">&lt;</button>';
      }

      // 페이지 버튼들
      for (let i = startPage; i <= endPage; i++) {
        paginationHTML += '<button class="btn ' + (i == currentPage ? 'btn-secondary'
            : 'btn-primary') + ' edit-btn" data-page="' + i + '">' + i + '</button>';
      }

      // 다음 버튼
      if (hasNext) {
        paginationHTML += '<button id="next-block-button" class="btn btn-primary edit-btn" data-page="'
            + (currentPage + 1) + '">&gt;</button>';
      }

      // 각 id에 맞는 위치에 데이터 뿌릴 변수명에 paginationHTML 코드 입력.
      paginationContainer.html(paginationHTML);

      // 이전 및 다음 버튼에 대한 페이지 이동처리
      $('#prev-block-button').off('click').on('click', function () {
        if (hasPrevious) {
          handlePageChange(page, currentPage - 1);
        }
      });

      $('#next-block-button').off('click').on('click', function () {
        if (hasNext) {
          handlePageChange(page, currentPage + 1);
        }
      });
    }


    // 초기 zzim탭 로드
    sendZzimList(1, selectedValue);

    // 찜 탭 클릭시, 우선 순위
    $("input[name='code']").on('change', function () {
      selectedValue = $(this).val();
      sendZzimList(1, selectedValue);
    });

    // post 탭 클릭시,
    $("#post-tab").on('click', function () {
      writtenPostList(1);
    });

    // 라디오 버튼 클릭 시, input value 에 따라 code 변경.
    // $("input[name='code']").on('change', function () {
    //   let select = $(this).val();
    //   sendZzimList(1, select);
    // });

    // 페이지 버튼 클릭 이벤트
    $(document).on("click", ".btn.edit-btn", function (e) {
      let pageNumber = parseInt($(this).data("page"));
      if (pageNumber > 0) {
        handlePageChange(
            $(this).closest(".pagination-container").attr("id").replace("-pagination", ""),
            pageNumber);
      }
    });



  });
</script>


</body>

</html>