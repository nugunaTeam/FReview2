<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <style>
      #review-log-table th,
      #review-log-table td {
        border: 2px solid #dee2e6; /* 선 두께를 2px로 설정 */
        text-align: center;
        vertical-align: middle;
      }

      #review-log-table th {
        font-weight: bold;
      }

      #page-buttons .btn {
        margin: 0 2px;
      }

      .d-flex.justify-content-center {
        gap: 0.5rem;
      }

      #review-log-table th {
        font-weight: bold;
      }

      #page-buttons .btn {
        margin: 0 2px;
      }

    </style>

    <style>
      .form-control {
        width: 100%;
        height: 38px;
        padding: 6px 12px;
        font-size: 14px;
        line-height: 1.42857143;
        color: #555;
        background-color: #fff;
        background-image: none;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
      }

      .pagination-container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 20px;
      }

      .table-container {
        position: relative;
      }

      .profile-container img {
        width: 100%;
        height: 100%;
        object-fit: cover; /* 이미지의 중앙을 맞추고, 자르기 */
        object-position: center; /* 중앙 위치 */
      }

    </style>


    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>브랜딩 페이지</title>
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
    <link href="/assets/css/style-h.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css"
          rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
</head>

<body>


<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="/main"
           class="logo d-flex align-items-center">
            <img src="/assets/img/logo/logo-vertical.png" alt="">
            <span class="d-none d-lg-block">FReview</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div>

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
            <li class="nav-item dropdown pe-3">
                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#">
                    <img src="/user/${fromUserSeq}/profile" alt="Profile"
                         class="rounded-circle" style="margin-right: 5px;" onerror="
                            this.onerror = null;
                            this.src = ${isFromUserStore}
                            ? '/assets/img/basic/store-basic-profile.png'
                            : '/assets/img/basic/customer-basic-profile.png';">
                    <span id="nickname-holder-head"
                          class="d-none d-md-block"
                          style="font-size : 18px;">${userNickname}</span>
                </a>
            </li>
        </ul>
    </nav>
