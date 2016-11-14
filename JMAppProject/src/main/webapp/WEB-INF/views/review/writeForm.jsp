<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>		
	<head>	
		<meta charset="UTF-8">
	</head>
	
	<body>
		리뷰 작성
		<hr/>
		
		<form method="post">
			<table>
				<tr>
					<td style="background-color:orange; width:70px"> 레스토랑 </td>
				 	<td><input type="text" name="btitle" style="width:600px" value="${review.revresid}"></td>
				</tr>
				
				<tr>
					<td style="background-color:orange; width:70px"> 내용 </td>
				 	<td><textarea name="bcontent" style="width:600px; height:200px;">${review.revcontent}</textarea></td>
				</tr>
			</table>
			<input type="submit" value="글쓰기"/>
		</form>
		
	</body>
</html>
