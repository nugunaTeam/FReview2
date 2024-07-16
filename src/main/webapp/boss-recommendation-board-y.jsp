<%@ page import="com.nuguna.freview.entity.member.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="loginUser" value="${requestScope.loginUser}" />
<c:set var="memberSeq" value="${loginUser.memberSeq}" />
<c:set var="nickname" value="${loginUser.nickname}" />
<c:set var="gubun" value="${loginUser.gubun}" />

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>추천 페이지</title>
    <meta content="" name="description">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/hr.css" rel="stylesheet">

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

    <style>
      .profile-card img {
        border-radius: 0; /* 이미지를 네모로 만듭니다 */
        width: 100%; /* 이미지를 카드의 전체 너비로 설정합니다 */
        max-width: none; /* 이미지를 카드의 전체 너비로 설정합니다 */
      }

      .profile-card {
        padding: 0; /* 카드 내부의 여백을 없앱니다 */
      }

      .col-xl-2 {
        flex: 0 0 auto;
        width: 20%;
      }
    </style>

    <!-- =======================================================
    * Template Name: NiceAdmin
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Updated: Apr 20 2024 with Bootstrap v5.3.3
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->

</head>

<body>

<header id="header" class="header fixed-top d-flex align-items-center header-hr">

    <div class="d-flex align-items-center justify-content-between ">
        <a href="/main?seq=${memberSeq}&pagecode=Requester"
           class="logo d-flex align-items-center">
            <img src="assets/img/logo/logo-vertical.png" alt="" style="  width: 50px; margin-top: 20px;">
            <span class="d-none d-lg-block">FReview</span>
        </a>
    </div>
    <div class="header-hr-right">
        <a href="/my-info?member_seq=${memberSeq}" style="margin-right: 20px">
            ${nickname}
            <img src="assets/img/basic/basic-profile-img.png" alt=" " style="width: 30px;
                margin-top: 15px;">
            <%--            <img src="<%=profileURL()%>" alt=" " style="width: 30px;--%>
            <%--    margin-top: 15px;"> TODO: 세션의 프로필 url을 적용할 것--%>
        </a>
        <a href="COMM_logout.jsp" style="margin-top: 17px;">로그아웃</a>
    </div>

</header>

<main id="main" style="margin:auto; margin-top:50px">
    <div class="pagetitle">
        <h1>사장님 추천페이지</h1>
    </div>

    <section class="section profile">
        <div class="row">
            <div class="tab-pane fade show active" id="boss" role="tabpanel" aria-labelledby="boss-tab">
                <form id="filterForm">
                    <input type="hidden" id="memberGubunCustomer" name="memberGubun" value="B">
                    <div>
                        <h3>음식 유형</h3>
                        <label><input type="checkbox" name="foodType" value="한식"> 한식</label>
                        <label><input type="checkbox" name="foodType" value="양식"> 양식</label>
                        <label><input type="checkbox" name="foodType" value="중식"> 중식</label>
                        <label><input type="checkbox" name="foodType" value="일식"> 일식</label>
                        <label><input type="checkbox" name="foodType" value="빵&베이커리"> 빵&베이커리</label>
                        <label><input type="checkbox" name="foodType" value="기타"> 기타</label>
                    </div>
                    <div>
                        <h3>태그</h3>
                        <label><input type="checkbox" name="tag" value="단체석"> 단체석</label>
                        <label><input type="checkbox" name="tag" value="뷰 맛집"> 뷰 맛집</label>
                        <label><input type="checkbox" name="tag" value="오션뷰"> 오션뷰</label>
                        <label><input type="checkbox" name="tag" value="반려동물 환영"> 반려동물
                            환영</label>
                    </div>
                    <div>
                        <button type="submit">필터링</button>
                    </div>
                </form>
                <br>
                <button id="resetBtn">모든 필터 제거</button>
                <div class="row" id="bossInfo"></div>
                <div class="d-flex justify-content-center">
                    <button class="btn btn-primary" id="loadMoreBtn" data-previous-member-seq="0">더보기</button>
                </div>
            </div>
        </div>
    </section>

</main>

<script>
  $(document).ready(function() {

    loadInitialData();

    $('#filterForm').submit(function(event) {
      event.preventDefault();
      var formData = $(this).serialize();
      loadFilteredData(formData);
    });

    $('#resetBtn').click(function() {
      $('#bossInfo').empty();
      $('input[name="foodType"]').prop('checked', false);
      $('input[name="tag"]').prop('checked', false);
      loadInitialData();
    });

    $('#loadMoreBtn').click(function() {
      var previousMemberSeq = $(this).data('previous-member-seq');
      loadMoreData(previousMemberSeq);
    });

    function loadInitialData() {
      $.ajax({
        method: "POST",
        url: "/recommendation-boss",
        dataType: "json",
        success: function (response) {
          renderData(response.data);
          if (response.hasMore) {
            $('#loadMoreBtn').data('previous-member-seq', response.data[response.data.length - 1].memberSeq).show();
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function() {
          console.error("[ERROR] 데이터 초기화 중 오류 발생");
        }
      });
    }

    function loadFilteredData(formData) {
      $.ajax({
        method: "GET",
        url: "/recommendation-filter",
        data: formData,
        dataType: "json",
        success: function (response) {
          $('#bossInfo').html('');
          renderData(response.data);
          if (response.hasMore) {
            $('#loadMoreBtn').data('previous-member-seq', response.data[response.data.length - 1].memberSeq).show();
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function() {
          console.error("[ERROR] 필터링 데이터 로딩 중 오류 발생");
        }
      });
    }

    function loadMoreData(previousMemberSeq) {
      $.ajax({
        method: "POST",
        url: "/recommendation-boss",
        data: {
          previousMemberSeq: previousMemberSeq
        },
        dataType: "json",
        success: function (response) {
          if (response.data.length > 0) {
            renderData(response.data);
            if (response.hasMore) {
              $('#loadMoreBtn').data('previous-member-seq', response.data[response.data.length - 1].memberSeq).show();
            } else {
              $('#loadMoreBtn').hide();
            }
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function() {
          console.error("[ERROR] 추가 데이터 로딩 중 오류 발생");
        }
      });
    }

    function renderData(data) {
      var htmlStr = "";
      $.map(data, function(val) {
        htmlStr += "<div class='col-xl-2'>";
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body profile-card pt-4 d-flex flex-column align-items-center'>";
        htmlStr += "<a href='/brand-page?member_seq=" + val["memberSeq"] + "'>";
        htmlStr += "<img src='" + val["profilePhotoUrl"] + "' alt='Profile' class='profile-img'>";
        htmlStr += "<h2>" + val["nickname"] + "</h2>";

        if (val["foodTypes"] != null && val["foodTypes"] !== "") {
          htmlStr += "<h3>" + val["foodTypes"] + "</h3>";
        }

        if (val["tags"] != null && val["tags"] !== "") {
          htmlStr += "<h3>" + val["tags"] + "</h3>";
        }

        htmlStr += "</a>";
        htmlStr += "</div>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $('#bossInfo').append(htmlStr);
    }
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
<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/chart.js/chart.umd.js"></script>
<script src="assets/vendor/echarts/echarts.min.js"></script>
<script src="assets/vendor/quill/quill.js"></script>
<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="assets/vendor/tinymce/tinymce.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>

</body>

</html>