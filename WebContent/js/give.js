function go_back() {
	var board = $('#board').val();
	location.href = "/give/search_give_" + board;
}

// 새 게시글 등록 (폼으로)
function newClassWriteForm(id) {
	var board = $('#board').val();
	if (!id) {
		var r = confirm("로그인 후 이용하실 수 있습니다. 로그인 하시겠습니까? ")
		if (r == true) {
			location.href = "/login";
		} else {
			location.href = "/give/search_give_" + board;
		}
	} else {
		if (board == "donation") {
			location.href = "/give/writeForm&" + board + "&0";
		} else {
			location.href = "/give/writeForm&" + board + "&0";
		}
	}
}

// 새 게시글 등록 완료
function regClass() {
	var board = $('#board').val();
	$('#no').val(0);
	form.key.value = "";
	if (board == "donation") {
		form.category.value = "기부";
		$('#modiform').attr("action", "/regClass&" + board).submit();
	} else {
		form.category.value = "교환";
		$('#modiform').attr("action", "/regClass&" + board).submit();
	}
}

// 해당 게시글 수정 (폼으로)
function modClassWriteForm(no) {
	var board = $('#board').val();
	if (board == "donation") {
		location.href = "/give/writeForm&" + board + "&" + no;
	} else {
		location.href = "/give/writeForm&" + board + "&" + no;
	}
}

// 해당 게시글 수정 완료
function modClass() {
	var board = $('#board').val();
	form.key.value = "";
	if (board == "donation") {
		form.category.value = "기부";
		$('#modiform').attr("action", "/modClass&" + board).submit();
	} else {
		form.category.value = "교환";
		$('#modiform').attr("action", "/modClass&" + board).submit();
	}
}

// 삭제
function delClass(no) {
	var board = $('#board').val();
	if (board == "donation") {
		if (confirm("정말 삭제하시겠습니까?") == true) {
			location.href = "/give/delClass&" + board + "&" + no;
		} else {
		}
	} else {
		if (confirm("정말 삭제하시겠습니까?") == true) {
			location.href = "/give/delClass&" + board + "&" + no;
		} else {
		}
	}
}

/**
 * 북마크 표시 기능
 * 
 * @param board_id
 *            게시판 번호 ( 1= 기부 , 2 = 교환)
 * @returns
 */
function bookmark(board_id, board_no) {
	$.ajax({
		url : "/bookmark/check",
		type : "post",
		data : {
			"board_id" : board_id,
			"no" : board_no
		},
		success : function(data) {
			if (data == 0) {
				// 로그인이 되어있지 않은 경우
				var r = confirm("'스크랩'은 로그인 후 사용가능 합니다. 로그인 하시겠습니까?");
				if (r == true) {
					window.location = "http://localhost:8080/login";
				}
			} else if (data == 1) {
				// 로그인이 되어있음져 북마크가 되어 있는 경우 북마크 해제
				// $('#image').attr("src", "/images/unbookmark.png")
				$('#bookmark' + board_no).attr("src", "/images/unbookmark.png")
			} else {
				// 로그인이 되어있으며 북마크가 안되어있는 경우 북마크 설정
				$('#bookmark' + board_no).attr("src", "/images/bookmark.png")
			}
		}
	}); // ajax 끝
}

/**
 * 교환 신청 폼 입력 신청하기 눌렀을 때 입력 안할 경우 입력하란 팝업 알림 입력 한 경우 등록
 * 
 * @returns
 */
function applicant() {
	if (!$('#appli_content').val()) {
		alert("내용을 입력해주세요");
		$('#appli_content').focus();
	} else {
		$('#appli_form').attr("action", "/applicant/add").submit();
	}
}

/**
 * 교환 신청 폼 입력 신청하기 눌렀을 때 입력 안할 경우 입력하란 팝업 알림 입력 한 경우 등록
 * 
 * @returns
 */
function applicant_d() {

	$('#appli_form').attr("action", "/applicant/add").submit();
}

/**
 * 교환신청 후 삭제 눌렀을 떄
 * 
 * @returns
 */
