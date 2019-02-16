function go_search() {
	
var sel = document.getElementById("search_category");
var val = sel.options[sel.selectedIndex].value;

	if (document.frm.key.value == "") {
		alert("검색어를 입력해 주세요.");
		document.frm.key.focus();
	} else if (val == "선택") {
		alert("카테고리를 선택해 주세요.");
		document.frm.category.focus();
	} else {
		document.frm.submit();
	}
}



