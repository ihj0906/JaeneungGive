<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<link href="/css/give.css" rel="stylesheet" type="text/css" />

<!-- 메인 시작 -->
<article>

	<div class="search">
		<div class="search_container">
			<input type="text" placeholder="검색어를 입력해주세요"  />
			<input type="button" value="검색" />
		</div>
	</div>
	
	<div class="giveMenu">
		<ul>
		<a href="#"><li>언어</li></a>
		<a href="#"><li>예술</li></a>
		<a href="#"><li>스포츠</li></a>
		<a href="#"><li>컴퓨터</li></a>
		<a href="#"><li>그 외</li></a>
		</ul>
	</div>
	
	<div class="giveDetail">
	<div class="giveDetail_container">
		<table class="giveDetail_table" width="50%">
		<tr>
			<th>기부 재능</th><td>언어/한국어</td>
			<th>희망 재능</th><td>언어/영어</td>
		</tr>
		<tr>
			<th>작성자</th><td colspan=3><a href="#">외국타조</a></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan=3>영어를 잘하고싶어요.</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan=3>영어도 배우고 친구도 만들고 싶어요~~</textarea></td>
		</tr>
		<tr>
			<th>위치</th>	<td>노원구</td>
			<th>마감일</th><td>2019.01.00&ensp;<span id=dday>D-6</span></td>
		</tr>
		<tr>
			<th>스크랩</th><td colspan=3><input type="checkbox" id="clip"></td>
		</tr>
		</table>
		<input type="button" id="request" value="신청하기">
	</div>
	</div>
	
	<div class="clear"></div>
</article>
<!-- 메인 끝 -->

<%@ include file="../footer.jsp" %>