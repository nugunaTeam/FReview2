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

    <title>관리자 페이지</title>
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

    <!-- =======================================================
    * Template Name: NiceAdmin
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Updated: Apr 20 2024 with Bootstrap v5.3.3
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<style>
  .delete-btn {
    color: red;
    font-weight: bold;
    border: none;
    background: none;
    cursor: pointer;
  }
</style>

<style>
  .search-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
</style>

<body>

<!-- 탈퇴 모달 창 -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">정말 탈퇴시킬까요?</h5><br>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                탈퇴를 원하시면 관리자 비밀번호를 입력해주세요
                <form id="deleteForm">
                    <div class="mb-3">
                        <label for="password" class="form-label">비밀번호</label>
                        <input type="password" class="form-control" id="password" required>
                    </div>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소
                    </button> <!-- 추가된 취소 버튼 -->
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
                    <a href="/admin/manage/store" class="active">
                        <i class="bi bi-circle"></i><span>스토어</span>
                    </a>
                </li>
            </ul>
        </li>
        <ul class="sidebar-nav">
            <li class="nav-item">
                <a class="nav-link collapsed" href="/account/info">
                    <i class="bi bi-person"></i><span>개인정보수정</span>
                </a>
            </li>
        </ul>
    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>스토어 관리</h1>
    </div>

    <section class="section">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">스토어 리스트</h5>
                        <p>가입한 스토어 리스트입니다 <br>
                            아이디를 클릭하면 해당 스토어의 브랜딩 페이지로 이동할 수 있습니다 <br>
                            <br>
                        </p>
                        <div>
                            <input type="text" name="searchWord" id="searchWord"
                                   placeholder="원하는 키워드로 검색하세요!">
                            <input type="button" id="searchBtn" value="검색">
                        </div>

                        <table class="table">
                            <thead>
                            <tr>
                                <th>스토어명</th>
                                <th>사업자번호</th>
                                <th>아이디</th>
                                <th>가입일자</th>
                                <th>탈퇴</th>
                            </tr>
                            </thead>
                            <tbody id="storeList"></tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="d-flex justify-content-center">
        <button class="btn btn-primary" id="loadMoreBtn" data-previous-business-number="0">더보기
        </button>
    </div>

</main>

<script>
  $(document).ready(function () {
    let currentSearchWord = '';

    loadInitialData();

    $('#searchBtn').click(function () {
      currentSearchWord = $('#searchWord').val();
      $('#storeList').empty();
      loadInitialData(currentSearchWord);
    });

    $('#loadMoreBtn').click(function () {
      let previousBusinessNumber = $(this).data('previous-user-seq');
      loadMoreData(previousBusinessNumber, currentSearchWord);
    });

    function loadInitialData(searchWord = '') {
      $.ajax({
        method: "POST",
        url: "/api/admin/store/list",
        contentType: "application/json",
        data: JSON.stringify({
          previousUserSeq: null,
          searchWord: searchWord
        }),
        dataType: "json",
        success: function (response) {
          $('#storeList').empty();
          renderData(response.storeList);
          if (response.hasMore) {
            $('#loadMoreBtn').data('previousUserSeq',
                response.storeList
                    [response.storeList
                    .length - 1].seq).show();
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function () {
          console.error("[ERROR] 데이터 초기화 중 오류 발생");
        }
      });
    }

    function loadMoreData(previousUserSeq, searchWord = '') {
      $.ajax({
        method: "POST",
        url: "/api/admin/store/list",
        contentType: "application/json",
        data: JSON.stringify({
          previousUserSeq: previousUserSeq,
          searchWord: searchWord
        }),
        dataType: "json",
        success: function (response) {
          if (response.storeList
              .length > 0) {
            renderData(response.storeList
            );
            if (response.hasMore) {
              $('#loadMoreBtn').data('previousUserSeq',
                  response.storeList
                      [response.storeList
                      .length - 1].seq).show();
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
      let htmlStr = "";
      $.map(data, function (user) {
        let formattedCreatedAt = dayjs(user["createdAt"]).format('YYYY-MM-DD HH:mm');

        htmlStr += "<tr>";
        htmlStr += "<td>" + user["nickname"] + "</td>";
        htmlStr += "<td>" + user["businessNumber"] + "</td>";
        htmlStr += "<td><a href='/brand-page?user_seq=" + user["seq"] + "'>" + user["email"]
            + "</a></td>";
        htmlStr += "<td>" + formattedCreatedAt + "</td>";
        htmlStr += "<td><button class='btn btn-danger btn-sm delete-btn' data-bs-toggle='modal' data-bs-target='#deleteModal' data-id='"
            + user["email"] + "' data-seq='" + user["seq"] + "'>X</button></td>";
        htmlStr += "</tr>";
      });
      $('#storeList').append(htmlStr);
    }

  });

  let deleteModal = document.getElementById('deleteModal');
  deleteModal.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let deleteUserEmail = button.getAttribute('data-id');
    let deleteUserSeq = button.getAttribute('data-seq');
    let modalTitle = deleteModal.querySelector('.modal-title');
    let modalBodyInput = deleteModal.querySelector('.modal-body input');

    modalTitle.textContent = '정말 탈퇴시킬까요? (ID: ' + deleteUserEmail + ')';
    modalBodyInput.value = '';

    document.getElementById('deleteForm').onsubmit = function (event) {
      event.preventDefault();
      let adminVerificationPW = modalBodyInput.value;

      fetch('/api/admin/store/' + deleteUserSeq + '?adminVerificationPW=' + encodeURIComponent(adminVerificationPW) + '&adminSeq=' + ${userSeq}, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(response => {
        if (response.status === 200) {
          return response.text().then(data => {
            console.log(data);
            alert('정상적으로 삭제 처리 되었습니다.');
            let modal = bootstrap.Modal.getInstance(deleteModal);
            modal.hide();
            location.reload();
          });
        } else if (response.status === 401) {
          modalBodyInput.classList.add('is-invalid');
          let invalidFeedback = deleteModal.querySelector('.invalid-feedback');
          if (!invalidFeedback) {
            invalidFeedback = document.createElement('div');
            invalidFeedback.classList.add('invalid-feedback');
            invalidFeedback.textContent = '비밀번호가 잘못되었습니다.';
            modalBodyInput.parentNode.appendChild(invalidFeedback);
          }
        } else {
          return response.text().then(data => {
            console.error(data);
            alert('오류가 발생했습니다. 다음에 다시 시도해주세요.');
          });
        }
      })
      .catch(error => console.error('Error:', error));
    };
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
