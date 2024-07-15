<%@ page import="com.nuguna.freview.entity.member.Member" %>
<%@ page import="com.nuguna.freview.dto.cust.activitylog.CustMyLikePostDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
    Member member = null;
    int memberSeq = 0;
    if (session.getAttribute("Member") != null) {
        member = (Member) session.getAttribute("Member");
        memberSeq = member.getMemberSeq();
    }
//    List<CustMyLikePostDto> likePosts = (List<CustMyLikePostDto>) request.getAttribute("likePosts");
    // 날짜 포맷 설정
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>FReview</title>
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
    <link href="assets/css/style-h.css" rel="stylesheet">

    <style>
      .item-box {
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 15px;
        margin-bottom: 20px;
        background-color: #f9f9f9;
        transition: background-color 0.3s;
      }

      .post-likes {
        display: inline-block;
        margin-top: 15px;
        font-size: 1rem;
        color: #e74c3c; /* 빨간색으로 설정 */
      }

      .item-meta {
        margin-right: 6px;
        display: inline-block;
        margin-top: 15px;
        font-size: 1rem;
        color: #999; /* 회색으로 설정 */
      }

      .item-meta-non-inline {
        margin-right: 6px;
        margin-top: 15px;
        font-size: 1rem;
        color: #999; /* 회색으로 설정 */
      }

      .item-box:hover {
        background-color: #f1f1f1;
      }

      .item-title {
        font-size: 1.25rem;
        font-weight: bold;
        color: #333;
      }

      .item-title a {
        text-decoration: none;
        color: inherit;
      }

      .item-content {
        margin-top: 10px;
        font-size: 1rem;
        color: #555;
      }

      #itemsContainer {
        margin-left: -15px;
        margin-top: 15px;
      }
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- icon bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="/main?seq=<%=memberSeq%>&pagecode=Requester"
           class="logo d-flex align-items-center">
            <img src="assets/img/logo/logo-vertical.png" alt="">
            <span class="d-none d-lg-block">FReview</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div>

    <!-- 우측 상단 닉네임&프로필 사진 -->
    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
            <li class="nav-item dropdown pe-3">
                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#">
                    <img src="assets/img/basic/basic-profile-img.png" alt="Profile"
                         class="rounded-circle">
                    <span id="nickname-holder-head"
                          class="d-none d-md-block"><%=member.getNickname()%></span>
                </a>
            </li>
        </ul>
    </nav>
</header>

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/my-info">
                <i class="bi bi-person-lines-fill"></i><span>브랜딩</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" data-bs-target="#components-nav" href="#">
                <i class="bi bi-layout-text-window-reverse"></i>
                <span>활동</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/my-notification">
                <i class="bi bi-envelope"></i>
                <span>알림</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed"
               href="${pageContext.request.contextPath}/my-personal-info">
                <i class="ri-edit-box-line"></i>
                <span>개인정보수정</span>
            </a>
        </li>
    </ul>
