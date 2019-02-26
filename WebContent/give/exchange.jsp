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

	<!-- <form method="post"> -->
	<div class="giveMenu">
		<ul>
			<li><a href="javascript:void(0);" onclick="menu_list('8')">언어</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('9')">예술</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('10')">스포츠</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('11')">컴퓨터</a></li>
			<li><a href="javascript:void(0);" onclick="menu_list('12')">그외</a></li>
		</ul>
	</div>
	<div class="board_title_div">
	<h2 class="board_title"><img class="exchange_img" src="/images/exchange.png" />재능교환 게시판</h2>
	</div>
	<div class="giveList">
		<div class="giveList_container">
			<div class="search_result">
				<input type="hidden" id="board" value="exchange"> <input
					type="hidden" name="no" value="${exchange.no}">
				<c:if test="${empty keyword}">
					<p class="search_category">◎ 검색결과 : 전체</p>
				</c:if>
				<c:if test="${!empty keyword}">
					<p class="search_category">◎ 검색결과 : ${keyword}</p>
				</c:if>
				<input class="new_board_write_btn" type="button" id="giveReg" value="새 글 작성"
					onclick="newClassWriteForm('${loginInfo.id}')">
			</div>
			<table class="giveList_table">
				<thead>
					<tr>
						<td width="10%">기부 재능</td>
						<td width="10%">희망 재능</td>
						<td width="40%">제목</td>
						<td width="10%">작성자</td>
						<td width="15%">위치</td>
						<td width="10%">마감일</td>
						<td width="5%">스크랩</td>
					</tr>
				</thead>
				<tbody>
					<c:set var="rlfdl" value="${fn:length(exchangeList)}" />
					<c:choose>
						<c:when test="${rlfdl != 0}">
							<c:forEach var="num" begin="0" end="${rlfdl-1}">
								<%-- <c:forEach var="exchange" items="${exchangeList}"> --%>
								<tr>
									<td>${exchangeList[num].give_talent1}&ensp;/&ensp;${exchangeList[num].give_talent2}</td>
									<td>${exchangeList[num].wish_talent1}&ensp;/&ensp;${exchangeList[num].wish_talent2}</td>
									<td><a href="/give/exchangeDetail&${exchangeList[num].no}">${exchangeList[num].subject}</a></td>
									<td>${exchangeList[num].id}</td>
									<td>${exchangeList[num].location}</td>
									<%-- <td>${exchangeList[num].closing_date}&ensp;<span id=dday>D-6</span></td> --%>
									<!-- 디데이 출력 시작 -->
									<td><jsp:useBean id="now" class="java.util.Date" /> <fmt:parseNumber
											var="strDate" value="${now.time / (1000*60*60*24)}"
											integerOnly="true" /> <fmt:parseDate var="endDate"
											value="${exchangeList[num].closing_date }"
											pattern="yyyy-MM-dd" /> <fmt:parseNumber var="endDate2"
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
									<!-- 북마크 시작-->
									<td><c:choose>
											<c:when test="${empty loginInfo}">
												<input type="image" class="bookmarkImage"
													id="bookmark${bookmarkList[num].no}"
													src="/images/unbookmark.png"
													onclick="bookmark('2','${bookmarkList[num].no}')">
											</c:when>
											<c:when test="${bookmarkList[num].id == loginInfo.id}">
												<input type="image" class="bookmarkImage"
													id="bookmark${bookmarkList[num].no}"
													src="/images/bookmark.png"
													onclick="bookmark('2','${bookmarkList[num].no}')">
											</c:when>
											<c:otherwise>
												<input type="image" class="bookmarkImage"
													id="bookmark${bookmarkList[num].no}"
													src="/images/unbookmark.png"
													onclick="bookmark('2','${bookmarkList[num].no}')">
											</c:otherwise>
										</c:choose></td>
									<!-- 북마크 종료 -->
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td>현재 등록 된 재능교환이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
				<tfoot>
				<!-- 페이징 시작 -->
					<tr>
						<td colspan="8">
							<!-- 왼쪽 화살표 --> <c:if test="${page.prev}">
								<a style="text-decoration: none;"
									href="javascript:page(${page.getStartPage()-1});"><c:out value="<<"/></a>
							</c:if> <!-- 페이지 숫자 표시 --> <c:forEach begin="${page.getStartPage()}"
								end="${page.getEndPage()}" var="idx">
								<a style="text-decoration: none;"
									href="javascript:page(${idx});">${idx}</a>
							</c:forEach> <!-- 오른쪽 화살표 --> <c:if test="${page.next}">
								<a style="text-decoration: none;"
									href="javascript:page(${page.getEndPage()+1});"><c:out value=">>"/></a>
							</c:if>
						</td>
					</tr>
					<!-- 페이징 끝-->
				</tfoot>
			</table>
		</div>
	</div>
	<!-- </form> -->
	<div class="clear"></div>
</article>
<!-- 메인 끝 -->

<%@ include file="../footer.jsp"%>