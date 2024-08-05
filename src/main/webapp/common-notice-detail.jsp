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

    <title>공지글 상세보기</title>
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
      table tbody tr {
        background-color: white !important;
      }

      .content-cell {
        height: 200px;
        vertical-align: top;
        white-space: pre-wrap;
      }

      .container {
        max-width: 100%;
        width: 100%;
      }

      .fixed-width {
        width: 150px;
        word-wrap: break-word;
      }

      .table {
        table-layout: fixed;
        width: 100%;
      }

      #contentEdit {
        min-height: 340px;
      }

      .button-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 20vh;
      }

      .button-container div {
        margin: 0 10px;
      }

      .like-button {
        background-color: #ff79c6 !important;
        border-color: #ff79c6 !important;
        color: #fff !important;
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

<jsp:include page="/header.jsp" />

<main id="main" style="margin:auto; margin-top:50px">
    <div class="pagetitle">
        <h1>공지 상세보기</h1>
    </div>

    <div class="card">
        <div class="card-body">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h5 class="card-title mb-0">공지</h5>
                <div>
                    <c:if test="${userSeq  == currentPost.userSeq }">
                        <button type="button" class="btn btn-danger" onclick="confirmDelete()">
                            삭제
                        </button>
                        <button type="button" class="btn btn-primary" onclick="editPost()">
                            수정
                        </button>
                    </c:if>
                    <button type="button" class="btn btn-primary"
                            onclick="location.href='/notice'">목록으로
                    </button>
                </div>
            </div>
            <form id="postForm" action="/notice/detail/update" method="post">
                <input type="hidden" name="postSeq" value="${currentPost.seq}">
                <table class="table table-bordered" style="table-layout: fixed; width: 100%;">
                    <tbody>
                    <tr>
                        <th class="fixed-width">제목</th>
                        <td>
                            <span id="titleView">${currentPost.title}</span>
                            <input type="text" class="form-control d-none" id="titleEdit"
                                   name="title" value="${currentPost.title}">
                        </td>
                    </tr>
                    <tr>
                        <th class="fixed-width">작성일자</th>
                        <td id="displayCreatedAt">${currentPost.createdAt}</td>
                    </tr>
                    <tr>
                        <th class="fixed-width">수정일자</th>
                        <td id="displayUpdatedAt">${currentPost.updatedAt}</td>
                    </tr>
                    <tr>
                        <th class="fixed-width">내용</th>
                        <td>
                                <span id="contentView"
                                      style="white-space: pre-line;">${currentPost.content}</span>
                            <textarea class="form-control d-none" id="contentEdit"
                                      name="content" rows="20">${currentPost.content}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <th class="fixed-width">조회수</th>
                        <td id="displayViewCount">${currentPost.totalView}</td>
                    </tr>
                    </tbody>
                </table>
                <div id="editButtons" class="d-none">
                    <button type="submit" class="btn btn-primary">완료</button>
                    <button type="button" class="btn btn-secondary" onclick="cancelEdit()">취소
                    </button>
                </div>
            </form>
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
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                    <button type="button" class="btn btn-danger" onclick="deletePost()">확인</button>
                </div>
            </div>
        </div>
    </div>

    <script>
      document.addEventListener('DOMContentLoaded', function () {
        // 날짜 형식 변환 함수
        function formatDate(dataString) {
          return dayjs(dataString).format('YYYY-MM-DD HH:mm');
        }

        // 초기화 시 날짜 설정
        var createdAt = "${currentPost.createdAt}";
        var updatedAt = "${currentPost.updatedAt}";
        document.getElementById('displayCreatedAt').textContent = formatDate(createdAt);
        document.getElementById('displayUpdatedAt').textContent = formatDate(updatedAt);

        function editPost() {
          $('#titleView, #contentView').addClass('d-none');
          $('#titleEdit, #contentEdit, #editButtons').removeClass('d-none');
        }

        function cancelEdit() {
          $('#titleView, #contentView').removeClass('d-none');
          $('#titleEdit, #contentEdit, #editButtons').addClass('d-none');
        }

        function confirmDelete() {
          var deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
          deleteModal.show();
        }

        // 게시글 삭제
        function deletePost() {
          let postSeq = $('input[name="postSeq"]').val();
          fetch(`/api/common/notice/${postSeq}`, {
            method: 'DELETE',
          })
          .then(response => {
            if (response.ok) {
              alert('게시글이 성공적으로 삭제되었습니다.');
              location.replace("/notice");
            } else {
              response.text().then(text => alert('게시글 삭제 실패: ' + text));
            }
          })
          .catch(error => alert('Error: ' + error));
        }

        // 폼 제출 처리
        $('#postForm').on('submit', function(e) {
          e.preventDefault();
          var postData = {
            seq: $('input[name="postSeq"]').val(),
            title: $('#titleEdit').val(),
            content: $('#contentEdit').val()
          };
          $.ajax({
            url: '/api/common/notice/update',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(postData),
            success: function(response) {
              alert('게시글이 성공적으로 업데이트되었습니다.');
              window.location.reload();
            },
            error: function(xhr, status, error) {
              alert('업데이트 실패: ' + error);
            }
          });
        });

        window.editPost = editPost;
        window.cancelEdit = cancelEdit;
        window.confirmDelete = confirmDelete;
        window.deletePost = deletePost;
      });
    </script>

</main>

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