var count = 0;

function idCheck() {

	var text = $("#id").val();

	var regexp = /[0-9a-zA-Z]/; // 숫자,영문,특수문자
	// var regexp = /[0-9]/; // 숫자만
	// var regexp = /[a-zA-Z]/; // 영문만

	for (var i = 0; i < text.length; i++) {
		if (text.charAt(i) != " " && regexp.test(text.charAt(i)) == false) {
			alert("한글이나 특수문자는 입력불가능 합니다.");
			return false;
		}
	}
}
// function idcheck2() {
// var param = "id=" + $("#id").val();
// sendRequest("joinAjax.do", param, idResult, "post");
//
// }
// function idResult() {
// if (httpRequest.readyState == 4) { // 데이터를 전부 받은 상태. 완전한 데이터 이용 가능
// if (httpRequest.status == 200) { // 요청 성공
// var result = document.getElementById("idCheckTD");
// result.innerHTML = httpRequest.responseText;
// }
// }
// }

function overlapCheck() {
		
	var param = $("#id").val();
	
	$.ajax({
		url : "ajax.do",
		type : "POST",
		data : {"did" : param},
		cache : false,

		success : function(idmsg) {
			if (idmsg == 0) {
				$('#idCheckTD').text("사용 가능한 아이디입니다.");
			} else {
				$('#idCheckTD').text("이미 등록된 아이디입니다.");
				return false;
			}
		},

		error : function(request, status, error) {
			if (request.status != '0') {
				alert("code : " + request.status + "\r\nmessage : "
						+ request.reponseText + "\r\nerror : " + error);
			}
		}

	});
}

function passwordCheck() {
	if ($('#password').val() != $('#password2').val()) {
		$('#passwordCheckTD').text("비밀번호가 일치하지 않습니다.");
	} else if ($('#password').val() == $('#password2').val()) {
		$('#passwordCheckTD').text("비밀번호가 일치합니다.");
	}
}

/*
 * function init(){ count=0; }
 * 
 * function countCheck(){ if(count==1){ count=0; } }
 */