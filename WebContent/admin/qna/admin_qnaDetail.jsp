<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/admin_header.jsp"%>

<article>
	<div class="margin"></div>
	<h2>Q&amp;A 관리</h2>
	<table class="admin_board_list">
		<tr>
			<th class="admin_detail_table" width=20%>아이디</th>
			<td class="admin_detail_table_td" width=80%>${adminQnaDetail.id}</td>
		</tr>
		<tr>
			<th class="admin_detail_table">제목</th>
			<td class="admin_detail_table_td">${adminQnaDetail.subject}</td>
		</tr>
		<tr>
			<th class="admin_detail_table">내용</th>
			<td class="admin_detail_table_td" style="height:150px;">${adminQnaDetail.content}</td>
		</tr>
		<!-- 			<tr>
					<th>첨부파일</th>
					<td>추가 예정</td>
				</tr> -->
		<tr>
			<th class="admin_detail_table">작성일</th>
			<td class="admin_detail_table_td"><fmt:formatDate value="${adminQnaDetail.cre_date}"/> </td>
		</tr>
	</table>
	<form action="/admin/adminQnaWrite" method="post" name="form">
		<table class="admin_qna_reply">
			<input type="hidden" value="${adminQnaDetail.no}" id="no" name="no" />
			<tr>
				<th width=20%>답변</th>
				<td width=80%><textarea name="reply" cols="50" rows="5">${adminQnaDetail.reply}</textarea>
					<input class="admin_submit_btn" style="height: 99px; vertical-align: top;" type="submit" value="입력"></td>
			</tr>
		</table>
		<br>
		<div class="board_btn"> 
		<input class="admin_submit_btn" type="button" value="목록" onclick="go_back('/admin/qna')">
		</div>
	</form>

</article>

<%@ include file="/admin/admin_footer.jsp"%>