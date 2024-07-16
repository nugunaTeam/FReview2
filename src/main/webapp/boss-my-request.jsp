<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nuguna.freview.servlet.member.page.RequestServlet" %>
<%@ page import="com.nuguna.freview.servlet.member.page.ReceivedInformServlet" %>
<%@ page import="com.nuguna.freview.servlet.member.page.SendInformServlet" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Users / Profile - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

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
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
            <img src="assets/img/logo.png" alt="">
            <span class="d-none d-lg-block">NiceAdmin</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
        <form class="search-form d-flex align-items-center" method="POST" action="#">
            <input type="text" name="query" placeholder="Search" title="Enter search keyword">
            <button type="submit" title="Search"><i class="bi bi-search"></i></button>
        </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item d-block d-lg-none">
                <a class="nav-link nav-icon search-bar-toggle " href="#">
                    <i class="bi bi-search"></i>
                </a>
            </li><!-- End Search Icon-->

            <li class="nav-item dropdown">

                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="bi bi-bell"></i>
                    <span class="badge bg-primary badge-number">4</span>
                </a><!-- End Notification Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                    <li class="dropdown-header">
                        You have 4 new notifications
                        <a href="#"><span
                                class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-exclamation-circle text-warning"></i>
                        <div>
                            <h4>Lorem Ipsum</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>30 min. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-x-circle text-danger"></i>
                        <div>
                            <h4>Atque rerum nesciunt</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>1 hr. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-check-circle text-success"></i>
                        <div>
                            <h4>Sit rerum fuga</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>2 hrs. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-info-circle text-primary"></i>
                        <div>
                            <h4>Dicta reprehenderit</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>4 hrs. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li class="dropdown-footer">
                        <a href="#">Show all notifications</a>
                    </li>

                </ul><!-- End Notification Dropdown Items -->

            </li><!-- End Notification Nav -->

            <li class="nav-item dropdown">

                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="bi bi-chat-left-text"></i>
                    <span class="badge bg-success badge-number">3</span>
                </a><!-- End Messages Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
                    <li class="dropdown-header">
                        You have 3 new messages
                        <a href="#"><span
                                class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-1.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>Maria Hudson</h4>
                                <p>Velit asperiores et ducimus soluta repudiandae labore officia est
                                    ut...</p>
                                <p>4 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-2.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>Anna Nelson</h4>
                                <p>Velit asperiores et ducimus soluta repudiandae labore officia est
                                    ut...</p>
                                <p>6 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-3.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>David Muldon</h4>
                                <p>Velit asperiores et ducimus soluta repudiandae labore officia est
                                    ut...</p>
                                <p>8 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="dropdown-footer">
                        <a href="#">Show all messages</a>
                    </li>

                </ul><!-- End Messages Dropdown Items -->

            </li><!-- End Messages Nav -->

            <li class="nav-item dropdown pe-3">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#"
                   data-bs-toggle="dropdown">
                    <img src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
                    <span class="d-none d-md-block dropdown-toggle ps-2">K. Anderson</span>
                </a><!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>Kevin Anderson</h6>
                        <span>Web Designer</span>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center"
                           href="users-profile.html">
                            <i class="bi bi-person"></i>
                            <span>My Profile</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center"
                           href="users-profile.html">
                            <i class="bi bi-gear"></i>
                            <span>Account Settings</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
                            <i class="bi bi-question-circle"></i>
                            <span>Need Help?</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
                        </a>
                    </li>

                </ul><!-- End Profile Dropdown Items -->
            </li><!-- End Profile Nav -->

        </ul>
    </nav><!-- End Icons Navigation -->

