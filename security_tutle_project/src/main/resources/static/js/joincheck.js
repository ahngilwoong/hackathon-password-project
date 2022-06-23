function checked(){  //form 유효성 검사 
    var p = document.getElementById('pw'); 
    var p_cf = document.getElementById('admin_pw');
    var nameCheck = document.getElementById("name");
    var named= RegExp(/^[가-힣]+$/)

//이름 유효성 검사
if(!named.test(nameCheck.value)){
    alert("이름형식에 맞게 입력해주세요")
    nameCheck.value= "";
    nameCheck.focus();
    return false;
}

else { 
    return true; 
 } 
}

function is_checked() {
  
    // 1. checkbox element를 찾습니다.
    const checkbox = document.getElementById('my_checkbox');
    // 2. checked 속성을 체크합니다.
    const is_checked = checkbox.checked;
    
  }

function safetyPasswordPattern() {
    var p = document.getElementById('pw'); 
    var admin_pw = document.getElementById('admin_pw');
    var message = "";
    var color = "";
    var checkPoint = 0;

    // 입력값이 있을경우에만 실행
    if(pass.length) {
        // 최대 입력 글자수를 제한한다.
        if(pass.length < 8 || pass.length > 16) {
            message = ":: 최소 8자 이상, 최대 16자 이하 ::";
            color = "#A23E48";
        }

        // 문자열의 길이가 8 ~ 16 인경우
        else {
            // 비밀번호 문자열에 숫자 존재 여부 검사
            var pattern1 = /[0-9]/;  // 숫자
            if(pattern1.test(pass) == false) {
                checkPoint = checkPoint + 1;
            }

            // 비밀번호 문자열에 영문 소문자 존재 여부 검사
            var pattern2 = /[a-z]/;
            if(pattern2.test(pass) == false) {
                checkPoint = checkPoint + 1;
            }

            // 비밀번호 문자열에 영문 대문자 존재 여부 검사
            var pattern3 = /[A-Z]/;
            if(pattern3.test(pass) == false) {
                checkPoint = checkPoint + 1;
            }

            // 비밀번호 문자열에 특수문자 존재 여부 검사
            var pattern4 = /[~!@#$%^&*()_+|<>?:{}]/;  // 특수문자
            if(pattern4.test(pass) == false) {
                checkPoint = checkPoint + 1;
            }

            if(checkPoint >= 3) {
                message = ":: 보안성이 취약한 비밀번호 ::";
                color = "#A23E48";
            } else if(checkPoint == 2) {
                message = ":: 보안성이 낮은 비밀번호 ::";
                color = "#FF8C42";
            } else if(checkPoint == 1) {
                message = ":: 보안성이 보통인 비밀번호 ::";
                color = "#FF8C42";
            } else {
                message = ":: 보안성이 강력한 비밀번호 ::";
                color = "#0000CD";
            }
        }
    }

    else {
        message = ":: 비밀번호를 입력해 주세요 ::";
        color = "#000000";
    }

    document.getElementById("makyText").innerHTML = message;
    document.getElementById("makyText").style.color = color;
}