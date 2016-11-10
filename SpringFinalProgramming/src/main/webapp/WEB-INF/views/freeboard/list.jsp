<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
		<style type="text/css">
			a {
				text-decoration: none,
				color:black,
				
			}
			a:HOVER {
					color:green
			}	
		</style>
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		
		<p align="left"><a href="/myweb/"><IMAGE SRC="/myweb/resources/spring.jpg"></IMAGE></a>
		&nbsp; <font size="6"><b>자유 게시판</b></font></p>
		<hr/> <!-- 시작과 동시에 끝이다라는 의미<br/>// 태그의 의미는 수평선그리기 -->
		
		<c:if test="${login != null}">
			<a href="write">[글쓰기]</a>
			</c:if>
		
		
		<table style="border-collapse: collapse; border: 1px solid black;width: 600px">
			<tr style="background-color:#FFADEF">
				<td style="border: 1px solid black;">번호</td> 
				<td style="border: 1px solid black;">제목</td> 
				<td style="border: 1px solid black;">글쓴이</td>
				<td style="border: 1px solid black;">조회수</td>
				<td style="border: 1px solid black;">날짜</td>
			</tr>
						
			<c:forEach var="freeboard" items='${list}'> 
				<tr>
					<td style="border: 1px solid black;">${freeboard.bno}</td> 
					<td style="border: 1px solid black;">
					<a href="info?bno=${freeboard.bno}">${freeboard.btitle}</a>					
					</td>
					<td style="border: 1px solid black;">${freeboard.bwriter}</td>
					<td style="border: 1px solid black;">${freeboard.bhitcount}</td>
					<td style="border: 1px solid black;">${freeboard.bdate}</td>
				</tr>
			</c:forEach>
		</table> 
		
		<div style="width: 600px">
			<a href="list?pageNo=1">[처음]</a>
			<c:if test="${groupNo>1}">
				<a href="list?pageNo=${startPageNo-1}">[이전]</a>
			</c:if>
				
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
			&nbsp;
				<a href="list?pageNo=${i}" 
				<c:if test="${pageNo==i}">style="color:red"</c:if>
				>${i}</a>
				&nbsp;
			</c:forEach>
			
				<c:if test="${groupNo<totalGroupNo}">
				<a href="list?pageNo=${endPageNo+1}">[다음]</a>
				</c:if>
			<a href="list?pageNo=${totalPageNo}">[맨끝]</a>
		</div>
	
		
	</body>
</html>