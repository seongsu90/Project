<%@ page  contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head> 
	<body>
	
		메뉴리스트 생성
		<hr/>
			<form method="post" enctype="multipart/form-data">
				메뉴이름 : <input type="text" name="mlname"/><br/>	
				메뉴가격 : <input type="number" name="mlprice"/><br/>
				식당명 : <input type="text" name="mlresid"/><br/>
				메뉴 정보 : <input type="text" name="mlinfo"/><br/>
				이벤트 메뉴 이름 : <input type="file" name="mlsavedfile"/><br/>
				이벤트 할인가격 : <input type="number" name="eprice"/><br/>
				이벤트 시작기간 : <input type="date" name="estart"/><br/>
				
					
				<input type="submit" value="생성"/>
			</form>
	</body>
</html>