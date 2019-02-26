function adminLogin() {
	if(!$('#id').val()){
		alert("아이디를 입력해주세요");
		$('#id').focus();
	}else if(!$('#password').val()){
		alert("비밀번호를 입력해주세요");
		$('#password').focus();
	}else{
		$('#form').submit();
	}
}

function adminFaqDelete(no) {
	$('#no').val(no);
	document.form.action="/admin/faqDelete";
	document.form.submit();
}

function adminMemberDelete(id) {
	$('#id').val(id);
	document.form.action="/admin/memberDelete";
	document.form.submit();
}

function adminMemberUpdate(id) {
	$('#id').val(id);
	document.form.action="/admin/memberUpdate";
	document.form.submit();
}

function go_back(url){
	 location.href = url;
}

function boardDel(no,category){
	if(category == '기부'){
		location.href = "/admin/boardDelete?no="+no+"&category=1";
	}else{
		location.href = "/admin/boardDelete?no="+no+"&category=2";
	}
}

