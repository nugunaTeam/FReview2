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

    <title>공지게시판</title>
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
        <h1>공지</h1>
    </div>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">공지게시판</h5>
            <p>매우 중요한 공지가 올라옵니다<br></p>
            <div class="d-flex justify-content-between">
                <div>
                    <input type="text" name="searchWord" id="searchWord" placeholder="제목/내용으로 검색하세요!">
                    <input type="button" id="searchBtn" value="검색">
                </div>
                <c:if test="${code eq 'ADMIN'}">
                    <div>
                        <a href="/notice/create" class="btn btn-primary">
                            공지 등록
                        </a>
                    </div>
                </c:if>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성일자</th>
                    <th>조회수</th>
                </tr>
                </thead>
                <tbody id="noticeList"></tbody>
            </table>
            <div class="pagination" id="pagination"></div>

        </div>
    </div>
</main>

<script>
  $(document).ready(function () {
    loadPage(1);

    $('#searchBtn').click(function() {
      let searchWord = $('#searchWord').val();
      loadPage(1, searchWord);
    });

    function loadPage(currentPage, searchWord = '') {
      $.ajax({
        method: "POST",
        url: '/api/common/notice/list/' + currentPage,
        data: { searchWord: searchWord },
        dataType: "json",
        success: function (response) {
          renderData(response.noticeList);
          renderPagination(response.pageTotalCount, currentPage, searchWord);
        },
        error: function () {
          console.error("[ERROR] 공지리스트 초기화 중 오류 발생");
        }
      });
    }

    function renderData(data) {
      let htmlStr = "";
      $.map(data, function (val) {
        let formattedCreatedAt = dayjs(val["createdAt"]).format('YYYY-MM-DD HH:mm');
        let shortContent = val["content"].length > 30 ? val["content"].substring(0, 30) + "..." : val["content"];

        htmlStr += "<tr>";
        htmlStr += "<td><a href='/notice/" + val["seq"] + "'>" + val["title"] + "</a></td>";
        htmlStr += "<td>" + shortContent + "</td>";
        htmlStr += "<td>" + formattedCreatedAt + "</td>";
        htmlStr += "<td>" + val["totalView"] + "</td>";
        htmlStr += "</tr>";
      });
      $('#noticeList').empty().append(htmlStr);
    }

    function renderPagination(totalPages, currentPage, searchWord) {
      let htmlStr = "";
      let startPage = Math.floor((currentPage - 1) / 10) * 10 + 1;
      let endPage = startPage + 9;
      if (endPage > totalPages) {
        endPage = totalPages;
      }

      if (startPage > 1) {
        htmlStr += "<a href='#' class='page-link' data-page='" + (startPage - 1) + "' data-search='" + searchWord + "' style='color: black;'>이전</a>";
      } else {
        htmlStr += "<span style='color: grey;'>이전</span>";
      }

      for (let i = startPage; i <= endPage; i++) {
        if (i === currentPage) {
          htmlStr += "<span class='current-page'>" + i + "</span>";
        } else {
          htmlStr += "<a href='#' class='page-link' data-page='" + i + "' data-search='" + searchWord + "'>" + i + "</a>";
        }
      }

      if (endPage < totalPages) {
        htmlStr += "<a href='#' class='page-link' data-page='" + (endPage + 1) + "' data-search='" + searchWord + "' style='color: black;'>다음</a>";
      } else {
        htmlStr += "<span style='color: grey;'>다음</span>";
      }

      $('#pagination').html(htmlStr);
    }

    $('#pagination').on('click', 'a.page-link', function (e) {
      e.preventDefault();
      let page = $(this).data('page');
      let searchWord = $(this).data('search');
      loadPage(page, searchWord);
    });
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