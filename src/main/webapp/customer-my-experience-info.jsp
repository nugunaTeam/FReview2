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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
</head>

<body>

<jsp:include page="/header.jsp" />

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item">
            <a class="nav-link collapsed"
               href="/my/brand-info">
                <i class="bi bi-grid"></i>
                <span>브랜딩</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link"
               href="${pageContext.request.contextPath}/my/experience">
                <i class="bi bi-card-checklist"></i>
                <span>체험</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed "
               href="${pageContext.request.contextPath}/my/activity">
                <i class="bi bi-bell"></i>
                <span>활동</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/my/notification">
                <i class="bi bi-card-checklist"></i>
                <span>알림</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/my/personal-info">
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
                                <button class="nav-link active" id="my-applied-experience-tab"
                                        data-bs-toggle="tab" data-bs-target="#my-applied-experience"
                                        type="button" role="tab" aria-selected="true">지원 리스트
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="proposal-to-me-experience-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#proposal-to-me-experience" type="button"
                                        role="tab" aria-selected="false">제안 리스트
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="my-accepted-experience-tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#my-accepted-experience" type="button"
                                        role="tab" aria-selected="false">수락 리스트
                                </button>
                            </li>
                        </ul>

                        <div class="tab-content pt-4" id="borderedTabContent">
                            <!-- 나의 모집 지원 리스트 -->
                            <div class="tab-pane fade show active" id="my-applied-experience"
                                 role="tabpanel" aria-labelledby="my-applied-experience-tab">
                                <div id="myAppliedExperienceList" class="row">
                                    <!-- 내가 지원한 체험 리스트가 렌더링 -->
                                </div>
                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container"
                                     id="my-applied-experience-pagination"></div>
                            </div>

                            <!-- 나에게 온 체험 제안 리스트 -->
                            <div class="tab-pane fade" id="proposal-to-me-experience"
                                 role="tabpanel" aria-labelledby="proposal-to-me-experience-tab">
                                <div id="proposalToMeExperienceList" class="row">
                                    <!-- 나에게 제안 온 체험 리스트가 렌더링 -->
                                </div>
                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container"
                                     id="proposal-to-me-experience-pagination"></div>
                            </div>

                            <!-- 내가 수락한 체험 리스트 -->
                            <div class="tab-pane fade" id="my-accepted-experience" role="tabpanel"
                                 aria-labelledby="my-accepted-experience-tab">
                                <div>
                                    <div class="pb-4">
                                        <input type="radio" id="is-experience-apply"
                                               name="isExperienceByApplies" value="true" checked/>
                                        지원
                                        <input type="radio" id="is-experience-proposal"
                                               name="isExperienceByApplies" value="false"/> 제안
                                    </div>
                                </div>
                                <div id="myAcceptedExperienceList" class="row"></div>
                                <!-- 내가 수락한 체험 리스트가 렌더링 -->

                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container"
                                     id="my-accepted-experience-pagination"></div>
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

    sendMyAppliedExperienceList(1);

    // 지원 리스트 탭 클릭 시 데이터 요청
    $("#my-applied-experience-tab").on('click', function () {
      sendMyAppliedExperienceList(1);
    });

    // 제안 리스트 탭 클릭 시 데이터 요청
    $("#proposal-to-me-experience-tab").on('click', function () {
      sendProposalToMeExperienceList(1);
    });

    // 수락 리스트 탭 클릭 시 데이터 요청
    $("#my-accepted-experience-tab").on('click', function () {
      // 기본적으로 "체험" 라디오 버튼을 클릭한 상태로 설정
      $('#is-experience-apply').prop('checked', true);
      sendMyAcceptedApplyList(1);
    });

    // "체험" 라디오 버튼 클릭 시 데이터 요청
    $('#is-experience-apply').on('change', function () {
      sendMyAcceptedApplyList(1);
    });

    // "제안" 라디오 버튼 클릭 시 데이터 요청
    $('#is-experience-proposal').on('change', function () {
      sendMyAcceptedProposalList(1);
    });

    // 지원 리스트 전송 함수
    function sendMyAppliedExperienceList(page) {
      let sendData = {
        'targetPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/customer/my/experience/apply-list",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 지원 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, applyInfos} = response;
          renderMyAppliedExperienceList(applyInfos);
          initializePagination(paginationInfo, 'my-applied-experience');
        }
      });
    }

    // 제안 리스트 전송 함수
    function sendProposalToMeExperienceList(page) {
      let sendData = {
        'targetPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/customer/my/experience/proposal-list",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 제안 리스트 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, proposalInfos} = response;
          renderProposalToMeExperienceList(proposalInfos);
          initializePagination(paginationInfo, 'proposal-to-me-experience');
        }
      });
    }

    // 수락 리스트(체험) 데이터 요청 함수
    function sendMyAcceptedApplyList(page) {
      let sendData = {
        'targetPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/customer/my/experience/accepted-apply-list",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 수락 리스트(체험) 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, myAcceptedApplyInfos} = response;
          renderMyAcceptedApplyList(myAcceptedApplyInfos);
          initializePagination(paginationInfo, 'my-accepted-experience');
        }
      });
    }

    // 수락 리스트(제안) 데이터 요청 함수
    function sendMyAcceptedProposalList(page) {
      let sendData = {
        'targetPage': page
      };
      $.ajax({
        type: "GET",
        url: "/api/customer/my/experience/accepted-proposal-list",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[ERROR] 수락 리스트(제안) 불러오기 실패하였습니다. 다시 시도해주세요.");
        },
        success: function (response) {
          let {paginationInfo, acceptedProposalInfos} = response;
          renderMyAcceptedProposalList(acceptedProposalInfos);
          initializePagination(paginationInfo, 'my-accepted-experience');
        }
      });
    }

    // 지원 리스트 렌더링 함수
    function renderMyAppliedExperienceList(applyInfos) {
      let htmlStr = "";
      $.map(applyInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y mt-2'>";
        htmlStr += "<p><a href='/brand/" + item.storeSeq + "'>" + item.storeName
            + "</a>님의 <a href='/mojip/" + item.postSeq + "'>모집글</a>에 지원했습니다.</p>";
        htmlStr += "<p>진행 현황: ";
        if (item.status === 'SENT') {
          htmlStr += "<span style='color:green'>요청 진행중</span>";
        } else if (item.status === 'REJECTED') {
          htmlStr += "<span style='color:mediumvioletred'>거절됨</span>";
        }
        htmlStr += "</p>";
        htmlStr += "<p>지원 날짜: " + item.applyDate.year + "년 " + item.applyDate.monthValue + "월 "
            + item.applyDate.dayOfMonth + "일</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#myAppliedExperienceList").html(htmlStr);
    }

    // 제안 리스트 렌더링 함수
    function renderProposalToMeExperienceList(proposalInfos) {
      let htmlStr = "";
      $.map(proposalInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y mt-2'>";
        htmlStr += "<p><a href='/brand/" + item.storeSeq + "'>" + item.storeName
            + "</a>님으로부터 <span style='color: chocolate'>체험 제안</span>이 왔어요!</p>";
        htmlStr += "<p>제안 내용: " + (item.proposalDetails !== null ? item.proposalDetails : "") + "</p>";
        htmlStr += "<p>진행 현황: ";
        if (item.status === 'REJECTED') {
          htmlStr += "<span style='color:mediumvioletred'>거절함</span>";
        } else if (item.status === 'SENT') {
          htmlStr += "<button class='btn btn-success accept-btn' data-experience-seq='"
              + item.experienceSeq + "'>수락</button>";
          htmlStr += "<button class='btn btn-danger reject-btn' data-experience-seq='"
              + item.experienceSeq + "'>거절</button>";
        }
        htmlStr += "</p>";
        htmlStr += "<p>제안 날짜: " + item.proposalDate.year + "년 " + item.proposalDate.monthValue
            + "월 "
            + item.proposalDate.dayOfMonth + "일</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#proposalToMeExperienceList").html(htmlStr);
    }

    // 수락 리스트(체험) 렌더링 함수
    function renderMyAcceptedApplyList(myAcceptedApplyInfos) {
      let htmlStr = "";
      $.map(myAcceptedApplyInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y mt-2'>";
        htmlStr += "<p><a href='/brand/" + item.storeSeq + "'>" + item.storeName
            + "</a>님이 내 <a href='/mojip/" + item.postSeq
            + "'><span style='color: green'>체험 지원</span></a>을 수락했습니다.</p>";
        htmlStr += "<p>진행 현황: ";
        if (item.status === 'ACCEPTED') {
          htmlStr += "<span style='color:green'>수락됨</span>";
        } else if (item.status === 'NOSHOW') {
          htmlStr += "<span style='color:mediumvioletred'>노쇼</span>";
        } else if (item.status === 'DONE') {
          htmlStr += "<span style='color:blue'>완료됨</span>";
        }
        htmlStr += "</p>";
        htmlStr += "<p>체험 날짜: " + item.experienceDate.year + "년 " + item.experienceDate.monthValue
            + "월 "
            + item.experienceDate.dayOfMonth + "일</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#myAcceptedExperienceList").html(htmlStr);
    }

    // 수락 리스트(제안) 렌더링 함수
    function renderMyAcceptedProposalList(acceptedProposalInfos) {
      let htmlStr = "";
      $.map(acceptedProposalInfos, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y mt-2'>";
        htmlStr += "<p><a href='/brand/" + item.storeSeq + "'>" + item.storeName
            + "</a>님의 <span style='color:chocolate'>체험 제안</span>을 수락했습니다.</p>";
        htmlStr += "<p>제안 내용: " + item.proposalDetails + "</p>";
        htmlStr += "<p>진행 현황: ";
        if (item.status === 'ACCEPTED') {
          htmlStr += "<span style='color:green'>수락됨</span>";
        } else if (item.status === 'NOSHOW') {
          htmlStr += "<span style='color:mediumvioletred'>노쇼</span>";
        } else if (item.status === 'DONE') {
          htmlStr += "<span style='color:blue'>완료됨</span>";
        }
        htmlStr += "</p>";
        htmlStr += "<p>체험 날짜: " + item.experienceDate.year + "년 " + item.experienceDate.monthValue
            + "월 "
            + item.experienceDate.dayOfMonth + "일</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#myAcceptedExperienceList").html(htmlStr);
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

    // 페이지 버튼 클릭 이벤트
    $(document).on("click", ".btn.edit-btn", function (e) {
      let pageNumber = parseInt($(this).data("page"));
      if (pageNumber > 0) {
        handlePageChange(
            $(this).closest(".pagination-container").attr("id").replace("-pagination", ""),
            pageNumber);
      }
    });

    // 페이지 변경 핸들러
    function handlePageChange(tab, page) {
      currentPage = page;
      if (tab === 'my-applied-experience') {
        sendMyAppliedExperienceList(page);
      } else if (tab === 'proposal-to-me-experience') {
        sendProposalToMeExperienceList(page);
      } else if (tab === 'my-accepted-experience') {
        let isExperienceApply = $('#is-experience-apply').is(':checked');
        if (isExperienceApply) {
          sendMyAcceptedApplyList(page);
        } else {
          sendMyAcceptedProposalList(page);
        }
      }
    }

    // 수락 버튼 클릭 이벤트
    $(document).on("click", ".accept-btn", function (e) {
      let experienceSeq = $(this).data("experience-seq");
      $.ajax({
        type: "POST",
        url: "/api/customer/my/experience/" + experienceSeq + "/accept",
        success: function () {
          alert('해당 체험 제안을 수락했습니다.');
          sendProposalToMeExperienceList(currentPage);
        },
        error: function () {
          alert('수락 처리 중 오류가 발생했습니다. 다시 시도해주세요.');
        }
      });
    });

    // 거절 버튼 클릭 이벤트
    $(document).on("click", ".reject-btn", function (e) {
      let experienceSeq = $(this).data("experience-seq");
      $.ajax({
        type: "POST",
        url: "/api/customer/my/experience/" + experienceSeq + "/reject",
        success: function () {
          alert('해당 체험 제안을 거절했습니다.');
          sendProposalToMeExperienceList(currentPage);
        },
        error: function () {
          alert('거절 처리 중 오류가 발생했습니다. 다시 시도해주세요.');
        }
      });
    });
  });
</script>

</body>

</html>