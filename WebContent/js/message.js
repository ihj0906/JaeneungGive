// 쪽지 삭제시 
/**
 * checkbox로 선택한 쪽지 삭제시 사용
 * 
 * @returns
 */
function delete_note(noteType) {
	var checkBox = document.getElementById("note_check");
	if (checkBox.checked != true) {
		alert("쪽지를 선택해주세요");
	} else {
		document.message_form.action = "/message/delete&" + noteType;
		document.message_form.submit();
	}
}

/**
 * 쪽지 읽기에서 삭제 시 사용
 * 
 * @returns
 */
function del_note(noteType) {
	document.message_form.action = "/message/delete&" + noteType;
	document.message_form.submit();
}

function test() {
	alert("테스트");
}

/**
 * 쪽지 작성 시 최대 글자수 제한 및 현재 글자수 알림 
 */
function counttext() {
	$(document).ready(function() {
		$('.note_text').keyup(function() {
			var content = $(this).val();
			$('#counter').html("( " + content.length + " / 최대 1000자)"); // 글자수  실시간 카운팅

			if (content.length > 1000) {
				alert("최대 1000자까지 입력 가능합니다.");
				$(this).val(content.substring(0, 1000));
				$('#counter').html("(1000 / 최대 1000자)");
			}
		});
	});
}

/**
 * 전체 선택 기능  
 */

function checked_all() {
	if ($('.checked-all').is(":checked")) {
		$('.checkbox').prop('checked', true);
	} else {
		$('.checkbox').prop('checked', false);
	}
}

function sendMessage(){
	if(!$('.note_text').val().trim()){
	alert("쪽지 내용을 입력해주시기 바랍니다.");
	$('#counter').html("( 0 / 최대 1000자)"); // 글자수  실시간 카운팅
	$('.note_text').val('');
	$('.note_text').focus();
	}else{
		$('#messageForm').submit();
	}
}

function cancelMessage(){
	location.href="/message/inbox";
}
