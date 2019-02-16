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
	
	<div class="giveWrite">
	<div class="giveWrite_container">
		<table class="giveWrite_table" width="50%">
		<tr>
			<th>기부 재능</th>
			<td>
				<select id="give_talent1">
					<option value="">선택</option>
					<option value="언어">언어</option>
					<option value="예술">예술</option>
					<option value="스포츠">스포츠</option>
					<option value="컴퓨터">컴퓨터</option>
					<option value="그 외">그 외</option>
				</select>
				<input type="text" id="give_talent2" size="10">
			</td>
			<th>희망 재능</th>
			<td>
				<select id="wish_talent1">
					<option value="">선택</option>
					<option value="언어">언어</option>
					<option value="예술">예술</option>
					<option value="스포츠">스포츠</option>
					<option value="컴퓨터">컴퓨터</option>
					<option value="그 외">그 외</option>
				</select>
				<input type="text" id="wish_talent2" size="10">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan=3><input type="text" id="subject"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan=3><textarea id="content" rows="10"></textarea></td>
		</tr>
		<tr>
			<th>위치</th>
			<td>
				<input type="text" id="location" size="10">
				<input type="button" id="location_search" value="찾기">
			</td>
			<th>마감일</th>
			<td>
				<input type="text" id="closingDate" size="10">
				<input type="button" id="closingDate_search" value="날짜 선택">
			</td>
		</tr>
		</table>
		<input type="button" id="giveReg_ok" value="등록">
		<input type="button" id="giveReg_cancel" value="취소">
	</div>
	</div>
	
	<div class="clear"></div>
</article>
<!-- 메인 끝 -->

<%@ include file="../footer.jsp" %>