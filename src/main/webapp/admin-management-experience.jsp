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

    <title>체험</title>
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
    <link href="/assets/css/hr.css" rel="stylesheet">

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

    <!-- Day.js -->
    <script src="https://cdn.jsdelivr.net/npm/dayjs@1.10.7/dayjs.min.js"></script>

    <style>
      .pagination a, .pagination span {
        display: inline-block;
        padding: 8px 16px;
        margin: 5px;
        border-radius: 5px;
        border: 1px solid transparent;
        background-color: #FFFFFF;
        color: black;
        text-decoration: none;
        transition: background-color 0.3s;
        box-sizing: border-box;
        vertical-align: middle;
      }

      .pagination a:hover {
        background-color: #3399ff;
        border-color: #3399ff;
      }

      .pagination .current-page {
        background-color: #007bff;
        color: white;
        cursor: default;
      }

      .pagination {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 20px 0;
      }

      .container {
        max-width: 100%;
        width: 100%;
      }

    </style>
    <!-- =======================================================
    * Template Name: NiceAdmin
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Updated: Apr 20 2024 with Bootstrap v5.3.3
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
<body>

<jsp:include page="/header.jsp" />

<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">
        <ul class="sidebar-nav">
            <li class="nav-item">
                <a class="nav-link collapsed" href="/admin/analysis">
                    <i class="bi bi-person"></i><span>분석</span>
                </a>
            </li>
        </ul>
        <li class="nav-item">
            <a class="nav-link " data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-layout-text-window-reverse"></i><span>관리</span><i
                    class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="tables-nav" class="nav-content collapse show" data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/admin/manage/customer">
                        <i class="bi bi-circle"></i><span>체험단</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/manage/store">
                        <i class="bi bi-circle"></i><span>스토어</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/manage/experience" class="active">
                        <i class="bi bi-circle"></i><span>체험</span>
                    </a>
                </li>
            </ul>
        </li>
        <ul class="sidebar-nav">
            <li class="nav-item">
                <a class="nav-link collapsed" href="/admin/profile">
                    <i class="bi bi-person"></i><span>개인정보수정</span>
                </a>
            </li>
        </ul>
    </ul>

</aside>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>체험 관리</h1>
    </div>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">리뷰 관리</h5>
            <p>스토어 요청으로 숨겨진 리뷰 관리를 할 수 있습니다<br></p>
            <table class="table">
            <thead>
            <tr>
                <th>요청한 스토어</th>
                <th>리뷰 작성자</th>
                <th>리뷰 URL</th>
                <th>리뷰 삭제</th>
            </tr>
            </thead>
            <tbody id="hiddenReviews"></tbody>
        </table>
            <div class="pagination" id="pagination"></div>

        </div>
    </div>
</main>

<script>
  let currentPage = 1;

  $(document).ready(function () {
    loadPage(currentPage);

    function loadPage(page) {
      currentPage = page;
      $.ajax({
        method: "POST",
        url: '/api/admin/experience/hidden-reviews/' + page,
        dataType: "json",
        success: function (response) {
          renderData(response.reviewList);
          renderPagination(response.pageTotalCount, page);
        },
        error: function () {
          console.error("[ERROR] 리뷰리스트 초기화 중 오류 발생");
        }
      });
    }

    function renderData(data) {
      let htmlStr = "";
      $.map(data, function(val) {
        htmlStr += "<tr>";
        htmlStr += "<td>" + val["storeName"] + "</td>";
        htmlStr += "<td>" + val["reviewerName"] + "</td>";
        htmlStr += "<td><a href='" + val["url"] + "'>" + val["url"] + "</a></td>";
        htmlStr += "<td><button class='btn btn-danger' onclick='deleteReview(" + val["seq"] + ")'>삭제</button></td>";
        htmlStr += "</tr>";
      });
      $('#hiddenReviews').empty().append(htmlStr);
    }

    function renderPagination(totalPages, currentPage) {
      let htmlStr = "";
      let startPage = Math.floor((currentPage - 1) / 10) * 10 + 1;
      let endPage = startPage + 9;
      if (endPage > totalPages) {
        endPage = totalPages;
      }

      if (startPage > 1) {
        htmlStr += "<a href='#' class='page-link' data-page='" + (startPage - 1) + "' style='color: black;'>이전</a>";
      } else {
        htmlStr += "<span style='color: grey;'>이전</span>";
      }

      for (let i = startPage; i <= endPage; i++) {
        if (i === currentPage) {
          htmlStr += "<span class='current-page'>" + i + "</span>";
        } else {
          htmlStr += "<a href='#' class='page-link' data-page='" + i + "'>" + i + "</a>";
        }
      }

      if (endPage < totalPages) {
        htmlStr += "<a href='#' class='page-link' data-page='" + (endPage + 1) + "' style='color: black;'>다음</a>";
      } else {
        htmlStr += "<span style='color: grey;'>다음</span>";
      }

      $('#pagination').html(htmlStr);
    }

    $('#pagination').on('click', 'a.page-link', function (e) {
      e.preventDefault();
      let page = $(this).data('page');
      loadPage(page);
    });
  });

  function deleteReview(seq) {
    if (confirm('정말로 이 리뷰를 삭제하시겠습니까?')) {
      $.ajax({
        method: "DELETE",
        url: '/api/admin/experience/' + seq,
        complete: function() {
          alert('리뷰가 성공적으로 삭제되었습니다.');
          location.replace("/admin/manage/experience");
        },
        error: function() {
          console.error("[ERROR] 리뷰 삭제 중 오류 발생");
        }
      });
    }
  }
</script>

<jsp:include page="/footer.jsp" />

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