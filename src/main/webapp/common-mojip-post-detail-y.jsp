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

    <title>모집글 상세보기</title>
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

    <style>
      .button-container {
        display: flex;
        justify-content: center;
        gap: 10px; /* 버튼 사이의 간격 조정 */
        margin-top: 20px; /* 상단 여백 추가 */
      }

      .like-button {
        background-color: #ff79c6 !important; /* 연한 분홍색 배경 */
        border-color: #ff79c6 !important; /* 연한 분홍색 테두리 */
        color: #fff !important; /* 흰색 텍스트 */
        display: inline-block !important;
      }

      .apply-button {
        display: inline-block !important;
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

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center header-hr">
    <div class="d-flex align-items-center justify-content-between ">
        <a href="/main?seq=${memberSeq}&pagecode=Requester"
           class="logo d-flex align-items-center">
            <img src="assets/img/logo/logo-vertical.png" alt=""
                 style="  width: 50px; margin-top: 20px;">
            <span class="d-none d-lg-block">FReview</span>
        </a>
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

<main id="main" style="margin:auto; margin-top:50px">
    <div class="pagetitle">
        <h1>모집</h1>
    </div>

    <div class="card">
        <div class="card-body">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h5 class="card-title mb-0">모집글 상세보기</h5>
                <div>
                    <c:if test="${memberSeq == mojipPost.memberSeq || gubun == 'A'}">
                        <button type="button" class="btn btn-danger" onclick="confirmDelete()">
                            삭제
                        </button>
                    </c:if>
                    <c:if test="${memberSeq == mojipPost.memberSeq}">
                        <button type="button" class="btn btn-primary" onclick="editPost()">수정
                        </button>
                    </c:if>
                    <button type="button" class="btn btn-secondary"
                            onclick="location.href='/mojip'">목록으로
                    </button>
                </div>
            </div>
            <div class="d-flex mb-4">
                <img src="${mojipPost.profilePhotoUrl}" alt="Profile" class="profile-img">
                <div class="ml-4">
                    <h3><a href='/brand-page?member_seq=${mojipPost.memberSeq}'>${mojipPost.storeName}</a></h3>
                    <p>분야: ${mojipPost.codeName}</p>
                    <p>태그: ${mojipPost.name}</p>
                </div>
            </div>
            <form id="postForm" action="/mojip-detail-update" method="post">
                <input type="hidden" name="postSeq" value="${mojipPost.postSeq}">
                <input type="hidden" name="writerSeq" value="${mojipPost.memberSeq}">
                <input type="hidden" name="memberSeq" value="${memberSeq}">
                <table class="table table-bordered" style="table-layout: fixed; width: 100%;">
                    <tbody>
                    <tr>
                        <th class="fixed-width">제목</th>
                        <td>
                            <span id="titleView">${mojipPost.title}</span>
                            <input type="text" class="form-control d-none" id="titleEdit"
                                   name="title" value="${mojipPost.title}">
                        </td>
                    </tr>
                    <tr>
                        <th class="fixed-width">모집 시작 일자</th>
                        <td>
                            <span id="mojipView">${mojipPost.applyStartDate}</span>
                        </td>
                    </tr>
                    <tr>
                        <th class="fixed-width">모집 종료 일자</th>
                        <td>${mojipPost.applyEndDate}</td>
                    </tr>
                    <tr>
                        <th class="fixed-width">체험 날짜</th>
                        <td>${mojipPost.experienceDate}</td>
                    </tr>
                    <tr>
                        <th class="fixed-width">체험 장소</th>
                        <td>${mojipPost.storeLocation}</td>
                    </tr>
                    <tr>
                        <th class="fixed-width">내용</th>
                        <td>
                            <span id="contentView"
                                  style="white-space: pre-line;">${mojipPost.content}</span>
                            <textarea class="form-control d-none" id="contentEdit" name="content"
                                      rows="10">${mojipPost.content}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <th class="fixed-width">좋아요 수</th>
                        <td>${mojipPost.numberOfLikes}</td>
                    </tr>
                    </tbody>
                </table>
                <div id="editButtons" class="d-none">
                    <button type="submit" class="btn btn-primary">완료</button>
                    <button type="button" class="btn btn-secondary" onclick="cancelEdit()">취소
                    </button>
                </div>
            </form>
            <div id="likeButtons" class="button-container text-center">
                <c:if test="${gubun == 'B' || gubun == 'C'}">
                    <c:choose>
                        <c:when test="${isLiked}">
                            <button type="button" class="btn btn-primary like-button"
                                    onclick="cancelLike(${mojipPost.postSeq}, ${applicantSeq})">
                                <i class="bi bi-heart-fill me-1"></i> 좋아요
                            </button>
                        </c:when>
                        <c:otherwise>
                            <button type="button" class="btn btn-primary like-button"
                                    onclick="addLike(${mojipPost.postSeq}, ${applicantSeq})">
                                <i class="bi bi-heart me-1"></i> 좋아요
                            </button>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <c:if test="${gubun == 'C'}">
                    <button type="button" class="btn btn-primary apply-button"
                            data-bs-toggle="modal" data-bs-target="#applyModal">지원하기
                    </button>
                </c:if>
            </div>
        </div>
    </div>

    <div class="modal fade" id="applyModal" tabindex="-1" aria-labelledby="applyModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="applyModalLabel">지원 확인</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    정말 지원하겠습니까?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소
                    </button>
                    <button type="button" class="btn btn-danger" onclick="applyPost()">확인</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">삭제 확인</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    정말 삭제하겠습니까?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소
                    </button>
                    <button type="button" class="btn btn-danger" onclick="deletePost()">확인</button>
                </div>
            </div>
        </div>
    </div>
</main>

<script>
  function editPost() {
    document.getElementById('titleView').classList.add('d-none');
    document.getElementById('titleEdit').classList.remove('d-none');
    document.getElementById('contentView').classList.add('d-none');
    document.getElementById('contentEdit').classList.remove('d-none');
    document.getElementById('editButtons').classList.remove('d-none');
    document.getElementById('likeButtons').style.display = 'none';
  }

  function cancelEdit() {
    document.getElementById('titleView').classList.remove('d-none');
    document.getElementById('titleEdit').classList.add('d-none');
    document.getElementById('contentView').classList.remove('d-none');
    document.getElementById('contentEdit').classList.add('d-none');
    document.getElementById('editButtons').classList.add('d-none');
    document.getElementById('likeButtons').style.display = 'flex';
  }

  function applyPost() {
    var postSeq = document.querySelector('input[name="postSeq"]').value;
    var writerSeq = document.querySelector('input[name="writerSeq"]').value;
    var memberSeq = document.querySelector('input[name="memberSeq"]').value;

    var formData = new URLSearchParams();
    formData.append('postSeq', postSeq);
    formData.append('writerSeq', writerSeq);
    formData.append('memberSeq', memberSeq);

    fetch('/mojip-detail-apply', {
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
          alert('성공적으로 지원되었습니다.');
          location.reload();
        });
      } else {
        response.text().then(data => {
          console.error(data);
          alert('지원에 실패했습니다. 다시 시도해 주세요.');
        });
      }
    })
    .catch(error => console.error('Error:', error));
  }

  function confirmDelete() {
    var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
    deleteModal.show();
  }

  document.getElementById('postForm').addEventListener('submit', function (event) {
    event.preventDefault();

    var formData = new URLSearchParams(new FormData(this));

    fetch('/mojip-detail-update', {
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
          alert('게시글이 성공적으로 수정되었습니다.');
          location.replace("/mojip");
        });
      } else {
        response.text().then(data => {
          console.error(data);
          alert('게시글 수정에 실패했습니다. 다시 시도해 주세요.');
        });
      }
    })
    .catch(error => console.error('Error:', error));
  });

  function deletePost() {
    var postSeq = document.querySelector('input[name="postSeq"]').value;

    fetch('/mojip-detail-delete', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      body: new URLSearchParams({postSeq: postSeq}).toString()
    })
    .then(response => {
      if (response.ok) {
        return response.text().then(data => {
          console.log(data);
          alert('게시글이 성공적으로 삭제되었습니다.');
          location.replace("/mojip");
        });
      } else {
        response.text().then(data => {
          console.error(data);
          alert('게시글 삭제에 실패했습니다. 다시 시도해 주세요.');
        });
      }
    })
    .catch(error => console.error('Error:', error));
  }

  function addLike(postSeq) {
    fetch('/likes-add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      body: new URLSearchParams({
        postSeq: postSeq,
        memberSeq: ${memberSeq}
      }).toString()
    })
    .then(response => {
      if (response.ok) {
        location.reload();
      } else {
        alert('좋아요를 추가하는 데 실패했습니다. 다시 시도해 주세요.');
      }
    })
    .catch(error => {
      console.error('Error:', error);
      alert('좋아요를 추가하는 도중 오류가 발생했습니다.');
    });
  }

  function cancelLike(postSeq, applicantSeq) {
    fetch('/likes-cancel', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      body: new URLSearchParams({
        postSeq: postSeq,
        memberSeq: ${memberSeq}
      }).toString()
    })
    .then(response => {
      if (response.ok) {
        location.reload();
      } else {
        alert('좋아요를 취소하는 데 실패했습니다. 다시 시도해 주세요.');
      }
    })
    .catch(error => {
      console.error('Error:', error);
      alert('좋아요를 취소하는 도중 오류가 발생했습니다.');
    });
  }
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