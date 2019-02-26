
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%-- <%@ include file="mypagesidemenu.jsp" %> --%>  

<link href="/css/mypage.css" rel="stylesheet" type="text/css" />

<div class="mypage_img_div">
<img class="mypage_img" src="/images/mypage.jpg" /></div>
 
<div class="mygiveList">
		<h1>교 환</h1>
		<form name="mypagefrm">
		<!-- 북마크 교환 -->
	<table class="mygiveList_table">
	<thead>
	<tr>
		<th width="15%">기부 재능</th>
		<th width="15%">희망 재능</th>		
		<th width="40%">제목</th>
		<th width="15%">위치</th>
		<th width="15%">마감일</th>
<!-- 		<td>삭제</td> -->
	</tr>
	</thead>
	<c:forEach var="myexchange" items="${bmExchangeList}">
		<tr>
			<td>${myexchange.give_talent1}&ensp;/&ensp;${myexchange.give_talent2}</td>
			<td>${myexchange.wish_talent1}&ensp;/&ensp;${myexchange.wish_talent2}</td>
			<td><a href="/give/exchangeDetail&${myexchange.no}">${myexchange.subject}</a></td>
			<td>${myexchange.location}</td>
			<td>${myexchange.closing_date}&ensp;</td>
<!-- 			<td><input type="checkbox" id="clip"></td>
 -->		</tr>
	</c:forEach>
	</table>
<!-- 		<input type="button" id="delete_btn" value="체크 한 글 삭제" onclick="delDonationClasses()">
 -->	</form>
</div>

<div id=member></div>
<section class="top_section">
</section>

<%@ include file="../footer.jsp"%>