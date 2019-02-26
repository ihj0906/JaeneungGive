<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/admin_header.jsp"%>

<article>
	<div class="margin"></div>
	<h2>Q&amp;A 관리</h2>
	<div class="admin_board_list">
		<table class="board_list_table">
				<tr>
					<th width=10%>아이디</th>
					<th width=30%>제목</th>
					<th width=40%>내용</th>
					<th width=10%>작성일</th>
					<th width=10%>처리상태</th>
				</tr>
			<tbody>
				<c:forEach var="adminQnaList" items="${adminQnaList}">
					<tr>
						<td>${adminQnaList.id}</td>
						<td><a href="/admin/qnaDetail&${adminQnaList.no}">${adminQnaList.subject}</a></td>
						<td><a href="/admin/qnaDetail&${adminQnaList.no}">${adminQnaList.content}</a></td>
						<td><fmt:formatDate value="${adminQnaList.cre_date}" /></td>
						<td><c:choose>
								<c:when test="${adminQnaList.repyn==1}">답변완료</c:when>
								<c:otherwise>처리중</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</article>

<%@ include file="/admin/admin_footer.jsp"%>