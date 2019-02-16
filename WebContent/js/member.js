function checkedall() {
	if ($('.agree-all').is(":checked")) {
		$('.agree').prop('checked', true);
	} else {
		$('.agree').prop('checked', false);
	}
}

function unchecked() {
	if ($('#agree1').is(":checked") && $('#agree2').is(":checked")) {
		$('.agree-all').prop('checked', true);
	} else if (!$('#agree1').is(":checked") || !$('#agree2').is(":checked")) {
		$('.agree-all').prop('checked', false);
	}
}

/**
 * 약관 동의 체크
 */
function terms() {
	if (!$('#agree1').is(":checked") && !$('#agree2').is(":checked")) {
		alert("이용약관에 동의해주시기 바랍니다.");
		$('#agree1').focus();
	} else if (!$('#agree2').is(":checked")) {
		alert("개인정보수집 및 이용에 동의해주시기 바랍니다. ");
		$('#agree2').focus();
	} else {
		document.join.submit();
	}
}

function join() {
	var doc = document.formm;
	if (!doc.id.value) {
		alert("아이디를 입력하여 주세요.");
		doc.id.focus();
	} else if (doc.checkid.value != doc.id.value) {
		alert("아이디 중복확인을 해주세요.");
		doc.checkidbtn.focus();
	} else if (!doc.password.value) {
		alert("비밀번호를 입력해 주세요.");
		doc.password.focus();
	} else if (!doc.confirmPassword.value) {
		alert("비밀번호확인을 입력해 주세요.");
		doc.confirmPassword.focus();
	} else if (doc.password.value != doc.confirmPassword.value) {
		alert("비밀번호가 일치하지 않습니다. 비밀번호를 다시 확인해주세요.");
		doc.confirmPassword.focus();
	} else if (!doc.name.value) {
		alert("이름을 입력해 주세요.");
		doc.name.focus();
	} else if (!doc.phone.value) {
		alert("휴대전화를 입력해 주세요.");
		doc.phone.focus();
	} else if (!doc.email.value) {
		alert("이메일을 입력해 주세요.");
		doc.email.focus();
	} else {
		doc.submit();
	}
}

function noSpacebar() {
	$('input[type=text]').keydown(function(e) {
		if (e.keyCode == 32) {
			// $(this).val();
			return false;
		}
	});
}
/*
 * 0 48 9 57 A 65 Z 90 a 97 z 122
 * 
 */

function engNumOnly() {
	$('input[type=text]').keydown(
			function(e) {
				if (e.keyCode == 32 || e.keyCode != 122 && e.keyCode != 8
						&& !(e.keyCode >= 48 && e.keyCode <= 57)
						&& !(e.keyCode >= 65 && e.keyCode <= 90)) {
					return false;
				} else if (e.key == '!') {
					return false;
				}
			});
}

function go_mypage() {
	$("#signUpForm").attr("action", "/mypage/memberinfo").submit();
	event.preventDefault();
}

