<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jaeneung Give</title>
<script type="text/javascript" src="/js/qna.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
<script type="text/javascript" src="/js/message.js"></script>
<script type="text/javascript" src="/js/member.js"></script>
<script type="text/javascript" src="/js/give.js"></script>
<script type="text/javascript" src="/js/mypage.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link href="/css/index.css" rel="stylesheet" type="text/css" />
<!-- 폰트 css 관련 -->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<!-- 버튼 css 관련 -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type='text/css'>
<link href='https://fonts.googleapis.com/css?family=PT+Sans:700' rel='stylesheet' type='text/css'>
<!-- <link href="/css/member.css" rel="stylesheet" type="text/css" />
<link href="/css/message.css" rel="stylesheet" type="text/css" />
<link href="/css/report.css" rel="stylesheet" type="text/css" /> -->

<!-- <script type="text/javascript" src="js/jaeneung.js"></script> -->
</head>
<body>
<fmt:setLocale value="ko" />
	<div class="wrap">
		<!-- 헤더 시작 -->
		<header>
			<div class="top_container">
				<div id="logo">
					<a href="/index"> <img src="/images/logo3.png" alt="logo" />
					</a>
				</div>

				<form name=frmm action="/give/search_give_donation" id="headerForm"
					method=post>
					<input type="hidden" name="category"> <input type="hidden"
						name="key"> <input type="hidden" id="qnaId"
						value="${loginInfo.id }">

					<nav class="header_menu">
						<div class="header_menu_container">
							<ul>
								<li class="header_dropdown_menu"><a
									href="/introduce/introduceSite">&emsp;사이트 소개&emsp;</a>
									<ul class="header_dropdown">
										<li class="header_dropdown_menu"><a
											href="/introduce/introduceSite">재능기부 란?</a></li>
										<li class="header_dropdown_menu"><a
											href="/introduce/howtouse">이용 방법</a></li>
									</ul></li>
								<li class="header_dropdown_menu">
									<!-- <a href="give/search_give" id="기부">&emsp;재능기부&emsp;∨</a> -->
									<a href="javascript:void(0);" onclick="menu_list('1')">&emsp;재능기부&emsp;</a>
									<ul class="header_dropdown">
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('2')">언어</a></li>
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('3')">예술</a></li>
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('4')">스포츠</a></li>
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('5')">컴퓨터</a></li>
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('6')">그외</a></li>
									</ul>
								</li>
								<!-- 						<li><a href="/give/exchange.jsp">&emsp;재능교환&emsp;∨</a> -->
								<li class="header_dropdown_menu"><a
									href="javascript:void(0);" onclick="menu_list('7')">&emsp;재능교환&emsp;</a>
									<ul class="header_dropdown">
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('8')">언어</a></li>
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('9')">예술</a></li>
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('10')">스포츠</a></li>
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('11')">컴퓨터</a></li>
										<li class="header_dropdown_menu"><a
											href="javascript:void(0);" onclick="menu_list('12')">그외</a></li>
									</ul></li>

								<c:if test="${!empty loginInfo}">
									<li class="header_dropdown_menu"><a
										href="/mypage/memberinfo">&emsp;마이페이지&emsp;</a>
										<ul class="header_dropdown">
											<li class="header_dropdown_menu"><a href="/mypage/memberinfo">회원정보</a></li>
											<li class="header_dropdown_menu"><a>재능기부 내역</a>
												<ul>
													<li class="header_dropdown_menu"><a href="/mypage/mywrite_donation">나의 재능기부</a></li>
													<li class="header_dropdown_menu"><a href="/mypage/myapply_donation">기부 신청 내역</a></li>
												</ul>
											</li>
											<li class="header_dropdown_menu"><a>재능교환 내역</a>
												<ul>
													<li class="header_dropdown_menu"><a href="/mypage/mywrite_exchange">나의 재능교환</a></li>
													<li class="header_dropdown_menu"><a href="/mypage/myapply_exchange">교환 신청 내역</a></li>
												</ul>
											</li>
											<li class="header_dropdown_menu"><a>스크랩</a>
												<ul>
													<li class="header_dropdown_menu"><a href="/mypage/bm_donation">재능기부</a></li>
													<li class="header_dropdown_menu"><a href="/mypage/bm_exchange">재능교환</a></li>
												</ul>
											</li>
											<!-- <li><a href="#">재능판매내역</a></li>-->
										</ul></li>
								</c:if>
								<li class="header_dropdown_menu"><a href="/qna/faq">&emsp;고객센터&emsp;</a>
									<ul class="header_dropdown">
										<li class="header_dropdown_menu" onclick="select_list('1')"><a
											href="#">Q&amp;A</a></li>
										<li class="header_dropdown_menu"><a href="/qna/faq">FAQ</a></li>
									</ul></li>
							</ul>
							<nav id="logo_menu">
								<ul>
									<c:if test="${empty loginInfo }">
										<li><a href="/login">&emsp;로그인&emsp;</a></li>
										<li>|</li>
										<li><a href="/join/terms">&emsp;회원가입&emsp;</a></li>
									</c:if>
									<c:if test="${!empty loginInfo}">
										<!-- 알람종 동기화가 됨-->
											<!-- <div style="cursor:pointer" onclick="window.location.href='http://www.naver.com/';"> -->
										<%-- <iframe class="alarm1"
													src="http://192.168.0.44:3750?id=${loginInfo.id}"
													width="80" height="30" frameborder="0" scrolling="no">메시지함</iframe> --%>
										<li><a href="/message/inbox">&emsp;<img width="30px"
												src="/images/email.png">&emsp;
										</a></li>
										<li><a href="/mypage/memberinfo">${loginInfo.name} 님</a>
										</li>



										<li>&emsp; |</li>
										<li>&emsp;<a href="/logout">로그아웃</a></li>
									</c:if>
								</ul>
							</nav>
						</div>
					</nav>
				</form>

			</div>

			<div class="clear"></div>
		</header>
	</div>
	<!-- 헤더 끝 -->