<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		
		<p align="left"><a href="/myweb/"><IMAGE SRC="/myweb/resources/spring.jpg"></IMAGE></a>
		&nbsp; <font size="6"><b>회원 가입</b></font></p>
		<hr/> <!-- 시작과 동시에 끝이다라는 의미<br/>// 태그의 의미는 수평선그리기 -->
		<form method="post">
			아이디: <input type="text" name="mid" value="${member.mid}"/>
			<a href="checkMid">중복체크</a>
			 <br/>
			 이름: <input type="text" name="mname" value="${member.mname}"/>
			 <br/>
			패스워드: <input type="password" name="mpassword"/>
			<br/>
			휴대전화: <input type="tel" name="mtel" value="${member.mtel}"/>
			<br/>
			이메일: <input type="email" name="memail" value="${member.memail}"/>
			<br/>
			주소: <input type="text" name="maddress" value="${member.maddress}"/>
			<br/>
			<input type="submit" value="가입"/> 
		</form>
				
	</body>
</html>