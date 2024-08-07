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

      table {
        text-align: center;
      }

      .pagination-container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 20px;
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
            <a class="nav-link "
               href="${pageContext.request.contextPath}/store/experience?userSeq=${userSeq}">
                <i class="bi bi-card-checklist"></i>
                <span>체험</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
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
                                <button class="nav-link active" id="apply-tab" data-bs-toggle="tab"
                                        data-bs-target="#apply-list" type="button" role="tab"
                                        aria-controls="apply" aria-selected="true">지원자 리스트
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="proposal-tab" data-bs-toggle="tab"
                                        data-bs-target="#proposal-list" type="button" role="tab"
                                        aria-controls="proposal" aria-selected="false">제안자 리스트
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="final-tab" data-bs-toggle="tab"
                                        data-bs-target="#final-list" type="button" role="tab"
                                        aria-controls="final" aria-selected="false">확정자 리스트
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="review-tab" data-bs-toggle="tab"
                                        data-bs-target="#review-list" type="button" role="tab"
                                        aria-controls="review" aria-selected="false">리뷰 리스트
                                </button>
                            </li>
                        </ul>
                        <div class="tab-content pt-4" id="borderedTabContent">
                            <!-- 지원자 리스트 -->
                            <div class="tab-pane fade show active" id="apply-list" role="tabpanel"
                                 aria-labelledby="apply-tab">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>지원자</th>
                                        <th>모집글</th>
                                        <th>모집 시작일</th>
                                        <th>모집 마감일</th>
                                        <th>체험일</th>
                                        <th>확정체크</th>
                                        <th>상태</th>
                                    </tr>
                                    </thead>
                                    <tbody id="applyListHtml"></tbody>
                                </table>
                                <div class="pagination-container" id="apply-pagination"></div>
                            </div>
                            <!-- 제안자 리스트 -->
                            <div class="tab-pane fade show " id="proposal-list" role="tabpanel"
                                 aria-labelledby="proposal-tab">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>제안자</th>
                                        <th>제안 내용</th>
                                        <th>제안 일자</th>
                                        <th>진행 상황</th>
                                    </tr>
                                    </thead>
                                    <tbody id="proposalListHtml"></tbody>
                                </table>
                                <div class="pagination-container" id="proposal-pagination"></div>
                            </div>
                            <!-- 확정자 리스트 -->
                            <div class="tab-pane fade" id="final-list" role="tabpanel"
                                 aria-labelledby="final-tab">
                                <div>
                                    <div class="pb-4">
                                        <input type="radio" name="code" value="APPLY" checked /> 지원
                                        <input type="radio" name="code" value="PROPOSAL" /> 제안
                                    </div>
                                </div>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>지원자</th>
                                        <th class="title-header">모집글</th>
                                        <th class="proposal-header" style="display:none;">제안내용</th>
                                        <th>체험일자</th>
                                        <th>참여여부</th>
                                        <th>상태</th>
                                    </tr>
                                    </thead>
                                    <tbody id="finalListHtml"></tbody>
                                </table>
                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container" id="final-pagination"></div>
                            </div>
                            <!-- 리뷰 리스트ㅡ -->
                            <div class="tab-pane fade" id="review-list" role="tabpanel"
                                 aria-labelledby="review-tab">
                                <div>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>지원자</th>
                                            <th>체험일자</th>
                                            <th>리뷰상태</th>
                                            <th>리뷰 url</th>
                                            <th>리뷰 등록일</th>
                                            <th>숨김</th>
                                        </tr>
                                        </thead>
                                        <tbody id="reviewListHtml"></tbody>
                                    </table>
                                    <!-- 페이지네이션 버튼 -->
                                    <div class="pagination-container" id="review-pagination"></div>
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
    let selectedValue = $("input[name='code']:checked").val() || 'APPLY'; // 기본값 설정

    // 초기 활동 페이지 로드 시 좋아요 리스트 우선.
    // applyList(1);

    // ----- 지원자 리스트
    function applyList(page) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/store/experience/apply-list",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 지원자 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let { paginationInfo, storeApplyList } = response;
          renderApplyList(storeApplyList);
          initializePagination(paginationInfo, 'apply');
        }
      });
    }
    // 지원자 리스트
    function renderApplyList(storeApplyList) {
      let htmlStr = "";
      $.map(storeApplyList, function (item) {
        let postTitle = item.title.length > 30 ? item.title.substring(0, 30) + '...' : item.title;
        let startDateFormat = dayjs(item.applyStartDate).format('YYYY-MM-DD');
        let endDateFormat = dayjs(item.applyEndDate).format('YYYY-MM-DD');
        let experienceDateFormat = dayjs(item.experienceDate).format('YYYY-MM-DD');
        htmlStr += "<tr>";
        htmlStr += "<td><a href='/brand/" + item.fromUserSeq + "'>" + item.nickname + "</a></td>";
        htmlStr += "<td><a href='/mojip/" + item.fromPostSeq + "'>" + postTitle + "</a></td>";
        htmlStr += "<td>" + startDateFormat + "</td>";
        htmlStr += "<td>" + endDateFormat + "</td>";
        htmlStr += "<td>" + experienceDateFormat + "</td>";
        // htmlStr += "<td data-id='"+ item.experienceSeq +"'><input type='button' class='status-apply' value='확정'></td>";
        htmlStr += "<td><button class='status-apply' data-id='" + item.experienceSeq + "'>확정</button></td>";
        htmlStr += "<td class='status-apply'>" + item.status + "</td>";
        htmlStr += "</tr>";
      });
      $("#applyListHtml").html(htmlStr);

      // 이벤트 위임을 통해 동적으로 생성된 요소에 이벤트 바인딩
      $(document).off("click", ".status-apply").on("click", ".status-apply", function() {
        let experienceSeq = $(this).data("id");

        if (experienceSeq !== undefined) {
          statusConfirm(experienceSeq);
        } else {
          console.error("[ERROR] experienceSeq is undefined.");
        }
      });
    }
    // 지원자 리스트 status function
    function statusConfirm(experienceSeq) {
      let status = 'ACCEPTED';
      $.ajax({
        type: "POST",
        url: "/api/store/experience/apply-confirm?status=" + status + "&experienceSeq=" + experienceSeq,
        success: function(response) {
          alert("상태가 성공적으로 업데이트되었습니다.");
        },
        error: function() {
          console.error("[ERROR] 지원자 상태값을 수정할 수 없습니다.");
        }
      });
    }

    // 제안자 리스트
    function proposalList(page) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/store/experience/proposal-list",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 제안자 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {proposalList, paginationInfo} = response;
          renderProposalList(proposalList);
          initializePagination(paginationInfo, 'proposal');
        }
      });
    }
    // 제안자 리스트 랜더링 함수
    function renderProposalList(proposalList) {
      let htmlStr = "";
      $.map(proposalList, function (item) {
        let proposalDetail = item.proposalDetail.length > 30 ? item.proposalDetail.substring(0, 30) + '...' : item.proposalDetail;
        let proposalDate = dayjs(item.createdAt).format('YYYY-MM-DD');
        htmlStr += "<tr>";
        htmlStr += "<td><a href='/brand/" + item.toUserSeq + "'>" + item.nickname + "</a></td>";
        htmlStr += "<td>" + proposalDetail + "</td>";
        htmlStr += "<td>" + proposalDate + "</td>";
        htmlStr += "<td>" + item.status + "</td>";
        htmlStr += "</tr>";
      });
      $("#proposalListHtml").html(htmlStr);


    }


    // 확정 리스트 전송 함수
    function finalList(page, selectedValue) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };
      let apiUrl = selectedValue === 'APPLY'
          ? "/api/store/experience/final-apply-list"
          : "/api/store/experience/final-proposal-list";
      return new Promise((resolve, reject) => {
        $.ajax({
          type: "GET",
          url: apiUrl,
          data: $.param(sendData),
          contentType: "application/x-www-form-urlencoded",
          dataType: "json",
          success: function (response) {
            let paginationInfo = response.paginationInfo;
            if (selectedValue === 'APPLY') {
              renderFinalApplyList(response.storeFinalApplyList);
              $(".title-header").show();
              $(".proposal-header").hide();
            } else if (selectedValue === 'PROPOSAL') {
              renderFinalProposalList(response.storeFinalProposalList);
              $(".title-header").hide();
              $(".proposal-header").show();
            }
            initializePagination(paginationInfo, 'final');
            resolve(response);

            $(".status-checkbox").on("change", function () {
              let isChecked = $(this).is(":checked");
              let row = $(this).closest("tr");
              let statusFinal = row.find(".status-apply");
              // 상태 업데이트
              if (isChecked) {
                statusFinal.text("ACCEPTED");
              } else {
                statusFinal.text("SENT");
              }
              let experienceSeq = row.find("td[data-id]").data("id"); // 경험 ID 추출
              updateApplyStatus(experienceSeq, isChecked ? "ACCEPTED" : "SENT");
            });
          },
          error: function (response) {
            reject(response);
            console.error("[ERROR] 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
          }
        });
      });
    }
    // 확정 -- 지원 리스트 렌더링 함수
    function renderFinalApplyList(storeFinalApplyList) {
      let htmlStr = "";
      $.map(storeFinalApplyList, function (item) {
        let experienceDateFormat = item.experienceDate ? dayjs(item.experienceDate).format(
            'YYYY-MM-DD') : "날짜를 입력하세요";
        htmlStr += "<tr>";
        htmlStr += "<td data-id='" + item.experienceSeq + "'><a href='/brand/" + item.fromUserSeq
            + "'>" + item.nickname + "</a></td>";
        htmlStr += "<td class='title-cell'><a href='/mojip/" + item.fromPostSeq + "'>" + item.title
            + "</a></td>";
        htmlStr += "<td>" + experienceDateFormat + "</td>";
        htmlStr += "<td><button class='status-button' data-action='DONE' data-id='" + item.experienceSeq + "'>확정</button>" +
            "<button class='status-button' data-action='NOSHOW' data-id='" + item.experienceSeq + "'>노쇼</button></td>";
        htmlStr += "<td class='status-accepted'>" + item.status + "</td>";
        htmlStr += "</tr>";
      });
      $("#finalListHtml").html(htmlStr);
    }

    // 확정 -- 제안 리스트 렌더링 함수
    function renderFinalProposalList(storeFinalProposalList) {
      let htmlStr = "";
      $.map(storeFinalProposalList, function (item) {
        let experienceDateFormat = item.experienceDate
            ? dayjs(item.experienceDate).format("YYYY-MM-DD")
            : "";

        htmlStr += "<tr>";
        htmlStr += "<td><a href='/brand/" + item.toUserSeq + "'>" + item.nickname + "</a></td>";
        htmlStr += "<td class='proposal-cell''>" + item.proposalDetail + "</td>";
        htmlStr +=
            "<td class='experience-date'>" +
            "<input type='date' class='form-control date-picker' data-id='" +
            item.experienceSeq +
            "' value='" +
            experienceDateFormat +
            "'>" +
            "<input type='button' class='confirm-date-btn' value='확인'/>" +
            "</td>";
        htmlStr += "<td><button class='status-button' data-action='DONE' data-id='" + item.experienceSeq + "'>확정</button>" +
            "<button class='status-button' data-action='NOSHOW' data-id='" + item.experienceSeq + "'>노쇼</button></td>";
        htmlStr += "<td class='status-accepted'>" + item.status + "</td>";
        htmlStr += "</tr>";
      });
      $("#finalListHtml").html(htmlStr);

      function updateExperienceDate(experienceSeq, selectedDate) {
        $.ajax({
          type: "POST",
          url: "/api/store/experience/experience-date-update?experienceSeq="+experienceSeq+"&experienceDate="+selectedDate,
          success: function (response) {
            alert("날짜가 성공적으로 업데이트되었습니다.");
          },
          error: function () {
            console.error("[ERROR] 날짜 업데이트에 실패했습니다.");
          },
        });
      }

      $(".confirm-date-btn").on("click", function () {
        let parentRow = $(this).closest("tr");
        let selectedDate = parentRow.find(".date-picker").val();
        let experienceSeq = parentRow.find(".date-picker").data("id");

        if (selectedDate && experienceSeq) {
          updateExperienceDate(experienceSeq, selectedDate);
        } else {
          console.error("[ERROR] experienceSeq 또는 날짜가 올바르지 않습니다.");
        }
      });



    }


    $(document).off("click", ".status-button").on("click", ".status-button", function() {
      let experienceSeq = $(this).data("id");
      let action = $(this).data("action");
      experienceStatusUpdate(experienceSeq, action);
    });


    //확정자 > 지원
    function experienceDateUpdate(experienceSeq, status) {
      $.ajax({
        type: "POST",
        url: "/api/store/experience/experience-date-update?status=" + status + "&experienceSeq=" + experienceSeq,
        success: function(response) {
          alert("상태가 성공적으로 업데이트되었습니다.");
        },
        error: function() {
          console.error("[ERROR] 지원자 상태값을 수정할 수 없습니다.");
        }
      });
    }
    // 확정자 > 제안
    function experienceStatusUpdate(experienceSeq, status) {
      $.ajax({
        type: "POST",
        url: "/api/store/experience/experience-update-status?status=" + status + "&experienceSeq=" + experienceSeq,
        success: function(response) {
          alert("상태가 성공적으로 업데이트되었습니다.");
        },
        error: function() {
          console.error("[ERROR] 제안자 상태값을 수정할 수 없습니다.");
        }
      });
    }


    // 리뷰 리스트
    function reviewList(page) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/store/experience/review-list",
        data: sendData,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let { storeReviewList, paginationInfo } = response;
          renderReviewList(storeReviewList);
          initializePagination(paginationInfo, 'review');

        }
      });
    }
    // 리뷰 리스트 랜더링 함수
    function renderReviewList(storeReviewList) {
      let htmlStr = "";
      $.map(storeReviewList, function (item) {
        let visitDate = dayjs(item.visitDate).format('YYYY-MM-DD');
        let createdAt = item.createdAt ? dayjs(item.createdAt).format('YYYY-MM-DD') : "";
        let encodedUrl = item.url ? encodeURIComponent(item.url) : "";
        htmlStr += "<tr>";
        htmlStr += "<td data-customer-id='" + item.customerSeq + "'><a href='/brand/" + item.customerSeq
            + "'>" + item.nickname + "</a></td>";
        htmlStr += "<td>" + visitDate + "</td>";
        htmlStr += "<td class='status-review'>" + item.status + "</td>";
        htmlStr += "<td><a href='" + encodedUrl + "'>" + encodedUrl + "</a></td>";
        htmlStr += "<td>" + createdAt + "</td>";
        htmlStr += "<td><button class='status-hidden' data-id='" + item.seq
            + "'>숨김</button></td>";
        htmlStr += "</tr>";
      });
      $("#reviewListHtml").html(htmlStr);

      $(document).off("click", ".status-hidden").on("click", ".status-hidden", function() {
        let seq = $(this).data("id");
        if (seq !== undefined) {
          let status = 'STORE_HIDDEN';
          updateReviewStatus(seq, status);
        } else {
          console.error("[ERROR] experienceSeq is undefined.");
        }
      });
    }
    // 리뷰 리스트 status function
    function updateReviewStatus(seq, status) {
      $.ajax({
        type: "POST",
        url: "/api/store/experience/review-hidden?seq="+seq+"&status="+status,
        // data : { 'customerSeq': seq, 'status' : status },
        success: function (response) {
          alert("숨김 처리 되었습니다.");
        },
        error: function () {
          console.error("[ERROR] 리뷰 상태값을 수정할 수 없습니다.");
        }
      });
    }


    //페이지 변경 핸들러
    function handlePageChange(location, page) {
      if (location === 'apply') {
        applyList(page);
      } else if (location === 'proposal') {
        proposalList(page);
      } else if (location === 'review') {
        reviewList(page);
      } else if (location === 'final') { // 찜
        finalList(page, selectedValue)
        .then(response => {
          if (selectedValue === 'APPLY') {
            renderFinalApplyList(response.storeFinalApplyList);
          } else if (selectedValue === 'PROPOSAL') {
            renderFinalProposalList(response.storeFinalProposalList);
          } else {
            console.error("[Not Found!] 데이터를 찾을 수 없습니다. 다시 시도해주세요.");
          }
          initializePagination(response.paginationInfo, 'proposal');
        })
        .catch(error => {
          console.error("[ERROR] 데이터가 정상적이지 않습니다. 다시 시도해주세요.");
        });

      }
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
    applyList(1, selectedValue);
    // 확정자 리스트 초기 로드
    finalList(1, selectedValue);
    // 확정자 리스트 탭 클릭시, 우선 순위
    $("input[name='code']").on('change', function () {
      selectedValue = $(this).val();
      finalList(1, selectedValue);
    });
    // proposal 탭 클릭시,
    $("#proposal-tab").on('click', function () {
      proposalList(1);
    });
    // review 탭 클릭시,
    $("#review-tab").on('click', function () {
      reviewList(1);
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



  });
</script>


</body>

</html>