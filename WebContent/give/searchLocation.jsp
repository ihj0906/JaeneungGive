<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="/css/give.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/give.js"></script>

<!-- 주소 검색 팝업 창 시작 -->
<form id="popup_frm" name="popup_frm" method="post">
	<div id="lo_popup">
		<table class="popup_table">
			<tr>
				<td style="padding-left: 80px">
				<input type="text" size="20" id="lo" name="lo" placeholder="검색어를 입력해주세요">&ensp; 
				<input type="submit" class="board_list_btn" value="검색" onclick="search_location()"><br>
					(시 또는 구 명칭으로 검색해 주세요.)</td>
			</tr>
			<tr>
				<td><select id="lo_list" name="lo_list" size='7'>
						<c:forEach var="location" items="${locationList}">
							<option value="location">${location.lo1}&ensp;${location.lo2}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td style="padding-left: 120px"><input class="board_list_btn" type="button" value="확인"
					onclick="location_submit()">&emsp; <input type="button"
					value="닫기" class="boardDetail_delete_btn" onclick="window.close()"></td>
			</tr>
		</table>
	</div>
</form>
<!-- 주소 검색 팝업 창 끝 -->


