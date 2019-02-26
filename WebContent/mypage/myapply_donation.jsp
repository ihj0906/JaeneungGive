
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%-- <%@ include file="mypagesidemenu.jsp" %> --%>   

<link href="/css/mypage.css" rel="stylesheet" type="text/css" />

<div class="mypage_img_div">
<img class="mypage_img" src="/images/mypage.jpg" /></div>

<div class="mygiveList">
		<h1>신청한 글</h1>
		<!-- 내가 신청한 기부 -->
	<table class="mygiveList_table">
	<thead>    
	<tr>
			<td width="15%">재능명</td>
			<td width="40%">제목</td>
			<td width="15%">작성자</td>
			<td width="15%">신청일</td>
			<td width="15%">진행 상태</td>
			
		</tr>
	</thead>
	<c:forEach var="mydonation" items="${myApplyDonationList}">
		<tr>
			<td>${mydonation.talent1}&ensp;/&ensp;${mydonation.talent2}</td>
			<td style="white-space: nowrap; width: 500px;"><a href="/give/donationDetail&${mydonation.no}">${mydonation.subject}</a></td>
			<td>${mydonation.id}</td>
			<td><fmt:formatDate value="${mydonation.app_appli_date}"/></td>
			
			<td><c:if test="${mydonation.app_user_progress == 3}">신청 완료</c:if> </td>
			</tr>
	</c:forEach>
	</table>
</div>

<div id=member></div>

<section class="top_section">
</section>

<%@ include file="../footer.jsp"%>