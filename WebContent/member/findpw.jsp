<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="/css/member.css" rel="stylesheet" type="text/css" />

<section class="top_section"></section>

<article>

	<div id="member">
		<h1>비밀번호 찾기</h1>
		<br> 
		<table class="login_form">
		<tr><td class="login_form_td">
		<input type="text" id="name" placeholder="이름"></td>
		<td rowspan="3" class="login_form_td">
		<input class="board_list_btn" style="width: 92px; height: 79px;" type="button" name="checkidbtn" class="find_pwd_Btn" onclick="findPw()" value="찾기"></td>
		</tr>
		<tr><td class="login_form_td">
		<input type="text" id="email" placeholder="이메일"></td></tr>
		<tr><td class="login_form_td">
		<input type="text" id="id" placeholder="아이디"></td></tr>
		<tr><td class="login_form_td"> 
		<font size="1"></font>
		<p class="findResult">
		<span class="msg"></span>
		</p></td></tr>
		</table>
	</div>

</article>

<%@ include file="../footer.jsp"%>