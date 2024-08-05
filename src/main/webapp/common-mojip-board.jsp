<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="loginUser" value="${loginUser}"/>
<c:set var="userSeq" value="${loginUser.seq}"/>
<c:set var="nickname" value="${loginUser.nickname}"/>
<c:set var="profileUrl" value="${loginUser.profilePhotoUrl}"/>
<c:set var="code" value="${loginUser.code}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>모집 게시판</title>
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

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

    <!-- Day.js -->
    <script src="https://cdn.jsdelivr.net/npm/dayjs@1.10.7/dayjs.min.js"></script>

    <style>
      .post-list {
        display: flex !important;
        flex-wrap: wrap !important;
        gap: 16px !important;
        justify-content: flex-start !important;
        width: 100%;
      }

      .post-item {
        flex: 0 0 calc(25% - 16px) !important;
        box-sizing: border-box !important;
        border: 1px solid #ddd !important;
        border-radius: 8px !important;
        padding: 16px !important;
        background-color: #fff !important;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1) !important;
        text-decoration: none !important;
        color: inherit !important;
        margin-bottom: 16px !important;
      }

      .post-item img.profile-img {
        max-width: 100% !important;
        height: auto !important;
        border-radius: 50% !important;
      }

      .post-item h5, .post-item p {
        margin: 8px 0 !important;
      }

      .btn-register {
        background-color: #007bff; /* Bootstrap 기본 파란색 */
        color: white;
        text-decoration: none;
      }

      .btn-register:hover {
        color: white; /* Hover 시에도 흰색 유지 */
      }

      .search-container {
        display: flex;
        justify-content: space-between;
        align-items: center;
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

<jsp:include page="/header.jsp"/>

<main id="main" style="margin:auto; margin-top:50px">
    <div class="pagetitle">
        <h1>모집</h1>
    </div>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">모집 게시판</h5>
            <p>매우 중요한 모집글이 올라옵니다 <br></p>
            <div class="search-container">
                <div>
                    <input type="text" name="searchWord" id="searchWord"
                           placeholder="원하는 키워드로 검색하세요!">
                    <input type="button" id="searchBtn" value="검색">
                </div>

                <c:if test="${code eq 'STORE'}">
                    <a href="/mojip/create" class="btn btn-register">
                        모집 등록
                    </a>
                </c:if>
            </div>
        </div>
        <div id="postList" class="post-list">
        </div>
    </div>
    <div class="d-flex justify-content-center">
        <button class="btn btn-primary" id="loadMoreBtn" data-previous-post-seq="0">더보기</button>
    </div>

</main>

<script>
  $(document).ready(function () {
    let currentSearchWord = '';

    loadInitialData();

    $('#searchBtn').click(function () {
      currentSearchWord = $('#searchWord').val();
      $('#postList').empty();
      loadInitialData(currentSearchWord);
    });

    $('#loadMoreBtn').click(function () {
      let previousPostSeq = $(this).data('previous-post-seq');
      loadMoreData(previousPostSeq, currentSearchWord);
    });

    function loadInitialData(searchWord = '') {
      $.ajax({
        method: "POST",
        url: "/api/common/mojip/list",
        contentType: "application/json",
        data: JSON.stringify({
          searchWord: searchWord,
          requesterSeq: ${userSeq}
        }),
        dataType: "json",
        success: function (response) {
          $('#postList').empty();
          renderData(response.mojipList); // 데이터 객체 접근 수정
          if (response.hasMore) {
            $('#loadMoreBtn').data('previous-post-seq',
                response.mojipList[response.mojipList.length - 1].seq).show();
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function () {
          console.error("[ERROR] 데이터 초기화 중 오류 발생");
        }
      });
    }

    function loadMoreData(previousPostSeq, searchWord = '') {
      $.ajax({
        method: "POST",
        url: "/api/common/mojip/list",
        contentType: "application/json",
        data: JSON.stringify({
          previousPostSeq: previousPostSeq,
          searchWord: searchWord,
          requesterSeq: ${userSeq}
        }),
        dataType: "json",
        success: function (response) {
          if (response.mojipList.length > 0) {
            renderData(response.mojipList);
            if (response.hasMore) {
              $('#loadMoreBtn').data('previous-post-seq',
                  response.mojipList[response.mojipList.length - 1].seq).show();
            } else {
              $('#loadMoreBtn').hide();
            }
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function () {
          console.error("[ERROR] 추가 데이터 로딩 중 오류 발생");
        }
      });
    }

    function renderData(data) {
      var htmlStr = "";
      $.map(data, function (post) {
        let formattedApplyStartDate = dayjs(post["applyStartDate"]).format('YYYY-MM-DD');
        let formattedApplyEndDate = dayjs(post["applyEndDate"]).format('YYYY-MM-DD');
        let formattedExperienceDate = dayjs(post["experienceDate"]).format('YYYY-MM-DD');

        htmlStr += "<a href='/mojip/" + post["seq"]
            + "' class='post-item'>";
        htmlStr += "<img src='" + post["profilePhotoUrl"] + "' alt='Profile' class='profile-img'>";
        htmlStr += "<h5>" + post["title"] + "</h5>";
        htmlStr += "<p>[모집 가게] " + post["storeName"] + "</p>";
        htmlStr += "<p>[체험 장소] " + post["storeLocation"] + "</p>";
        htmlStr += "<p>[체험 기간] " + formattedApplyStartDate + " ~ " + formattedApplyEndDate + "</p>";
        htmlStr += "<p>[체험 날짜] " + formattedExperienceDate + "</p>";
        htmlStr += "<p>[좋아요 수] " + post["totalLike"] + "</p>";
        htmlStr += "</a>";
      });
      $('#postList').append(htmlStr);
    }

  });
</script>

<jsp:include page="/footer.jsp"/>

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