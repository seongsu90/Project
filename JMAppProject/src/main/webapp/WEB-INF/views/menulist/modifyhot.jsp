<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		
		핫메뉴 수정
		<hr/>
			<form method="post">
				메뉴가격 : <input type="number" name="mlprice" value="${menuList.mlprice}"/><br/>
				메뉴 정보 : <input type="text" name="mlinfo" value="${menuList.mlinfo}"/><br/>
				메뉴 사진 : <input type="file" name="mlsavedfile" value="${menuList.mlsavedfile}"/><br/>
				핫메뉴 선택 : <input type="radio" name="mlishot" value="true"/>핫메뉴 유지
						    <input type="radio" name="mlishot" value="true"/>일반메뉴로 췐지
				<br/>
			
				<input type="submit" value="수정"/>
			</form>
	</body>
</html>