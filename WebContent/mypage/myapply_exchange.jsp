<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%-- <%@ include file="mypagesidemenu.jsp"%> --%>

<link href="/css/member.css" rel="stylesheet" type="text/css" />

<div class="mypage_img_div">
<img class="mypage_img" src="/images/mypage.jpg" /></div>

<div class="mygiveList">
	<h1>
		신청한 글
	</h1>
	<!-- 내가 신청한 교환 -->
	<table class="mygiveList_table">
		<thead>
			<tr>
				<td width="15%">상대재능</td>
				<td width="15%">나의재능</td>
				<td width="25%">제목</td>
				<td width="15%">작성자</td>
				<td width="15%">신청일</td>
				<td width="15%">진행 상태</td>
			</tr>
		</thead>
		<c:forEach var="myexchange" items="${myApplyExchangeList}">
			<tr>
				<td>${myexchange.give_talent1}&ensp;/&ensp;${myexchange.give_talent2}</td>
				<td>${myexchange.wish_talent1}&ensp;/&ensp;${myexchange.wish_talent2}</td>
				<td style="white-space: nowrap; width: 50px;"><a
					href="/give/exchangeDetail&${myexchange.no}">${myexchange.subject}</a></td>
				<td>${myexchange.id}</td>
				<td><fmt:formatDate value="${myexchange.app_appli_date}" /></td>
				<td><c:choose>
						<c:when test="${myexchange.app_user_progress == 1}"> 진행 중
					</c:when>
						<c:when test="${myexchange.app_user_progress == 2}"> 성사
					</c:when>
						<c:otherwise> 실패
					</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>
</div>

<div id=member></div>

<section class="top_section">
</section>

<%@ include file="../footer.jsp"%>