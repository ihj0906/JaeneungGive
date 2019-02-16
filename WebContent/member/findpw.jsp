<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>

<div id=member>
	<big><b><div><span>비밀번호 찾기</span></div></b></big> <br>
		
		
			이름 <input type="text" id="name" placeholder="이름"> <br>
			이메일 <input type="text" id="email" placeholder="이메일"> <br> 
		아이디 <input type="text" id="id" placeholder="아이디"> <br> 
		<input
			type="button" name="checkidbtn" class="findBtn" onclick="findPw()"
			style="height: 25px; width: 173px" value="찾기"> <br> <font size="1"></font>
			 <p class="findResult"><span
				class="msg"></span>
		</p>
	</div>	
	
</article>

<%@ include file="../footer.jsp" %>