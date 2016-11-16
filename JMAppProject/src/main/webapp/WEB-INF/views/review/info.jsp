<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		글내용
		<hr/>		
		<table>
			<tr>
				<td style="background-color:orange; width:70px"> 리뷰 번호 </td>
			 	<td>${review.revno}</td>
			</tr>
		
			<tr>
				<td style="background-color:orange; width:70px"> 레스토랑 </td>
			 	<td>${review.revresid}</td>
			</tr>
			
			<tr>
				<td style="background-color:orange; width:70px"> 내용 </td>
			 	<td><pre>${review.revcontent}</pre></td>
			</tr>
			
			<tr>
				<td style="background-color:orange; width:70px"> 글쓴이 </td>
			 	<td>${review.revmid}</td>
			</tr>
			
			<tr>
				<td style="background-color:orange; width:70px"> 평점 </td>
			 	<td>${review.revscore}</td>
			</tr>
			
			<tr>
				<td style="background-color:orange; width:70px"> 날짜 </td>
			 	<td>${review.revdate}</td>
			</tr>
		</table>		
		<div>
			<c:if test="${login == review.revmid}" >
				<a href="delete?revno=${review.revno}">[삭제]</a>				
			</c:if>
			<a href="list">[목록]</a>
		</div>
	</body>
</html>