function modify() {
	$(".msg").text("");
	$(".msg").attr("style", "color:#f00");
	if (!$("#password").val()) {
		$("#msgPassword").text("비밀번호를 입력해주세요.");
		$('#password').focus();
	} else if (!$('#confirmPassword').val()) {
		$("#msgConfirmPassword").text("비밀번호확인을 입력해주세요");
		$('#confirmPassword').focus();
	} else if ($('#password').val() != $('#confirmPassword').val()) {
		$("#msgConfirmPassword").text("비밀번호가 일치하지 않습니다. 다시 확인해주세요");
		$('#confirmPassword').val('');
		$('#confirmPassword').focus();
	} else if (!$('#phone').val()) {
		$("#msgPhone").text("휴대전화를 입력해주세요.");
		$('#phone').focus();
	} else if (!$('#email').val()) {
		$("#msgEmail").text("이메일을 입력해주세요.");
		$('#email').focus();
	} else {
		var id = $('#id').val();
		var password = $('#password').val();

		$.ajax({
			url : "/login/check/",
			type : "post",
			data : {
				"id" : id,
				"password" : password
			},
			success : function(data) {
				if (data == 1) {
					alert("회원정보가 수정되었습니다");
					$("#signUpForm").submit();
				} else {
					$(".checkResult .msg").text("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
					$('#password').val('');
					$('#password').focus();
				}
			}
		}); // ajax 끝
	}
}

function login() {
	var id = $('#id').val();
	var password = $('#password').val();
	if (!id) {
		$(".checkResult .msg").text("아이디를 입력해주세요");
		$(".checkResult .msg").attr("style", "color:#f00");
		$('#id').focus();
	} else if (!password) {
		$(".checkResult .msg").text("비밀번호를 입력해주세요");
		$(".checkResult .msg").attr("style", "color:#f00");
		$('#password').focus();
	} else {
		$.ajax({
			url : "/login/check/",
			type : "post",
			data : {
				"id" : id,
				"password" : password
			},
			success : function(data) {
				if (data == 1) {
					$('#loginForm').submit();
				} else if (data == 2) {
					$(".checkResult .msg").text("일치하는 회원정보가 없습니다. 다시 확인해주세요.");
					$(".checkResult .msg").attr("style", "color:#f00");
				} else {
					$(".checkResult .msg").text(
							"아이디나 비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
					$(".checkResult .msg").attr("style", "color:#f00");
					$('#id').val('');
					$('#password').val('');

				}
			}
		}); // ajax 끝
	} // else End

}
function findId() {
	var name = $('#name').val();
	var email = $('#email').val();
	if (!name) {
		$(".findResult .msg").text("이름을 입력해주세요");
		$(".findResult .msg").attr("style", "color:#f00");
		$('#name').focus();
	} else if (!email) {
		$(".findResult .msg").text("이메일을 입력해주세요");
		$(".findResult .msg").attr("style", "color:#f00");
		$('#email').focus();
	} else {
		$.ajax({
			url : "/findId/Result",
			type : "post",
			data : {
				"name" : name,
				"email" : email
			},
			success : function(data) {
				if (data != "") {
					$(".findResult .msg").text("고객님의 아이디는" + data + "입니다");
					$(".findResult .msg").attr("style", "color:#f00");
				} else {
					$(".findResult .msg").text("입력하신 정보와 일치하는 회원정보가 없습니다.");
					$(".findResult .msg").attr("style", "color:#00f");
				}
			}
		}); // ajax 끝
	} // else End
}

function findPw() {
	var name = $('#name').val();
	var email = $('#email').val();
	var id = $('#id').val();
	if (!name) {
		$(".findResult .msg").text("이름을 입력해주세요");
		$(".findResult .msg").attr("style", "color:#f00");
		$('#name').focus();
	} else if (!email) {
		$(".findResult .msg").text("이메일을 입력해주세요");
		$(".findResult .msg").attr("style", "color:#f00");
		$('#email').focus();
	} else if (!id) {
		$(".findResult .msg").text("아이디를 입력해주세요");
		$(".findResult .msg").attr("style", "color:#f00");
		$('#id').focus();
	} else {
		$.ajax({
			url : "/findPassword/Result",
			type : "post",
			data : {
				"name" : name,
				"email" : email,
				"id" : id
			},
			success : function(data) {
				if (data != "") {
					$(".findResult .msg").text("고객님의 패스워드는" + data + "입니다");
					$(".findResult .msg").attr("style", "color:#f00");
				} else {
					$(".findResult .msg").text("입력하신 정보와일치하는 회원정보가 없습니다.");
					$(".findResult .msg").attr("style", "color:#00f");
				}
			}
		}); // ajax 끝
	} // else End
}
function deleteUser() {
	$(".msg").text("");
	$(".msg").attr("style", "color:#f00");
	if (!$("#password").val()) {
		$("#msgPassword").text("비밀번호를 입력해주세요.");
		$('#password').focus();
	} else {
		var id = $('#id').val();
		var password = $('#password').val();

		$.ajax({
			url : "/login/check/",
			type : "post",
			data : {
				"id" : id,
				"password" : password
			},
			success : function(data) {
				if (data == 1) {
					var r = confirm("탈퇴하실 경우 모든 정보가 삭제됩니다. 정말 탈퇴하시겠습니까?");
					if (r == true) {
						alert("탈퇴 되었습니다. 이용해주셔서 감사합니다.");
						$("#signUpForm").attr("action", "/mypage/delete");
						$("#signUpForm").submit();
					}
				} else {
					$(".checkResult .msg").text("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
					$('#password').val('');
					$('#password').focus();
				}
			}
		}); // ajax 끝

	}
}