</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed" href="index.jsp">
                <i class="bi bi-grid"></i>
                <span>나의 브랜딩</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/boss-received-request.jsp">
                <i class="bi bi-bell"></i>
                <span>알림</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link " href="${pageContext.request.contextPath}/boss-my-request.jsp">
                <i class="bi bi-card-checklist"></i>
                <span>요청</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/boss-brand-info.jsp">
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
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">
                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-edit" id="mozzipList">모집글 리스트</button>
                </li>
                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-settings" id="receivedRequestList">받은 지원서</button>
                </li>
                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#my-request">제안 활동</button>
                </li>
              </ul>
              <div class="tab-content pt-2">
                <div class="tab-pane show fade active profile-edit pt-6" id="profile-edit">
                  <!-- MozzipList -->
                  <form method="get" action="${pageContext.request.contextPath}/api/boss/my-notification/received-inform">
                    <!-- Table with stripped rows -->
                    <table class="table">
                      <thead>
                      <tr style="text-align: center;">
                        <th>글 제목</th>
                        <th data-type="date" data-format="YYYY/DD/MM">모집시작일</th>
                        <th data-type="date" data-format="YYYY/DD/MM">모집마감일</th>
                        <th data-type="date" data-format="YYYY/DD/MM">행사일</th>
                        <th>조회수</th>
                      </tr>
                      </thead>
                      <tbody id="mozzipListAll" >
                        <!-- 모집글 리스트 목록 -->
                      </tbody>
                    </table>
                    <!-- End Table with stripped rows -->
                  </form>

                            </div>
                            <div class="tab-pane fade active pt-6" id="profile-settings">
                                <!-- Settings Form -->
                                <form method="get"
                                      action="${pageContext.request.contextPath}/api/boss/my-notification/send-inform">
                                    <!-- 내가 찜 -->
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">To.OOO </h5>
                                            <p> ____ 님을 찜 하였습니다.</p>
                                        </div>
                                    </div>
                                    <!-- 내가 좋아요 -->
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">To.OOO </h5>
                                            <p> ____님의 게시글을 좋아요했습니다.</p>
                                        </div>
                                    </div>
                                </form><!-- End settings Form -->

                            </div>
                            <div class="tab-pane fade active pt-6" id="my-request">
                                <!-- Settings Form -->
                                <form method="get"
                                      action="${pageContext.request.contextPath}/api/boss/my-notification/send-inform">
                                    <!-- 내가 찜 -->
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">To.OOO </h5>
                                            <p> ____ 님을 찜 하였습니다.</p>
                                        </div>
                                    </div>
                                    <!-- 내가 좋아요 -->
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">To.OOO </h5>
                                            <p> ____님의 게시글을 좋아요했습니다.</p>
                                        </div>
                                    </div>
                                </form><!-- End settings Form -->

                            </div>

                        </div>
                        <!-- End Bordered Tabs -->
                    </div>
                </div>
                <div class="tab-pane fade active pt-6" id="profile-settings">
                  <!-- Settings Form -->
                  <form id="strJson">
                    <!-- Table with stripped rows -->
                    <table class="table">
                        <thead>
                        <tr style="text-align: center;">
                          <th><b>N</b>o</th>
                          <th>지원자</th>
                          <th>진행상태</th>
                          <th>모집시작일</th>
                          <th>모집마감일</th>
                          <th>체험일</th>
                          <th data-type="date" data-format="YYYY/DD/MM">확정</th>
                          <th>참석여부</th>
                          <!--<th>리뷰</th>-->
                        </tr>
                        </thead>
                        <tbody id="receivedRequest" >
                        <!-- 지원자 리스트 목록 -->
                      </tbody>
                    </table>
                    <!-- End Table with stripped rows -->
                  </form><!-- End settings Form -->

                </div>
                <div class="tab-pane fade active pt-6" id="my-request">
                  <!-- Settings Form -->
                  <form method="get" action="${pageContext.request.contextPath}/api/boss/my-notification/send-inform">
                    <!-- 내가 찜 -->
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">To.OOO </h5>
                        <p> ____ 님을 찜 하였습니다.</p>
                      </div>
                    </div>
                    <!-- 내가 좋아요 -->
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">To.OOO </h5>
                        <p> ____님의 게시글을 좋아요했습니다.</p>
                      </div>
                    </div>
                  </form><!-- End settings Form -->

                </div>

              </div>
              <!-- End Bordered Tabs -->
            </div>
        </div>
    </section>

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

  <script>
    $(function() {
      // 모집글 리스트
      $.ajax({
        method: "GET",
        url: "<%=request.getContextPath()%>/api/boss/my-request",
        dataType: "json",
        error: function(data) {
          console.log("여기 에러다 : ", data);
        },
        success: function(data) {
          console.log("데이터 수신 완료:", data);
          var bossMozzipList = data.bossMozzipList;
          var htmlStr = " ";
          $.map(bossMozzipList, function(item, index) {
            htmlStr += "<tr style='text-align: center'>";
            htmlStr += "<td>" + item.title + "</td>";
            htmlStr += "<td>" + item.applyStartDate + "</td>";
            htmlStr += "<td>" + item.applyEndDate + "</td>";
            htmlStr += "<td>" + item.experienceDate + "</td>";
            htmlStr += "<td>" + item.viewCount + "</td>";
            htmlStr += "</tr>";
          });
          $("#mozzipListAll").html(htmlStr);
        }
      });
      // 받은 지원서
      $("#receivedRequestList").click(function() {
        var sendFormData = $("#strJson").serialize();
        console.log(sendFormData);
        $.ajax({
          method: "GET",
          url: "<%=request.getContextPath()%>/api/boss/my-request",
          dataType: "json",
          error: function(data) {
            console.log("여기 에러다 : ", data);
          },
          success: function(data) {
            console.log("데이터 수신 완료:", data);
            var receivedRequest = data.receivedRequest;
            var htmlStr = " ";
            $.map(receivedRequest, function(item, index) {
              htmlStr += "<tr style='text-align: center'>";
              htmlStr += "<td>" + item.seq + "</td>";
              htmlStr += "<td>" + item.nickname + "</td>";
              htmlStr += "<td>" + item.status + "</td>";
              htmlStr += "<td>" + item.comeDate + "</td>";
              htmlStr += "<td>" + item.comeOrNot + "</td>";
              htmlStr += "<td>" + item.experienceDate + "</td>";
              htmlStr += "<td><button class='attend-btn' data-id='" + item.seq + "'>참석</button></td>";
              htmlStr += "</tr>";
            });
            $("#receivedRequest").html(htmlStr);

            // 참석 버튼에 이벤트 핸들러 추가
            $(".attend-btn").click(function() {
              var id = $(this).data("id");
              attendRequest(id);
            });
          }
        });
      });

      // 참석 요청 처리 함수
      function attendRequest(id) {
        $.ajax({
          method: "POST",
          url: "<%=request.getContextPath()%>/api/attend",
          data: { id: id },
          success: function(response) {
            alert("참석 처리되었습니다.");
          },
          error: function(error) {
            console.log("에러 발생:", error);
            alert("참석 처리에 실패했습니다.");
          }
        });
      }
    });
  </script>
</body>

</html>