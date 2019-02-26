<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%-- <%@ include file="mypagesidemenu.jsp"%> --%>

<link href="/css/member.css" rel="stylesheet" type="text/css" />

<div class="mypage_img_div">
<img class="mypage_img" src="/images/mypage.jpg" /></div>

<div class="mygiveList">
	<div id="pagetitle">
		<h1 class="mypagetitle">회 원 정 보</h1>
	</div>

	<div id="member">
		<form id="signUpForm" action="modify" method="post">
			<table id="join_table">

				<tr>
					<td style="width: 110px;">아이디</td>
					<td style="width: 100px"><input type="text"
						value="${member.id}" disabled><input type="hidden"
						name="id" id="id" value="${member.id}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" id="password" onclick="engNumOnly()" /></td>
					<td><span class="msg" id="msgPassword">(영문 대소문자/숫자,
							15자)</span></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="confirmPassword"
						id="confirmPassword" onclick="engNumOnly()"/></td>
					<td><span class="msg" id="msgConfirmPassword"></span></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" disabled name="name"
						value="${member.name}" /></td>
				</tr>
				<tr>
					<td>휴대전화</td>
					<td><input type="text" name="phone" id="phone"
						value="${member.phone}" onclick="numOnly()"/></td>
					<td><span class="msg" id="msgPhone" style="margin-left: 20px;">(하이픈('-')을 제외하고 입력 해 주세요.)</span></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" id="email"
						value="${member.email}" onclick="forMail()"/></td>
					<td><span class="msg" id="msgEmail"></span></td>
				</tr>
				<tr>
					<td class="mypage_memberinfo_btn" colspan="2">
					<input class="board_list_btn" type="button" value="수정" onclick="modify()" /> 
					<input class="boardDetail_delete_btn" type="button" value="탈퇴" onclick="deleteUser()" /></td>
				</tr>
			</table>
			<p class="checkResult">
				<span class="msg"></span>
			</p>
			<!-- <input type="button" value="취소" onclick="go_mypage()"/>  -->
		</form>
	</div>
</div>
<section class="top_section">
</section>

<%@ include file="../footer.jsp"%>
