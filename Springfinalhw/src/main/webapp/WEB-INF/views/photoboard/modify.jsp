<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		
		<p align="left"><a href="/myweb2/"><IMAGE SRC="/myweb2/resources/spring.jpg"></IMAGE></a>
		&nbsp; <font size="6"><b>글수정</b></font></p>
		<hr/> <!-- 시작과 동시에 끝이다라는 의미<br/>// 태그의 의미는 수평선그리기 -->
		<form method="post"  enctype="multipart/form-data">
		<input type="hidden" name="bno" value="${photoBoard.bno}"/>
		<table>
			<tr>
				<td style="background-color:#9966FF; width:70px">제목</td>
				<td><input type="text" name="btitle" style="width:600px;" value="${photoBoard.btitle}"></td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">내용</td>
				<td><input type="text" name="bcontent" style="width:600px;" value="${photoBoard.bcontent}"></td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">사진</td>
				<td><img src="show?savedfile=${photoBoard.savedfile}" width="500px"/></td>
			</tr>
			<tr>
				<td style="background-color:#9966FF; width:70px">사진 수정</td>
				<td><input type="file" name="photo"/></td>
			</tr>		
		</table>
		<input type="submit"  value="수정하기"/>
		<input type="button"  name="list"  value="목록" onclick="location.href='list' ">
		</form>
	</body>
</html>