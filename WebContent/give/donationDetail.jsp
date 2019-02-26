<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<link href="/css/give.css" rel="stylesheet" type="text/css" />

<!-- 메인 시작 -->
<article>
	<!-- 검색창 시작 -->
	<div class="search_wrap">
		<div class="main_search">
			<form method="post" name="frm">
				<div class="main_search_container">
					<select id="search_category" name="category">
						<option value="선택">선택</option>
						<option value="기부">기부</option>
						<option value="교환">교환</option>
					</select> <input type="text" name="key" placeholder="검색어를 입력해주세요" /> <input
						type="button" onclick="go_search()" value="검색" />
				</div>
			</form>
		</div>
	</div>
	<!-- 검색창 끝 -->

	<div class="giveMenu">
		<ul>
			<li><a href="javascript:void(0);" onclick="menu_list('2')">언어</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('3')">예술</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('4')">스포츠</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('5')">컴퓨터</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('6')">그외</a></li>
		</ul>
	</div>


	<!-- 기부 상세 테이블 시작 -->

	<form method="post">
		<div class="giveDetail">
			<div class="giveDetail_container">
				<input type="hidden" id="board" value="donation"> <input
					type="hidden" id="login_id" value="${loginInfo.id}"> <input
					type="hidden" id="no" value="${donationDetail.no}">

				<table class="giveDetail_table">
					<tr>
						<th width="10%">기부 재능</th>
						<td width="40%">${donationDetail.talent1}&ensp;/&ensp;${donationDetail.talent2}</td>
						<th width="10%">모집인원</th>
						<td width="20%">${fn:length(listOfApplicant)}&ensp;/&ensp;${donationDetail.people}</td>
						<th width="10%">스크랩</th>
						<td width="10%">
	<!-- 북마크 시작-->
	<c:choose>
		<c:when test="${empty loginInfo}">
			<input type="image" class="bookmarkImage" id="bookmark${bookmark.no}"
				src="/images/unbookmark.png"
				onclick="bookmark('1','${bookmark.no}')">
		</c:when>
		<c:when test="${bookmark.id == loginInfo.id}">
			<input type="image" class="bookmarkImage" id="bookmark${bookmark.no}"
				src="/images/bookmark.png" onclick="bookmark('1','${bookmark.no}')">
		</c:when>
		<c:otherwise>
			<input type="image" class="bookmarkImage" id="bookmark${bookmark.no}"
				src="/images/unbookmark.png"
				onclick="bookmark('1','${bookmark.no}')">
		</c:otherwise>
	</c:choose>
	<!-- 북마크 종료  -->
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td colspan='5'><a href="/message/write&${donationDetail.id}">${donationDetail.id}</a></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan='5'>${donationDetail.subject}</td>
					</tr>
					<tr>
						<th width="10%" class="board_form_Detail">내용</th>
						<td width="60%" class="board_form_Detail" colspan='5'>${donationDetail.content}</td>
					</tr>
					<tr>
						<th width="10%">위치</th>
						<td width="40%">${donationDetail.location}</td>
						<th width="10%">마감일</th>
						<td width="40%" colspan='3'>${donationDetail.closing_date}&ensp;<!-- 디데이 출력 시작 --> <jsp:useBean
								id="now" class="java.util.Date" /> <fmt:parseNumber
								var="strDate" value="${now.time / (1000*60*60*24)}"
								integerOnly="true" /> <fmt:parseDate var="endDate"
								value="${donationDetail.closing_date }" pattern="yyyy-MM-dd" />
							<fmt:parseNumber var="endDate2"
								value="${endDate.time / (1000*60*60*24)}" integerOnly="true" />
							<c:choose>
								<c:when test="${strDate-endDate2 < 0}">
									마감
									</c:when>
								<c:otherwise>
									D+${strDate-endDate2}
									</c:otherwise>
							</c:choose></td>
						<!-- 디데이 출력 종료  -->

					</tr>
				</table>
			</div>
		</div>
	</form>
	<!-- 기부 상세 테이블 종료  -->
	<br>
	<!-- 기부 신청 시작 -->
	<c:if test="${!empty loginInfo}">
		<form id="appli_form" method="post">
			<input type="hidden" name="url"
				value="/give/donationDetail&${donationDetail.no}"> <input
				type="hidden" name="id" value="${loginInfo.id}"> <input
				type="hidden" name="board_no" value="${donationDetail.no}">
			<input type="hidden" name="board_id" value="1"> <input
				type="hidden" name="appli_confirmId" id="appli_confirmId"> <input
				type="hidden" value="${donationDetail.people}" name="people">
			<table class="giveDetail_table_bottom">
				<tr>
					<th class="giveDetail_table_bottom_title" width="25%">NO</th>
					<th class="giveDetail_table_bottom_title" width="25%">ID</th>
					<th colspan='2' class="giveDetail_table_bottom_title" width="50%">진행상태</th>
				</tr>

				<c:choose>
					<%--작성자 - 신청 내용 시작 --%>
					<c:when test="${donationDetail.id == loginInfo.id}">
						<c:if test="${empty listOfApplicant}">
							<tr>
								<td colspan="3">현재 신청자가 없습니다</td>
							</tr>
						</c:if>
						<c:forEach var="list" items="${listOfApplicant}">
							<tr>
								<td>${list.no}</td>
								<td>${list.id}</td>
								<td colspan='2'>
								<c:if test="${list.progress==1}">신청</c:if></td>
							</tr>
						</c:forEach>
					</c:when>
					<%--작성자 -  신청 내용 종료 --%>
					<%--신청자  - 신청 내용 시작 --%>
					<c:when test="${applicant.id == loginInfo.id}">
						<tr>
							<td></td>
							<td>${applicant.id}</td>
							<c:if test="${applicant.progress == 3}">
								<td>신청 완료 </td>
								<td><input class="board_delete_btn" type=button value="취소"
									onclick="applicant_del()"></td>
							</c:if>
						</tr>
					</c:when>
					<%--신청자  - 신청 내용 종료 --%>
					<%--미신청자  - 신청 내용 시작 --%>

					<c:otherwise>
						<tr>
						<%-- 신청인원 마감  --%>
							<c:if
								test="${donationDetail.app_progress eq 3}">
