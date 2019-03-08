<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<div style="background-color: #8ecbc4;">
	<img class="message_img" src="/images/message.jpg">
</div>
<div class="noteall">
	<%@ include file="sidemenu.jsp"%>

	<div class="note_area">
		<h4>쪽지 읽기</h4>
		<!-- 기부 / 교환 글 카테고리 출력 
		<p>
			<button class="j_category">기부</button>
			글제목이 들어갈 장소입니다.
		</p>
		-->

		<!-- 쪽지삭제 -->
		<form name="message_form">
			<c:if test="${who == '보낸사람' }">
				<a class="note_btn" href="javascript:void(0);"
					onclick="del_note('del_to')"><span class="bu_del"></span>삭제</a>
				<input type="hidden" name="del_no" value="${noteDetail.no}">
				<!-- 답장버튼 -->
				<a class="note_btn" href="/message/write&${noteDetail.fromId}">답장하기</a>

				<table class="noteDetail">
					<tr>
						<th>${who}</th>
						<td>${noteDetail.fromId}</td>
					</tr>
					<tr>
						<th>${time}</th>
						<td><fmt:formatDate type="BOTH"
								value="${noteDetail.sendTime}" /></td>
					</tr>
					<tr>
						<td id="content" colspan="2">${noteDetail.content}</td>
					</tr>
				</table>
			</c:if>

			<c:if test="${who == '받는사람'}">
				<a class="note_btn" href="javascript:void(0);"
					onclick="del_note('del_from')"><span class="bu_del"></span>삭제</a>
				<input type="hidden" name="del_no" value="${noteDetail.no}">

				<table class="noteDetail">
					<tr>
						<th>${who}</th>
						<td>${noteDetail.toId}</td>
					</tr>
					<tr>
						<th>${time}</th>
						<td><fmt:formatDate type="BOTH"
								value="${noteDetail.sendTime}" /></td>
					</tr>
					<tr>
						<td id="content" colspan="2">${noteDetail.content}</td>
					</tr>
				</table>
			</c:if>
		</form>
	</div>
</div>

<%@ include file="/footer.jsp"%>