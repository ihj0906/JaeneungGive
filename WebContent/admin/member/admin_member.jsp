<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/admin_header.jsp"%>

<article>
	<div class="margin"></div>
	<h2>회원관리</h2>
	<div class="admin_board_list">
		<form action="/admin/memberSelectDelete" method="post" name="form">
			<input type="hidden" value="" id="id" name="id" />
			<table class="board_list_table">
				<tr>
					<!-- <th width=5%><input type="checkbox"></th> -->
					<th width=15%>아이디</th>
					<th width=15%>이름</th>
					<th width=25%>이메일</th>
					<th width=15%>연락처</th>
					<th width=15%>탈퇴여부</th>
					<th width=15%>활성/비활성</th>
				</tr>
				<tbody>

					<c:forEach var="adminMember" items="${adminMemberList}">
						<tr>
							<!-- 	<td><input type="checkbox"></td> -->
							<td>${adminMember.id}</td>
							<td>${adminMember.name}</td>
							<td>${adminMember.email}</td>
							<td>${adminMember.phone}</td>
							<c:choose>
								<c:when test="${adminMember.useyn == 1}">
									<td>비활성</td>
									<td><input class="admin_member_enable_btn" type="button"
										value="활성화" onclick="adminMemberUpdate('${adminMember.id}')"></td>
								</c:when>
								<c:otherwise>
									<td>활성</td>
									<td><input class="admin_member_disble_btn" type="button"
										value="비활성화" onclick="adminMemberDelete('${adminMember.id}')"></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
					<!-- <tr class="borad_delete_btn">
				<td colspan="7"><input type="button" value="선택삭제"></td>
			</tr> -->
				</tbody>
			</table>
		</form>
	</div>
</article>

<%@ include file="/admin/admin_footer.jsp"%>