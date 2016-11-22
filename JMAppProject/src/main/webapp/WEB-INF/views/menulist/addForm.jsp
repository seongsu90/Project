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
				메뉴이름 : <input type="text" name="mlname" value="${menuList.mlname}"/><br/>	
				메뉴가격 : <input type="number" name="mlprice" value="${menuList.mlprice}"/><br/>
				식당명 : <input type="text" name="mlresid" value="${menuList.mlresid}"/><br/>
				메뉴 정보 : <input type="text" name="mlinfo" value="${menuList.mlinfo}"/><br/>
			     메뉴 사진 : <input type="file" name="mlphoto" value="${menuList.mlsavedfile}"/><br/>
				핫메뉴 선택 : <input type="radio" name="mlishot" value="true"/>핫해하태?
						   <input type="radio" name="mlishot" value="false"/>일반메뉴<br/>
				 	
				<input type="submit" value="생성"/>
			</form>
	</body>
</html>