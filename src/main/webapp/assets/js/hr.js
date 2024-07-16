
$(function(){

  let COMM_register_idCheck = false; // 아이디 중복확인 체크
  let COMM_register_pwCheck = false; // 비밀번호확인 체크
  let COMM_register_emailNumberCheck = false; // 이메일 인증번호 확인 체크
  let COMM_register_nickNameCheck = false;
  let COMM_register_acceptTerms = false; // 개인정보 및 이용약관 체크 확인

  let COMM_register_businessInfo = false;
  let COMM_register_buisnessloc = false;

  $("#COMM_register_IDcheckBTN").on("click",function(){ //COMM_register 아이디체크


    let inputID = $("#Input_ID").val();

    $.ajax({
      method: "post",
      url : "/auth?pagecode=checkID",
      data : {"id" : inputID},
      error: function(myval){console.log("에러"+myval)},
      success: function(myval){
        console.log("성공"+myval);

        if (myval == 1) {
          $("#COMM_register_IDdeny").removeClass("remove");
          $("#COMM_register_IDavail").addClass("remove");
          $("#Input_ID").val("");
        } else {
          $("#COMM_register_IDavail").removeClass("remove");
          COMM_register_idCheck = true;
        }

      }
    })

  });


$("#Input_pw").change(function(){ // COMM_register 비밀번호 형식 확인

  let reg = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$/
  let val = $("#Input_pw").val();



  if(reg.test(val)){
    $("#COMM_register_pwvali").removeClass("remove");
    $("#COMM_register_pwdeny").addClass("remove");
  }else if(val===""){
    $("#COMM_register_pwdeny").addClass("remove");
    $("#COMM_register_pwvali").addClass("remove");
  }
  else{
    $("#COMM_register_pwdeny").removeClass("remove");
    $("#Input_pw").val("");
    $("#COMM_register_pwvali").addClass("remove");
  }

})

 $("#Input_PasswordCheck") .change(function(){ // COMM_register 비밀번호 확인하기

   let pw = $("#Input_pw").val();
   let pwCheck = $("#Input_PasswordCheck").val();

   if(pw===pwCheck){
     $("#COMM_register_pwCheckvali").removeClass("remove");
     $("#COMM_register_pwCheckdeny").addClass("remove");
     COMM_register_pwCheck = true;
   }else if(pwCheck===""&&pw===""){
     $("#COMM_register_pwCheckdeny").addClass("remove");
     $("#COMM_register_pwCheckvali").addClass("remove");
   }
   else{
     $("#COMM_register_pwCheckdeny").removeClass("remove");
     $("#Input_PasswordCheck").val("");
     $("#COMM_register_pwCheckvali").addClass("remove");
   }

 })

  let emailNumber; // 이메일 인증번호

  $("#COMM_register_emailBtn").click(function(){ // COMM_register 이메일 인증번호 보내기


    let inputEmail = $("#COMM_register_input_email").val();
    let reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;

    if(reg.test(inputEmail)){

      alert("입력하신 이메일에서 인증번호를 확인해주세요");
      let randomFourDigitNumber = Math.random().toString().slice(2, 8);

      $.ajax({
        method : "post",
        url : "/send-certification",
        data : {"email" : inputEmail,
                "randomNumber" : randomFourDigitNumber},
        error : function(myval){console.log("에러"+myval)},
        success : function(myval) {

          console.log("성공"+myval)
          emailNumber = myval;

        }

      })


      $("#COMM_register_input_emailNumber").attr('disabled',false);
      $("#COMM_register_emailNumberBtn").attr('disabled',false);


    }else{
      alert("이메일 형식이 맞지 않습니다. 다시 입력하여 주세요");
      $("#COMM_register_input_email").val("");
    }


  })

  $("#COMM_register_emailNumberBtn").click(function(){ // COMM_register 인증번호 확인
    let emailCheckNumber = $("#COMM_register_input_emailNumber").val();

    if(emailCheckNumber === emailNumber){
      alert("통과");
      $("#COMM_register_emailCheckNumberVali").removeClass("remove");
      COMM_register_emailNumberCheck = true;
    }else{
      alert("인증실패! 이메일을 다시 입력해주세요");

      $("#COMM_register_input_emailNumber").val("");
      $("#COMM_register_input_email").val("");
      $("#COMM_register_input_emailNumber").attr('disabled',true);
      $("#COMM_register_emailNumberBtn").attr('disabled',true);
    }
  });

  $("#COMM_register_NickNamecheckBTN").on("click",function(){ //COMM_register 닉네임 체크


    let inputnickName = $("#Input_NickName").val();

    $.ajax({
      method: "post",
      url : "/auth?pagecode=checkNickName",
      data : {"NickName" : inputnickName},
      error: function(myval){console.log("에러"+myval)},
      success: function(myval){
        console.log("성공"+myval);

        if (myval == 1) {
          $("#COMM_register_NickNamedeny").removeClass("remove");
          $("#COMM_register_NickNameavail").addClass("remove");
          $("#Input_NickName").val("");
          COMM_register_nickNameCheck = false;
        } else {
          $("#COMM_register_NickNameavail").removeClass("remove");
          $("#COMM_register_NickNamedeny").addClass("remove");
          COMM_register_nickNameCheck = true;
        }

      }
    })

  });

  $("#reviewer_acceptTerms").change(function(){ //COMM_register 이용약관 확인
    if($(this).is(":checked")){
      COMM_register_acceptTerms = true;
    }
  })


  $("#COMM_register_btn_reviewer_regist").click(function(){ // COMM_register reviewer 제출버튼
    if(COMM_register_idCheck&&COMM_register_pwCheck&&COMM_register_emailNumberCheck&&COMM_register_nickNameCheck&&COMM_register_acceptTerms){
    $("#COMM_register_form_reviewer_regist").attr({"action": "/auth?pagecode=reviewer_regist", "method":"post"}).submit();
    }else if(!COMM_register_idCheck){
      alert("아이디 중복확인을 체크해주세요!");
    }else if(!COMM_register_pwCheck){
      alert("비밀번호 확인을 체크해주세요!");
    } else if(!COMM_register_emailNumberCheck){
      alert("이메일 인증번호를 체크해주세요!");
    } else if(!COMM_register_nickNameCheck){
      alert("닉네임 중복확인을 체크해주세요!");
    } else if(!COMM_register_acceptTerms){
      alert("개인정보 및 이용약관를 확인하고 동의해주세요");
    }
  })


  $("#COMM_register_Boss_IDcheckBTN").on("click",function(){ //COMM_register Boss 아이디체크


    let inputID = $("#Boss_Input_ID").val();

    $.ajax({
      method: "post",
      url : "/auth?pagecode=checkID",
      data : {"id" : inputID},
      error: function(myval){console.log("에러"+myval)},
      success: function(myval){
        console.log("성공"+myval);

        if (myval == 1) {
          $("#COMM_register_Boss_IDdeny").removeClass("remove");
          $("#COMM_register_Boss_IDavail").addClass("remove");
          $("#Boss_Input_ID").val("");
        } else {
          $("#COMM_register_Boss_IDavail").removeClass("remove");
          COMM_register_idCheck = true;
        }

      }
    })

  });

  $("#Input_Boss_pw").change(function(){ // COMM_register Boss 비밀번호 형식 확인

    let reg = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$/
    let val = $("#Input_Boss_pw").val();



    if(reg.test(val)){
      $("#COMM_register_Boss_pwvali").removeClass("remove");
      $("#COMM_register_Boss_pwdeny").addClass("remove");
    }else if(val===""){
      $("#COMM_register_Boss_pwdeny").addClass("remove");
      $("#COMM_register_Boss_pwvali").addClass("remove");
    }
    else{
      $("#COMM_register_Boss_pwdeny").removeClass("remove");
      $("#Input_Boss_pw").val("");
      $("#COMM_register_Boss_pwvali").addClass("remove");
    }

  })

  $("#Input_Boss_PasswordCheck") .change(function(){ // COMM_register Boss 비밀번호 확인하기

    let pw = $("#Input_Boss_pw").val();
    let pwCheck = $("#Input_Boss_PasswordCheck").val();

    if(pw===pwCheck){
      $("#COMM_register_Boss_pwCheckvali").removeClass("remove");
      $("#COMM_register_Boss_pwCheckdeny").addClass("remove");
      COMM_register_pwCheck = true;
    }else if(pwCheck===""&&pw===""){
      $("#COMM_register_Boss_pwCheckdeny").addClass("remove");
      $("#COMM_register_Boss_pwCheckvali").addClass("remove");
    }
    else{
      $("#COMM_register_Boss_pwCheckdeny").removeClass("remove");
      $("#Input_Boss_PasswordCheck").val("");
      $("#COMM_register_Boss_pwCheckvali").addClass("remove");
    }

  })

  $("#COMM_register_Boss_emailBtn").click(function(){ // COMM_register Boss 이메일 인증번호 보내기


    let inputEmail = $("#COMM_register_input_Boss_email").val();
    let reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;

    if(reg.test(inputEmail)){

      alert("입력하신 이메일에서 인증번호를 확인해주세요");
      let randomFourDigitNumber = Math.random().toString().slice(2, 8);

      $.ajax({
        method : "post",
        url : "/send-certification",
        data : {"email" : inputEmail,
          "randomNumber" : randomFourDigitNumber},
        error : function(myval){console.log("에러"+myval)},
        success : function(myval) {

          console.log("성공"+myval)
          emailNumber = myval;

        }

      })


      $("#COMM_register_input_Boss_emailNumber").attr('disabled',false);
      $("#COMM_register_Boss_emailNumberBtn").attr('disabled',false);


    }else{
      alert("이메일 형식이 맞지 않습니다. 다시 입력하여 주세요");
      $("#COMM_register_input_Boss_email").val("");
    }


  })

  $("#COMM_register_Boss_emailNumberBtn").click(function(){ // COMM_register Boss 인증번호 확인
    let emailCheckNumber = $("#COMM_register_input_Boss_emailNumber").val();

    if(emailCheckNumber === emailNumber){
      alert("통과");
      $("#COMM_register_Boss_emailCheckNumberVali").removeClass("remove");
      COMM_register_emailNumberCheck = true;
    }else{
      alert("인증실패! 이메일을 다시 입력해주세요");

      $("#COMM_register_input_Boss_emailNumber").val("");
      $("#COMM_register_input_Boss_email").val("");
      $("#COMM_register_input_Boss_emailNumber").attr('disabled',true);
      $("#COMM_register_Boss_emailNumberBtn").attr('disabled',true);
      $("#COMM_register_Boss_emailCheckNumberVali").addClass("remove");
    }
  });

  $("#COMM_register_Boss_buisnessInfobts").click(function(){ // COMM_regist Boss 사업자자등록번호 확인하기
    let buisnessInfo = $("#COMM_register_input_Boss_buisnessInfo").val();
    const reg = /^\d{3}-\d{2}-\d{5}$/;
    if(reg.test(buisnessInfo)){

      $.ajax({
        method : "post",
        url : "/auth?pagecode=checkbuisnessInfo",
        data : {"buisnessInfo" : buisnessInfo},
        error : function(myval){console.log("에러"+myval)},
        success : function(myval) {

          if(myval==1){
            $("#COMM_register_Boss_buisnessInfoavail").removeClass("remove");
            $("#COMM_register_input_Boss_addressbtn").attr("disabled",false);
            $("#COMM_register_input_Boss_buisnessaddress").attr("disabled",false);
            COMM_register_businessInfo = true;
          }else{
            alert("등록된 사업자 번호가 아닙니다. 담당자에게 문의바랍니다. FReview: 02-5875-5785")
            $("#COMM_register_input_Boss_buisnessInfo").val("");
            $("#COMM_register_input_Boss_addressbtn").attr("disabled",true);
            $("#COMM_register_input_Boss_buisnessaddress").attr("disabled",true);
            $("#COMM_register_input_Boss_buisnessaddress").val("");
            COMM_register_businessInfo = false;
            COMM_register_buisnessloc = false;

          }

        }

      })



    }else{
      alert("사업자등록번호 형식에 맞게 작성해주세요");
      $("#COMM_register_input_Boss_buisnessInfo").val("");
      $("#COMM_register_input_Boss_addressbtn").attr("disabled",true);
      $("#COMM_register_input_Boss_buisnessaddress").attr("disabled",true);
    }
  })

  $("#COMM_register_input_Boss_buisnessInfo").change(function(){ // COMM_register Boss 사업자 등록번호 중복체크
    let buisnessInfo = $("#COMM_register_input_Boss_buisnessInfo").val();
    const reg = /^\d{3}-\d{2}-\d{5}$/;

    if(reg.test(buisnessInfo)){

      $.ajax({
        method : "post",
        url : "/auth?pagecode=checkduplocatedNumberinmember",
        data : {"buisnessInfo" : buisnessInfo},
        error : function(myval){console.log("에러"+myval)},
        success : function(myval) {
          if(myval==1) {
            alert("등록된 사업자등록번호입니다");
            $("#COMM_register_input_Boss_buisnessInfo").val("");
            $("#COMM_register_input_Boss_addressbtn").attr("disabled",true);
            $("#COMM_register_input_Boss_buisnessaddress").attr("disabled",true);
            $("#COMM_register_input_Boss_buisnessaddress").val("");
            COMM_register_businessInfo = false;
            COMM_register_buisnessloc = false;
          }
        }
      })

    } else{
      alert("사업자등록번호 형식에 맞게 작성해주세요");
      $("#COMM_register_input_Boss_buisnessInfo").val("");
      $("#COMM_register_input_Boss_addressbtn").attr("disabled",true);
      $("#COMM_register_input_Boss_buisnessaddress").attr("disabled",true);
    }


  })

  $("#COMM_register_input_Boss_addressbtn").click(function(){ // COMM_register Boss 주소입력
    new daum.Postcode({

      oncomplete: function(data){

        let addr = "";
        if(data.userSelectedType === 'R'){
          addr = data.roadAddress;
          COMM_register_buisnessloc = true;
        } else{
          addr = data.jibunAddress;
          COMM_register_buisnessloc = true;
        }

        addr += " "+data.zonecode;
        console.log(addr);
        $("#COMM_register_input_Boss_buisnessaddress").val(addr);

      }

    }).open();
  })

  $("#reviewer_Boss_acceptTerms").change(function(){ //COMM_register Boss 이용약관 확인
    if($(this).is(":checked")){
      COMM_register_acceptTerms = true;
    }
  })

  $("#COMM_register_btn_Boss_regist").click(function(){ // COMM_register Boss 회원가입
    if(COMM_register_idCheck&&COMM_register_pwCheck&&COMM_register_emailNumberCheck&&COMM_register_acceptTerms&&COMM_register_businessInfo&&COMM_register_buisnessloc){
    $("#COMM_register_form_Boss_regist").attr({"action": "/auth?pagecode=Boss_regist", "method":"post"}).submit();
    }else if(!COMM_register_idCheck){
      alert("아이디 중복확인을 체크해주세요!");
    }else if(!COMM_register_pwCheck){
      alert("비밀번호 확인을 체크해주세요!");
    } else if(!COMM_register_emailNumberCheck){
      alert("이메일 인증번호를 체크해주세요!");
    } else if(!COMM_register_businessInfo){
      alert("사업자인증을 해주세요!");
    } else if(!COMM_register_buisnessloc){
      alert("사업자 주소를 입력해주세요");
    } else if(!COMM_register_acceptTerms){
      alert("개인정보 및 이용약관에 동의해주세요");
    }

  })


  $("#COMM_register_Boss_NickNamecheckBTN").on("click",function(){ //COMM_register Boss 닉네임 체크

    alert(1);
    let inputnickName = $("#Input_Boss_NickName").val();

    $.ajax({
      method: "post",
      url : "/auth?pagecode=checkNickName",
      data : {"NickName" : inputnickName},
      error: function(myval){console.log("에러"+myval)},
      success: function(myval){
        console.log("성공"+myval);

        if (myval == 1) {
          $("#COMM_register_Boss_NickNamedeny").removeClass("remove");
          $("#COMM_register_Boss_NickNameavail").addClass("remove");
          $("#Input_Boss_NickName").val("");
          COMM_register_nickNameCheck = false;
        } else {
          $("#COMM_register_Boss_NickNameavail").removeClass("remove");
          $("#COMM_register_Boss_NickNamedeny").addClass("remove");
          COMM_register_nickNameCheck = true;
        }

      }
    })

  });

  $("#common_findid_btn").click(function(){ // common_findid 아이디 찾기 버튼 클릭시 이벤트


    let findidEmail = $("#findidEmail").val();


    $.ajax({
      method: "post",
      url : "/auth?pagecode=findId",
      data : {"findidEmail" : findidEmail},
      error: function(myval){console.log("에러"+myval)},
      success: function(myval){console.log("성공"+myval);

        if(myval==="null"){
          alert("가입된 이메일이 아닙니다. 다시 확인부탁드립니다");
        }else{
          $("#common_findid_div_findid").css("display","");
          $("#common_findid_div_Idcheck").html("<span> 회원님의 아이디는 "+myval+" 입니다</span>")
        }

      }
    })


  })

  $(".common_findid_modalcancelbtn").click(function(){ // common-findid 아이디 찾기 모달창 취소 버튼 클릭시 이벤트
    $("#common_findid_div_findid").css('display','none');
  })

  $("#common_findid_loginbtn").click(function(){ // common-findid 아이디 찾기 모달창 취소 버튼 클릭시 이벤트
    location.replace("/common-login.jsp");
  })

  $("#common_findpw_btn").click(function(){ // common-findpw 비밀번호 찾기 버튼 클릭시 이벤트

    let userEmail = $("#findpwEmail").val();
    let userId = $("#findpw_ID").val();

    $.ajax({
      method: "post",
      url : "/findpw",
      data : {"findpwEmail" : userEmail,
              "findpwId": userId},
      error: function(myval){console.log("에러"+myval)},
      success: function(myval){console.log("성공"+myval);


        if(myval==1){
          $("#common_findid_div_findid").css("display","");
          $("#common_findid_div_Idcheck").html("<span>비밀번호 재생성되었습니다. 이메일에서 비밀번호 확인하시고 다시 로그인해주세요</span>")
        }else{
          alert("존재하지 않는 정보입니다. 이메일과 아이디를 다시 확인해주세요");
        }


      }
    })

  })

})

$("#COMM_register_reviewer_agreebtn").click(function(){ // COMM_register 개인정보 및 이용약관 확인 버튼

  $("#reviewer_acceptTerms").attr("disabled",false);
  $("#COMM_register_reviewer_disagreebtn").trigger("click");


  $("#COMM_LGN_login").click(function(){

  })

})

$("#COMM_register_Boss_agreebtn").click(function(){ // COMM_register Boss 개인정보 및 이용약관 확인 버튼
  $("#reviewer_Boss_acceptTerms").attr("disabled",false);
  $("#COMM_register_Boss_disagreebtn").trigger("click");
})