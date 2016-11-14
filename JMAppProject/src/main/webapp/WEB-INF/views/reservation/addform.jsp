<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		
		
		&nbsp; <font size="6"><b>add</b></font></p>
		<hr/> <!-- 시작과 동시에 끝이다라는 의미<br/>// 태그의 의미는 수평선그리기 -->
		<form method="post">
		- 예약 시간 <input type="text"  name="cnumber"  value="${cnumber}" readonly/> <br/>
		- 인원 수<input type="text"  name="cname" value="쿠폰이름을 입력해주세요"/> <br/>
		- 예약 아이디<input type="date" name="cdday"> <br/>
		- 예약하는 식당<br/>
		<textarea name="cinfo" rows="10" cols="30">쿠폰정보를 입력해 주세요</textarea> <br/>
		- 쿠폰적용 음식점 <input type="text"  name="cresid"  value="${cresid}" readonly/> <br/>
		- 쿠폰 할인금액<input type="text"  name="cdiscount" value="10000"/> <br/>
		<input type="submit" value="쿠폰 등록"/> <br/>
		</form>
	</body>
</html>