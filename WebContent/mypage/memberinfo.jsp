
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="mypagesidemenu.jsp"%>

<div id="pagetitle">
	<h1>
		<span>회 원 정 보</span>
	</h1>
</div>

<div id=member>
	<form id="signUpForm" action="modify" method="post">
		<table id=join_table style="padding-left: 350px;">

			<tr>
				<td style="width: 110px;">아이디</td>
				<td style="width: 100px"><input type="text"
					value="${member.id}" disabled><input type="hidden"
					name="id" id="id" value="${member.id}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" id="password" /></td>
				<td><span class="msg" id="msgPassword">(영문 대소문자/숫자, 15자)</span></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="confirmPassword"
					id="confirmPassword" /></td>
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
					value="${member.phone}" /></td>
				<td><span class="msg" id="msgPhone"></span></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" id="email"
					value="${member.email}" /></td>
				<td><span class="msg" id="msgEmail"></span></td>
			</tr>
		</table>
		<p class="checkResult">
				<span class="msg"></span>
			</p>
		<!-- <input type="button" value="취소" onclick="go_mypage()"/>  -->
		<input type="button" value="탈퇴" onclick="deleteUser()" /> <input
			type="button" value="수정" onclick="modify()" />
	</form>
</div>

</article>

<%@ include file="../footer.jsp"%>