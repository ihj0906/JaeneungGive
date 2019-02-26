<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link href="/css/member.css" rel="stylesheet" type="text/css" />

<section class="top_section"></section>

<article>
   <div id="member">
      <h1>로 그 인</h1>
      <br>
      <form method="post" id="loginForm">
      <table class="login_form">
      <tr>
      <td class="login_form_td">
         <c:if test="${!loginCommand.rememberId}">
            <input type="text" id="id" name="id" placeholder="아이디" onclick="lowerEngNumOnly()">
         </c:if>
         <c:if test="${loginCommand.rememberId}">
            <input type="text" id="id" name="id" value="${loginCommand.id}" onclick="lowerEngNumOnly()">
         </c:if>
      </td>
      <td rowspan='2' class="login_form_td">
         <input class="board_list_btn" style="width: 92px; height: 52px;" type=button id="loginBtn" onclick="login()" value="로그인">
      </td>
      </tr>
      <tr>
      <td class="login_form_td">
         <input type="password" id="password" name="password" placeholder="비밀번호" onclick="engNumOnly()">
      </td>
      </tr>
      <tr>
      <td class="login_form_td">
         <p class="checkResult">
            <span class="msg"></span></p>
      </td>
      </tr>
         </table>
         <c:if test="${!loginCommand.rememberId}">
            <br>
            <font size="2"> <input type="checkbox" name="rememberId" />
               아이디 저장
            </font>
         </c:if>
         <c:if test="${loginCommand.rememberId}">
            <br>
            <font size="2"> <input type="checkbox" name="rememberId"
               checked="checked" /> 아이디 저장
            </font>
         </c:if>

         <!-- <br> <font size="1"> <input type='checkbox' />아이디 저장 -->
         <font size="2">
            <hr width="18%"> <a href="findId">아이디찾기</a> <a
            href="findPassword">/비밀번호 찾기</a> <a href="/join/terms">/회원가입</a>
         </font>

      </form>
   </div>
      <%-- <td colspan="2"><font color="red">
            <p>로그인에 실패하였습니다. 다시 시도해 주십시오.</p>
      </font> <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION" /></td> --%>

</article>

<%@ include file="/footer.jsp"%>