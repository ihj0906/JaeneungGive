
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<div style="background-color: #8ecbc4;">
	<img class="message_img" src="/images/message.jpg">
</div>
<div class="noteall">
<%@ include file="sidemenu.jsp"%>
<!-- <section class="top_section"></section> -->

<div class="note_area">
	<h4>받은 쪽지함</h4>
<%-- 	<a class="note_btn" href="/message/delete&${noteDetail.no}"><span class="bu_del"></span>삭제</a> --%>
	<form name="message_form">
	<a class="note_btn" href="javascript:void(0);" onclick="delete_note('del_to')"><span class="bu_del"></span>삭제</a>
	<table class="notelist">
		<tr>
<!-- 			<th width=3%;><input type="checkbox" class="checked-all" onclick="checkedAll()"></th> -->
			<th width=3%;><input type="checkbox" class="checked-all" onClick="checked_all()" ></th>
			<th>내용</th>
			<th width=15%>보낸사람</th>
			<th width=20%>받은날짜</th>
			<th width=10%>읽음</th>
		</tr>
		
		<c:forEach var="inbox" items="${inboxList}">
			<tr>
				<td><input type="checkbox" id="note_check" class="checkbox" name="del_no" value="${inbox.no}"></td>
				<td id="content"><a href="inbox&${inbox.no}">${inbox.content}</a></td>
				<td>${inbox.fromId}</td>
				<td><fmt:formatDate type="BOTH" value="${inbox.sendTime}" /></td>
				<c:if test="${inbox.readYn == 1}">
					<td>읽음</td>
				
				</c:if>
				<c:if test="${inbox.readYn != 1}">
					<td>읽지 않음</td>
				</c:if>
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


<%@ include file="../footer.jsp"%>
