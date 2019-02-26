<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%-- <%@ include file="mypagesidemenu.jsp" %> --%>   

<link href="/css/mypage.css" rel="stylesheet" type="text/css" />

<div class="mypage_img_div">
<img class="mypage_img" src="/images/mypage.jpg" /></div>

<div class="mygiveList">
		<h1>기 부</h1>
		<form name="mypagefrm">
		<!-- 북마크 기부 -->
	<table class="mygiveList_table">
	<thead>
	<tr>
		<td width="15%">기부 재능</td>
		<td width="15%">모집 인원</td>
		<td width="40%">제목</td>
		<td width="15%">위치</td>
		<td width="15%">마감일</td>
	</tr>
	</thead>
	<c:forEach var="mydonation" items="${bmDonationList}">
		<tr>
			<td>${mydonation.talent1}&ensp;/&ensp;${mydonation.talent2}</td>
			<td>${mydonation.people}</td>
			<td style="white-space: nowrap; width: 50px;"><a href="/give/donationDetail&${mydonation.no}">${mydonation.subject}</a></td>
			<td>${mydonation.location}</td>
			<td>${mydonation.closing_date}&ensp;</td>
 		</tr>
	</c:forEach>
	</table>
	</form>
</div>

<div id=member></div>
<section class="top_section">
</section>

<%@ include file="../footer.jsp"%>