<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
	
		메뉴리스트 생성
		<hr/>
			<form method="post" >
				메뉴이름 : <input type="text" name="mlname"/><br/>	
				메뉴가격 : <input type="text" name="mlprice"/><br/>
				식당명 : <input type="text" name="mlresid"/><br/>
				메뉴 정보 : <input type="text" name="mlinfo"/><br/>
				메뉴 사진 : <input type="file" name="mlsavedfile"/><br/>
				핫메뉴 선택 : <input type="radio" name="mlishot"/>핫메뉴 등록
						   <input type="radio" name="mlishot"/>일반메뉴 등록<br/>
				<input type="submit" value="생성"/>
			</form>
	</body>
</html>