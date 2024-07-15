<%--
  Created by IntelliJ IDEA.
  User: rlagk
  Date: 2024-06-04
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Pages / Register - NiceAdmin Bootstrap Template</title>
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
    <link href="assets/css/hr.css" rel="stylesheet">
    <!-- =======================================================
    * Template Name: NiceAdmin
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Updated: Apr 20 2024 with Bootstrap v5.3.3
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body>

<main>
    <div class="container">

        <section
                class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                        <div class="d-flex justify-content-center py-4">
                            <a href="#" class="logo d-flex align-items-center w-auto">
                                <img src="assets/img/logo/logo-vertical.png" alt="" style="width: 50px;
    margin-top: 20px;">
                                <span class="d-none d-lg-block">Freview</span>
                            </a>
                        </div><!-- End Logo -->

                        <div class="card mb-3">

                            <div class="card-body">

                                <div class="pt-4 pb-2">
                                    <h5 class="card-title text-center pb-0 fs-4">회원가입</h5>
                                </div>
                                <div class="card">
                                    <div class="card-body" style=width:500px>
                                        <!-- Bordered Tabs Justified -->
                                        <ul class="nav nav-tabs nav-tabs-bordered d-flex"
                                            id="borderedTabJustified" role="tablist">
                                            <li class="nav-item flex-fill" role="presentation">
                                                <button class="nav-link w-100" id="home-tab"
                                                        data-bs-toggle="tab"
                                                        data-bs-target="#bordered-justified-home"
                                                        type="button" role="tab"
                                                        aria-controls="home" aria-selected="false"
                                                        tabindex="-1">체험단
                                                </button>
                                            </li>
                                            <li class="nav-item flex-fill" role="presentation">
                                                <button class="nav-link w-100 active"
                                                        id="profile-tab" data-bs-toggle="tab"
                                                        data-bs-target="#bordered-justified-profile"
                                                        type="button" role="tab"
                                                        aria-controls="profile"
                                                        aria-selected="true">사장님
                                                </button>
                                            </li>
                                        </ul>
                                        <div class="tab-content pt-2"
                                             id="borderedTabJustifiedContent">
                                            <div class="tab-pane fade" id="bordered-justified-home"
                                                 role="tabpanel" aria-labelledby="home-tab">
                                                <p>협찬을 제공받고 온라인 리뷰를 제출하는 체험단 입니다</p>
                                                <form class="row g-3 needs-validation"
                                                      id="COMM_register_form_reviewer_regist"
                                                      novalidate>
                                                    <div class="col-12">
                                                        <label for="Input_ID"
                                                               class="form-label">아이디</label>
                                                        <div style=display:flex>
                                                            <input type="text" name="id"
                                                                   class="form-control"
                                                                   id="Input_ID" required>
                                                            <button type="button"
                                                                    class="btn btn-outline-primary"
                                                                    id="COMM_register_IDcheckBTN"
                                                                    style=
                                                                            "text-align: center;
                                                                    font-size: 13px;
                                                                    width: 110px;
                                                                    margin-left: 5px; "
                                                            >중복확인
                                                            </button>
                                                        </div>
                                                        <div class="invalid-feedback">아이디를 입력해주세요
                                                        </div>
                                                        <div id="COMM_register_IDavail"
                                                             class="remove"
                                                             style=color:cornflowerblue>아이디 사용 가능합니다
                                                        </div>
                                                        <div id="COMM_register_IDdeny"
                                                             class="remove" style=color:red>아이디 사용
                                                            불가합니다
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="Input_pw" class="form-label">비밀번호</label>
                                                        <input type="password" name="password"
                                                               class="form-control" id="Input_pw"
                                                               required>
                                                        <div class="invalid-feedback">Please enter
                                                            your password!
                                                        </div>
                                                        <div id="COMM_register_pwdeny"
                                                             class="remove" style=color:red>영문 숫자
                                                            특수기호 조합 8자리 이상을 입력해주세요
                                                        </div>
                                                        <div id="COMM_register_pwvali"
                                                             class="remove"
                                                             style=color:cornflowerblue>비밀번호 사용
                                                            가능합니다
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="Input_PasswordCheck"
                                                               class="form-label">비밀번호확인</label>
                                                        <input type="password" class="form-control"
                                                               id="Input_PasswordCheck" required>
                                                        <div id="COMM_register_pwCheckdeny"
                                                             class="remove" style=color:red>비밀번호를
                                                            확인해주세요
                                                        </div>
                                                        <div id="COMM_register_pwCheckvali"
                                                             class="remove"
                                                             style=color:cornflowerblue>통과
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="COMM_register_input_email"
                                                               class="form-label">이메일</label>
                                                        <div style=display:flex>
                                                            <input type="email" name="email"
                                                                   class="form-control"
                                                                   id="COMM_register_input_email"
                                                                   required>
                                                            <button type="button"
                                                                    class="btn btn-outline-primary"
                                                                    id="COMM_register_emailBtn"
                                                                    style=
                                                                            "text-align: center;
                                                                    font-size: 13px;
                                                                    width: 110px;
                                                                    margin-left: 5px; "
                                                            >인증번호
                                                            </button>
                                                        </div>
                                                        <div class="invalid-feedback">이메일을 입력해주세요
                                                        </div>
                                                        <div class="col-12">
                                                            <label for="COMM_register_input_emailNumber"
                                                                   class="form-label">인증번호확인</label>
                                                            <div style=display:flex>
                                                                <input type="email" name="text"
                                                                       class="form-control"
                                                                       id="COMM_register_input_emailNumber"
                                                                       required disabled>
                                                                <button type="button"
                                                                        class="btn btn-outline-primary"
                                                                        id="COMM_register_emailNumberBtn"
                                                                        style=
                                                                                "text-align: center;
                                                                    font-size: 13px;
                                                                    width: 110px;
                                                                    margin-left: 5px; "
                                                                        disabled>확인
                                                                </button>
                                                            </div>
                                                            <div id="COMM_register_emailCheckNumberVali"
                                                                 class="remove"
                                                                 style=color:cornflowerblue>인증 성공
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="col-12">
                                                        <label for="Input_ID"
                                                               class="form-label">닉네임</label>
                                                        <div style=display:flex>
                                                            <input type="text" name="nickname"
                                                                   class="form-control"
                                                                   id="Input_NickName" required>
                                                            <button type="button"
                                                                    class="btn btn-outline-primary"
                                                                    id="COMM_register_NickNamecheckBTN"
                                                                    style=
                                                                            "text-align: center;
                                                                    font-size: 13px;
                                                                    width: 110px;
                                                                    margin-left: 5px; "
                                                            >중복확인
                                                            </button>
                                                        </div>
                                                        <div class="invalid-feedback">닉네임을 입력해주세요
                                                        </div>
                                                        <div id="COMM_register_NickNameavail"
                                                             class="remove"
                                                             style=color:cornflowerblue>닉네임 사용 가능합니다
                                                        </div>
                                                        <div id="COMM_register_NickNamedeny"
                                                             class="remove" style=color:red>닉네임 사용
                                                            불가합니다
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="Input_AgeGroup"
                                                               class="form-label">연령대</label>
                                                        <select id="Input_AgeGroup" name="agegroup"
                                                                style="margin-left: 10px;
                                                                        width: 100px;"
                                                                required>
                                                            <option value="10대">10대</option>
                                                            <option value="20대">20대</option>
                                                            <option value="30대">30대</option>
                                                            <option value="40대">40대</option>
                                                            <option value="50대">50대</option>
                                                            <option value="60대">60대</option>
                                                            <option value="70대">70대</option>
                                                            <option value="80대">80대</option>
                                                            <option value="90대">90대</option>
                                                        </select>
                                                        <div class="invalid-feedback">연령대를 입력해주세요
                                                        </div>
                                                    </div>
                                                    <div class="col-12">

                                                        <div class="form-check">
                                                            <input class="form-check-input"
                                                                   name="terms" type="checkbox"
                                                                   value=""
                                                                   id="reviewer_acceptTerms"
                                                                   required disabled>
                                                            <button type="button"
                                                                    class="btn btn-primary"
                                                                    data-bs-toggle="modal"
                                                                    data-bs-target="#modalDialogScrollable"
                                                                    style="color: blue;
                                                                           background: none;
                                                                           border: none;"
                                                            >
                                                                개인정보 및 이용약관에 동의합니다.
                                                            </button>
                                                            <div class="modal fade"
                                                                 id="modalDialogScrollable"
                                                                 tabindex="-1">
                                                                <div class="modal-dialog modal-dialog-scrollable">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title">
                                                                                개인정보 및 이용약관</h5>
                                                                            <button type="button"
                                                                                    class="btn-close"
                                                                                    data-bs-dismiss="modal"
                                                                                    aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="modal-body">
                                                                            <h4>개인정보 수집 및 이용약관</h4>
                                                                            <h5>1. 개인정보의 수집 및 이용
                                                                                목적</h5>
                                                                            <p>1.1. 식당 리뷰를 작성하는 체험단
                                                                                회원에게서는 다음과 같은 개인정보를
                                                                                수집합니다.</p>
                                                                            <ul>
                                                                                <li>성명</li>
                                                                                <li>연락처 (이메일 주소,
                                                                                    전화번호 등)
                                                                                </li>
                                                                                <li>나이 또는 생년월일</li>
                                                                                <li>거주지 (선택사항)</li>
                                                                                <li>SNS 계정 정보
                                                                                    (선택사항)
                                                                                </li>
                                                                            </ul>
                                                                            <h5>2. 개인정보의 수집 방법</h5>
                                                                            <p>2.1. 개인정보는 회원 가입 시,
                                                                                서비스 이용 과정에서 자발적으로
                                                                                제공되는 경우, 이벤트나 프로모션
                                                                                참여 시 수집될 수 있습니다.</p>
                                                                            <h5>3. 개인정보의 이용</h5>
                                                                            <p>3.1. 체험단 회원의 개인정보는
                                                                                다음과 같은 목적으로
                                                                                이용됩니다.</p>

                                                                            <h5>4. 개인정보의 보유 및 이용
                                                                                기간</h5>
                                                                            4.1. 개인정보는 회원 탈퇴 시 또는
                                                                            개인정보 보호 및 관리 정책에 따라 명시된
                                                                            기간 이후에는 파기됩니다.

                                                                            <h5>5. 개인정보의 제3자 제공</h5>
                                                                            5.1. 회사는 법령에 따른 경우 또는
                                                                            회원의 동의가 있는 경우를 제외하고는
                                                                            개인정보를 외부에 제공하지 않습니다.

                                                                            <h5>6. 개인정보의 파기 절차 및
                                                                                방법</h5>
                                                                            6.1. 개인정보는 수집 및 이용 목적이
                                                                            달성된 후에는 관련 법령에 따라 안전하게
                                                                            파기됩니다.

                                                                            <h5>7. 개인정보 관리책임자 및
                                                                                연락처</h5>
                                                                            7.1. 회원은 개인정보에 관한 불만이나
                                                                            문의사항을 개인정보 관리책임자에게 연락할 수
                                                                            있습니다.
                                                                            <ul>
                                                                                <li>이름: 윤승</li>
                                                                                <li>이메일:
                                                                                    yoon@gmail.com
                                                                                </li>
                                                                                <li>전화번호:
                                                                                    010-7777-7777
                                                                                </li>
                                                                            </ul>

                                                                            <h5>8. 기타</h5>
                                                                            8.1. 본 약관은 법령이나 회사의 정책
                                                                            변경에 따라 수정될 수 있으며, 변경 사항은
                                                                            서비스 내 공지를 통해 고지됩니다.

                                                                            <p>위의 개인정보 수집 및 이용약관은
                                                                                회원가입 시 동의 후 서비스를
                                                                                이용하실 수 있습니다. 이를
                                                                                참고하시어 동의 여부를 결정해주시기
                                                                                바랍니다.</p>

                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button"
                                                                                    class="btn btn-secondary"
                                                                                    data-bs-dismiss="modal"
                                                                                    id="COMM_register_reviewer_disagreebtn">
                                                                                나가기
                                                                            </button>
                                                                            <button type="button"
                                                                                    class="btn btn-primary"
                                                                                    id="COMM_register_reviewer_agreebtn">
                                                                                동의
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="invalid-feedback">You must
                                                                agree before submitting.
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <button class="btn btn-primary w-100"
                                                                type="button"
                                                                id="COMM_register_btn_reviewer_regist">
                                                            회원가입
                                                        </button>
                                                    </div>
                                                    <div class="col-12">
                                                        <p class="small mb-0">Already have an
                                                            account? <a href="pages-login.html">Log
                                                                in</a></p>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="tab-pane fade active show"
                                                 id="bordered-justified-profile" role="tabpanel"
                                                 aria-labelledby="profile-tab">
                                                <p>협찬을 제공하고 온라인 리뷰를 제공받는 사장님 입니다</p>
                                                <form class="row g-3 needs-validation"
                                                      id="COMM_register_form_Boss_regist"
                                                      novalidate>
                                                    <div class="col-12">
                                                        <label for="Input_ID"
                                                               class="form-label">아이디</label>
                                                        <div style=display:flex>
                                                            <input type="text" name="id"
                                                                   class="form-control"
                                                                   id="Boss_Input_ID" required>
                                                            <button type="button"
                                                                    class="btn btn-outline-primary"
                                                                    id="COMM_register_Boss_IDcheckBTN"
                                                                    style=
                                                                            "text-align: center;
                                                                    font-size: 13px;
                                                                    width: 110px;
                                                                    margin-left: 5px; "
                                                            >중복확인
                                                            </button>
                                                        </div>
                                                        <div class="invalid-feedback">아이디를 입력해주세요
                                                        </div>
                                                        <div id="COMM_register_Boss_IDavail"
                                                             class="remove"
                                                             style=color:cornflowerblue>아이디 사용 가능합니다
                                                        </div>
                                                        <div id="COMM_register_Boss_IDdeny"
                                                             class="remove" style=color:red>아이디 사용
                                                            불가합니다
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="Input_Boss_pw"
                                                               class="form-label">비밀번호</label>
                                                        <input type="password" name="password"
                                                               class="form-control"
                                                               id="Input_Boss_pw" required>
                                                        <div class="invalid-feedback">비밀번호를 입력하세요!
                                                        </div>
                                                        <div id="COMM_register_Boss_pwdeny"
                                                             class="remove" style=color:red>영문 숫자
                                                            특수기호 조합 8자리 이상을 입력해주세요
                                                        </div>
                                                        <div id="COMM_register_Boss_pwvali"
                                                             class="remove"
                                                             style=color:cornflowerblue>비밀번호 사용
                                                            가능합니다
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="Input_Boss_PasswordCheck"
                                                               class="form-label">비밀번호확인</label>
                                                        <input type="password" class="form-control"
                                                               id="Input_Boss_PasswordCheck"
                                                               required>
                                                        <div id="COMM_register_Boss_pwCheckdeny"
                                                             class="remove" style=color:red>비밀번호를
                                                            확인해주세요
                                                        </div>
                                                        <div id="COMM_register_Boss_pwCheckvali"
                                                             class="remove"
                                                             style=color:cornflowerblue>통과
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="COMM_register_input_Boss_email"
                                                               class="form-label">이메일</label>
                                                        <div style=display:flex>
                                                            <input type="email" name="email"
                                                                   class="form-control"
                                                                   id="COMM_register_input_Boss_email"
                                                                   required>
                                                            <button type="button"
                                                                    class="btn btn-outline-primary"
                                                                    id="COMM_register_Boss_emailBtn"
                                                                    style=
                                                                            "text-align: center;
                                                                    font-size: 13px;
                                                                    width: 110px;
                                                                    margin-left: 5px; "
                                                            >인증번호
                                                            </button>
                                                        </div>
                                                        <div class="invalid-feedback">이메일을 입력해주세요
                                                        </div>
                                                        <div class="col-12">
                                                            <label for="COMM_register_input_Boss_emailNumber"
                                                                   class="form-label">인증번호확인</label>
                                                            <div style=display:flex>
                                                                <input type="email" name="text"
                                                                       class="form-control"
                                                                       id="COMM_register_input_Boss_emailNumber"
                                                                       required disabled>
                                                                <button type="button"
                                                                        class="btn btn-outline-primary"
                                                                        id="COMM_register_Boss_emailNumberBtn"
                                                                        style=
                                                                                "text-align: center;
                                                                    font-size: 13px;
                                                                    width: 110px;
                                                                    margin-left: 5px; "
                                                                        disabled>확인
                                                                </button>
                                                            </div>
                                                            <div id="COMM_register_Boss_emailCheckNumberVali"
                                                                 class="remove"
                                                                 style=color:cornflowerblue>인증 성공
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="Input_Boss_NickName"
                                                               class="form-label">닉네임</label>
                                                        <div style=display:flex>
                                                            <input type="text" name="nickname"
                                                                   class="form-control"
                                                                   id="Input_Boss_NickName"
                                                                   required>
                                                            <button type="button"
                                                                    class="btn btn-outline-primary"
                                                                    id="COMM_register_Boss_NickNamecheckBTN"
                                                                    style=
                                                                            "text-align: center;
                                                                    font-size: 13px;
                                                                    width: 110px;
                                                                    margin-left: 5px; "
                                                            >중복확인
                                                            </button>
                                                        </div>
                                                        <div class="invalid-feedback">닉네임을 입력해주세요
                                                        </div>
                                                        <div id="COMM_register_Boss_NickNameavail"
                                                             class="remove"
                                                             style=color:cornflowerblue>닉네임 사용 가능합니다
                                                        </div>
                                                        <div id="COMM_register_Boss_NickNamedeny"
                                                             class="remove" style=color:red>닉네임 사용
                                                            불가합니다
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="Input_Boss_AgeGroup"
                                                               class="form-label">연령대</label>
                                                        <select id="Input_Boss_AgeGroup"
                                                                name="agegroup"
                                                                style="margin-left: 10px;
                                                                        width: 100px;"
                                                                required>
                                                            <option value="10대">10대</option>
                                                            <option value="20대">20대</option>
                                                            <option value="30대">30대</option>
                                                            <option value="40대">40대</option>
                                                            <option value="50대">50대</option>
                                                            <option value="60대">60대</option>
                                                            <option value="70대">70대</option>
                                                            <option value="80대">80대</option>
                                                            <option value="90대">90대</option>
                                                        </select>
                                                        <div class="invalid-feedback">연령대를 입력해주세요
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="COMM_register_input_Boss_buisnessInfo"
                                                               class="form-label">사업자등록번호</label>
                                                        <div style="display:flex">
                                                            <input type="text" class="form-control"
                                                                   id="COMM_register_input_Boss_buisnessInfo"
                                                                   name="buisness_number"
                                                                   placeholder="000-00-00000 형식으로 입력"
                                                                   required>
                                                            <button type="button"
                                                                    class="btn btn-outline-primary"
                                                                    id="COMM_register_Boss_buisnessInfobts"
                                                                    style=
                                                                            "text-align: center;
                                                                        font-size: 9px;
                                                                        width: 110px;
                                                                        margin-left: 5px; "
                                                            >사업자인증하기
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <div class="invalid-feedback">사업자등록번호를 입력해주세요
                                                    </div>
                                                    <div id="COMM_register_Boss_buisnessInfoavail"
                                                         class="remove" style=color:cornflowerblue>
                                                        인증 완료되었습니다
                                                    </div>
                                                    <div id="COMM_register_Boss_buisnessInfoDuplicatedvali"
                                                         class="remove" style=color:cornflowerblue>
                                                        가입 가능한 사업자등록번호입니다
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="COMM_register_input_Boss_addressbtn"
                                                               class="form-label">주소 검색</label>
                                                        <button type="button"
                                                                class="btn btn-outline-primary"
                                                                id="COMM_register_input_Boss_addressbtn"
                                                                style=
                                                                        "text-align: center;
                                                                    font-size: 9px;
                                                                    width: 210px;
                                                                    margin-left: 5px; " disabled>
                                                            주소검색
                                                        </button>
                                                    </div>
                                                    <div class="col-12">
                                                        <label for="COMM_register_input_Boss_buisnessaddress"
                                                               class="form-label">사업자 주소</label>
                                                        <input type="text" class="form-control"
                                                               name="store_loc"
                                                               id="COMM_register_input_Boss_buisnessaddress"
                                                               required disabled>
                                                    </div>

                                                    <div class="col-12">
                                                        <div class="form-check">
                                                            <input class="form-check-input"
                                                                   name="terms" type="checkbox"
                                                                   value=""
                                                                   id="reviewer_Boss_acceptTerms"
                                                                   required disabled>
                                                            <button type="button"
                                                                    class="btn btn-primary"
                                                                    data-bs-toggle="modal"
                                                                    data-bs-target="#modalDialogScrollable1"
                                                                    style="color: blue;
                                                                           background: none;
                                                                           border: none;"
                                                            >
                                                                개인정보 및 이용약관에 동의합니다.
                                                            </button>
                                                            <div class="modal fade"
                                                                 id="modalDialogScrollable1"
                                                                 tabindex="-1">
                                                                <div class="modal-dialog modal-dialog-scrollable">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title">
                                                                                개인정보 및 이용약관</h5>
                                                                            <button type="button"
                                                                                    class="btn-close"
                                                                                    data-bs-dismiss="modal"
                                                                                    aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="modal-body">
                                                                            <h4>개인정보 수집 및 이용약관</h4>
                                                                            <h5>1. 개인정보의 수집 및 이용
                                                                                목적</h5>
                                                                            <p>1.2. 식당을 운영하는 사장님으로서
                                                                                회원 가입하는 경우, 다음과 같은
                                                                                개인정보를 수집합니다.</p>
                                                                            <ul>
                                                                                <li>사업자 등록 번호</li>
                                                                                <li>업체명 또는 상호</li>
                                                                                <li>대표자 성명</li>
                                                                                <li>대표자 연락처</li>
                                                                                <li>사업장 주소</li>
                                                                            </ul>
                                                                            <h5>2. 개인정보의 수집 방법</h5>
                                                                            <p>2.1. 개인정보는 회원 가입 시,
                                                                                서비스 이용 과정에서 자발적으로
                                                                                제공되는 경우, 이벤트나 프로모션
                                                                                참여 시 수집될 수 있습니다.</p>
                                                                            <h5>3. 개인정보의 이용</h5>
                                                                            <p>3.2. 사장님 회원의 개인정보는
                                                                                다음과 같은 목적으로
                                                                                이용됩니다.</p>

                                                                            <h5>4. 개인정보의 보유 및 이용
                                                                                기간</h5>
                                                                            4.1. 개인정보는 회원 탈퇴 시 또는
                                                                            개인정보 보호 및 관리 정책에 따라 명시된
                                                                            기간 이후에는 파기됩니다.

                                                                            <h5>5. 개인정보의 제3자 제공</h5>
                                                                            5.1. 회사는 법령에 따른 경우 또는
                                                                            회원의 동의가 있는 경우를 제외하고는
                                                                            개인정보를 외부에 제공하지 않습니다.

                                                                            <h5>6. 개인정보의 파기 절차 및
                                                                                방법</h5>
                                                                            6.1. 개인정보는 수집 및 이용 목적이
                                                                            달성된 후에는 관련 법령에 따라 안전하게
                                                                            파기됩니다.

                                                                            <h5>7. 개인정보 관리책임자 및
                                                                                연락처</h5>
                                                                            7.1. 회원은 개인정보에 관한 불만이나
                                                                            문의사항을 개인정보 관리책임자에게 연락할 수
                                                                            있습니다.
                                                                            <ul>
                                                                                <li>이름: 윤승</li>
                                                                                <li>이메일:
                                                                                    yoon@gmail.com
                                                                                </li>
                                                                                <li>전화번호:
                                                                                    010-7777-7777
                                                                                </li>
                                                                            </ul>

                                                                            <h5>8. 기타</h5>
                                                                            8.1. 본 약관은 법령이나 회사의 정책
                                                                            변경에 따라 수정될 수 있으며, 변경 사항은
                                                                            서비스 내 공지를 통해 고지됩니다.

                                                                            <p>위의 개인정보 수집 및 이용약관은
                                                                                회원가입 시 동의 후 서비스를
                                                                                이용하실 수 있습니다. 이를
                                                                                참고하시어 동의 여부를 결정해주시기
                                                                                바랍니다.</p>

                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button"
                                                                                    class="btn btn-secondary"
                                                                                    data-bs-dismiss="modal"
                                                                                    id="COMM_register_Boss_disagreebtn">
                                                                                나가기
                                                                            </button>
                                                                            <button type="button"
                                                                                    class="btn btn-primary"
                                                                                    id="COMM_register_Boss_agreebtn">
                                                                                동의
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                        <div class="col-12">
                                                            <button class="btn btn-primary w-100"
                                                                    id="COMM_register_btn_Boss_regist"
                                                                    type="submit">회원가입
                                                            </button>
                                                        </div>
                                                        <div class="col-12">
                                                            <p class="small mb-0">Already have an
                                                                account? <a href="pages-login.html">Log
                                                                    in</a></p>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div><!-- End Bordered Tabs Justified -->
                                    </div>
                                </div>


                            </div>
                        </div>

                        <div class="credits">
                            <!-- All the links in the footer should remain intact. -->
                            <!-- You can delete the links only if you purchased the pro version. -->
                            <!-- Licensing information: https://bootstrapmade.com/license/ -->
                            <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                        </div>

                    </div>
                </div>
            </div>

        </section>

    </div>
</main><!-- End #main -->

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
<script src="assets/js/hr.js"></script>
</body>

</html>