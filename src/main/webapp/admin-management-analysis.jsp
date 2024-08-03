<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var ="loginUser" value="${loginUser}"/>
<c:set var ="userSeq" value="${loginUser.seq}"/>
<c:set var ="nickname" value="${loginUser.nickname}"/>
<c:set var ="profileUrl" value="${loginUser.profilePhotoUrl}" />
<c:set var ="code" value="${loginUser.code}"/>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>관리자 페이지</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="/assets/img/favicon.png" rel="icon">
  <link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

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

  <!-- chart.js -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

  <!-- =======================================================
  * Template Name: NiceAdmin
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Updated: Apr 20 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

<!-- 탈퇴 모달 창 -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="deleteModalLabel">정말 탈퇴시킬까요?</h5><br>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        탈퇴를 원하시면 관리자 비밀번호를 입력해주세요
        <form id="deleteForm">
          <div class="mb-3">
            <label for="password" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="password" required>
          </div>
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button> <!-- 추가된 취소 버튼 -->
          <button type="submit" class="btn btn-primary">확인</button>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center header-hr">
  <div class="d-flex align-items-center justify-content-between ">
    <a href="/main?seq=${userSeq}&pagecode=Requester"
       class="logo d-flex align-items-center">
      <img src="/assets/img/logo/logo-vertical.png" alt=""
           style="  width: 50px; margin-top: 20px;">
      <span class="d-none d-lg-block">FReview</span>
    </a>
    <i class="bi bi-list toggle-sidebar-btn"></i>
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

    <ul class="sidebar-nav">
      <li class="nav-item">
        <a class="nav-link active" href="/admin/manage/analysis">
          <i class="bi bi-person"></i><span>분석</span>
        </a>
      </li>
    </ul>
    <li class="nav-item">
      <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
        <i class="bi bi-layout-text-window-reverse"></i><span>관리</span><i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul id="tables-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
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
          <a href="/admin/manage/experience">
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

</aside><!-- End Sidebar-->

<main id="main" class="main">

  <div class="pagetitle">
    <h1>유저 데이터 분석</h1>
  </div>

  <section class="section">

      <div class="card">
        <div class="card-body">
          <h5 class="card-title">체험 관련 누적 그래프</h5>
          <canvas id="myChart" style="height: 400px; width: 100%;"></canvas>
        </div>
      </div>

    <div class="card">
      <div class="card-body">
        <h5 class="card-title">관심사 분포도</h5>
        <canvas id="pieChart" style="max-height: 400px;"></canvas>
      </div>
    </div>
  </section>

</main>

<script>
  $(document).ready(function() {
    function getRandomColor() {
      let letters = '0123456789ABCDEF';
      let color = '#';
      for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
      }
      return color;
    }

    function formatDate(dateObj) {
      const year = dateObj.year;
      const month = String(dateObj.monthValue).padStart(2, '0');
      const day = String(dateObj.dayOfMonth).padStart(2, '0');
      return year+"-"+month+"-"+day;
    }

    $.ajax({
      url: '/api/admin/analysis/done-experience',
      method: 'POST',
      contentType: "application/json",
      success: function (data) {
        let ctx = document.getElementById('myChart').getContext('2d');
        let labels = data.map(d => formatDate(d.date));
        let values = data.map(d => d.totalDone);

        let  myChart = new Chart(ctx, {
          type: 'line',
          data: {
            labels: labels,
            datasets: [{
              label: '체험 성공',
              data: values,
              borderColor: 'rgb(75, 192, 192)',
              tension: 0.1
            }]
          },
          options: {
            responsive: true,
            scales: {
              y: {
                beginAtZero: true
              }
            }
          }
        });
      },
      error: function () {
        console.error('[ERROR] 체험완료 데이터를 불러오던 도중 에러가 발생했습니다');
      }
    });

    $.ajax({
      url: '/api/admin/analysis/interest-distribution',
      method: 'POST',
      success: function(responseData) {
        let labels = responseData.map(function(item) {
          return item.code;
        });
        let data = responseData.map(function(item) {
          return item.totalScore;
        });

        let backgroundColors = labels.map(function() {
          return getRandomColor();
        });

        new Chart(document.getElementById('pieChart'), {
          type: 'pie',
          data: {
            labels: labels,
            datasets: [{
              label: '누적',
              data: data,
              backgroundColor: backgroundColors,
              hoverOffset: 4
            }]
          }
        });
      },
      error: function() {
        console.error('[ERROR] 관심사 분포 데이터를 불러오던 도중 에러가 발생했습니다');
      }
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

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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
