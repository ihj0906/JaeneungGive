<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	function page(idx) {
		var pagenum = idx;
		var contentnum = $("#contentnum option:selected").val();
		location.href = "${pageContext.request.contextPath}/list?pagenum="
				+ pagenum + "&contentnum=" + contentnum;
	}
</script>
</head>
<body>
	<select name="contentnum" id="contentnum">
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
	</select>
	<table>
		<thead>
			<tr>
				<th>기부 재능</th>
				<th>모집 인원</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>위치</th>
				<th>마감일</th>
				<th></th>
			</tr>

		</thead>
		<tbody>
			<c:forEach var="donation" items="${list}">

				<tr>
					<td>${donation.talent1}&ensp;/&ensp;${donation.talent2}</td>
					<td>${donation.count}&ensp;/&ensp;${donation.people}</td>
					<td>${donation.id}</td>
					<td><a href="/give/donationDetail&${donation.no}">${donation.subject}</a></td>
					<td><a href="/give/donationDetail&${donation.no}">${donation.content}</a></td>
					<td>${donation.location}</td>
					<td>${donation.closing_date}&ensp;<span id=dday>D-6</span></td>
					<!-- 북마크 시작-->
					<td><c:choose>
							<c:when test="${empty loginInfo}">
								<input type="image" class="bookmarkImage" id="${donation.no}"
									src="/images/unbookmark.png"
									onclick="bookmark('1','${donation.no}')">
							</c:when>
							<c:when test="${donation.book_id == loginInfo.id}">
								<input type="image" class="bookmarkImage" id="${donation.no}"
									src="/images/bookmark.png"
									onclick="bookmark('1','${donation.no}')">
							</c:when>
							<c:otherwise>
								<input type="image" class="bookmarkImage" id="${donation.no}"
									src="/images/unbookmark.png"
									onclick="bookmark('1','${donation.no}')">
							</c:otherwise>
						</c:choose></td>
					<!-- 북마크 종료 -->
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<!-- 왼쪽 화살표 --> <c:if test="${page.prev}">
						<a style="text-decoration: none;"
							href="javascript:page(${page.getStartPage()-1});">&laquo;</a>
					</c:if> <!-- 페이지 숫자 표시 --> <c:forEach begin="${page.getStartPage()}"
						end="${page.getEndPage()}" var="idx">
						<a style="text-decoration: none;" href="javascript:page(${idx});">${idx}</a>
					</c:forEach> <!-- 오른쪽 화살표 --> <c:if test="${page.next}">
						<a style="text-decoration: none;"
							href="javascript:page(${page.getEndPage()+1});">&raquo;</a>
					</c:if>

				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>


