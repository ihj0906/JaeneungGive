<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%-- <%@ include file="mypagesidemenu.jsp" %> --%>   

<link href="/css/mypage.css" rel="stylesheet" type="text/css" />

<div class="mypage_img_div">
<img class="mypage_img" src="/images/mypage.jpg" /></div>

<div class="mygiveList">
		<h1>내가 쓴 글</h1>
		<!-- 내가 쓴 교환글 -->
	<table class="mygiveList_table">
	
	<thead>
	<tr>
		<td width="15%">기부 재능</td>
		<td width="15%">희망 재능</td>
		<td width="40%">제목</td>
		<td width="15%">마감일</td>
		<td width="15%">진행 상태</td>
		
	</tr>
	</thead>
	<c:forEach var="mywriteExchange" items="${mywriteExchangeList}">
		<tr>
			<td>${mywriteExchange.give_talent1}&ensp;/&ensp;${mywriteExchange.give_talent2}</td>
			<td>${mywriteExchange.wish_talent1}&ensp;/&ensp;${mywriteExchange.wish_talent2}</td>
			<td style="white-space: nowrap; width: 50px;"><a href="/give/exchangeDetail&${mywriteExchange.no}">${mywriteExchange.subject}</a></td>
			<td>${mywriteExchange.closing_date}&ensp;</td>
			<td><c:if test="${mywriteExchange.app_progress == 1}">진행중</c:if>
			<c:if test="${mywriteExchange.app_progress == 3}">완료</c:if></td>
		</tr>
	</c:forEach>
	</table>
</div>


<div id=member></div>
<section class="top_section">
</section>

<%@ include file="../footer.jsp"%>