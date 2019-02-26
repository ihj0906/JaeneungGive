<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

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
			<li><a href="javascript:void(0);" onclick="menu_list('8')">언어</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('9')">예술</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('10')">스포츠</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('11')">컴퓨터</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('12')">그외</a></li>
		</ul>
	</div>

	<!-- 교환 상세 테이블 시작-->
	<form method="post">
		<div class="giveDetail">
			<div class="giveDetail_container">
				<input type="hidden" id="board" value="exchange"> <input
					type="hidden" id="login_id" value="${loginInfo.id}"> <input
					type="hidden" id="no" value="${exchangeDetail.no}">
				<table class="giveDetail_table">
					<tr>
						<th width="10%">기부 재능</th>
						<td width="40%">${exchangeDetail.give_talent1}&ensp;/&ensp;${exchangeDetail.give_talent2}</td>
						<th width="10%">희망 재능</th>
						<td width="20%">${exchangeDetail.wish_talent1}&ensp;/&ensp;${exchangeDetail.wish_talent2}</td>
						<th width="10%">스크랩
						</td>
						<td width="10%">
							<!-- 북마크 시작--> <c:choose>
								<c:when test="${empty loginInfo}">
									<input type="image" class="bookmarkImage"
										id="bookmark${bookmark.no}" src="/images/unbookmark.png"
										onclick="bookmark('2','${bookmark.no}')">
								</c:when>
								<c:when test="${bookmark.id == loginInfo.id}">
									<input type="image" class="bookmarkImage"
										id="bookmark${bookmark.no}" src="/images/bookmark.png"
										onclick="bookmark('2','${bookmark.no}')">
								</c:when>
								<c:otherwise>
									<input type="image" class="bookmarkImage"
										id="bookmark${bookmark.no}" src="/images/unbookmark.png"
										onclick="bookmark('2','${bookmark.no}')">
								</c:otherwise>
							</c:choose> <!-- 북마크 종료 -->
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td colspan='5'><a href="/message/write&${exchangeDetail.id}">${exchangeDetail.id}</a></td>
					</tr>
					<%-- 		
	<tr>
				<th>작성자</th>
			<c:when test="${applicant.progress == 2}">
				<td colspan=3>${exchangeDetail.id}<input type="button" id="messageBtn" value="쪽지보내기" onclick="test()"></td>
				</c:when>
				<c:otherwise>
				<td colspan=3>${exchangeDetail.id}</td>
				</c:otherwise>
			</tr> --%>
					<tr>
						<th>제목</th>
						<td colspan='5'>${exchangeDetail.subject}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan='5'>${exchangeDetail.content}</td>
					</tr>
					<tr>
						<th width="10%">위치</th>
						<td width="40%">${exchangeDetail.location}</td>
						<th width="10%">마감일</th>
						<td width="40%" colspan="3">${exchangeDetail.closing_date}&ensp;<!-- 디데이 출력 시작 -->
							<jsp:useBean id="now" class="java.util.Date" /> <fmt:parseNumber
								var="strDate" value="${now.time / (1000*60*60*24)}"
								integerOnly="true" /> <fmt:parseDate var="endDate"
								value="${exchangeDetail.closing_date }" pattern="yyyy-MM-dd" />
							<fmt:parseNumber var="endDate2"
								value="${endDate.time / (1000*60*60*24)}" integerOnly="true" />
							<c:choose>
								<c:when test="${strDate-endDate2 < 0}">
									D${strDate-endDate2}
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

	<!-- 교환 상세 테이블 끝  -->
	<br>
	<!-- 교환 신청 시작 -->
	<c:if test="${!empty loginInfo}">
		<form id="appli_form" method="post">
			<input type="hidden" name="url"
				value="/give/exchangeDetail&${exchangeDetail.no}"> <input
				type="hidden" name="id" value="${loginInfo.id}"> <input
				type="hidden" name="board_no" value="${exchangeDetail.no}">
			<input type="hidden" name="board_id" value="2"> <input
				type="hidden" name="appli_confirmId" id="appli_confirmId">
			<table class="giveDetail_table_bottom">
				<tr>
					<th class="giveDetail_table_bottom_title" width="10%">NO</th>
					<th class="giveDetail_table_bottom_title" width="10%">ID</th>
					<th class="giveDetail_table_bottom_title" width="50%">내용</th>
					<th class="giveDetail_table_bottom_title" colspan='2' width="30%">진행상황</th>
				</tr>
				<c:choose>
					<%--작성자 - 신청 내용 시작 --%>
					<c:when test="${exchangeDetail.id == loginInfo.id}">
						<c:if test="${empty listOfApplicant}">
							<tr>
								<td colspan="4">현재 신청자가 없습니다</td>
							</tr>
						</c:if>
						<c:forEach var="list" items="${listOfApplicant}">
							<tr>
								<td>${list.no}</td>
								<td>${list.id}</td>
								<td>${list.content}</td>
								<c:if test="${list.progress == 1}">
									<td colspan='2'><input class="board_submit_btn" type="button" id="joinConfirmBtn" value="수락"
										onclick="joinSubmit('${list.id}')"></td>
								</c:if>
								<c:if test="${list.progress == 2}">
									<td colspan='2'>완료</td>
								</c:if>
								<c:if test="${list.progress == 3}">
									<td colspan='2'>거절</td>
								</c:if>
							</tr>
						</c:forEach>
					</c:when>
					<%--작성자 -  신청 내용 종료 --%>
					<%--신청자  - 신청 내용 시작 --%>
					<c:when test="${applicant.id == loginInfo.id}">
						<tr>
							<td></td>
							<td>${applicant.id}</td>
							<td>${applicant.content}</td>
							<c:choose>
								<c:when test="${applicant.progress == 1}">
									<td colspan='2'>진행 중 <input class="board_delete_btn" type=button value="삭제"
										onclick="applicant_del()"></td>
								</c:when>
								<c:when test="${applicant.progress == 2}">
									<td colspan='2'>성사</td>
								</c:when>
								<c:otherwise>
									<td colspan='2'>실패</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:when>
					<%--신청자  - 신청 내용 종료 --%>
					<%--미신청자  - 신청 내용 시작 --%>

					<c:otherwise>
						<tr>

							<c:choose>
								<%-- 신청일이 지났을 경우 잔여 지원자수와 상관 없이 신청 불가 --%>
								<c:when test="${strDate-endDate2 > 0}">
									<td colspan="5">신청일이 지나 마감되었습니다.</td>
								</c:when>
								<%-- 교한 성공 하여  마감  --%>
								<c:when test="${exchangeDetail.app_progress eq 3}">
									<td colspan="5">교환신청이 마감되었습니다.</td>
								</c:when>
								<c:otherwise>
									<td></td>
									<td>${loginInfo.id}</td>
									<td><textarea maxlength="200" name="content"
											id="appli_content"></textarea></td>
									<td colspan='2'><input class="board_submit_btn" type="button"
										id="appli_btn" value="신청" onclick="applicant()"></td>
								</c:otherwise>
							</c:choose>
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
		<c:if test="${exchangeDetail.id == loginInfo.id}">

			<input class="board_list_btn" type="button" id="modify" value="수정"
				onclick="modClassWriteForm('${exchangeDetail.no}')">
			<input class="boardDetail_delete_btn" type="button" id="delete" value="삭제"
				onclick="delClass('${exchangeDetail.no}')">
		</c:if>
		<input class="board_list_btn" type="button" id="back" value="목록"
			onclick="go_back()">
	</div>
	<!-- 버튼 종료-->
	<div class="clear"></div>
</article>
<!-- 메인 끝 -->

<%@ include file="../footer.jsp"%>