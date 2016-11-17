<%@ page  contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head> 
	<body>
	
		이벤트 생성
		<hr/>
			<form method="post">
				이름 : <input type="text" name=ename value="${event.ename}"/><br/>	
				식당명 : <input type="number" name=eresid  value="${event.eresid}"/><br/>
				이벤트 사진 : <input type="file" name=esavedfile value="${event.esavedfile}"/><br/>
				이벤트 정보 : <input type="text" name=einfo value="${event.einfo}"/><br/>
				이벤트 메뉴 이름 : <input type="text" name=emlname value="${event.emlname}"/><br/>
				이벤트 할인가격 : <input type="number" name=eprice value="${event.eprice}"/><br/>
				이벤트 시작기간 : <input type="date" name=estart value="${event.estart}"/><br/>
				이벤트 종료기간 : <input type="date" name=eend value="${event.eend}"/><br/>
				
				<input type="submit" value="생성"/>
			</form>
	</body>
</html>