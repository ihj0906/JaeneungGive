<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/js/member.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<h1>ID 중복확인</h1>
		<form name=formm method="post" style="margin-right: 0">
			User ID <input type=text name="id" size="15" id="id" value="${id}"> <input
				type=button value="검색" class="submit" onclick="checkId()"><br>
			<div style="margin-top: 20px">
				<c:if test="${idCheckResult}">
					<script type="text/javascript">
						opener.document.formm.id.value = "";
					</script>
				${id}는 이미 사용중인 아이디입니다.
			</c:if>
				<c:if test="${!idCheckResult}">
				${id}는 사용 가능한 아이디입니다.
				<input type="button" value="사용" class="cancel" onclick="useId()">
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>