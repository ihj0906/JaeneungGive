<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!-- 검색 기능 -->
<script type="text/javascript" src="/js/index.js"></script>

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

	<!-- 재능기부 최근목록 시작 -->
	<div class="main_wrap">
		<section class="donation_main">

			<h2 class="give_font">
				<img class="donation_img" src="/images/donation.png" />최근 재능기부 목록
			</h2>
			<div class="donation">
				<c:forEach var="num" begin="0" end="3">
					<div class="donation_list">
						<div class="donation_list_top">
							<div class="donation_talent">${donationList[num].talent2}</div>
							<div class="donation_full">${donationList[num].count} / ${donationList[num].people}</div>
						</div>
						<div class="donation_list_middle">

							<!-- 북마크 시작-->
							<div class="donation_bookmark">
								<c:choose>
									<c:when test="${empty loginInfo}">
										<input type="image" class="bookmarkImage"
											id="bookmark${bookmarkList[num].no}"
											src="/images/unbookmark.png"
											onclick="bookmark('1','${bookmarkList[num].no}')">
									</c:when>
									<c:when test="${bookmarkList[num].id == loginInfo.id}">
										<input type="image" class="bookmarkImage"
											id="bookmark${bookmarkList[num].no}"
											src="/images/bookmark.png"
											onclick="bookmark('1','${bookmarkList[num].no}')">
									</c:when>
									<c:otherwise>
										<input type="image" class="bookmarkImage"
											id="bookmark${bookmarkList[num].no}"
											src="/images/unbookmark.png"
											onclick="bookmark('1','${bookmarkList[num].no}')">
									</c:otherwise>
								</c:choose>
							</div>
							<!-- 북마크 종료 -->
							<div class="donation_subject"
								onclick="go_d_detail(${donationList[num].no})">
								<a href="/give/donationDetail&${donationList[num].no}">${donationList[num].subject}</a>
							</div>
							<hr>
						</div>
						<div class=link_to_detail
							onclick="go_d_detail(${donationList[num].no})">
							<div class="donation_content">
								<a href="/give/donationDetail&${donationList[num].no}">${donationList[num].content}</a>
							</div>
						</div>
						<hr>
						<div>
							<div class="donation_user">${donationList[num].id}</div>
							<!-- 디데이 출력 시작 -->
							<div class="donation_dday">
							<%-- <jsp:useBean id="now" class="java.util.Date" /> --%>
									<c:set var="now" value="<%= new java.util.Date() %>"/> 
								<fmt:parseNumber var="strDate"
									value="${now.time / (1000*60*60*24)}" integerOnly="true" />
								<fmt:parseDate var="endDate"
									value="${donationList[num].closing_date }" pattern="yyyy-MM-dd" />
								<fmt:parseNumber var="endDate2"
									value="${endDate.time / (1000*60*60*24)}" integerOnly="true" />
								<c:choose>
									<c:when test="${strDate-endDate2 < 0}">
									D${strDate-endDate2}
									</c:when>
									<c:otherwise>
									마감
									</c:otherwise>
								</c:choose>
							</div>
							<!-- 디데이 출력 종료  -->
							<div class="donation_position">
								<img class="donation_position_img" src="images/do_pin.png" />${donationList[num].location}</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>

		<!-- 재능교환 최근목록 시작 -->
		<section class="donation_main">

			<h2 class="give_font">
				<img class="exchange_img" src="/images/exchange.png" />최근 재능교환 목록
			</h2>
			<div class="donation">
				<c:forEach var="num" begin="0" end="3">
					<div class="donation_list">
						<div class="donation_list_top">
							<div class="donation_talent">${exchangeList[num].give_talent2}</div>
							<div class="donation_full">${exchangeList[num].wish_talent2}</div>
						</div>
						<div class="donation_list_middle">
							<!-- 북마크 시작-->
							<div class="donation_bookmark">
								<c:choose>
									<c:when test="${empty loginInfo}">
										<input type="image" class="bookmarkImage"
											id="bookmark${bookmarkListE[num].no}"
											src="/images/unbookmark.png"
											onclick="bookmark('2','${bookmarkListE[num].no}')">
									</c:when>
									<c:when test="${bookmarkListE[num].id == loginInfo.id}">
										<input type="image" class="bookmarkImage"
											id="bookmark${bookmarkListE[num].no}"
											src="/images/bookmark.png"
											onclick="bookmark('2','${bookmarkListE[num].no}')">
									</c:when>
									<c:otherwise>
										<input type="image" class="bookmarkImage"
											id="bookmark${bookmarkListE[num].no}"
											src="/images/unbookmark.png"
											onclick="bookmark('2','${bookmarkListE[num].no}')">
									</c:otherwise>
								</c:choose>
							</div>
							<!-- 북마크 종료 -->
							<div class="donation_subject"
								onclick="go_e_detail(${exchangeList[num].no})">
								${exchangeList[num].subject}</div>
							<hr>
						</div>
						<div class="link_to_detail"
							onclick="go_e_detail(${exchangeList[num].no})">
							<div class="donation_content">${exchangeList[num].content}
							</div>
							<hr>
						</div>
						<div class="donation_user">${exchangeList[num].id}</div>
						<!-- 디데이 출력 시작 -->
						<div class="donation_dday">
							<fmt:parseDate var="endDate"
								value="${exchangeList[num].closing_date }" pattern="yyyy-MM-dd" />
							<fmt:parseNumber var="endDate2"
								value="${endDate.time / (1000*60*60*24)}" integerOnly="true" />
							<c:choose>
								<c:when test="${strDate-endDate2 < 0}">
									D${strDate-endDate2}
									</c:when>
								<c:otherwise>
									마감
									</c:otherwise>
							</c:choose>
						</div>
						<!-- 디데이 출력 종료  -->
						<div class="donation_position">
							<img class="donation_position_img" src="images/ex_pin.png" />${exchangeList[num].location}</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</div>
	<!-- 재능기부 최근목록 끝 -->

	<div class="clear"></div>

</article>
<!-- 메인 끝 -->

<%@ include file="footer.jsp"%>