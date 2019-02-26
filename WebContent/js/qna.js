/**
 * qna 리스트 클릭 시 창 이동
 * 
 * @param list_no
 *            카테고리 값
 * @returns
 */
function select_list(list_no) {
	if (!$('#qnaId').val()) {
		var r = confirm("로그인 후 이용하실 수 있습니다. 로그인 하시겠습니까? ")
		if (r == true) {
			location.href = "/login";
		} else {
			location.href = "/qna/faq";
		}
	} else if (list_no == 1) {
		location.href = "/qna/qna";
	} else {
		location.href = "/qna/report";
	}
}

/**
 * 게시물 작성 시 제목 최대 글자수 제한 및 현재 글자수 알림
 */
function countQnaContent() {
	$(document).ready(function() {
		$('#content').keyup(function() {
			var content = $(this).val();
			if (content.length > 1000) {
				alert("최대 1000자까지 입력 가능합니다.");
				$(this).val(content.substring(0, 1000));
			}
		});
	});
}

function go_backq(url){
	 location.href = url;
}

