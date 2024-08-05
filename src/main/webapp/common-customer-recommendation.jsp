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

    <title>추천 페이지</title>
    <meta content="" name="description">

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

    <style>
      .profile-card img {
        border-radius: 0; /* 이미지를 네모로 만듭니다 */
        width: 100%; /* 이미지를 카드의 전체 너비로 설정합니다 */
        max-width: none; /* 이미지를 카드의 전체 너비로 설정합니다 */
      }

      .profile-card {
        padding: 0; /* 카드 내부의 여백을 없앱니다 */
      }

      .col-xl-2 {
        flex: 0 0 auto;
        width: 20%;
      }

      #personalizedInfoContainer {
        border: 2px solid #007bff; /* 테두리 강조 */
        border-radius: 10px; /* 테두리 둥글게 */
        padding: 20px; /* 내부 여백 */
        margin-bottom: 20px; /* 아래 여백 */
      }

      #personalizedInfo {
        display: flex;
        flex-wrap: wrap;
      }

      #personalizedInfo .col-xl-2 {
        flex: 0 0 auto;
        width: 20%; /* 한 행에 5개의 카드가 들어가도록 설정 */
      }

      .col-md-6 {
        flex: 0 0 50%;
        max-width: 50%;
        padding: 10px;
      }

      #rankingInfoContainer {
        border: 1px solid #007bff;
        border-radius: 10px;
        padding: 20px;
        background-color: #f8f9fa;
      }

      .row {
        display: flex;
        justify-content: space-between;
      }

      .col-md-6 {
        flex: 1;
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

<main id="main" style="margin: auto; margin-top: 50px;">
    <div class="pagetitle">
        <h1>체험단 추천 페이지</h1>
    </div>

    <section class="section profile">
        <div class="row">
            <div class="col-md-6">
                <div class="tab-pane fade show active" id="customer" role="tabpanel"
                     aria-labelledby="customer-tab">
                    <form id="filterForm">
                        <div>
                            <h3>음식 유형</h3>
                            <label><input type="checkbox" name="foodType" value="한식"> 한식</label>
                            <label><input type="checkbox" name="foodType" value="양식"> 양식</label>
                            <label><input type="checkbox" name="foodType" value="중식"> 중식</label>
                            <label><input type="checkbox" name="foodType" value="일식"> 일식</label>
                            <label><input type="checkbox" name="foodType" value="베이커리"> 베이커리</label>
                            <label><input type="checkbox" name="foodType" value="기타"> 기타</label>
                        </div>
                        <div>
                            <h3>태그</h3>
                            <label><input type="checkbox" name="tag" value="초식"> 초식</label>
                            <label><input type="checkbox" name="tag" value="육식"> 육식</label>
                            <label><input type="checkbox" name="tag" value="맛집블로거"> 맛집블로거</label>
                            <label><input type="checkbox" name="tag" value="정성리뷰어"> 정성리뷰어</label>
                        </div>
                        <div>
                            <button type="submit">필터링</button>
                            <button id="resetBtn">모든 필터 제거</button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-md-6" id="rankingSection">
                <div id="rankingInfoContainer">
                    <div id="rankingInfo"></div>
                </div>
            </div>
        </div>

        <br>
        <div id="personalizedInfoSection" style="display: none;">
            <h2> ${nickname}님이 요즘 관심있을만한 체험단들을 추천해드려요 </h2>
            <div id="personalizedInfoContainer">
                <div class="row" id="personalizedInfo"></div>
            </div>
        </div>
        <h2> 전체 보기 </h2>
        <div class="row" id="customerInfo"></div>
        <div class="d-flex justify-content-center">
            <button class="btn btn-primary" id="loadMoreBtn" data-previous-user-seq="0">
                더보기
            </button>
        </div>
        </div>
    </section>
</main>

<script>
  $(document).ready(function () {
    let code = "${code}";
    if (code !== "ADMIN") {
      $('#personalizedInfoSection').show();
      loadInitialPersonalizationData();
    }

    loadInitialRankingData();
    loadInitialData();
    loadInitialPersonalizationData();

    $('#filterForm').submit(function (event) {
      event.preventDefault();
      let formData = {
        previousUserSeq: $('#previousUserSeq').val(),
        foodTypes: $('input[name="foodType"]:checked').map(function () {
          return this.value;
        }).get(),
        tags: $('input[name="tag"]:checked').map(function () {
          return this.value;
        }).get(),
        userCode: 'CUSTOMER'
      };

      loadFilteredData(JSON.stringify(formData));
    });

    $('#resetBtn').click(function () {
      $('#customerInfo').empty();
      $('input[name="foodType"]').prop('checked', false);
      $('input[name="tag"]').prop('checked', false);
      loadInitialData();
    });

    $('#loadMoreBtn').click(function () {
      let previousUserSeq = $(this).data('previous-user-seq');
      let isFiltered = $(this).data('isFiltered');
      let foodTypes = [];
      let tags = [];

      if (isFiltered) {
        $('input[name="foodType"]:checked').each(function () {
          foodTypes.push($(this).val());
        });
        $('input[name="tag"]:checked').each(function () {
          tags.push($(this).val());
        });

        loadMoreFilteredData(previousUserSeq, foodTypes, tags);
      } else {
        loadMoreData(previousUserSeq);
      }
    });

    function loadInitialData() {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation",
        contentType: "application/json",
        data: JSON.stringify({
          previousUserSeq: null,
          userCode: 'CUSTOMER'
        }),
        dataType: "json",
        success: function (response) {
          renderData(response.userList, 'customerInfo');
          if (response.hasMore) {
            $('#loadMoreBtn').data('previous-user-seq',
                response.userList[response.userList.length - 1].userSeq).show();
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function () {
          console.error("[ERROR] 추천 데이터 초기화 중 오류 발생");
        }
      });
    }

    function loadInitialPersonalizationData() {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation/personalization",
        contentType: "application/json",
        data: JSON.stringify({
          requesterSeq: ${userSeq},
          pageCode: "CUSTOMER"
        }),
        dataType: "json",
        success: function (response) {
          renderData(response.userList, 'personalizedInfo');
        },
        error: function () {
          console.error("[ERROR] 개인화 추천 데이터 초기화 중 오류 발생");
        }
      })
    }

    function loadInitialRankingData() {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation/top-performers",
        contentType: "application/json",
        data: JSON.stringify({
          pageCode: "CUSTOMER"
        }),
        dataType: "json",
        success: function (response) {
          renderRankingData(response.topPerformers, 'rankingInfo');
        },
        error: function () {
          console.error("[ERROR] 랭킹 데이터 초기화 중 오류 발생")
        }
      })
    }

    function loadFilteredData(formData) {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation/filter",
        data: formData,
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
          $('#customerInfo').html('');
          renderData(response.userList, 'customerInfo');
          if (response.hasMore) {
            $('#loadMoreBtn').data('previous-user-seq',
                response.userList[response.userList.length - 1].userSeq)
            .data('isFiltered', true)
            .show();
          } else {
            $('#loadMoreBtn').hide();
          }
        },
        error: function () {
          console.error("[ERROR] 필터링 데이터 로딩 중 오류 발생");
        }
      });
    }

    function loadMoreData(previousUserSeq) {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation",
        contentType: "application/json",
        data: JSON.stringify({
          previousUserSeq: previousUserSeq,
          userCode: 'CUSTOMER'
        }),
        dataType: "json",
        success: function (response) {
          if (response.userList.length > 0) {
            renderData(response.userList, 'customerInfo');
            if (response.hasMore) {
              $('#loadMoreBtn').data('previous-user-seq',
                  response.userList[response.userList.length - 1].userSeq).show();
            } else {
              $('#loadMoreBtn').hide();
            }
          }
        },
        error: function () {
          console.error("[ERROR] 추가 데이터 로딩 중 오류 발생");
        }
      });
    }

    function loadMoreFilteredData(previousUserSeq, foodTypes, tags) {
      $.ajax({
        method: "POST",
        url: "/api/common/recommendation/filter",
        contentType: "application/json",
        data: JSON.stringify({
          previousUserSeq: previousUserSeq,
          foodTypes: foodTypes,
          tags: tags,
          userCode: 'CUSTOMER'
        }),
        dataType: "json",
        success: function (response) {
          if (response.userList.length > 0) {
            renderData(response.userList, 'customerInfo');
            if (response.hasMore) {
              $('#loadMoreBtn').data('previous-user-seq',
                  response.userList[response.userList.length - 1].userSeq).show();
            } else {
              $('#loadMoreBtn').hide();
            }
          }
        },
        error: function (xhr, status, error) {
          console.error("[ERROR] 추가 필터링 데이터 로딩 중 오류 발생" + error);
        }
      });
    }

    function renderData(data, targetId) {
      let htmlStr = "";
      $.map(data, function (val) {
        htmlStr += "<div class='col-xl-2'>";
        htmlStr += "<div class='card'>";
        htmlStr += "<div class='card-body profile-card pt-4 d-flex flex-column align-items-center'>";
        htmlStr += "<a href='/brand/" + val["userSeq"] + `?fromUserSeq=${userSeq}'>`;
        htmlStr += "<img src='" + val["profilePhotoUrl"] + "' alt='Profile' class='profile-img'>";
        htmlStr += "<h2>" + val["nickname"] + "</h2>";

        if (val["foodTypeWord"] != null && val["foodTypeWord"] !== "") {
          htmlStr += "<h3>" + val["foodTypeWord"] + "</h3>";
        }

        if (val["tagWord"] != null && val["tagWord"] !== "") {
          htmlStr += "<h3>" + val["tagWord"] + "</h3>";
        }

        htmlStr += "</a>";
        htmlStr += "</div>";
        htmlStr += "</div>";
        htmlStr += "</div>";
      });
      $('#' + targetId).append(htmlStr);
    }

    function renderRankingData(data, targetId) {
      let htmlStr = "<div>";
      htmlStr += "<h2>지금 핫한 체험단은?</h2>";
      htmlStr += "<table>";

      let numRows = Math.ceil(data.length / 2);

      for (let i = 0; i < numRows; i++) {
        htmlStr += "<tr>";

        if (i < data.length) {
          htmlStr += "<td style='padding-right: 100px;'>" + (i + 1) + ". <a href='/brand/" + data[i]["userSeq"] + `?fromUserSeq=${userSeq}'>`
              + data[i]["nickname"] + "</a></td>";
        }

        let rightIndex = i + numRows;
        if (rightIndex < data.length) {
          htmlStr += "<td>" + (rightIndex + 1) + ". <a href='/brand/" + data[rightIndex]["userSeq"] + `?fromUserSeq=${userSeq}'>` + data[rightIndex]["nickname"] + "</a></td>";
        }

        htmlStr += "</tr>";
      }

      htmlStr += "</table>";
      htmlStr += "</div>";
      $('#' + targetId).append(htmlStr);
    }
  });
</script>

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