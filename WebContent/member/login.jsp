<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="/css/member.css" rel="stylesheet" type="text/css" />


<article>

	<div id=member>
		<big><b><div>로 그 인</div></b></big> <br>
		<form method="post" id="loginForm">
			<c:if test="${!loginCommand.rememberId}">
				<input type="text" id="id" name="id" placeholder="아이디">
				<br>
			</c:if>
			<c:if test="${loginCommand.rememberId}">
				<input type="text" id="id" name="id" value="${loginCommand.id}">
				<br>
			</c:if>

			<input type="password" id="password" name="password"
				placeholder="비밀번호"> <br>
			<input type=button style="height: 25px; width: 173px" id="loginBtn" onclick="login()" value="로그인">
			<p class="checkResult">
				<span class="msg"></span>
			</p>
			<c:if test="${!loginCommand.rememberId}">
				<br>
				<font size="1"> <input type="checkbox" name="rememberId" />
					아이디 저장
				</font>
			</c:if>
			<c:if test="${loginCommand.rememberId}">
				<br>
				<font size="1"> <input type="checkbox" name="rememberId"
					checked="checked" /> 아이디 저장
				</font>
			</c:if>

			<!-- <br> <font size="1"> <input type='checkbox' />아이디 저장 -->
			<font size="1">
				<hr width="9%"> <a href="findId">아이디찾기</a> <a
				href="findPassword">/비밀번호 찾기</a> <a href="/join/terms">/회원가입</a>
			</font>

		</form>
	</div>
		<%-- <td colspan="2"><font color="red">
				<p>로그인에 실패하였습니다. 다시 시도해 주십시오.</p>
		</font> <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION" /></td> --%>

</article>

<%@ include file="../footer.jsp"%>