</header>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>${otherBrandInfo.nickname}님의 브랜딩 페이지</h1>
    </div><!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="card">
                <!-- profile  -->
                <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                    <img src="/user/${userSeq}/profile" alt="Profile" class="rounded-circle"
                         onerror="
                                 this.onerror = null;
                                 this.src ='/assets/img/basic/customer-basic-profile.png';">
                    <h2 id="nickname-holder-section" style="font-size: 1.5rem; margin: 0.5rem 0;">
                        ${otherBrandInfo.nickname}
                    </h2>
                    <div class="social-links mt-2"
                         style="display: flex; align-items: center; justify-content: center;">
                        <!-- 찜 버튼 -->
                        <button id="zzimButton"
                                style="background-color: #ffe6e6; border: none; font-size: 1.5rem; cursor: pointer; padding: 0.5rem 1rem; border-radius: 5px; display: flex; align-items: center; outline: none; height: 40px;">
                            <i id="heartIcon" class="ri-heart-3-fill"
                               style="margin-right: 0.7rem; color: pink;"></i>
                            <span id="zzimCount" style="font-size: 1rem; color: #333;">
                                ${otherBrandInfo.zzimCount}
                            </span>
                        </button>

                        <!-- 제안하기 버튼 -->
                        <div id="proposalButtonContainer"></div>
                    </div>
                </div>

                <!-- 모달 HTML -->
                <div class="modal fade" id="proposalModal" tabindex="-1" role="dialog"
                     aria-labelledby="proposalModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="proposalModalLabel">제안하기</h5>
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form id="proposalForm">
                                    <div class="form-group">
                                        <label for="proposalDetail">제안 내용</label>
                                        <textarea class="form-control" id="proposalDetail"
                                                  name="proposalDetail" rows="3"
                                                  required></textarea>
                                        <small style="color: mediumvioletred;">한번 전송한 제안 내용은 수정
                                            불가합니다. ( 100글자까지 입력 가능 )</small>
                                    </div>
                                    <button type="submit" class="btn btn-primary"
                                            style="border:none; background-color: mediumvioletred">
                                        제안하기
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <script>
                  $(document).ready(function () {
                    var proposed = ${proposed};  // false 또는 true
                    var isFromUserStore = ${isFromUserStore};  // true 또는 false
                    var fromUserSeq = ${fromUserSeq};
                    var userSeq = ${userSeq};

                    // 버튼을 삽입할 컨테이너
                    var $buttonContainer = $('#proposalButtonContainer');

                    // 버튼 스타일
                    var buttonStyles = {
                      border: 'none',
                      borderRadius: '5px',
                      padding: '0.5rem 1rem',
                      fontSize: '1rem',
                      marginLeft: '1rem',
                      outline: 'none'
                    };

                    var disabledButtonStyles = $.extend({}, buttonStyles, {
                      backgroundColor: 'gray',
                      color: 'white',
                      pointerEvents: 'none'
                    });

                    var enabledButtonStyles = $.extend({}, buttonStyles, {
                      backgroundColor: 'mediumvioletred',
                      color: 'white',
                      cursor: 'pointer'
                    });

                    // 버튼 생성 함수
                    function createButton(text, styles, id, disabled) {
                      var $button = $('<button></button>').text(text).css(styles);
                      if (id) $button.attr('id', id);
                      if (disabled) $button.prop('disabled', true);
                      $buttonContainer.empty().append($button);
                    }

                    if (isFromUserStore) {
                      if (proposed) {
                        createButton('제안 진행 중', disabledButtonStyles, null, true);
                      } else {
                        createButton('제안하기', enabledButtonStyles, 'openProposalModal');
                      }
                    }

                    $(document).on('click', '#openProposalModal', function () {
                      $('#proposalModal').modal('show');
                    });

                    $('#proposalForm').on('submit', function (event) {
                      event.preventDefault();

                      var proposalDetail = $('#proposalDetail').val();

                      var dataObject = {
                        customerSeq: userSeq,
                        proposalDetail: proposalDetail
                      };

                      $.ajax({
                        url: '/api/store/proposal',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(dataObject),
                        success: function () {
                          alert('해당 체험단에게 제안을 보냈습니다.');
                          createButton('제안 진행 중', disabledButtonStyles, null, true);
                          $('#proposalModal').modal('hide');
                        },
                        error: function (xhr) {
                          var errorMessage = xhr.responseJSON && xhr.responseJSON.message
                              ? xhr.responseJSON.message : '제안 전송에 실패했습니다.';
                          alert(errorMessage);
                          console.error('Error:', errorMessage); // 디버깅을 위한 로그
                        }
                      });
                    });
                  });
                </script>


                <script>
                  $(document).ready(function () {
                    var zzimed = ${zzimed};
                    if (zzimed) {
                      $('#heartIcon').css('color', 'red');
                    } else {
                      $('#heartIcon').css('color', 'white');
                    }

                    $('#zzimButton').on('click', function () {
                      const userSeq = ${userSeq};

                      const data = {
                        toUserSeq: userSeq
                      };

                      $.ajax({
                        url: '/api/other/zzim',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: function (response) {
                          if (response.zzimed) {
                            alert("해당 체험단을 찜했습니다.");
                            $('#heartIcon').css('color', 'red'); // 찜 활성화
                          } else {
                            alert("해당 체험단을 찜 취소했습니다.");
                            $('#heartIcon').css('color', 'white'); // 찜 비활성화
                          }
                          $('#zzimCount').text(response.zzimCount);
                        },
                        error: function (response) {
                          alert(response.responseText.message);
                        }
                      });
                    });
                  });
                </script>

                <div class="card-body pt-3">
                    <div class="tab-content pt-2">

                        <div class="tab-pane fade show active profile-overview"
                             id="profile-overview">

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color : blue">소개</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="introduce-input" type="text" name="to_nickname"
                                           value="${otherBrandInfo.introduce}"
                                           class="form-control" readonly>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color : blue">닉네임</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="nickname-input" type="text" name="to_nickname"
                                           value="${otherBrandInfo.nickname}"
                                           class="form-control" readonly>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3 col-md-4 label" style="color : blue">연령대</div>
                                <div class="col-lg-8 col-md-6">
                                    <input id="agegroup-input" type="text" name="to_nickname"
                                           value="${otherBrandInfo.ageGroup}"
                                           class="form-control" readonly>
                                </div>
                            </div>


                        </div>

                        <div class="row">
                            <div class="col-lg-3 col-md-4 label" style="color : blue">활동 분야</div>
                            <div class="col-lg-8 col-md-6">
                                <div id="food-type-buttons">
                                </div>
                                <p id="food-type-buttons-message" class="text-primary"
                                   style="font-size: 18px;"></p>
                            </div>
                        </div>

                        <script>
                          $(document).ready(function () {
                            const foodTypes = [
                              {value: "국밥", color: "orange"},
                              {value: "돈까스", color: "orange"},
                              {value: "족발", color: "orange"},
                              {value: "막창", color: "orange"},
                              {value: "피자", color: "mediumvioletred"},
                              {value: "파스타", color: "mediumvioletred"},
                              {value: "햄버거", color: "mediumvioletred"},
                              {value: "스테이크", color: "mediumvioletred"},
                              {value: "마라탕", color: "saddlebrown"},
                              {value: "짜장면", color: "saddlebrown"},
                              {value: "짬뽕", color: "saddlebrown"},
                              {value: "탕수육", color: "saddlebrown"},
                              {value: "텐동", color: "olivedrab"},
                              {value: "초밥", color: "olivedrab"},
                              {value: "규동", color: "olivedrab"},
                              {value: "라멘", color: "olivedrab"},
                              {value: "빵", color: "sienna"},
                              {value: "케이크", color: "sienna"},
                              {value: "쿠키", color: "sienna"},
                              {value: "샌드위치", color: "sienna"},
                              {value: "커피", color: "sienna"},
                              {value: "커리", color: "green"},
                              {value: "쌀국수", color: "green"},
                              {value: "기타", color: "green"}
                            ];

                            const foodTypeButtons = $("#food-type-buttons");

                            const selectedFoodTypes = [
                              <c:forEach var="foodType" items="${otherBrandInfo.foodTypes}">
                              '${foodType}'
                              <c:if test="${!foodType.equals(otherBrandInfo.foodTypes[otherBrandInfo.foodTypes.size()-1])}">,
                              </c:if>
                              </c:forEach>
                            ];

                            if (selectedFoodTypes.length === 0) {
                              $("#food-type-buttons-message").text("아직 선택한 활동 분야가 없어요.");
                            } else {
                              foodTypes.forEach(function (foodType) {
                                if (selectedFoodTypes.includes(foodType.value)) {
                                  const button = $("<button></button>")
                                  .text(foodType.value)
                                  .css({
                                    backgroundColor: foodType.color,
                                    border: 'none',
                                    color: 'white',
                                    padding: '10px',
                                    margin: '5px',
                                    borderRadius: '5px'
                                  })
                                  .prop('disabled', true);

                                  $("#food-type-buttons").append(button);
                                }
                              });
                            }
                          });
                        </script>


                        <div class="row">
                            <div class="col-lg-3 col-md-4 label" style="color : blue">태그</div>
                            <div class="col-lg-8 col-md-6">
                                <div id="tag-buttons"></div>
                                <p id="tag-select-message" class="text-primary"
                                   style="font-size: 18px;"></p>
                            </div>
                        </div>

                        <script>
                          $(document).ready(function () {
                            const tags = [
                              {value: "초식", color: "green"},
                              {value: "육식", color: "indianred"},
                              {value: "맛집블로거", color: "blue"},
                              {value: "정성리뷰어", color: "orange"}
                            ];

                            const selectedTags = [
                              <c:forEach var="tag" items="${otherBrandInfo.tagInfos}">
                              '${tag}'
                              <c:if test="${!tag.equals(otherBrandInfo.tagInfos[otherBrandInfo.tagInfos.size()-1])}">,
                              </c:if>
                              </c:forEach>
                            ];

                            if (selectedTags.length === 0) {
                              $("#tag-select-message").text("아직 선택한 태그가 없어요.");
                            } else {
                              tags.forEach(function (tag) {
                                if (selectedTags.includes(tag.value)) {
                                  const button = $("<button></button>")
                                  .text(tag.value)
                                  .css({
                                    backgroundColor: tag.color,
                                    border: 'none',
                                    color: 'white',
                                    padding: '10px',
                                    margin: '5px',
                                    borderRadius: '5px'
                                  })
                                  .prop('disabled', true);

                                  $("#tag-buttons").append(button);
                                }
                              });
                            }
                          });
                        </script>
                        <div class="row">
                            <div class="col-lg-3 col-md-4 label" style="color:blue">리뷰 로그</div>
                            <div class="col-lg-8 col-md-6">
                                <div class="table-container">
                                    <!-- 리뷰가 있는 경우 테이블 표시 -->
                                    <c:if test="${not empty reviewInfos}">
                                        <table class="table table-striped table-bordered text-center"
                                               id="review-log-table">
                                            <thead>
                                            <tr>
                                                <th>스토어명</th>
                                                <th>방문일자</th>
                                                <th>리뷰</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="review" items="${reviewInfos}">
                                                <c:set var="visitDate" value="${review.visitDate}"/>
                                                <tr>
                                                    <td>
                                                        <a href="/brand/${review.storeSeq}">${review.storeName}</a>
                                                    </td>
                                                    <td>${visitDate}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${review.status == 'WRITTEN'}">
                                                                <a href="${review.url}"
                                                                   class="btn btn-success btn-sm">리뷰
                                                                    보러가기</a>
                                                            </c:when>
                                                            <c:when test="${review.status == 'UNWRITTEN'}">
                                                                <button class="btn btn-sm"
                                                                        style="background-color: indianred; border-color: indianred; color: white;">
                                                                    미등록
                                                                </button>
                                                            </c:when>
                                                        </c:choose>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                        <div class="pagination-container">
                                            <button id="prev-block-button"
                                                    class="btn btn-primary edit-btn"
                                                    style="${reviewPageInfo.hasPrevious ? '' : 'display:none;'}">
                                                &lt;
                                            </button>
                                            <div id="page-buttons"
                                                 class="d-flex justify-content-center mx-2">
                                                <c:forEach var="page"
                                                           begin="${reviewPageInfo.startPage}"
                                                           end="${reviewPageInfo.endPage}">
                                                    <c:choose>
                                                        <c:when test="${page == reviewPageInfo.currentPage}">
                                                            <button class="btn btn-secondary edit-btn"
                                                                    disabled>${page}</button>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button class="btn btn-primary edit-btn"
                                                                    data-page="${page}">${page}</button>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </div>
                                            <button id="next-block-button"
                                                    class="btn btn-primary edit-btn"
                                                    style="${reviewPageInfo.hasNext ? '' : 'display:none;'}">
                                                &gt;
                                            </button>
                                        </div>
                                    </c:if>

                                    <!-- 리뷰가 없는 경우 메시지 표시 -->
                                    <c:if test="${empty reviewInfos}">
                                        <p style="font-size: 18px; color : hotpink">아직 리뷰 기록이
                                            없어요.</p>
                                    </c:if>
                                </div>
                            </div>
                        </div>

                        <script>
                          function initializePagination(reviewPageInfo) {

                            $('#prev-block-button').off('click').on('click', function () {
                              if (reviewPageInfo.hasPrevious) {
                                loadPage(reviewPageInfo.currentPage - 1);
                              }
                            });

                            $('#next-block-button').off('click').on('click', function () {
                              if (reviewPageInfo.hasNext) {
                                loadPage(reviewPageInfo.currentPage + 1);
                              }
                            });

                            $('#page-buttons').empty();
                            for (var i = reviewPageInfo.startPage; i <= reviewPageInfo.endPage;
                                i++) {
                              var pageButton = $(
                                  '<button class="btn btn-primary edit-btn" data-page="' + i
                                  + '">' + i + '</button>');
                              if (i === reviewPageInfo.currentPage) {
                                pageButton.addClass('btn-secondary').prop('disabled', true);
                              }
                              pageButton.on('click', function () {
                                var pageNumber = $(this).data('page');
                                loadPage(pageNumber);
                              });
                              $('#page-buttons').append(pageButton);
                            }

                            if (reviewPageInfo.hasPrevious) {
                              $('#prev-block-button').show();
                            } else {
                              $('#prev-block-button').hide();
                            }

                            if (reviewPageInfo.hasNext) {
                              $('#next-block-button').show();
                            } else {
                              $('#next-block-button').hide();
                            }
                          }

                          function loadPage(page) {

                            $.ajax({
                              url: '/api/customer/other/reviews',
                              method: 'POST',
                              contentType: 'application/json',
                              data: JSON.stringify({'userSeq': ${userSeq}, 'page': page}),
                              success: function (response) {
                                // 리뷰 목록 업데이트
                                var reviewInfos = response.reviewInfos;
                                var reviewLogTableBody = $('#review-log-table tbody');
                                reviewLogTableBody.empty();
                                $.each(reviewInfos, function (index, review) {
                                  var visitDate = review.visitDate;
                                  var reviewRow = '<tr>' +
                                      '<td><a href="/brand/' + review.storeSeq + '">'
                                      + review.storeName + '</a></td>' +
                                      '<td>' + visitDate + '</td>' +
                                      '<td>' + renderReviewButton(review) + '</td>' +
                                      '</tr>';
                                  reviewLogTableBody.append(reviewRow);
                                });
                                initializePagination(response.reviewPageInfo);
                              },
                              error: function (err) {
                                alert('페이지를 로드하는데 실패했습니다. 다시 시도해주세요.');
                              }
                            })
                            ;
                          }

                          function renderReviewButton(review) {
                            if (review.status === 'WRITTEN') {
                              return '<a href="' + review.url
                                  + '" class="btn btn-success btn-sm">리뷰 보러가기</a>';
                            } else if (review.status === 'UNWRITTEN') {
                              return '<button class="btn btn-sm" style="background-color: indianred; border-color: indianred; color: white;">미등록</button>';
                            }
                            return '';
                          }

                          var reviewPageInfo = {
                            currentPage: ${reviewPageInfo.currentPage},
                            startPage: ${reviewPageInfo.startPage},
                            endPage: ${reviewPageInfo.endPage},
                            hasPrevious: ${reviewPageInfo.hasPrevious},
                            hasNext: ${reviewPageInfo.hasNext}
                          };
                          initializePagination(reviewPageInfo);
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main><!-- End #main -->

<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span><a
            href="https://github.com/nugunaTeam/FReview2"> nugunaTeam </a></span></strong>.
        All
        Rights
        Reserved
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
</html>