<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		
		&nbsp; <font size="6"><b>coupon list</b></font></p>
		<hr/> <!-- 시작과 동시에 끝이다라는 의미<br/>// 태그의 의미는 수평선그리기 -->
			<table style="width:570px">
			<tr>
				<td style="background-color:#9966FF; width:70px">쿠폰소유자</td>
				<td style="background-color:#9966FF; width:70px">쿠폰번호</td>
			</tr>
			<c:forEach var="couponbox" items="${couponlist}">
			<tr>
				<td>${couponbox.cbmid}</td>
				<td>${couponbox.cbnumber}</td>
			</tr>
			</c:forEach>
			
			</table>
	</body>
</html>