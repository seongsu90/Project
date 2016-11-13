<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		
		이벤트 수정
		<hr/>
			<form method="post">
				메뉴이름 : <input type="text" name="ename"/><br/>	
				메뉴가격 : <input type="text" name="eResid"/><br/>
				메뉴 정보 : <input type="text" name="einfo"/><br/>
				메뉴 사진 : <input type="file" name="eMlname"/><br/>
				핫메뉴 선택 : <input type="checkbox" name="emlhot"/><br/>
					
				<input type="submit" value="수정"/>
			</form>
	</body>
</html>