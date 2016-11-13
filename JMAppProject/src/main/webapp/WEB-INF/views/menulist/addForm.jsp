<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
	
		메뉴리스트 생성
		<hr/>
			<form method="post">
				메뉴이름 : <input type="text" name="ename"/><br/>	
				메뉴가격 : <input type="text" name="eResid"/><br/>
				식당명 : <input type="file" name="savedfile"/><br/>
				메뉴 정보 : <input type="text" name="einfo"/><br/>
				메뉴 사진 : <input type="file" name="eMlname"/><br/>
				핫메뉴 선택 : <input type="checkbox" name="emlhot"/><br/>
					
				<input type="submit" value="생성"/>
			</form>
	</body>
</html>