<%@ page  contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head> 
	<body>
	
		이벤트 생성
		<hr/>
			<form method="post" enctype="multipart/form-data">
				이름 : <input type="text" name="ename"/><br/>	
				식당명 : <input type="number" name="eresid"/><br/>
				이벤트 사진 : <input type="file" name="esavedfile"/><br/>
				이벤트 정보 : <input type="text" name="einfo"/><br/>
				이벤트 메뉴 이름 : <input type="text" name="emlname"/><br/>
				이벤트 할인가격 : <input type="number" name="eprice"/><br/>
				이벤트 시작기간 : <input type="date" name="estart"/><br/>
				이벤트 종료기간 : <input type="date" name="eend"/><br/>
				
					
				<input type="submit" value="생성"/>
			</form>
	</body>
</html>