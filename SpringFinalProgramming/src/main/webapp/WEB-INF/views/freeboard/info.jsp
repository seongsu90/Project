<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		
		<p align="left"><a href="/myweb/"><IMAGE SRC="/myweb/resources/spring.jpg"></IMAGE></a>
		&nbsp; <font size="6"><b>글내용</b></font></p>
		<hr/> <!-- 시작과 동시에 끝이다라는 의미<br/>// 태그의 의미는 수평선그리기 -->
		
		<table>
			 <tr>
				<td style="background-color:#9966FF; width:70px">번호</td>
				<td>${freeboard.bno}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">제목</td>
				<td>${freeboard.btitle}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">내용</td>
				<td><pre>${freeboard.bcontent}</pre></td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">글쓴이</td>
				<td>${freeboard.bwriter}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">조회수</td>
				<td>${freeboard.bhitcount}</td>
			</tr>			
			<tr>
				<td style="background-color:#9966FF; width:70px">날짜</td>
				<td>${freeboard.bdate}</td>
			</tr>
		</table>
		
		<%--컨테이너 역할을 한다. --%>
		<div>
			<c:if test="${login == freeboard.bwriter}">
			<a href="modify?bno=${freeboard.bno}">[수정]</a>
			<a href="remove?bno=${freeboard.bno}">[삭제]</a>
			</c:if>
			<a href="list">[목록]</a>
		</div>
	</body>
</html>