<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/admin_header.jsp"%>

<article>
<div class="margin"></div>
	<h2>게시물관리 </h2>
	<div class="admin_board_list">
	<form action="/admin/boardDelete" method="post" name="form">
		<table class="admin_detail_table">
		<input type="hidden" value="${adminBoardDetail.no}" name="no" />
		<input type="hidden" value="${adminBoardDetail.category}" name="category" />
			<tr>
				<th class="admin_detail_table" width="15%">작성자</th>
				<td class="admin_detail_table" width="35%">${adminBoardDetail.id}</td>
				<th class="admin_detail_table" width="15%">카테고리</th>
				<td class="admin_detail_table" width="35%">${adminBoardDetail.category}</td>
			</tr>
			<tr>
				<th class="admin_detail_table">제목</th>
				<td class="qna_subject" colspan='3'>${adminBoardDetail.subject}</td>
			</tr>
			<tr>
				<th class="admin_detail_table">내용</th>
				<td class="qna_content" style="height: 150px;" colspan='3'>${adminBoardDetail.content}</td>
			</tr>
			<tr>
				<th class="admin_detail_table">작성일</th>
				<td class="admin_detail_table" colspan='3'><fmt:formatDate value="${adminBoardDetail.cre_date}"/></td>
			</tr>
		</table>
		<br>
		<div class="board_btn">
		<input class="admin_qna_delete_btn" type="submit" value="삭제"> 
		<input class="admin_submit_btn" type="button" value="목록" onclick="go_back('/admin/board')">
		</div>
	</form>
	</div>
</article>

<%@ include file="/admin/admin_footer.jsp"%>