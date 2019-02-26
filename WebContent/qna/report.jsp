<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<link href="/css/qna.css" rel="stylesheet" type="text/css" />

<div style="background-color: #50d2d4;">
	<img class="faq_img" src="/images/faq.jpg" />
</div>
	<nav class="tabmenu">
	<input type="hidden" id="qnaId" value="${loginInfo.id}">
		<ul>
			<li onclick="select_list('1')"><a href="#">문의 내역</a></li>
			<li class="on" onclick="select_list('2')"><a href="#">문의 하기</a></li>
			<li><a href="/qna/faq">자주 묻는 질문</a></li>
		</ul>
	</nav>



<!-- 	<div module="calendar_Write">
	</div> -->
	

	<form action="write_qna" method="post">
	<div class="content">
		<table class="report_form" summary="1:1 문의 글 작성 폼">
			<tr>
				<th class="report_form_table" scope="row">아이디</th>
				<td>
				<!-- readonly 읽기전용 속성 / 유저 아이디 가져올것 -->
					<input class="report_form_table_text" type = "text" name = "id" size = "50" readonly="readonly" value="${loginInfo.id}">
				</td>
			</tr>
			<tr>
				<th class="report_form_table" scope="row">제목</th>
				<td>
					<input class="report_form_table_text" type = "text" name = "subject" id=subject size = "50" maxlength="100">
				</td>
			</tr>
			<tr>
				<th class="report_form_table" scope="row">연락처</th>
				<td>
					<input class="report_form_table_text" onclick="numOnly()" type = "text" name = "myname" size = "50" maxlength="11">
				</td>
			</tr>
			<tr>
				<th class="report_form_table" scope="row">내용</th>
				<td>
					<textarea class="report_form_table_textarea" name="content" id="content" rows = "14" cols = "50"  maxlength="1000"></textarea><BR>
				</td>
			</tr>
			<!-- <tr>
				<th scope="row">첨부파일</th>
				<td width="200">
						<input type="file" name="image">
				</td>
			</tr> -->
			<tr><td class="report_form_btn" colspan="2">
				<input class="board_list_btn" type="submit" value="등록">
				<input class="boardDetail_delete_btn" type="button" value="취소" onclick="go_backq('/qna/qna')">
			</td></tr>
		</table>
	</div>
		</form>
			
<%@ include file="../footer.jsp" %>