<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/admin_header.jsp"%>

<article>
	<div class="margin"></div>
	<h2>게시물관리</h2>
	<div class="admin_board_list">
		<table class="board_list_table">
			<tr>
				<!-- <th width=5%><input type="checkbox"></th> -->
				<th width=10%>카테고리</th>
				<th width=10%>작성자</th>
				<th width=30%>제목</th>
				<th width=40%>내용</th>
				<th width=10%>삭제</th>
			</tr>
			<tbody>

				<c:forEach var="adminBoard" items="${adminBoardList}">
					<input type="hidden" value="${adminBoard.no}" id="no" name="no" />
					<tr>
						<!-- <td><input type="checkbox"></td> -->
						<td>${adminBoard.category}</td>
						<td>${adminBoard.id}</td>
						<c:if test="${adminBoard.category eq '기부'}">
							<td><a href="/admin/boardDetail&1&${adminBoard.no}">${adminBoard.subject}</a></td>
							<td><a href="/admin/boardDetail&1&${adminBoard.no}">${adminBoard.content}</a></td>
						</c:if>
						<c:if test="${adminBoard.category eq '교환'}">
							<td><a href="/admin/boardDetail&2&${adminBoard.no}">${adminBoard.subject}</a></td>
                            <td><a href="/admin/boardDetail&2&${adminBoard.no}">${adminBoard.content}</a></td>
						</c:if>
						<td><input class="admin_board_delete_btn" type="button" value="삭제" onclick="boardDel('${adminBoard.no}','${adminBoard.category}')"></td>
					</tr>
				</c:forEach>
				<!-- <tr class="borad_delete_btn">
				<td colspan="7"><input type="button" value="선택삭제"></td>
			</tr> -->
			</tbody>
		</table>
	</div>
</article>

<%@ include file="/admin/admin_footer.jsp"%>