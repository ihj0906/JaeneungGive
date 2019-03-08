<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<div style="background-color: #8ecbc4;">
	<img class="message_img" src="/images/message.jpg">
</div>
<div class="noteall">
<%@ include file="sidemenu.jsp"%>
<div class="note_area">
	<h4>쪽지 쓰기</h4>
	<!-- 기부 / 교환 글 카테고리 출력 -->
	<!-- <p>
			<button class="j_category">기부</button>
			글제목이 들어갈 장소입니다.
		</p> -->
	<form action="sendResult" id="messageForm" method="post">
		<table class="noteDetail">
			<tr>
				<th width="10%">받는사람</th>
				<td class="message_to_member"><input type=hidden name="toId" value="${toId}">${toId}</td>
				<td><input type=hidden name="fromId" value="${loginInfo.id}"></td>
			</tr>
			<tr><td colspan="2">
		<textarea rows="30" cols="auto" name="content" class="note_text"
			placeholder="메세지를 작성해주세요" onclick="counttext()"></textarea>
		</td></tr>
		<tr><td colspan="2">
		<span id="counter">(0 / 최대 1000자)</span>
		</td></tr>
		<tr><td colspan="2" class="message_btn">
			<input type="button" class="message_cancel_btn" value="취소" onclick="cancelMessage()">
			<input type="button" class="message_submit_btn"value="보내기" onclick="sendMessage()">
		</td></tr>
		</table>

	</form>
</div>

</div>
<%@ include file="/footer.jsp"%>