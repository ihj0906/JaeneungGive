<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%-- <%@ include file="mypagesidemenu.jsp"%> --%>

<link href="/css/mypage.css" rel="stylesheet" type="text/css" />

<div class="mypage_img_div">
<img class="mypage_img" src="/images/mypage.jpg" /></div>

<div class="mygiveList">
	<h1>내가 쓴 글</h1>
	<!-- 내가 쓴 기부글 -->
	<table class="mygiveList_table">
	<thead>
	<tr>
		<th width="15%">기부 재능</th>		
		<th width="50%">제목</th>
		<th width="15%">마감일</th>
		<th width="15%">진행 상태</th>
	</tr>
	</thead>
	<c:forEach var="mywriteDonation" items="${mywriteDonationList}">
		<tr>
			<td>${mywriteDonation.talent1}&ensp;/&ensp;${mywriteDonation.talent2}</td>
			<td><a href="/give/donationDetail&${mywriteDonation.no}">${mywriteDonation.subject}</a></td>
			<td>${mywriteDonation.closing_date}&ensp;</td>
			<td><c:if test="${mywriteDonation.app_progress == 1}">진행중</c:if>
			<c:if test="${mywriteDonation.app_progress == 3}"> 완료</c:if></td>
		</tr>
	</c:forEach>
	</table>
		<!-- <input class="boardDetail_delete_btn" type="button" id="delete_btn" value="선택 삭제" onclick="alert('정말 삭제 하시겠습니까?')"> -->
</div>

<div id=member></div>

<section class="top_section">
</section>

<%@ include file="../footer.jsp"%>