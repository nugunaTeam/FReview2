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
      .bi-heart-fill {
        color: red;
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
<header id="header" class="header fixed-top d-flex align-items-center header-hr">
    <div class="d-flex align-items-center justify-content-between ">
        <a href="/main?seq=${userSeq}&pagecode=Requester"
           class="logo d-flex align-items-center">
            <img src="/assets/img/logo/logo-vertical.png" alt=""
                 style="  width: 50px; margin-top: 20px;">
            <span class="d-none d-lg-block">FReview</span>
        </a>
    </div>
    <div class="header-hr-right">
        <a href="/my-info?user_seq=${userSeq}" style="margin-right: 20px">
            ${nickname}
            <img src="${profileUrl}" alt=" " style="width: 30px; margin-top: 15px;">
        </a>
        <a href="/COMM_logout.jsp" style="margin-top: 17px;">로그아웃</a>
    </div>
</header>

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="/store/my/brand-info?userSeq=${userSeq}">
                <i class="bi bi-award"></i>
                <span>브랜딩</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/experience?userSeq=${userSeq}">
                <i class="bi bi-grid"></i>
                <span>체험</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/activity?userSeq=${userSeq}">
                <i class="bi bi-card-checklist"></i>
                <span>활동</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link"
               href="${pageContext.request.contextPath}/store/notification?userSeq=${userSeq}">
                <i class="bi bi-bell"></i>
                <span>알림</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/store/my-info?userSeq=${userSeq}">
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
                                <button class="nav-link" id="post-tab" data-bs-toggle="tab"
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
                                <form id="likeList">
                                </form>
                            </div>

                            <!-- 나를 찜한 다른 유저 리스트 -->
                            <div class="tab-pane fade" id="received-zzim" role="tabpanel"
                                 aria-labelledby="zzim-tab">
                                <form>
                                    <div class="pb-4">
                                        <label>
                                            <input type="radio" name="code" value="customer"
                                                   onclick="receivedZzimList('CUSTOMER')" checked/>체험단
                                        </label>
                                        <label class="m-lg-2">
                                            <input type="radio" name="code" value="store"
                                                   onclick="receivedZzimList('STORE')"/> 스토어
                                        </label>
                                    </div>
                                </form>
                                <form id="zzimList">

                                </form>
                            </div>

                            <!-- 체험 관련 알림 -->
                            <div class="tab-pane fade" id="experience-list" role="tabpanel"
                                 aria-labelledby="experience-tab">
                                <form>
                                    <div class="pb-4">
                                        <label>
                                            <input type="radio" name="code" value="apply"
                                                   onclick="receivedValue('apply')" checked/>지원자
                                        </label>
                                        <label class="m-lg-2">
                                            <input type="radio" name="code" value="propose"
                                                   onclick="receivedValue('propose')"/> 제안자
                                        </label>
                                    </div>
                                </form>
                                <form id="experienceList">

                                </form>
                            </div>
                        </div><!-- End Bordered Tabs -->

                    </div>
                </div>
            </div>
        </div>
    </section>

</main><!-- End #main -->

<script>
  $(document).ready(function () {
    let userSeq = ${userSeq};

    // 알림 > 좋아요
    let likeUrl = "/api/store/notification/received-like";
    $.ajax({
      method: "GET",
      url: likeUrl,
      data: { userSeq: userSeq },
      dataType: "json",
      error: function() {
        console.error("[error] 좋아요 리스트 데이터를 불러오던 도중 문제가 발생했습니다.");
      },
      success: function(response) {
        renderLikeData(response);
      }
    });
    // 알림 > 좋아요 - data
    function renderLikeData(response) {
      let htmlStr = "";

      response.forEach(function(item) {
        let cutTitle = item.title.length > 30 ? item.title.substring(0, 30) + '...' : item.title;
        let cutContent = item.content.length > 30 ? item.content.substring(0, 30) + '...' : item.content;
        let formattedLikeDate = dayjs(item.createdAt).format('YYYY년 MM월 DD일');
        if(item.postCode === '모집') {
          htmlStr += "<div class='card' id='receivedLikeList'>";
          htmlStr += "<div class='card-body-y'>";
          htmlStr += "<h6 class='card-title-y'>";
          htmlStr += "<a href='/mojip/" + item.userSeq + "'>" + cutTitle + "</a></h6>";
          htmlStr += "<p>" + cutContent + "</p>";
          htmlStr += "<p class='p-last'>" + formattedLikeDate + "&nbsp;<i class='bi bi-heart-fill'></i>&nbsp;" + item.likeCount + "</p>";
          htmlStr += "</div></div>";
        }
      });

      $('#likeList').append(htmlStr);
    }


    // 알림 > 찜
    window.receivedZzimList = function (value) {
      let zzimUrl = "/api/store/notification/received-zzim";
      let formdata = {
        code: value,
        userSeq: userSeq
      };
      $.ajax({
        method: "GET",
        url: zzimUrl,
        data: formdata,
        dataType: "json",
        error: function () {
          console.error("[error] 찜 리스트 데이터를 불러오던 도중 문제가 발생했습니다. ");
        },
        success: function (response) {
            $('#zzimList').html('');
          if (value === "CUSTOMER") {
            let zzimCustomersList = response.zzimCustomers;
            renderZzimCustomerData(zzimCustomersList);
          } else {
            let zzimStoresList = response.zzimStores;
            renderZzimStoreData(zzimStoresList);
          }
        }
      });
    }
    // 알림 > 찜 > 체험단
    function renderZzimCustomerData(response) {
      let htmlStr = "";
      $.map(response, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y'>";
        htmlStr += "<p><a href='/store/brand-info?userSeq=" + item.zzimUserSeq + "'>"
            + item.nickname + "</a>님이 나를 찜하였습니다.</p>";
        htmlStr += "<p class='p-last'>분야 : "+ item.foodTypes + "</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
    $('#zzimList').append(htmlStr);
    }
    // 알림 > 찜 > 스토어
    function renderZzimStoreData(response) {
      let htmlStr = " ";
      $.map(response, function (item) {
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y'>";
        htmlStr += "<p><a href='/store/my/brand-info?userSeq=" + item.zzimUserSeq + "'>"
            + item.nickname + "</a>님</p>";
        htmlStr += "<p>스토어 위치 : "+ item.storeLocation +"</p>";
        htmlStr += "<p class='p-last'>분야 : "+ item.foodTypes + "</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $('#zzimList').append(htmlStr);
    }
    window.receivedZzimList('CUSTOMER');


    // 알림 > 체험
    window.receivedValue = function (value) {
      let expUrl = "/api/store/notification/experience-list";
      let formdata = {
        code: value,
        userSeq: userSeq
      };
      $.ajax({
        method: "POST",
        url: expUrl,
        data: JSON.stringify(formdata),
        contentType: "application/json",
        dataType: "json",
        error: function () {
          console.error("[error] 체험 지원/제안 리스트 데이터를 불러오던 도중 문제가 발생했습니다. ");
        },
        success: function (response) {
          $('#experienceList').html('');
          if (value === "apply") {
            let applyList = response.applyList;
            renderApplyData(applyList);
          } else {
            let proposeList = response.proposeList;
            renderProposeData(proposeList);
            proposeList.forEach(function(item) {
              console.log(item);
            });
          }
        }
      });
    };
    // 알림 > 체험 > 지원
    function renderApplyData(response) {
      let htmlStr = "";
      $.map(response, function (item) {
        let formattedCreatedAt = dayjs(item["createdAt"]).format('YYYY년 MM월 DD일');

        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body-y'>";
        htmlStr += "<p><a href='/store/my/brand-info?userSeq=" + item.fromUserSeq + "'>"
            + item.nickname + "</a>님이 <a href='/mojip/"+ item.postSeq + "'>" + item.title + "</a>에 지원하였습니다.</p>";
        htmlStr += "<p class='p-last'>"+ formattedCreatedAt +"</p>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $("#experienceList").empty().append(htmlStr);
    }
    // 알림 > 체험 > 제안
    function renderProposeData(response) {
      let htmlStr = "";
      $.map(response, function (item) {
        let formattedCreatedAt = dayjs(item["createdAt"]).format('YYYY년 MM월 DD일');
        let status = item.status === 'REJECTED' ? '거절' :
                    item.status === 'ACCEPTED' ? '승낙' : '미확인';
        if (status !== '미확인') { // '미확인'인 경우 제외
            htmlStr += "<div class='card'>";
            htmlStr += "<div class='card-body-y'>";
            htmlStr += "<p><a href='/store/my/brand-info?userSeq=" + item.toUserSeq + "'>"
              + item.nickname + "</a>님이 체험 제안을 " + status + " 하였습니다.</p>";
            htmlStr += "<p class='text-header-y' >제안내용 : </p><p class='text-body-y'>"
              + item.proposeDetail + "</p>";
            htmlStr += "<p class='p-last'>" + formattedCreatedAt + "</p>";
            htmlStr += "</div>";
            htmlStr += "</div>";
        }
      });
      $("#experienceList").empty().append(htmlStr);
    }
    window.receivedValue('apply');


  });
</script>


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

</body>

</html>







