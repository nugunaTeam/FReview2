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

    <!-- Day.js -->
    <script src="https://cdn.jsdelivr.net/npm/dayjs@1.10.7/dayjs.min.js"></script>

    <style>

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

      .card-body-y {
        padding: 20px 20px;
      }

      .card-title-y {
        padding: 10px 0px 5px 0;
        font-size: 16px;
        font-weight: 500;
        color: #012970;
        font-family: "Poppins", sans-serif;
      }

      .text-header-y{
        font-size: 14px;
        font-weight: bold;
      }
      .text-body-y {
        font-size: 14px;
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
</head>

<body>

<!-- ======= Header ======= -->
<jsp:include page="/header.jsp" />

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="/my/brand">
                <i class="bi bi-award"></i>
                <span>브랜딩</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/experience">
                <i class="bi bi-grid"></i>
                <span>체험</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/activity">
                <i class="bi bi-card-checklist"></i>
                <span>활동</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link"
               href="${pageContext.request.contextPath}/store/notification">
                <i class="bi bi-bell"></i>
                <span>알림</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/personal-info">
                <i class="bi bi-person"></i>
                <span>개인정보수정</span>
            </a>
        </li>
    </ul>


</aside><!-- End Sidebar-->
<main id="main" class="main">

    <section class="section">
        <div class="row">
            <div class="col-lg-12">

                <div class="card">
                    <div class="card-body">
                        <%--                        <h5 class="card-title">Bordered Tabs</h5>--%>
                        <ul class="nav nav-tabs nav-tabs-bordered pt-4" id="borderedTab"
                            role="tablist">
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active" id="like-tab" data-bs-toggle="tab"
                                        data-bs-target="#received-like" type="button" role="tab"
                                        aria-controls="like" aria-selected="true">좋아요
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="zzim-tab" data-bs-toggle="tab"
                                        data-bs-target="#received-zzim" type="button" role="tab"
                                        aria-controls="zzim" aria-selected="false">찜
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="experience-tab" data-bs-toggle="tab"
                                        data-bs-target="#experience-list" type="button" role="tab"
                                        aria-controls="post" aria-selected="false">체험
                                </button>
                            </li>
                        </ul>
                        <div class="tab-content pt-4" id="borderedTabContent">

                            <!-- 내가 좋아요 한 글 -->
                            <div class="tab-pane fade show active" id="received-like"
                                 role="tabpanel"
                                 aria-labelledby="like-tab">
                                <div id="likeListHtml"></div>
                                <!-- 페이지네이션 버튼 -->
                                <div class="pagination-container" id="like-pagination"></div>
                            </div>

                            <!-- 나를 찜한 다른 유저 리스트 -->
                            <div class="tab-pane fade" id="received-zzim" role="tabpanel"
                                 aria-labelledby="zzim-tab">
                                <div>
                                    <div class="pb-4">
                                        <input type="radio" id="customerZzim" name="code" value="CUSTOMER" checked /> 체험단
                                        <input type="radio" id="storeZzim" name="code" value="STORE" /> 스토어
                                    </div>
                                    <div id="receivedZzimListHtml" class="row"></div>
                                    <!-- 페이지네이션 버튼 -->
                                    <div class="pagination-container" id="zzim-pagination"></div>
                                </div>
                            </div>

                            <!-- 체험 관련 알림 -->
                            <div class="tab-pane fade" id="experience-list" role="tabpanel"
                                 aria-labelledby="experience-tab">
                                <div>
                                    <div class="pb-4">
                                        <input type="radio" name="exp" value="apply" checked /> 지원자
                                        <input type="radio" name="exp" value="proposal" /> 제안자
                                    </div>
                                    <div id="experienceListHtml" ></div>
                                    <!-- 페이지네이션 버튼 -->
                                    <div class="pagination-container" id="experience-pagination"></div>
                                </div>
                            </div>
                        </div><!-- End Bordered Tabs -->

                    </div>
                </div>
            </div>
        </div>
    </section>

</main>

<script>
  $(document).ready(function () {
    let userSeq = '${userSeq}';
    let zzimSelectedValue = $("input[name='code']:checked").val() || 'CUSTOMER';    // default
    let experienceSelectedValue = $("input[name='exp']:checked").val() || 'apply' ;   // default

    receivedLikeList(1);

    // 알림 > 좋아요 전송 함수
    function receivedLikeList(page) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };
      $.ajax({
        method: "GET",
        url: "/api/store/notification/received-like",
        data: $.param(sendData),
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        error: function (response) {
          console.error("[error] 좋아요 리스트 데이터를 불러오던 도중 문제가 발생했습니다.");
        },
        success: function (response) {
          let { paginationInfo, receivedLikeInfo } = response;
          renderLikeData(receivedLikeInfo);
          initializePagination(paginationInfo, 'like');
        }
      });
    }

    function renderLikeData(receivedLikeInfos) {
      let htmlStr = "";
        $.map(receivedLikeInfos, function (item) {
          let formattedLikeDate = dayjs(item.createdAt).format('YYYY년 MM월 DD일');
          if (item.postCode === '모집') {
            htmlStr += "<div class='card' id='receivedLikeList'>";
            htmlStr += "<div class='card-body-y'>";
            htmlStr += "<h6 class='card-title-y'><a href='/brand/" + item.likedUserSeq + "'>"+ item.nickname +"</a>님이 ";
            htmlStr += "<a href='/mojip/" + item.postSeq + "'>내 글</a>을 좋아합니다.</h6>";
            htmlStr += "<p class='p-last'>" + formattedLikeDate + "</p>";
            htmlStr += "</div></div>";
          }
        });
      $('#likeListHtml').empty().html(htmlStr);
    }

    function handlePageChange(location, page) {
      if (location === 'like') {
        receivedLikeList(page);
      } else if (location === 'zzim') {
        receivedZzimList(page, zzimSelectedValue).then(response => {
          if (zzimSelectedValue === 'CUSTOMER') {
            renderZzimCustomerList(response.receivedZzimCustomerInfo);
          } else if (zzimSelectedValue === 'STORE') {
            renderZzimStoreList(response.receivedZzimStoreInfo);
          } else {
            console.error("[Not Found!] 데이터를 찾을 수 없습니다. 다시 시도해주세요.");
          }
          initializePagination(response.paginationInfo, 'zzim');
        }).catch(err => {
          console.error("[ERROR] 찜 리스트 데이터를 불러오던 도중 문제가 발생했습니다.", err);
        });
      } else if (location === 'experience') {
        receivedExperienceList(page, experienceSelectedValue).then(response => {
          if (experienceSelectedValue === 'apply') {
            renderExperienceApply(response.experienceApplyInfo);
          } else if (experienceSelectedValue === 'proposal') {
            renderExperienceProposal(response.experienceProposalInfo);
          } else {
            console.error("[Not Found!] 데이터를 찾을 수 없습니다. 다시 시도해주세요.");
          }
          initializePagination(response.paginationInfo, 'experience');
        }).catch(err => {
          console.error("[error] 체험 리스트 데이터를 불러오던 도중 문제가 발생했습니다.", err);
        });
      }
    }

    function receivedZzimList(page, zzimSelectedValue) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };
      let apiUrl = zzimSelectedValue === 'CUSTOMER'
          ? "/api/store/notification/received-zzim-customer"
          : "/api/store/notification/received-zzim-store";
      return new Promise((resolve, reject) => {
        $.ajax({
          method: "GET",
          url: apiUrl,
          data: $.param(sendData),
          contentType: "application/x-www-form-urlencoded",
          dataType: "json",
          success: function (response) {
            let paginationInfo = response.paginationInfo;
            if (zzimSelectedValue === 'CUSTOMER') {
              let receivedZzimCustomerInfo = response.receivedZzimCustomerInfo;
              renderZzimCustomerList(receivedZzimCustomerInfo);
            } else if (zzimSelectedValue === 'STORE') {
              let receivedZzimStoreInfo = response.receivedZzimStoreInfo;
              renderZzimStoreList(receivedZzimStoreInfo);
            }
            initializePagination(paginationInfo, 'zzim');
            resolve(response);
          },
          error: function (response) {
            reject(response);
            console.error("[error] 찜 리스트 데이터를 불러오던 도중 문제가 발생했습니다. ");
          }
        });
      });
    }

    function renderZzimCustomerList(receivedZzimCustomerInfo) {
      let htmlStr = "";
      $.map(receivedZzimCustomerInfo, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y mt-2'>";
        htmlStr += "<p><a href='/brand/" + item.zzimUserSeq + "'>" + item.nickname
            + "</a>님이 나를 찜 하였습니다.</p>";
        htmlStr += "<p class='p-last'>분야 : " + item.foodTypes + "</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#receivedZzimListHtml").html(htmlStr);
    }
    // 찜 > 스토어 리스트 랜더링 함수
    function renderZzimStoreList(receivedZzimStoreInfo) {
      let htmlStr = " ";
      $.map(receivedZzimStoreInfo, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y'>";
        htmlStr += "<p><a href='/brand/" + item.zzimUserSeq + "'>"
            + item.nickname + "</a>님이 나를 찜하였습니다.</p>";
        htmlStr += "<p>스토어 위치 : " + item.storeLocation + "</p>";
        htmlStr += "<p class='p-last'>분야 : " + item.foodTypes + "</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $('#receivedZzimListHtml').html(htmlStr);
    }


    // 체험 리스트 전송 함수
    function receivedExperienceList(page, experienceSelectedValue) {
      let sendData = {
        'userSeq': userSeq,
        'currentPage': page
      };
      let apiUrl = experienceSelectedValue === 'apply'
          ? "/api/store/notification/experience-apply"
          : "/api/store/notification/experience-proposal";
      return new Promise((resolve, reject) => {
        $.ajax({
          method: "GET",
          url: apiUrl,
          data: $.param(sendData),
          contentType: "application/x-www-form-urlencoded",
          dataType: "json",
          success: function (response) {
            let paginationInfo = response.paginationInfo;
            if (experienceSelectedValue === 'apply') {
              let experienceApplyInfo = response.experienceApplyInfo;
              renderExperienceApply(experienceApplyInfo)
            } else if (experienceSelectedValue === 'proposal') {
              let experienceProposalInfo = response.experienceProposalInfo;
              renderExperienceProposal(experienceProposalInfo);
            }
            initializePagination(paginationInfo, 'experience');
            resolve(response);
          },
          error: function (response) {
            console.error("[error] 체험 리스트 데이터를 불러오던 도중 문제가 발생했습니다.");
            reject(response);
          }
        });
      });
    }

    function renderExperienceApply(experienceApplyInfo) {
      let htmlStr = "";
      $.map(experienceApplyInfo, function (item) {
        let formattedCreatedAt = dayjs(item["createdAt"]).format('YYYY년 MM월 DD일');
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y'>";
        htmlStr += "<p><a href='/brand/" + item.fromUserSeq + "'>"
            + item.nickname + "</a>님이 <a href='/mojip/"+ item.postSeq + "'>내 모집글</a>에 지원하였습니다.</p>";
        htmlStr += "<p class='p-last'>"+ formattedCreatedAt +"</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#experienceListHtml").html(htmlStr);
    }

    function renderExperienceProposal(experienceProposalInfo) {
      let htmlStr = "";
      $.map(experienceProposalInfo, function (item) {
        let formattedCreatedAt = dayjs(item["createdAt"]).format('YYYY년 MM월 DD일');
        let status = item.status === 'REJECTED' ? '거절' :
                    item.status === 'ACCEPTED' ? '승낙' : '미확인';
        if (status !== '미확인') {
            htmlStr += "<div class='card'>";
            htmlStr += "<div class='card-body-y'>";
            htmlStr += "<p><a href='/brand/" + item.proposalUserSeq + "'>"
              + item.nickname + "</a>님에게 체험 제안을 " + status + " 하였습니다.</p>";
            htmlStr += "<p class='text-header-y' >제안내용 : </p><p class='text-body-y'>"
              + item.proposalDetail + "</p>";
            htmlStr += "<p class='p-last'>" + formattedCreatedAt + "</p>";
            htmlStr += "</div>";
            htmlStr += "</div>";
        }
      });
      $("#experienceListHtml").html(htmlStr);
    }

    //페이지네이션 처리.
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
          paginationHTML += '<button class="btn ' + (i == currentPage ? 'btn-secondary'
              : 'btn-primary') + ' edit-btn" data-page="' + i + '">' + i + '</button>';
        }

        if (hasNext) {
          paginationHTML += '<button id="next-block-button" class="btn btn-primary edit-btn" data-page="'
              + (currentPage + 1) + '">&gt;</button>';
        }

        paginationContainer.html(paginationHTML);

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

    $("input[name='code']").on('change', function () {
      zzimSelectedValue = $(this).val();
      receivedZzimList(1, zzimSelectedValue);
    });

    $("input[name='exp']").on('change', function () {
      experienceSelectedValue = $(this).val();
      receivedExperienceList(1, experienceSelectedValue);
    });

    // 찜 탭 클릭 시, 우선 순위
    $("#zzim-tab").on('click', function () {
      receivedZzimList(1, zzimSelectedValue);
    });

    $("#experience-tab").on('click', function () {
      receivedExperienceList(1, experienceSelectedValue);
    });

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

</body>
<!-- ======= Footer ======= -->
<jsp:include page="/footer.jsp" />

</html>







