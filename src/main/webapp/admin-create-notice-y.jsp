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

    <title>공지글 등록하기</title>
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
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="/assets/css/style.css" rel="stylesheet">
    <link href="/assets/css/hr.css" rel="stylesheet">

    <style>
      /* Custom CSS to make all table rows white */
      table tbody tr {
        background-color: white !important;
      }
    </style>

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

    <!-- =======================================================
    * Template Name: NiceAdmin
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Updated: Apr 20 2024 with Bootstrap v5.3.3
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<body>

<!-- ======= Header ======= -->
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
            <img src="/assets/img/basic/basic-profile-img.png" alt=" " style="width: 30px;
                margin-top: 15px;">
            <%--            <img src="<%=profileURL()%>" alt=" " style="width: 30px;--%>
            <%--    margin-top: 15px;"> TODO: 세션의 프로필 url을 적용할 것--%>
        </a>
        <a href="COMM_logout.jsp" style="margin-top: 17px;">로그아웃</a>
    </div>
</header>

<main id="main" style="margin:auto; margin-top:50px">
    <div class="pagetitle">
        <h1>공지 등록하기</h1>
    </div>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">새로운 공지글을 입력해주세요</h5>

            <!-- Form for creating a post -->
            <form id="createPostForm" action="/notice-create" method="post">
                <div class="mb-3">
                    <label for="title" class="form-label">제목</label>
                    <input type="text" class="form-control" id="title" name="title" required>
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">내용</label>
                    <textarea class="form-control" id="content" name="content" rows="20"
                              required></textarea>
                </div>
                <div class="d-flex justify-content-between">
                    <button type="button" class="btn btn-secondary" onclick="location.href='/notice'">취소</button>
                    <button type="submit" class="btn btn-primary">등록</button>
                </div>
            </form>

        </div>
    </div>

    <script>
      document.getElementById('createPostForm').addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission

        var formData = new URLSearchParams(new FormData(this));

        fetch('/notice-create', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          },
          body: formData.toString()
        })
        .then(response => {
          if (response.ok) {
            return response.text().then(data => {
              console.log(data);
              alert('게시글이 성공적으로 등록되었습니다.');
              location.replace("/notice");
            })
          } else {
            response.text().then(data => {
              console.error(data);
              alert('게시글 등록에 실패했습니다. 다시 시도해 주세요.');
            });
          }
        })
        .catch(error => console.error('Error:', error));
      });
    </script>

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