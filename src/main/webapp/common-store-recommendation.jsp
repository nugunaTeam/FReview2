<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="loginUser" value="${loginUser}"/>
<c:set var="userSeq" value="${loginUser.seq}"/>
<c:set var="nickname" value="${loginUser.nickname}"/>
<c:set var="profileUrl" value="${loginUser.profilePhotoUrl}" />
<c:set var="code" value="${loginUser.code}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>추천 페이지</title>
    <meta content="" name="description">

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

      #personalizedInfoContainer {
        border: 2px solid #007bff; /* 테두리 강조 */
        border-radius: 10px; /* 테두리 둥글게 */
        padding: 20px; /* 내부 여백 */
        margin-bottom: 20px; /* 아래 여백 */
      }

      #personalizedInfo {
        display: flex;
        flex-wrap: wrap;
      }

      #personalizedInfo .col-xl-2 {
        flex: 0 0 auto;
        width: 20%; /* 한 행에 5개의 카드가 들어가도록 설정 */
      }

      .col-md-6 {
        flex: 0 0 50%;
        max-width: 50%;
        padding: 10px;
      }

      #rankingInfoContainer {
        border: 1px solid #007bff;
        border-radius: 10px;
        padding: 20px;
        background-color: #f8f9fa;
      }

      img{
        width: 200px;
        border-radius: 50px;
        margin-bottom: 20px;
      }
      .header{
        display: flex;
        justify-content: space-between;
      }
      .header-left,.header-right{
        display: flex;
      }
      .header-left{
        margin-left: 60px;
      }
      .header-right{
        margin-right: 60px;
      }
      .card-header{
        display: flex;
        justify-content: space-between;
      }

      .nav-menu {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-grow: 1;
      }

      .nav-menu ul {
        list-style: none;
        padding: 0;
        margin: 0;
        display: flex;
        align-items: center;
        justify-content: center;
      }

      .nav-menu ul li {
        padding: 0 15px;
      }

      .nav-menu ul li a {
        color: #000000;
        text-decoration: none;
        transition: color 0.3s ease;
      }

      .nav-menu ul li a:hover {
        color: #808080;
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

<header id="header" class="header fixed-top d-flex align-items-center header">
    <div class="d-flex align-items-center justify-content-between ">
        <a href="/main?seq=${userSeq}&pagecode=Requester"
           class="logo d-flex align-items-center">
            <img src="/assets/img/logo/logo-vertical.png" alt=""
                 style="  width: 50px; margin-top: 20px;">
            <span class="d-none d-lg-block">FReview</span>
        </a>
    </div>

    <nav class="nav-menu d-none d-lg-block">
        <ul>
            <li><a href="/notice">공지게시판</a></li>
            <li><a href="/mojip">모집게시판</a></li>
            <li><a href="/recommendation/customer">체험단 추천</a></li>
            <li><a href="/recommendation/store">사장님 추천</a></li>
        </ul>
    </nav>

    <div class="header-right">
        <a href="/my-info?user_seq=${userSeq}" style="margin-right: 20px">
            ${nickname}
            <img src="${profileUrl}" alt=" " style="width: 30px; margin-top: 15px;">
        </a>
        <a href="/COMM_logout.jsp" style="margin-top: 17px;">로그아웃</a>
    </div>
</header>

<main id="main" style="margin:auto; margin-top:50px">
    <div class="pagetitle">
        <h1>스토어 추천 페이지</h1>
    </div>

    <section class="section profile">
        <div class="row">
            <div class="tab-pane fade show active" id="store" role="tabpanel" aria-labelledby="store-tab">
                <form id="filterForm">
                    <div>
                        <h3>음식 유형</h3>
                        <label><input type="checkbox" name="foodType" value="한식"> 한식</label>
                        <label><input type="checkbox" name="foodType" value="양식"> 양식</label>
                        <label><input type="checkbox" name="foodType" value="중식"> 중식</label>
                        <label><input type="checkbox" name="foodType" value="일식"> 일식</label>
                        <label><input type="checkbox" name="foodType" value="베이커리"> 베이커리</label>
                        <label><input type="checkbox" name="foodType" value="기타"> 기타</label>
                    </div>
                    <div>
                        <h3>태그</h3>
                        <label><input type="checkbox" name="tag" value="뷰 맛집"> 뷰 맛집</label>
                        <label><input type="checkbox" name="tag" value="오션뷰"> 오션뷰</label>
                        <label><input type="checkbox" name="tag" value="반려동물 환영"> 반려동물 환영</label>
                    </div>
                    <div>
                        <button type="submit">필터링</button> <button id="resetBtn">모든 필터 제거</button>
                    </div>
                </form>

                <div class="col-md-6" id="rankingSection">
                    <div id="rankingInfoContainer">
                        <div id="rankingInfo"></div>
                    </div>
                </div>
            </div>

            <br>
                <div id="personalizedInfoSection">
                    ${nickname}님이 요즘 관심있을만한 스토어들을 추천해드려요
                    <div id="personalizedInfoContainer">
                        <div class="row" id="personalizedInfo"></div>
                    </div>
                </div>
                전체 보기
                <div class="row" id="storeInfo"></div>
                <div class="d-flex justify-content-center">
                    <button class="btn btn-primary" id="loadMoreBtn" data-previous-user-seq="0">더보기</button>
                </div>
            </div>
        </div>
    </section>

</main>

<script>
  $(document).ready(function() {
    let code = "${code}";
    if (code === "ADMIN") {
      $('#personalizedInfoSection').hide();
    }

    loadInitialRankingData();
    loadInitialData();
    loadInitialPersonalizationData();

    $('#filterForm').submit(function (event) {
      event.preventDefault();
      let formData = {
        previousUserSeq: $('#previousUserSeq').val(),
        foodTypes: $('input[name="foodType"]:checked').map(function(){ return this.value; }).get(),
        tags: $('input[name="tag"]:checked').map(function(){ return this.value; }).get(),
        userCode: 'STORE'
      };

      loadFilteredData(JSON.stringify(formData));
    });

    $('#resetBtn').click(function() {
      $('#storeInfo').empty();
      $('input[name="foodType"]').prop('checked', false);
      $('input[name="tag"]').prop('checked', false);
      loadInitialData();
    });

    $('#loadMoreBtn').click(function () {
      let previousUserSeq = $(this).data('previous-user-seq');
      let isFiltered = $(this).data('isFiltered');
      let foodTypes = [];
      let tags = [];

      if (isFiltered) {
        $('input[name="foodType"]:checked').each(function() {
          foodTypes.push($(this).val());
        });
        $('input[name="tag"]:checked').each(function() {
          tags.push($(this).val());
        });

        loadMoreFilteredData(previousUserSeq, foodTypes, tags);
      } else {
        loadMoreData(previousUserSeq);
      }
    });

    function loadInitialData() {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation",
        contentType: "application/json",
        data: JSON.stringify({
          previousUserSeq: null,
          userCode: 'STORE'
        }),
        dataType: "json",
        success: function (response) {
          renderData(response.userList, 'storeInfo');
          if (response.hasMore) {
            $('#loadMoreBtn').data('previous-user-seq', response.userList[response.userList.length - 1].userSeq).show();
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function () {
          console.error("[ERROR] 추천 데이터 초기화 중 오류 발생");
        }
      });
    }

    function loadInitialPersonalizationData() {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation/personalization",
        contentType: "application/json",
        data: JSON.stringify({
          requesterSeq: ${userSeq},
          pageCode: "STORE"
        }),
        dataType: "json",
        success: function (response) {
          renderData(response.userList, 'personalizedInfo');
        },
        error: function() {
          console.error("[ERROR] 개인화 추천 데이터 초기화 중 오류 발생");
        }
      })
    }

    function loadInitialRankingData() {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation/top-performers",
        contentType: "application/json",
        data: JSON.stringify({
          pageCode: "STORE"
        }),
        dataType: "json",
        success: function (response) {
          renderRankingData(response.topPerformers, 'rankingInfo');
        },
        error: function() {
          console.error("[ERROR] 랭킹 데이터 초기화 중 오류 발생")
        }
      })
    }

    function loadFilteredData(formData) {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation/filter",
        data: formData,
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
          $('#storeInfo').html('');
          renderData(response.userList, 'storeInfo');
          if (response.hasMore) {
            $('#loadMoreBtn').data('previous-user-seq', response.userList[response.userList.length - 1].userSeq)
            .data('isFiltered', true)
            .show();
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function () {
          console.error("[ERROR] 필터링 데이터 로딩 중 오류 발생");
        }
      });
    }

    function loadMoreData(previousUserSeq) {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation",
        contentType: "application/json",
        data: JSON.stringify({
          previousUserSeq: previousUserSeq,
          userCode: 'STORE'
        }),
        dataType: "json",
        success: function (response) {
          if (response.userList.length > 0) {
            renderData(response.userList, 'storeInfo');
            if (response.hasMore) {
              $('#loadMoreBtn').data('previous-user-seq', response.userList[response.userList.length - 1].userSeq).show();
            } else {
              $('#loadMoreBtn').hide();
            }
          }
        },
        error: function () {
          console.error("[ERROR] 추가 데이터 로딩 중 오류 발생");
        }
      });
    }

    function loadMoreFilteredData(previousUserSeq, foodTypes, tags) {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation/filter",
        contentType: "application/json",
        data: JSON.stringify({
          previousUserSeq: previousUserSeq,
          foodTypes: foodTypes,
          tags: tags,
          userCode: 'STORE'
        }),
        dataType: "json",
        success: function (response) {
          if (response.userList.length > 0) {
            renderData(response.userList, 'storeInfo');
            if (response.hasMore) {
              $('#loadMoreBtn').data('previous-user-seq', response.userList[response.userList.length - 1].userSeq).show();
            } else {
              $('#loadMoreBtn').hide();
            }
          }
        },
        error: function (xhr, status, error) {
          console.error("[ERROR] 추가 필터링 데이터 로딩 중 오류 발생" + error);
        }
      });
    }

    function renderData(data, targetId) {
      let htmlStr = "";
      $.map(data, function (val) {
        htmlStr += "<div class='col-xl-2'>";
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body profile-card pt-4 d-flex flex-column align-items-center'>";
        htmlStr += "<a href='/brand-page?user_seq=" + val["userSeq"] + "'>";
        htmlStr += "<img src='" + val["profilePhotoUrl"] + "' alt='Profile' class='profile-img'>";
        htmlStr += "<h2>" + val["nickname"] + "</h2>";

        if (val["foodTypeWord"] != null && val["foodTypeWord"] !== "") {
          htmlStr += "<h3>" + val["foodTypeWord"] + "</h3>";
        }

        if (val["tagWord"] != null && val["tagWord"] !== "") {
          htmlStr += "<h3>" + val["tagWord"] + "</h3>";
        }

        htmlStr += "</a>";
        htmlStr += "</div>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $('#' + targetId).append(htmlStr);
    }

    function renderRankingData(data, targetId) {
      let htmlStr = "<div>";
      htmlStr += "<h2>지금 핫한 스토어는?</h2>";
      htmlStr += "<table>";

      let numRows = Math.ceil(data.length / 2);

      for (let i = 0; i < numRows; i++) {
        htmlStr += "<tr>";

        if (i < data.length) {
          htmlStr += "<td>" + (i + 1) + ". <a href='/brand-page?user_seq=" + data[i]["userSeq"] + "'>" + data[i]["nickname"] + "</a></td>";
        }

        let rightIndex = i + numRows;
        if (rightIndex < data.length) {
          htmlStr += "<td>" + (rightIndex + 1) + ". <a href='/brand-page?user_seq=" + data[rightIndex]["userSeq"] + "'>" + data[rightIndex]["nickname"] + "</a></td>";
        }

        htmlStr += "</tr>";
      }

      htmlStr += "</table>";
      htmlStr += "</div>";
      $('#' + targetId).append(htmlStr);
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