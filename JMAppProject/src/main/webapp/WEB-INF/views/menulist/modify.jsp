<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		
		메뉴리스트 수정
		<hr/>
			<form method="post">
			    
				메뉴가격 : <input type="number" name="mlprice" value="${menuList.mlprice}"/><br/>
				메뉴 정보 : <input type="text" name="mlinfo" value="${menuList.mlinfo}"/><br/>
				메뉴 사진 : <input type="file" name="mlsavedfile" value="${menuList.mlsavedfile}"/><br/>
				핫메뉴 선택 : <input type="radio" name="mlishot" value="true"/>핫<br/>
							<input type="radio" name="mlishot" value="false">일반<br/>
			
				<input type="submit" value="수정"/>
			</form>
	</body>
</html>