<%-- 							<c:if
								test="${fn:length(listOfApplicant) == donationDetail.people }"> --%>
								<td colspan="4">정원이 마감되었습니다.</td>
							</c:if>
							<c:if
								test="${fn:length(listOfApplicant) < donationDetail.people }">
								<c:choose>
						<%-- 신청일이 지났을 경우 잔여 지원자수와 상관 없이 신청 불가 --%>
									<c:when test="${strDate-endDate2 > 0}">
										<td colspan="4">신청일이 지나 마감되었습니다.</td>
									</c:when>
									<c:otherwise>
										<td></td>
										<td>${loginInfo.id}</td>
										<td colspan='2'><input class="board_submit_btn" type="button" id="appli_btn" value="신청"
											onclick="applicant_d()"></td>
									</c:otherwise>
								</c:choose>
							</c:if>
						</tr>
					</c:otherwise>
					<%--미신청자  - 신청 내용 종료--%>
				</c:choose>
			</table>

		</form>
	</c:if>
	<!-- 교환 신청 종료  -->

	<!-- 버튼  시작 -->
	<div class="board_btn">
	
	<c:if test="${donationDetail.id == loginInfo.id}">
	<input class="board_list_btn" type="button" id="modify" value="수정"
			onclick="modClassWriteForm('${donationDetail.no}')">
	<input class="boardDetail_delete_btn" type="button" id="delete" value="삭제"
			onclick="delClass('${donationDetail.no}')">
	</c:if>
	
	<input class="board_list_btn" type="button" id="back" value="목록" onclick="go_back()">
	</div>
	<!-- 버튼 종료-->
	<div class="clear"></div>
</article>
<!-- 메인 끝 -->

<%@ include file="../footer.jsp"%>