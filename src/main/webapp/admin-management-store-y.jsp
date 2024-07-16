<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="loginUser" value="${requestScope.loginUser}"/>
<c:set var="memberSeq" value="${loginUser.memberSeq}"/>
<c:set var="nickname" value="${loginUser.nickname}"/>
<c:set var="gubun" value="${loginUser.gubun}"/>

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
                <h5 class="modal-title" id="deleteModalLabel">정말 삭제할까요?</h5><br>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                스토어 삭제를 원하시면 관리자 비밀번호를 입력해주세요
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

<!-- 스토어 등록 모달 창 -->
<div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="registerModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="registerModalLabel">스토어 등록</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                등록할 스토어의 정보를 입력해주세요
                <form id="registerForm">
                    <div class="mb-3">
                        <label for="storeName" class="form-label">스토어명</label>
                        <input type="text" class="form-control" id="storeName" name="addStoreName"
                               required>
                    </div>
                    <div class="mb-3">
                        <label for="businessNumber" class="form-label">사업자번호</label>
                        <input type="text" class="form-control" id="businessNumber"
                               name="addBusinessNumber" pattern="\d{3}-\d{2}-\d{5}"
                               placeholder="123-45-67890" required>
                    </div>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소
                    </button>
                    <button type="submit" class="btn btn-primary">등록완료</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center header-hr">
    <div class="d-flex align-items-center justify-content-between ">
        <a href="/main?seq=${memberSeq}&pagecode=Requester"
           class="logo d-flex align-items-center">
            <img src="assets/img/logo/logo-vertical.png" alt=""
                 style="  width: 50px; margin-top: 20px;">
            <span class="d-none d-lg-block">FReview</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div>
    <div class="header-hr-right">
        <a href="/my-info?member_seq=${memberSeq}" style="margin-right: 20px">
            ${nickname}
            <img src="assets/img/basic/basic-profile-img.png" alt=" " style="width: 30px;
                margin-top: 15px;">
            <%--            <img src="<%=profileURL()%>" alt=" " style="width: 30px;--%>
            <%--    margin-top: 15px;"> TODO: 세션의 프로필 url을 적용할 것--%>
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
                    <a href="/admin-member-management">
                        <i class="bi bi-circle"></i><span>멤버</span>
                    </a>
                </li>
                <li>
                    <a href="/admin-store-management" class="active">
                        <i class="bi bi-circle"></i><span>스토어</span>
                    </a>
                </li>
            </ul>
        </li>
        <ul class="sidebar-nav">
            <li class="nav-item">
                <a class="nav-link collapsed" href="/personal-info-update">
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
                        <p>전국에 등록된 스토어 리스트와 가입한 사장님 리스트입니다 <br>
                            아이디를 클릭하면 해당 멤버의 브랜딩 페이지로 이동할 수 있습니다 <br>
                            가입한 사장님이 있는 스토어는 삭제할 수 없습니다 <br>
                        </p>
                        <div class="search-container">
                            <div>
                                <input type="text" name="searchWord" id="searchWord" placeholder="원하는 키워드로 검색하세요!">
                                <input type="button" id="searchBtn" value="검색">
                            </div>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#registerModal">
                                스토어 등록
                            </button>
                        </div>

                        <table class="table">
                            <thead>
                            <tr>
                                <th>스토어명</th>
                                <th>사업자번호</th>
                                <th>가입한 사장님 아이디</th>
                                <th data-type="date" data-format="YYYY/DD/MM">사장님 가입일자</th>
                                <th>삭제</th>
                            </tr>
                            </thead>
                            <tbody id="storeList">
                            </tbody>
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
    var currentSearchWord = '';

    loadInitialData();

    $('#searchBtn').click(function () {
      currentSearchWord = $('#searchWord').val();
      $('#storeList').empty();
      loadInitialData(currentSearchWord);
    });

    $('#loadMoreBtn').click(function () {
      var previousBusinessNumber = $(this).data('previous-business-number');
      loadMoreData(previousBusinessNumber, currentSearchWord);
    });

    function loadInitialData(searchWord = '') {
      var apiUrl = searchWord ? "/admin-store-search" : "/admin-store-management";
      $.ajax({
        method: "POST",
        url: apiUrl,
        data: {
          searchWord: searchWord
        },
        dataType: "json",
        success: function (response) {
          $('#storeList').empty();
          renderData(response.data);
          if (response.hasMore) {
            $('#loadMoreBtn').data('previous-business-number',
                response.data[response.data.length - 1].businessNumber).show();
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function () {
          console.error("[ERROR] 데이터 초기화 중 오류 발생");
        }
      });
    }

    function loadMoreData(previousBusinessNumber, searchWord = '') {
      var apiUrl = searchWord ? "/admin-store-search" : "/admin-store-management";
      $.ajax({
        method: "POST",
        url: apiUrl,
        data: {
          previousBusinessNumber: previousBusinessNumber,
          searchWord: searchWord
        },
        dataType: "json",
        success: function (response) {
          if (response.data.length > 0) {
            renderData(response.data);
            if (response.hasMore) {
              console.log("hasMore = true");
              $('#loadMoreBtn').data('previous-business-number',
                  response.data[response.data.length - 1].businessNumber).show();
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

      $.map(data, function (store) {
        var storeId = store["id"] ? store["id"] : "(미가입)";
        var formattedCreatedAt = store["createdAt"] ? dayjs(store["createdAt"]).format(
            'YYYY-MM-DD HH:mm') : "";

        htmlStr += "<tr>";
        htmlStr += "<td>" + store["storeName"] + "</td>";
        htmlStr += "<td>" + store["businessNumber"] + "</td>";
        htmlStr += "<td>" + storeId + "</td>";
        htmlStr += "<td>" + formattedCreatedAt + "</td>";
        htmlStr += "<td>";
        if (store["id"] == null) {
          htmlStr += "<button class='btn btn-danger btn-sm' data-bs-toggle='modal' data-bs-target='#deleteModal' data-id='"
              + store["businessNumber"] + "'>x</button>";
        } else {
          htmlStr += "<button class='btn btn-secondary btn-sm' disabled>x</button>";
        }
        htmlStr += "</td>";
        htmlStr += "</tr>";
      });
      $('#storeList').append(htmlStr);
    }

  });

  var deleteModal = document.getElementById('deleteModal');
  deleteModal.addEventListener('show.bs.modal', function (event) {
    var button = event.relatedTarget;
    var deleteBusinessNumber = button.getAttribute('data-id');
    var modalTitle = deleteModal.querySelector('.modal-title');
    var modalBodyInput = deleteModal.querySelector('.modal-body input');

    modalTitle.textContent = '정말 삭제시킬까요? (사업자번호: ' + deleteBusinessNumber + ')';
    modalBodyInput.value = '';

    document.getElementById('deleteForm').onsubmit = function (event) {
      event.preventDefault();
      var adminVerificationPW = modalBodyInput.value;

      fetch('admin-store-delete', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'deleteBusinessNumber=' + encodeURIComponent(deleteBusinessNumber)
            + '&adminVerificationPW=' + encodeURIComponent(adminVerificationPW)
      })
      .then(response => {
        if (response.status === 200) {
          return response.text().then(data => {
            console.log(data);
            alert('정상적으로 삭제 처리 되었습니다.');
            var modal = bootstrap.Modal.getInstance(deleteModal);
            modal.hide();
            location.reload();
          });
        } else if (response.status === 401) {
          modalBodyInput.classList.add('is-invalid');
          var invalidFeedback = deleteModal.querySelector('.invalid-feedback');
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

  var registerModal = document.getElementById('registerModal');
  registerModal.addEventListener('show.bs.modal', function (event) {
    document.getElementById('registerForm').onsubmit = function (event) {
      event.preventDefault(); // Prevent default form submission

      var storeName = document.getElementById('storeName').value;
      var businessNumber = document.getElementById('businessNumber').value;

      var formData = new URLSearchParams();
      formData.append('addStoreName', storeName);
      formData.append('addBusinessNumber', businessNumber);

      fetch('/admin-store-add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: formData.toString()
      })
      .then(response => {
        if (response.status === 200) {
          return response.text().then(data => {
            console.log(data);
            alert('스토어가 성공적으로 등록되었습니다.');
            var modal = bootstrap.Modal.getInstance(registerModal);
            modal.hide();
            location.reload();
          });
        } else {
          return response.text().then(data => {
            console.error(data);
            alert('스토어 등록에 실패했습니다. 다시 시도해 주세요.');
          });
        }
      })
      .catch(error => console.error('Error:', error));

      $('#registerModal').modal('hide');
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
