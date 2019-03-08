<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<div style="background-color: #8ecbc4;">
	<img class="message_img" src="/images/message.jpg">
</div>
<div class="noteall">
<%@ include file="sidemenu.jsp"%>
<div class="note_area">
	<h4>보낸 쪽지함</h4>
	<form name="message_form">
		<a class="note_btn" href="javascript:void(0);" onclick="delete_note('del_from')"><span
			class="bu_del"></span>삭제</a>
		<table class="notelist">
			<tr>
				<th width=3%;><input type="checkbox" class="checked-all" onclick="checked_all()"></th>
				<th>내용</th>
				<th width=15%>받는사람</th>
				<th width=20%>보낸날짜</th>
			</tr>
			<c:forEach var="sent" items="${sentList}">
				<tr>
					<td><input type="checkbox" id="note_check" class="checkbox" name="del_no"
						value="${sent.no}"></td>
					<td id="content"><a href="sent&${sent.no}">${sent.content}</a></td>
					<td>${sent.toId}</td>
					<td><fmt:formatDate type="BOTH" value="${sent.sendTime}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
<%-- 	<div class="paginate">
		<input type="button" value="<<"> <input type="button"
			value="<"> <input type="button" value="1"> <input
			type="button" value=">"> <input type="button" value=">>">
	</div> --%>
</div>

</div>
<%@ include file="/footer.jsp"%>