function applicant_del() {
	$('#appli_form').attr("action", "/applicant/del").submit();
}

/**
 * 교환작성자가 신청자 중 한명을 교환대상자로 선정하여 승인 할 때
 * 
 * @returns
 */
function joinSubmit(confirmId) {
	var r = confirm("확인을 누르시면 교환신청이 완료되며, 변경하실 수 없습니다. 계속하시려면 [확인]을 눌러주세요");
	if (r == true) {
		$('#appli_confirmId').val(confirmId);
		$('#appli_form').attr("action", "/applicant/submit").submit();
	}
}

/* 회원가입 페이지 회원정보 입력 중 발생하는 에러 문구 */
function join() {
	$(".msg").text("");
	$(".msg").attr("style", "color:#f00");
	if (!$("#id").val()) {
		$(".idCheckResult .msg").text("아이디를 입력해주세요.");
		$('#id').focus();
	} else if (!$('#checkid').val()) {
		$(".idCheckResult .msg").text("아이디 중복확인을 해주세요.");
		$('.board_submit_btn').focus();
	} else if (!$('#password').val()) {
		$("#msgPassword").text("비밀번호를 입력해주세요.");
		$('#password').focus();
	} else if (!$('#confirmPassword').val()) {
		$("#msgConfirmPassword").text("비밀번호확인을 입력해주세요.");
		$('#confirmPassword').focus();
	} else if ($('#password').val() != $('#confirmPassword').val()) {
		$("#msgConfirmPassword").text("비밀번호가 일치하지 않습니다. 다시 확인해주세요");
		$('#confirmPassword').val('');
		$('#confirmPassword').focus();
	} else if (!$('#name').val()) {
		$("#msgName").text("이름을 입력해주세요.");
		$('#name').focus();
	} else if (!$('#phone').val()) {
		$("#msgPhone").text("휴대전화를 입력해주세요.");
		$('#phone').focus();
	} else if (!$('#email').val()) {
		$("#msgEmail").text("이메일을 입력해주세요.");
		$('#email').focus();
	} else {
		$('form').submit();
	}

}

/**
 * 페이징 기능
 */
function page(idx) {
	var pagenum = idx;
	location.href = "/give/search_give_" + $('#board').val() + "?pagenum="
			+ pagenum;
}

/**
 * 게시물 작성 시 본문 최대 글자수 제한 및 현재 글자수 알림
 */
function countBoardtext() {
	$(document).ready(function() {
		$('#content').keyup(function() {
			var content = $(this).val();
			$('#count_con').html("( " + content.length + " / 5000)"); // 글자수
			// 실시간
			// 카운팅

			if (content.length > 5000) {
				alert("최대 5000자까지 입력 가능합니다.");
				$(this).val(content.substring(0, 5000));
				$('#count_con').html("(5000 / 5000)");
			}
		});
	});
}

/**
 * 게시물 작성 시 제목 최대 글자수 제한 및 현재 글자수 알림
 */
function countBoardSubtext() {
	$(document).ready(function() {
		$('#subject').keyup(function() {
			var content = $(this).val();
			$('#count_sub').html("( " + content.length + " / 100)"); // 글자수
			// 실시간
			// 카운팅

			if (content.length > 100) {
				alert("최대 100자까지 입력 가능합니다.");
				$(this).val(content.substring(0, 100));
				$('#count_sub').html("(100 / 100)");
			}
		});
	});
}

// 주소 검색 팝업 창 열기/닫기
function popup() {
	var url = "/give/searchLocation";
	var option = "width=470, height=455, left=400, top=100, resizable=yes, scrollbars=no";
	window.open(url, "", option);
}

// 주소 검색
/*function search_location() {
	var form = document.popup_frm;
	if (form.lo.value == '') {
		alert("검색어를 입력해 주세요.");
		form.lo.focus();
	} else {
		form.action = "/give/searchLocation";
		form.submit();
	}
}*/

// 주소 선택 후 값 넘기기
function location_submit() {
	var sel = document.getElementById("lo_list");
	var val = sel.options[sel.selectedIndex].text;
	window.opener.document.getElementById("location").value = val;
	window.close();
}
