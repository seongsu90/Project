<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		리뷰 작성
		<hr/>
		
		<table style="border-collapse: collapse; border: 1px solid black; width: 600px; "> 				
			<tr style="background-color: #ffcc00">				
				<td style="border: 1px solid black;">리뷰 번호</td> 
				<td style="border: 1px solid black;">레스토랑</td> 
				<td style="border: 1px solid black;">작성자</td>
				<td style="border: 1px solid black;">내용</td>
				<td style="border: 1px solid black;">평점</td>			
				<td style="border: 1px solid black;">날짜</td>			
			</tr>
			
			<c:forEach var="review" items="${list}"> 		
				<tr>															
					<td style="border: 1px solid black;">
						<a href="info?revno=${review.revno}">${review.revno}</a>
					</td>		
					<td style="border: 1px solid black;">${review.revresid}</td> 
					<td style="border: 1px solid black;">${review.revmid}</td>
					<td style="border: 1px solid black;">${review.revcontent}</td>
					<td style="border: 1px solid black;">${review.revscore}</td>
					<td style="border: 1px solid black;">${review.revdate}</td>
				</tr>
			</c:forEach>
		</table>
		
		
	</body>
</html>
