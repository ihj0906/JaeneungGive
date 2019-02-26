<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jaeneung Give Admin</title>
<link href="/css/admin.css" rel="stylesheet" type="text/css" />
<!-- 폰트 css 관련 -->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<!-- 버튼 css 관련 -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type='text/css'>
<link href='https://fonts.googleapis.com/css?family=PT+Sans:700' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="/js/admin.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<header>
		<div class="header_logo">
			<a class="brand">Admin</a> <a class="login" href="/adminlogout">로그아웃</a>
		</div>
		<nav class="header_nav">
			<ul>
				<li class="header_menu"><a href="/admin/board">게시물관리</a></li>|
				<li class="header_menu"><a href="/admin/member">회원관리</a></li>|
				<li class="header_menu"><a href="/admin/qna">Q&amp;A 관리</a></li>|
				<li class="header_menu"><a href="/admin/faq">FAQ 관리</a></li>
			</ul>
		</nav>
		<hr>
	</header>