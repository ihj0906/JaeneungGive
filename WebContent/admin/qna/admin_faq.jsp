<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/admin_header.jsp"%>

<article>
	<div class="margin"></div>
	<h2>FAQ 관리</h2>
	<div class="admin_faq_area">
		<form action="/admin/faqWrite" method="post" name="form">
			<table class="faq_form_table">
				<tr>
					<th class="faq_form_table_line" width=10%>제목</th>
					<td class="faq_form_table_line" width=90%><input
						class="faq_form_subject" type="text" name="subject"></td>
				</tr>
				<tr>
					<th class="faq_form_table_line">내용</th>
					<td class="faq_form_table_line" colspan="2"><textarea
							class="faq_form_content" name="content" cols="50" rows="5"></textarea></td>
				</tr>
			</table>
			<div class="board_btn">
				<input class="admin_submit_btn" type="submit" value="등록">
			</div>
			<br> <input type="hidden" value="" id="no" name="no" /> <br>
			<table class="admin_faq_list">
				<tr>
					<th width=30%>제목</th>
					<th width=60%>내용</th>
					<th width=10%>삭제</th>
				</tr>
				<c:forEach var="adminFaqList" items="${adminFaqList}">
					<tr>
						<td class="admin_faq_list">${adminFaqList.subject}</td>
						<td class="admin_faq_list">${adminFaqList.content}</td>
						<td><input class="admin_board_delete_btn" type="button"
							value="삭제" onclick="adminFaqDelete('${adminFaqList.no}')"></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</article>

<%@ include file="/admin/admin_footer.jsp"%>