</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>활동 로그</h1>
    </div>
    <!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="col-xl-12">
                <div class="card">
                    <div class="card-body pt-3">
                        <!-- Bordered Tabs -->
                        <ul class="nav nav-tabs nav-tabs-bordered">
                            <li class="nav-item">
                                <button class="nav-link active" data-bs-toggle="tab"
                                        data-bs-target="#receivedBtn" id="likedPost">
                                    좋아요한 글
                                </button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab"
                                        data-bs-target="#receivedBtn" id="myZzimStores">
                                    내가 찜한 스토어
                                </button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab"
                                        data-bs-target="#receivedBtn" id="zzimedMeStores">
                                    나를 찜한 스토어
                                </button>
                            </li>
                        </ul>
                        <div class="tab-content pt-1">
                            <div class="tab-pane show fade active profile-edit pt-6"
                                 id="receivedBtn">
                                <div id="itemsContainer" class="container-fluid">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script>
      $(document).ready(function () {
        // 좋아요 한 글 데이터를 가져오는 함수
        function fetchLikedPosts() {
          $.ajax({
            url: '/api/customer/my-activity/liked-posts',  // 좋아요 한 글 데이터를 가져올 API 엔드포인트
            type: 'GET',
            success: function (likePosts) {
              $('#itemsContainer').empty(); // 기존 내용 초기화

              if (likePosts.item.length === 0) {
                $('#itemsContainer').append('<div class="alert alert-info">좋아요한 글이 없어요</div>');
              } else {
                // Generate HTML for likePosts
                likePosts.item.forEach(function (post) {
                  var postBox = $('<div class="item-box"></div>');

                  var postTitle = $('<div class="item-title"></div>');
                  var postLink = $('<a></a>').attr('href', '/post/' + post.seq).text(
                      post.title.length > 20 ? post.title.slice(0, 20) + '...' : post.title);
                  postTitle.append(postLink);

                  var postContent = $('<div class="item-content"></div>').text(
                      post.content.length > 30 ? post.content.slice(0, 30) + '...' : post.content);

                  var postMeta = $('<div class="item-meta"></div>').text(post.createdAt);
                  var postLikes = $('<div class="post-likes"></div>').html(
                      ' ❤️ ' + post.likesCount);

                  postBox.append(postTitle).append(postContent).append(postMeta).append(postLikes);
                  $('#itemsContainer').append(postBox);
                });
              }
            },
            error: function (error) {
              console.error('Error fetching liked posts:', error);
            }
          });
        }

        // 페이지 로드 시 좋아요 한 글 데이터 초기 로드
        fetchLikedPosts();

        // 좋아요 한 글 버튼 클릭 이벤트 처리
        $('#likedPost').on('click', function () {
          fetchLikedPosts(); // 좋아요 한 글 데이터 다시 불러오기
        });

        // 나를 찜한 스토어 버튼 클릭 이벤트 처리
        $('#zzimedMeStores').on('click', function () {
          $.ajax({
            url: '/api/customer/my-activity/zzimed-me-stores',
            type: 'GET',
            success: function (zzimedMeStores) {
              console.log(zzimedMeStores);
              $('#itemsContainer').empty(); // 기존 내용 초기화

              if (zzimedMeStores.item.length === 0) {
                $('#itemsContainer').append('<div class="alert alert-info">나를 찜한 스토어가 없어요</div>');
              } else {
                zzimedMeStores.item.forEach(function (store) {
                  var zzimedMeStoreBox = $('<div class="item-box"></div>');

                  var zzimedMeStoreName = $('<div class="item-title"></div>');
                  var storeLink = $('<a></a>').attr('href', '/branding/' + store.bossSeq).text(
                      store.storeName);
                  zzimedMeStoreName.append(storeLink);

                  var zzimedMeStoreLocation = $('<div class="item-content"></div>').text(
                      '위치: ' + store.storeLoc);

                  var zzimedMeStoreFoodTypes = $('<div class="item-meta-non-inline"></div>').text(
                      '분야: ' + store.foodTypes.join(', '));

                  var zzimedMeStoreTagInfos = $('<div class="item-meta-non-inline"></div>').html(
                      store.tagInfos.map(tag => '#' + tag).join(' '));

                  zzimedMeStoreBox.append(zzimedMeStoreName).append(zzimedMeStoreLocation).append(
                      zzimedMeStoreFoodTypes).append(
                      zzimedMeStoreTagInfos);
                  $('#itemsContainer').append(zzimedMeStoreBox);
                });
              }
            },
            error: function (error) {
              console.error('Error fetching zzimed me stores:', error);
            }
          });
        });

        /*// 내가 찜한 스토어 버튼 클릭 이벤트 처리
        $('#myZzimStores').on('click', function () {
          $.ajax({
            url: '/api/customer/my-activity/zzim-stores',
            type: 'GET',
            success: function (data) {
              console.log(data);
              // 데이터를 화면에 표시하려면 이곳에 추가할 수 있습니다.
            },
            error: function (error) {
              console.error('Error fetching my zzim stores:', error);
            }
          });
        });*/
        // 내가 찜한 스토어 버튼 클릭 이벤트 처리
        $('#myZzimStores').on('click', function () {
          $.ajax({
            url: '/api/customer/my-activity/zzim-stores',
            type: 'GET',
            success: function (myZzimStores) {
              console.log(myZzimStores);
              $('#itemsContainer').empty(); // 기존 내용 초기화

              if (myZzimStores.item.length === 0) {
                $('#itemsContainer').append('<div class="alert alert-info">내가 찜한 스토어가 없어요</div>');
              } else {
                myZzimStores.item.forEach(function (store) {
                  var myZzimStoreBox = $('<div class="item-box"></div>');

                  var myZzimStoreName = $('<div class="item-title"></div>');
                  var storeLink = $('<a></a>').attr('href', '/branding/' + store.bossSeq).text(
                      store.storeName);
                  myZzimStoreName.append(storeLink);

                  var myZzimStoreLocation = $('<div class="item-content"></div>').text(
                      '위치: ' + store.storeLoc);

                  var myZzimStoreFoodTypes = $('<div class="item-meta-non-inline"></div>').text(
                      '분야: ' + store.foodTypes.join(', '));

                  var myZzimStoreTagInfos = $('<div class="item-meta-non-inline"></div>').html(
                      store.tagInfos.map(tag => '#' + tag).join(' '));

                  myZzimStoreBox.append(myZzimStoreName).append(myZzimStoreLocation).append(
                      myZzimStoreFoodTypes).append(
                      myZzimStoreTagInfos);
                  $('#itemsContainer').append(myZzimStoreBox);
                });
              }
            },
            error: function (error) {
              console.error('Error fetching my zzim stores:', error);
            }
          });
        });
      });
    </script>
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>nugunaTeam</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>
<!-- jquery  -->

<!-- icon bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

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
