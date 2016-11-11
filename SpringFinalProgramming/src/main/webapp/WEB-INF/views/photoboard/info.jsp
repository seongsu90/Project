<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		
		<p align="left"><a href="/myweb/"><IMAGE SRC="/myweb/resources/spring.jpg"></IMAGE></a>
		&nbsp; <font size="6"><b>글쓰기</b></font></p>
		<hr/> <!-- 시작과 동시에 끝이다라는 의미<br/>// 태그의 의미는 수평선그리기 -->
		
		<table style="width:570px">
			<tr>
				<td style="background-color:#9966FF; width:70px">번호</td>
				<td>${photoBoard.bno}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">제목</td>
				<td>${photoBoard.btitle}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">내용</td>
				<td><pre>${photoBoard.bcontent}</pre></td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">글쓴이</td>
				<td>${photoBoard.bwriter}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">조회수</td>
				<td>${photoBoard.bhitcount}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">날짜</td>
				<td>${photoBoard.bdate}</td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">사진</td>
				<td><img src="show?savedfile=${photoBoard.savedfile}" width="500px"/></td>
			</tr>				
		</table>
				
	</body>
</html>