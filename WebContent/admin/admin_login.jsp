<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/admin.css" rel="stylesheet" type="text/css" />
<!-- 폰트 css 관련 -->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<!-- 버튼 css 관련 -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type='text/css'>
<link href='https://fonts.googleapis.com/css?family=PT+Sans:700' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="/js/admin.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<title>Jaeneung Give Admin</title>
</head>
<body>

	<article>
		<div id="member">
			<h1>업무 로그인</h1>
			<br>
			<form method="post" id="form" name="form">
				<table class="login_form">
				<tbody class="login_form_tbody">
					<tr>
						<td class="login_form_td"><input name="id" id="id"
							type="text" placeholder="아이디"></td>
						<td rowspan='2' class="login_form_td"><input
							class="admin_login_btn" type="button" id="loginBtn"
							onclick="adminLogin()" value="업무 로그인"></td>
					</tr>
					<tr>

						<td class="login_form_td"><input type="password"
							id="password" name="password" placeholder="비밀번호"></td>
					</tr>
				</tbody>
				</table>
			</form>
		</div>
	</article>

<%@ include file="/admin/admin_footer.jsp"%>